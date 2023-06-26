package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.Background;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.options.sign.BarcodeSignOptions;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;
import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;

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
    public BarcodeSignOptions signPdf() {
        // setup options
        BarcodeSignOptions signOptions = new BarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

    /**
     * Add BarCode signature data to image sign options
     *
     * @return ImageBarcodeSignOptions
     */
    @Override
    public BarcodeSignOptions signImage() {
        // setup options
        BarcodeSignOptions signOptions = new BarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    private void fillProperties(BarcodeSignOptions signOptions) {
        signOptions.setEncodeType(BarcodeTypes.Code39Standard);
        Background background = new Background();
        background.setColor(Color.WHITE);
        signOptions.setBackground(background);
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
    public BarcodeSignOptions signWord() {
        // setup options
        BarcodeSignOptions signOptions = new BarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

    /**
     * Add BarCode signature data to cells sign options
     *
     * @return CellsBarcodeSignOptions
     */
    @Override
    public BarcodeSignOptions signCells() {
        // setup options
        BarcodeSignOptions signOptions = new BarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

    /**
     * Add BarCode signature data to slides sign options
     *
     * @return SlidesBarcodeSignOptions
     */
    @Override
    public BarcodeSignOptions signSlides() {
        // setup options
        BarcodeSignOptions signOptions = new BarcodeSignOptions(barCodeData.getText());
        fillProperties(signOptions);
        signOptions.setPageNumber(signatureData.getPageNumber());
        return signOptions;
    }

}
