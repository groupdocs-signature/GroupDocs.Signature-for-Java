package com.groupdocs.ui.signature.servlet;

import com.groupdocs.ui.config.GlobalConfiguration;
import com.groupdocs.ui.signature.service.SignatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signature")
public class SignatureViewServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(SignatureViewServlet.class);

    @Inject
    private GlobalConfiguration globalConfiguration;

    @Inject
    private SignatureService signatureService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // set http port
        globalConfiguration.getServer().setHttpPort(req.getServerPort());

        // set configuration properties
        req.setAttribute("globalConfiguration", globalConfiguration);
        logger.debug("signature config: {}", signatureService.getSignatureConfiguration());
        req.setAttribute("signatureConfiguration", signatureService.getSignatureConfiguration());

        // forward to signature page
        req.getRequestDispatcher("WEB-INF/view/signature.jsp").forward(req, resp);
    }
}
