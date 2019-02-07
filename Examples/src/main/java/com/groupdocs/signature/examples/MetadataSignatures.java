package com.groupdocs.signature.examples;

import java.util.Date;
import java.util.List;

import com.groupdocs.signature.config.SignatureConfig;
import com.groupdocs.signature.domain.SearchResult;
import com.groupdocs.signature.domain.signatures.BaseSignature;
import com.groupdocs.signature.domain.signatures.metadata.CellsMetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.MetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.PdfMetadataSignatures;
import com.groupdocs.signature.domain.signatures.metadata.SlidesMetadataSignature;
import com.groupdocs.signature.domain.signatures.metadata.WordsMetadataSignature;
import com.groupdocs.signature.handler.SignatureHandler;
import com.groupdocs.signature.internal.c.a.ms.System.Decimal;
import com.groupdocs.signature.internal.c.a.ms.System.Guid;
import com.groupdocs.signature.internal.c.a.ms.lang.Operators;
import com.groupdocs.signature.options.OutputType;
import com.groupdocs.signature.options.metadatasearch.CellsSearchMetadataOptions;
import com.groupdocs.signature.options.metadatasearch.PdfSearchMetadataOptions;
import com.groupdocs.signature.options.metadatasearch.SlidesSearchMetadataOptions;
import com.groupdocs.signature.options.metadatasearch.WordsSearchMetadataOptions;
import com.groupdocs.signature.options.metadatasignature.CellsMetadataSignOptions;
import com.groupdocs.signature.options.metadatasignature.PdfMetadataSignOptions;
import com.groupdocs.signature.options.metadatasignature.SlidesMetadataSignOptions;
import com.groupdocs.signature.options.metadatasignature.WordsMetadataSignOptions;
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
	
	public static void signCellsWithMetadataSignOptions(String fileName) throws Throwable{
		//ExStart:signCellsWithMetadataSignOptions
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		CellsMetadataSignOptions signOptions = new CellsMetadataSignOptions();
	    // Specify different Metadata Signatures and add them to options sigature collection
	    // setup Author property
		CellsMetadataSignature mdSign_Author = new CellsMetadataSignature("Author", "Mr.Scherlock Holmes");
		signOptions.getMetadataSignatures().add(mdSign_Author);
	    // setup data of document id
		CellsMetadataSignature mdSign_DocId = new CellsMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
		signOptions.getMetadataSignatures().add(mdSign_DocId);
	    // setup data of sign date
		CellsMetadataSignature mdSign_Date = new CellsMetadataSignature("SignDate", new Date());
		signOptions.getMetadataSignatures().add(mdSign_Date);
	    // setup some integer value
		CellsMetadataSignature mdSign_Days = new CellsMetadataSignature("DocDays", 12345);
		signOptions.getMetadataSignatures().add(mdSign_Days);
	    // setup data of sign date
		CellsMetadataSignature mdSign_Koeff = new CellsMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
		signOptions.getMetadataSignatures().add(mdSign_Koeff);
		
		// save option		
		SaveOptions saveOptions = new SaveOptions();
	    saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signCellsWithMetadataSignOptions
	}
	
	public static void signWordsWithMetadataSignOptions(String fileName) throws Throwable{
		//ExStart:signWordsWithMetadataSignOptions
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		WordsMetadataSignOptions signOptions = new WordsMetadataSignOptions();
		    // Specify different Metadata Signatures and add them to options sigature collection
		    // setup Author property
		WordsMetadataSignature mdSign_Author = new WordsMetadataSignature("Author", "Mr.Scherlock Holmes");
		signOptions.getMetadataSignatures().add(mdSign_Author);
		    // setup data of document id
		WordsMetadataSignature mdSign_DocId = new WordsMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
		signOptions.getMetadataSignatures().add(mdSign_DocId);
		    // setup data of sign date
		WordsMetadataSignature mdSign_Date = new WordsMetadataSignature("SignDate", new Date());
		signOptions.getMetadataSignatures().add(mdSign_Date);
		    // setup some integer value
		WordsMetadataSignature mdSign_Days = new WordsMetadataSignature("DocDays", 12345);
		signOptions.getMetadataSignatures().add(mdSign_Days);
		    // setup data of sign date
		WordsMetadataSignature mdSign_Koeff = new WordsMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
		signOptions.getMetadataSignatures().add(mdSign_Koeff);
		
		// save option		
		SaveOptions saveOptions = new SaveOptions();
	    saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signWordsWithMetadataSignOptions
	}
	
	public static void signSlidesWithMetadataSignOptions(String fileName) throws Throwable{
		//ExStart:signSlidesWithMetadataSignOptions
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup options with text of signature
		SlidesMetadataSignOptions signOptions = new SlidesMetadataSignOptions();
		    // Specify different Metadata Signatures and add them to options sigature collection
		    // setup Author property
		SlidesMetadataSignature mdSign_Author = new SlidesMetadataSignature("Author", "Mr.Scherlock Holmes");
		signOptions.getMetadataSignatures().add(mdSign_Author);
		    // setup data of document id
		SlidesMetadataSignature mdSign_DocId = new SlidesMetadataSignature("DocumentId", java.util.UUID.randomUUID().toString());
		signOptions.getMetadataSignatures().add(mdSign_DocId);
		    // setup data of sign date
		SlidesMetadataSignature mdSign_Date = new SlidesMetadataSignature("SignDate", new Date());
		signOptions.getMetadataSignatures().add(mdSign_Date);
		    // setup some integer value
		SlidesMetadataSignature mdSign_Days = new SlidesMetadataSignature("DocDays", 12345);
		signOptions.getMetadataSignatures().add(mdSign_Days);
		    // setup data of sign date
		SlidesMetadataSignature mdSign_Koeff = new SlidesMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
		signOptions.getMetadataSignatures().add(mdSign_Koeff);
		
		// save option		
		SaveOptions saveOptions = new SaveOptions();
	    saveOptions.setOutputType(OutputType.String);
		saveOptions.setOutputFileName("signed_output");
		// sign document
		String signedPath = handler.sign(fileName, signOptions, saveOptions);
		System.out.println("Signed file path is: " + signedPath);
		//ExEnd:signSlidesWithMetadataSignOptions
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
		SearchResult result = handler.search(fileName, searchOptions);
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
	
	public static void searchMetadataSignatureInCellsDocuments(String fileName) throws Throwable{
		//ExStart:searchMetadataSignatureInCellsDocuments
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup search options
		CellsSearchMetadataOptions searchOptions = new CellsSearchMetadataOptions();
		// search document
		SearchResult result = handler.search(fileName, searchOptions);
		//foreach to while statements conversion
		for (BaseSignature signature : result.getSignatures())
		{
			CellsMetadataSignature metadataSignature = Operators.as(signature, CellsMetadataSignature.class);
		    if (metadataSignature != null)
		    {
		        System.out.print("Cells Metadata: "+metadataSignature.getName()+" = "+metadataSignature.toString() );
		    }
		}
		//ExEnd:searchMetadataSignatureInCellsDocuments
	}
	
	public static void searchMetadataSignatureInWordsDocuments(String fileName) throws Throwable{
		//ExStart:searchMetadataSignatureInWordsDocuments
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup search options
		WordsSearchMetadataOptions searchOptions = new WordsSearchMetadataOptions();
		// search document
		SearchResult result = handler.search(fileName, searchOptions);
		//foreach to while statements conversion
		for (BaseSignature signature : result.getSignatures())
		{
			WordsMetadataSignature metadataSignature = Operators.as(signature, WordsMetadataSignature.class);
		    if (metadataSignature != null)
		    {
		        System.out.print("Words Metadata: "+metadataSignature.getName()+" = "+metadataSignature.toString() );
		    }   
		}
		//ExEnd:searchMetadataSignatureInWordsDocuments
	}
	
	public static void searchMetadataSignatureInSlidesDocuments(String fileName) throws Throwable{
		//ExStart:searchMetadataSignatureInSlidesDocuments
		// setup Signature configuration 
		SignatureConfig signConfig = CommonUtilities.getConfiguration(); 
		// instantiating the conversion handler
		SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
		// setup search options
		SlidesSearchMetadataOptions searchOptions = new SlidesSearchMetadataOptions();		  
		// set if we need built-in signatures
		searchOptions.setIncludeBuiltinProperties(true);		  
		// search document
		SearchResult result = handler.search(fileName, searchOptions);
		
		//foreach to while statements conversion
		for (BaseSignature signature:result.getSignatures())
		{
			SlidesMetadataSignature metadataSignature = Operators.as(signature, SlidesMetadataSignature.class);
			if (signature != null)
			{
				System.out.print("Slides Metadata: " + metadataSignature.getName() + " = " + signature.toString() );
			}
		}
		//ExEnd:searchMetadataSignatureInSlidesDocuments
	}
}
