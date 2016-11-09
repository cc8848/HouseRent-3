$(document).ready(function () {
    var house = new House();
    house.getRentModes();
});

function House() {
    var _this = this;
    this.id = $('#houseID').html();
    /**
     * 获取租赁模式及房屋信息
     */
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
    /**
     * 显示租赁模式
     * @param data
     */
    this.showRentModes = function (data) {
        $('#houseInfo-tab').before(template('rentMode', {data: data}));
        $('#content-houseInfo').before(template('rentModeContent', {data: data}));
    };
    /**
     * 显示房间信息
     * @param data
     */
    this.showRooms = function (data) {
        $.each(data, function (i, rentMode) {
            if (rentMode.id == 1) {
                $.getJSON('/rooms/getRooms', {houseID: _this.id}, function (roomsData) {
                    if (roomsData.status) {
                        var content = '#content-' + rentMode.id;
                        var rooms = roomsData.data;
                        $(content).html(template('share', {data: rooms[0]}));
                        _this.selectInit(roomsData.data);
                    } else {
                        alert(roomsData.message);
                    }
                })
            }
        })
    };
    /**
     * 房间号转换为Select2的Data参数
     * @param data
     * @return {Array}
     */
    this.roomsNoToSelectData = function (data) {
        var rooms = [];
        $.each(data, function (index, room) {
            rooms.push(room.roomNo);
        });
        return rooms;
    };
    /**
     * select控件初始化
     * @param data
     */
    this.selectInit = function (data) {
        $("#roomNo").select2({
            placeholder: "房号",
            data: _this.roomsNoToSelectData(data)
        });
    };
}


