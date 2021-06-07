package com.groupdocs.ui.signature.servlet;

import com.groupdocs.ui.signature.model.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.service.SignatureService;
import com.groupdocs.ui.signature.util.JsonResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/signature/uploadDocument")
@MultipartConfig
public class UploadDocumentServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(UploadDocumentServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        Part file = req.getPart("file");
        String url = req.getParameter("url");
        Boolean rewrite = Boolean.valueOf(req.getParameter("rewrite"));
        String signatureType = req.getParameter("signatureType");

        SignatureFileDescriptionEntity signatureFileDescriptionEntity = signatureService.uploadDocument(file, url, rewrite, signatureType);

        JsonResponseUtils.writeJson(resp, signatureFileDescriptionEntity);
    }

}
