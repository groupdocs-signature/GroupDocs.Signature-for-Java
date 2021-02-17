---
id: sign-documents-with-standard-qr-code-entries
url: signature/java/sign-documents-with-standard-qr-code-entries
title: Sign documents with standard QR-code entries
weight: 6
description: "This article explains how to create QR-code electronic signature with standard encoded entries like Address, Email, V-Card, MeCard, EPC/SEPA, Event etc"
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
[**GroupDocs.Signature**](https://products.groupdocs.com/signature/java) provides ability to embed into QR-code signature standard entries like email, contact v-card, address etc. This feature supports standard QR-code representation of entries. At this moment following standard QR-code entries are supported

* [Email](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/Email ) entry that allows to specify in QR-code standard email information with recipient, subject and body.
* [Address](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/Address ) entry contains address information.
* [V-Card](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/VCard ) entry implements standard of visit card 3.0 specification. More details could be found [here](https://en.wikipedia.org/wiki/VCard).
* [Me-Card](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/MeCard ) entry implements similar to V-Card contact details standard. More details could be found [here](https://en.wikipedia.org/wiki/MeCard_(QR_code)).
* [EPC](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/EPC ) implements standard of the European Payments Council guidelines define the content of a QR code that can be used to initiate [SEPA](https://en.wikipedia.org/wiki/SEPA_credit_transfer) credit transfer. More details could be found [here](https://en.wikipedia.org/wiki/EPC_QR_code).
* [Event](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.domain.extensions.serialization/Event ) entry implements event standard.

Here are the steps to embed standard entry into QR-code with GroupDocs.Signature:  

* Create new instance of  [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature ) class and pass source document path as a constructor parameter.
* Create new instance of one of standard entries class.
* Create one or several objects of [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions ) object with [getData](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#getData() ) value assigned with initialized standard object before.
* Instantiate the  [QrCodeSignOptions](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions )  object according to your requirements and custom object to [getData](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions#getData() ) property.
* Call [sign](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature#sign(java.io.OutputStream,%20java.util.List) ) method of  [Signature](https://apireference.groupdocs.com/signature/java/com.groupdocs.signature/Signature )  class instance and pass [QrCodeSignOptions](https://apireference.groupdocs.com/https://apireference.groupdocs.com/signature/java/com.groupdocs.signature.options.sign/QrCodeSignOptions ) to it.

## Sign PDF with email QR-code object

This example shows how to esign PDF with Email QR-code object.

```java
Signature signature = new Signature("sample.pdf"))

    // create Email object
    Email email = new Email();
	email.setAddress("sherlock@holmes.com");
	email.setSubject("Very important e-mail");
	email.setBody("Hello, Watson. Reach me ASAP!");


	// create options
	// create options
	QrCodeSignOptions options = new QrCodeSignOptions();
	options.setEncodeType(QrCodeTypes.QR);
	// setup Data property to Address instance
	options.setData(email);
	// set right bottom corner
	options.setHorizontalAlignment(HorizontalAlignment.Right);
	options.setVerticalAlignment(VerticalAlignment.Bottom);
	options.setMargin(new Padding(10));
	options.setWidth(100);
	options.setHeight(100);

    // sign document to file
    signature.sign("output.pdf", options);

```

## Sign PDF with Address inside the QR-Code image

This example shows how to esign PDF with address inside the QR-code image.

```java
Signature signature = new Signature("sample.pdf"))
{
    // create Address object
    Address address = new Address();
	address.setStreet("221B Baker Street");
	address.setCity("London");
	address.setState("NW");
	address.setZIP("NW16XE");
	address.setCountry("England");


	// create options
	QrCodeSignOptions options = new QrCodeSignOptions();
	options.setEncodeType(QrCodeTypes.QR);
		// setup Data property to Address instance
	options.setData(address);
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

## Sign PDF with V-Card (VCF) information in the QR-Code image

This example shows how to esign PDF with V-Card inside the QR-code image.

```java
Signature signature = new Signature("sample.pdf"))
{
    // create VCard object
    VCard vCard = new VCard();

	vCard.setFirstName("Sherlock");
	vCard.setMidddleName("Jay");
	vCard.setLastName("Holmes");
	vCard.setInitials("Mr.");
	vCard.setCompany("Watson Inc.");
	vCard.setJobTitle("Detective");
	vCard.setHomePhone("0333 003 3577");
	vCard.setWorkPhone("0333 003 3512");
	vCard.setEmail("watson@sherlockholmes.com");
	vCard.setUrl("http://sherlockholmes.com/");
	vCard.setBirthDay(new Date(1854, 1, 6));
	Address address = new Address();
	address.setStreet("221B Baker Street");
	address.setCity("London");
	address.setState("NW");
	address.setZIP("NW16XE");
	address.setCountry("England");
	vCard.setHomeAddress(address);


	// create options
	QrCodeSignOptions options = new QrCodeSignOptions();
	options.setEncodeType(QrCodeTypes.QR);
	// setup Data property to Address instance
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

## Sign PDF with Me-Card information in the QR-Code image

This example shows how to esign PDF with Me-Card inside the QR-code image.

```java
Signature signature = new Signature("sample.pdf")
{
    // create MeCard object
    MeCard meCard = new MeCard();
	meCard.setName("Sherlock");
	meCard.setNickname("Jay");
	meCard.setReading("Holmes");
	meCard.setNote("Base Detective");
	meCard.setPhone("0333 003 3577");
	meCard.setAltPhone("0333 003 3512");
	meCard.setEmail("watson@sherlockholmes.com");
	meCard.setUrl("http://sherlockholmes.com/");
	meCard.setBirthDay(new Date(1854, 1, 6));
	Address address = new Address();
	address.setStreet("221B Baker Street");
	address.setCity("London");
	address.setState("NW");
	address.setZIP("NW16XE");
	address.setCountry("England");
	meCard.setAddress(address);

	// create options
	QrCodeSignOptions options = new QrCodeSignOptions();
	options.setEncodeType(QrCodeTypes.QR);
	// setup Data property to MeCard instance
	options.setData(meCard);
	// set right bottom corner
	options.setHorizontalAlignment(HorizontalAlignment.Right);
	options.setVerticalAlignment(VerticalAlignment.Bottom);
	options.setMargin(new Padding(10));
	options.setWidth(100);
	options.setHeight(100);

    // sign document to file
    signature.Sign("output.pdf", options);
}
```

## Sign PDF with EPC payment in the QR-Code image

This example shows how to esign PDF with EPC / SEPA payment inside the QR-code image.

```java
Signature signature = new Signature("sample.pdf")
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

## Sign PDF with Event information in the QR-Code image

This example shows how to esign PDF with event data inside the QR-code image.

```java
Signature signature = new Signature("sample.pdf")
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

## More resources

### GitHub Examples

You may easily run the code above and see the feature in action in our GitHub examples:

* [GroupDocs.Signature for .NET examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET)
* [GroupDocs.Signature for Java examples, plugins, and showcase](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)
* [Document Signature for .NET MVC UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-MVC)
* [Document Signature for .NET App WebForms UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-.NET-WebForms)
* [Document Signature for Java App Dropwizard UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Dropwizard)
* [Document Signature for Java Spring UI Example](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java-Spring)

### Free Online App

Along with full-featured .NET library we provide simple, but powerful free Apps.

You are welcome to eSign PDF, Word, Excel, PowerPoint documents with free to use online **[GroupDocs Signature App](https://products.groupdocs.app/signature)**.
