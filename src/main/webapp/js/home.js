/**
 * Created by wu on 2016/11/19.
 */
$(document).ready(function () {
    var home = new Home();
    home.homeInit();
});

function Home() {
    this.homeInit = function () {
        $(".select2").select2();
        this.provinceInit();
        this.cityInit();
        this.areaInit();
        this.roleInit();
    };
    this.provinceInit = function () {
        $.getJSON("/address/getAllProvince", function (data) {
            $("#province").select2({
                placeholder: "省份",
                data: data.data
            }).on("select2:select", function () {
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
        });
    };
    this.cityInit = function () {
        $("#city").select2({
            placeholder: "城市"
        }).on("select2:select", function () {
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
    };
    this.areaInit = function () {
        $("#area").select2({
            placeholder: "地区"
        }).on("select2:select", function () {
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
    };
    this.roleInit = function () {
        $("#storeNum").select2({
            placeholder: "门牌号"
        }).on("select2:select", function () {
            var storeID = $("#storeNum").select2("val");
            $("#storeRole").html("");
            $.getJSON("/store/getRoles", {
                storeID: storeID
            }, function (data) {
                $("#storeRole").select2({
                    data: data.data
                });
            });
        });
    };
}