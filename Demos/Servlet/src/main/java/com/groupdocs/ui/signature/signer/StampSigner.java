package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.stamps.StampBackgroundCropType;
import com.groupdocs.signature.domain.stamps.StampLine;
import com.groupdocs.signature.domain.stamps.StampTextRepeatType;
import com.groupdocs.signature.options.stampsignature.CellsStampSignOptions;
import com.groupdocs.signature.options.stampsignature.WordsStampSignOptions;
import com.groupdocs.signature.options.stampsignature.ImagesStampSignOptions;
import com.groupdocs.signature.options.stampsignature.SlidesStampSignOptions;
import com.groupdocs.signature.options.stampsignature.PdfStampSignOptions;
import com.groupdocs.ui.signature.model.web.SignatureDataEntity;
import com.groupdocs.ui.signature.model.xml.StampXmlEntity;

import java.util.List;

/**
 * StampSigner
 * Signs documents with the stamp signature
 * @author Aspose Pty Ltd
 */
public class StampSigner extends Signer{
    private List<StampXmlEntity> stampData;

    /**
     * Constructor
     * @param stampData
     * @param signatureData
     */
    public StampSigner(List<StampXmlEntity> stampData, SignatureDataEntity signatureData) {
        super(signatureData);
        this.stampData = stampData;
    }

    /**
     * Add stamp signature data to pdf sign options
     * @return PdfStampSignOptions
     */
    @Override
    public PdfStampSignOptions signPdf(){
        // setup options
        PdfStampSignOptions pdfSignOptions = new PdfStampSignOptions();
        pdfSignOptions.setHeight(signatureData.getImageHeight());
        pdfSignOptions.setWidth(signatureData.getImageWidth());
        pdfSignOptions.setTop(signatureData.getTop());
        pdfSignOptions.setLeft(signatureData.getLeft());
        pdfSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        pdfSignOptions.setRotationAngle(signatureData.getAngle());
        pdfSignOptions.setBackgroundColor(getColor(stampData.get(stampData.size() - 1).getBackgroundColor()));
        pdfSignOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
        // draw stamp lines
        fillStamp(pdfSignOptions.getInnerLines(), pdfSignOptions.getOuterLines());
        return pdfSignOptions;
    }

    /**
     * Add stamp signature data to image sign options
     * @return ImageStampSignOptions
     */
    @Override
    public ImagesStampSignOptions signImage(){
        // setup options
        ImagesStampSignOptions imageSignOptions = new ImagesStampSignOptions();
        imageSignOptions.setHeight(signatureData.getImageHeight());
        imageSignOptions.setWidth(signatureData.getImageWidth());
        imageSignOptions.setTop(signatureData.getTop());
        imageSignOptions.setLeft(signatureData.getLeft());
        imageSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        imageSignOptions.setRotationAngle(signatureData.getAngle());
        imageSignOptions.setBackgroundColor(getColor(stampData.get(stampData.size() - 1).getBackgroundColor()));
        imageSignOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
        fillStamp(imageSignOptions.getInnerLines(), imageSignOptions.getOuterLines());
        return imageSignOptions;
    }

    /**
     * Add stamp signature data to words sign options
     * @return WordsStampSignOptions
     */
    @Override
    public WordsStampSignOptions signWord(){
        // setup options
        WordsStampSignOptions wordsSignOptions = new WordsStampSignOptions();
        wordsSignOptions.setHeight(signatureData.getImageHeight());
        wordsSignOptions.setWidth(signatureData.getImageWidth());
        wordsSignOptions.setTop(signatureData.getTop());
        wordsSignOptions.setLeft(signatureData.getLeft());
        wordsSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        wordsSignOptions.setRotationAngle(signatureData.getAngle());
        wordsSignOptions.setBackgroundColor(getColor(stampData.get(stampData.size() - 1).getBackgroundColor()));
        wordsSignOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
        fillStamp(wordsSignOptions.getInnerLines(), wordsSignOptions.getOuterLines());
        return wordsSignOptions;
    }

    /**
     * Add stamp signature data to cells sign options
     * @return CellsStampSignOptions
     */
    @Override
    public CellsStampSignOptions signCells(){
        // setup options
        CellsStampSignOptions cellsSignOptions = new CellsStampSignOptions();
        cellsSignOptions.setHeight(signatureData.getImageHeight());
        cellsSignOptions.setWidth(signatureData.getImageWidth());
        cellsSignOptions.setTop(signatureData.getTop());
        cellsSignOptions.setLeft(signatureData.getLeft());
        cellsSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        cellsSignOptions.setRotationAngle(signatureData.getAngle());
        cellsSignOptions.setBackgroundColor(getColor(stampData.get(stampData.size() - 1).getBackgroundColor()));
        cellsSignOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
        fillStamp(cellsSignOptions.getInnerLines(), cellsSignOptions.getOuterLines());
        return cellsSignOptions;
    }

    /**
     * Add stamp signature data to slides sign options
     * @return SlidesStampSignOptions
     */
    @Override
    public SlidesStampSignOptions signSlides(){
        // setup options
        SlidesStampSignOptions slidesSignOptions = new SlidesStampSignOptions();
        slidesSignOptions.setHeight(signatureData.getImageHeight());
        slidesSignOptions.setWidth(signatureData.getImageWidth());
        slidesSignOptions.setTop(signatureData.getTop());
        slidesSignOptions.setLeft(signatureData.getLeft());
        slidesSignOptions.setDocumentPageNumber(signatureData.getPageNumber());
        slidesSignOptions.setRotationAngle(signatureData.getAngle());
        slidesSignOptions.setBackgroundColor(getColor(stampData.get(stampData.size() - 1).getBackgroundColor()));
        slidesSignOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
        fillStamp(slidesSignOptions.getInnerLines(), slidesSignOptions.getOuterLines());
        return slidesSignOptions;
    }

    private void fillStamp(List<StampLine> innerLines, List<StampLine> outerLines) {
        for (int n = 0; n < stampData.size(); n++) {
            String text = "";
            for (int m = 0; m < stampData.get(n).getTextRepeat(); m++) {
                text = text + stampData.get(n).getText();
            }
            // set reduction size - required to recalculate each stamp line height and font size after stamp resizing in the UI
            int reductionSize = 0;
            // check if reduction size is between 1 and 2. for example: 1.25
            if ((double) stampData.get(n).getHeight() / signatureData.getImageHeight() > 1 && (double) stampData.get(n).getHeight() / signatureData.getImageHeight() < 2) {
                reductionSize = 2;
            } else if (stampData.get(n).getHeight() / signatureData.getImageHeight() == 0) {
                reductionSize = 1;
            } else {
                reductionSize = stampData.get(n).getHeight() / signatureData.getImageHeight();
            }
            if ((n + 1) == stampData.size()) {
                // draw inner horizontal line
                StampLine squareLine = new StampLine();
                squareLine.setText(text);
                squareLine.getFont().setFontSize(stampData.get(n).getFontSize() / reductionSize);
                squareLine.setTextColor(getColor(stampData.get(n).getTextColor()));
                innerLines.add(squareLine);
                if (stampData.size() == 1) {
                    StampLine line = new StampLine();
                    line.setBackgroundColor(getColor(stampData.get(n).getBackgroundColor()));
                    line.getOuterBorder().setColor(getColor(stampData.get(n).getStrokeColor()));
                    line.getOuterBorder().setWeight(0.5);
                    line.getInnerBorder().setColor(getColor(stampData.get(n).getBackgroundColor()));
                    line.getInnerBorder().setWeight(0.5);
                    line.setHeight(1);
                    outerLines.add(line);
                }
            } else {
                // draw outer rounded lines
                int height = (stampData.get(n).getRadius() - stampData.get(n + 1).getRadius()) / reductionSize;
                StampLine line = new StampLine();
                line.setBackgroundColor(getColor(stampData.get(n).getBackgroundColor()));
                line.getOuterBorder().setColor(getColor(stampData.get(n).getStrokeColor()));
                line.getOuterBorder().setWeight(0.5);
                line.getInnerBorder().setColor(getColor(stampData.get(n + 1).getStrokeColor()));
                line.getInnerBorder().setWeight(0.5);
                line.setText(text);
                line.setHeight(height);
                line.getFont().setFontSize(stampData.get(n).getFontSize() / reductionSize);
                line.setTextColor(getColor(stampData.get(n).getTextColor()));
                line.setTextBottomIntent((height / 2));
                line.setTextRepeatType(StampTextRepeatType.RepeatWithTruncation);
                outerLines.add(line);
            }
        }
    }

}
