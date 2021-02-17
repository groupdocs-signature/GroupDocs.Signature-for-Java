package com.groupdocs.signature.examples.advanced_usage.documentpreview;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.ProcessLog;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.examples.Constants;
import com.groupdocs.signature.exception.GroupDocsSignatureException;

public class GetDocumentProcessHistoryAdvanced
{
    /**
     * <p>
     * Get document form fields and signatures information 
     * </p>
     */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GetDocumentProcessHistoryAdvanced : Get advanced document process history\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_HISTORY;

        final Signature signature = new Signature(filePath);
        try /*JAVA: was using*/
        {
            IDocumentInfo documentInfo = signature.getDocumentInfo();
            // display document process history information
            System.out.print("Document Process logs information: count = "+documentInfo.getProcessLogs().size());
            for (ProcessLog processLog : documentInfo.getProcessLogs())
            {
                System.out.print(" - operation ["+processLog.getType()+"}] on "+processLog.getDate().toString()+"}. Succedded/Failed "+processLog.getSucceeded()+"/"+processLog.getFailed()+". Message: "+processLog.getMessage()+" : ");
                if (processLog.getSignatures() != null)
                {
                    for (BaseSignature logSignature : processLog.getSignatures())
                    {
                        System.out.print("\t\t -"+logSignature.getSignatureType()+" #"+logSignature.getSignatureId()+" at "+logSignature.getTop()+" x "+logSignature.getLeft()+" pos;");
                    }
                }
            }
        } catch (Exception e){
            throw new GroupDocsSignatureException(e.getMessage());
        }

    }
}
