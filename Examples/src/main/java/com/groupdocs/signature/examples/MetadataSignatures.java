package com.groupdocs.signature.examples;

import java.util.Date;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignatures;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.internal.c.a.ms.lang.Operators;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.metadatasearch.PdfSearchMetadataOptions;
import com.groupdocs.signature.options.metadatasignature.PdfMetadataSignOptions;
import com.groupdocs.signature.options.saveoptions.SaveOptions;


public class MetadataSignatures {
	
	public static void signPDFWithMetadataSignOptions(String fileName) throws Throwable{
		//ExStart:signPDFWithMetadataSignOptions
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		
		// setup options with text of signature
		PdfMetadataSignOptions signMetadataOptions = new PdfMetadataSignOptions();
		// Specify different Metadata Signatures and add them to options sigature collection
		// setup Author property
		PdfMetadataSignature mdSign_Author = new PdfMetadataSignature("Author", "Mr.Scherlock Holmes");
		signMetadataOptions.getMetadataSignatures().add(mdSign_Author);
		// setup data of document id
		PdfMetadataSignature mdSign_DocId = new PdfMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
		signMetadataOptions.getMetadataSignatures().add(mdSign_DocId);
		// setup data of sign date
		PdfMetadataSignature mdSign_Date = new PdfMetadataSignature("SignDate", new Date(), "pdf");
		signMetadataOptions.getMetadataSignatures().add(mdSign_Date);
		
		// save option		
		SaveOptions saveOptions = new SaveOptions();
	    saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signMetadataOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPDFWithMetadataSignOptions
	}
	
	public static void signPDFWithStandardMetadataSignatures(String fileName) throws Throwable{
		//ExStart:signPDFWithStandardMetadataSignatures
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		PdfMetadataSignOptions signOptions = new PdfMetadataSignOptions();
		// Using standard Pdf Metadata Signatures with new values				
		MetadataSignature[] signatures = new MetadataSignature[]
		{
		    PdfMetadataSignatures.getAuthor().deepClone("Mr.Scherlock Holmes"),
		    PdfMetadataSignatures.getCreateDate().deepClone(new Date()),
		    PdfMetadataSignatures.getMetadataDate().deepClone(new Date()),
		    PdfMetadataSignatures.getCreatorTool().deepClone("GD.Signature-Test"),
		    PdfMetadataSignatures.getModifyDate().deepClone(new Date()),
		    PdfMetadataSignatures.getProducer().deepClone("GroupDocs-Producer"),
		    PdfMetadataSignatures.getEntry().deepClone("Signature"),
		    PdfMetadataSignatures.getKeywords().deepClone("GroupDocs, Signature, Metadata, Creation Tool"),
		    PdfMetadataSignatures.getTitle().deepClone("Metadata Example"),
		    PdfMetadataSignatures.getSubject().deepClone("Metadata Test Example"),
		    PdfMetadataSignatures.getDescription().deepClone("Metadata Test example description"),
		    PdfMetadataSignatures.getCreator().deepClone("GroupDocs.Signature"),
		};
		signOptions.getMetadataSignatures().addRange(signatures);
		
		// save option		
		SaveOptions saveOptions = new SaveOptions();
	    saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signPDFWithStandardMetadataSignatures
	}
	
	public static void searchMetadataSignatureInPDFDocuments(String fileName) throws Throwable{
		//ExStart:searchMetadataSignatureInPDFDocuments
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup search options
		PdfSearchMetadataOptions searchOptions = new PdfSearchMetadataOptions();
		  
		// search document
		SearchResult result = handler.search("SignedMetadata.pdf", searchOptions);
		// output signatures
		for (BaseSignature signature : result.getSignatures())
		{
		    PdfMetadataSignature metadataSignature = Operators.as(signature, PdfMetadataSignature.class);
		    if (metadataSignature != null)
		    {
		    	System.out.println("Pdf Metadata:"+metadataSignature.getTagPrefix()+":"+ metadataSignature.getName()+" = "+ metadataSignature.toString());
		    }
		}
		//ExEnd:searchMetadataSignatureInPDFDocuments
	}
}
