package com.groupdocs.ui.signature.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
import static com.google.common.net.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;

/**
 * Configure CORS
 */
public class CORSServlet extends HttpServlet {

    protected void setControlHeader(HttpServletResponse resp) {
        resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // set CORS headers
        resp.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "GET");
        resp.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "POST");
        resp.setHeader(ACCESS_CONTROL_ALLOW_METHODS, "OPTIONS");
        resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        resp.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, "X-Requested-With,Content-Type,Accept,Origin");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
