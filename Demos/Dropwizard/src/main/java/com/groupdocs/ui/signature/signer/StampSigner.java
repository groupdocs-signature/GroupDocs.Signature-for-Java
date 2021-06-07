package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.stamps.StampBackgroundCropType;
import com.groupdocs.signature.domain.stamps.StampLine;
import com.groupdocs.signature.domain.stamps.StampTextRepeatType;
import com.groupdocs.signature.options.stampsignature.*;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.xml.StampXmlEntity;

import java.util.List;

/**
 * StampSigner
 * Signs documents with the stamp signature
 *
 * @author Aspose Pty Ltd
 */
public class StampSigner extends Signer {
    private List<StampXmlEntity> stampData;

    /**
     * Constructor
     *
     * @param stampData
     * @param signatureData
     */
    public StampSigner(List<StampXmlEntity> stampData, SignatureDataEntity signatureData) {
        super(signatureData);
        this.stampData = stampData;
    }

    /**
     * Add stamp signature data to pdf sign options
     *
     * @return PdfStampSignOptions
     */
    @Override
    public PdfStampSignOptions signPdf() {
        // setup options
        PdfStampSignOptions signOptions = new PdfStampSignOptions();
        fillStampOptions(signOptions);
        return signOptions;
    }

    private void fillStampOptions(StampSignOptions signOptions) {
        signOptions.setHeight(signatureData.getImageHeight() - 20);
        signOptions.setWidth(signatureData.getImageWidth() - 20);
        signOptions.setTop(signatureData.getTop());
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setDocumentPageNumber(signatureData.getPageNumber());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setBackgroundColor(getColor(stampData.get(stampData.size() - 1).getBackgroundColor()));
        signOptions.setBackgroundColorCropType(StampBackgroundCropType.OuterArea);
        fillStamp(signOptions.getInnerLines(), signOptions.getOuterLines());
    }

    /**
     * Add stamp signature data to image sign options
     *
     * @return ImageStampSignOptions
     */
    @Override
    public ImagesStampSignOptions signImage() {
        // setup options
        ImagesStampSignOptions signOptions = new ImagesStampSignOptions();
        fillStampOptions(signOptions);
        return signOptions;
    }

    /**
     * Add stamp signature data to words sign options
     *
     * @return WordsStampSignOptions
     */
    @Override
    public WordsStampSignOptions signWord() {
        // setup options
        WordsStampSignOptions signOptions = new WordsStampSignOptions();
        fillStampOptions(signOptions);
        return signOptions;
    }

    /**
     * Add stamp signature data to cells sign options
     *
     * @return CellsStampSignOptions
     */
    @Override
    public CellsStampSignOptions signCells() {
        // setup options
        CellsStampSignOptions signOptions = new CellsStampSignOptions();
        fillStampOptions(signOptions);
        return signOptions;
    }

    /**
     * Add stamp signature data to slides sign options
     *
     * @return SlidesStampSignOptions
     */
    @Override
    public SlidesStampSignOptions signSlides() {
        // setup options
        SlidesStampSignOptions signOptions = new SlidesStampSignOptions();
        fillStampOptions(signOptions);
        return signOptions;
    }

    private void fillStamp(List<StampLine> innerLines, List<StampLine> outerLines) {
        for (int i = 0; i < stampData.size(); i++) {
            StampXmlEntity stampXmlEntity = stampData.get(i);
            String text = "";
            for (int j = 0; j < stampXmlEntity.getTextRepeat(); j++) {
                text = text + stampXmlEntity.getText();
            }
            // set reduction size - required to recalculate each stamp line height and font size after stamp resizing in the UI
            int reductionSize = 0;
            // check if reduction size is between 1 and 2. for example: 1.25
            int stampXmlEntityHeight = stampXmlEntity.getHeight();
            int imageHeight = signatureData.getImageHeight();
            if ((double) stampXmlEntityHeight / imageHeight > 1 && (double) stampXmlEntityHeight / imageHeight < 2) {
                reductionSize = 2;
            } else if (stampXmlEntityHeight / imageHeight == 0) {
                reductionSize = 1;
            } else {
                reductionSize = stampXmlEntityHeight / imageHeight;
            }
            if ((i + 1) == stampData.size()) {
                // draw inner horizontal line
                StampLine squareLine = new StampLine();
                fillTextAndFont(stampXmlEntity, text, reductionSize, squareLine);
                innerLines.add(squareLine);
                if (stampData.size() == 1) {
                    StampLine line = initStampLine(i);
                    line.getInnerBorder().setColor(getColor(stampXmlEntity.getBackgroundColor()));
                    line.setHeight(1);
                    outerLines.add(line);
                }
            } else {
                // draw outer rounded lines
                StampLine line = initStampLine(i);
                line.getInnerBorder().setColor(getColor(stampData.get(i + 1).getStrokeColor()));
                int height = (stampXmlEntity.getRadius() - stampData.get(i + 1).getRadius()) / reductionSize;
                line.setHeight(height);
                fillTextAndFont(stampXmlEntity, text, reductionSize, line);
                line.setTextBottomIntent((height / 2));
                line.setTextRepeatType(StampTextRepeatType.None);
                outerLines.add(line);
            }
        }
    }

    private void fillTextAndFont(StampXmlEntity stampXmlEntity, String text, int reductionSize, StampLine squareLine) {
        squareLine.setText(text);
        squareLine.getFont().setFontSize(stampXmlEntity.getFontSize() / reductionSize);
        squareLine.getFont().setBold(stampXmlEntity.getBold());
        squareLine.getFont().setItalic(stampXmlEntity.getItalic());
        squareLine.getFont().setUnderline(stampXmlEntity.getUnderline());
        squareLine.setTextColor(getColor(stampXmlEntity.getTextColor()));
    }

    private StampLine initStampLine(int n) {
        StampLine line = new StampLine();
        line.setBackgroundColor(getColor(stampData.get(n).getBackgroundColor()));
        line.getOuterBorder().setColor(getColor(stampData.get(n).getStrokeColor()));
        line.getOuterBorder().setWeight(0.5);
        line.getInnerBorder().setWeight(0.5);
        return line;
    }

}
