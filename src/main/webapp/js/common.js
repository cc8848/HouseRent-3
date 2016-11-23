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

function TableUtil(tableID) {

    var table = $('#' + tableID);

    this.getCellContent = function (rowNum, colNum) {
        table.find('tbody tr:eq(3) td:eq(2)')
    }

}

function refresh() {
    window.location.reload();
}
