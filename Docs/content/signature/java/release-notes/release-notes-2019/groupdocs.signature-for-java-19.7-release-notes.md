---
id: groupdocs-signature-for-java-19-7-release-notes
url: signature/java/groupdocs-signature-for-java-19-7-release-notes
title: GroupDocs.Signature for Java 19.7 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 19.7{{< /alert >}}

## Major Features

There are few new features, improvements and bug fixes in this regular release. Most features are related to support of djvu format for most service methods, implementation of serialization and encryption of custom data objects into Metadata signatures with ability to extract them back and specify custom serialization and data encryption. Also this release contains some internal security and licensing improvements.

*   Introduced ability to embed custom objects to Metadata Signature for Cells and Words Documents
*   Implemented support to embed custom objects to Metadata Signature for Slides Presentation Documents
*   Added support of custom serialization for Pdf Metadata Signature object
*   Implemented ability of custom data encryption and decryption for embedded objects into Metadata Signature for Pdf Documents
*   Internal improvements of error handling and code updates
*   Fixed data serialization issues with simple data type for QR and Metadata signature

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2024 | Implement ability to embed custom object to Slides Metadata Signature | New Feature |
| SIGNATURENET-1842 | Implement ability to embed custom object to Words Metadata Signature | New Feature |
| SIGNATURENET-1838 | Implement ability to embed custom object to Cells Metadata Signature | New Feature |
| SIGNATURENET-2014 | Implement support of .djvu file format for verification process | Improvement |
| SIGNATURENET-2013 | Implement ability to search files with .djvu format as image documents | Improvement |
| SIGNATURENET-2007 | Implement ability to sign files with .djvu format as image documents | Improvement |
| SIGNATURENET-1980 | Implement new method AddSignature for MetadataOptions | Improvement |
| SIGNATURENET-2020 | Fix exception for de-serialization of encrypted string values in Metadata Signatures | Bug |
| SIGNATURENET-2012 | SaveOptions.OutputFileName doesn't affect on result name of signed document | Bug |
| SIGNATURENET-2008 | PdfQRCodeSignature.GetData<DocumentSignature>() throws exception | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 19.7. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  Public classes **CellsMetadataSignature, SlidesMetadataSignature, WordsMetadataSignature** were extended with new public property **DataEncryption **of type **IDataEncryption**
    
    **DataEncryption property**
    
    ```java
    /**
     * <p>
     * Gets or sets implementation of {@link IDataEncryption} interface to encode and decode signature Value properties for string types and object instances.
     * </p>
     */
    public final IDataEncryption getDataEncryption();
    /**
     * <p>
     * Gets or sets implementation of {@link IDataEncryption} interface to encode and decode signature Value properties for string types and object instances.
     * </p>
     */
    public final void setDataEncryption(IDataEncryption value);
    ```
    
    and overloaded method **public T GetData<T>()**. These methods return object of type T over de-serialization and decryption from Metadata Value.
    
    **GetData<T>() method**
    
    ```java
    /**
     * <p>
     * Obtain object from Metadata Signature Value over deserialization.
     * </p>
     * @return Instance of T object
     * <p>{@code T}: Type of object to deserialize from Metadata value</p>
     */
    public final <T>  T getData(Class<T> typeOfT);
    /**
     * <p>
     * Obtain object from Metadata Signature Text over deserialization.
     * </p>
     * @return 
     * @param dataEncryption Set custom data encryption implementation
     * <p>{@code T}: Type of object to deserialize from Metadata Value</p>
     */
    public final <T>  T getData(Class<T> typeOfT, IDataEncryption dataEncryption);
    ```
    
    Custom data class **DocumentSignature:**  
    
    **Example of custom class**
    
    ```java
    public static class DocumentSignature
    {
        public String getVersion(){ return Version; }
        public void setVersion(String value){ Version = value; }
        // specify SkipSerialization attribute to skip this field on serialization
        @SkipSerializationAttribute()
        public String Version;
      
        public boolean isProcessed(){ return IsProcessed; }
        public void setProcessed(boolean value){ IsProcessed = value; }
        // specify SkipSerialization attribute to skip this field on serialization
        @SkipSerializationAttribute()
        public boolean IsProcessed;
      
        public String getID(){ return ID; }
        public void setID(String value){ ID = value; }
        @FormatAttribute(propertyName = "SignatureID")
        public String ID;
      
      
        public String getAuthor(){ return Author; }
        public void setAuthor(String value){ Author = value; }
        @FormatAttribute (propertyName = "Author")
        public String Author;
      
      
        public java.util.Date getSigned() { return Signed; }
        public void setSigned(java.util.Date value) { Signed = value; }
        @FormatAttribute (propertyName = "SignatureDate",propertyFormat = "yyyy-MM-dd")
        public java.util.Date Signed = new java.util.Date();
      
      
        public java.math.BigDecimal getDataFactor() { return DataFactor; }
        public void setDataFactor(java.math.BigDecimal value) { DataFactor = value; }
        @FormatAttribute (propertyName = "Factor", propertyFormat = "N2")
        public java.math.BigDecimal DataFactor = new java.math.BigDecimal(0.01);
    }
    ```
    
    Following example demonstrates signing Words document with Metadata signature with value of custom class **DocumentSignature **object:
    
    **Sign Words Document with custom objects in Metadata**
    
    ```java
    // setup key and passphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
      
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup options with text of signature
    WordsMetadataSignOptions signOptions = new WordsMetadataSignOptions();
      
    // create custom object
    DocumentSignature signature = new DocumentSignature();
    signature.setID(Guid.newGuid().toString());
    signature.setAuthor(System.getenv("USERNAME"));
    signature.setSigned(new java.util.Date());
    signature.setDataFactor(new java.math.BigDecimal("11.22"));
      
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    WordsMetadataSignature mdDocument = signOptions.addSignature("DocumentSignature", signature);
    // set encryption
    mdDocument.setDataEncryption(encryption);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("SignedMedataDataEncrypted.docx");
      
    // sign document
    String signedPath = handler.<String>sign("test.docx", signOptions, tmp0);
      
    System.out.print("Signed file path is: " + signedPath);
    ```
    
    Example how to retrieve signed Words document with **DocumentSignature **Metadata Value (see examples above how to sign Document with custom data objects)
    
    **Search custom object in Metadata Signature**
    
    ```java
    // setup key and pasphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
      
      
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
      
    // setup search options
    WordsSearchMetadataOptions searchOptions = new WordsSearchMetadataOptions();
      
    // search document
    SearchResult result = handler.search("SignedMedataDataEncrypted.docx", searchOptions);
    // output signatures
    java.util.List<WordsMetadataSignature> signatures = result.toList(WordsMetadataSignature.class);
    //foreach to while statements conversion
    Iterator tmp0 = ( signatures).iterator();
    while (tmp0.hasNext()){
    	WordsMetadataSignature signature = (WordsMetadataSignature) tmp0.next();
    	if (signature != null && signature.getName().equals("DocumentSignature")){
        	DocumentSignature docSignature = signature.<DocumentSignature>getData(DocumentSignature.class, encryption);
            if (docSignature != null){
            	System.out.print("Found DocumentSignature signature: #"+docSignature.getID()+". Author "+docSignature.getAuthor()+" from "+docSignature.getDataFactor()+". Factor: " +docSignature.getDataFactor() );
         	}
       	}
    }
    ```
    
    Following example demonstrates signing Slides document with Metadata signature with value of custom class **DocumentSignature **object:
    
    **Sign Slides Document with custom objects in Metadata**
    
    ```java
    // setup key and passphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
     
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup options with text of signature
    SlidesMetadataSignOptions signOptions = new SlidesMetadataSignOptions();
     
    // create custom object
    DocumentSignature signature = new DocumentSignature();
    signature.setID(Guid.newGuid().toString());
    signature.setAuthor(System.getenv("USERNAME"));
    signature.setSigned(new java.util.Date());
    signature.setDataFactor(new java.math.BigDecimal("11.22"));
     
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    SlidesMetadataSignature mdDocument = signOptions.addSignature("DocumentSignature", signature);
    // set encryption
    mdDocument.setDataEncryption(encryption);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("SignedMedataDataEncrypted.pptx");
     
    // sign document
    String signedPath = handler.<String>sign("test.pptx", signOptions, tmp0);
     
    System.out.print("Signed file path is: " + signedPath);
    ```
    
    Example how to retrieve signed Slides document with **DocumentSignature **Metadata Value (see examples above how to sign Document with custom data objects)
    
    **Search custom object in Metadata Signature**
    
    ```java
    // setup key and pasphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
     
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
    // setup search options
    SlidesSearchMetadataOptions searchOptions = new SlidesSearchMetadataOptions();
    // search document
    SearchResult result = handler.search("SignedMedataTextEncrypted.pptx", searchOptions);
    // output signatures
    java.util.List<SlidesMetadataSignature> signatures = result.toList(SlidesMetadataSignature.class);
    //foreach to while statements conversion
    Iterator tmp0 = ( signatures).iterator();
    while (tmp0.hasNext()){
    	SlidesMetadataSignature signature = (SlidesMetadataSignature) tmp0.next();
    	if (signature != null){
    		String strValue = signature.<String>getData(String.class, encryption);
    		System.out.print("Found Metadata signature original value is: " + signature.getValue().toString() + ". Encrypted value is: " + strValue);
    	}
    }
    ```
    
    Following example demonstrates signing Cells document with Metadata signature with value of custom class **DocumentSignature **object:
    
    **Sign Cells Document with custom objects in Metadata**
    
    ```java
    // setup key and passphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
     
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    // setup options with text of signature
    CellsMetadataSignOptions signOptions = new CellsMetadataSignOptions();
     
    // create custom object
    DocumentSignature signature = new DocumentSignature();
    signature.setID(Guid.newGuid().toString());
    signature.setAuthor(System.getenv("USERNAME"));
    signature.setSigned(new java.util.Date());
    signature.setDataFactor(new java.math.BigDecimal("11.22"));
     
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    CellsMetadataSignature mdDocument = signOptions.addSignature("DocumentSignature", signature);
    // set encryption
    mdDocument.setDataEncryption(encryption);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("SignedMedataDataEncrypted.xlsx");
     
    // sign document
    String signedPath = (String)handler.<String>sign("test.xlsx", signOptions, tmp0);
     
    System.out.print("Signed file path is: " + signedPath);
    ```
    
    Example how to retrieve signed Cells document with **DocumentSignature **Metadata Value (see examples above how to sign Document with custom data objects)
    
    **Search custom object in Metadata Signature**
    
    ```java
    // setup key and pasphrase
    String key = "1234567890";
    String salt = "1234567890";
    // create data encryption
    IDataEncryption encryption = new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, key, salt);
      
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
    // setup search options
    CellsSearchMetadataOptions searchOptions = new CellsSearchMetadataOptions();
     
    // search document
    SearchResult result = handler.search("SignedMedataDataEncrypted.xlsx", searchOptions);
    // output signatures
    java.util.List<CellsMetadataSignature> signatures = result.toList(CellsMetadataSignature.class);
    //foreach to while statements conversion
    Iterator tmp0 = ( signatures).iterator();
    while (tmp0.hasNext()){
    	CellsMetadataSignature signature = (CellsMetadataSignature) tmp0.next();
       	if (signature != null && signature.getName().equals("DocumentSignature")) {
       		DocumentSignature docSignature = signature.getData(DocumentSignature.class, encryption);
     		if (docSignature != null){
           		System.out.print("Found DocumentSignature signature: "+docSignature.getID()+". Author "+docSignature.getAuthor()+" from "+docSignature.getDataFactor()+". Factor: "+ docSignature.getDataFactor());
         	}
       	}
    }
    ```
    
      
    
2.  **GroupDocs.Signature.Options.WordsMetadataSignOptions**
    
    Public class **WordsMetadataSignOptions **was extended with new public method** AddSignature. **Method creates new Words Metadata Signature with passed arguments (name and value), adds signature to list of metadata signatures and returns newly created object as result.
    
    **AddSignature method**
    
    ```java
    /**
     * <p>
     * Creates new WordsMetadataSignature with passed arguments and adds it to collection.
     * </p>
     * @return Newly created signature that was added to MetadataSignatures collection
     * @param name The name of new metadata signature
     * @param value The value of new metadata signature
     */
    public final WordsMetadataSignature addSignature(String name, Object value)
    ```
    
    Following example demonstrates signing Words document with Metadata signature using this new method:
    
    **Sign Document with metadata signatures**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup options with text of signature
    WordsMetadataSignOptions signOptions = new WordsMetadataSignOptions();
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    signOptions.addSignature("Author", "Mr.Scherlock Holmes");
    // setup data of document id
    signOptions.addSignature("DocumentId", java.util.UUID.randomUUID());
    // setup data of sign date
    signOptions.addSignature("SignDate", new Date());
    // setup some integer value
    signOptions.addSignature("DocDays", 12345);
    // setup data of sign date
    signOptions.addSignature("SignKoeff", 2.345);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("Words_Documents_Metadata");
     
    // sign document
    String signedPath = handler.<String>sign("test.docx", signOptions, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
3.  **GroupDocs.Signature.Options.SlidesMetadataSignOptions**  
    Public class **SlidesMetadataSignOptions **was extended with new public method** AddSignature. **Method creates new Slides Metadata Signature with passed arguments (name and value), adds signature to list of metadata signatures and returns newly created object as result.
    
    **AddSignature method**
    
    ```java
    /**
     * <p>
     * Creates new SlidesMetadataSignature with passed arguments and adds it to collection.
     * </p>
     * @return Newly created signature that was added to MetadataSignatures collection
     * @param name The name of new metadata signature
     * @param value The value of new metadata signature
     */
    public final SlidesMetadataSignature addSignature(String name, Object value)
    ```
    
    Following example demonstrates signing Slides document with Metadata signature using this new method:
    
    **Sign Document with metadata signatures**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup options with text of signature
    SlidesMetadataSignOptions signOptions = new SlidesMetadataSignOptions();
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property       
    signOptions.addSignature("Author", "Mr.Scherlock Holmes");
    // setup data of document id       
    signOptions.addSignature("DocumentId",java.util.UUID.randomUUID());
    // setup data of sign date      
    signOptions.addSignature("SignDate", new Date());
    // setup some integer value      
    signOptions.addSignature("DocDays", 12345);
    // setup data of sign date
    signOptions.addSignature("SignKoeff", 2.345);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("Slides_Documents_Metadata");
     
    // sign document
    String signedPath = handler.<String>sign("test.pptx", signOptions, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
4.  **GroupDocs.Signature.Options.PdfMetadataSignOptions**  
    Public class **PdfMetadataSignOptions **was extended with new public method** AddSignature. **Method creates new Pdf Metadata Signature with passed arguments (name and value), adds signature to list of metadata signatures and returns newly created object as result.
    
    **AddSignature method**
    
    ```java
    /**
     * <p>
     * Creates new PdfMetadataSignature with passed arguments and adds it to collection.
     * </p>
     * @return Newly created signature that was added to MetadataSignatures collection
     * @param name The name of new metadata signature
     * @param value The value of new metadata signature
     */
    public final PdfMetadataSignature addSignature(String name, Object value)
    ```
    
    Following example demonstrates signing Pdf document with Metadata signature using this new method:
    
    **Sign Document with metadata signatures**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup options with text of signature
    PdfMetadataSignOptions signOptions = new PdfMetadataSignOptions();
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    signOptions.addSignature("Author", "Mr.Scherlock Holmes");
    // setup data of document id
    signOptions.addSignature("DocumentId", java.util.UUID.randomUUID());
    // setup data of sign date
    signOptions.addSignature("SignDate", new Date());
    // setup some integer value
    signOptions.addSignature("DocDays", 12345);
    // setup data of sign date
    signOptions.addSignature("SignKoeff", 2.345);
     
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("Pdf_Documents_Metadata");
     
    // sign document
    String signedPath = handler.<String>sign("test.pdf", signOptions, saveOptions);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
5.  **GroupDocs.Signature.Options.CellsMetadataSignOptions**  
    Public class **CellsMetadataSignOptions **was extended with new public method** AddSignature. **Method creates new Cells Metadata Signature with passed arguments (name and value), adds signature to list of metadata signatures and returns newly created object as result.
    
    **AddSignature method**
    
    ```java
    /**
     * <p>
     * Creates new CellsMetadataSignature with passed arguments and adds it to collection.
     * </p>
     * @return Newly created signature that was added to MetadataSignatures collection
     * @param name The name of new metadata signature
     * @param value The value of new metadata signature
     */
    @Public
    public final CellsMetadataSignature addSignature(String name, Object value);
    ```
    
    Following example demonstrates signing Cells document with Metadata signature using this new method:
    
    **Sign Document with metadata signatures**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup options with text of signature
    CellsMetadataSignOptions signOptions = new CellsMetadataSignOptions();
    // Specify different Metadata Signatures and add them to options sigature collection
    // setup Author property
    CellsMetadataSignature mdSign_Author = signOptions.addSignature("Author", "Mr.Scherlock Holmes");
    mdSign_Author.setDataEncryption(new SymmetricEncryption(SymmetricAlgorithmType.Rijndael, "12345", "12345"));
    // setup data of document id       
    signOptions.addSignature("DocumentId", java.util.UUID.randomUUID());
    // setup data of sign date       
    signOptions.addSignature("SignDate", new Date());
    // setup some integer value  
    signOptions.addSignature("DocDays", 12345);
    // setup data of sign date        
    signOptions.addSignature("SignKoeff", 2.345);
    SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("Cells_Documents_Metadata");
     
    // sign document
    String signedPath = handler.<String>sign("test.xlsx", signOptions, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
6.  **com.groupdocs.signature.domain.signatures.metadata.ImageMetadataSignature**  
    Public class **ImageMetadataSignature **was updated with constructor that expects identifier and value. Class supports any standard data types, same as methods to convert. Please carefully read Exif tags specifications to clarify what Id values are acceptable for your scenarios of using Image Metadata signature.
    
    **Image Metadata Signature class properties**
    
    ```java
    /**
     * <p>
     * Creates Image Metadata Signature with Id and value
     * </p>
     * @param id Unique identifier Image Metadata Signature name. See references for Exif tags specifications for possible id values
     * @param value Metadata value
     */
    public ImageMetadataSignature(int id, Object value);
    ```
    
    Several methods were added for Metadata value conversion to any supported standard type
    
    **Image Metadata methods**
    
    ```java
    /**
    * <p>
    * Converts to boolean.
    * </p>
    * @return Returns the Metadata signature value as boolean.
    * <p><hr>Throws an exception if the Metadata value could not be converted.</hr></p>
    */ 
    public boolean toBoolean();
    /**
    * <p>
    * Converts to integer.
    * </p>
    * @return Returns the Metadata Signature value as integer.
    * <p><hr>Throws an exception if the Metadata value could not be converted.</hr></p>
    */  
    public int toInteger();
    /**
    * <p>
    * Converts to long.
    * </p>
    * @return Returns the Metadata Signature value as long.
    * <p><hr>Throws an exception if the Metadata value could not be converted.</hr></p>
    */  
    public final long toLong();
    /**
    * <p>
    * Converts to float.
    * </p>
    * @return Returns the Image Metadata Signature value as float.
    * <p><hr>Throws an exception if the Metadata value could not be converted. 
    * If original value is string based the default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}({@link SignatureConfig#getDefaultCulture}/{@link SignatureConfig setDefaultCulture(java.util.Locale)})
    * </hr></p>
    */
    public final float toSingle();
    /**
    * <p>
    * Converts to float.
    * </p>
    * @return Returns the Metadata Signature value as float.
    * @param provider Format data provider to use with data conversion operations.
    * <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
    */ 
    public final float toSingle(java.util.Locale provider);
    /**
    * <p>
    * Converts to Double.
    * </p>
    * @return Returns the Image Metadata Signature value as Double.
    * <p><hr>Throws an exception if the Metadata value could not be converted. 
    * If original value is string based the default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}({@link SignatureConfig#getDefaultCulture}/{@link SignatureConfig setDefaultCulture(java.util.Locale)})
    * </hr></p>
    */  
    public double toDouble();
    /**
    * <p>
    * Converts to Double.
    * </p>
    * @return Returns the Metadata Signature value as Double.
    * @param provider Format data provider to use with data conversion operations.
    * <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
    */  
    public double toDouble(java.util.Locale provider);
    /**
    * <p>
    * Converts to Decimal.
    * </p>
    * @return Returns the Image Metadata Signature value as Decimal.
    * <p><hr>Throws an exception if the Metadata value could not be converted. 
    * If original value is string based the default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}({@link SignatureConfig#getDefaultCulture}/{@link SignatureConfig setDefaultCulture(java.util.Locale)})
    * </hr></p>
    */
    public final java.math.BigDecimal toDecimal();
    /**
    * <p>
    * Converts to Decimal.
    * </p>
    * @return Returns the Metadata Signature value as Decimal.
    * @param provider Format data provider to use with data conversion operations.
    * <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
    */
    public final java.math.BigDecimal toDecimal(java.util.Locale provider);
    /**
    * <p>
    * Converts to Date.
    * </p>
    * @return Returns the Metadata Signature value as Date.
    * <p><hr>Throws an exception if the Metadata value could not be converted. 
    * If original value is string based the default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}({@link SignatureConfig#getDefaultCulture}/{@link SignatureConfig setDefaultCulture(java.util.Locale)})
    * </hr></p>
    */
    public java.util.Date toDateTime();
    /**
    * <p>
    * Converts to Date.
    * </p>
    * @return Returns the Metadata Signature value as Date.
    * @param provider Format data provider to use with data conversion operations.
    * <p><hr>Throws an exception if the Metadata value could not be converted</hr></p>
    */
    public java.util.Date toDateTime(java.util.Locale provider);
    
    /**
    * <p>
    * Converts to String with override ToString() method
    * </p>
    * @return Returns the Metadata Signature value as String.
    */  
    public String toString();
    /**
    * <p>
    * Converts to String with specified format
    * </p>
    * @return Returns the Metadata Signature value as String.
    * @param format Data format string.
    * <p><hr>Converts a boolean property into "True" or "False".
    * Default culture property info will be used from static SignatureConfig {@code SignatureConfig.DefaultCulture}({@link SignatureConfig#getDefaultCulture}
    * </hr></p>
    */  
    public String toString(String format);
    /**
    * <p>
    * Converts to String with specified format
    * </p>
    * @return Returns the Metadata Signature value as String.
    * @param format Data format string.
    * @param provider Format data provider to use with data conversion operations.
    * <p><hr>Converts a boolean property into "True" or "False".</hr></p>
    */  
    public String toString(String format, java.util.Locale provider);
    ```
    
    Following example shows using of this class:
    
    **Image Metadata Signature example**
    
    ```java
    // setup int value
    ImageMetadataSignature mdSign_DocId = new ImageMetadataSignature(imgsMetadataId++, 123456); // int
    
    // setup Author property
    ImageMetadataSignature mdSign_Author = new ImageMetadataSignature(imgsMetadataId++, "Mr.Scherlock Holmes"); // string
    
    // setup data of sign date
    ImageMetadataSignature mdSign_Date = new ImageMetadataSignature(imgsMetadataId++, new java.util.Date()); // DateTime
    
    // setup double
    ImageMetadataSignature mdSign_Amnt = new ImageMetadataSignature(imgsMetadataId++, 123.456M); //decimal value
    ```
    
7.  **com.groupdocs.signature.options.metadatasignature.ImagesMetadataSignOptions**  
    New public class **ImagesMetadataSignOptions **was added to implement options of Metadata Signatures in Image documents. Class derived base class** MetadataSignOptions**.
    
    **ImagesMetadataSignOptions class properties**
    
    ```java
    /**
     * <p>
     * Represents the Metadata Signature Options for Image Documents.
     * </p>
     */
    public class ImagesMetadataSignOptions extends MetadataSignOptions
    {
        /**
         * <p>
         * Initializes a new instance of the ImagesSignMetadataOptions class with default values.
         * </p>
         */   
        public ImagesMetadataSignOptions();
     
        /**
         * <p>
         * Initializes a new instance of the ImagesSignMetadataOptions class with Metadata.
         * </p>
         * @param collection Signature Metadata
         */   
        public ImagesMetadataSignOptions(ArrayList<MetadataSignature> collection);
     
    }
    ```
    
    Following example shows how to set this options:
    
    **Setup ImagesMetadataSignOptions instance**
    
    ```java
    // setup options with text of signature
    ImagesMetadataSignOptions signOptions = new ImagesMetadataSignOptions();
    // Specify different Metadata Signatures and add them to options sigature collection
    int imgsMetadataId = 41996;
    // setup int value
    ImageMetadataSignature mdSign_DocId = new ImageMetadataSignature(imgsMetadataId++, 123456); // int
    signOptions.getMetadataSignatures().add(mdSign_DocId);
    // setup Author property
    ImageMetadataSignature mdSign_Author = new ImageMetadataSignature(imgsMetadataId++, "Mr.Scherlock Holmes"); // string
    signOptions.getMetadataSignatures().add(mdSign_Author);
    // setup data of sign date
    ImageMetadataSignature mdSign_Date = new ImageMetadataSignature(imgsMetadataId++, new java.util.Date()); // DateTime
    signOptions.getMetadataSignatures().add(mdSign_Date);
    // setup double
    ImageMetadataSignature mdSign_Amnt = new ImageMetadataSignature(imgsMetadataId++, new Double("123.456")); //decimal value
    signOptions.getMetadataSignatures().add(mdSign_Amnt);
    ```
    
8.  Public class **Metered **was extended with new public methods **getConsumptionQuantity() **and **getConsumptionCredit()**
    
    **Metered methods**
    
    ```java
    /**
     * <p>
     * Gets consumption quantity
     * </p>
     * @return Consumption quantity
     */
    public static double getConsumptionQuantity() throws Exception;
     
    /**
     * <p>
     * Gets credit quantity
     * </p>
     * @return Credit quantity
     */
    public static double getConsumptionCredit() throws Exception;
    }
    ```
    
    Following example demonstrates using Metered class to retrieve Credit and Consumption quantities:
    
    **Using Metered class**
    
    ```java
    String publicKey = "1234567890";
    String privateKey = "1234567890";
     
    Metered metered = new Metered();
    String pubKey = publicKey;
    String prvKey = privateKey;
    try{
        metered.setMeteredKey(pubKey, prvKey);
        double consumption = Metered.getConsumptionQuantity();
        double credit = Metered.getConsumptionCredit();
        System.out.print("Metered consumption = " + consumption + ", credit = " + credit);
    }catch (Exception e){
     
    }
    ```
