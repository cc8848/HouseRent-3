/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/26
 * 类说明:
 * 更新记录：
 */
$(document).ready(function () {
    var handHouse = new HandHouseIssue();
    handHouse.Init();
});

function HandHouseIssue() {
    var serialNum = $('#serialNum');//房屋编号
    var community = $('#community');//社区
    var roomQuantity = $('#roomQuantity');//室数量
    var hallQuantity = $('#hallQuantity');//厅数量
    var bathroomQuantity = $('#bathroomQuantity');//卫数量
    var type = $('#type');//房屋类型
    var decoration = $('#decoration');//装修情况
    var orientation = $('#orientation');//朝向
    var currentFloor = $('#currentFloor');//所在楼层
    var totalFloor = $('#totalFloor');//总楼层
    var floorArea = $('#floorArea');//建筑面积
    var buildAge = $('#buildAge');//建造年代
    var price = $('#price');//出售价格
    var propertyRightsForTwoYears = $('#propertyRightsForTwoYears');//产权是否满两年
    var onlyHousing = $('#onlyHousing');//是否唯一性住房
    var title = $('#title');//房屋标题
    var houseDetails = $('#houseDetails');//房屋详情
    var ownerMentality = $('#ownerMentality');//房东心态
    var supportingFacility = $('#supportingFacility');//配套设施
    var professionalService = $('#professionalService');//服务介绍
    var location = new Location($("[name='province']"), $("[name='city']"), $("[name='area']"));//省市区

    this.Init = function () {
        $("[name='propertyRightsForTwoYears'],[name='onlyHousing']").bootstrapSwitch({
            onText: "是",
            offText: "否",
            onColor: "success",
            offColor: "danger",
            size: "small",
            state: false,
            onInit: function () {
                $(this).val("0");
            },
            onSwitchChange: function (event, state) {
                if (state == true) {
                    $(this).val("1");
                } else {
                    $(this).val("0");
                }
            }
        });
        location.locationInit();
        //房屋类型初始化
        $.getJSON('/json/house_type.json', function (data) {
            type.select2({
                placeholder: "请选择",
                data: data
            });
        });
        //装修类型初始化
        $.getJSON('/json/house_decoration.json', function (data) {
            decoration.select2({
                placeholder: "请选择",
                data: data
            });
        });
        //房屋朝向初始化
        $.getJSON('/json/house_orientation.json', function (data) {
            orientation.select2({
                placeholder: "请选择",
                data: data
            });
        });
        $("[name='issue']").on('click', this.issueSubmit);
    };

    this.issueSubmit = function () {
        var http = new HttpTools();
        if (valid.validate()) {
            http.postCRF('/handHouse/issue', {
                    serialNum: serialNum.val(),
                    provinceId: location.getProvinceVal(),
                    cityId: location.getCityVal(),
                    areaId: location.getAreaVal(),
                    communityName: community.val(),
                    roomQuantity: roomQuantity.val(),
                    hallQuantity: hallQuantity.val(),
                    bathroomQuantity: bathroomQuantity.val(),
                    type: type.select2('val'),
                    decoration: decoration.select2('val'),
                    orientation: orientation.select2('val'),
                    currentFloor: currentFloor.val(),
                    totalFloor: totalFloor.val(),
                    floorArea: floorArea.val(),
                    buildAge: buildAge.val(),
                    price: price.val(),
                    propertyRightsForTwoYears: propertyRightsForTwoYears.val(),
                    onlyHousing: onlyHousing.val(),
                    title: title.val(),
                    houseDetails: houseDetails.val(),
                    ownerMentality: ownerMentality.val(),
                    supportingFacility: supportingFacility.val(),
                    professionalService: professionalService.val()
                },
                function (data) {
                    var tools = new ModalTools();
                    var model = {};
                    if (data.status) {
                        model = $.scojs_modal({
                                title: '注册成功',
                                content: tools.p(data.message),
                                onClose: function () {
                                    forward('/home');
                                }
                            }
                        );
                    } else {
                        model = $.scojs_modal({
                                title: '错误信息',
                                content: tools.p(data.message)
                            }
                        );
                    }
                    model.show();
                }
            )
        }

    };

    var valid = $.scojs_valid('#hand_house_issue', {
        rules: {
            province: ['not_empty'],
            city: ['not_empty'],
            area: ['not_empty'],
            community: ['not_empty'],
            roomQuantity: ['not_empty'],
            hallQuantity: ['not_empty'],
            bathroomQuantity: ['not_empty'],
            type: ['not_empty'],
            decoration: ['not_empty'],
            orientation: ['not_empty'],
            currentFloor: ['not_empty'],
            totalFloor: ['not_empty'],
            floorArea: ['not_empty'],
            buildAge: ['not_empty'],
            price: ['not_empty'],
            title: ['not_empty'],
            houseDetails: ['not_empty'],
            ownerMentality: ['not_empty'],
            supportingFacility: ['not_empty'],
            professionalService: ['not_empty']
        },
        messages: {
            province: {not_empty: '此处必须输入'},
            city: {not_empty: '此处必须输入'},
            area: {not_empty: '此处必须输入'},
            community: {not_empty: '此处必须输入'},
            roomQuantity: {not_empty: '此处必须输入'},
            hallQuantity: {not_empty: '此处必须输入'},
            bathroomQuantity: {not_empty: '此处必须输入'},
            type: {not_empty: '此处必须输入'},
            decoration: {not_empty: '此处必须输入'},
            orientation: {not_empty: '此处必须输入'},
            currentFloor: {not_empty: '此处必须输入'},
            totalFloor: {not_empty: '此处必须输入'},
            floorArea: {not_empty: '此处必须输入'},
            buildAge: {not_empty: '此处必须输入'},
            price: {not_empty: '此处必须输入'},
            title: {not_empty: '此处必须输入'},
            houseDetails: {not_empty: '此处必须输入'},
            ownerMentality: {not_empty: '此处必须输入'},
            supportingFacility: {not_empty: '此处必须输入'},
            professionalService: {not_empty: '此处必须输入'}
        }
    });
}