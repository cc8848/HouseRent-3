/**
 * Created by wuxinzhe on 16/10/7.
 */

function logout() {
    $("#logout-form").submit();
}

function errorModal(tittle, message) {
    $('#error-modal-tittle').html(tittle);
    $('#error-modal-message').html(message);
    $('#errorModal').modal();
}


