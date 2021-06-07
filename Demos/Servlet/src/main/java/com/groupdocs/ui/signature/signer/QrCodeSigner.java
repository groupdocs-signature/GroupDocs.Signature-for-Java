package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.qrcodes.QRCodeTypes;
import com.groupdocs.signature.options.qrcodesignature.*;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;
import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;

/**
 * QrCodeSigner
 * Signs documents with the QR-Code signature
 * @author Aspose Pty Ltd
 */
public class QrCodeSigner extends Signer{
    private OpticalXmlEntity qrCodeData;

    /**
     * Constructor
     * @param qrCodeData
     * @param signatureData
     */
    public QrCodeSigner(OpticalXmlEntity qrCodeData, SignatureDataEntity signatureData){
        super(signatureData);
        this.qrCodeData = qrCodeData;
    }

    /**
     * Add QR-Code signature data to pdf sign options
     * @return PdfQRCodeSignOptions
     */
    @Override
    public PdfQRCodeSignOptions signPdf(){
        // setup options
        PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(QRCodeTypes.QR);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
        fillBorders(signOptions);
        return signOptions;
    }

    private void fillBorders(QRCodeSignOptions signOptions) {
        if(qrCodeData.getBorderWidth() != 0){
            signOptions.setBorderVisiblity(true);
            signOptions.setBorderColor(getColor(qrCodeData.getBorderColor()));
            signOptions.setBorderWeight(qrCodeData.getBorderWidth());
            signOptions.setBorderDashStyle(qrCodeData.getBorderStyle());
        }
    }

    /**
     * Add QR-Code signature data to image sign options
     * @return ImageQRCodeSignOptions
     */
    @Override
    public ImagesQRCodeSignOptions signImage(){
        // setup options
        ImagesQRCodeSignOptions signOptions = new ImagesQRCodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(QRCodeTypes.QR);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        if(signatureData.getAngle() != 0) {
            signOptions.setRotationAngle(signatureData.getAngle());
        }
        fillBorders(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to words sign options
     * @return WordsQRCodeSignOptions
     */
    @Override
    public WordsQRCodeSignOptions signWord(){
        // setup options
        WordsQRCodeSignOptions signOptions = new WordsQRCodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(QRCodeTypes.QR);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
        fillBorders(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to cells sign options
     * @return CellsQRCodeSignOptions
     */
    @Override
    public CellsQRCodeSignOptions signCells(){
        // setup options
        CellsQRCodeSignOptions signOptions = new CellsQRCodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(QRCodeTypes.QR);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
        fillBorders(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to Slides sign options
     * @return SlidesQRCodeSignOptions
     */
    @Override
    public SlidesQRCodeSignOptions signSlides(){
        // setup options
        SlidesQRCodeSignOptions signOptions = new SlidesQRCodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(QRCodeTypes.QR);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
        fillBorders(signOptions);
        return signOptions;
    }

}
