package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.signature.model.request.SignatureFileTreeRequest;
import com.groupdocs.ui.signature.model.web.SignatureFileDescriptionEntity;
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

@WebServlet("/signature/loadFileTree")
public class FileTreeLoadServlet extends CORSServlet {
    private static final Logger logger = LoggerFactory.getLogger(FileTreeLoadServlet.class);

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        SignatureFileTreeRequest fileTreeRequest = new Gson().fromJson(req.getReader(), SignatureFileTreeRequest.class);

        List<SignatureFileDescriptionEntity> fileList = signatureService.getFileList(fileTreeRequest);

        JsonResponseUtils.writeJson(resp, fileList);
    }

}
