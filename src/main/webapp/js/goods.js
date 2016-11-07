$(document).ready(function () {
    var house = new House();
    house.getRentModes();
});

function House() {

    var _this = this;
    this.id = $('#houseID').html();

    this.getRentModes = function () {
        $.getJSON('/rentMode/getRentModes', {houseID: _this.id}, function (data) {
            if (data.status) {
                _this.showRentModes(data.data);
                _this.showRooms(data.data);
            } else {
                alert(data.message);
            }
        });
    };

    this.showRentModes = function (data) {
        $('#rentMode-tab').before(template('rentMode', {data: data})).html(template('rentModeContent', {data: data}));
    };

    this.showRooms = function (data) {
        $.each(data, function (i, rentMode) {
            if (rentMode.id == 1) {
                $.getJSON('/rooms/getRooms', {houseID: _this.id}, function (data) {
                    if (data.status) {
                        var content = '#content-' + rentMode.id;
                        $(content).html(template('share', data));
                        _this.icheckInit(data);
                    } else {
                        alert(data.message);
                    }
                })
            }
        })
    };

    this.icheckInit = function (data) {
        $.each(data.data, function (index, room) {
            var divID = '#input-check-' + room.id;
            $(divID).iCheck({
                checkboxClass: 'icheckbox_flat-blue'
            });
            if (room.houseStatusId == 2) {//出租状态标红且不可选
                $(divID).iCheck('disable');//设置不可用
                var label = divID + ' > label';//选择下级元素
                $(label).removeClass('label-success').addClass('label-danger');//修改样式
            }
        });
    };
}


