package com.groupdocs.ui.signature.resources;

import com.groupdocs.ui.common.config.GlobalConfiguration;
import com.groupdocs.ui.common.entity.web.FileDescriptionEntity;
import com.groupdocs.ui.common.entity.web.LoadDocumentEntity;
import com.groupdocs.ui.common.entity.web.PageDescriptionEntity;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentPageRequest;
import com.groupdocs.ui.common.entity.web.request.LoadDocumentRequest;
import com.groupdocs.ui.common.exception.TotalGroupDocsException;
import com.groupdocs.ui.common.resources.Resources;
import com.groupdocs.ui.signature.config.SignatureConfiguration;
import com.groupdocs.ui.signature.config.SignatureConfigurationModel;
import com.groupdocs.ui.signature.entity.request.*;
import com.groupdocs.ui.signature.entity.web.SignatureDataEntity;
import com.groupdocs.ui.signature.entity.web.SignatureFileDescriptionEntity;
import com.groupdocs.ui.signature.entity.web.SignedDocumentEntity;
import com.groupdocs.ui.signature.entity.xml.OpticalXmlEntity;
import com.groupdocs.ui.signature.entity.xml.TextXmlEntity;
import com.groupdocs.ui.signature.service.*;
import com.groupdocs.ui.signature.util.directory.SignatureDirectory;
import com.groupdocs.ui.signature.views.Signature;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.groupdocs.ui.signature.util.SignatureType.IMAGE;
import static javax.ws.rs.core.MediaType.*;

/**
 * SignatureResources
 *
 * @author Aspose Pty Ltd
 */

@Path(value = "/signature")
public class SignatureResources extends Resources {

    private static final Logger logger = LoggerFactory.getLogger(SignatureResources.class);

    public static final String SIGNATURE_TYPE_PARAM = "signatureType";

    private final SaveSignatureService saveSignatureService;
    private SignatureService signatureService;
    private SignService signService;

    /**
     * Constructor
     *
     * @param globalConfiguration global configuration object
     * @throws UnknownHostException
     */
    public SignatureResources(GlobalConfiguration globalConfiguration) throws UnknownHostException {
        super(globalConfiguration);

        signatureService = new SignatureServiceImpl(globalConfiguration);
        signService = new SignServiceImpl(globalConfiguration);
        saveSignatureService = new SaveSignatureServiceImpl(globalConfiguration);
    }

    /**
     * Get and set signature page
     *
     * @return html view
     */
    @GET
    public Signature getView() {
        // initiate index page
        return new Signature(globalConfiguration, DEFAULT_CHARSET);
    }

    @GET
    @Path(value = "/loadConfig")
    @Produces(APPLICATION_JSON)
    public SignatureConfigurationModel loadConfig() {
        return SignatureConfigurationModel.createSignatureConfiguration(globalConfiguration.getSignature(), globalConfiguration.getCommon());
    }

    /**
     * Get files and directories
     */
    @POST
    @Path(value = "/loadFileTree")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<SignatureFileDescriptionEntity> loadFileTree(SignatureFileTreeRequest signatureFileTreeRequest) {
        return signatureService.getFileList(signatureFileTreeRequest);
    }

    /**
     * Get document description
     *
     * @return document description
     */
    @POST
    @Path(value = "/loadDocumentDescription")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public LoadDocumentEntity loadDocumentDescription(LoadDocumentRequest loadDocumentRequest) {
        return signatureService.getDocumentDescription(loadDocumentRequest);
    }

    /**
     * Get document page
     *
     * @return document page
     */
    @POST
    @Path(value = "/loadDocumentPage")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public PageDescriptionEntity loadDocumentPage(LoadDocumentPageRequest loadDocumentPageRequest) {
        return signatureService.loadDocumentPage(loadDocumentPageRequest);
    }

    /**
     * Download document
     *
     * @return document
     */
    @GET
    @Path(value = "/downloadDocument")
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadDocument(@QueryParam("path") String documentGuid,
                                 @Context HttpServletResponse response) throws IOException {
        downloadFile(response, documentGuid);
    }

    /**
     * Upload document
     *
     * @return uploaded document object (the object contains uploaded document guid)
     */
    @POST
    @Path(value = "/uploadDocument")
    @Produces(APPLICATION_JSON)
    @Consumes(MULTIPART_FORM_DATA)
    public SignatureFileDescriptionEntity uploadDocument(@FormDataParam("file") InputStream inputStream,
                                                         @FormDataParam("file") FormDataContentDisposition fileDetail,
                                                         @FormDataParam("url") String documentUrl,
                                                         @FormDataParam("rewrite") Boolean rewrite,
                                                         @FormDataParam("signatureType") String signatureType) {
        if (signatureType == null) {
            signatureType = "";
        }
        Map<String, Object> params = new HashMap<>();
        params.put(SIGNATURE_TYPE_PARAM, signatureType);
        // upload file
        String filePath = uploadFile(documentUrl, inputStream, fileDetail, rewrite, params);
        // create response
        SignatureFileDescriptionEntity uploadedDocument = new SignatureFileDescriptionEntity();
        uploadedDocument.setGuid(filePath);
        if (IMAGE.equals(signatureType)) {
            // get page image
            try {
                byte[] bytes = Files.readAllBytes(new File(uploadedDocument.getGuid()).toPath());
                // encode ByteArray into String
                String encodedImage = new String(Base64.getEncoder().encode(bytes));
                uploadedDocument.setImage(encodedImage);
            } catch (IOException ex) {
                throw new TotalGroupDocsException(ex.getMessage(), ex);
            }
        }
        return uploadedDocument;
    }

    @Override
    protected String getStoragePath(Map<String, Object> params) {
        String signatureType = (String) params.get(SIGNATURE_TYPE_PARAM);
        String pathFromSignatureType = signatureType == null ? "" : SignatureDirectory.getPathFromSignatureType(signatureType);
        SignatureConfiguration signatureConfiguration = globalConfiguration.getSignature();
        String documentStoragePath = StringUtils.isEmpty(pathFromSignatureType) ?
                signatureConfiguration.getFilesDirectory() :
                signatureConfiguration.getDataDirectory() + pathFromSignatureType;
        return documentStoragePath;
    }

    /**
     * Delete signature file from local storage
     */
    @POST
    @Path(value = "/deleteSignatureFile")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public void deleteSignatureFile(DeleteSignatureFileRequest deleteSignatureFileRequest) {
        signatureService.deleteSignatureFile(deleteSignatureFileRequest);
    }

    /**
     * Get fonts
     *
     * @return list of fonts names
     */
    @GET
    @Path(value = "/getFonts")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public List<String> getFonts() {
        return signatureService.getFonts();
    }

    /**
     * Get signature image stream - temporarlly workaround used until release of the GroupDocs.Signature 18.5, after release will be removed
     *
     * @return signature image
     */
    @POST
    @Path(value = "/loadSignatureImage")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public PageDescriptionEntity loadSignatureImage(LoadSignatureImageRequest loadSignatureImageRequest) {
        return signatureService.loadSignatureImage(loadSignatureImageRequest);
    }

    /**
     * Sign document with digital signature
     *
     * @return signed document info
     */
    @POST
    @Path(value = "/sign")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public SignedDocumentEntity sign(SignDocumentRequest signDocumentRequest) {
        return signService.sign(signDocumentRequest);
    }

    /**
     * Sign document with signatures and download result without saving
     *
     * @return signed document info
     */
    @POST
    @Path(value = "/downloadSigned")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_OCTET_STREAM)
    public void downloadSigned(SignDocumentRequest signDocumentRequest, @Context HttpServletResponse response) {
        List<SignatureDataEntity> signaturesData = signDocumentRequest.getSignaturesData();
        if (signaturesData == null || signaturesData.isEmpty()) {
            throw new IllegalArgumentException("Sign data is empty");
        }

        // get document path
        String documentGuid = signDocumentRequest.getGuid();
        String fileName = FilenameUtils.getName(documentGuid);
        // set response content info

        try (InputStream inputStream = signService.signByStream(signDocumentRequest);
             ServletOutputStream outputStream = response.getOutputStream()) {
            // download the document
            long length = IOUtils.copyLarge(inputStream, outputStream);
            addFileDownloadHeaders(response, fileName, length);
        } catch (Exception ex) {
            logger.error("Exception in downloading document", ex);
            throw new TotalGroupDocsException(ex.getMessage(), ex);
        }
    }

    /*
     * Save signature image stream
     * @return image signature
     */
    @POST
    @Path(value = "/saveImage")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public FileDescriptionEntity saveImage(SaveImageRequest saveImageRequest) {
        return saveSignatureService.saveImage(saveImageRequest);
    }

    /**
     * Save signature stamp
     *
     * @return stamp
     */
    @POST
    @Path(value = "/saveStamp")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public FileDescriptionEntity saveStamp(SaveStampRequest saveStampRequest) {
        return saveSignatureService.saveStamp(saveStampRequest);
    }

    /**
     * Save Optical signature data
     *
     * @return optical signature
     */
    @POST
    @Path(value = "/saveOpticalCode")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public OpticalXmlEntity saveOpticalCode(SaveOpticalCodeRequest saveOpticalCodeRequest) {
        return saveSignatureService.saveOpticalCode(saveOpticalCodeRequest);
    }

    /**
     * Save signature text
     *
     * @return text signature
     */
    @POST
    @Path(value = "/saveText")
    @Produces(APPLICATION_JSON)
    @Consumes(APPLICATION_JSON)
    public TextXmlEntity saveText(SaveTextRequest saveTextRequest) {
        return saveSignatureService.saveText(saveTextRequest);
    }

}