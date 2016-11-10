$(document).ready(function () {
    var house = new House();
    house.houseInit();
});

function House() {
    var _this = this;
    this.id = $('#houseID').html();
    /**
     * 获取租赁模式及房屋信息
     */
    this.houseInit = function () {
        $.getJSON('/rentMode/getRentModes', {houseID: _this.id}, function (data) {
            if (data.status) {
                _this.showRentModes(data.data);
                $.each(data.data, function (i, rentMode) {
                    if (rentMode.id == 1) {
                        _this.showShareMode();
                    } else if (rentMode.id == 2) {
                        _this.showWholeMode();
                    } else if (rentMode.id == 3) {
                        _this.showSubletMode();
                    }
                })
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
     * 房号列表select控件初始化
     * @param roomList
     */
    this.roomsSelectInit = function (roomList) {
        var roomNumList = [];
        $.each(roomList, function (index, room) {
            roomNumList.push(room.roomNo);
        });
        $('#roomNo').select2({
            placeholder: '房号',
            data: roomNumList
        }).on('select2:select', function () {
            var roomNo = $('#roomNo').select2('val');
            $.each(roomList, function (index, room) {
                if (room.roomNo == roomNo) {
                    new Room(room).changeRoomInfo();
                }
            });
        });
    };
    /**
     * 显示分租模式
     * @param data
     */
    this.showShareMode = function () {
        $.getJSON('/rooms/getRooms', {houseID: _this.id}, function (roomsData) {
            if (roomsData.status) {
                var roomList = roomsData.data;
                var room = new Room(roomList[0]);
                room.showRoomInfo();
                _this.roomsSelectInit(roomList);
            } else {
                alert(roomsData.message);
            }
        })
    };
    /**
     * 显示整租模式
     * @param data
     */
    this.showWholeMode = function (data) {

    };
    /**
     * 显示转租模式
     * @param data
     */
    this.showSubletMode = function (data) {

    };
}

function Room(room) {
    this.room = room;
    var _this = this;
    /**
     * 显示房间信息
     * @param room
     */
    this.showRoomInfo = function () {
        $('#content-1').html(template('share', {room: _this.room}));
    };

    this.changeRoomInfo = function () {
        $('#room-expectPrice').html(room.expectPrice);
        $('#room-areaNum').html(room.areaNumber);
        $('#room-statusName').html(room.houseStatus.statusName);
        $('#room-haveWashroom').html(room.haveWashroom ? '是' : '否');
        $('#room-haveKitchen').html(room.haveKitchen ? '是' : '否');
        $('#room-haveDesk').html(room.haveDesk ? '是' : '否');
        $('#room-haveWardrobe').html(room.haveWardrobe ? '是' : '否');
        $('#room-haveAirConditioning').html(room.haveAirConditioning ? '是' : '否');
        $('#room-haveWaterHeater').html(room.haveWaterHeater ? '是' : '否');
        $('#room-haveWLAN').html(room.haveWLAN ? '是' : '否');
    }
}


