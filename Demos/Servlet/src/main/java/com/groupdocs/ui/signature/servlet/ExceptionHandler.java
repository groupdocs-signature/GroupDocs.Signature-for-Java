package com.groupdocs.ui.signature.servlet;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.groupdocs.ui.model.response.ExceptionEntity;
import com.groupdocs.ui.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for handling {@link com.groupdocs.ui.exception.TotalGroupDocsException}
 */
@WebServlet("/error-handler")
public class ExceptionHandler extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Exception exception = (Exception)req.getAttribute("javax.servlet.error.exception");

        ExceptionEntity exceptionEntity = new ExceptionEntity();
        exceptionEntity.setMessage(exception.getMessage());
        if (logger.isDebugEnabled()) {
            exception.printStackTrace();
            exceptionEntity.setException(exception);
        }
        logger.error(exception.getCause() != null? exception.getCause().getLocalizedMessage() : exception.getMessage());

        Utils.setContentType(resp, MediaType.JSON_UTF_8.toString());
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        resp.getWriter().write(new Gson().toJson(exceptionEntity));
    }
}
