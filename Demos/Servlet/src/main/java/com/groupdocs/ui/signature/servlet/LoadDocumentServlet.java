package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.DocumentDescriptionEntity;
import com.groupdocs.ui.signature.service.SignatureService;
import com.groupdocs.ui.signature.util.JsonResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/signature/loadDocumentDescription")
public class LoadDocumentServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(LoadDocumentServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        LoadDocumentRequest loadDocumentRequest = new Gson().fromJson(req.getReader(), LoadDocumentRequest.class);

        List<DocumentDescriptionEntity> documentDescription = signatureService.getDocumentDescription(loadDocumentRequest);

        JsonResponseUtils.writeJson(resp, documentDescription);
    }
}
