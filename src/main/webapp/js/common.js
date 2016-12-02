/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wuxinzhe  创建时间: 16/10/7
 * 类说明: 公共的JS工具集合
 * 更新记录：
 */



function Modal() {
    this.infoModal = function (message, tittle) {
        if (arguments.length == 2) {
            $('#info-modal-tittle').html(tittle);
            $('#info-modal-message').html(message);
        } else {
            $('#info-modal-message').html(message);
        }
        $('#infoModal').modal();
    };

    this.confirmModal = function (message, fun, tittle) {
        if (arguments.length == 3) {
            $('#confirm-modal-tittle').html(tittle);
            $('#confirm-modal-message').html(message);
        } else {
            $('#confirm-modal-message').html(message);
        }
        $('#confirm-button').on('click', fun);
        $('#confirmModal').modal();
    };

    this.uploadModal = function (houseID) {
        var header = $("meta[name='_csrf_header']").attr("content");
        var token = $("meta[name='_csrf']").attr("content");
        var viewMode = $("input[name='viewMode']:checked").val();

        $('#uploadViewModal').modal();
        // 初始化Check组件
        $('.radio').iCheck({
            radioClass: 'iradio_flat-red'
        });
        //初始化文件上传组件
        $('#file').fileinput({
            language: 'zh',//语言
            uploadUrl: '/file/upload',//上传的地址
            initialCaption: '请上传房屋图片...',//文本框初始化标题
            allowedFileExtensions: ['jpg'],//接收的文件后缀
            showCaption: true,//是否显示标题
            dropZoneEnabled: true,//是否显示拖拽区域
            maxFileSize: 2048,//单位为kb，如果为0表示不限制文件大小
            maxFileCount: 2,//表示允许同时上传的最大文件个数
            validateInitialCount: true,
            overwriteInitial: false,
            showDrag: true,
            showAjaxErrorDetails: true,
            enctype: 'multipart/form-data',
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}",
            ajaxSettings: {
                beforeSend: function (xhr) {
                    xhr.setRequestHeader(header, token);
                }
            },
            uploadExtraData: {
                houseID: houseID,
                viewMode: viewMode
            }
        });

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
    this.selectInitAjax = function (target, URL) {
        $.getJSON(URL, function (backData) {
            target.select2({
                data: backData.data
            });
        });
    };
}

function refresh() {
    window.location.reload();
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

