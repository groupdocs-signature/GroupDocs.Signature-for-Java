package com.groupdocs.signature.examples.advanced_usage.sign.sign_multilayers_images;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.Padding;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.VerificationResult;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.enums.TextMatchType;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.QrCodeSignature;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.PageStreamFactory;
import com.groupdocs.signature.options.preview.PreviewFormats;
import com.groupdocs.signature.options.preview.PreviewOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.DicomSaveOptions;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.DicomXmpEntry;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.DicomXmpType;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.signature.options.verify.QrCodeVerifyOptions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SignDicomImageAdvanced
{
    /**
     * <p>
     * Following example demonstrates how to sign multilayer image document DICOM format with several signatures
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignDicomImageAdvanced : Sign multilayer image document DICOM format with several signatures\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_DICOM;
        String fileName = Paths.get(filePath).getFileName().toString();

        String outputFilePath = new File(Constants.OutputPath, "SignDicomImageAdvanced\\"+ fileName).getPath();

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            Padding tmp0 = new  Padding();
            tmp0.setRight(5);
            tmp0.setLeft(5);
            QrCodeSignOptions options = new QrCodeSignOptions("Patient #36363393. R: No-Issues");
            options.setAllPages(true);
            options.setWidth(100);
            options.setHeight(100);
            options.setVerticalAlignment(VerticalAlignment.Bottom);
            options.setHorizontalAlignment(HorizontalAlignment.Right);
            options.setMargin(tmp0);

            //Add Xmp meta-data to signed document
            DicomSaveOptions dicomSaveOptions = new DicomSaveOptions();
            List<DicomXmpEntry> list = new ArrayList<DicomXmpEntry>();
            list.add(new DicomXmpEntry(DicomXmpType.PatientName, "Patient #4"));
            dicomSaveOptions.setXmpEntries(list);

            // sign document to file
            SignResult signResult = signature.sign(outputFilePath, options, dicomSaveOptions);
            System.out.print("\nSource document signed successfully with "+signResult.getSucceeded().size()+" signature(s).\nFile saved at "+outputFilePath);
            System.out.print("\nList of newly created signatures:");
            for (BaseSignature temp : signResult.getSucceeded())
            {
                System.out.print(temp.getSignatureType()+" at page #"+temp.getPageNumber()+": Id:"+temp.getSignatureId()+".");
            }
        }
        finally { if (signature != null) (signature).dispose(); }

        //Get signed DICOM image info
        documentInfo(outputFilePath);

        //Search for signatures at signed DICOM
        search(outputFilePath);

        //Verify signed DICOM
        verify(outputFilePath);

        //Preview signed DICOM
        preview(outputFilePath);
    }

    private static void documentInfo(String filePath) throws Exception
    {
        //Get signed DICOM image info
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            IDocumentInfo signedDocumentInfo = signature.getDocumentInfo();

            //Print XMP data
            System.out.print("\nList of DICOM xmp metadata:");
            for (MetadataSignature item : signedDocumentInfo.getMetadataSignatures())
            {
                System.out.print(item.toString());
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }

    private static void verify(String filePath) throws Exception
    {
        // verify document signatures
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            QrCodeVerifyOptions options = new QrCodeVerifyOptions();
            options.setAllPages(true);
            options.setText("Patient #36363393");
            options.setMatchType(TextMatchType.Contains);

            VerificationResult result = signature.verify(options);
            if (result.isValid())
            {
                System.out.print("\nDICOM "+filePath+" has "+result.getSucceeded().size()+" successfully verified signatures!");
            }
            else
            {
                System.out.print("\nDocument "+filePath+" failed verification process.");
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }

    private static void search(String filePath) throws Exception
    {
        // search for signatures in document
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            List<QrCodeSignature> signatures = signature.search(QrCodeSignature.class, SignatureType.QrCode);
            System.out.print("\nDICOM ['"+filePath+"'] contains following signatures.");

              for (QrCodeSignature QrCodeSignature : signatures)
              {
                System.out.print("QRCode signature found at page "+QrCodeSignature.getPageNumber()+" with type "+QrCodeSignature.getEncodeType().getTypeName()+" and text "+QrCodeSignature.getText());
              }

        }
        finally { if (signature != null) (signature).dispose(); }
    }

    private static void preview(String filePath) throws Exception
    {
        // generate preview
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            PreviewOptions previewOption = new PreviewOptions(new PageStreamFactory() {
                @Override
                public OutputStream createPageStream(int pageNumber) {
                    return generatePageStream(pageNumber);
                }

                @Override
                public void closePageStream(int pageNumber, OutputStream pageStream) {
                    releasePageStream(pageNumber, pageStream);
                }
            });
            signature.generatePreview(previewOption);
            System.out.print("\nDICOM ['"+filePath+"'] pages previews were successfully generated!");
        }
        finally { if (signature != null) (signature).dispose(); }
    }

    private static OutputStream generatePageStream(int pageNumber)
    {
        try {
            String filePath = Constants.OutputPath +"\\SignDicomImageAdvanced\\image-"+pageNumber+".jpg";
            return new FileOutputStream(filePath);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }

    private static void releasePageStream(int pageNumber, OutputStream pageStream)
    {
        try {
            pageStream.close();
            String imageFilePath = new File(Constants.OutputPath + "\\SignDicomImageAdvanced", "image-" +pageNumber +  ".jpg").getPath();
            System.out.print("Image file "+imageFilePath+" is ready for preview");
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
}
