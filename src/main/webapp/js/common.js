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
