package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.model.response.FileDescriptionEntity;
import com.groupdocs.ui.signature.model.request.SaveStampRequest;
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

@WebServlet("/signature/saveStamp")
public class SaveStampServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(SaveStampServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        SaveStampRequest saveStampRequest = new Gson().fromJson(req.getReader(), SaveStampRequest.class);

        FileDescriptionEntity fileDescriptionEntity = signatureService.saveStamp(saveStampRequest);

        JsonResponseUtils.writeJson(resp, fileDescriptionEntity);
    }
}