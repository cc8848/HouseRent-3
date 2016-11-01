/**
 * Created by wuxinzhe on 16/10/7.
 */
$(document).ready(pageInit());

//页面初始化
function pageInit() {
    selectInit();
    showRecommend();
}

//下拉框初始化
function selectInit() {
    $(".select2").select2();
    $.getJSON("/address/getAllProvince", function (data) {
        $("#province").select2({
            placeholder: "省份",
            data: data.data
        });
    });
    $("#city").select2({
        placeholder: "城市"
    });
    $("#area").select2({
        placeholder: "地区"
    });
}

$("#province").on("select2:select", function () {
    var provinceID = $("#province").select2("val");
    $('#city').html('');
    $('#area').html('');
    $.getJSON("/address/getCityByProvince", {
        provinceID: provinceID
    }, function (data) {
        $("#city").select2({
            data: data.data
        });
    });
});

$("#city").on("select2:select", function () {
    var cityID = $("#city").select2("val");
    $('#area').html("");
    $.getJSON("/address/getAreaByCity", {
        cityID: cityID
    }, function (data) {
        $("#area").select2({
            data: data.data
        });
    });
});

$("#address-button").click(function () {
    var area = $("#area").select2('data')[0].text;
    if (null != area) {
        $('#area-input').val(area);
    }
});
//查询条件设置-start
$('#price-1').on('click', setPrice);
$('#price-2').on('click', setPrice);
$('#price-3').on('click', setPrice);
$('#price-4').on('click', setPrice);
$('#price-5').on('click', setPrice);
$('#price-6').on('click', setPrice);
function setPrice() {
    $('#price-input').val(this.innerHTML);
}

$('#room-1').on('click', setRoom);
$('#room-2').on('click', setRoom);
$('#room-3').on('click', setRoom);
$('#room-4').on('click', setRoom);
$('#room-5').on('click', setRoom);
$('#room-6').on('click', setRoom);
function setRoom() {
    $('#room-input').val(this.innerHTML);
}

$('#rentMode-1').on('click', setWay);
$('#rentMode-2').on('click', setWay);
$('#rentMode-3').on('click', setWay);
$('#rentMode-4').on('click', setWay);
function setWay() {
    $('#rentMode-input').val(this.innerHTML)
}
//查询条件设置-end

//点击搜索事件
$('#searchButton').on('click', search);
function search() {
    var rent = $('#price-input').val();
    var minRent;
    var maxRent;
    if (rent != "不限" && rent != "4000以上") {
        var rentArr = rent.split('-');
        minRent = rentArr[0];
        maxRent = rentArr[1];
    } else if (rent == "4000以上") {
        minRent = 4000;
        maxRent = null;
    } else {
        minRent = null;
        maxRent = null;
    }
    var areaName = $('#area-input').val();
    areaName = areaName == "不限" ? null : areaName;
    var roomNum = $('#room-input').val();
    roomNum = roomNum == "不限" ? null : roomNum;
    var rentMode = $('#rentMode-input').val();
    rentMode = rentMode == "不限" ? null : rentMode;
    $.getJSON('/house/selectHousesListBySearchTerms', {
        pageNum: 1,
        pageSize: 10,
        minRent: minRent,
        maxRent: maxRent,
        areaName: areaName,
        roomNum: roomNum,
        rentMode: rentMode
    }, function (data) {
        var pageNum = data.data.pageNum;
        var pageSize = data.data.size;
        $.each(data.data.list, function (index, obj) {
        })
    })
}

function showRecommend() {
    $.getJSON('/house/selectRecommend', function (data) {
        $('#recommendTittle').after(template('recommendList', data.data));
    });
}


