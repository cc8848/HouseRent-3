$(document).ready(function () {
    var house = new House();
    house.houseInit();
});
function House() {
    var _this = this;
    this.id = $('#houseID').html();
    this.roomNumList = [];
    /**
     * 获取租赁模式及房屋信息
     */
    this.houseInit = function () {
        $('#tab-content div:first').addClass('active');
        $('#tab li:first').addClass('active');
        _this.showRooms();
        new Good().formInit();
    };
    /**
     * 显示分租模式
     */
    this.showRooms = function () {
        $.getJSON('/rooms/getRooms', {houseID: _this.id}, function (roomsData) {
            if (roomsData.status) {
                var roomList = roomsData.data;
                _this.roomsSelectInit(roomList);
            } else {
                alert(roomsData.message);
            }
        })
    };
    /**
     * 房号列表select控件初始化
     * @param roomList
     */
    this.roomsSelectInit = function (roomList) {
        $('#roomNo').select2().on('select2:select', function () {
            var roomNo = $('#roomNo').select2('val');
            $.each(roomList, function (index, room) {
                if (room.roomNo == roomNo) {
                    new Room(room).changeRoomInfo();
                }
            });
        });
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
    /**
     * 修改房间信息
     */
    this.changeRoomInfo = function () {
        $('.room-expectPrice').html(this.room.expectPrice);
        $('.room-areaNum').html(this.room.areaNumber);
        $('.room-statusName').html(this.room.houseStatus.statusName);
        $('.room-haveWashroom').html(this.room.haveWashroom ? '是' : '否');
        $('.room-haveKitchen').html(this.room.haveKitchen ? '是' : '否');
        $('.room-haveDesk').html(this.room.haveDesk ? '是' : '否');
        $('.room-haveWardrobe').html(this.room.haveWardrobe ? '是' : '否');
        $('.room-haveAirConditioning').html(this.room.haveAirConditioning ? '是' : '否');
        $('.room-haveWaterHeater').html(this.room.haveWaterHeater ? '是' : '否');
        $('.room-haveWLAN').html(this.room.haveWLAN ? '是' : '否');
    }
}

function Good() {
    var _this = this;
    this.plus = $('#tenancy-plus');
    this.subtract = $('#tenancy-subtract');
    this.tenancy = $('#tenancy-input');
    this.formInit = function () {
        _this.rentWaySelectInit();
        _this.tenancyInputInit();
    };
    this.rentWaySelectInit = function () {
        $('#rentWay').select2({
            placeholder: "请选择租赁的房号"
        }).select2('val', '');
    };
    this.tenancyInputInit = function () {
        _this.plus.on('click', function () {
            if (_this.tenancy.val() != '' && _this.tenancy.val() != null && _this.tenancy.val() >= 36) {
                alert('租期最长不可大于3年！');
            } else if (_this.tenancy.val() != '' && _this.tenancy.val() < 36) {
                _this.tenancy.val(parseInt(_this.tenancy.val()) + 1);
            } else if (_this.tenancy.val() == '' || _this.tenancy.val() == null) {
                _this.tenancy.val(1);
            }
        });
        _this.subtract.on('click', function () {
            if (_this.tenancy.val() == null || _this.tenancy.val() <= 0) {
                alert('租期不可小于0个月！');
            } else {
                _this.tenancy.val(_this.tenancy.val() - 1);
            }
        });
        _this.tenancy.on('blur', function () {
            if (_this.tenancy.val() != '' && _this.tenancy.val() != null && _this.tenancy.val() > 36) {
                alert('租期最长不可大于3年！');
                _this.tenancy.val('');
            }
        });
    }
}


