/**
 * 租赁模式构造函数
 * @param id
 * @param name
 * @param tab
 * @constructor
 */
function RentMode(id, name, tab) {
    this.id = id;
    this.name = name;
    this.tab = tab;
}
RentMode.prototype.getID = function () {
    return this.id;
};
RentMode.prototype.setID = function (id) {
    this.id = id;
};
RentMode.prototype.getName = function () {
    return this.name;
};
RentMode.prototype.setName = function (name) {
    this.name = name;
};
RentMode.prototype.getTab = function () {
    return this.name;
};
RentMode.prototype.setTab = function (tab) {
    this.tab = tab;
};

/**
 * 房间信息构造函数
 * @param id
 * @param roomNo
 * @param areaNo
 * @param haveWashroom
 * @param haveKitchen
 * @param houseID
 * @param houseStatus
 * @param expectRent
 * @constructor
 */
function Room(id, roomNo, areaNo, haveWashroom, haveKitchen, houseID, houseStatus, expectRent) {
    this.id = id;
    this.roomNo = roomNo;
    this.areaNo = areaNo;
    if (haveWashroom) {
        this.haveWashroom = '是';
    } else {
        this.haveKitchen = '否';
    }
    if (haveKitchen) {
        this.haveKitchen = '是';
    } else {
        this.haveKitchen = '否';
    }
    this.houseID = houseID;
    this.houseStatus = houseStatus;
    this.expectRent = expectRent;
}
Room.prototype.getID = function () {
    return this.id;
};
Room.prototype.setID = function (id) {
    this.id = id;
};
Room.prototype.getRoomNo = function () {
    return this.roomNo;
};
Room.prototype.setRoomNo = function (roomNo) {
    this.roomNo = roomNo;
};
Room.prototype.getAreaNo = function () {
    return this.areaNo;
};
Room.prototype.setAreaNo = function (areaNo) {
    this.areaNo = areaNo;
};
Room.prototype.isHaveWashroom = function () {
    return this.haveWashroom;
};
Room.prototype.setHaveWashroom = function (haveWashroom) {
    this.haveWashroom = haveWashroom;
};
Room.prototype.isHaveKitchen = function () {
    return this.haveKitchen;
};
Room.prototype.setHaveKitchen = function (haveKitchen) {
    this.haveKitchen = haveKitchen;
};
Room.prototype.getHouseID = function () {
    return this.houseID;
};
Room.prototype.setHouseID = function (houseID) {
    this.houseID = houseID;
};
Room.prototype.getHouseStatusID = function () {
    return this.houseStatus.id;
};
Room.prototype.gethouseStatusName = function () {
    return this.houseStatus.statusName;
};
Room.prototype.getExpectRent = function () {
    return this.expectRent;
};
Room.prototype.setExpectRent = function (expectRent) {
    this.expectRent = expectRent;
};

/**
 * 房屋构造函数
 * @param id
 * @param rentModes
 * @constructor
 */
function House(id, rentModes) {
    this.id = id;
    this.rentModes = rentModes;
}
House.prototype.getID = function () {
    return this.id;
};
House.prototype.setRentModes = function (rentModes) {
    this.rentModes = rentModes;
};
/**
 * 获取租赁模式
 * @param houseID
 * @return rentModes
 */
House.prototype.getRentModes = function (houseID) {
    $.getJSON('/rentMode/getRentModes', {
        houseID: houseID
    }, function (callBackData) {
        // if (callBackData.status) {
        //     var rentModes = new Array;
        //     for (var i = 0; i < callBackData.data.length; i++) {
        //         rentModes[i] = new RentMode(callBackData.data[i].id, callBackData.data[i].name)
        //     }
        // } else {
        //     throw callBackData.message;
        // }
    });
    return this.rentModes;
};
/**
 * 获取房屋信息
 * @param houseID
 * @return rooms
 */
House.prototype.getRooms = function (houseID) {
    $.getJSON('/rooms/getRooms', {
        houseID: houseID
    }, function (data) {
        if (!data.status) {
            alert(data.message);
        } else {
            var rooms = new Array();
            $.each(data.data, function (index, room) {
                rooms[index] = new Room(room.id, room.roomNo, room.areaNumber, room.haveWashroom, room.haveKitcken, room.houseId, room.houseStatus, room.expectRent)
            });
            return rooms;
        }
    })
};


$(document).ready(houseInit());
function houseInit() {
    //创建房屋对象
    var house = new House($('#houseID').html());
    // 获取租赁模式
    var rentModes = house.getRentModes(house.getID());
    $('#rentMode-tab').before(template('rentMode', {data: rentModes}));
}


function goodsInit() {
    var houseID = $('#houseID').html();
    var rentMode = $('#rentMode-tab');
    $.getJSON('/rentMode/getRentModes', {
        houseID: houseID
    }, function (data) {
        rentMode.before(template('rentMode', {data: data.data}));
        rentMode.html(template('rentModeContent', data));
        //如果Content-1存在，则查询分租的房间信息
        var share = $('#content-1');
        if (share != null) {
            $.getJSON('/rooms/getRooms', {
                houseID: houseID
            }, function (data) {
                share.html(template('share', data));
                $.each(data.data, function (index, room) {
                    var id = '#input-check-' + room.id;
                    $(id).iCheck({
                        checkboxClass: 'icheckbox_flat-blue'
                    });
                    if (room.houseStatusId == 2) {//出租状态标红且不可选
                        $(id).iCheck('disable');
                        var label = id + ' > label';
                        $(label).removeClass('label-success').addClass('label-danger')
                    }
                });
            });
        }
        //如果Content-2存在，则查询整租的房屋信息
        var whole = $('#content-2');
        if (whole != null) {
        }
        //如果Content-3存在，则查询转租的房屋信息
    });
}