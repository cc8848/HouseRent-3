$(document).ready(checkInit());

function checkInit() {
    $('.input-check').iCheck({
        checkboxClass: 'icheckbox_flat-blue',
        radioClass: 'iradio_flat-blue'
    });
}

$(document).ready(getRentMode());

function getRentMode() {
    var houseID = $('#houseID').html();
    $.getJSON('/rentMode/getRentMode', {
        houseID: houseID
    }, function (data) {
        $('#info-table').after(template('rentMode', data));
    })
}