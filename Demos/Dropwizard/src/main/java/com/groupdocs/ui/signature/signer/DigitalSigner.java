package com.groupdocs.ui.signature.signer;

import com.groupdocs.signature.options.SignOptions;
import com.groupdocs.signature.options.digitalsignature.CellsSignDigitalOptions;
import com.groupdocs.signature.options.digitalsignature.PdfSignDigitalOptions;
import com.groupdocs.signature.options.digitalsignature.WordsSignDigitalOptions;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;

import javax.ws.rs.NotSupportedException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DigitalSigner
 * Signs documents with the digital signature
 *
 * @author Aspose Pty Ltd
 */
public class DigitalSigner extends Signer {
    private String password;

    /**
     * Constructor
     *
     * @param signatureData
     * @param password
     */
    public DigitalSigner(SignatureDataEntity signatureData, String password) {
        super(signatureData);
        this.password = password;
    }

    /**
     * Add digital signature data to pdf sign options
     *
     * @return PdfSignDigitalOptions
     */
    @Override
    public PdfSignDigitalOptions signPdf() throws ParseException {
        // initiate date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");
        // setup digital signature options
        PdfSignDigitalOptions pdfSignOptions = new PdfSignDigitalOptions(signatureData.getSignatureGuid());
        pdfSignOptions.setReason(signatureData.getReason());
        pdfSignOptions.setContact(signatureData.getContact());
        pdfSignOptions.setLocation(signatureData.getAddress());
        pdfSignOptions.setPassword(password);
        pdfSignOptions.setSignAllPages(true);
        if (signatureData.getDate() != null && !signatureData.getDate().isEmpty()) {
            pdfSignOptions.getSignature().setSignTime(formatter.parse(signatureData.getDate()));
        }
        return pdfSignOptions;
    }

    /**
     * Sign image with digital signature currently not supported
     *
     * @throws NotSupportedException
     */
    @Override
    public SignOptions signImage() throws NotSupportedException {
        throw new NotSupportedException("This file type is not supported");
    }

    /**
     * Add digital signature data to words sign options
     *
     * @return WordsSignDigitalOptions
     */
    @Override
    public WordsSignDigitalOptions signWord() throws ParseException {
        // initiate date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");
        // setup digital signature options
        WordsSignDigitalOptions wordsSignOptions = new WordsSignDigitalOptions(signatureData.getSignatureGuid());
        if (signatureData.getDate() != null && !signatureData.getDate().isEmpty()) {
            wordsSignOptions.getSignature().setSignTime(formatter.parse(signatureData.getDate()));
        }
        wordsSignOptions.setPassword(password);
        wordsSignOptions.setSignAllPages(true);
        return wordsSignOptions;
    }

    /**
     * Add digital signature data to cells sign options
     *
     * @return CellsSignDigitalOptions
     */
    @Override
    public CellsSignDigitalOptions signCells() throws ParseException {
        // initiate date formatter
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yy");
        CellsSignDigitalOptions cellsSignOptions = new CellsSignDigitalOptions(signatureData.getSignatureGuid());
        if (signatureData.getDate() != null && !signatureData.getDate().isEmpty()) {
            cellsSignOptions.getSignature().setSignTime(formatter.parse(signatureData.getDate()));
        }
        cellsSignOptions.setPassword(password);
        cellsSignOptions.setSignAllPages(true);
        return cellsSignOptions;
    }

    /**
     * Sign slides with digital signature currently not supported
     *
     * @throws NotSupportedException
     */
    @Override
    public SignOptions signSlides() throws NotSupportedException, ParseException {
        throw new NotSupportedException("This file type is not supported");
    }
}
