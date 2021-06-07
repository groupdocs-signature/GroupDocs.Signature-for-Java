package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.options.barcodesignature.*;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;
import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;

/**
 * BarCodeSigner
 * Signs documents with the BarCode signature
 * @author Aspose Pty Ltd
 */
public class BarCodeSigner extends Signer{
    private OpticalXmlEntity qrCodeData;

    /**
     * Constructor
     * @param qrCodeData OpticalXmlEntity
     * @param signatureData SignatureDataEntity
     */
    public BarCodeSigner(OpticalXmlEntity qrCodeData, SignatureDataEntity signatureData){
        super(signatureData);
        this.qrCodeData = qrCodeData;
    }

    /**
     * Add BarCode signature data to pdf sign options
     * @return PdfBarcodeSignOptions
     */
    @Override
    public PdfBarcodeSignOptions signPdf(){
        // setup options
        PdfBarcodeSignOptions signOptions = new PdfBarcodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
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
     * Add BarCode signature data to image sign options
     * @return ImageBarcodeSignOptions
     */
    @Override
    public ImagesBarcodeSignOptions signImage(){
        // setup options
        ImagesBarcodeSignOptions signOptions = new ImagesBarcodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
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
     * Add BarCode signature data to words sign options
     * @return WordsBarcodeSignOptions
     */
    @Override
    public WordsBarcodeSignOptions signWord(){
        // setup options
        WordsBarcodeSignOptions signOptions = new WordsBarcodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
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
     * Add BarCode signature data to cells sign options
     * @return CellsBarcodeSignOptions
     */
    @Override
    public CellsBarcodeSignOptions signCells(){
        // setup options
        CellsBarcodeSignOptions signOptions = new CellsBarcodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
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
     * Add BarCode signature data to slides sign options
     * @return SlidesBarcodeSignOptions
     */
    @Override
    public SlidesBarcodeSignOptions signSlides(){
        // setup options
        SlidesBarcodeSignOptions signOptions = new SlidesBarcodeSignOptions(qrCodeData.getText());
        signOptions.setEncodeType(BarcodeTypes.CODE_39_STANDARD);
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

    private void fillBorders(BarcodeSignOptions signOptions) {
        if(qrCodeData.getBorderWidth() != 0){
            signOptions.setBorderVisiblity(true);
            signOptions.setBorderColor(getColor(qrCodeData.getBorderColor()));
            signOptions.setBorderWeight(qrCodeData.getBorderWidth());
            signOptions.setBorderDashStyle(qrCodeData.getBorderStyle());
        }
    }
}
