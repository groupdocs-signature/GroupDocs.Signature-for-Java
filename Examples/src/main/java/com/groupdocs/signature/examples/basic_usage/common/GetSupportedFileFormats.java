package com.groupdocs.signature.examples.basic_usage.common;


import com.groupdocs.signature.domain.documentpreview.FileType;

import java.util.List;

public class GetSupportedFileFormats {
    public static void run()
    {
        List<FileType> supportedFileTypes = FileType.getSupportedFileTypes();

        for (FileType fileType : supportedFileTypes){
        System.out.print("\n"+fileType.getExtension());
    }
}
}