<!DOCTYPE html>
<!-- release v4.5.2, copyright 2014 - 2018 Kartik Visweswaran -->
<!--suppress JSUnresolvedLibraryURL -->
<c:set var="cp" value="${pageContext.request.contextPath}"></c:set>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Krajee JQuery Plugins - &copy; Kartik</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" crossorigin="anonymous">
    <link href="../css/fileinput.min.css" media="all" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
    <link href="../themes/explorer-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="../js/plugins/sortable.js" type="text/javascript"></script>
    <script src="../js/fileinput.min.js" type="text/javascript"></script>
    <script src="../js/locales/fr.js" type="text/javascript"></script>
    <script src="../js/locales/es.js" type="text/javascript"></script>
    <script src="../themes/fas/theme.js" type="text/javascript"></script>
    <script src="../themes/explorer-fas/theme.js" type="text/javascript"></script>
</head>
<body>
<div class="container my-3">
    <form enctype="multipart/form-data">
        <div class="form-group">
            <div class="file-loading">
                <input id="file" type="file" class="file">
                <input id="fileDir" type="hidden" value="img">
                <input id="bfsBillType" type="hidden" value="1">
            </div>
        </div>
    </form>
</div>
</body>
<script>
    $("#file").fileinput({
        theme: 'fas',
        uploadUrl: '${cp}/logistics-front/file/uploadFile',
        allowedFileExtensions: ['jpg', 'png', 'gif'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        uploadExtraData:{"fileDir":$("#fileDir").val(),"bfsBillType":$("#bfsBillType").val()},
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function (filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
    }).on("fileuploaded", function(event, data) {
        console.log(data);
        //$("#path").attr("value",data.response);
    });
    $(".btn-warning").on('click', function () {
        var $el = $("#file");
        if ($el.attr('disabled')) {
            $el.fileinput('enable');
        } else {
            $el.fileinput('disable');
        }
    });
    $(".btn-info").on('click', function () {
        $("#file").fileinput('refresh', {previewClass: 'bg-info'});
    });
</script>
</html>