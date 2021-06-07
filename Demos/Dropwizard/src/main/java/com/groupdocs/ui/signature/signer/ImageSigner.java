package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.options.imagesignature.*;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;

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
    public PdfSignImageOptions signPdf() {
        // setup options
        // setup image signature options
        PdfSignImageOptions signOptions = new PdfSignImageOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    private void fillImageOptions(SignImageOptions signOptions) {
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setHeight(signatureData.getImageHeight());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
    }

    /**
     * Add image signature data to image sign options
     *
     * @return ImageSignImageOptions
     */
    @Override
    public ImagesSignImageOptions signImage() {
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        ImagesSignImageOptions signOptions = new ImagesSignImageOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    /**
     * Add image signature data to words sign options
     *
     * @return WordsSignImageOptions
     */
    @Override
    public WordsSignImageOptions signWord() {
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        WordsSignImageOptions signOptions = new WordsSignImageOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    /**
     * Add image signature data to cells sign options
     *
     * @return CellsSignImageOptions
     */
    @Override
    public CellsSignImageOptions signCells() {
        // setup image signature options
        CellsSignImageOptions signOptions = new CellsSignImageOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }

    /**
     * Add image signature data to slides sign options
     *
     * @return SlidesSignImageOptions
     */
    @Override
    public SlidesSignImageOptions signSlides() {
        // setup image signature options with relative path - image file stores in config.ImagesPath folder
        SlidesSignImageOptions signOptions = new SlidesSignImageOptions(signatureData.getSignatureGuid());
        fillImageOptions(signOptions);
        return signOptions;
    }
}
