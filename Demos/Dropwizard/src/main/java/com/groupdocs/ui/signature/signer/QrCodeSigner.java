package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;

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
    public QrCodeSignOptions signPdf() {
        QrCodeSignOptions signOptions = new QrCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to image sign options
     *
     * @return ImageQRCodeSignOptions
     */
    @Override
    public QrCodeSignOptions signImage() {
        QrCodeSignOptions signOptions = new QrCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to words sign options
     *
     * @return WordsQRCodeSignOptions
     */
    @Override
    public QrCodeSignOptions signWord() {
        QrCodeSignOptions signOptions = new QrCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to cells sign options
     *
     * @return CellsQRCodeSignOptions
     */
    @Override
    public QrCodeSignOptions signCells() {
        QrCodeSignOptions signOptions = new QrCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    /**
     * Add QR-Code signature data to Slides sign options
     *
     * @return SlidesQRCodeSignOptions
     */
    @Override
    public QrCodeSignOptions signSlides() {
        QrCodeSignOptions signOptions = new QrCodeSignOptions(qrCodeData.getText());
        fillProperties(signOptions);
        return signOptions;
    }

    private void fillProperties(QrCodeSignOptions signOptions) {
        signOptions.setEncodeType(QrCodeTypes.QR);
        signOptions.setHorizontalAlignment(signatureData.getHorizontalAlignment());
        signOptions.setVerticalAlignment(signatureData.getVerticalAlignment());
        signOptions.setWidth(resolveDimension(signatureData.getImageWidth()));
        signOptions.setHeight(resolveDimension(signatureData.getImageHeight()));
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setPageNumber(signatureData.getPageNumber());
        if (signatureData.getAngle() != 0) {
            signOptions.setRotationAngle(signatureData.getAngle());
        }
    }

    private int resolveDimension(int value) {
        return value > 0 ? value : 200;
    }

}
