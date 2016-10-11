/**
 * Created by wuxinzhe on 16/10/7.
 */
$(document).ready(pageInit());

//页面初始化
function pageInit() {
    selectInit();
    showMap();
}
//地图显示
function showMap() {
    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom: 10,
        center: [116.480983, 40.0958]
    });
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

$('#way-1').on('click', setWay);
$('#way-2').on('click', setWay);
$('#way-3').on('click', setWay);
$('#way-4').on('click', setWay);

function setWay() {
    $('#way-input').val(this.innerHTML)
}