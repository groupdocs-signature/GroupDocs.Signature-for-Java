---
id: groupdocs-signature-for-java-20-5-release-notes
url: signature/java/groupdocs-signature-for-java-20-5-release-notes
title: GroupDocs.Signature for Java 20.5 Release Notes
weight: 2
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 20.5{{< /alert >}}

## Major Features

This release contains significant features with supporting additional Form Fields signatures, implementation of popular standard QR-code entities, important fixes and improvements. Below the list of most notable changes in release of GroupDocs.Signature for Java 20.5:

*   Implemented Me-Card and Event QR-code entities support.
*   Implemented EPC/SEPA payment QR-Code standard
*   Added ability to create Combobox Form Field signatures
*   Involved support of Radio button form fields
*   Implemented additional V-Card properties support and different versioning
*   Added ability to specify Image Border with extra appearance settings
*   Fixed few bugs form field signatures coordinates saving
*   Updated text signature implementation naming  
      
    

Full List of Issues Covering all Changes in this Release 

| Key | Summary | Issue Type |
| --- | --- | --- |
| SIGNATURENET-2671 |  Implement EPC/SEPA standard QR-code entry  | Feature |
| SIGNATURENET-2670 |  Implement MeCard contact details standard QR-code entry | Feature |
| SIGNATURENET-2669 |  Implement Event standard QR-code entry  | Feature |
| SIGNATURENET-2644 | Implement ability to add Radio button Form Field signature to PDF Documents | Feature |
| SIGNATURENET-2639 | Implement ability to add Combobox Form Field signature to PDF Documents | Feature |
| SIGNATURENET-2199 | Implement Border settings for Image signature options | Feature |
| SIGNATURENET-2680 | Implement QR-Code VCard entry with CELL type phone support | Improvement |
| SIGNATURENET-2641 | Implement saving Form Fields signature coordinates and size to metadata layer | Improvement |
| SIGNATURENET-2602 | Update Signature Implementation enum with value Native against Stamp | Improvement |
| SIGNATURENET-2592 | Improve saving jpg images for Lossless formats | Improvement |
| SIGNATURENET-2200 | Implement Transparent feature for Background for Stamp signatures | Improvement |
| SIGNATURENET-2674 | SearchResult contains PDF FormField signatures with wrong Top property | Bug |
| SIGNATURENET-2590 | Inappropriate encoding result for processing Barcode of Code32 encode type | Bug |
| SIGNATURENET-2588 | Output Jpeg images are corrupted after saving | Bug |

## Public Developer Guide examples changes

Following topics from Developer Guide were updated:

[Sign document with Form Field signature (advanced)]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-form-field-signature-advanced.md" >}})

[Sign documents with standard QR-code entries]({{< ref "signature/java/developer-guide/advanced-usage/signing/sign-document-with-embedded-and-encrypted-data-in-qr-code-signatures/_index.md" >}})

## Public API and Backward Incompatible Changes

#### Public class [EPC](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/EPC) was added to represent European Payments Council Quick Response Code to be encoded to QR-Code embedded objects.

Public class **[EPC](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/EPC) **was added to represent European Payments Council Quick Response Code to be encoded to QR-Code embedded objects.

**New public class EFC**

```java
/**
 * <p>
 * Represents European Payments Council Quick Response Code.
 * </p>
 */
public final class EPC
{
    /**
     * <p>
     * Gets or sets Beneficiary's Name. Maximum length is 70 characters.
     * </p>
     */    
    public final String getName();    
    public final void setName(String value);

    /**
     * <p>
     * Gets or sets Beneficiary's BIC with up to 11 characters length.
     * </p>
     */   
    public final String getBIC();    
    public final void setBIC(String value);

    /**
     * <p>
     * Gets or sets Beneficiary's Account (IBAN). The IBAN consists of up to 34 alphanumeric characters.
     * </p>
     */    
    public final String getIBAN();    
    public final void setIBAN(String value);

    /**
     * <p>
     * Gets or sets amount.
     * </p>
     */   
    public final double getAmount();   
    public final void setAmount(double value);

    /**
     * <p>
     * Gets or sets Business Code up to 4 characters.
     * </p>
     */    
    public final String getCode();    
    public final void setCode(String value);

    /**
     * <p>
     * Gets or sets Payment Reference (maximum 35 characters). This field and the Remittance Information field are mutually exclusive.
     * </p>
     */    
    public final String getReference();    
    public final void setReference(String value);

    /**
     * <p>
     * Gets or sets Remittance Information (maximum 140 characters). This field and the Payment Reference field are mutually exclusive.
     * </p>
     */    
    public final String getRemittance();   
    public final void setRemittance(String value);
    
    /**
     * <p>
     * Gets or sets hint information. Maximum 70 characters.
     * </p>
     */    
    public final String getInformation();   
    public final void setInformation(String value);

    /**
     * <p>
     * EPC / SEPA QR-Code version implementation. By default this value set to 002.
     * </p>
     */    
    public final String getVersion();   
    public final void setVersion(String value);

    /**
     * <p>
     * EPC / SEPA QR-Code char set implementation. By default this value set to 1
     * </p>
     */    
    public final String getCharset();
    public final void setCharset(String value);

    /**
     * <p>
     * EPC / SEPA QR-Code identification. By default this value set to SCT
     * </p>
     */   
    public final String getIdentification();
    public final void setIdentification(String value);

    /**
     * <p>
     * Instantiates new EPC object.
     * </p>
     */    
    public EPC();
}
```

Following example demonstrates using **[sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))** method to design PDF document with embedded **[EFC](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/EPC)** object into the QR-code

**eSign Pdf with embedded EPC QR-Code**

```java
 // initialize Signature instance 
Signature signature = new Signature("sample.pdf");
{
    // create EPC object
    EPC epc = new EPC();
    epc.setName("Sherlock");
    epc.setBIC("MrSherlockH");
    epc.setIBAN("BE72000000001616");
    epc.setAmount(123456.78D);
    epc.setCode("SHRL");
    epc.setReference("Private service");
    epc.setInformation("Thanks for help");

    // create options
    QrCodeSignOptions options = new QrCodeSignOptions();
    options.setEncodeType(QrCodeTypes.QR);
    // setup Data property to EPC instance
    options.setData(epc);
    // set right bottom corner
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    options.setVerticalAlignment(VerticalAlignment.Bottom);
    options.setMargin(new Padding(10));
    options.setWidth(100);
    options.setHeight(100);


    // sign document to file
    signature.sign("output.pdf", options);
}
```

#### Public class [Event](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/Event) was added to represent Event standard entry as QR-Code embedded objects.

Public class **[Event](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/Event)** was added to represent Event standard entry as QR-Code embedded objects.

**New public class Event**

```java
/**
 * <p>
 * Represents standard QR-Code Event details.
 * </p>
 */
public final class Event
{
    /**
     * <p>
     * Gets or sets event title.
     *  </p>
     */    
    public final String getTitle();
    public final void setTitle(String value);

    /**
     * <p>
     * Gets or sets description.
     *  </p>
     */   
    public final String getDescription();
    public final void setDescription(String value);

    /**
     * <p>
     * Gets or sets event location.
     *  </p>
     */    
    public final String getLocation();
    public final void setLocation(String value);

   /**
    * <p>
    * Gets or sets event start date and time.
    * </p>
    */  
    public final java.util.Date getStartDate() ;
    public final void setStartDate(java.util.Date value);

    /**
     * <p>
     * Gets or sets event end date and time.
     * </p>
     */    
    public final java.util.Date getEndDate();
    public final void setEndDate(java.util.Date value);

    /**
     * <p>
     * Creates Event instance with default values.
     * </p>
     */    
    public Event();
}


```

Following example demonstrates using **[sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))**method to design PDF document with embedded **[Event](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/Event)** object into the QR-code

**eSign Pdf with embedded Event QR-Code**

```java
 // initialize Signature instance
Signature signature = new Signature("sample.pdf");
{
    // create Event object
    Event evnt = new Event();

    evnt.setTitle("GTM(9-00)");
    evnt.setDescription("General Team Meeting");
    evnt.setLocation("Conference-Room");
    Calendar c1 = Calendar.getInstance();
    c1.setTime(new Date());
    c1.add(Calendar.DATE, 1);
    c1.add(Calendar.HOUR, 9);
    Calendar c2 = Calendar.getInstance();
    c2.setTime(new Date());
    c2.add(Calendar.DATE, 1);
    c2.add(Calendar.HOUR, 9);
    c2.add(Calendar.MINUTE, 30);
    evnt.setStartDate(c1.getTime());
    evnt.setEndDate(c2.getTime());

    // create options
    QrCodeSignOptions options = new QrCodeSignOptions();
    options.setEncodeType(QrCodeTypes.QR);
    // setup Data property to Event instance
    options.setData(evnt);
    // set right bottom corner
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    options.setVerticalAlignment(VerticalAlignment.Bottom);
    options.setMargin(new Padding(10));
    options.setWidth(100);
    options.setHeight(100);


    // sign document to file
    signature.sign("output.pdf", options);
}
```

#### Public class [MeCard](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/MeCard) was added to represent standard contact details to be encoded to QR-Code embedded object.

Public class **[MeCard](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/MeCard)** was added to represent standard contact details to be encoded to QR-Code embedded object.

**New public class DeleteResult**

```java
/**
 * <p>
 * Represents MeCard standard contact details.
 * </p>
 */
public final class MeCard
{
    /**
     * <p>
     * Gets or sets contact Name.
     *  </p>
     */   
    public final String getName();
    public final void setName(String value);

    /**
     * <p>
     * Gets or sets contact Nickname.
     *  </p>
     */    
    public final String getNickname();
    public final void setNickname(String value);

    /**
     * <p>
     * Gets or sets phone number.
     * </p>
     */    
    public final String getPhone();
    public final void setPhone(String value);

    /**
     * <p>
     * Gets or sets alternative phone number.
     * </p>
     */    
    public final String getAltPhone();
    public final void setAltPhone(String value);

    /**
     * <p>
     * Gets or sets reading of name.
     * </p>
     */    
    public final String getReading();
    public final void setReading(String value);

    /**
     * <p>
     * Gets or sets contact email.
     * </p>
     */    
    public final String getEmail();
    public final void setEmail(String value);

    /**
     * <p>
     * Gets or sets Note (Company) of contact.
     *  </p>
     */    
    public final String getNote();
    public final void setNote(String value);

    /**
     * <p>
     * Gets or sets URL.
     * </p>
     */    
    public final String getUrl();
    public final void setUrl(String value);

    /**
     * <p>
     * Gets or sets Home Address properties. This property is not initialized by default.
     * </p>
     */    
    public final Address getAddress();
    public final void setAddress(Address value);

    /**
     * <p>
     * Gets or sets contact birthday.
     * </p>
     */    
    public final java.util.Date getBirthDay();
    public final void setBirthDay(java.util.Date value);

    /**
     * <p>
     * Creates MeCard instance with default values.
     * </p>
     */    
    public MeCard();
}
```

Following example demonstrates using **[sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))**method to design PDF document with embedded **[MeCard](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/MeCard)** object into the QR-code

**eSign Pdf with embedded MeCard QR-Code**

```java
Signature signature = new Signature("sample.pdf");
{
    // create MeCard object
    MeCard vCard = new MeCard();
    vCard.setName("Sherlock");
    vCard.setNickname("Jay");
    vCard.setReading("Holmes");
    vCard.setNote("Base Detective");
    vCard.setPhone("0333 003 3577");
    vCard.setAltPhone("0333 003 3512");
    vCard.setEmail("watson@sherlockholmes.com");
    vCard.setUrl("http://sherlockholmes.com/");
    vCard.setBirthDay(new Date(1854, 1, 6));
    Address address = new Address();
    address.setStreet("221B Baker Street");
    address.setCity("London");
    address.setState("NW");
    address.setZIP("NW16XE");
    address.setCountry("England");
    vCard.setAddress(address);

    // create options
    QrCodeSignOptions options = new QrCodeSignOptions();
    options.setEncodeType(QrCodeTypes.QR);
    // setup Data property to MeCard instance
    options.setData(vCard);
    // set right bottom corner
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    options.setVerticalAlignment(VerticalAlignment.Bottom);
    options.setMargin(new Padding(10));
    options.setWidth(100);
    options.setHeight(100);


    // sign document to file
    signature.sign("output.pdf", options);
}
```

#### Public class [VCard](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/VCard) was updated with new property CellPhone.

Public class **[VCard](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/VCard)** was update with new string property CellPhone to get or set cellular phone number for contact details.

**New property CellPhone**

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
 	 * Gets or sets cellular phone number.
 	 * </p>
 	 */	
	public final String getCellPhone();
	public final void setCellPhone(String value);
 }
```

#### Public enumaration [FormFieldType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/FormFieldType) was updated with new option **Radio**.

Enumeration **[FormFieldType](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.enums/FormFieldType)** was updated with new options Radio to specify Radio button type for signature [RadiobuttonFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/RadiobuttonFormFieldSignature).

**New option Radio**

```java
/**
 * <p>
 * Specifies Form Field type.
 * </p>
 */
public class FormFieldType
{
    /**
 	* <p>
 	* Radio-button
 	* </p>
 	*/
	public static final int Radio ;
}


```

#### Public class [RadiobuttonFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/RadiobuttonFormFieldSignature) was added to implement radio buttons form field type for Pdf documents.

Public class **[RadioButtonFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/RadiobuttonFormFieldSignature)** was added

**New public class RadioButtonFormFieldSignature**

```java
/**
 * <p>
 * Contains radio-button input form field signature properties.
 * </p>
 */
public final class RadioButtonFormFieldSignature extends FormFieldSignature
{
    /**
     * <p>
     * Contains selected value.
     * </p>
     */   
    public final String getSelected();
    public final void setSelected(String value);

   /**
    * <p>
    * Get or set Radio buttons options list.
    * </p>
    */    
    public final java.util.List<String> getItems() ;
    public final void setItems(java.util.List<String> value);

    /**
     * <p>
     * Creates RadioButtonFieldSignature with predefined name.
     * </p>
     * @param name Name of form field object.
     */    
    public RadioButtonFormFieldSignature(String name);
   
   /**
    * <p>
    * Creates RadioButtonFieldSignature with predefined name and items list.
    * </p>
    * @param name Name of form field object.
    * @param items Values of radio-button list.
    */    
   public RadioButtonFormFieldSignature(String name,java.util.List<String> items);   

   /**
    * <p>
    * Creates RadioButtonFieldSignature with predefined name, items list and selected value.
    * </p>
    * @param name Name of form field object.
    * @param items Values of radio-button list.
    * @param selected Selected value.
    */    
   public RadioButtonFormFieldSignature(String name,java.util.List<String> items, Object selected);
}
```

Following example demonstrates using **[sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))** method with **[RadioButtonFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/RadiobuttonFormFieldSignature)**

**eSign Pdf with RadioButtonFormFieldSignature**

```java
// initialize Signature instance

Signature signature = new Signature("sample.pdf");
{
    // instantiate radio-button form field signature
    List<String> radioOptions = Arrays.asList("One", "Two", "Three");

    RadioButtonFormFieldSignature radioSignature = new RadioButtonFormFieldSignature("radioData1", radioOptions, "Two");

    // instantiate options based on text form field signature
    FormFieldSignOptions options = new FormFieldSignOptions(radioSignature);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    options.setVerticalAlignment(VerticalAlignment.Top);
    options.setMargin(new Padding(0, 0, 0, 0));
    options.setHeight(100);
    options.setWidth(300);


    // sign document to file
    SignResult signResult = signature.sign("output.pdf", options);
}
```

#### Public class [ComboboxFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/ComboboxFormFieldSignature) was updated with new properties and ability to add this form field type to Pdf documents.

Public class **[ComboboxFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/ComboboxFormFieldSignature)** was updated with new properties.

*   property **Selected** as string returns the value which is selected at combo-box field;
*   property **Items** as list of strings keeps list of values at combo-box field;
*   new public constructors with various arguments was added. It provides possibility to set combo-box field signature name, list of values and selected value.

**New public class DeleteResult**

```java
/**
 * <p>
 * Contains combo-box input form field signature properties.
 * </p>
 */
public final class ComboboxFormFieldSignature extends FormFieldSignature
{
    /**
     * <p>
     * Get or set selected value.
     * </p>
     */   
    public final String getSelected();    
    public final void setSelected(String value);
    
   /**
    * <p>
    * Get or set combo-box options list.
    * </p>
    */    
    public final java.util.List<String> getItems() ; 
    public final void setItems(java.util.List<String> value);
    

    /**
     * <p>
     * Creates ComboboxFormFieldSignature with predefined name.
     * </p>
     * @param name Name of form field object.
     */   
    public ComboboxFormFieldSignature(String name);

   
   /**
    * <p>
    * Creates ComboboxFormFieldSignature with predefined name and options list.
    * </p>
    * @param name Name of form field object.
    * @param items Values of combo-box list.
    */   
   public ComboboxFormFieldSignature(String name,java.util.List<String> items);

  
   /**
    * <p>
    * Creates ComboboxFormFieldSignature with predefined name, options list and selected value.
    * </p>
    * @param name Name of form field object.
    * @param items Values of combo-box list.
    * @param selected Selected value.
    */   
   public ComboboxFormFieldSignature(String name,java.util.List<String> items, Object selected);
}
```

Following example demonstrates using **[sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20com.groupdocs.signature.options.sign.SignOptions))** method with **[ComboboxFormFieldSignature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.signatures.formfield/ComboboxFormFieldSignature)**

**Sign document with Combobox Form field siganture**

```java
// initialize Signature instance
Signature signature = new Signature("sample.pdf");
{
    // instantiate combo box form field signature
    List<String> items = Arrays.asList( "Red", "Green", "Blue" );

    ComboboxFormFieldSignature combobox = new ComboboxFormFieldSignature("combo1", items, "Blue");

    // instantiate options based on text form field signature
    FormFieldSignOptions options = new FormFieldSignOptions(combobox);
    options.setHorizontalAlignment(HorizontalAlignment.Right);
    options.setVerticalAlignment(VerticalAlignment.Top);
    options.setMargin(new Padding(0, 0, 0, 0));
    options.setHeight(100);
    options.setWidth(300);


    // sign document to file
    SignResult signResult = signature.sign("sampleSigned.pdf", options);
}
```
