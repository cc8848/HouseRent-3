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
                        _this.selectInit(data.data);
                    } else {
                        alert(data.message);
                    }
                })
            }
        })
    };

    this.roomsToSelectData = function (data) {
        var rooms = [];
        $.each(data, function (index, room) {

            rooms.push(room.roomNo);
        });

        return rooms;
    };

    this.selectInit = function (data) {
        $("#roomNo").select2({
            placeholder: "房号",
            data: _this.roomsToSelectData(data)
        });
    };
}

function SelectPojo(id, text) {
    this.id = id;
    this.text = text;
}


