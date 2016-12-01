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

    var tittle = $('#tittle');

    var desc = $('#desc');

    var price = $('#price');

    var floor = $('#floor');

    var floorArea = $('#floorArea');

    var poolArea = $('#poolArea');

    var face = $('#face');

    var decoration = $('#decoration');

    var layout = $('#layout');

    var status = $('#status');

    var address = $('#address');

    var submit = $('#issueSubmit');

    var location = new Location('#province', '#city', '#area');

    this.menuInit = function () {
        location.locationInit();
        var array = [];
        array.push();
        var selectUtil = new SelectUtil();
        selectUtil.selectInit(face, "/json/house_face.json");
        selectUtil.selectInit(decoration, "/json/house_decoration.json");
        selectUtil.selectInit(layout, "/json/house_layout.json");
        selectUtil.selectInit(status, "/json/status_sell.json");
        submit.on('click', _this.issueSubmit);
    };

    this.issueSubmit = function () {
        HttpUtil.postCRF('/house/issue', {
            tittle: tittle.val(),
            desc: desc.val(),
            faceID: face.val(),
            address: address.val(),
            floorArea: floorArea.val(),
            poolArea: poolArea.val(),
            price: price.val(),
            floor: floor.val(),
            layout: layout.val(),
            decorationType: decoration.val(),
            province: location.getProvinceVal(),
            city: location.getCityVal(),
            area: location.getAreaVal(),
            status: status.val()
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
        zoom: 12
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
                maximumAge: 0,           //定位结果缓存0毫秒，默认：0
                convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
                showButton: true,        //显示定位按钮，默认：true
                buttonPosition: 'RT',    //定位按钮停靠位置，默认：'LB'，左下角
                buttonOffset: new AMap.Pixel(10, 10),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
                showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
                markerOptions: {
                    draggable: true
                },
                showCircle: false,        //定位成功后用圆圈表示定位精度范围，默认：true
                panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
                zoomToAccuracy: true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            });
            map.addControl(geolocation);
            AMap.event.addListener(geolocation, 'complete', _this.onComplete);//返回定位信息
            // AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
        });
        form.find("[name='submit']").on('click', _this.submit);
    };

    this.onComplete = function (data) {
        form.find("[name='mapX']").val(data.position.getLng());
        form.find("[name='mapY']").val(data.position.getLat());
    };

    this.submit = function () {
        var httpUtil = new HttpUtil();
        httpUtil.postCRF('/community/create', {
                communityName: form.find("[name='tittle']").val(),
                provinceID: location.getProvinceVal(),
                cityID: location.getCityVal(),
                areaID: location.getAreaVal(),
                mapX: form.find("[name='mapX']").val(),
                mapY: form.find("[name='mapY']").val(),
                openTime: form.find("[name='openTime']").val(),
                realEstateTime: form.find("[name='realEstateTime']").val(),
                estateManageCompany: form.find("[name='estateManageCompany']").val()
            },
            function (data) {
                modal.confirmModal(data.message, refresh);
            }
        )
    }
}
