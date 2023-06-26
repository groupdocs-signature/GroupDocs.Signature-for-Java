package com.groupdocs.ui.signature;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@SpringBootTest
public class SignatureControllerTest {
    MockMvc mvc;

    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    SignatureController controller;


    public void setUp() throws Exception {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/templates/");
        viewResolver.setSuffix(".html");

        this.mvc = standaloneSetup(this.controller).setViewResolvers(viewResolver).build();
    }

    @Test
    public void getView()  throws Exception {
        mvc.perform(get("/signature")).andExpect(status().isOk()).andExpect(view().name("signature"));
    }

    public void loadFileTree() {
    }

    public void loadDocumentDescription() {
    }

    public void loadDocumentPage() {
    }

    public void downloadDocument() {
    }

    public void uploadDocument() {
    }

    public void loadSignatureImage() {
    }

    public void signDigital() {
    }

    public void signImage() {
    }

    public void signStamp() {
    }

    public void signOptical() {
    }

    public void signText() {
    }

    public void saveImage() {
    }

    public void saveStamp() {
    }

    public void saveOpticalCode() {
    }

    public void saveText() {
    }
}