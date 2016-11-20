/**
 * Created by wu on 2016/11/20.
 */
function Location(provinceID, cityID, areaID) {

    var province = $('#' + provinceID);
    var city = $('#' + cityID);
    var area = $('#' + areaID);

    this.init = function () {
        province.select2({placeholder: '省份'});
        city.select2({placeholder: '城市'});
        area.select2({placeholder: '地区'});
        $.getJSON('/address/all', function (backData) {
            var array = [];
            $.each(backData.data, function (i, province) {
                var option = new Option(province.provinceID, province.provinceName);
                array.push(option);
            });
            province.select2({
                data: array
            });
        })
    };

    this.findCityFromProvince = function (provinceList, in_id) {
        var out_province = null;
        $.each(provinceList, function (i, province) {
            if (in_id == province.provinceID) {
                out_province = province;
                return false;
            }
        });
        return out_province.cities;
    };

    this.findAreaFromCity = function (cityList, in_id) {
        var out_city = null;
        $.each(cityList, function (i, city) {
            if (in_id = city.cityid) {
                out_city = city;
                return false;
            }
        });
        return out_city.areas;
    };
}

function Option(id, text) {
    this.id = id;
    this.text = text;
}