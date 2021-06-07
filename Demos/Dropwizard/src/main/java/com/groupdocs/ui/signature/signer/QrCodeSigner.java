package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.qrcodes.QRCodeTypes;
import com.groupdocs.signature.options.qrcodesignature.*;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;

import java.awt.*;

/**
 * QrCodeSigner
 * Signs documents with the QR-Code signature
 *
 * @author Aspose Pty Ltd
 */
public class QrCodeSigner extends Signer {
    private OpticalXmlEntity qrCodeData;

    /**
     * Constructor
     *
     * @param qrCodeData
     * @param signatureData
     */
    public QrCodeSigner(OpticalXmlEntity qrCodeData, SignatureDataEntity signatureData) {
        super(signatureData);
        this.qrCodeData = qrCodeData;
    }

    /**
     * Add QR-Code signature data to pdf sign options
     *
     * @return PdfQRCodeSignOptions
     */
    @Override
    public PdfQRCodeSignOptions signPdf() {
        // setup options
        PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to image sign options
     *
     * @return ImageQRCodeSignOptions
     */
    @Override
    public ImagesQRCodeSignOptions signImage() {
        // setup options
        ImagesQRCodeSignOptions signOptions = new ImagesQRCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to words sign options
     *
     * @return WordsQRCodeSignOptions
     */
    @Override
    public WordsQRCodeSignOptions signWord() {
        // setup options
        WordsQRCodeSignOptions signOptions = new WordsQRCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to cells sign options
     *
     * @return CellsQRCodeSignOptions
     */
    @Override
    public CellsQRCodeSignOptions signCells() {
        // setup options
        CellsQRCodeSignOptions signOptions = new CellsQRCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to Slides sign options
     *
     * @return SlidesQRCodeSignOptions
     */
    @Override
    public SlidesQRCodeSignOptions signSlides() {
        // setup options
        SlidesQRCodeSignOptions signOptions = new SlidesQRCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    private void fillProperties(QRCodeSignOptions signOptions) {
        signOptions.setEncodeType(QRCodeTypes.QR);
        signOptions.setBackgroundColor(Color.WHITE);
        signOptions.setHorizontalAlignment(signatureData.getHorizontalAlignment());
        signOptions.setVerticalAlignment(signatureData.getVerticalAlignment());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        if (signatureData.getAngle() != 0) {
            signOptions.setRotationAngle(signatureData.getAngle());
        }
    }

}
