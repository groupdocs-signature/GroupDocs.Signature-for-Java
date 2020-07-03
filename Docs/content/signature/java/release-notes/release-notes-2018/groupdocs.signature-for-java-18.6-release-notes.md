---
id: groupdocs-signature-for-java-18-6-release-notes
url: signature/java/groupdocs-signature-for-java-18-6-release-notes
title: GroupDocs.Signature for Java 18.6 Release Notes
weight: 3
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 18.6{{< /alert >}}

## Major Features

There are about seven improvements, new features and fixes in this regular release. Most new features are related to ability to encode custom objects to QR-Code Signatures and alternative implementation of Stamp Signatures. The most notable changes are:

*   Introduced ability to encode custom objects to QR-Code Signatures
*   Implemented standard QR-Code embedded objects like VCard contact details and Email formats
*   Involved ability to search custom objects and obtain them from QR-Code Signatures
*   Updated Dynamic Metered library with latest changes and fixes
*   Implemented new Slides format like otp, potx, potm, pptm, ppsm
*   Fixed few bugs with Slides and Words format files extensions
*   Introduced new type of Stamp Signature

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-3413 | Implement standard QRCode embedded classes VCard, Email | New Feature |
| SIGNATURENET-3400 | Implement ability to search custom object to QR-Code Signature | New Feature |
| SIGNATURENET-3396 | Implement ability to encode custom object to QR-Code Signature | New Feature |
| SIGNATURENET-3393 | Add ability to process new Slides file formats (otp, potx, potm, pptm, ppsm) | New Feature |
| SIGNATURENET-3391 | Implement Square type of Stamp Signatures | New Feature |
| SIGNATURENET-3294 | Signed .doc files have .docx extension | Bug |
| SIGNATURENET-3290 | Signed .ppt files have .pps extension | Bug |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 18.6. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  **Introduced ability to encode custom objects to QR-Code Signature** for all supported Document types. Any class can be used to embedded it to QRCode Signature. Optional few attributes can be used to specify names and format of data for objects serialization. New attributes allow to specify format and names of object fields/properties serialization. By default serialization format to QR-Code is Json format. Future versions will include ability to specify custom serialization and de-serialization of objects. New attribute **FormatAttribute** allows to specify name and data format for class property. Attribute **SkipSerializationAttribute** allows to skip member of class for serialization. These attributes are optional.  
      
    1.Public class **FormatAttribute** was added to GroupDocs.Signature.Domain.Extensions namespace to represent attribute for fields, variables or properties of class to be serialized to embedded QR-Code object. This attribute can be used for custom classes fields and properties to specify special field name or format while serialization.  
      
    
    **FormatAttriute class implementation**
    
    ```java
     /**
      * <p>
      * Instructs for objects serialization to serialize the member with the specified name and format
      * </p>
      */
    @Target ({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention (RetentionPolicy.RUNTIME)
     
    public @interface FormatAttribute
    {
        /**
         * <p>
         * Gets or sets the name of the property.
         * </p>Value: The name of the property.
         */
        @Public
        public String propertyName() default "";
     
        /**
         * <p>
         * Gets or sets the serialization format of the property.
         * </p>Value: The format of the property.
         */
        @Public
        public String propertyFormat() default "";
     
    }
    ```
    
    ** Create custom class with required properties or field**
    
    
    
    ```java
    public static class DocumentSignature
    {
        @FormatAttribute(propertyName = "Id")
        public String getID(){ return auto_ID; }
        @FormatAttribute (propertyName = "SignatureID")
        public void setID(String value){ auto_ID = value; }
        private String auto_ID;
     
        @FormatAttribute (propertyName = "Author")
        public String getAuthor(){ return auto_Author; }
        @FormatAttribute (propertyName = "Author")
        public void setAuthor(String value){ auto_Author = value; }
        private String auto_Author;
     
        @FormatAttribute (propertyName = "SignatureDate",propertyFormat = "yyyy-MM-dd")
        public java.util.Date getSigned() { return auto_Signed; }
     
        @FormatAttribute (propertyName = "SignatureDate",propertyFormat = "yyyy-MM-dd")
        public void setSigned(java.util.Date value) { auto_Signed = value; }
     
        private java.util.Date auto_Signed = new java.util.Date();
     
        @FormatAttribute (propertyName = "Factor", propertyFormat = "N2")
        public java.math.BigDecimal getDataFactor() { return auto_DataFactor; }
     
        @FormatAttribute (propertyName = "Factor",propertyFormat = "N2")
        public void setDataFactor(java.math.BigDecimal value) { auto_DataFactor = value; }
     
        private java.math.BigDecimal auto_DataFactor = new java.math.BigDecimal(0.01);
    }
    ```
    
    2.Public class **SkipSerializationAttribute **was added to GroupDocs.Signature.Domain.Extensions namespace to represent attribute for fields, variables or properties of class to be skipped while serialization to embedded QR-Code object. This attribute can be used for custom classes fields and properties to skip its property from serialization
    
    **SkipSerializationAttribute**
    
    ```java
     /**
      * <p>
      * Instructs the serialization to skip the member
      * </p>
      */
    @Target ({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention (RetentionPolicy.RUNTIME)
    @Public
    public @interface SkipSerializationAttribute
    {
     
    }
    ```
    
    **Create custom class with required properties or field and specify fields that should not be serialized into embedded QR-Code Signature Text**
    
    
    
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
            @FormatAttribute (propertyName = "SignatureID")
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
    
    3.New property of **QRCodeSignOptions** of type object **Data** was added to pass objects for QR-Code Signature
    
    **QRCodeSignOptions**
    
    ```java
    /**
     * <p>
     * Gets or sets custom object to serialize to QR-Code content.
     * </p>
     */
     
    public Object getData(){ return auto_Data; }
    /**
     * <p>
     * Gets or sets custom object to serialize to QR-Code content.
     * </p>
     */
     
    public void setData(Object value){ auto_Data = value; }
    private Object auto_Data;
    ```
    
    It allows to pass custom data objects for QR-Code Signature.
    
    Following example demonstrate it
    
    **Sign document with custom QR-Code data**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
        // setup custom object instance with required data
    DocumentSignature docSignature =new DocumentSignature();
    docSignature.setID(UUID.randomUUID().toString());
    docSignature.setAuthor("Mr.Sherlock");
    docSignature.setSigned(new java.util.Date());
    docSignature.setDataFactor(new java.math.BigDecimal("0.67"));
     
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup options
    PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
        // QR-code type
    signOptions.setEncodeType(QRCodeTypes.QR);
     
        // setup Data property with custom object
    signOptions.setData(docSignature);
     
        // save Options
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("SignedQRCodeCustData");
        // sign document
    String signedPath = (String)handler.<String>sign("test.pdf", signOptions, saveOptions);
    ```
    
    By default current implementation of serialization format uses base Json format. For object above QR-Code Signature will keep following text content - fields marked with SkipSerialization attribute will be missing in output content.
    
    **Example of serialized custom object to QR-Code text**
    
    ```java
    {
    "SignatureID": "6ba54e34-f215-4dc0-be3e-b8ec552ec7fb",
    "Author": "Mr.Sherlock",
    "SignatureDate": "2018-03-18",
    "Factor": "0.67"
    }
    ```
    
2.  Public class **VCard** was added to com.groupdocs.signature.domain.extensions namespace to represent standard VCard contact details to be encoded to QR-Code embedded objects.
    
    **VCard class implementation**
    
    ```java
    /**
     * <p>
     * Represents VCard standard contact details.
     * </p>
     */
    public class VCard
    {   
        /**
         * <p>
         * Get or set contact First Name.
         * </p>
         */
         
        public String getFirstName(){ return auto_FirstName; }
        /**
         * <p>
         * Get or set contact First Name.
         * </p>
         */
        
        public void setFirstName(String value){ auto_FirstName = value; }
        private String auto_FirstName;
     
        /**
         * <p>
         * Get or set contact Middle Name.
         * </p>
         */
         
        public String getMidddleName(){ return auto_MidddleName; }
        /**
         * <p>
         * Get or set contact Middle Name.
         * </p>
         */
         
        public void setMidddleName(String value){ auto_MidddleName = value; }
        private String auto_MidddleName;
     
        /**
         * <p>
         * Get or set contact Last Name.
         * </p>
         */
       
        public String getLastName(){ return auto_LastName; }
        /**
         * <p>
         * Get or set contact Last Name.
         * </p>
         */
         
        public void setLastName(String value){ auto_LastName = value; }
        private String auto_LastName;
     
        /**
         * <p>
         * Get or set contact initials.
         * </p>
         */
         
        public String getInitials(){ return auto_Initials; }
        /**
         * <p>
         * Get or set contact initials.
         * </p>
         */
        
        public void setInitials(String value){ auto_Initials = value; }
        private String auto_Initials;
     
        /**
         * <p>
         * Get or set Company of contact.
         * </p>
         */
       
        public String getCompany(){ return auto_Company; }
        /**
         * <p>
         * Get or set Company of contact.
         * </p>
         */
        
        public void setCompany(String value){ auto_Company = value; }
        private String auto_Company;
     
        /**
         * <p>
         * Get or set contact Job Title.
         * </p>
         */
       
        public String getJobTitle(){ return auto_JobTitle; }
        /**
         * <p>
         * Get or set contact Job Title.
         * </p>
         */
        
        public void setJobTitle(String value){ auto_JobTitle = value; }
        private String auto_JobTitle;
     
        /**
         * <p>
         * Gets or sets Home Address properties. This property is not initialized by default.
         * </p>
         */
        
        public Address getHomeAddress(){ return auto_HomeAddress; }
        /**
         * <p>
         * Gets or sets Home Address properties. This property is not initialized by default.
         * </p>
         */
       
        public void setHomeAddress(Address value){ auto_HomeAddress = value; }
        private Address auto_HomeAddress;
     
        /**
         * <p>
         * Gets or sets Work Address properties. This property is not initialized by default.
         * </p>
         */
         
        public Address getWorkAddress(){ return auto_WorkAddress; }
        /**
         * <p>
         * Gets or sets Work Address properties. This property is not initialized by default.
         * </p>
         */
        
        public void setWorkAddress(Address value){ auto_WorkAddress = value; }
        private Address auto_WorkAddress;
     
        /**
         * <p>
         * Gets or sets home phone number.
         * </p>
         */
        
        public String getHomePhone(){ return auto_HomePhone; }
        /**
         * <p>
         * Gets or sets home phone number.
         * </p>
         */
         
        public void setHomePhone(String value){ auto_HomePhone = value; }
        private String auto_HomePhone;
     
        /**
         * <p>
         * Gets or sets work phone number.
         * </p>
         */
        
        public String getWorkPhone(){ return auto_WorkPhone; }
        /**
         * <p>
         * Gets or sets work phone number.
         * </p>
         */
        
        public void setWorkPhone(String value){ auto_WorkPhone = value; }
        private String auto_WorkPhone;
     
        /**
         * <p>
         * Gets or sets contact email.
         * </p>
         */
         
        public String getEmail(){ return auto_Email; }
        /**
         * <p>
         * Gets or sets contact email.
         * </p>
         */
         
        public void setEmail(String value){ auto_Email = value; }
        private String auto_Email;
     
        /**
         * <p>
         * Gets or sets contact URL.
         * </p>
         */
       
        public String getUrl(){ return auto_Url; }
        /**
         * <p>
         * Gets or sets contact URL.
         * </p>
         */
       
        public void setUrl(String value){ auto_Url = value; }
        private String auto_Url;
     
        /**
         * <p>
         * Gets or sets contact birthday.
         * </p>
         */
         
        public Date getBirthDay(){ return auto_BirthDay; }
        /**
         * <p>
         * Gets or sets contact birthday.
         * </p>
         */
         
        public void setBirthDay(Date value){ auto_BirthDay = value; }
        private Date auto_BirthDay;
     
       
        public VCard() {}
    }
    ```
    
      
    Following example demonstrates using VCard object into QR-Code Signature.
    
    **Composing VCard object**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
     
        // Setup VCard object
    VCard vcard =new VCard();
    vcard.setFirstName("Sherlock");
    vcard.setMidddleName("Jay");
    vcard.setLastName("Holmes");
    vcard.setInitials("Mr.");
    vcard.setCompany("Watson Inc.");
    vcard.setJobTitle("Detective");
    vcard.setHomePhone("0333 003 3577");
    vcard.setWorkPhone("0333 003 3512");
    vcard.setEmail("watson@sherlockholmes.com");
    vcard.setUrl("http://sherlockholmes.com/");
    vcard.setBirthDay(new Date(1854, 1, 6));
        // Setup Address of Contant details
    vcard.setHomeAddress(new Address());
    vcard.getHomeAddress().setStreet("221B Baker Street");
    vcard.getHomeAddress().setCity("London");
    vcard.getHomeAddress().setState("NW");
    vcard.getHomeAddress().setZIP("NW16XE");
    vcard.getHomeAddress().setCountry("England");
     
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup SaveOptions
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("VCardData");
        // setup options with text of signature
    PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
        // setup QR-code type and size
    signOptions.setEncodeType(QRCodeTypes.QR);
    signOptions.setWidth(200);
    signOptions.setHeight(200);
     
        // setup Data property to VCard instance
    signOptions.setData(vcard);
     
        // sign document
    ```
    
    Public class **Email** was added to com.groupdocs.signature.domain.extensions namespace to represent Email properties of email format standard implementation for QR-Code embedded objects.
    
    **Email class implementation**
    
    ```java
    public class Email
    {
        /**
         * <p>
         * Get or set Email address.
         * </p>
         */   
        public String getAddress(){ return auto_Address; }
        /**
         * <p>
         * Get or set Email address.
         * </p>
         */   
        public void setAddress(String value){ auto_Address = value; }
        private String auto_Address;
     
        /**
         * <p>
         * Get or set email Subject.
         * </p>
         */   
        public String getSubject(){ return auto_Subject; }
        /**
         * <p>
         * Get or set email Subject.
         * </p>
         */   
        public void setSubject(String value){ auto_Subject = value; }
        private String auto_Subject;
     
        /**
         * <p>
         * Get or set Body of email message.
         * </p>
         */   
        public String getBody(){ return auto_Body; }
        /**
         * <p>
         * Get or set Body of email message.
         * </p>
         */   
        public void setBody(String value){ auto_Body = value; }
        private String auto_Body;
    }
    ```
    
      
    Class **Email** implements standard QRCode email message. Here's how it can be used
    
    **Composing Email object**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
     
        // Setup Email object
    Email email =new Email();
    email.setAddress("watson@sherlockholmes.com");
    email.setSubject("Welcome email");
    email.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
         
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup SaveOptions
    SaveOptions saveOptions =new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("EmailData");
        // setup options with text of signature
    PdfQRCodeSignOptions signOptions = new PdfQRCodeSignOptions();
        // setup QR-code type and size
    signOptions.setEncodeType(QRCodeTypes.QR);
    signOptions.setWidth(200);
    signOptions.setHeight(200);
     
        // setup Data property to Email instance
    signOptions.setData(email);
     
        // sign document
    String signedPath = (String)handler.<String>sign("test.pdf", signOptions, saveOptions);
    ```
    
3.  **Search features** was updated to support custom objects deserialization. New method of QRCodeSignature was added to support obtaining object from Signature.
    
    Following example demonstrates retrieving **DocumentSignature **object from signed Pdf file with **DocumentSignature **QR-Code Signature
    
    **Search for custom object from signed document**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup search options
    PdfSearchQRCodeOptions searchOptions = new PdfSearchQRCodeOptions();
     
        // specify as true to search all pages of a document
    searchOptions.setSearchAllPages(false);
     
        // search document
    SearchResult result = handler.search("SignedQRCodeCustData.pdf", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        PdfQRCodeSignature qrCodeSignature = Operators.as(signature, PdfQRCodeSignature.class);
        if (qrCodeSignature != null)
        {
            System.out.println("Found QRCode signature: " + qrCodeSignature.getEncodeType().getTypeName() + " with text " + qrCodeSignature.getText());
     
            DocumentSignature docSignature = qrCodeSignature.<DocumentSignature>getData(DocumentSignature.class);
            if (docSignature != null)
            {
                System.out.println("Found DocumentSignature signature: #"+docSignature.getID()+". Author "+docSignature.getAuthor()+" from "+docSignature.getDataFactor()+". Factor: "+docSignature.getDataFactor());
            }
        }
    }
    ```
    
    Also this feature supports retrieving standard VCard and Email object types.
    
    
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup search options
    PdfSearchQRCodeOptions searchOptions = new PdfSearchQRCodeOptions();
     
        // specify as true to search all pages of a document
    searchOptions.setSearchAllPages(false);
     
        // search document
    SearchResult result = handler.search("SignedQRCodeVCardData.pdf", searchOptions);
        // output signatures
    for (BaseSignature signature : result.getSignatures())
    {
        PdfQRCodeSignature qrCodeSignature = Operators.as(signature, PdfQRCodeSignature.class);
        if (qrCodeSignature != null)
        {
            System.out.println("Found QRCode signature: "+qrCodeSignature.getEncodeType().getTypeName()+" with text " + qrCodeSignature.getText());
     
            VCard vcard = qrCodeSignature.<VCard>getData(VCard.class);
            if (vcard != null)
            {
                System.out.println("Found VCard signature: "+vcard.getFirstName()+" "+vcard.getLastName()+" from "+vcard.getCompany()+". Email: " +vcard.getEmail());
            }
        }
    }
    ```
    
4.  **New Stamp type **was implemented. Class **StampType** contains description of Stamp Type.
    
    **StampType**
    
    ```java
    /**
     * <p>
     * Specify stamp type properties.
     * </p>
     */
    public final class StampType 
    {
       
        /**
         * <p>
         * Get Index of object in collection of supported stamp types.
         * </p>
         */   
        public int getTypeIndex(){ return auto_TypeIndex; }
     
     
        /**
         * <p>
         * Get Index of object in collection of supported stamp types.
         * </p>
         */
        private void setTypeIndex(int value){ auto_TypeIndex = value; }
        private int auto_TypeIndex;
     
        /**
         * <p>
         * Name of stamp type.
         * </p>
         */
        
        public String getTypeName(){ return auto_TypeName; }
        /**
         * <p>
         * Name of stamp type.
         * </p>
         */
        private void setTypeName(String value){ auto_TypeName = value; }
        private String auto_TypeName;
     
        /**
         * <p>
         * Determines whether the specified stamp type is equal to the current object.
         * </p>
         * @return Result of comparison.
         * @param other Object for comparison.
         */
        
        public boolean equals(StampType other)
        {
        }
     
        /**
         * <p>
         * Overridden method determines whether the specified System.Object is equal to the current System.Object.
         * </p>
         * @return Result of comparison.
         * @param obj Object for comparison.
         */
         
        public boolean equals(Object obj)
        {
        }
     
        /**
         * <p>
         * Overridden method serves as a hash function for a particular type.
         * </p>
         * @return Hash.
         */
       
        public int hashCode()
        {
        }
     
        /**
         * <p>
         * Overridden method serves as conversion to string type.
         * </p>
         * @return String.
         */
         
        public String toString()
        {
        }
    ```
    
    Public abstract class **StampSignOptions** was extended with new property StampType. With this property user is able to set type of stamp signature. Value by default is Round.
    
    **StampSignOptions**
    
    ```java
     /**
     * <p>
     * Represents the Stamp Signature Options.
     * </p>
     */
    public abstract class StampSignOptions 
    {
      /**
     * <p>
     * Gets or sets stamp type.
     * Value by default is Round.
     * </p>
     */
     
    public StampType getStampType(){ return auto_StampType; }
     
    /**
     * <p>
     * Gets or sets stamp type.
     * Value by default is Round.
     * </p>
     */
     
    public void setStampType(StampType value){ auto_StampType = value; }
    private StampType auto_StampType;
     }
    ```
    
    **Example**
    
    ```java
    // setup Signature configuration
    String storagePath = BaseTestData.getTestDataPath() +"\\Storage";
    String outputPath = BaseTestData.getTestDataPath() +"\\Output";
        // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(storagePath);
    signConfig.setOutputPath(outputPath);
     
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup options
    ImagesStampSignOptions signOptions = new ImagesStampSignOptions();
     
        // setup stamp type
    signOptions.setStampType(StampTypes.SQUARE); //This feature is supported starting from version 18.6.
     
        // setup other properties
    signOptions.setTop(300);
    signOptions.setLeft(255);
    signOptions.setHeight(150);
    signOptions.setWidth(250);
    signOptions.setStampType(StampTypes.ROUND);
     
    signOptions.setImageGuid(BaseTestData.getTestDataPath() +"\\Images\\300x200plane.png");
     
        //Outer lines
    StampLine line00 = new StampLine();
    line00.setHeight(18);
    line00.getOuterBorder().setWeight(6);
    line00.getOuterBorder().setColor(Color.getRoyalBlue().getNativeObject());
    line00.getInnerBorder().setWeight(6);
    line00.getInnerBorder().setColor(Color.getCornflowerBlue().getNativeObject());
    line00.setBackgroundColor(Color.getWhite().getNativeObject());
    signOptions.getOuterLines().add(line00);
     
    StampLine line01 = new StampLine();
    line01.setHeight(20);
    line01.setText("INTERNATIONAL AIRPORT");
    line01.setTextColor(Color.getCadetBlue().getNativeObject());
    line01.getFont().setFontSize(10);
    line01.setTextBottomIntent(5);
    line01.getInnerBorder().setWeight(1);
    line01.getInnerBorder().setColor(Color.getCadetBlue().getNativeObject());
    signOptions.getOuterLines().add(line01);
     
        //Inner lines
    StampLine line02 = new StampLine();
    line02.setText("DEPARTURE");
    line02.setTextColor(Color.getDarkRed().getNativeObject());
    line02.getFont().setFontSize(14);
    line02.setTextBottomIntent(10);
    line02.getFont().setBold(true);
    line02.setHeight(30);
    signOptions.getInnerLines().add(line02);
     
    StampLine line03 = new StampLine();
    line03.setText("03.03.2003");
    line03.setTextColor(Color.getBrown().getNativeObject());
    line03.getFont().setFontSize(12);
    line03.getFont().setBold(true);
    line03.setHeight(20);
    signOptions.getInnerLines().add(line03);
     
    SaveOptions saveOptions =  new SaveOptions();
    saveOptions.setOutputType(OutputType.String);
    saveOptions.setOutputFileName("DocImages_StampRound");
     
        // sign document with round stamp
    String signedPath = (String)handler.<String>sign("invoice.png", signOptions,saveOptions);
    Console.writeLine(StringExtensions.concat("Signed file path is: ",  signedPath));
    //change stamp type
    signOptions.setStampType(StampTypes.SQUARE);
     
    SaveOptions saveOptions2 =  new SaveOptions();
    saveOptions2.setOutputType(OutputType.String);
    saveOptions2.setOutputFileName("DocImages_StampRound");
        // sign document with square stamp
    String signedPath2 = (String)handler.<String>sign("invoice.png", signOptions, saveOptions2);
    ```
