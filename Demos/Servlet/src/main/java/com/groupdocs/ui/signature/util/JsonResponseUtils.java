package com.groupdocs.ui.signature.util;

import com.google.common.net.MediaType;
import com.google.gson.Gson;
import com.groupdocs.ui.util.Utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsonResponseUtils {

    /**
     * Convert the object to json and write it in response
     *
     * @param response http response
     * @param obj object for writing in response
     * @throws IOException
     */
    public static void writeJson(HttpServletResponse response, Object obj) throws IOException {
        Utils.setContentType(response, MediaType.JSON_UTF_8.toString());
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(new Gson().toJson(obj));
    }
}
