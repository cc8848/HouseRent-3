/**
 * Created by wuxinzhe on 16/10/7.
 */
function upLoad(fileInput, URL) {

    var fileInput = fileInput;

    var URL = URL;

    this.initParameter = {
        language: 'zh',//语言
        uploadUrl: URL,//上传的地址
        allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        //dropZoneEnabled: false,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        maxFileCount: 5, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount: true,
        // previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！"
    };

    this.init = function () {//控件初始化
        fileInput.fileinput(this.initParameter);
    }

}


function Modal() {
    this.errorModal = function (message, tittle) {
        if (arguments.length == 2) {
            $('#error-modal-tittle').html(tittle);
            $('#error-modal-message').html(message);
        } else {
            $('#error-modal-message').html(message);
        }
        $('#errorModal').modal();
    };

    this.confirmModal = function (message, fun, tittle) {
        if (arguments.length == 3) {
            $('#confirm-modal-tittle').html(tittle);
            $('#confirm-modal-message').html(message);
        } else {
            $('#confirm-modal-message').html(message);
        }
        $('#confirm-button').on('click', fun);
        $('#confirmModal').modal();
    };

    this.uploadModal = function (houseID) {
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");
        $('#uploadViewModal').modal();
        // 初始化Check组件
        $('.radio').iCheck({
            radioClass: 'iradio_flat-red'
        });
        //初始化文件上传组件
        $('#file').fileinput({
            language: 'zh',//语言
            uploadUrl: '/file/upload',//上传的地址
            initialCaption: '请上传房屋图片...',//文本框初始化标题
            allowedFileExtensions: ['jpg'],//接收的文件后缀
            showCaption: true,//是否显示标题
            dropZoneEnabled: true,//是否显示拖拽区域
            maxFileSize: 2048,//单位为kb，如果为0表示不限制文件大小
            maxFileCount: 2,//表示允许同时上传的最大文件个数
            validateInitialCount: true,
            overwriteInitial: false,
            showDrag: true,
            showAjaxErrorDetails: true,
            enctype: 'multipart/form-data',
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}",
            ajaxSettings: {
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                }
            },
            uploadExtraData: {
                houseID: houseID
            }
        });

    }
}

function SelectUtil() {
    this.selectInit = function (target, URL) {
        $.getJSON(URL, function (backData) {
            target.select2({
                data: backData
            });
        });
    };
}

function refresh() {
    window.location.reload();
}

function postCRF(URL, data, callback) {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    $.ajax({
        url: URL,
        type: 'POST',
        beforeSend: function (xhr) {
            xhr.setRequestHeader(header, token);
        },
        data: data,
        success: callback,
        error: function (xhr, ajaxOptions, thrownError) {
            console.log(xhr.status + ": " + thrownError);
        }
    });
}

