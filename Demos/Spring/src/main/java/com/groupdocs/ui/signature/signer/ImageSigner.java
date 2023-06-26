package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.options.sign.ImageSignOptions;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;

/**
 * ImageSigner
 * Signs documents with the image signature
 *
 * @author Aspose Pty Ltd
 */
public class ImageSigner extends Signer {

    /**
     * Constructor
     *
     * @param signatureData
     */
    public ImageSigner(SignatureDataEntity signatureData) {
        super(signatureData);
    }

    /**
     * Add image signature data to pdf sign options
     *
     * @return PdfSignImageOptions
     */
    @Override
    public ImageSignOptions signPdf() {
        // setup options
        // setup image signature options
        ImageSignOptions signOptions = new ImageSignOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    private void fillImageOptions(ImageSignOptions signOptions) {
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
    }

    /**
     * Add image signature data to image sign options
     *
     * @return ImageSignImageOptions
     */
    @Override
    public ImageSignOptions signImage() {
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        ImageSignOptions signOptions = new ImageSignOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    /**
     * Add image signature data to words sign options
     *
     * @return WordsSignImageOptions
     */
    @Override
    public ImageSignOptions signWord() {
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        ImageSignOptions signOptions = new ImageSignOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    /**
     * Add image signature data to cells sign options
     *
     * @return CellsSignImageOptions
     */
    @Override
    public ImageSignOptions signCells() {
        // setup image signature options
        ImageSignOptions signOptions = new ImageSignOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    /**
     * Add image signature data to slides sign options
     *
     * @return SlidesSignImageOptions
     */
    @Override
    public ImageSignOptions signSlides() {
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        ImageSignOptions signOptions = new ImageSignOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }
}
