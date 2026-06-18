### GroupDocs Document Signature API

[Product Page](https://products.groupdocs.com/signature/java) | [Docs](https://docs.groupdocs.com/signature/java/) | [Demos](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/signature) | [Examples](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/signature/) | [Free Support](https://forum.groupdocs.com/c/signature) | [Temporary License](https://purchase.groupdocs.com/temporary-license)

**GroupDocs.Signature Demos** are applications that demonstrate powerful features of [GroupDocs.Signature for Java](https://products.groupdocs.com/signature/java) distributed as Docker images. Sign **PDF, DOCX, PPT, XLS**, and over 90 document formats with text, image, barcode, QR code, stamp, and digital certificate signatures. Use these images as-is or customize and integrate them into your own project.

**Note:** without a license the application runs in trial mode. [Purchase a license](https://purchase.groupdocs.com/signature/java) or request a [temporary license](https://purchase.groupdocs.com/temporary-license).

## Security Notice

These Docker images ship **sample/demo applications** — not production-ready services.

- Intended for **local development and evaluation** only
- Demo defaults enable upload, browse, and download; **no authentication** is included
- Do **not** expose port `8080` to untrusted networks without authentication, a reverse proxy, path validation, and other controls required by your organization
- For production, use the [GroupDocs.Signature library](https://docs.groupdocs.com/signature/java/) and implement your own secure document storage and API layer

Source code: [GroupDocs.Signature-for-Java](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java)

## Supported Document Formats

GroupDocs.Signature for Java supports **90+ document formats** including Microsoft Office, PDF, images, OpenDocument, and more. See the [full list of supported formats](https://docs.groupdocs.com/signature/java/supported-document-formats/) in the documentation.

## Document Signature Demo Features

- Clean, modern and intuitive design
- Responsive design and mobile support
- Digital certificate, image, text, stamp, barcode, and QR code signatures
- Draw signature with finger on mobile devices
- Download, upload, and sign documents
- Sign password-protected documents
- Cross-browser and cross-platform support

## Available Docker Images

Six images are published for each GroupDocs.Signature for Java release: three Spring and three Dropwizard variants.

Tag format: `{version}-java-{jdk}-bullseye-{framework}`

Example: `{{VERSION}}-java-openjdk8-bullseye-dropwizard` — GroupDocs.Signature for Java **{{VERSION}}**, Eclipse Temurin 8, Debian Bullseye, Dropwizard.

| Tag | JDK | Framework |
| --- | --- | --- |
| `{{VERSION}}-java-openjdk8-bullseye-dropwizard` | Eclipse Temurin 8 | Dropwizard |
| `{{VERSION}}-java-openjdk11-bullseye-dropwizard` | Eclipse Temurin 11 | Dropwizard |
| `{{VERSION}}-java-openjdk18-bullseye-dropwizard` | Eclipse Temurin 21 | Dropwizard |
| `{{VERSION}}-java-openjdk8-bullseye-spring` | Eclipse Temurin 8 | Spring |
| `{{VERSION}}-java-openjdk11-bullseye-spring` | Eclipse Temurin 11 | Spring |
| `{{VERSION}}-java-openjdk18-bullseye-spring` | Eclipse Temurin 21 | Spring |

The `latest` tag points to the `{{VERSION}}-java-openjdk18-bullseye-spring` variant when published with the **latest** workflow option.

## How to Run

Pull and run a Dropwizard image:

```shell
docker run -p 8080:8080 --name signature --rm groupdocs/signature:{{VERSION}}-java-openjdk8-bullseye-dropwizard
# Open http://localhost:8080/signature/ in your browser.
```

Bind volumes for sample files and license:

```shell
docker run -p 8080:8080 --name signature --rm \
  -v "C:/DocumentSamples/:/home/groupdocs/app/DocumentSamples" \
  -v "C:/Licenses/:/home/groupdocs/app/Licenses" \
  groupdocs/signature:{{VERSION}}-java-openjdk8-bullseye-dropwizard
```

The sample reads license files from the mounted `Licenses` directory and lists documents from `DocumentSamples`.

## Signature Configuration Options

Environment variables:

| Variable | Description | Default |
| --- | --- | --- |
| `LIC_PATH` | Path to directory with license file | `/home/groupdocs/app/Licenses` |
| `DOWNLOAD_ON` | Enable download button in UI | `true` |
| `UPLOAD_ON` | Enable file upload | `true` |
| `FILES_DIR` | Directory for uploaded files | `/home/groupdocs/app/DocumentSamples` |
| `HOST_ADDRESS` | Host name or IP for the server instance | (empty) |

## See Also

- [View documents](https://products.groupdocs.com/viewer/java) with GroupDocs.Viewer
- [Compare documents](https://products.groupdocs.com/comparison/java) with GroupDocs.Comparison
- [Annotate documents](https://products.groupdocs.com/annotation/java) with GroupDocs.Annotation

[Product Page](https://products.groupdocs.com/signature/java) | [Docs](https://docs.groupdocs.com/signature/java/) | [Demos](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/tree/master/Demos) | [API Reference](https://apireference.groupdocs.com/java/signature) | [Examples](https://github.com/groupdocs-signature/GroupDocs.Signature-for-Java/tree/master/Examples) | [Blog](https://blog.groupdocs.com/category/signature/) | [Free Support](https://forum.groupdocs.com/c/signature) | [Temporary License](https://purchase.groupdocs.com/temporary-license)
