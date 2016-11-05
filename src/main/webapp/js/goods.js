$(document).ready(getRentMode());
//获取租赁模式
function getRentMode() {
    var houseID = $('#houseID').html();
    $.getJSON('/rentMode/getRentMode', {
        houseID: houseID
    }, function (data) {
        $('#rentMode-tab').before(template('rentMode', data));
        $('#rentMode-tab').html(template('rentModeContent', data));
        var share = $('#content-1');
        //如果Content-1存在，则查询房间信息
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
        checkInit(data);
    });
}
//初始化iCheck组件
function checkInit(data) {
    $.each(data.data, function (index, room) {
        var id = '#input-check-' + room.id;
        $(id).iCheck({
            checkboxClass: 'icheckbox_flat-blue'
        });
        if (room.houseStatus.statusName == '出租状态') {
            $(id).iCheck('disable');
            var label = id + ' > label';
            $(label).removeClass('label-success').addClass('label-danger')
        }
    });
}