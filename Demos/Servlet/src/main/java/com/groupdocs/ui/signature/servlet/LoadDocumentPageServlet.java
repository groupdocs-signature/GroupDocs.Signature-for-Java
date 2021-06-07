package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.model.request.LoadDocumentPageRequest;
import com.groupdocs.ui.model.response.LoadedPageEntity;
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

@WebServlet("/signature/loadDocumentPage")
public class LoadDocumentPageServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(LoadDocumentPageServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        LoadDocumentPageRequest loadDocumentPageRequest = new Gson().fromJson(req.getReader(), LoadDocumentPageRequest.class);

        LoadedPageEntity loadedPageEntity = signatureService.loadDocumentPage(loadDocumentPageRequest);

        JsonResponseUtils.writeJson(resp, loadedPageEntity);
    }
}
