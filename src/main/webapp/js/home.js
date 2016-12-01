/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/19
 * 类说明: home页面对应的js文件
 * 更新记录：
 */
$(document).ready(function () {
    $('.select2').select2();
    $("[href='#issue-info']").on('click', new IssueMenu().menuInit);
    $("[href='#creat-project']").on('click', new ProjectMenu().menuInit())
});

var modal = new Modal();

function IssueMenu() {

    var _this = this;

    var location = new Location('#province', '#city', '#area');

    this.menuInit = function () {
        location.locationInit();
        var selectUtil = new SelectUtil();
        selectUtil.selectInit($('#face'), "/json/house_face.json");
        selectUtil.selectInit($('#decoration'), "/json/house_decoration.json");
        selectUtil.selectInit($('#layout'), "/json/house_layout.json");
        selectUtil.selectInit(status, "/json/status_sell.json");
        $('#issueSubmit').on('click', _this.issueSubmit);
    };

    this.issueSubmit = function () {
        var httpUtil = new HttpUtil();
        httpUtil.postCRF('/house/issue', {
            tittle: $('#tittle').val(),
            desc: $('#desc').val(),
            faceID: $('#face').val(),
            address: $('#address').val(),
            floorArea: $('#floorArea').val(),
            poolArea: $('#poolArea').val(),
            price: $('#price').val(),
            floor: $('#floor').val(),
            layout: $('#layout').val(),
            decorationType: $('#decoration').val(),
            province: location.getProvinceVal(),
            city: location.getCityVal(),
            area: location.getAreaVal(),
            status: $('#status').val()
        }, function (backData) {
            var modal = new Modal();
            if (backData.status) {
                modal.uploadModal(backData.data);
            } else {
                modal.errorModal(backData.message);
            }
        });
    }
}

function ProjectMenu() {

    var _this = this;

    var form = $("#create-project");

    var location = new Location(form.find("[name='province']"), form.find("[name='city']"), form.find("[name='area']"));

    var map = new AMap.Map('community-map', {
        resizeEnable: true,
        zoom: 10
    });

    this.menuInit = function () {
        $('.form_date').datetimepicker({
            language: 'zh-CN',
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
        location.locationInit();
        AMap.plugin(['AMap.ToolBar', 'AMap.Scale'],
            function () {
                map.addControl(new AMap.ToolBar());
                map.addControl(new AMap.Scale());
            });
        map.plugin('AMap.Geolocation', function () {
            geolocation = new AMap.Geolocation({
                enableHighAccuracy: true,//是否使用高精度定位，默认:true
                timeout: 10000,          //超过10秒后停止定位，默认：无穷大
                buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
                showButton: false,
                panToLocation: true
            });
            map.addControl(geolocation);
            geolocation.getCurrentPosition();
            AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
            AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
        });
        function onComplete(data) {
            form.find("[name='lng']").val(data.position.getLng());
            form.find("[name='lat']").val(data.position.getLat());
            var marker = new AMap.Marker({
                map: map,
                position: [data.position.getLng(), data.position.getLat()],
                draggable: true
            });
            AMap.event.addListener(marker, 'dragend', function () {
                form.find("[name='lng']").val(marker.getPosition().getLng());
                form.find("[name='lat']").val(marker.getPosition().getLat());
            });
        }

        function onError(data) {
            var str = '定位失败，错误信息：';
            switch (data.info) {
                case 'PERMISSION_DENIED':
                    str += '浏览器阻止了定位操作';
                    break;
                case 'POSITION_UNAVAILBLE':
                    str += '无法获得当前位置';
                    break;
                case 'TIMEOUT':
                    str += '定位超时';
                    break;
                default:
                    str += '未知错误';
                    break;
            }
            $.scojs_message(str, $.scojs_message.TYPE_ERROR);
        }

        form.find("[name='submit']").on('click', _this.submit);
    };

    this.submit = function () {
        var target = ["tittle", "province", "city", "area", "address", "lng", "lat", "openTime", "realEstateTime", "estateManageCompany"];
        var notEmpty = true;
        var maxLength = true;
        $.each(target, function () {
            var input = form.find("[name='" + this + "']");
            if (null == input.val() || input.val() == "") {
                input.parent().parent().addClass('has-error');
                notEmpty = false;
            }
            if (this == "tittle" && input.val().length > 15) {
                input.parent().parent().addClass('has-warning');
                maxLength = false;
            }
        });
        if (notEmpty && maxLength) {
            var httpUtil = new HttpUtil();
            httpUtil.postCRF('/community/create', {
                    communityName: form.find("[name='tittle']").val(),
                    provinceID: location.getProvinceVal(),
                    cityID: location.getCityVal(),
                    areaID: location.getAreaVal(),
                    address: form.find("[name='address']").val(),
                    lng: form.find("[name='lng']").val(),
                    lat: form.find("[name='lat']").val(),
                    openTime: form.find("[name='openTime']").val(),
                    realEstateTime: form.find("[name='realEstateTime']").val(),
                    estateManageCompany: form.find("[name='estateManageCompany']").val()
                },
                function (data) {
                    modal.infoModal(data.message);
                    $('#infoModal').on('hidden.bs.modal', refresh);
                }
            )
        } else {
            var str = "温馨提示：";
            if (!notEmpty && !maxLength) {
                str += "项目名称不得超出15字并且请完成红色的必输字段！";
            } else if (!notEmpty && maxLength) {
                str += "请完成红色必输字段！";
            } else {
                str += "项目名称不得超出15字";
            }
            $.scojs_message(str, $.scojs_message.TYPE_ERROR);
        }
    }
}
