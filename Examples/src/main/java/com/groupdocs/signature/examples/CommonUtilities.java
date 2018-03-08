package com.groupdocs.signature.examples;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.licensing.License;

public class CommonUtilities {
	// ExStart:commonutilities
	// Storage path\
	public static final String storagePath = (System.getProperty("user.dir") + "\\Data\\Storage\\");
	// License path
	public static final String licensePath = "E:\\GroupDocs.Total.Java.lic";
	// Output path
	public static final String outputPath = (System.getProperty("user.dir") + "\\Data\\Output\\");
	// Output image path
	public static final String outputImagePath = (System.getProperty("user.dir") + "\\Data\\Output\\Images\\");
	//Certificates path
	public static final String certificatePath = (System.getProperty("user.dir") + "\\Data\\Certificates\\");
	// Image path
	public static final String imagePath = (System.getProperty("user.dir") + "\\Data\\Images\\");
	// ExEnd:commonutilities

	public static String getImagesPath(String imageName) {
		return imagePath + imageName;
	}
	public static String getOutputPath(String fileName) {
		return outputPath + fileName;
	}

	public static String getStoragePath(String outputFileName) {
		return storagePath + outputFileName;
	}
	public static String getCertificatePath(String fileName){
		return certificatePath + fileName;
	}
	public static void applyLicense() throws IOException {
		// ExStart:applyLicense
		License license = new License();
		// Set license
		license.setLicense(licensePath);
		// ExEnd:applyLicense
	}

	public static void applyLicenseFromStream() throws IOException {
		// ExStart:applyLicenseFromStream
		// Obtain license stream
		InputStream licenseStream = new FileInputStream(licensePath);
		// Instantiate GroupDocs.Signature handler
		License license = new License();
		// setup license
		license.setLicense(licenseStream);
		// ExEnd:applyLicenseFromStream
	}

	public static SignatureConfig getConfiguration() {
		// ExStart:getConfiguration
		try {
			SignatureConfig signConfig = new SignatureConfig(); 
			signConfig.setStoragePath(storagePath);
			signConfig.setOutputPath(outputPath);
			signConfig.setImagesPath(outputImagePath);
			signConfig.setCertificatesPath(certificatePath);
			return signConfig;

		} catch (Exception exp) {
			System.out.println("Exception: " + exp.getMessage());
			exp.printStackTrace();
			return null;
		}
		// ExEnd:getConfiguration
	}
}
