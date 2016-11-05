$(document).ready(getRentMode());
//获取租赁模式
function getRentMode() {
    var houseID = $('#houseID').html();
    $.getJSON('/rentMode/getRentMode', {
        houseID: houseID
    }, function (data) {
        $('#info-table').after(template('rentMode', data));
        $('#rentMode-tab').html(template('rentModeContent', data));
        var share = $('#content-1');
        //如果Content-1
        if (share != null) {
            getRoomsInfo(share, houseID);
        }
    });
}
//获取房间数据
function getRoomsInfo(share, houseID) {
    $.getJSON('/rooms/getRooms', {
        houseID: houseID
    }, function (data) {
        share.html(template('share', data));
        checkInit();
    });
}
//初始化iCheck组件
function checkInit() {
    $('.input-check').iCheck({
        checkboxClass: 'icheckbox_flat-blue',
        radioClass: 'iradio_flat-blue'
    });
}