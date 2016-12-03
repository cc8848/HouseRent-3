/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/11/19
 * 类说明: home页面对应的js文件
 * 更新记录：
 */
$(document).ready(function () {
    var homeTemplate = new HomeTemplate();

    $('.select2').select2();
    $("[href='#issue-house']").on('click', homeTemplate.issueHouseInit);
    $("[href='#create-project']").on('click', homeTemplate.createProjectInit);
    $("[href='#project-manage']").on('click', homeTemplate.projectManageInit);
    $("[href='#house-manage']").on('click', homeTemplate.houseManageInit);

});

var modal = new Modal();

function HomeTemplate() {

    this.issueHouseInit = function () {
        $('#issue-house').html(template('issue-house-template'));
        new IssueHouse().menuInit();
    };

    this.createProjectInit = function () {
        $('#create-project').html(template('create-project-template'));
        new ProjectCreate().menuInit();
    };

    this.projectManageInit = function () {
        $.getJSON('/community/myClassify', function (data) {
            $('#PM-table').html(template('project-manage-template', data));
            $('#PM-pageNum').html(data.data.pageNum);
            $('#PM-totalPage').html(data.data.pages);
            new ProjectManage().menuInit();
        });
    };

    this.houseManageInit = function () {
        var selectUtil = new SelectUtil();
        selectUtil.selectInitAjax($("[name='HM-project']"), "/community/select", {companyID: $('#HM-companyID').text()});
        new HouseManage().menuInit();
    }
}

function IssueHouse() {

    var _this = this;

    var form = $('#issue-house-form');

    var location = new Location(form.find("[name='province']"), form.find("[name='city']"), form.find("[name='area']"));

    this.menuInit = function () {
        location.locationInit();
        var selectUtil = new SelectUtil();
        selectUtil.selectInitForJson(form.find("[name='face']"), "/json/house_face.json");
        selectUtil.selectInitForJson(form.find("[name='decoration']"), "/json/house_decoration.json");
        selectUtil.selectInitForJson(form.find("[name='layout']"), "/json/house_layout.json");
        selectUtil.selectInitForJson(form.find("[name='houseStatus']"), "/json/status_sell.json");
        selectUtil.selectInitAjax(form.find("[name='community']"), "/community/select");
        selectUtil.selectInitForJson(form.find("[name='elevatorType']"), "/json/house_elevator.json");
        form.find("[name='issueSubmit']").on('click', _this.submit);
    };

    this.submit = function () {
        var httpUtil = new HttpUtil();
        httpUtil.postCRF('/house/create', {
            tittle: form.find("[name='tittle']").val(),
            desc: form.find("[name='desc']").val(),
            faceID: form.find("[name='face']").val(),
            address: form.find("[name='address']").val(),
            floorArea: form.find("[name='floorArea']").val(),
            poolArea: form.find("[name='poolArea']").val(),
            price: form.find("[name='price']").val(),
            floor: form.find("[name='floor']").val(),
            layout: form.find("[name='layout']").val(),
            decorationType: form.find("[name='decoration']").val(),
            communityID: form.find("[name='community']").val(),
            houseStatus: form.find("[name='houseStatus']").val(),
            brokerage: form.find("[name='brokerage']").val(),
            age: form.find("[name='age']").val(),
            elevatorType: form.find("[name='elevatorType']").val(),
            province: location.getProvinceVal(),
            city: location.getCityVal(),
            area: location.getAreaVal()
        }, function (backData) {
            modal.infoModal(backData.message);
            $('#infoModal').on('hidden.bs.modal', refresh);
        });
    }
}

/**
 * 创建项目
 * @constructor
 */
function ProjectCreate() {

    var _this = this;

    var form = $("#create-project-form");

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
        var target = ["tittle", "province", "city", "area", "address", "lng", "lat", "openTime", "realEstateTime"];
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
/**
 * 项目管理
 * @constructor
 */
function ProjectManage() {

    var pageNum = $('#PM-pageNum');

    var totalPage = $('#PM-totalPage');

    var table = $('#PM-table');

    var pageUtil = new PageUtil(pageNum, totalPage, '/community/myClassify', 'project-manage-template', table);

    this.menuInit = function () {
        $('#PM-next').on('click', pageUtil.nextPage);
        $('#PM-pre').on('click', pageUtil.prePage);
        $("[name='PM-cancel']").each(function () {
            $(this).click(function () {
                var id = $(this).attr('id');
                var array = id.split('-');
                var httpUtil = new HttpUtil();
                httpUtil.postCRF('/community/cancel', {
                    communityID: array[1]
                }, function (data) {
                    if (data.status) {
                        modal.infoModal(data.message);
                        $('#infoModal').on('hidden.bs.modal', refresh);
                    } else {
                        modal.infoModal(data.message);
                    }
                });
            });
        });
    };
}
/**
 * 房源管理
 * @constructor
 */
function HouseManage() {

    var pageNum = $('#HM-pageNum');

    var totalPage = $('#HM-totalPage');

    var table = $('#HM-table');

    var data = {companyID: $('#HM-companyID').text()};

    var pageUtil = new PageUtil(pageNum, totalPage, '/community/myClassify', 'house-manage-template', table, data);

    this.menuInit = function () {
        $('#HM-next').on('click', pageUtil.nextPage);
        $('#HM-pre').on('click', pageUtil.prePage);
        this.getAllHouse();
        $("[name='HM-project']").on('select2:select', this.getCommunityHouse);
    };

    this.getAllHouse = function () {
        $.getJSON('/house/myHouse', data, function (data) {
            table.html(template('house-manage-template', data));
            pageNum.html(data.data.pageNum);
            totalPage.html(data.data.pages);
        })
    };


    this.getCommunityHouse = function () {
        data.communityID = $("[name='HM-project']").val();
        $.getJSON('/house/myHouse', data, function (data) {
            table.html(template('house-manage-template', data));
            pageNum.html(data.data.pageNum);
            totalPage.html(data.data.pages);
        })
    }
}

