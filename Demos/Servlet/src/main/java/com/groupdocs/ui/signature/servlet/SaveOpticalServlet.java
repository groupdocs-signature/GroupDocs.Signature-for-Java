package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.signature.model.request.SaveOpticalCodeRequest;
import com.groupdocs.ui.signature.model.xml.OpticalXmlEntity;
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

@WebServlet("/signature/saveOpticalCode")
public class SaveOpticalServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(SaveOpticalServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        SaveOpticalCodeRequest saveOpticalCodeRequest = new Gson().fromJson(req.getReader(), SaveOpticalCodeRequest.class);

        OpticalXmlEntity opticalXmlEntity = signatureService.saveOpticalCode(saveOpticalCodeRequest);

        JsonResponseUtils.writeJson(resp, opticalXmlEntity);
    }
}