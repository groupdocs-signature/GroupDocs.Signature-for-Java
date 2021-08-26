package com.groupdocs.signature.examples.advanced_usage.documentpreview;

import com.groupdocs.signature.Signature;
import com.groupdocs.signature.SignatureSettings;
import com.groupdocs.signature.domain.ProcessLog;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;


public class GetDocumentSignaturesInfo
{
    /**
     * <p>
     * Get document form fields and signatures information
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GetDocumentSignaturesInfo : Get document signatures information\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SIGNED_MULTI;
        SignatureSettings signatureSettings = new SignatureSettings();
        signatureSettings.setShowDeletedSiganturesInfo(false);
        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            IDocumentInfo documentInfo = signature.getDocumentInfo();

            // display all document signatures information without deleted ones
            System.out.print("Document actual Signatures : "+documentInfo.getSignatures().size());
            for (BaseSignature baseSignature : documentInfo.getSignatures())
            {
                System.out.print(
                        " - #"+baseSignature.getSignatureId()+": Type: "+baseSignature.getSignatureType()+" Location: "+baseSignature.getLeft()+"x"+baseSignature.getTop()+". "
                                + "Size: "+baseSignature.getWidth()+"x"+baseSignature.getHeight()+". "
                                + "CreatedOn/ModifiedOn: "+baseSignature.getCreatedOn()+" / "+baseSignature.getModifiedOn());
            }
            // display document process history information
            System.out.print("Document Process logs information: count = "+documentInfo.getProcessLogs().size());
            for (ProcessLog processLog : documentInfo.getProcessLogs())
            {
                System.out.print(" - operation ["+processLog.getType()+"] on {processLog.Date.ToShortDateString()}. Succedded/Failed {processLog.Succeeded}/{processLog.Failed}. Message: {processLog.Message} : ");
                if (processLog.getSignatures() != null)
                {
                    for (BaseSignature logSignature : processLog.getSignatures())
                    {
                        System.out.print("\t\t -"+logSignature.getSignatureType()+" #"+logSignature.getSignatureId()+" at "+logSignature.getTop()+" x "+logSignature.getLeft()+" pos;");
                    }
                }
            }
        }catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }

    }
}
