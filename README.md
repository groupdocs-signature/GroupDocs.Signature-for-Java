# GroupDocs.Signature for Java

> A Java library to create, apply, verify, and remove digital and electronic signatures from documents, including PDFs, Word, Excel, Images, and more. Supports text, image, barcode, QR code, stamp, metadata, and certificate-based digital signatures.

---

## About

This repository provides usage examples and demos for **GroupDocs.Signature for Java**, a powerful API for adding and verifying signatures in Java-based applications. It supports **over 90 document formats**, enabling developers to streamline digital signing workflows across platforms.

---

### 🔑 Key Features

- Apply and verify digital signatures with X.509 certificates
- Add text, image, barcode, QR code, and stamp signatures
- Insert metadata, form field, and timestamp signatures
- Search for or remove existing signatures from documents
- Compatible with Java SE, EE, and Spring-based applications

---

## 🔧 Supported Signature Types

| Signature Type     | Description                                |
|--------------------|--------------------------------------------|
| **Digital Signatures** | X.509 certificate-based signatures for legal compliance |
| **Image Signatures**   | Draw or upload images (PNG, JPEG, SVG, BMP)    |
| **Text Signatures**    | Add custom text annotations with fonts & styles |
| **QR-Code Signatures** | Generate QR codes with custom data/format   |
| **Barcode Signatures** | Add/search/remove barcodes from documents         |
| **Stamp Signatures**   | Custom stamps with date/user info/company logos |
| **Metadata Signatures** | Hidden signatures for document tracking & authentication |
| **Form Field Signatures** | Interactive signature fields for workflows |

---

## 📁 Supported Document Formats (90+)

**Office Documents:**
- Microsoft Word (DOC, DOCX, DOCM, DOT, DOTX, DOTM)
- Excel (XLS, XLSX, XLSM, XLSB, XLT, XLTX, XLTM)
- PowerPoint (PPT, PPTX, PPTM, PPS, PPSX)
- Visio (VSD, VSDX, VSS, VSSX, VST, VSTX)

**PDFs & Images:**
- PDF (Portable Document Format)
- Images (PNG, JPG, JPEG, BMP, TIFF, GIF, SVG, WEBP)

**Other Formats:**
- OpenDocument (ODT, ODS, ODP)
- Text files (TXT, RTF, CSV)
- Web formats (HTML, HTM)
- And many more...

---

## 💻 Code Examples

### ✅ Search for Digital Signatures in Excel XLSX

```java
Signature signature = new Signature("spreadsheet.xlsx");
DigitalSearchOptions options = new DigitalSearchOptions();

// Search for signatures in document
List<DigitalSignature> signatures = signature.search(DigitalSignature.class, options);
System.out.print("\nSource document contains following signatures.");
for (DigitalSignature digitalSignature : signatures) {
    System.out.print("Digital signature found from " + digitalSignature.getSignTime() +
                     " with validation flag " + digitalSignature.isValid() +
                     ". Certificate SN " + digitalSignature.getCertificate().getType());
}
```

---

### ✍️ Digitally Sign a PDF with Certificate
```java
Signature signature = new Signature("sample.pdf");
DigitalSignOptions options = new DigitalSignOptions("certificate.pfx");

// Set certificate password and details
options.setPassword("1234567890");
options.setReason("Sign");
options.setContact("JohnSmith");
options.setLocation("Office1");

// Set image appearance
options.setImageFilePath("sample.jpg");
options.setAllPages(true);
options.setWidth(80);
options.setHeight(60);
options.setVerticalAlignment(VerticalAlignment.Bottom);
options.setHorizontalAlignment(HorizontalAlignment.Right);

// Set margins
Padding padding = new Padding();
padding.setBottom(10);
padding.setRight(10);
options.setMargin(padding);

// Apply signature
SignResult signResult = signature.sign("signed.pdf", options);

// Print results
System.out.print("List of newly created signatures:");
int number = 1;
for (BaseSignature temp : signResult.getSucceeded()) {
    System.out.print("Signature #" + number++ +
                     ": Type: " + temp.getSignatureType() +
                     " Id: " + temp.getSignatureId() +
                     ", Location: " + temp.getLeft() + "x" + temp.getTop() +
                     ". Size: " + temp.getWidth() + "x" + temp.getHeight());
}
```
---

### 📚 Documentation and Resources

- [Official Documentation](https://docs.groupdocs.com/signature/java/)
- [Free Support Forum](https://forum.groupdocs.com/c/signature)
- [License Terms](https://purchase.groupdocs.com/policies/license) – Commercial licensing
- [Release Notes](https://releases.groupdocs.com/signature/java/) – Latest updates and changelog

---

## Looking for GroupDocs.Signature for .NET?

👉 [View the .NET version here](https://github.com/groupdocs-signature/GroupDocs.Signature-for-NET)

<!-- SEO Keywords: digital signature, create digital signature, document sign, document signature, e sign, e sign process, e signature, e signature from image, electronic sign, electronic signature, signature e sign, groupdocs signature, sign documents online, sign pdf doc, sign pdf document, sign the pdf, sign to pdf, signature app, signature pdf, signing pdf document, csv file signature, remove barcode from pdf, qr code remover from pdf, signature valid png, get a signature, signature api, signature java, esign pdf, file signature, verify signature, create signature, image signature -->

---

### 🔖 Tags

`java digital signature` `sign pdf java` `e-sign java` `signature api java` `groupdocs signature java`  
`image signature java` `verify signature java` `electronic signature java` `document signing java`  
`sign excel java` `sign word java` `sign image java` `qr code signature java` `barcode signature java`
