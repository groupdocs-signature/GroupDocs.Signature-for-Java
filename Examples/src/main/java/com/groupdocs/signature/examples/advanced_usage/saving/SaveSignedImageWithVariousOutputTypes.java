package com.groupdocs.signature.examples.advanced_usage.saving;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.qrcodes.QrCodeTypes;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;
import com.groupdocs.signature.options.saveoptions.imagessaveoptions.*;
import com.groupdocs.signature.options.sign.QrCodeSignOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaveSignedImageWithVariousOutputTypes {

    /**
     * Sign image document with qr-code signature and save it to special image output type
     */
    public static void run()
    {
        // The path to the documents directory.
        String filePath = Constants.SAMPLE_JPG;

        try {
            Signature signature = new Signature(filePath);
            QrCodeSignOptions signOptions = new QrCodeSignOptions("JohnSmith");
            signOptions.setEncodeType(QrCodeTypes.QR);
            signOptions.setLeft(100);
            signOptions.setTop(100);

            List<ImageSaveOptions> listSaveOptions = new ArrayList<ImageSaveOptions>();

            // create Bmp save options with advanced settings
            BmpSaveOptions bmpSaveOptions = new BmpSaveOptions();
            bmpSaveOptions.setAddMissingExtenstion(true);
            bmpSaveOptions.setCompression(BitmapCompression.Rgb);
            bmpSaveOptions.setHorizontalResolution(7);
            bmpSaveOptions.setVerticalResolution(7);
            bmpSaveOptions.setBitsPerPixel(16);
            bmpSaveOptions.setOverwriteExistingFiles(true);

            listSaveOptions.add(bmpSaveOptions);
                            // create Gif save options with advanced settings
            GifSaveOptions gifSaveOptions = new GifSaveOptions();
            gifSaveOptions.setBackgroundColorIndex((byte)2);
            gifSaveOptions.setColorResolution((byte) 7);
            gifSaveOptions.setDoPaletteCorrection(true);
            gifSaveOptions.setTrailer(true);
            gifSaveOptions.setInterlaced(false);
            gifSaveOptions.setPaletteSorted(true);
            gifSaveOptions.setPixelAspectRatio((byte) 24);
            gifSaveOptions.setAddMissingExtenstion(true);

            listSaveOptions.add(gifSaveOptions);

            // create Jpeg save options with advanced settings
            JpegSaveOptions jpegSaveOptions = new JpegSaveOptions();
            jpegSaveOptions.setAddMissingExtenstion(true);
            jpegSaveOptions.setBitsPerChannel((byte) 8);
            jpegSaveOptions.setColorType(JpegCompressionColorMode.Rgb);
            jpegSaveOptions.setComment("signed jpeg file");
            jpegSaveOptions.setCompressionType(JpegCompressionMode.Lossless);
            jpegSaveOptions.setQuality(100);
            jpegSaveOptions.setSampleRoundingMode(JpegRoundingMode.Extrapolate);

            listSaveOptions.add(jpegSaveOptions);

            // create png save options with advanced settings
            PngSaveOptions pngSaveOptions = new PngSaveOptions();
            pngSaveOptions.setBitDepth((byte) 8);
            pngSaveOptions.setColorType(PngColorType.Grayscale);
            pngSaveOptions.setCompressionLevel(9);
            pngSaveOptions.setFilterType(PngFilterType.Adaptive);
            pngSaveOptions.setProgressive(true);
            pngSaveOptions.setAddMissingExtenstion(true);

            listSaveOptions.add(pngSaveOptions);
            // create tiff save options with advanced settings
            TiffSaveOptions tiffSaveOptions = new TiffSaveOptions();
            tiffSaveOptions.setExpectedTiffFormat(TiffFormat.TiffNoCompressionBw);
            tiffSaveOptions.setAddMissingExtenstion(true);

            listSaveOptions.add(tiffSaveOptions);

            for (ImageSaveOptions saveOptions : listSaveOptions)
            {
                // set flag to overwrite existing files
                saveOptions.setOverwriteExistingFiles(true);
                // set flag to add missing extension automatically
                saveOptions.setAddMissingExtenstion(true);
                String outputFilePath = new File(Constants.OutputPath, "SaveSignedImageOutputType//sampleJPG2"+ saveOptions.getClass().getSimpleName().toString()).getPath();
                // sign document to file
                signature.sign(outputFilePath, signOptions, saveOptions);
                System.out.print("\nSource document signed successfully.\nFile saved at " + outputFilePath);
            }


    }catch(Exception e){
        throw new GroupDocsSignatureException(e.getMessage());
    }
}

}