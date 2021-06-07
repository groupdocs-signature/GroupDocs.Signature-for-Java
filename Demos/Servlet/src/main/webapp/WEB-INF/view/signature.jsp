<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<head>
    <title>Signature for Java Servlet</title>
    <link type="text/css" rel="stylesheet" href="/assets/common/css/all.min.css">
    <link type="text/css" rel="stylesheet" href="/assets/common/css/v4-shims.min.css">
    <link type="text/css" rel="stylesheet" href="/assets/common/css/swiper.min.css">
    <link type="text/css" rel="stylesheet" href="/assets/common/css/jquery-ui.min.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/common/css/circle-progress.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/viewer/css/viewer.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/viewer/css/viewer.mobile.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/viewer/css/viewer-dark.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/bcPaint.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/bcPaint.mobile.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/signature.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/signature.mobile.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/stampGenerator.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/opticalCodeGenerator.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/textGenerator.css"/>
    <link type="text/css" rel="stylesheet" href="/assets/signature/css/bcPicker.css"/>
    <script type="text/javascript" src="/assets/common/js/jquery.min.js"></script>
    <script type="text/javascript" src="/assets/common/js/swiper.min.js"></script>
    <script type="text/javascript" src="/assets/common/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="/assets/viewer/js/viewer.js"></script>
    <script type="text/javascript" src="/assets/signature/js/signature.js"></script>
    <script type="text/javascript" src="/assets/signature/js/rotatable.js"></script>
    <script type="text/javascript" src="/assets/signature/js/bcPaint.js"></script>
    <script type="text/javascript" src="/assets/signature/js/bcPicker.js"></script>
    <script type="text/javascript" src="/assets/signature/js/stampGenerator.js"></script>
    <script type="text/javascript" src="/assets/signature/js/opticalCodeGenerator.js"></script>
    <script type="text/javascript" src="/assets/signature/js/textGenerator.js"></script>
    <script type="text/javascript" src="/assets/common/js/jquery.ui.touch-punch.min.js"></script>
</head>
<body>
<div id="element"></div>
<script type="text/javascript">
    $('#element').viewer({
        applicationPath: "http://${globalConfiguration.server.hostAddress}:${globalConfiguration.server.httpPort}/signature",
        defaultDocument: "${signatureConfiguration.defaultDocument}",
        htmlMode: false,
        preloadPageCount: "${signatureConfiguration.preloadPageCount}",
        zoom : false,
        pageSelector: "${signatureConfiguration.pageSelector}",
        search: false,
        thumbnails: false,
        rotate: false,
        download: "${signatureConfiguration.download}",
        upload: "${signatureConfiguration.upload}",
        print: "${signatureConfiguration.print}",
        browse: "${signatureConfiguration.browse}",
        rewrite: "${signatureConfiguration.rewrite}"
    });
    $('#element').signature({
        textSignature: "${signatureConfiguration.textSignature}",
        imageSignature:  "${signatureConfiguration.imageSignature}",
        digitalSignature:  "${signatureConfiguration.digitalSignature}",
        qrCodeSignature:  "${signatureConfiguration.qrCodeSignature}",
        barCodeSignature:  "${signatureConfiguration.barCodeSignature}",
        stampSignature:  "${signatureConfiguration.stampSignature}",
        downloadOriginal:  "${signatureConfiguration.downloadOriginal}",
        downloadSigned:  "${signatureConfiguration.downloadSigned}"
    });
</script>
</body>
</html>