/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/6
 * 类说明:
 * 更新记录：
 */

$(document).ready(function () {
    var init = new Init();
    $('.select2').select2();

    $("[href='#company']").on('click', init.companyInit);

});

function Init() {
    this.companyInit = function () {
        var adminCompany = new AdminCompany();
        adminCompany.menuInit();
    }
}

function AdminCompany() {
    var table = $('#CA-table');
    var company = $('#company');
    var location = new Location(company.find("[name='province']"), company.find("[name='city']"), company.find("[name='area']"));
    this.menuInit = function () {
        location.locationInit();
        new SelectUtil().selectInitForJson(company.find("[name='status']"), '/json/status_sys.json');
        this.tableInit();
    };

    this.tableInit = function () {
        $.getJSON('/company/select', function (data) {
            if (data.status) {
                table.html(template('CA-template', data));
                var pages = data.data.pages;
                var pageNum = data.data.pageNum;
                var options = {
                    bootstrapMajorVersion: 3,//bootstrap版本
                    currentPage: pageNum, //当前页数
                    totalPages: pages, //总页数
                    itemTexts: function (type, page, current) {
                        switch (type) {
                            case "first":
                                return "首页";
                            case "prev":
                                return "上一页";
                            case "next":
                                return "下一页";
                            case "last":
                                return "末页";
                            case "page":
                                return page;
                        }
                    },//点击事件，用于通过Ajax来刷新整个list列表
                    onPageClicked: function (event, originalEvent, type, page) {
                        $.getJSON('/company/select', {
                            pageNum: page
                            // provinceID: location.getProvinceVal(),
                            // cityID: location.getCityVal(),
                            // areaID: location.getAreaVal(),
                            // status: company.find("[name='status']").val()
                        }, function (data) {
                            if (data.status) {
                                table.html(template('CA-template', data));
                            } else {
                                var modal = $.scojs_modal({
                                    keyboard: true,
                                    title: '错误提示',
                                    content: data.message
                                });
                                modal.show();
                            }
                        });
                    }
                };
                $('#CA-page').bootstrapPaginator(options);
            } else {
                var modal = $.scojs_modal({
                    keyboard: true,
                    title: '错误提示',
                    content: data.message
                });
                modal.show();
            }
        });
    };
}