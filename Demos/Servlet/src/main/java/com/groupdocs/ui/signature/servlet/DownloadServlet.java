package com.groupdocs.ui.signature.servlet;

import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.signature.config.SignatureConfiguration;
import com.groupdocs.ui.signature.service.SignatureService;
import com.groupdocs.ui.util.Utils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import static com.groupdocs.ui.signature.util.PathConstants.OUTPUT_FOLDER;

@WebServlet("/signature/downloadDocument/")
public class DownloadServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(DownloadServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        String documentGuid = req.getParameter("path");
        Boolean signed = Boolean.valueOf(req.getParameter("signed"));

        // get document path
        String fileName = FilenameUtils.getName(documentGuid);
        // choose directory
        SignatureConfiguration signatureConfiguration = signatureService.getSignatureConfiguration();
        String filesDirectory = signed ? signatureConfiguration.getDataDirectory() + OUTPUT_FOLDER : signatureConfiguration.getFilesDirectory();
        String pathToDownload = String.format("%s%s%s", filesDirectory, File.separator, fileName);

        // set response content info
        Utils.addFileDownloadHeaders(resp, fileName, null);

        long length;
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(pathToDownload));
             ServletOutputStream outputStream = resp.getOutputStream()) {
            // download the document
            length = IOUtils.copyLarge(inputStream, outputStream);
        } catch (Exception ex) {
            logger.error("Exception in downloading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }

        // add downloaded file length into header
        Utils.addFileDownloadLengthHeader(resp, length);
    }
}
