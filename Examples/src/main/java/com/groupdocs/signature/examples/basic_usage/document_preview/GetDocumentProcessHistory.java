package com.groupdocs.signature.examples.basic_usage.document_preview;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.ProcessLog;
import com.groupdocs.signature.domain.documentpreview.IDocumentInfo;
import com.groupdocs.signature.examples.Constants;

public class GetDocumentProcessHistory {

    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # GetDocumentProcessHistory : Get document process history\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_HISTORY;

        Signature signature = new Signature(filePath);

            IDocumentInfo documentInfo = signature.getDocumentInfo();
            // display document process history information
            System.out.print("Document Process logs information: count = "+documentInfo.getProcessLogs().size());
            for (ProcessLog processLog : documentInfo.getProcessLogs())
            {
                System.out.print(" - operation ["+processLog.getType()+"] on "+processLog.getDate()+". Succeeded/Failed "+processLog.getSucceeded()+"/"+processLog.getFailed()+". Message: "+processLog.getMessage());
            }

    }
}
