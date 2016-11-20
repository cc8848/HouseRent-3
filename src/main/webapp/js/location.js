/**
 * Created by wu on 2016/11/20.
 */
function Location(provinceID, cityID, areaID) {

    var province = $(provinceID);

    var city = $(cityID);

    var area = $(areaID);

    this.locationInit = function () {
        $(".select2").select2();
        this.provinceInit();
        this.cityInit();
        this.areaInit();
    };
    this.provinceInit = function () {
        $.getJSON("/address/getAllProvince", function (data) {
            province.select2({
                placeholder: "省份",
                data: data.data
            }).on("select2:select", function () {
                var provinceID = province.select2("val");
                city.html('');
                area.html('');
                $.getJSON("/address/getCityByProvince", {
                    provinceID: provinceID
                }, function (data) {
                    city.select2({
                        data: data.data
                    });
                });
            });
        });
    };
    this.cityInit = function () {
        city.select2({
            placeholder: "城市"
        }).on("select2:select", function () {
            var cityID = city.select2("val");
            area.html("");
            $.getJSON("/address/getAreaByCity", {
                cityID: cityID
            }, function (data) {
                area.select2({
                    data: data.data
                });
            });
        });
    };
    this.areaInit = function () {
        area.select2({
            placeholder: "地区"
        });
    };
}