/**
 * Created by wuxinzhe on 16/10/7.
 */
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
        $('#uploadViewModal').modal();
        // 初始化Check组件
        $('.radio').iCheck({
            radioClass: 'iradio_flat-red'
        });
        //初始化文件上传组件
        $('.file-input').fileinput();

    }
}

function SelectUtil() {
    var _this = this;
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