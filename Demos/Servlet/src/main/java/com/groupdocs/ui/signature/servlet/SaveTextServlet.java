package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.signature.model.request.SaveTextRequest;
import com.groupdocs.ui.signature.model.xml.TextXmlEntity;
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

@WebServlet("/signature/saveText")
public class SaveTextServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(SaveTextServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        SaveTextRequest saveTextRequest = new Gson().fromJson(req.getReader(), SaveTextRequest.class);

        TextXmlEntity textXmlEntity = signatureService.saveText(saveTextRequest);

        JsonResponseUtils.writeJson(resp, textXmlEntity);
    }
}