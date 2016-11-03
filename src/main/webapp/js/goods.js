$(document).ready(checkInit());

function checkInit() {
    $('.input-check').iCheck({
        checkboxClass: 'icheckbox_flat-blue',
        radioClass: 'iradio_flat-blue'
    });
}

$(document).ready(selectHouseDetail());

function selectHouseDetail() {
    $.getJSON('/')
}