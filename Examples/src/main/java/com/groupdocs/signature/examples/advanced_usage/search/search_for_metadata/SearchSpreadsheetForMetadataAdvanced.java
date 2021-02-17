package com.groupdocs.signature.examples.advanced_usage.search.search_for_metadata;


import com.groupdocs.signature.Signature;
import com.groupdocs.signature.domain.enums.SignatureType;
import com.groupdocs.signature.domain.signatures.metadata.SpreadsheetMetadataSignature;
import com.groupdocs.signature.examples.Constants;
import org.joda.time.LocalDateTime;

import java.util.List;

public class SearchSpreadsheetForMetadataAdvanced {
    /**
    * Search document for metadata signature
    */
    public static void run() throws Exception
    {
        System.out.print("\n--------------------------------------------------------------------------------------------------------------------");
        System.out.print("[Example Advanced Usage] # SearchSpreadsheetForMetadataAdvanced : Search Spreadsheet document for metadata signature(s)\n");

        // The path to the documents directory.
        String filePath = Constants.SAMPLE_SPREADSHEET_SIGNED_METADATA;
        Signature signature = new Signature(filePath);
        {
            // search for signatures in document
            List<SpreadsheetMetadataSignature> signatures = signature.search(SpreadsheetMetadataSignature.class,SignatureType.Metadata);
            // try to get each Spreadsheet signature with proper data type added in Basic usage example SignSpreadsheetWithMetadata
            // See example SignSpreadsheetWithMetadata with added various data type values to signatures
            try
            {
                for(SpreadsheetMetadataSignature mdSign : signatures){
                    switch (mdSign.getName()){
                        case "Author":
                            System.out.print("\t["+mdSign.getName()+"] as String = "+mdSign.toString());
                            continue;
                        case "CreatedOn":
                            System.out.print("\t["+mdSign.getName()+"] as String = "+ mdSign.getCreatedOn().toString());
                            continue;
                        case "DocumentId":
                            System.out.print("\t["+mdSign.getName()+"] as Integer = "+mdSign.toInteger());
                            continue;
                        case "SignatureId":
                            System.out.print("\t["+mdSign.getName()+"] as Double = "+mdSign.toDouble());
                            continue;
                        case "Amount":
                            System.out.print("\t["+mdSign.getName()+"] as Decimal = "+mdSign.toDouble());
                            continue;
                        case "Total":
                            System.out.print("\t["+mdSign.getName()+"] as Float = "+mdSign.toSingle());
                            continue;
                    }
                }
            }
            catch (Exception ex)
            {
                System.out.print("Error obtaining signature: "+ex.getMessage());
            }
        }
    }
}
