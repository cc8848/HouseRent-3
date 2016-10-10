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
    $.getJSON("/address/getAreaByCity", {
        cityID: cityID
    }, function (data) {
        $("#area").select2({
            data: data.data
        });
    });
});


