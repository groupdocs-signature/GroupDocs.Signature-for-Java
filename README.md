# GroupDocs.Signature for Java

> A Java library to create, apply, verify, and remove digital and electronic signatures from documents, including PDFs, Word, Excel, Images, and more. Supports text, image, barcode, QR code, stamp, metadata, and certificate-based digital signatures.

## Important: Demo Applications Only

The projects in the [Demos](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/tree/master/Demos) folder and the Docker images published as [`groupdocs/signature`](https://hub.docker.com/r/groupdocs/signature) are **sample applications** intended to demonstrate [GroupDocs.Signature for Java](https://products.groupdocs.com/signature/java) features.

They are **not** production-ready services and must **not** be exposed to the public internet without additional hardening.

Before using a demo in any shared or production-like environment:

- Run it on `localhost` or a trusted private network only
- Do not publish Docker containers directly to the internet without authentication, a reverse proxy, and network restrictions
- Treat file upload, browse, and download features as untrusted input — validate and sandbox file paths in your own integration
- Add authentication, authorization, rate limiting, and logging appropriate for your security requirements
- Keep GroupDocs.Signature and all dependencies up to date

For production integrations, use the library ([Examples](Examples), [documentation](https://docs.groupdocs.com/signature/java/)) and implement your own secure document storage and API layer instead of deploying these demos as-is.

## Repository Structure

Directory | Description
--------- | -----------
[Demos](Demos) | Demo projects for Spring, Dropwizard, Javalin, Ktor, Micronaut, and Compose Desktop.
[Examples](Examples) | Java API usage examples with sample documents.

## Demos

All web demos run on `http://localhost:8080/signature/` and provide document signing with digital certificates, images, text, stamps, barcodes, and QR codes.

| Demo | Framework | Language | Build | Version |
|------|-----------|----------|-------|---------|
| [Spring](Demos/Spring) | Spring Boot 2.5 | Java | `mvn clean spring-boot:run` | 26.5 |
| [Dropwizard](Demos/Dropwizard) | Dropwizard 1.3 | Java | `mvn clean compile exec:java` | 26.5 |
| [Javalin](Demos/Javalin) | Javalin 4.6 | Kotlin | `./gradlew run` | 26.5 |
| [Ktor](Demos/Ktor) | Ktor | Kotlin | `./gradlew run` | 26.5 |
| [Micronaut](Demos/Micronaut) | Micronaut 3.4 | Kotlin | `./gradlew run` | 26.5 |
| [Compose](Demos/Compose) | Compose Desktop | Kotlin | `./gradlew run` | 26.5 |

The [Compose](Demos/Compose) demo is a standalone desktop application (not a web app).

## Docker

Pre-built Docker images are available on [Docker Hub](https://hub.docker.com/r/groupdocs/signature).

```bash
docker pull groupdocs/signature:latest
docker run -p 8080:8080 groupdocs/signature:latest
```

**Security notice:** Docker images ship with demo defaults (e.g. upload and browse enabled, no authentication). Use them for local evaluation only. Do not expose port `8080` to untrusted networks without adding authentication, path validation, and other security controls required by your organization.

Available image tags follow the pattern `{version}-java-{jdk}-bullseye-{framework}`:

| Tag | JDK | Framework |
|-----|-----|-----------|
| `{ver}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{ver}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{ver}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |
| `{ver}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{ver}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{ver}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |

The `latest` tag points to the `openjdk18-bullseye-spring` variant.

The [Docker Hub repository overview](https://hub.docker.com/r/groupdocs/signature) is generated from [`docs/docker-hub-overview.md`](docs/docker-hub-overview.md) when the [Publish Docker Images](.github/workflows/docker-publish.yml) workflow runs with **Push** enabled.

## Getting Started

GroupDocs.Signature for Java requires J2SE 8.0 (1.8) or above.

Add the [GroupDocs repository](https://releases.groupdocs.com/java/repo/) to your Maven project:

```xml
<repository>
    <id>GroupDocs Artifact Repository</id>
    <url>https://releases.groupdocs.com/java/repo/</url>
</repository>

<dependency>
    <groupId>com.groupdocs</groupId>
    <artifactId>groupdocs-signature</artifactId>
    <version>26.5</version>
</dependency>
```


## About

This repository provides usage examples and demos for **GroupDocs.Signature for Java**, a powerful API for adding and verifying signatures in Java-based applications. It supports **over 90 document formats**, enabling developers to streamline digital signing workflows across platforms.


## 🔑 Key Features

- [Apply](https://docs.groupdocs.com/signature/java/electronic-signature-types/) and [verify](https://docs.groupdocs.com/signature/java/verify-barcode-signatures-in-the-document/) digital signatures with X.509 certificates
- [Add](https://docs.groupdocs.com/signature/java/esign-document-with-text-signature/) text, image, barcode, QR code, and stamp signatures
- Insert [metadata](https://docs.groupdocs.com/signature/java/esign-document-with-metadata-signature/), form field, and timestamp signatures
- [Search](https://docs.groupdocs.com/signature/java/search-for-electronic-signatures-in-document/) for or remove existing signatures from documents
- Compatible with Java SE, EE, and Spring-based applications


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
- And many [more...](https://docs.groupdocs.com/signature/java/supported-document-formats/)


## 💻 Code Examples

### Search for Digital Signatures in Excel XLSX

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


### Digitally Sign a PDF with Certificate
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


## 📚 Documentation and Resources

- [Official Documentation](https://docs.groupdocs.com/signature/java/)
- [Free Support Forum](https://forum.groupdocs.com/c/signature)
- [License Terms](https://purchase.groupdocs.com/policies/license) – Commercial licensing
- [Release Notes](https://releases.groupdocs.com/signature/java/) – Latest updates and changelog


## Looking for GroupDocs.Signature for .NET?

👉 [View the .NET version here](https://github.com/groupdocs-signature/GroupDocs.Signature-for-NET)

<!-- SEO Keywords: digital signature, create digital signature, document sign, document signature, e sign, e sign process, e signature, e signature from image, electronic sign, electronic signature, signature e sign, groupdocs signature, sign documents online, sign pdf doc, sign pdf document, sign the pdf, sign to pdf, signature app, signature pdf, signing pdf document, csv file signature, remove barcode from pdf, qr code remover from pdf, signature valid png, get a signature, signature api, signature java, esign pdf, file signature, verify signature, create signature, image signature -->


## 🔖 Tags

`java digital signature` `sign pdf java` `e-sign java` `signature api java` `groupdocs signature java`  
`image signature java` `verify signature java` `electronic signature java` `document signing java`  
`sign excel java` `sign word java` `sign image java` `qr code signature java` `barcode signature java`
