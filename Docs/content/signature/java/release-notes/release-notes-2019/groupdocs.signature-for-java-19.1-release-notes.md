---
id: groupdocs-signature-for-java-19-1-release-notes
url: signature/java/groupdocs-signature-for-java-19-1-release-notes
title: GroupDocs.Signature for Java 19.1 Release Notes
weight: 5
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 19.1{{< /alert >}}

## Major Features

There are about 10 improvements, new features and fixes in this regular release. Most features are related to introduced Metadata Signature type implementation for signing and searching for Cells,Slides and Words Documents, also introducing new Form-Field Signature type implementation for signing. There are few improvements with search signature results. Summary the most notable changes are:

*   Introduced Metadata Signature singing features for Cells Documents
*   Implemented Search for Metadata Signatures in Cells Documents
*   Added support of Metadata Signature singing features for Words Documents
*   Implemented Search for Metadata Signatures in Words Documents
*   Introduced ability to search for embedded built-in Metadata Signatures in Words and Cells Documents
*   Implemented support of password protected open-documents-spreadsheet file types of Cells Documents
*   Provided ability to obtain typed list of signatures from search result data
*   Implement Form-field Search features for PDF Documents
*   Introduced Form-field Signature features for PDF Documents
*   Added support of built-in metadata search for Slides/Presentation Documents
*   Implement Metadata Signatures Search for Slides Documents
*   Introduced Metadata Signature features for Slides Documents
*   Extend Digital Signatures verification with Subject and Issuer criteria for Words Documents
*   Improved Form-field Signature naming for multi page Documents
*   Fixed Form-fields search bug for empty named controls for PDF Documents
*   Improved Output file setup, fixed issue for absolute output file path
*   Improve error handling with extended messages

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-1694 | Implement support of built-in metadata search for Words Documents | New Feature |
| SIGNATURENET-1690 | Implement support of built-in metadata search for Cells Documents | New Feature |
| SIGNATURENET-1685 | Implement Metadata Signatures Search for Cells Documents | New Feature |
| SIGNATURENET-1681 | Implement Metadata Signatures Search for Words Documents | New Feature |
| SIGNATURENET-1677 | Implement Metadata Signature features for Cells Documents | New Feature |
| SIGNATURENET-1672 | Implement Metadata Signature features for Words Documents | New Feature |
| SIGNATURENET-1582 | Implement additional verification criteria for Digital Signatures of Words Documents | New Feature |
| SIGNATURENET-1701 | Implement support of password protected Open-Documents-Spreadsheet ODS file formats | Improvement |
| SIGNATURENET-1695 | Implement Search results conversion to typed list of signatures | Improvement |
| SIGNATURENET-1467 | Implement global Exception handler to catch all not handled exceptions | Improvement |
| SIGNATURENET-1760 | Implement Form-Field Search features for PDF Documents | New Feature |
| SIGNATURENET-1751 | Implement Form-Field Signature features for PDF Documents | New Feature |
| SIGNATURENET-1715 | Implement support of built-in metadata search for Slides/Presentation Documents | New Feature |
| SIGNATURENET-1711 | Implement Metadata Signatures Search for Slides Documents | New Feature |
| SIGNATURENET-1707 | Implement Metadata Signature features for Slides Documents | New Feature |
| SIGNATURENET-1797 | Skip Output folder when SaveOptions.OutputFileName is set as absolute path | Bug |
| SIGNATURENET-1782 | Exception is fired when searching in PDF documents for Form-fields that were setup without name | Bug |
| SIGNATURENET-1785 | Implement standard Image Metadata Signatures | New Feature |
| SIGNATURENET-1756 | Extend Form-Field signature name automatically with number prefix for multiple-pages options | Improvement |
| SIGNATURENET-1581 | Improve handling exceptions with proper details and exception type | Improvement |

## Public API and Backward Incompatible Changes

{{< alert style="info" >}}This section lists public API changes that were introduced in GroupDocs.Signature for Java 19.1. It includes not only new and obsoleted public methods, but also a description of any changes in the behavior behind the scenes in GroupDocs.Signature which may affect existing code. Any behavior introduced that could be seen as a regression and modifies existing behavior is especially important and is documented here.{{< /alert >}}

1.  New public class **CellsMetadataSignature **was added to implement Metadata signature features for Cells Documents. This class derives base **MetadataSignature**, overloads virtual methods (IClonable implementation).
    
    **Cells Metadata Signature class properties**
    
    ```java
    /// <summary>
    /// Contains Cells Metadata Signature properties.
    /// </summary>
    public final class CellsMetadataSignature extends MetadataSignature
    {
        /// <summary>
        /// Creates Cells Metadata Signature with predefined name and empty value
        /// </summary>
        /// <param name="name">Cells Metadata Signature name</param>
        public CellsMetadataSignature(String name);
     
        /// <summary>
        /// Creates Cells Metadata Signature with predefined values
        /// </summary>
        /// <param name="name">Name of Metadata signature object</param>
        /// <param name="value">Value of Metadata signature</param>
        public CellsMetadataSignature(String name, Object value);
     
        /// <summary>
        /// Clone Metadata Signature instance.
        /// </summary>
        /// <returns>Returns cloned Metadata Signature instance</returns>
        public Object deepClone();
     
        /// <summary>
        /// Clone Cells Metadata Signature instance with given value.
        /// </summary>
        /// <param name="value">Value for new cloned object.</param>
        /// <returns>Returns cloned Metadata Signature instance.</returns>
        public MetadataSignature deepClone(Object value);
    }
    ```
    
    **Cells Metadata Signature properties:**
    
    Cells Metadata Signature derives all base class properties.  
    **Cells Metadata Signature methods:**
    
    PDF metadata Signature derives all base class methods.
    
    | Method name | Return type | Description / Remarks |
    | --- | --- | --- |
    | toBoolean() | boolean | Returns the Metadata signature value as Boolean. Throws an exception if the Metadata value could not be converted. If value is integer type all non zero values will be interpreted as True.  |
    | toInteger() | integer | Returns the Metadata Signature value as integer. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. Double value will be truncated. String value will be tries to parse into integer. |
    | toDouble() | double | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as double. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. String value will be tries to parse into double based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toDateTime() | Date | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as java.util.Date. Throws an exception if the Metadata value could not be converted. String value will be tries to parse into Date based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toString() | string | Overload method with ability to specify IDataFormatProvider to data type convertions. Returns the Metadata Signature value as string representation based on passed format and IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    
    Following example demonstrates using **CellsMetadataSignature **to compose Metadata Signature options for Cells Document.
    
    **Compose Cells Metadata Signature Options**
    
    ```java
    // setup options with text of signature
    CellsMetadataSignOptions signOptions = new CellsMetadataSignOptions();
    	// Specify different Metadata Signatures and add them to options sigature collection
    	// setup Author property
    CellsMetadataSignature mdSign_Author = new CellsMetadataSignature("Author", "Mr.Scherlock Holmes");
    signOptions.getMetadataSignatures().add(mdSign_Author);
        // setup data of document id
    CellsMetadataSignature mdSign_DocId = new CellsMetadataSignature("DocumentId", Guid.newGuid().toString());
    signOptions.getMetadataSignatures().add(mdSign_DocId);
        // setup data of sign date
    CellsMetadataSignature mdSign_Date = new CellsMetadataSignature("SignDate", DateTime.getNow().Clone());
    signOptions.getMetadataSignatures().add(mdSign_Date);
        // setup some integer value
    CellsMetadataSignature mdSign_Days = new CellsMetadataSignature("DocDays", 12345);
    signOptions.getMetadataSignatures().add(mdSign_Days);
        // setup data of sign date
    CellsMetadataSignature mdSign_Koeff = new CellsMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
    signOptions.getMetadataSignatures().add(mdSign_Koeff);
    ```
    
      
    
2.  New public class **WordsMetadataSignature **was added to implement Metadata signature features for Words Documents. This class derives base **MetadataSignature**, overloads virtual methods (IClonable implementation).
    
    **Words Metadata Signature class properties**
    
    ```java
    /// <summary>
    /// Contains Words Metadata Signature properties.
    /// </summary>
    public final class WordsMetadataSignature extends MetadataSignature
    {
        /// <summary>
        /// Creates Words Metadata Signature with predefined name and empty value
        /// </summary>
        /// <param name="name">Words Metadata Signature name</param>
        public WordsMetadataSignature(String name);
     
        /// <summary>
        /// Creates Words Metadata Signature with predefined values
        /// </summary>
        /// <param name="name">Name of Metadata signature object</param>
        /// <param name="value">Value of Metadata signature</param>
        public WordsMetadataSignature(String name, Object value);
     
        /// <summary>
        /// Clone Metadata Signature instance.
        /// </summary>
        /// <returns>Returns cloned Metadata Signature instance</returns>
        public Object deepClone();
     
        /// <summary>
        /// Clone Words Metadata Signature instance with given value.
        /// </summary>
        /// <param name="value">Value for new cloned object.</param>
        /// <returns>Returns cloned Metadata Signature instance.</returns>
        public MetadataSignature deepClone(Object value);
    }
    ```
    
    **Words Metadata Signature properties:**
    
    Words Metadata Signature derives all base class properties.  
    **Words Metadata Signature methods:**
    
    PDF metadata Signature derives all base class methods.
    
    | Method name | Return type | Description / Remarks |
    | --- | --- | --- |
    | toBoolean() | boolean | Returns the Metadata signature value as Boolean. Throws an exception if the Metadata value could not be converted. If value is integer type all non zero values will be interpreted as True.  |
    | toInteger() | integer | Returns the Metadata Signature value as integer. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. Double value will be truncated. String value will be tries to parse into integer. |
    | toDouble() | double | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as double. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. String value will be tries to parse into double based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toDateTime() | Date | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as java.util.Date. Throws an exception if the Metadata value could not be converted. String value will be tries to parse into Date based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | toString() | string | Overload method with ability to specify IDataFormatProvider to data type convertions. Returns the Metadata Signature value as string representation based on passed format and IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    
    Following example demonstrates using **WordsMetadataSignature **to compose Metadata Signature options for Words Document.
    
    **Compose Words Metadata Signature Options**
    
    ```java
    // setup options with text of signature
    WordsMetadataSignOptions signOptions = new WordsMetadataSignOptions();
        // Specify different Metadata Signatures and add them to options sigature collection
        // setup Author property
    WordsMetadataSignature mdSign_Author = new WordsMetadataSignature("Author", "Mr.Scherlock Holmes");
    signOptions.getMetadataSignatures().add(mdSign_Author);
        // setup data of document id
    WordsMetadataSignature mdSign_DocId = new WordsMetadataSignature("DocumentId", Guid.newGuid().toString());
    signOptions.getMetadataSignatures().add(mdSign_DocId);
        // setup data of sign date
    WordsMetadataSignature mdSign_Date = new WordsMetadataSignature("SignDate", DateTime.getNow().Clone());
    signOptions.getMetadataSignatures().add(mdSign_Date);
        // setup some integer value
    WordsMetadataSignature mdSign_Days = new WordsMetadataSignature("DocDays", 12345);
    signOptions.getMetadataSignatures().add(mdSign_Days);
        // setup data of sign date
    WordsMetadataSignature mdSign_Koeff = new WordsMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
    signOptions.getMetadataSignatures().add(mdSign_Koeff);
    ```
    
      
    
3.  New public class **CellsSearchMetadataOptions **was added to provide options to search for Cells Metadata signatures within the Cells Documents. This class derives base **SearchMetadataOptions.**
    
    **Cells Metadata Search Options properties**
    
    ```java
    /**
     * <p>
     * Represents the Metadata Signature Search Options for Cells Documents.
     * </p>
     */
    public class CellsSearchMetadataOptions extends SearchMetadataOptions
    {
    /**
     * <p>
     * Indicates if Built-in document properties like Document statistic, information etc should be included into Search result
     * </p>
     */
     
    public final boolean getIncludeBuiltinProperties();
    /**
     * <p>
     * Indicates if Built-in document properties like Document statistic, information etc should be included into Search result
     * </p>
     */
     
    public final void setIncludeBuiltinProperties(boolean value);
    private boolean auto_IncludeBuiltinProperties;
     
    /**
     * <p>
     * Initializes a new instance of the CellsSearchMetadataOptions class with default values.
     * </p>
     */
     
    public CellsSearchMetadataOptions();
     
    /**
     * <p>
     * Initializes a new instance of the CellsSearchMetadataOptions class.
     * </p>
     * @param includeBuiltinProperties Indicates if built-in properties should be included into search results.
     */
     
    public CellsSearchMetadataOptions(boolean includeBuiltinProperties);
    ```
    
    Following example demonstrates using **SearchMetadataOptions** to search for Cells Metadata signatures in the Cells Documents.
    
    **Search for Metadata signatures in Cells Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup search options
    CellsSearchMetadataOptions searchOptions = new CellsSearchMetadataOptions();
    // search document
    SearchResult result = handler.search("SignedMetadata.xlsx", searchOptions);
    // output signatures
    java.util.List<CellsMetadataSignature> signatures = result.toList(CellsMetadataSignature.class);
    //foreach to while statements conversion
    for (CellsMetadataSignature signature : signatures)
    {
    	if (signature != null)
    	{
    		System.out.print("Cells Metadata: "+signature.getName()+" = "+signature.toString() );
    	}
    }
    ```
    
4.  New public class **WordsSearchMetadataOptions **was added to provide options to search for Words Metadata signatures within the Words Documents. This class derives base **SearchMetadataOptions**.
    
    **Words Metadata Search Options properties**
    
    ```java
    /**
     * <p>
     * Represents the Metadata Signature Search Options for Words Documents.
     * </p>
     */
    public class WordsSearchMetadataOptions extends SearchMetadataOptions
    {
        /**
         * <p>
         * Indicates if Built-in document properties like Document statistic, information etc should be included into Search result
         * </p>
         */  
        public final boolean getIncludeBuiltinProperties();
        /**
         * <p>
         * Indicates if Built-in document properties like Document statistic, information etc should be included into Search result
         * </p>
         */   
        public final void setIncludeBuiltinProperties(boolean value);
        private boolean auto_IncludeBuiltinProperties;
        /**
         * <p>
         * Initializes a new instance of the WordsSearchMetadataOptions class with default values.
         * </p>
         */
       
        public WordsSearchMetadataOptions();
     
        /**
         * <p>
         * Initializes a new instance of the CellsSearchMetadataOptions class.
         * </p>
         * @param includeBuiltinProperties Indicates if buil-in properties should be included into search results.
         */
        
        public WordsSearchMetadataOptions(boolean includeBuiltinProperties);
    }
    ```
    
    Following example demonstrates using **SearchMetadataOptions** to search for Words Metadata signatures in the Words Documents.
    
    **Search for Metadata signatures in Words Documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
    // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
    // setup search options
    WordsSearchMetadataOptions searchOptions = new WordsSearchMetadataOptions();
    // search document
    SearchResult result = handler.search("SignedMetadata.docx", searchOptions);
    // output signatures
    java.util.List<WordsMetadataSignature> signatures = result.toList(WordsMetadataSignature.class);
    //foreach to while statements conversion
    for (WordsMetadataSignature metadataSignature : signatures)
    {
    	if (metadataSignature != null)
    	{
    		System.out.print("Words Metadata: "+metadataSignature.getName()+" = "+metadataSignature.toString() );
    	}	
    }
    ```
    
5.  **Public class** **SearchResult **was updated with generic method **<T> toList(Class<T> typeOfT)**  to provide ability for typed list conversion.
    
    ```java
    // search document
    SearchResult result = handler.Search("SignedBarCode.pdf", searchOptions);
    // output signatures - use toList<T>() method to obtain list of required signature types
    java.util.List<PdfBarcodeSignature> signatures = result.toList(PdfBarcodeSignature.class);
    for(PdfBarcodeSignature signature : signatures)
    {
        if(signature != null)
        {
            System.out.print("Found Barcode signature: "+bcSignature.getEncodeType().getTypeName()+" with text "+bcSignature.getText() );
        }
    }
    ```
    
6.  **New Form-Field type **of signature is the abstract class** FormFieldSignature **and enumeration** FormFieldType.**  
    Many documents support special elements Form Fields that allow user to input data into standard form elements like text input, extended multi line text, check box, radio buttons, digital certificate holders etc. This version we implemented support of these signatures for PDF documents. New enumeration type **FormFieldType **specifies type of form-field element like Text, CheckBox, Signature.
    
    **FormFieldType**
    
    ```java
    /**
     * <p>
     * Specifies Form Field type.
     * </p>
     */
    public final class FormFieldType extends Enum
    {
       private FormFieldType(){}  
        /**
         * <p>
         * Simple text input.
         * </p>
         */
        public static final int Text = 0;
     
        ////// <summary>
        ////// Simple text input.
        ////// </summary>
        ///RichText,
     
        /// <summary>
        /// Check-box.
        /// </summary>
        public static final int Checkbox = 1;
     
        ////// <summary>
        ////// Button on form to submit data
        ////// </summary>
        ///Button,
     
        /// <summary>
        /// Digital signature area.
        /// </summary>
        public static final int DigitalSignature = 2;
     
    }
    ```
    
    New public abstract class **FormFieldSignature **was added to implement Form Field signature features for documents. The Form Field Signature is a input control which is placed on a document page. Some types of documents supports various input controls like Check-box or Text.
    
    This type of Signature allows users to place input controls on document pages.
    
    **FormFieldSignature**
    
    ```java
    /**
     * <p>
     * Contains Form Field Signature properties.
     * </p>
     */
    public abstract class FormFieldSignature extends BaseSignature implements ICloneable
     {
        /**
         * <p>
         * Specifies unique form field name.
         * </p>
         */
     
        public final String getName();
     
        /**
        * <p>
        * Specifies unique form field name.
         * </p>
         */
     
        public final void setName(String value);
        private String auto_Name;
        /**
         * <p>
         * Specifies Form field type.
         * </p>
         */
     
        public final int getType();
        /**
         * <p>
         * Specifies Form field type.
         * </p>
         */
     
        private void setType(int value);
        private int auto_Type;
     
        /**
         * <p>
        * Specifies Form-Field data object.
        * </p>
        */
     
        public final Object getValue();
        /**
         * <p>
        * Specifies Form-Field data object.
        * </p>
        */
     
        public final void setValue(Object value);
     }
    ```
    
    **FormField Signature properties:**
    
    | Name | Type | Description |
    | --- | --- | --- |
    | Name | string | Specifies name of FormField Signature. |
    | Type | FormFieldType | Specifies type of form field. |
    | Value | object | Specifies value of FormField  Signature. This property could be different type. |
    
7.  **New classes to represent different Form-Field Signatures of PDF documents.**  
    New scope of classes that are derived from base **FormFieldSignature** implement following PDF document form-fields.  
      
    1\. New public class **PdfTextFormFieldSignature **was added to implement simple input Text Form Field signatures for PDF documents. The Form Field Signature is a input control which is placed on a document page. Some types of documents supports various input controls like Check-box or Text.
    
    This type of Signature allows users to place input controls on document pages.
    
    **PdfTextFormFieldSignature**
    
    ```java
    /**
     * <p>
     * Contains text input form field signature properties for Pdf Document
     * </p>
     */
    public final class PdfTextFormFieldSignature extends FormFieldSignature
    {
        /**
         * <p>
         * Get or set text of form field  text input.
         * </p>
         */  
        public final String getText();
        /**
         * <p>
         * Get or set text of form field  text input.
         * </p>
         */  
        public final void setText(String value);
        private String auto_Text;
     
        /**
         * <p>
         * Creates PdfTextFormFieldSignature with predefined name.
         * </p>
         * @param name Name of form field object.
         */  
        public PdfTextFormFieldSignature(String name);
        /**
         * <p>
         * Creates PdfTextFormFieldSignature with predefined name.
         * </p>
         * @param name Name of form field object.
         * @param text Text of form field object.
         */  
        public PdfTextFormFieldSignature(String name, String text);
        }
    ```
    
    **PDF Text FormField Signature properties:**
    
    | Name | Type | Description |
    | --- | --- | --- |
    | Text | string | Specifies text of input Form Field Signature. |
    
    2\. New public class **PdfCheckboxFormFieldSignature **was added to implement simple Check Box Form Field signatures for PDF documents.
    
    **PdfCheckboxFormFieldSignature**
    
    ```java
    /**
     * <p>
     * Contains check-box input form field signature properties.
     * </p>
     */
    public final class PdfCheckboxFormFieldSignature extends FormFieldSignature
    {
         
        /**
         * <p>
         * Get or set checked value of form field check-box input.
         * </p>
         */  
        public final boolean getChecked();
        /**
         * <p>
         * Get or set checked value of form field check-box input.
         * </p>
         */   
        public final void setChecked(boolean value);
        private boolean auto_Checked;
        /**
         * <p>
         * Creates PdfCheckboxFormFieldSignature with predefined name.
         * </p>
         * @param name Name of form field object.
         */   
        public PdfCheckboxFormFieldSignature(String name);
        /**
         * <p>
         * Creates PdfCheckboxFormFieldSignature with predefined name and value
         * </p>
         * @param name Name of form field object.
         * @param isChecked Value if check box is checked
         */   
        public PdfCheckboxFormFieldSignature(String name, boolean isChecked);
        }
    }
    ```
    
    **PDF Text FormField Signature properties:**
    
    | Name | Type | Description |
    | --- | --- | --- |
    | Text | string | Specifies text of input Form Field Signature. |
    
    3\. New public class **PdfDigitalFormFieldSignature **was added to implement Digital Signature input Form Field for PDF documents.
    
    **PdfDigitalFormFieldSignature**
    
    ```java
    /**
     * <p>
     * Contains digital signature input form field properties for PDF Documents.
     * </p>
     */
    public final class PdfDigitalFormFieldSignature extends FormFieldSignature
    {
        /**
         * <p>
         * Read-only property that shows if Form-field Signature was signed with digital certificate.
         * </p>
         */ 
        public final boolean getSigned();
        /**
         * <p>
         * Read-only property that shows if Form-field Signature was signed with digital certificate.
         * </p>
         */
        private void setSigned(boolean value);
        private boolean auto_Signed;
         
        /**
         * <p>
         * Creates PdfDigitalFormFieldSignature with predefined name.
         * </p>
         * @param name Name of form field object.
         */   
        public PdfDigitalFormFieldSignature(String name);
        }
    }
    ```
    
    **PDF Text FormField Signature properties:**
    
    | Name | Type | Description |
    | --- | --- | --- |
    | Signed | bool | Specifies if Form Field Signature was signed. |
    
8.  New static class **PdfFormFieldSignOptions** represent options to put Form-field signature on PDF document. Class is derived from base **TextSignOptions** class that allows to specify positioning of signature area, alignment etc. Class keeps property of **FormFieldSignature** to be posted on document.
    
    **PdfFormFieldSignOptions**
    
    ```java
    /**
     * <p>
     * Represents class of the FormField Signature Options for Pdf Documents.
     * </p>
     */
    public final class PdfFormFieldSignOptions extends SignTextOptions
    {
        /**
         * <p>
         * Gets or sets the FormField of signature.
         * </p>
         */   
        public final FormFieldSignature getSignature();
        /**
         * <p>
         * Gets or sets the FormField of signature.
         * </p>
         */  
        public final void setSignature(FormFieldSignature value);
        private FormFieldSignature auto_Signature;
     
        /**
         * <p>
         * Initializes a new instance of the PdfFormFieldSignOptions class with default values.
         * </p>
         */  
        public PdfFormFieldSignOptions();
     
        /**
         * <p>
         * Initializes a new instance of the PdfFormFieldSignOptions class with FormField signature.
         * </p>
         */   
        public PdfFormFieldSignOptions(FormFieldSignature signature);
    }
    ```
    
    Following example demonstrates using **PdfFormFieldSignOptions** to add form field signature on PDF document page:
    
    **Signing with form field in PDF document**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("C:\\Storage");
    signConfig.setImagesPath("C:\\Images");
    signConfig.setOutputPath("C:\\Output");
    signConfig.setCertificatesPath("C:\\Certificates");
        // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        //collection of signatures initialization
    SignatureOptionsCollection collection = new SignatureOptionsCollection();
      
        // 1. setup text form field signature options
        // instantiate text form field signature
    FormFieldSignature textSignature = new PdfTextFormFieldSignature("FieldText","Value1");
        // instantiate options based on text form field signature
    PdfFormFieldSignOptions textOptions = new PdfFormFieldSignOptions(textSignature);
    textOptions.setHorizontalAlignment(HorizontalAlignment.Left);
    textOptions.setVerticalAlignment(VerticalAlignment.Top);
    textOptions.setMargin(new Padding(10, 20, 0, 0));
    textOptions.setHeight(10);
    textOptions.setWidth(100);
    collection.add(textOptions);
      
        // 2. setup check-box form field signature options
        // instantiate check-box form field signature
    FormFieldSignature checkboxSignature = new PdfCheckboxFormFieldSignature("FieldCheckbox", true);
        // instantiate options based on check-box form field signature
    PdfFormFieldSignOptions checkboxOptions = new PdfFormFieldSignOptions(checkboxSignature);
    checkboxOptions.setHorizontalAlignment(HorizontalAlignment.Left);
    checkboxOptions.setVerticalAlignment(VerticalAlignment.Top);
    checkboxOptions.setMargin(new Padding(120, 20, 0, 0));
    checkboxOptions.setHeight(10);
    checkboxOptions.setWidth(10);
    collection.add(checkboxOptions);
      
        // 3. setup digital signature form field options
        // instantiate digital signature form field
    FormFieldSignature digitalSignature = new PdfDigitalFormFieldSignature("FieldDigital");
     PagesSetup tmp1 = new  PagesSetup();
    tmp1.setLastPage(true);
        // instantiate options based on digital signature form field
    PdfFormFieldSignOptions digitalOptions = new PdfFormFieldSignOptions(digitalSignature);
    digitalOptions.setPagesSetup(tmp1);
    digitalOptions.setHorizontalAlignment(HorizontalAlignment.Right);
    digitalOptions.setVerticalAlignment(VerticalAlignment.Bottom);
    digitalOptions.setMargin(new Padding(0, 0, 10, 10));
    digitalOptions.setHeight(20);
    digitalOptions.setWidth(100);
    collection.add(digitalOptions);
     SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("Pdf_FormFields");
        // sign document
    String signedPath = handler.<String>sign("02_pages.pdf", collection, tmp0);
    System.out.print("Signed file path is: "+  signedPath);
    ```
    
9.  New abstract class **SearchFormFieldOptions **represents base class to specify search options for form field signatures.
    
    **SearchFormFieldOptions class properties**
    
    ```java
    /**
     * <p>
     * Represents abstract search Options for Form-field Signatures.
     * </p>
     */
    public abstract class SearchFormFieldOptions extends SearchOptions
    {
       /**
         * <p>
         * Specifies type of form field signature if it should be searched. Default value is null. 
         * </p>
         */ 
        public final Integer getType();
        
        /**
         * <p>
         * Specifies type of form field signature if it should be searched. Default value is null. 
         * </p>
         */  
        public final void setType(Integer value);
        private Integer auto_Type = null;
      
        /**
         * <p>
         * Specifies regular expression pattern of form field signature name if it should be searched. 
         * You can use it simple as "text" or regular expression like "abc\d+". Default value is empty string.
         * </p>
         */ 
        public final String getName();
        /**
         * <p>
         * Specifies regular expression pattern of form field signature name if it should be searched. 
         * You can use it simple as "text" or regular expression like "abc\d+". Default value is empty string.
         * </p>
         */ 
        public final void setName(String value);
        private String auto_Name;
      
        /**
         * <p>
         * Specifies value of form field signature if it should be searched. Default value is null.
         * </p>
         */  
        public final Object getValue();
        /**
         * <p>
         * Specifies value of form field signature if it should be searched. Default value is null.
         * </p>
         */  
        public final void setValue(Object value);
        private Object auto_Value;
     }
    ```
    
    Nullable property **Type** allows optionally specify type of form-field to search, string property **Name** allows to specify regular expression pattern for form-field name, property **Value** allows to specify optionally value of control.
    
10.  New public abstract class **PdfSearchFormFieldOptions ** was added to implement form field signature search for PDF documents.
    
    This type of Signature allows users to search for form field signatures like TextBox, CheckBox or Digital.
    
    **PdfSearchFormFieldOptions class properties**
    
    ```java
    /// <summary>
    /// Represents the Form-field Signature Search Options for Pdf Documents.
    /// </summary>
    public class PdfSearchFormFieldOptions extends SearchFormFieldOptions
    {
        /// <summary>
        /// Initializes a new instance of the PdfSearchFormFieldOptions class with default values.
        /// </summary>
        public PdfSearchFormFieldOptions();
    }
    ```
    
    Following example demonstrates using **SearchFormFieldOptions** to search for form field signatures on PDF document page:
    
    **Searching for form field in PDF document**
    
    ```java
     // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath("C:\\Storage");
    signConfig.setImagesPath("C:\\Images");
    signConfig.setOutputPath("C:\\Output");
    signConfig.setCertificatesPath("C:\\Certificates");
        // instantiating the signature handler
    SignatureHandler handler = new SignatureHandler(signConfig);
     
        // setup search options
    PdfSearchFormFieldOptions searchOptions = new PdfSearchFormFieldOptions();
    searchOptions.setSearchAllPages(true);
    searchOptions.setName("Field");
    searchOptions.setValue("Value1");
     
        // search document
    SearchResult result = handler.search("FormFieldDigitalSigned.pdf", searchOptions);
     
        // output signatures
    for (FormFieldSignature formFieldSignature : result.toList(FormFieldSignature.class))
    {
        if (formFieldSignature != null)
        {
            System.out.print("Pdf FormField: "+formFieldSignature.getName()+":"+formFieldSignature.getValue()+"  = "+formFieldSignature.toString() );
        }
    }
    ```
    
11.  New public class **SlidesMetadataSignature **was added to implement Metadata signature features for Slides documents. This class derives base **MetadataSignature **, overloads virtual methods (IClonable implementation).
    
    **Slides Metadata Signature class properties**
    
    ```java
    /// <summary>
    /// Contains Slides Metadata Signature properties.
    /// </summary>
    public final class SlidesMetadataSignature extends MetadataSignature
    {
        /// <summary>
        /// Creates Slides Metadata Signature with predefined name and empty value
        /// </summary>
        /// <param name="name">Slides Metadata Signature name</param>
        public SlidesMetadataSignature(String name);
     
        /// <summary>
        /// Creates Slides Metadata Signature with predefined values
        /// </summary>
        /// <param name="name">Name of Metadata signature object</param>
        /// <param name="value">Value of Metadata signature</param>
        public SlidesMetadataSignature(String name, Object value);
    }
    ```
    
    **Slides Metadata Signature properties:  
    **Slides Metadata Signature derives all base class properties.**  
    Slides Metadata Signature methods:**
    
    Slides metadata Signature derives all base class methods.
    
    | Method name | Return type | Description / Remarks |
    | --- | --- | --- |
    | ToBoolean() | boolean | Returns the Metadata signature value as Boolean. Throws an exception if the Metadata value could not be converted. If value is integer type all non zero values will be interpreted as True.  |
    | ToInteger() | integer | Returns the Metadata Signature value as integer. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. Double value will be truncated. String value will be tries to parse into integer. |
    | ToDouble() | double | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as double. Throws an exception if the Metadata value could not be converted. Boolean value will be converted to 1 in case of logical true value, otherwise 0. String value will be tries to parse into double based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | ToDateTime() | DateTime | Overload method with ability to specify IDataFormatProvider for string based values conversion. Returns the Metadata Signature value as DateTime. Throws an exception if the Metadata value could not be converted. String value will be tries to parse into Datetime based on passed IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    | ToString() | string | Overload method with ability to specify IDataFormatProvider to data type convertions. Returns the Metadata Signature value as string representation based on passed format and IDataFormatProvider or default provider from SignatureConfig.DefaultCulture property. |
    
    Following example demonstrates using **SlidesMetadataSignature **to compose Metadata Signature options for Words document.
    
    **Compose Slides Metadata Signature Options**
    
    ```java
    // setup options with text of signature
    SlidesMetadataSignOptions signOptions = new SlidesMetadataSignOptions();
        // Specify different Metadata Signatures and add them to options sigature collection
        // setup Author property
    SlidesMetadataSignature mdSign_Author = new SlidesMetadataSignature("Author", "Mr.Scherlock Holmes");
    signOptions.getMetadataSignatures().add(mdSign_Author);
        // setup data of document id
    SlidesMetadataSignature mdSign_DocId = new SlidesMetadataSignature("DocumentId", Guid.newGuid().toString());
    signOptions.getMetadataSignatures().add(mdSign_DocId);
        // setup data of sign date
    SlidesMetadataSignature mdSign_Date = new SlidesMetadataSignature("SignDate", DateTime.getNow().Clone());
    signOptions.getMetadataSignatures().add(mdSign_Date);
        // setup some integer value
    SlidesMetadataSignature mdSign_Days = new SlidesMetadataSignature("DocDays", 12345);
    signOptions.getMetadataSignatures().add(mdSign_Days);
        // setup data of sign date
    SlidesMetadataSignature mdSign_Koeff = new SlidesMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
    signOptions.getMetadataSignatures().add(mdSign_Koeff);
    ```
    
12.  New public class **SlidesMetadataSignOptions **was added to provide options to support Metadata signature features for Slides/Presentation documents. This class derives base **MetadataSignOptions.**
    
    **Slides Metadata Sign Options properties**
    
    ```java
    /// <summary>
    /// Represents the Metadata Signature Options for Slides documents.
    /// </summary>
    public class SlidesMetadataSignOptions : MetadataSignOptions
    {
        /// <summary>
        /// Initializes a new instance of the SlidesSignMetadataOptions class with default values.
        /// </summary>
        public SlidesMetadataSignOptions();
     
        /// <summary>
        /// Initializes a new instance of the SlidesSignMetadataOptions class with Metadata.
        /// </summary>
        /// <param name="collection">Signature Metadata</param>
        public SlidesMetadataSignOptions(IEnumerable<MetadataSignature> collection);
    }
    ```
    
    Following example demonstrates using **SlidesMetadataSignOptions **to add Metadata signatures to Slides document:
    
    **Sign Slides document with Metadata Signature**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath("C:\\Storage");
    signConfig.setOutputPath("C:\\Output");
        // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
        // setup options with text of signature
    SlidesMetadataSignOptions signOptions = new SlidesMetadataSignOptions();
        // Specify different Metadata Signatures and add them to options sigature collection
        // setup Author property
    SlidesMetadataSignature mdSign_Author = new SlidesMetadataSignature("Author", "Mr.Scherlock Holmes");
    signOptions.getMetadataSignatures().add(mdSign_Author);
        // setup data of document id
    SlidesMetadataSignature mdSign_DocId = new SlidesMetadataSignature("DocumentId", Guid.newGuid().toString());
    signOptions.getMetadataSignatures().add(mdSign_DocId);
        // setup data of sign date
    SlidesMetadataSignature mdSign_Date = new SlidesMetadataSignature("SignDate", DateTime.getNow().Clone());
    signOptions.getMetadataSignatures().add(mdSign_Date);
        // setup some integer value
    SlidesMetadataSignature mdSign_Days = new SlidesMetadataSignature("DocDays", 12345);
    signOptions.getMetadataSignatures().add(mdSign_Days);
        // setup data of sign date
    SlidesMetadataSignature mdSign_Koeff = new SlidesMetadataSignature("SignKoeff", new Decimal("2.345").Clone());
    signOptions.getMetadataSignatures().add(mdSign_Koeff);
     SaveOptions tmp0 = new  SaveOptions();
    tmp0.setOutputType(OutputType.String);
    tmp0.setOutputFileName("Slides_Documents_Metadata");
     
        // sign document
    String signedPath = handler.<String>sign("test.pptx", signOptions, tmp0);
    System.out.print("Signed file path is: " + signedPath);
    ```
    
13.  New public class **SlidesSearchMetadataOptions **was added to provide options to search for Metadata Signatures within the Slides/Presentation documents. This class derives base **SearchMetadataOptions**.
    
    **Slides Metadata Search Options properties**
    
    ```java
    /**
     * <p>
     * Represents the Metadata Signature Search Options for Slides Documents.
     * </p>
     */
    public class SlidesSearchMetadataOptions extends SearchMetadataOptions
    {
        /**
         * <p>
         * Indicates if Built-in document properties like Document statistic, information etc should be included into Search result
         * </p>
         */  
        public final boolean getIncludeBuiltinProperties();
        /**
         * <p>
         * Indicates if Built-in document properties like Document statistic, information etc should be included into Search result
         * </p>
         */   
        public final void setIncludeBuiltinProperties(boolean value);
        private boolean auto_IncludeBuiltinProperties;
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchMetadataOptions class with default values.
         * </p>
         */  
        public SlidesSearchMetadataOptions();
        /**
         * <p>
         * Initializes a new instance of the SlidesSearchMetadataOptions class.
         * </p>
         * @param includeBuiltinProperties Indicates if buil-in properties should be included into search results.
         */   
        public SlidesSearchMetadataOptions(boolean includeBuiltinProperties);
    }
    ```
    
    Following example demonstrates using **SlidesSearchMetadataOptions** to search for Slides Metadata signatures in the Slides/Presentation documents:
    
    **Search for Slides Metadata Signatures in documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig = new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Output");
        // instantiating the signature handler
    SignatureHandler<String> handler = new SignatureHandler<String>(signConfig);
     
        // setup search options
    SlidesSearchMetadataOptions searchOptions = new SlidesSearchMetadataOptions();
     
        // set if we need built-in signatures
    searchOptions.setIncludeBuiltinProperties(true);
     
        // search document
    SearchResult result = handler.search("SignedMetadata.pptx", searchOptions);
        // output signatures
    java.util.List<SlidesMetadataSignature> signatures = result.toList(SlidesMetadataSignature.class);
        //foreach to while statements conversion
    for (SlidesMetadataSignature signature:signatures)
    {
       if (signature != null)
       {
            System.out.print("Slides Metadata: " + signature.getName() + " = " + signature.toString() );
       }
    }
    ```
    
14.  Public class **WordsVerifyDigitalOptions** was updated with new string properties **SubjectName **and **IssuerName**. These fields could be used as additional criteria to verify Digital Signatures of Words documents. If these properties are specified verification process will check for Digital Signature properties (SubjectName, IssuerName) to be equal or contain passed strings. These values are case sensitive.
    
    **WordsVerifyDigitalOptions**
    
    ```java
    /**
     * <p>
     * Subject distinguished name of the certificate to validate. Value is case sensitive.
     * If this property is set verification will check if Signature subject name contains or equals passed value
     * </p>
     */
    public final String getSubjectName();
    /**
     * <p>
     * Subject distinguished name of the certificate to validate. Value is case sensitive.
     * If this property is set verification will check if Signature subject name contains or equals passed value
     * </p>
     */
    public final void setSubjectName(String value);
    private String auto_SubjectName;
     
    /**
     * <p>
     * Issuer name of the certificate to validate. Value is case sensitive.
     * If this property is set verification will check if Signature's issuer name contains or equals passed value
     * </p>
     */
    public final String getIssuerName();
    /**
     * <p>
     * Issuer name of the certificate to validate. Value is case sensitive.
     * If this property is set verification will check if Signature's issuer name contains or equals passed value
     * </p>
     */
    public final void setIssuerName(String value);
    private String auto_IssuerName;
    ```
    
    Following example demonstrates using these properties to verify Digital signatures in the Words documents:
    
    **Verify Digital signatures in the Words documents**
    
    ```java
    // setup Signature configuration
    SignatureConfig signConfig =new SignatureConfig();
    signConfig.setStoragePath(BaseTestData.getTestDataPath() +"\\Storage");
    signConfig.setImagesPath(BaseTestData.getTestDataPath() +"\\Output");
    signConfig.setOutputPath(BaseTestData.getTestDataPath() +"\\Images");
    signConfig.setCertificatesPath(BaseTestData.getTestDataPath() +"\\Certificates");
        // instantiating the conversion handler
    SignatureHandler handler = new SignatureHandler(signConfig);
    VerifyOptionsCollection verifyOptionsCollection = new VerifyOptionsCollection();
        // setup digital verification options
    WordsVerifyDigitalOptions verifyOptions = new WordsVerifyDigitalOptions("SherlockHolmes.cer");
    verifyOptions.setComments("Test1");
    verifyOptions.setSubjectName("Signature");
    verifyOptions.setIssuerName("GroupDocs");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    Date dateFrom = sdf.parse("26/1/2017 16:55:57");
    Date dateTo = sdf.parse("26/1/2017 16:55:59");
    verifyOptions.setSignDateTimeFrom(dateFrom);
    verifyOptions.setSignDateTimeTo(dateTo);
    //verify document
    VerificationResult result = handler.verify("test_digitalsigned.Docx", verifyOptions);
    System.out.print("Signed file verification result: " + result.isValid());
    
    
    ```
