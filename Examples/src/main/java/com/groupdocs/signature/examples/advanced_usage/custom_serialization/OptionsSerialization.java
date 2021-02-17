package com.groupdocs.signature.examples.advanced_usage.custom_serialization;


import com.google.gson.*;
import com.google.gson.stream.JsonReader;
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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String serialized = gson.toJson(collection);;

        GsonBuilder builder = new GsonBuilder();
        Object[] converters = { new SignOptionsJsonConverter(), new BarcodeTypeJsonConverter(), new QrCodeTypeJsonConverter() };

        builder.registerTypeAdapter(SignOptions.class, converters);
        Gson gsonAdapt = builder.create();


        SignOptions deserialized = gsonAdapt.fromJson(serialized, SignOptions.class);

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

    abstract static class JsonCreationAdapter<T> //extends JsonConverter
    {
             

        protected abstract T create(Type objectType, JsonObject jObject);

        public /*override*/ boolean canConvert(Type objectType, Class<T> clazz)
        {
            return clazz.getClass().isAssignableFrom(objectType.getClass());
        }

        public /*override*/ Object readJson(JsonReader reader, Type objectType, Object existingValue, JsonSerializer<T> serializer)
        {
           // JsonObject jObject = JObject.Load(reader);
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(reader);
            T target = create(objectType, jsonElement.getAsJsonObject());
            //serializer.serialize(jObject.CreateReader(), target);
            return target;
        }

        protected final int getSignatureType(JsonObject  jObject)
        {
            int result = SignatureType.Unknown;

            if (result == SignatureType.Unknown)
            {
                boolean hasItem = jObject.has("EncodeType");
                if (hasItem)
                {
                    JsonElement encodeType = jObject.get("EncodeType");
                    if (encodeType!=null)
                    {
                        String encodeTypeName = encodeType.toString();
                        if (encodeTypeName != null && !encodeTypeName.isEmpty())
                        {
                            for (BarcodeType item : BarcodeTypes.getAllTypes())
                            {
                                if (item.getTypeName() == encodeTypeName)
                                {
                                    result = SignatureType.Barcode;
                                    break;
                                }
                            }
                            for (QrCodeType item : QrCodeTypes.getAllTypes())
                            {
                                if (item.getTypeName() == encodeTypeName)
                                {
                                    result = SignatureType.QrCode;
                                    break;
                                }
                            }
                        }
                    }
                }
            }                
            if (result == SignatureType.Unknown)
            {
                boolean hasItem = jObject.has("Password");
                result = hasItem ? SignatureType.Digital : SignatureType.Unknown;
            }
            if (result == SignatureType.Unknown)
            {
                boolean hasItem = jObject.has("ImageFilePath");
                result = hasItem ? SignatureType.Image : SignatureType.Unknown;
            }
            if (result == SignatureType.Unknown)
            {
                boolean hasItem = jObject.has("Font");
                result = hasItem ? SignatureType.Text : SignatureType.Unknown;
            }

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

    static class BarcodeTypeJsonConverter extends JsonCreationAdapter<BarcodeType>
    {
        protected /*override*/ BarcodeType create(Type objectType, JsonObject  jObject)
        {
            BarcodeType result = getBarcodeType(jObject);

            return result;
        }
    }

    static class QrCodeTypeJsonConverter extends JsonCreationAdapter<QrCodeType>
    {
        protected /*override*/ QrCodeType create(Type objectType, JsonObject  jObject)
        {
            QrCodeType result = getQrCodeType(jObject);

            return result;
        }
    }

    static class SignOptionsJsonConverter extends JsonCreationAdapter<SignOptions>
    {
        protected /*override*/ SignOptions create(Type objectType, JsonObject  jObject)
        {
            SignOptions result = null;
            int signatureType = getSignatureType(jObject);

            // check SignatureType
            // check for Barcode options
            if (signatureType == SignatureType.Barcode)
            {
                result = new BarcodeSignOptions();
            }
            // check for QrCode options
            if (result == null && signatureType == SignatureType.QrCode)
            {
                result = new QrCodeSignOptions();
            }
            // check for digital options
            if (result == null && signatureType == SignatureType.Digital)
            {
                result = new DigitalSignOptions();
            }
            // check for text options
            if (result == null && signatureType == SignatureType.Text)
            {
                result = new TextSignOptions();
            }
            // check for image options
            if (result == null && signatureType == SignatureType.Image)
            {
                result = new ImageSignOptions();
            }
            // check for stamp options
            if (result == null && signatureType == SignatureType.Stamp)
            {
                result = new StampSignOptions();
            }

            return result;
        }
    }

}



