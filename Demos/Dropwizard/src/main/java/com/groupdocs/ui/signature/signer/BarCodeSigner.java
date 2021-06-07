package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.options.barcodesignature.*;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;

import java.awt.*;

/**
 * BarCodeSigner
 * Signs documents with the BarCode signature
 *
 * @author Aspose Pty Ltd
 */
public class BarCodeSigner extends Signer {
    private OpticalXmlEntity barCodeData;

    /**
     * Constructor
     *
     * @param barCodeData   OpticalXmlEntity
     * @param signatureData SignatureDataEntity
     */
    public BarCodeSigner(OpticalXmlEntity barCodeData, SignatureDataEntity signatureData) {
        super(signatureData);
        this.barCodeData = barCodeData;
    }

    /**
     * Add BarCode signature data to pdf sign options
     *
     * @return PdfBarcodeSignOptions
     */
    @Override
    public PdfBarcodeSignOptions signPdf() {
        // setup options
        PdfBarcodeSignOptions signOptions = new PdfBarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

    /**
     * Add BarCode signature data to image sign options
     *
     * @return ImageBarcodeSignOptions
     */
    @Override
    public ImagesBarcodeSignOptions signImage() {
        // setup options
        ImagesBarcodeSignOptions signOptions = new ImagesBarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    private void fillProperties(BarcodeSignOptions signOptions) {
        signOptions.setEncodeType(BarcodeTypes.Code39Standard);
        signOptions.setBackgroundColor(Color.WHITE);
        signOptions.setHorizontalAlignment(signatureData.getHorizontalAlignment());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        if (signatureData.getAngle() != 0) {
            signOptions.setRotationAngle(signatureData.getAngle());
        }
    }

    /**
     * Add BarCode signature data to words sign options
     *
     * @return WordsBarcodeSignOptions
     */
    @Override
    public WordsBarcodeSignOptions signWord() {
        // setup options
        WordsBarcodeSignOptions signOptions = new WordsBarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

    /**
     * Add BarCode signature data to cells sign options
     *
     * @return CellsBarcodeSignOptions
     */
    @Override
    public CellsBarcodeSignOptions signCells() {
        // setup options
        CellsBarcodeSignOptions signOptions = new CellsBarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

    /**
     * Add BarCode signature data to slides sign options
     *
     * @return SlidesBarcodeSignOptions
     */
    @Override
    public SlidesBarcodeSignOptions signSlides() {
        // setup options
        SlidesBarcodeSignOptions signOptions = new SlidesBarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

}
