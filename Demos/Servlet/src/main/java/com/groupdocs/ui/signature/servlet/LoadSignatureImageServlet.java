package com.groupdocs.ui.signature.servlet;

import com.google.gson.Gson;
import com.groupdocs.ui.exception.TotalGroupDocsException;
import com.groupdocs.ui.model.request.LoadDocumentRequest;
import com.groupdocs.ui.model.response.LoadedPageEntity;
import com.groupdocs.ui.signature.util.JsonResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@WebServlet("/signature/loadSignatureImage")
public class LoadSignatureImageServlet extends CORSServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setControlHeader(resp);

        LoadDocumentRequest loadSignatureImageRequest = new Gson().fromJson(req.getReader(), LoadDocumentRequest.class);
        LoadedPageEntity loadedPage = new LoadedPageEntity();
        try {
            // get page image
            byte[] bytes = Files.readAllBytes(new File(loadSignatureImageRequest.getGuid()).toPath());
            // encode ByteArray into String
            String encodedImage = new String(Base64.getEncoder().encode(bytes));
            loadedPage.setPageImage(encodedImage);
            // return loaded page object
            JsonResponseUtils.writeJson(resp, loadedPage);
        }catch (Exception ex){
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }
}
