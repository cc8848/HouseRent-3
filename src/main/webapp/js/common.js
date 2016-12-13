/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe  创建时间: 16/10/7
 * 类说明: 公共的JS工具集合
 * 更新记录：
 */



function ModalTools() {
    this.p = function (content) {
        return '<p style="padding: 10px 20px">' + content + '</p>';
    }
}

function SelectUtil() {
    this.selectInitForJson = function (target, URL) {
        $.getJSON(URL, function (backData) {
            target.select2({
                data: backData
            });
        });
    };
    this.selectInitAjax = function (target, URL, data) {
        $.getJSON(URL, data, function (backData) {
            target.select2({
                data: backData.data
            });
        });
    };
}

function FileUpload() {
    var header = $("meta[name='_csrf_header']").attr("content");
    var token = $("meta[name='_csrf']").attr("content");
    this.initFileInput = function (target, uploadUrl) {
        target.fileinput({
            language: 'zh', //设置语言
            dropZoneEnabled: false,//是否显示拖拽区域
            uploadUrl: uploadUrl, //上传的地址
            allowedFileExtensions: ['jpg', 'png', 'gif'],//接收的文件后缀
            showUpload: true, //是否显示上传按钮
            showCaption: true,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            ajaxSettings: {
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                }
            }
        });
    }
}

function refresh() {
    window.location.reload();
}

function forward(href) {
    window.location.href = href;
}


function HttpUtil() {
    this.postCRF = function (URL, data, callback) {
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");
        $.ajax({
            url: URL,
            type: 'POST',
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            data: data,
            success: callback,
            error: function (xhr, ajaxOptions, thrownError) {
                console.log(xhr.status + ": " + thrownError);
            }
        });
    }
}

function Location(province, city, area) {

    var modal = new Modal();

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
        return province.select2('data')[0].text;
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
        return city.select2('data')[0].text;
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
        return area.select2('data')[0].text;
    }
}


