/**
 * Created by wu on 2016/11/19.
 */
$(document).ready(homeInit());

function homeInit() {
    $('.select2').select2();
    $.getJSON("/address/getAllProvince", function (data) {
        $("#province").select2({
            placeholder: "省份",
            data: data.data
        }).select2('val', '');
    });
    $("#city").select2({
        placeholder: "城市"
    });
    $("#area").select2({
        placeholder: "地区"
    });

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

    $("#area").on("select2:select", function () {
        var areaID = $("#area").select2("val");
        $("#storeNum").html("");
        $.getJSON("/store/getNum", {
            areaID: areaID
        }, function (data) {
            $("#storeNum").select2({
                data: data.data
            });
        });
    });
}