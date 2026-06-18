package com.groupdocs.ui.signature.manual;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.licensing.License;
import com.groupdocs.signature.options.PageSignatureStreamFactory;
import com.groupdocs.signature.options.PreviewSignatureOptions;
import com.groupdocs.signature.options.preview.PreviewFormats;
import com.groupdocs.signature.options.sign.ImageSignOptions;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.ui.signature.XMLReaderWriter;
import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Local comparison of two ways to place a QR code on a document (without Docker UI).
 *
 * <p>Data from real demo API responses:</p>
 * <ul>
 *   <li>POST /signature/sign — guid, left, top, imageWidth, imageHeight, signatureGuid</li>
 *   <li>POST /signature/loadSignatureImage — PNG preview</li>
 *   <li>XML next to PNG — QR text</li>
 * </ul>
 *
 * <p><b>Why QrCodeSignOptions may fail on document sign?</b></p>
 * <ul>
 *   <li><b>saveOpticalCode</b> — QrCodeSignOptions + {@code generateSignaturePreview()} → PNG (works)</li>
 *   <li><b>document sign</b> — QrCodeSignOptions + {@code signature.sign()} → library regenerates
 *       bitmap (QrCodeSignature → Image.load). In headless/Docker 26.5 often
 *       {@code The image size can not be 0!}</li>
 *   <li><b>ImageSignOptions</b> — inserts ready PNG from preview (like loadSignatureImage)</li>
 * </ul>
 *
 * <p><b>Run from Demos/Spring</b> (PowerShell):</p>
 * <pre>
 * $env:JAVA_TOOL_OPTIONS="-Djdk.jar.maxSignatureFileSize=32000000"
 * mvn test-compile exec:java `
 *   "-Dexec.mainClass=com.groupdocs.ui.signature.manual.OpticalCodeSignComparison" `
 *   "-Dexec.classpathScope=test" `
 *   "-Ddemo.base=."
 *
 * # if PNG is missing — generates from XML via Preview API (like saveOpticalCode):
 * # "-Ddemo.generatePreview=true"
 *
 * # custom files (copy from container or UI):
 * # "-Ddemo.document=DocumentSamples/image2.xls"
 * # "-Ddemo.qrPng=DocumentSamples/SignatureData/ArCodes/Preview/003.png"
 * # simulate Docker (headless):
 * # "-Ddemo.headless=true"
 * </pre>
 */
public class OpticalCodeSignComparison {

    static {
        if (Boolean.parseBoolean(System.getProperty("demo.headless", "false"))) {
            System.setProperty("java.awt.headless", "true");
        }
    }

    private static final Path DEMO_BASE = Paths.get(System.getProperty("demo.base", ".")).toAbsolutePath().normalize();

    private static final String DOCUMENT_REL = System.getProperty("demo.document",
            "DocumentSamples" + File.separator + "image2.xls");

    private static final String QR_PNG_REL = System.getProperty("demo.qrPng",
            "DocumentSamples" + File.separator + "SignatureData" + File.separator + "ArCodes"
                    + File.separator + "Preview" + File.separator + "003.png");

    private static final String QR_XML_REL = System.getProperty("demo.qrXml",
            "DocumentSamples" + File.separator + "SignatureData" + File.separator + "ArCodes"
                    + File.separator + "XML" + File.separator + "003.xml");

    private static final String LICENSE_REL = System.getProperty("demo.license",
            "Licenses" + File.separator + "GroupDocs.Signature.Java.lic");

    /** POST /signature/sign → signaturesData[0] */
    private static final int PAGE_NUMBER = intProperty("demo.page", 1);
    private static final int LEFT = intProperty("demo.left", 587);
    private static final int TOP = intProperty("demo.top", 565);
    private static final int IMAGE_WIDTH = intProperty("demo.imageWidth", 187);
    private static final int IMAGE_HEIGHT = intProperty("demo.imageHeight", 187);

    private static final boolean GENERATE_PREVIEW = Boolean.parseBoolean(
            System.getProperty("demo.generatePreview", "true"));

    private static final Path OUTPUT_DIR = DEMO_BASE.resolve("DocumentSamples").resolve("Output");

    public static void main(String[] args) throws Exception {
        applyLicense();

        Path document = resolveRequired(DOCUMENT_REL, "Document to sign (copy image2.xls to DocumentSamples)");
        Path qrXml = resolveRequired(QR_XML_REL, "QR text XML");
        String qrText = loadQrText(qrXml);

        Path qrPng = DEMO_BASE.resolve(QR_PNG_REL).normalize();
        if (!Files.isRegularFile(qrPng)) {
            if (GENERATE_PREVIEW) {
                Files.createDirectories(qrPng.getParent());
                byte[] previewBytes = generateQrPreviewBytes(qrText);
                Files.write(qrPng, previewBytes);
                System.out.println("Generated PNG preview (saveOpticalCode path): " + qrPng
                        + " (" + previewBytes.length + " bytes)");
            } else {
                throw new IllegalStateException("PNG preview not found: " + qrPng
                        + "\nSet -Ddemo.qrPng=... or -Ddemo.generatePreview=true");
            }
        }

        Files.createDirectories(OUTPUT_DIR);

        System.out.println("=== OpticalCodeSignComparison ===");
        System.out.println("demo.base     : " + DEMO_BASE);
        System.out.println("document      : " + document);
        System.out.println("qr preview png: " + qrPng + " (" + Files.size(qrPng) + " bytes)");
        System.out.println("qr xml        : " + qrXml);
        System.out.println("qr text       : " + qrText);
        System.out.println("placement     : page=" + PAGE_NUMBER + " left=" + LEFT + " top=" + TOP
                + " size=" + IMAGE_WIDTH + "x" + IMAGE_HEIGHT);
        System.out.println("headless      : " + System.getProperty("java.awt.headless", "false"));
        System.out.println();

        runApproach("0) Preview API: QrCodeSignOptions → PNG (like POST /signature/saveOpticalCode)",
                () -> {
                    byte[] bytes = generateQrPreviewBytes(qrText);
                    if (bytes.length == 0) {
                        throw new IllegalStateException("Preview PNG is empty");
                    }
                    System.out.println("Preview size: " + bytes.length + " bytes");
                });

        Path outQrCodeOptions = OUTPUT_DIR.resolve(stripExtension(document.getFileName().toString()) + "-qrcode-options.xls");
        Path outImageOptions = OUTPUT_DIR.resolve(stripExtension(document.getFileName().toString()) + "-image-options.xls");

        runApproach("1) QrCodeSignOptions + signature.sign() (legacy signOptical / .NET demo)",
                () -> signWithQrCodeSignOptions(document, qrText, outQrCodeOptions));

        runApproach("2) ImageSignOptions + PNG preview (new signOptical)",
                () -> signWithImageSignOptions(document, qrPng, outImageOptions));

        System.out.println("Output files (if approach did not fail):");
        System.out.println("  " + outQrCodeOptions);
        System.out.println("  " + outImageOptions);
    }

    /** Same path as SaveSignatureServiceImpl.generateSignaturePreviewBytes */
    static byte[] generateQrPreviewBytes(String qrText) throws Exception {
        QrCodeSignOptions signOptions = buildQrCodeSignOptions(qrText);
        final byte[][] out = {new byte[0]};
        PreviewSignatureOptions previewOptions = new PreviewSignatureOptions(signOptions, new PageSignatureStreamFactory() {
            @Override
            public OutputStream createSignatureStream(PreviewSignatureOptions previewOptions) {
                return new ByteArrayOutputStream();
            }

            @Override
            public void closeSignatureStream(PreviewSignatureOptions previewOptions, OutputStream pageStream) {
                out[0] = ((ByteArrayOutputStream) pageStream).toByteArray();
            }
        });
        previewOptions.setPreviewFormat(PreviewFormats.PNG);
        Signature.generateSignaturePreview(previewOptions);
        return out[0];
    }

    static QrCodeSignOptions buildQrCodeSignOptions(String qrText) {
        QrCodeSignOptions options = new QrCodeSignOptions(qrText);
        options.setEncodeType(QrCodeTypes.QR);
        options.setPageNumber(PAGE_NUMBER);
        options.setLeft(LEFT);
        options.setTop(TOP);
        options.setWidth(IMAGE_WIDTH);
        options.setHeight(IMAGE_HEIGHT);
        return options;
    }

    /** Legacy approach: text from XML + QrCodeSignOptions (bitmap generated at sign time). */
    static void signWithQrCodeSignOptions(Path document, String qrText, Path output) throws Exception {
        QrCodeSignOptions options = buildQrCodeSignOptions(qrText);
        Signature signature = new Signature(document.toString());
        signature.sign(output.toString(), options);
    }

    /** New approach: ready PNG from saveOpticalCode / loadSignatureImage. */
    static void signWithImageSignOptions(Path document, Path qrPng, Path output) throws Exception {
        ImageSignOptions options = new ImageSignOptions(qrPng.toString());
        options.setPageNumber(PAGE_NUMBER);
        options.setLeft(LEFT);
        options.setTop(TOP);
        options.setWidth(IMAGE_WIDTH);
        options.setHeight(IMAGE_HEIGHT);

        Signature signature = new Signature(document.toString());
        signature.sign(output.toString(), options);
    }

    private static void runApproach(String title, SigningAction action) {
        System.out.println("--- " + title + " ---");
        try {
            action.run();
            System.out.println("SUCCESS");
        } catch (Exception ex) {
            System.out.println("FAILED: " + ex.getMessage());
            ex.printStackTrace(System.out);
        }
        System.out.println();
    }

    private static String loadQrText(Path qrXml) throws Exception {
        OpticalXmlEntity entity = new XMLReaderWriter<OpticalXmlEntity>().read(qrXml.toString(), OpticalXmlEntity.class);
        if (entity.getText() == null || entity.getText().trim().isEmpty()) {
            throw new IllegalStateException("QR text is empty in " + qrXml);
        }
        return entity.getText();
    }

    private static void applyLicense() throws Exception {
        Path license = DEMO_BASE.resolve(LICENSE_REL);
        if (Files.isRegularFile(license)) {
            License groupDocsLicense = new License();
            groupDocsLicense.setLicense(license.toString());
            System.out.println("License: " + license);
        } else {
            System.out.println("License not found at " + license + " — evaluation mode");
        }
    }

    private static Path resolveRequired(String relativePath, String label) {
        Path path = DEMO_BASE.resolve(relativePath).normalize();
        if (!Files.isRegularFile(path)) {
            throw new IllegalStateException(label + " not found: " + path
                    + "\nPlace files in DocumentSamples or set -Ddemo.document / -Ddemo.qrPng");
        }
        return path;
    }

    private static int intProperty(String key, int defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        return Integer.parseInt(value.trim());
    }

    private static String stripExtension(String fileName) {
        int dot = fileName.lastIndexOf('.');
        return dot > 0 ? fileName.substring(0, dot) : fileName;
    }

    @FunctionalInterface
    private interface SigningAction {
        void run() throws Exception;
    }
}
