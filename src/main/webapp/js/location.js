/**
 * Created by wu on 2016/11/20.
 */
function Location(province, city, area) {

    var province = province;

    var city = city;

    var area = area;

    var modal=new Modal();

    this.locationInit = function () {
        this.provinceInit();
        this.cityInit();
        this.areaInit();
    };

    this.provinceInit = function () {
        $.getJSON("/address/getAllProvince", function (data) {
            province.select2({
                placeholder: "请选择省份",
                data: data.data
            }).on("select2:select", function () {
                var provinceID = province.select2("val");
                city.html('');
                area.html('');
                $.getJSON("/address/getCityByProvince", {
                    provinceID: provinceID
                }, function (data) {
                    if (data.status) {
                        city.select2({
                            data: data.data
                        });
                    } else {
                        modal(data.message);
                    }
                });
            });
        });
    };

    this.getProvinceVal = function () {
        return province.select2('val');
    };

    this.getProvinceText = function () {
        return province.select2('data').text;
    };

    this.cityInit = function () {
        city.select2({
            placeholder: "请选择城市"
        }).on("select2:select", function () {
            var cityID = city.select2("val");
            area.html("");
            $.getJSON("/address/getAreaByCity", {
                cityID: cityID
            }, function (data) {
                if (data.status) {
                    area.select2({
                        data: data.data
                    });
                } else {
                    modal(data.message);
                }
            });
        });
    };

    this.getCityVal = function () {
        return city.select2('val');
    };

    this.getCityText = function () {
        return city.select2('data').text;
    };

    this.areaInit = function () {
        area.select2({
            placeholder: "请选择地区"
        });
    };

    this.getAreaVal = function () {
        return area.select2('val');
    };

    this.getAreaText = function () {
        return area.select('data').text;
    }


}