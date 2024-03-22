package com.groupdocs.signature.examples.advanced_usage.sign;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.extensions.signoptions.DigitalVBA;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.sign.DigitalSignOptions;
import com.groupdocs.signature.utils.common.Path;

public class SignSpreadsheetsVBAProject {
    /**
    * Sign Spreadsheet document with macro support and VBA Project in it
    */
    public static void run() throws Exception {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SignSpreadsheetsVBAProject : Sign Spreadsheet document with macro support and VBA Project in it\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_MACRO_SUPPORT;
        String certificatePath = Constants.CertificatePfx;
        String password = "1234567890";

        //Sign only VBA project
        String outputFilePath = Path.combine(Constants.OutputPath, "SignSpreadsheetsVBAProject", "OnlyVBAProject.xlsm");
        Signature signature = new Signature(filePath);
        {
            //Create digital signature options without digital certificate
            DigitalSignOptions signOptions = new DigitalSignOptions();
            //Add extension for signing VBA project digitally
            DigitalVBA digitalVBA = new DigitalVBA(certificatePath, password);
            //Set to true only for signing VBA project
            digitalVBA.setSignOnlyVBAProject(true);
            digitalVBA.setComments("VBA Comment");
            signOptions.getExtensions().add(digitalVBA);

            signature.sign(outputFilePath, signOptions);
        }

        //Sign SpreadSheet document and VBA project
        outputFilePath = Path.combine(Constants.OutputPath, "SignSpreadsheetsVBAProject", "DocumentAndVBAProject.xlsm");
        Signature signature1 = new Signature(filePath);
        {
            // setup digital signature options
            DigitalSignOptions signOptions = new DigitalSignOptions(certificatePath);
            signOptions.getSignature().setComments("Comment");
            signOptions.setPassword("1234567890");

            //Add extension for signing VBA project digitally
            DigitalVBA digitalVBA = new DigitalVBA(certificatePath, password);
            digitalVBA.setComments("VBA Comment");
            signOptions.getExtensions().add(digitalVBA);

            signature1.sign(outputFilePath, signOptions);
        }
    }
}
