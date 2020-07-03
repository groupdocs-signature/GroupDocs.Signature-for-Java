---
id: groupdocs-signature-for-java-19-11-release-notes
url: signature/java/groupdocs-signature-for-java-19-11-release-notes
title: GroupDocs.Signature for Java 19.11 Release Notes
weight: 1
description: ""
keywords: 
productName: GroupDocs.Signature for Java
hideChildren: False
---
{{< alert style="info" >}}This page contains release notes for GroupDocs.Signature for Java 19.11{{< /alert >}}

## Major Features

{{< alert style="danger" >}}In this version we're introducing new public API which was designed to be simple and easy to use. For more details about new API please check Developer Guide section. The legacy API have been moved into Legacy namespace so after update to this version it is required to make project-wide replacement of namespace usages from com.groupdocs.signature. to com.groupdocs.signature.legacy. to resolve build issues.{{< /alert >}}

  
Other notable features:

*   Added support for encryption several metadata signatures with same implementation when signing and searching 
*   Added support of file formats:
    *   Scalable Vector Graphics File (.svg) 
    *   Corel Draw File (.cdr)

## Full List of Issues Covering all Changes in this Release

| Key | Summary | Category |
| --- | --- | --- |
| SIGNATURENET-2202 | Implement Encryption setup to Sign Metadata at options level | Feature |
| SIGNATURENET-2204 | Implement Encryption setup for Search Metadata at Search Options level | Feature |
| SIGNATURENET-2149 | Implement new public Signature V2 API | Feature |
| SIGNATURENET-2154 | Unify document related options and classes for signing, verification and search processes | Improvement |

## Public API and Backward Incompatible Changes

#### All public types from com.groupdocs.signature namespace 

1.  Have been moved into **com.groupdocs.signature.legacy** namespace
2.  Marked as **Obsolete** with message: *This interface/class/enumeration is obsolete and will be available till January 2020 (v20.1).*

#### Full list of types that have been moved and marked as obsolete

1.  com.groupdocs.signature.config.SignatureConfig => com.groupdocs.signature.legacy.config.SignatureConfig
2.  com.groupdocs.signature.domain.BarcodeSignature => com.groupdocs.signature.legacy.domain.BarcodeSignature
3.  com.groupdocs.signature.domain.BarcodeType => com.groupdocs.signature.legacy.domain.BarcodeType
4.  com.groupdocs.signature.domain.BarcodeTypes => com.groupdocs.signature.legacy.domain.BarcodeTypes
5.  com.groupdocs.signature.domain.BaseSignature => com.groupdocs.signature.legacy.domain.BaseSignature
6.  com.groupdocs.signature.domain.BorderLine => com.groupdocs.signature.legacy.domain.BorderLine
7.  com.groupdocs.signature.domain.CellsBarcodeSignature => com.groupdocs.signature.legacy.domain.CellsBarcodeSignature
8.  com.groupdocs.signature.domain.CellsDigitalSignature => com.groupdocs.signature.legacy.domain.CellsDigitalSignature
9.  com.groupdocs.signature.domain.CellsMetadataSignature => com.groupdocs.signature.legacy.domain.CellsMetadataSignature
10.  com.groupdocs.signature.domain.CellsQRCodeSignature => com.groupdocs.signature.legacy.domain.CellsQRCodeSignature
11.  com.groupdocs.signature.domain.CellsSaveFileFormat => com.groupdocs.signature.legacy.domain.CellsSaveFileFormat
12.  com.groupdocs.signature.domain.CellsTextShapeType => com.groupdocs.signature.legacy.domain.CellsTextShapeType
13.  com.groupdocs.signature.domain.CellsTextSignatureImplementation => com.groupdocs.signature.legacy.domain.CellsTextSignatureImplementation
14.  com.groupdocs.signature.domain.CodeTextAlignment => com.groupdocs.signature.legacy.domain.CodeTextAlignment
15.  com.groupdocs.signature.domain.Corners => com.groupdocs.signature.legacy.domain.Corners
16.  com.groupdocs.signature.domain.DashStyle => com.groupdocs.signature.legacy.domain.DashStyle
17.  com.groupdocs.signature.domain.DigitalSignature => com.groupdocs.signature.legacy.domain.DigitalSignature
18.  com.groupdocs.signature.domain.DigitalSignatureType => com.groupdocs.signature.legacy.domain.DigitalSignatureType
19.  com.groupdocs.signature.domain.DocumentDescription => com.groupdocs.signature.legacy.domain.DocumentDescription
20.  com.groupdocs.signature.domain.DocumentPart => com.groupdocs.signature.legacy.domain.DocumentPart
21.  com.groupdocs.signature.domain.ExtendedDashStyle => com.groupdocs.signature.legacy.domain.ExtendedDashStyle
22.  com.groupdocs.signature.domain.Extensions.Address => com.groupdocs.signature.legacy.domain.Extensions.Address
23.  com.groupdocs.signature.domain.Extensions.Brush => com.groupdocs.signature.legacy.domain.Extensions.Brush
24.  com.groupdocs.signature.domain.Extensions.Email => com.groupdocs.signature.legacy.domain.Extensions.Email
25.  com.groupdocs.signature.domain.Extensions.FormatAttribute => com.groupdocs.signature.legacy.domain.Extensions.FormatAttribute
26.  com.groupdocs.signature.domain.Extensions.IDataEncryption => com.groupdocs.signature.legacy.domain.Extensions.IDataEncryption
27.  com.groupdocs.signature.domain.Extensions.IDataSerializer => com.groupdocs.signature.legacy.domain.Extensions.IDataSerializer
28.  com.groupdocs.signature.domain.Extensions.LinearGradientBrush => com.groupdocs.signature.legacy.domain.Extensions.LinearGradientBrush
29.  com.groupdocs.signature.domain.Extensions.RadialGradientBrush => com.groupdocs.signature.legacy.domain.Extensions.RadialGradientBrush
30.  com.groupdocs.signature.domain.Extensions.SignatureExtension => com.groupdocs.signature.legacy.domain.Extensions.SignatureExtension
31.  com.groupdocs.signature.domain.Extensions.SkipSerializationAttribute => com.groupdocs.signature.legacy.domain.Extensions.SkipSerializationAttribute
32.  com.groupdocs.signature.domain.Extensions.SolidBrush => com.groupdocs.signature.legacy.domain.Extensions.SolidBrush
33.  com.groupdocs.signature.domain.Extensions.SymmetricAlgorithmType => com.groupdocs.signature.legacy.domain.Extensions.SymmetricAlgorithmType
34.  com.groupdocs.signature.domain.Extensions.SymmetricEncryption => com.groupdocs.signature.legacy.domain.Extensions.SymmetricEncryption
35.  com.groupdocs.signature.domain.Extensions.SymmetricEncryptionAttribute => com.groupdocs.signature.legacy.domain.Extensions.SymmetricEncryptionAttribute
36.  com.groupdocs.signature.domain.Extensions.TextShadow => com.groupdocs.signature.legacy.domain.Extensions.TextShadow
37.  com.groupdocs.signature.domain.Extensions.TextureBrush => com.groupdocs.signature.legacy.domain.Extensions.TextureBrush
38.  com.groupdocs.signature.domain.Extensions.VCard => com.groupdocs.signature.legacy.domain.Extensions.VCard
39.  com.groupdocs.signature.domain.FileDescription => com.groupdocs.signature.legacy.domain.FileDescription
40.  com.groupdocs.signature.domain.FormField.FormFieldSignature => com.groupdocs.signature.legacy.domain.FormField.FormFieldSignature
41.  com.groupdocs.signature.domain.FormField.FormFieldType => com.groupdocs.signature.legacy.domain.FormField.FormFieldType
42.  com.groupdocs.signature.domain.FormField.PdfCheckboxFormFieldSignature => com.groupdocs.signature.legacy.domain.FormField.PdfCheckboxFormFieldSignature
43.  com.groupdocs.signature.domain.FormField.PdfDigitalFormFieldSignature => com.groupdocs.signature.legacy.domain.FormField.PdfDigitalFormFieldSignature
44.  com.groupdocs.signature.domain.FormField.PdfTextFormFieldSignature => com.groupdocs.signature.legacy.domain.FormField.PdfTextFormFieldSignature
45.  com.groupdocs.signature.domain.HorizontalAlignment => com.groupdocs.signature.legacy.domain.HorizontalAlignment
46.  com.groupdocs.signature.domain.IAlignment => com.groupdocs.signature.legacy.domain.IAlignment
47.  com.groupdocs.signature.domain.ICellsPosition => com.groupdocs.signature.legacy.domain.ICellsPosition
48.  com.groupdocs.signature.domain.ImageMetadataSignature => com.groupdocs.signature.legacy.domain.ImageMetadataSignature
49.  com.groupdocs.signature.domain.ImagesBarcodeSignature => com.groupdocs.signature.legacy.domain.ImagesBarcodeSignature
50.  com.groupdocs.signature.domain.ImagesQRCodeSignature => com.groupdocs.signature.legacy.domain.ImagesQRCodeSignature
51.  com.groupdocs.signature.domain.ImagesSaveFileFormat => com.groupdocs.signature.legacy.domain.ImagesSaveFileFormat
52.  com.groupdocs.signature.domain.ImagesTextSignatureImplementation => com.groupdocs.signature.legacy.domain.ImagesTextSignatureImplementation
53.  com.groupdocs.signature.domain.IOpacity => com.groupdocs.signature.legacy.domain.IOpacity
54.  com.groupdocs.signature.domain.IRectangle => com.groupdocs.signature.legacy.domain.IRectangle
55.  com.groupdocs.signature.domain.IRotation => com.groupdocs.signature.legacy.domain.IRotation
56.  com.groupdocs.signature.domain.ITextAlignment => com.groupdocs.signature.legacy.domain.ITextAlignment
57.  com.groupdocs.signature.domain.MeasureType => com.groupdocs.signature.legacy.domain.MeasureType
58.  com.groupdocs.signature.domain.MetadataSignature => com.groupdocs.signature.legacy.domain.MetadataSignature
59.  com.groupdocs.signature.domain.MetadataSignatureCollection => com.groupdocs.signature.legacy.domain.MetadataSignatureCollection\\
60.  com.groupdocs.signature.domain.Padding => com.groupdocs.signature.legacy.domain.Padding
61.  com.groupdocs.signature.domain.PageDescription => com.groupdocs.signature.legacy.domain.PageDescription
62.  com.groupdocs.signature.domain.PathType => com.groupdocs.signature.legacy.domain.PathType
63.  com.groupdocs.signature.domain.PdfBarcodeSignature => com.groupdocs.signature.legacy.domain.PdfBarcodeSignature
64.  com.groupdocs.signature.domain.PDFDigitalSignature => com.groupdocs.signature.legacy.domain.PDFDigitalSignature
65.  com.groupdocs.signature.domain.PdfFormTextFieldType => com.groupdocs.signature.legacy.domain.PdfFormTextFieldType
66.  com.groupdocs.signature.domain.PdfMetadataSignature => com.groupdocs.signature.legacy.domain.PdfMetadataSignature
67.  com.groupdocs.signature.domain.PdfMetadataSignatures => com.groupdocs.signature.legacy.domain.PdfMetadataSignatures
68.  com.groupdocs.signature.domain.PdfQRCodeSignature => com.groupdocs.signature.legacy.domain.PdfQRCodeSignature
69.  com.groupdocs.signature.domain.PdfSaveFileFormat => com.groupdocs.signature.legacy.domain.PdfSaveFileFormat
70.  com.groupdocs.signature.domain.PdfTextAnnotationBorderEffect => com.groupdocs.signature.legacy.domain.PdfTextAnnotationBorderEffect
71.  com.groupdocs.signature.domain.PdfTextAnnotationBorderStyle => com.groupdocs.signature.legacy.domain.PdfTextAnnotationBorderStyle
72.  com.groupdocs.signature.domain.PdfTextSignatureImplementation => com.groupdocs.signature.legacy.domain.PdfTextSignatureImplementation
73.  com.groupdocs.signature.domain.PdfTextStickerIcon => com.groupdocs.signature.legacy.domain.PdfTextStickerIcon
74.  com.groupdocs.signature.domain.PdfTextStickerState => com.groupdocs.signature.legacy.domain.PdfTextStickerState
75.  com.groupdocs.signature.domain.Position => com.groupdocs.signature.legacy.domain.Position
76.  com.groupdocs.signature.domain.PositionInCellsDocument => com.groupdocs.signature.legacy.domain.PositionInCellsDocument
77.  com.groupdocs.signature.domain.ProcessStatus => com.groupdocs.signature.legacy.domain.ProcessStatus
78.  com.groupdocs.signature.domain.QRCodeSignature => com.groupdocs.signature.legacy.domain.QRCodeSignature
79.  com.groupdocs.signature.domain.QRCodeType => com.groupdocs.signature.legacy.domain.QRCodeType
80.  com.groupdocs.signature.domain.QRCodeTypes => com.groupdocs.signature.legacy.domain.QRCodeTypes
81.  com.groupdocs.signature.domain.ResizeType => com.groupdocs.signature.legacy.domain.ResizeType
82.  com.groupdocs.signature.domain.SearchResult => com.groupdocs.signature.legacy.domain.SearchResult
83.  com.groupdocs.signature.domain.SignatureFont => com.groupdocs.signature.legacy.domain.SignatureFont
84.  com.groupdocs.signature.domain.SignedDocumentInfo => com.groupdocs.signature.legacy.domain.SignedDocumentInfo
85.  com.groupdocs.signature.domain.SlidesBarcodeSignature => com.groupdocs.signature.legacy.domain.SlidesBarcodeSignature
86.  com.groupdocs.signature.domain.SlidesMetadataSignature => com.groupdocs.signature.legacy.domain.SlidesMetadataSignature
87.  com.groupdocs.signature.domain.SlidesQRCodeSignature => com.groupdocs.signature.legacy.domain.SlidesQRCodeSignature
88.  com.groupdocs.signature.domain.SlidesSaveFileFormat => com.groupdocs.signature.legacy.domain.SlidesSaveFileFormat
89.  com.groupdocs.signature.domain.SlidesTextShapeType => com.groupdocs.signature.legacy.domain.SlidesTextShapeType
90.  com.groupdocs.signature.domain.SlidesTextSignatureImplementation => com.groupdocs.signature.legacy.domain.SlidesTextSignatureImplementation
91.  com.groupdocs.signature.domain.SquareBorderLine => com.groupdocs.signature.legacy.domain.SquareBorderLine
92.  com.groupdocs.signature.domain.StampBackgroundCropType => com.groupdocs.signature.legacy.domain.StampBackgroundCropType
93.  com.groupdocs.signature.domain.StampLine => com.groupdocs.signature.legacy.domain.StampLine
94.  com.groupdocs.signature.domain.StampTextRepeatType => com.groupdocs.signature.legacy.domain.StampTextRepeatType
95.  com.groupdocs.signature.domain.StampType => com.groupdocs.signature.legacy.domain.StampType
96.  com.groupdocs.signature.domain.StampTypes => com.groupdocs.signature.legacy.domain.StampTypes
97.  com.groupdocs.signature.domain.StretchMode => com.groupdocs.signature.legacy.domain.StretchMode
98.  com.groupdocs.signature.domain.TextHorizontalAlignment => com.groupdocs.signature.legacy.domain.TextHorizontalAlignment
99.  com.groupdocs.signature.domain.TextMatchType => com.groupdocs.signature.legacy.domain.TextMatchType
100.  com.groupdocs.signature.domain.TextVerticalAlignment => com.groupdocs.signature.legacy.domain.TextVerticalAlignment
101.  com.groupdocs.signature.domain.VerificationResult => com.groupdocs.signature.legacy.domain.VerificationResult
102.  com.groupdocs.signature.domain.VerticalAlignment => com.groupdocs.signature.legacy.domain.VerticalAlignment
103.  com.groupdocs.signature.domain.WordsBarcodeSignature => com.groupdocs.signature.legacy.domain.WordsBarcodeSignature
104.  com.groupdocs.signature.domain.WordsDigitalSignature => com.groupdocs.signature.legacy.domain.WordsDigitalSignature
105.  com.groupdocs.signature.domain.WordsFormTextFieldType => com.groupdocs.signature.legacy.domain.WordsFormTextFieldType
106.  com.groupdocs.signature.domain.WordsMetadataSignature => com.groupdocs.signature.legacy.domain.WordsMetadataSignature
107.  com.groupdocs.signature.domain.WordsQRCodeSignature => com.groupdocs.signature.legacy.domain.WordsQRCodeSignature
108.  com.groupdocs.signature.domain.WordsSaveFileFormat => com.groupdocs.signature.legacy.domain.WordsSaveFileFormat
109.  com.groupdocs.signature.domain.WordsTextShapeType => com.groupdocs.signature.legacy.domain.WordsTextShapeType
110.  com.groupdocs.signature.domain.WordsTextSignatureImplementation => com.groupdocs.signature.legacy.domain.WordsTextSignatureImplementation
111.  com.groupdocs.signature.exception.GroupDocsSignatureException => com.groupdocs.signature.legacy.exception.GroupDocsSignatureException
112.  com.groupdocs.signature.handler.Input.IInputDataHandler => com.groupdocs.signature.legacy.handler.Input.IInputDataHandler
113.  com.groupdocs.signature.handler.Output.IOutputDataHandler => com.groupdocs.signature.legacy.handler.Output.IOutputDataHandler
114.  com.groupdocs.signature.handler.ProcessCompleteEventArgs => com.groupdocs.signature.legacy.handler.ProcessCompleteEventArgs
115.  com.groupdocs.signature.handler.ProcessCompleteEventHandler => com.groupdocs.signature.legacy.handler.ProcessCompleteEventHandler
116.  com.groupdocs.signature.handler.ProcessEventArgs => com.groupdocs.signature.legacy.handler.ProcessEventArgs
117.  com.groupdocs.signature.handler.ProcessProgressEventArgs => com.groupdocs.signature.legacy.handler.ProcessProgressEventArgs
118.  com.groupdocs.signature.handler.ProcessProgressEventHandler => com.groupdocs.signature.legacy.handler.ProcessProgressEventHandler
119.  com.groupdocs.signature.handler.ProcessStartEventArgs => com.groupdocs.signature.legacy.handler.ProcessStartEventArgs
120.  com.groupdocs.signature.handler.ProcessStartEventHandler => com.groupdocs.signature.legacy.handler.ProcessStartEventHandle
121.  com.groupdocs.signature.handler.SignatureHandler => com.groupdocs.signature.legacy.handler.SignatureHandler
122.  com.groupdocs.signature.License => com.groupdocs.signature.legacy.License
123.  com.groupdocs.signature.Metered => com.groupdocs.signature.legacy.Metered
124.  com.groupdocs.signature.options.BarcodeSignOptions => com.groupdocs.signature.legacy.options.BarcodeSignOptions
125.  com.groupdocs.signature.options.BitmapCompression => com.groupdocs.signature.legacy.options.BitmapCompression
126.  com.groupdocs.signature.options.BmpSaveOptions => com.groupdocs.signature.legacy.options.BmpSaveOptions
127.  com.groupdocs.signature.options.CellsBarcodeSignOptions => com.groupdocs.signature.legacy.options.CellsBarcodeSignOptions
128.  com.groupdocs.signature.options.CellsMetadataSignOptions => com.groupdocs.signature.legacy.options.CellsMetadataSignOptions
129.  com.groupdocs.signature.options.CellsQRCodeSignOptions => com.groupdocs.signature.legacy.options.CellsQRCodeSignOptions
130.  com.groupdocs.signature.options.CellsSaveOptions => com.groupdocs.signature.legacy.options.CellsSaveOptions
131.  com.groupdocs.signature.options.CellsSearchBarcodeOptions => com.groupdocs.signature.legacy.options.CellsSearchBarcodeOptions
132.  com.groupdocs.signature.options.CellsSearchDigitalOptions => com.groupdocs.signature.legacy.options.CellsSearchDigitalOptions
133.  com.groupdocs.signature.options.CellsSearchMetadataOptions => com.groupdocs.signature.legacy.options.CellsSearchMetadataOptions
134.  com.groupdocs.signature.options.CellsSearchQRCodeOptions => com.groupdocs.signature.legacy.options.CellsSearchQRCodeOptions
135.  com.groupdocs.signature.options.CellsSignDigitalOptions => com.groupdocs.signature.legacy.options.CellsSignDigitalOptions
136.  com.groupdocs.signature.options.CellsSignImageOptions => com.groupdocs.signature.legacy.options.CellsSignImageOptions
137.  com.groupdocs.signature.options.CellsSignTextOptions => com.groupdocs.signature.legacy.options.CellsSignTextOptions
138.  com.groupdocs.signature.options.CellsStampSignOptions => com.groupdocs.signature.legacy.options.CellsStampSignOptions
139.  com.groupdocs.signature.options.CellsVerifyBarcodeOptions => com.groupdocs.signature.legacy.options.CellsVerifyBarcodeOptions
140.  com.groupdocs.signature.options.CellsVerifyDigitalOptions => com.groupdocs.signature.legacy.options.CellsVerifyDigitalOptions
141.  com.groupdocs.signature.options.CellsVerifyQRCodeOptions => com.groupdocs.signature.legacy.options.CellsVerifyQRCodeOptions
142.  com.groupdocs.signature.options.CellsVerifyTextOptions => com.groupdocs.signature.legacy.options.CellsVerifyTextOptions
143.  com.groupdocs.signature.options.DigitalSignatureAppearance => com.groupdocs.signature.legacy.options.DigitalSignatureAppearance
144.  com.groupdocs.signature.options.ExportImageSaveOptions => com.groupdocs.signature.legacy.options.ExportImageSaveOptions
145.  com.groupdocs.signature.options.GifSaveOptions => com.groupdocs.signature.legacy.options.GifSaveOptions
146.  com.groupdocs.signature.options.ImageAppearance => com.groupdocs.signature.legacy.options.ImageAppearance
147.  com.groupdocs.signature.options.ImagesBarcodeSignOptions => com.groupdocs.signature.legacy.options.ImagesBarcodeSignOptions
148.  com.groupdocs.signature.options.ImagesMetadataSignOptions => com.groupdocs.signature.legacy.options.ImagesMetadataSignOptions
149.  com.groupdocs.signature.options.ImagesQRCodeSignOptions => com.groupdocs.signature.legacy.options.ImagesQRCodeSignOptions
150.  com.groupdocs.signature.options.ImagesSaveOptions => com.groupdocs.signature.legacy.options.ImagesSaveOptions
151.  com.groupdocs.signature.options.ImagesSearchBarcodeOptions => com.groupdocs.signature.legacy.options.ImagesSearchBarcodeOptions
152.  com.groupdocs.signature.options.ImagesSearchMetadataOptions => com.groupdocs.signature.legacy.options.ImagesSearchMetadataOptions
153.  com.groupdocs.signature.options.ImagesSearchQRCodeOptions => com.groupdocs.signature.legacy.options.ImagesSearchQRCodeOptions
154.  com.groupdocs.signature.options.ImagesSignImageOptions => com.groupdocs.signature.legacy.options.ImagesSignImageOptions
155.  com.groupdocs.signature.options.ImagesSignTextOptions => com.groupdocs.signature.legacy.options.ImagesSignTextOptions
156.  com.groupdocs.signature.options.ImagesStampSignOptions => com.groupdocs.signature.legacy.options.ImagesStampSignOptions
157.  com.groupdocs.signature.options.ImagesVerifyBarcodeOptions => com.groupdocs.signature.legacy.options.ImagesVerifyBarcodeOptions
158.  com.groupdocs.signature.options.ImagesVerifyQRCodeOptions => com.groupdocs.signature.legacy.options.ImagesVerifyQRCodeOptions
159.  com.groupdocs.signature.options.JpegCompressionColorMode => com.groupdocs.signature.legacy.options.JpegCompressionColorMode
160.  com.groupdocs.signature.options.JpegCompressionMode => com.groupdocs.signature.legacy.options.JpegCompressionMode
161.  com.groupdocs.signature.options.JpegRoundingMode => com.groupdocs.signature.legacy.options.JpegRoundingMode
162.  com.groupdocs.signature.options.JpegSaveOptions => com.groupdocs.signature.legacy.options.JpegSaveOptions
163.  com.groupdocs.signature.options.LoadOptions => com.groupdocs.signature.legacy.options.LoadOptions
164.  com.groupdocs.signature.options.MetadataSignOptions => com.groupdocs.signature.legacy.options.MetadataSignOptions
165.  com.groupdocs.signature.options.OutputType => com.groupdocs.signature.legacy.options.OutputType
166.  com.groupdocs.signature.options.PagesSetup => com.groupdocs.signature.legacy.options.PagesSetup
167.  com.groupdocs.signature.options.PdfBarcodeSignOptions => com.groupdocs.signature.legacy.options.PdfBarcodeSignOptions
168.  com.groupdocs.signature.options.PdfFormFieldSignOptions => com.groupdocs.signature.legacy.options.PdfFormFieldSignOptions
169.  com.groupdocs.signature.options.PdfMetadataSignOptions => com.groupdocs.signature.legacy.options.PdfMetadataSignOptions
170.  com.groupdocs.signature.options.PdfQRCodeSignOptions => com.groupdocs.signature.legacy.options.PdfQRCodeSignOptions
171.  com.groupdocs.signature.options.PdfSaveOptions => com.groupdocs.signature.legacy.options.PdfSaveOptions
172.  com.groupdocs.signature.options.PdfSearchBarcodeOptions => com.groupdocs.signature.legacy.options.PdfSearchBarcodeOptions
173.  com.groupdocs.signature.options.PdfSearchDigitalOptions => com.groupdocs.signature.legacy.options.PdfSearchDigitalOptions
174.  com.groupdocs.signature.options.PdfSearchFormFieldOptions => com.groupdocs.signature.legacy.options.PdfSearchFormFieldOption
175.  com.groupdocs.signature.options.PdfSearchMetadataOptions => com.groupdocs.signature.legacy.options.PdfSearchMetadataOptions
176.  com.groupdocs.signature.options.PdfSearchQRCodeOptions => com.groupdocs.signature.legacy.options.PdfSearchQRCodeOptions
177.  com.groupdocs.signature.options.PdfSignDigitalOptions => com.groupdocs.signature.legacy.options.PdfSignDigitalOptions
178.  com.groupdocs.signature.options.PdfSignImageOptions => com.groupdocs.signature.legacy.options.PdfSignImageOptions
179.  com.groupdocs.signature.options.PdfSignTextOptions => com.groupdocs.signature.legacy.options.PdfSignTextOptions
180.  com.groupdocs.signature.options.PdfStampSignOptions => com.groupdocs.signature.legacy.options.PdfStampSignOptions
181.  com.groupdocs.signature.options.PdfTextAnnotationAppearance => com.groupdocs.signature.legacy.options.PdfTextAnnotationAppearance
182.  com.groupdocs.signature.options.PdfTextAnnotationVerifyExtensions => com.groupdocs.signature.legacy.options.PdfTextAnnotationVerifyExtensions
183.  com.groupdocs.signature.options.PdfTextStickerAppearance => com.groupdocs.signature.legacy.options.PdfTextStickerAppearance
184.  com.groupdocs.signature.options.PdfTextStickerVerifyExtensions => com.groupdocs.signature.legacy.options.PdfTextStickerVerifyExtensions
185.  com.groupdocs.signature.options.PDFVerifyBarcodeOptions => com.groupdocs.signature.legacy.options.PDFVerifyBarcodeOptions
186.  com.groupdocs.signature.options.PDFVerifyDigitalOptions => com.groupdocs.signature.legacy.options.PDFVerifyDigitalOptions
187.  com.groupdocs.signature.options.PDFVerifyQRCodeOptions => com.groupdocs.signature.legacy.options.PDFVerifyQRCodeOptions
188.  com.groupdocs.signature.options.PDFVerifyTextOptions => com.groupdocs.signature.legacy.options.PDFVerifyTextOptions
189.  com.groupdocs.signature.options.PngColorType => com.groupdocs.signature.legacy.options.PngColorType
190.  com.groupdocs.signature.options.PngFilterType => com.groupdocs.signature.legacy.options.PngFilterType
191.  com.groupdocs.signature.options.PngSaveOptions => com.groupdocs.signature.legacy.options.PngSaveOptions
192.  com.groupdocs.signature.options.QRCodeSignOptions => com.groupdocs.signature.legacy.options.QRCodeSignOptions
193.  com.groupdocs.signature.options.SaveOptions => com.groupdocs.signature.legacy.options.SaveOptions
194.  com.groupdocs.signature.options.SearchBarcodeOptions => com.groupdocs.signature.legacy.options.SearchBarcodeOptions
195.  com.groupdocs.signature.options.SearchDigitalOptions => com.groupdocs.signature.legacy.options.SearchDigitalOptions
196.  com.groupdocs.signature.options.SearchFormFieldOptions => com.groupdocs.signature.legacy.options.SearchFormFieldOptions
197.  com.groupdocs.signature.options.SearchMetadataOptions => com.groupdocs.signature.legacy.options.SearchMetadataOptions
198.  com.groupdocs.signature.options.SearchOptions => com.groupdocs.signature.legacy.options.SearchOptions
199.  com.groupdocs.signature.options.SearchOptionsCollection => com.groupdocs.signature.legacy.options.SearchOptionsCollection
200.  com.groupdocs.signature.options.SearchQRCodeOptions => com.groupdocs.signature.legacy.options.SearchQRCodeOptions
201.  com.groupdocs.signature.options.SignatureAppearance => com.groupdocs.signature.legacy.options.SignatureAppearance
202.  com.groupdocs.signature.options.SignatureOptionsCollection => com.groupdocs.signature.legacy.options.SignatureOptionsCollection
203.  com.groupdocs.signature.options.SignDigitalOptions => com.groupdocs.signature.legacy.options.SignDigitalOptions
204.  com.groupdocs.signature.options.SignImageOptions => com.groupdocs.signature.legacy.options.SignImageOptions
205.  com.groupdocs.signature.options.SignOptions => com.groupdocs.signature.legacy.options.SignOptions
206.  com.groupdocs.signature.options.SignTextOptions => com.groupdocs.signature.legacy.options.SignTextOptions
207.  com.groupdocs.signature.options.SlidesBarcodeSignOptions => com.groupdocs.signature.legacy.options.SlidesBarcodeSignOptions
208.  com.groupdocs.signature.options.SlidesMetadataSignOptions => com.groupdocs.signature.legacy.options.SlidesMetadataSignOptions
209.  com.groupdocs.signature.options.SlidesQRCodeSignOptions => com.groupdocs.signature.legacy.options.SlidesQRCodeSignOptions
210.  com.groupdocs.signature.options.SlidesSaveOptions => com.groupdocs.signature.legacy.options.SlidesSaveOptions
211.  com.groupdocs.signature.options.SlidesSearchBarcodeOptions => com.groupdocs.signature.legacy.options.SlidesSearchBarcodeOption
212.  com.groupdocs.signature.options.SlidesSearchMetadataOptions => com.groupdocs.signature.legacy.options.SlidesSearchMetadataOptions
213.  com.groupdocs.signature.options.SlidesSearchQRCodeOptions => com.groupdocs.signature.legacy.options.SlidesSearchQRCodeOptions
214.  com.groupdocs.signature.options.SlidesSignDigitalOptions => com.groupdocs.signature.legacy.options.SlidesSignDigitalOptions
215.  com.groupdocs.signature.options.SlidesSignImageOptions => com.groupdocs.signature.legacy.options.SlidesSignImageOptions
216.  com.groupdocs.signature.options.SlidesSignTextOptions => com.groupdocs.signature.legacy.options.SlidesSignTextOptions
217.  com.groupdocs.signature.options.SlidesStampSignOptions => com.groupdocs.signature.legacy.options.SlidesStampSignOptions
218.  com.groupdocs.signature.options.SlidesVerifyBarcodeOptions => com.groupdocs.signature.legacy.options.SlidesVerifyBarcodeOptions
219.  com.groupdocs.signature.options.SlidesVerifyQRCodeOptions => com.groupdocs.signature.legacy.options.SlidesVerifyQRCodeOptions
220.  com.groupdocs.signature.options.SlidesVerifyTextOptions => com.groupdocs.signature.legacy.options.SlidesVerifyTextOptions
221.  com.groupdocs.signature.options.StampSignOptions => com.groupdocs.signature.legacy.options.StampSignOptions
222.  com.groupdocs.signature.options.TiffFormat => com.groupdocs.signature.legacy.options.TiffFormat
223.  com.groupdocs.signature.options.TiffSaveOptions => com.groupdocs.signature.legacy.options.TiffSaveOptions
224.  com.groupdocs.signature.options.VerifyBarcodeOptions => com.groupdocs.signature.legacy.options.VerifyBarcodeOptions
225.  com.groupdocs.signature.options.VerifyDigitalOptions => com.groupdocs.signature.legacy.options.VerifyDigitalOptions
226.  com.groupdocs.signature.options.VerifyExtensions => com.groupdocs.signature.legacy.options.VerifyExtensions
227.  com.groupdocs.signature.options.VerifyOptions => com.groupdocs.signature.legacy.options.VerifyOptions
228.  com.groupdocs.signature.options.VerifyOptionsCollection => com.groupdocs.signature.legacy.options.VerifyOptionsCollection
229.  com.groupdocs.signature.options.VerifyQRCodeOptions => com.groupdocs.signature.legacy.options.VerifyQRCodeOptions
230.  com.groupdocs.signature.options.VerifyTextOptions => com.groupdocs.signature.legacy.options.VerifyTextOptions
231.  com.groupdocs.signature.options.WordsBarcodeSignOptions => com.groupdocs.signature.legacy.options.WordsBarcodeSignOptions
232.  com.groupdocs.signature.options.WordsMetadataSignOptions => com.groupdocs.signature.legacy.options.WordsMetadataSignOptions
233.  com.groupdocs.signature.options.WordsQRCodeSignOptions => com.groupdocs.signature.legacy.options.WordsQRCodeSignOptions
234.  com.groupdocs.signature.options.WordsSaveOptions => com.groupdocs.signature.legacy.options.WordsSaveOptions
235.  com.groupdocs.signature.options.WordsSearchBarcodeOptions => com.groupdocs.signature.legacy.options.WordsSearchBarcodeOptions
236.  com.groupdocs.signature.options.WordsSearchDigitalOptions => com.groupdocs.signature.legacy.options.WordsSearchDigitalOptions
237.  com.groupdocs.signature.options.WordsSearchMetadataOptions => com.groupdocs.signature.legacy.options.WordsSearchMetadataOptions
238.  com.groupdocs.signature.options.WordsSearchQRCodeOptions => com.groupdocs.signature.legacy.options.WordsSearchQRCodeOptions
239.  com.groupdocs.signature.options.WordsSignDigitalOptions => com.groupdocs.signature.legacy.options.WordsSignDigitalOptions
240.  com.groupdocs.signature.options.WordsSignImageOptions => com.groupdocs.signature.legacy.options.WordsSignImageOptions
241.  com.groupdocs.signature.options.WordsSignTextOptions => com.groupdocs.signature.legacy.options.WordsSignTextOptions
242.  com.groupdocs.signature.options.WordsStampSignOptions => com.groupdocs.signature.legacy.options.WordsStampSignOptions
243.  com.groupdocs.signature.options.WordsVerifyBarcodeOptions => com.groupdocs.signature.legacy.options.WordsVerifyBarcodeOptions
244.  com.groupdocs.signature.options.WordsVerifyDigitalOptions => com.groupdocs.signature.legacy.options.WordsVerifyDigitalOptions
245.  com.groupdocs.signature.options.WordsVerifyQRCodeOptions => com.groupdocs.signature.legacy.options.WordsVerifyQRCodeOptions
246.  com.groupdocs.signature.options.WordsVerifyTextOptions => com.groupdocs.signature.legacy.options.WordsVerifyTextOptions
