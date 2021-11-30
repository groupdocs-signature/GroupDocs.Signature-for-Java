package com.groupdocs.signature.examples.advanced_usage.custom_serialization;



import com.google.gson.*;
import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.SignResult;
import com.groupdocs.signature.domain.barcodes.BarcodeType;
import com.groupdocs.signature.domain.barcodes.BarcodeTypes;
import com.groupdocs.signature.domain.enums.DashStyle;
import com.groupdocs.signature.domain.enums.HorizontalAlignment;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.enums.VerticalAlignment;
import com.groupdocs.signature.domain.qrcodes.QrCodeType;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.PagesSetup;
import com.groupdocs.signature.options.sign.*;
import org.json.JSONObject;

import java.awt.*;
import java.io.File;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class OptionsSerialization
{

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Quick Start] # Options serialization and deserialization\n");

        List<SignOptions> collection = new ArrayList<SignOptions>();

        TextSignOptions textSignOptions = getTextSignOptions();


        collection.add(textSignOptions);

        ImageSignOptions imageSignOptions = getImageSignOptions();
        collection.add(imageSignOptions);

        DigitalSignOptions digitalSignOptions = getDigitalSignOptions();
        collection.add(digitalSignOptions);

        BarcodeSignOptions barcodeSignOptions = getBarcodeSignOptions();
        collection.add(barcodeSignOptions);

        QrCodeSignOptions qrCodeSignOptions = getQrCodeSignOptions();
        collection.add(qrCodeSignOptions);




        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //String serialized = gson.toJson(collection);;


            String json = "";
            boolean first = true;
            for(SignOptions option : collection ){
               JSONObject obj = new JSONObject(option);
                String serialized = obj.toString();
                if(first) {
                    json+=serialized;
                    first=false;
                } else {
                    json+=","+serialized;
                }
            }
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(SignOptions.class, new SignOptionsJsonConverter());

        Gson gsonAdapt = builder.create();


        SignOptions deserialized = gsonAdapt.fromJson(json, SignOptions.class);

        //System.out.print(deserialized.size());

        if (deserialized != null)
        {
            // The path to the documents directory.
            String filePath = Constants.SAMPLE_PDF;
            String fileName = Paths.get(filePath).getFileName().toString();
            String outputFilePath = new File(Constants.OutputPath, "OptionsSerialization\\"+ fileName).getPath();

            final Signature signature = new Signature(filePath);
            try /*JAVA: was using*/
            {
                // sign document to file
                SignResult signResult = signature.sign(outputFilePath, deserialized);

                System.out.print("\nSource document signed successfully with {signResult.Succeeded.Count} signature(s).\nFile saved at {outputFilePath}.");
            } catch (Exception e){
                throw new GroupDocsSignatureException(e.getMessage());
            }

        }
    }

    //>>>>>>>> #region  Options

    private static BarcodeSignOptions getBarcodeSignOptions()
    {
        BarcodeSignOptions result = new BarcodeSignOptions("123456789012", BarcodeTypes.Code39Standard);
        // alignment settings
        result.setLeft(100);
        result.setTop(500);
        result.setWidth(200);
        result.setHeight(120);
        result.setAllPages(true);
        result.setPageNumber(1);
        PagesSetup pagesSetup = new PagesSetup();
        pagesSetup.setFirstPage(true);
        pagesSetup.setLastPage(false);
        pagesSetup.setOddPages(true);
        pagesSetup.setEvenPages(false);
        result.setPagesSetup(pagesSetup)
        /* Exception occured */;
        result.setHorizontalAlignment(HorizontalAlignment.Right);
        result.setVerticalAlignment(VerticalAlignment.Top);
        // border settings
        result.getBorder().setColor(Color.red);
        result.getBorder().setDashStyle(DashStyle.DashLongDash);
        result.getBorder().setTransparency(0.8);
        result.getBorder().setWeight(2);
        result.getBorder().setVisible(true);
        // background settings
        result.getBackground().setColor(Color.yellow);
        result.getBackground().setTransparency(0.5);
        result.setForeColor(Color.green);

        return result;
    }
    private static QrCodeSignOptions getQrCodeSignOptions()
    {
        QrCodeSignOptions result = new QrCodeSignOptions("123456789012", QrCodeTypes.Aztec);
        // alignment settings
        result.setLeft(100);
        result.setTop(50);
        result.setWidth(200);
        result.setHeight(120);
        result.setAllPages(true);
        result.setPageNumber(1);
        PagesSetup pagesSetup = new PagesSetup();
        pagesSetup.setFirstPage(true);
        pagesSetup.setLastPage(false);
        pagesSetup.setOddPages(true);
        pagesSetup.setEvenPages(false);
        result.setPagesSetup(pagesSetup)
        /* Exception occured */;
        result.setHorizontalAlignment(HorizontalAlignment.Right);
        result.setVerticalAlignment(VerticalAlignment.Center);
        // border settings
        result.getBorder().setColor(Color.red);
        result.getBorder().setDashStyle(DashStyle.DashLongDash);
        result.getBorder().setTransparency(0.8);
        result.getBorder().setWeight(2);
        result.getBorder().setVisible(true);
        // background settings
        result.getBackground().setColor(Color.yellow);
        result.getBackground().setTransparency(0.5);
        result.setForeColor(Color.green);

        return result;
    }
    private static TextSignOptions getTextSignOptions()
    {
        TextSignOptions result = new TextSignOptions("John Smith");
        // alignment settings
        result.setLeft(100);
        result.setTop(50);
        result.setWidth(200);
        result.setHeight(120);
        result.setAllPages(true);
        result.setPageNumber(1);
        PagesSetup pagesSetup = new PagesSetup();
        pagesSetup.setFirstPage(true);
        pagesSetup.setLastPage(false);
        pagesSetup.setOddPages(true);
        pagesSetup.setEvenPages(false);
        result.setPagesSetup(pagesSetup)
        /* Exception occured */;
        result.setHorizontalAlignment(HorizontalAlignment.Left);
        result.setVerticalAlignment(VerticalAlignment.Top);
        // border settings
        result.getBorder().setColor(Color.red);
        result.getBorder().setDashStyle(DashStyle.DashLongDash);
        result.getBorder().setTransparency(0.8);
        result.getBorder().setWeight(2);
        result.getBorder().setVisible(true);
        // background settings
        result.getBackground().setColor(Color.yellow);
        result.getBackground().setTransparency(0.5);
        result.setForeColor(Color.green);

        return result;
    }
    private static ImageSignOptions getImageSignOptions()
    {
        String imagePath = Constants.ImageHandwrite;

        ImageSignOptions result = new ImageSignOptions(imagePath);
        // alignment settings
        result.setLeft(100);
        result.setTop(350);
        result.setWidth(200);
        result.setHeight(120);
        result.setAllPages(true);
        result.setPageNumber(1);
        PagesSetup pagesSetup = new PagesSetup();
        pagesSetup.setFirstPage(true);
        pagesSetup.setLastPage(false);
        pagesSetup.setOddPages(true);
        pagesSetup.setEvenPages(false);
        result.setPagesSetup(pagesSetup)
        /* Exception occured */;
        result.setHorizontalAlignment(HorizontalAlignment.Left);
        result.setVerticalAlignment(VerticalAlignment.Center);

        // border settings
        result.getBorder().setColor(Color.red);
        result.getBorder().setDashStyle(DashStyle.DashLongDash);
        result.getBorder().setTransparency(0.8);
        result.getBorder().setWeight(2);
        result.getBorder().setVisible(true);

        return result;
    }
    private static DigitalSignOptions getDigitalSignOptions()
    {
        String imagePath = Constants.ImageHandwrite;
        String certificatePath = Constants.CertificatePfx;
        String password = "1234567890";

        DigitalSignOptions result = new DigitalSignOptions(certificatePath, imagePath);
        result.setPassword(password);

        // alignment settings
        result.setLeft(100);
        result.setTop(550);
        result.setWidth(200);
        result.setHeight(120);
        result.setAllPages(true);
        result.setPageNumber(1);
        PagesSetup pagesSetup = new PagesSetup();
        pagesSetup.setFirstPage(true);
        pagesSetup.setLastPage(false);
        pagesSetup.setOddPages(true);
        pagesSetup.setEvenPages(false);
        result.setPagesSetup(pagesSetup)
        /* Exception occured */;
        result.setHorizontalAlignment(HorizontalAlignment.Left);
        result.setVerticalAlignment(VerticalAlignment.Bottom);

        // border settings
        result.getBorder().setColor(Color.red);
        result.getBorder().setDashStyle(DashStyle.DashLongDash);
        result.getBorder().setTransparency(0.8);
        result.getBorder().setWeight(2);
        result.getBorder().setVisible(true);

        return result;
    }
    //<<<<<<<< #endregion

    static class SignOptionsJsonConverter implements JsonDeserializer<SignOptions> {
        @Override
        public SignOptions deserialize(JsonElement json, Type type,
                                       JsonDeserializationContext context) throws JsonParseException {

            SignOptions result = null;
            JsonObject jsonObject = json.getAsJsonObject();
            int signatureType = getSignatureType(jsonObject);

            // check SignatureType
            // check for Barcode options
            if (signatureType == SignatureType.Barcode) {
                result = new BarcodeSignOptions();
            }
            // check for QrCode options
            if (result == null && signatureType == SignatureType.QrCode) {
                result = new QrCodeSignOptions();
            }
            // check for digital options
            if (result == null && signatureType == SignatureType.Digital) {
                result = new DigitalSignOptions();
            }
            // check for text options
            if (result == null && signatureType == SignatureType.Text) {
                result = new TextSignOptions();
            }
            // check for image options
            if (result == null && signatureType == SignatureType.Image) {
                result = new ImageSignOptions();
            }
            // check for stamp options
            if (result == null && signatureType == SignatureType.Stamp) {
                result = new StampSignOptions();
            }

            return result;

        }

        protected final int getSignatureType(JsonObject jObject) {
            int result = SignatureType.Unknown;

            if (result == SignatureType.Unknown) {
                boolean hasItem = jObject.has("encodeType");
                if (hasItem) {
                    JsonElement encodeType = jObject.get("encodeType");
                    if (encodeType != null) {
                        String encodeTypeName = encodeType.toString();
                        if (encodeTypeName != null && !encodeTypeName.isEmpty()) {
                            for (BarcodeType item : BarcodeTypes.getAllTypes()) {
                                if (item.getTypeName() == encodeTypeName) {
                                    result = SignatureType.Barcode;
                                    break;
                                }
                            }
                            for (QrCodeType item : QrCodeTypes.getAllTypes()) {
                                if (item.getTypeName() == encodeTypeName) {
                                    result = SignatureType.QrCode;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (result == SignatureType.Unknown) {
                boolean hasItem = jObject.has("password");
                result = hasItem ? SignatureType.Digital : SignatureType.Unknown;
            }
            if (result == SignatureType.Unknown) {
                boolean hasItem = jObject.has("imageFilePath");
                result = hasItem ? SignatureType.Image : SignatureType.Unknown;
            }
            if (result == SignatureType.Unknown) {
                boolean hasItem = jObject.has("font");
                result = hasItem ? SignatureType.Text : SignatureType.Unknown;
            }

            return result;

        }

    }
    static class BarcodeTypeJsonConverter implements JsonDeserializer<BarcodeType>
    {
        @Override
        public BarcodeType deserialize(JsonElement json, Type type,
                                       JsonDeserializationContext context) throws JsonParseException {

            JsonObject jsonObject = json.getAsJsonObject();
            BarcodeType result = getBarcodeType(jsonObject);

            return result;
        }
        protected final BarcodeType getBarcodeType(JsonObject  jObject)
        {
            BarcodeType result = null;

            boolean hasItem = jObject.has("TypeName");
            if (hasItem)
            {
                JsonElement encodeType = jObject.get("TypeName");
                if (encodeType != null)
                {
                    String encodeTypeName = encodeType.toString();
                    if (encodeTypeName != null && !encodeTypeName.isEmpty())
                    {
                        for (BarcodeType item : BarcodeTypes.getAllTypes())
                        {
                            if (item.getTypeName() == encodeTypeName)
                            {
                                result = item;
                                break;
                            }
                        }
                    }
                }
            }

            return result;
        }

    }

    static class QrCodeTypeJsonConverter implements JsonDeserializer<QrCodeType>
    {
        @Override
        public QrCodeType deserialize(JsonElement json, Type type,
                                      JsonDeserializationContext context) throws JsonParseException {

            JsonObject jsonObject = json.getAsJsonObject();
            QrCodeType result = getQrCodeType(jsonObject);

            return result;
        }

        protected final QrCodeType getQrCodeType(JsonObject jObject)
        {
            QrCodeType result = null;

            boolean hasItem = jObject.has("TypeName");
            if (hasItem)
            {
                JsonElement encodeType = jObject.get("TypeName");
                if (encodeType != null)
                {
                    String encodeTypeName = encodeType.toString();
                    if (encodeTypeName != null && !encodeTypeName.isEmpty())
                    {
                        for (QrCodeType item : QrCodeTypes.getAllTypes())
                        {
                            if (item.getTypeName() == encodeTypeName)
                            {
                                result = item;
                                break;
                            }
                        }
                    }
                }
            }

            return result;
        }

    }

}



