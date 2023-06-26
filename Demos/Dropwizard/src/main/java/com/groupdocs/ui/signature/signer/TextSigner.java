package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.domain.Background;
import com.groupdocs.signature.domain.Border;
import com.groupdocs.signature.domain.SignatureFont;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.TextSignatureImplementation;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.options.appearances.PdfTextAnnotationAppearance;
import com.groupdocs.signature.options.sign.TextSignOptions;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.xml.TextXmlEntity;

import java.awt.*;

/**
 * TextSigner
 * Signs documents with the text signature
 *
 * @author Aspose Pty Ltd
 */
public class TextSigner extends Signer {
    private TextXmlEntity textData;

    /**
     * Constructor
     *
     * @param textData
     * @param signatureData
     */
    public TextSigner(TextXmlEntity textData, SignatureDataEntity signatureData) {
        super(signatureData);
        this.textData = textData;
    }

    /**
     * Add text signature data to pdf sign options
     *
     * @return PdfSignTextOptions
     */
    @Override
    public TextSignOptions signPdf() {
        TextSignOptions signOptions = new TextSignOptions(textData.getText());
        signOptions.setPageNumber(signatureData.getPageNumber());
        fillTextOptions(signOptions);
        signOptions.setSignatureImplementation(TextSignatureImplementation.Image);
        // specify extended appearance options
        PdfTextAnnotationAppearance appearance = new PdfTextAnnotationAppearance();
        signOptions.setAppearance(appearance);
        return signOptions;
    }

    private int getReductionSize(int imageHeight) {
        int reductionSize = 0;
        // check if reduction size is between 1 and 2. for example: 1.25
        if ((double) textData.getHeight() / imageHeight > 1 && (double) textData.getHeight() / imageHeight < 2) {
            reductionSize = 2;
        } else if (textData.getHeight() / imageHeight == 0) {
            reductionSize = 1;
        } else {
            reductionSize = textData.getHeight() / imageHeight;
        }
        return reductionSize;
    }

    /**
     * Add text signature data to image sign options
     *
     * @return ImagesSignTextOptions
     */
    @Override
    public TextSignOptions signImage() {
        TextSignOptions signOptions = new TextSignOptions(textData.getText());
        fillTextOptions(signOptions);
        //type of implementation
        signOptions.setSignatureImplementation(TextSignatureImplementation.Image);
        return signOptions;
    }

    private void fillTextOptions(TextSignOptions signOptions) {
        signOptions.setLeft(signatureData.getLeft());
        signOptions.setTop(signatureData.getTop());
        int imageHeight = signatureData.getImageHeight();
        signOptions.setHeight(imageHeight);
        signOptions.setWidth(signatureData.getImageWidth());
        signOptions.setRotationAngle(signatureData.getAngle());
        signOptions.setVerticalAlignment(VerticalAlignment.None);
        signOptions.setHorizontalAlignment(HorizontalAlignment.None);

        Background background = new Background();
        background.setColor(getColor(textData.getBackgroundColor()));
        // setup colors settings
        signOptions.setBackground(background);
        // setup text color
        signOptions.setForeColor(getColor(textData.getFontColor()));
        // setup Font options
        if (signOptions.getFont() != null) {
            signOptions.getFont().setBold(textData.getBold());
            signOptions.getFont().setItalic(textData.getItalic());
            signOptions.getFont().setUnderline(textData.getUnderline());
            signOptions.getFont().setFamilyName(textData.getFont());
            // set reduction size - required to recalculate font size after signature resizing in the UI
            int reductionSize = getReductionSize(imageHeight);
            signOptions.getFont().setSize(textData.getFontSize() / reductionSize);
        }
    }

    /**
     * Add text signature data to words sign options
     *
     * @return WordsSignTextOptions
     */
    @Override
    public TextSignOptions signWord() {
        TextSignOptions signOptions = new TextSignOptions(textData.getText());
        signOptions.setPageNumber(signatureData.getPageNumber()-1);
        fillTextOptions(signOptions);
        //signOptions.setSignatureImplementation(TextSignatureImplementation.Image);
        return signOptions;
    }

    /**
     * Add text signature data to cells sign options
     *
     * @return CellsSignTextOptions
     */
    @Override
    public TextSignOptions signCells() {
        TextSignOptions signOptions = new TextSignOptions(textData.getText());
        signOptions.setPageNumber(signatureData.getPageNumber()-1);
        fillTextOptions(signOptions);
        Border border = new Border();
        border.setVisible(true);
        signOptions.setBorder(border);
        //type of implementation
        signOptions.setSignatureImplementation(TextSignatureImplementation.Image);
        return signOptions;
    }

    /**
     * Add text signature data to slides sign options
     *
     * @return SlidesSignTextOptions
     */
    @Override
    public TextSignOptions signSlides() {
        TextSignOptions signOptions = new TextSignOptions(textData.getText());
        signOptions.setPageNumber(signatureData.getPageNumber()-1);
        fillTextOptions(signOptions);
        //type of implementation
        signOptions.setSignatureImplementation(TextSignatureImplementation.Image);
        return signOptions;
    }
}
