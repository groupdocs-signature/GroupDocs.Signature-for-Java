package com.groupdocs.signature.examples.advanced_usage.documentpreview;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.options.loadoptions.LoadOptions;

import java.nio.file.Paths;

public class GetCertificateInfoAdvanced
{
    /**
     * <p>
     * Get Digital Certificates information
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GetCertificateInfoAdvanced : Get Digital Certificates information\n");

        // The path to certificate.
        String certificatePath = Constants.CertificatePfx;
        LoadOptions loadOptions = new LoadOptions();
        loadOptions.setPassword("1234567890");

        final Signature signature = new Signature(certificatePath, loadOptions);
        try /*JAVA: was using*/
        {
            IDocumentInfo documentInfo = signature.getDocumentInfo();
            System.out.print("\nCertificate properties " + Paths.get(certificatePath).getFileName().toString() + ":");
            System.out.print("\n - format : " + documentInfo.getFileType().getFileFormat());
            System.out.print("\n - extension : " + documentInfo.getFileType().getExtension());
            System.out.print("\n - size : " + documentInfo.getSize());
            System.out.print("\n - page count : " + documentInfo.getPageCount());

            // display document MetaData signatures information
            System.out.print("\nCertificate information:");
            for (MetadataSignature metadataSignature : documentInfo.getMetadataSignatures())
            {
                System.out.print("\n - Name: " + metadataSignature.getName() + " Value: " + metadataSignature.getValue() + " Type: " + metadataSignature.getType());
            }
        }
        finally { if (signature != null) (signature).dispose(); }
    }
}
