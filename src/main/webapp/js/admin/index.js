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
    $("[href='#store']").on('click', init.storeInit);
});

function Init() {
    this.companyInit = function () {
        // var adminCompany = new AdminCompany();
        // adminCompany.menuInit();
    };

    this.storeInit = function () {
        var adminStore = new AdminStore();
        adminStore.menuInit();
    };
}

function AdminCompany() {
    var table = $('#CA-table');
    var company = $('#company');
    var location = new Location(company.find("[name='province']"), company.find("[name='city']"), company.find("[name='area']"));
    this.menuInit = function () {
        location.locationInit();
        new SelectUtil().selectInitForJson(company.find("[name='status']"), '/json/status_sys.json');
        this.tableInit();
        $("#CA-query").on('click', this.query);
        table.find("[name='CA-pass']").each(function () {
            var id = $(this).parent().attr('id');
            $(this).on('click', function () {
                var httpUtil = new HttpUtil();
                httpUtil.postCRF('/company/pass', {
                    companyID: id
                }, function (data) {
                    var modal = $.scojs_modal({
                        keyboard: true,
                        title: '操作提示',
                        content: data.message,
                        onClose: refresh
                    });
                    modal.show();
                });
            });
        })
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

    this.query = function () {
        $.getJSON('/company/select', {
            provinceID: location.getProvinceVal(),
            cityID: location.getCityVal(),
            areaID: location.getAreaVal(),
            status: company.find("[name='status']").val()
        }, function (data) {
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
                            pageNum: page,
                            provinceID: location.getProvinceVal(),
                            cityID: location.getCityVal(),
                            areaID: location.getAreaVal(),
                            status: company.find("[name='status']").val()
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

    this.passInit = function () {
        var buttons = table.find("[name='CA-pass']");
        for (var i = 0; i < buttons.length; i++) {

        }
    };

    this.refuse = function () {
        var httpUtil = new HttpUtil();
        httpUtil.postCRF('/company/pass', {
            companyID: id
        }, function (data) {
            var modal = $.scojs_modal({
                keyboard: true,
                title: '操作提示',
                content: data.message,
                onClose: refresh
            });
            modal.show();
        });
    }
}

function AdminStore() {
    var table = $('#SA-table');
    var store = $('#store');
    var location = new Location(store.find("[name='province']"), store.find("[name='city']"), store.find("[name='area']"));
    this.menuInit = function () {
        location.locationInit();
        new SelectUtil().selectInitForJson(store.find("[name='status']"), '/json/status_sys.json');
        this.tableInit();
        $("#SA-query").on('click', this.query);
    };
    this.tableInit = function () {
        $.getJSON('/store/select', function (data) {
            if (data.status) {
                table.html(template('SA-template', data));
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
                        $.getJSON('/store/select', {
                            pageNum: page
                        }, function (data) {
                            if (data.status) {
                                table.html(template('SA-template', data));
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
                $('#SA-page').bootstrapPaginator(options);
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
    this.query = function () {
        $.getJSON('/store/select', {
            provinceID: location.getProvinceVal(),
            cityID: location.getCityVal(),
            areaID: location.getAreaVal(),
            status: store.find("[name='status']").val()
        }, function (data) {
            if (data.status) {
                table.html(template('SA-template', data));
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
                        $.getJSON('/store/select', {
                            pageNum: page,
                            provinceID: location.getProvinceVal(),
                            cityID: location.getCityVal(),
                            areaID: location.getAreaVal(),
                            status: store.find("[name='status']").val()
                        }, function (data) {
                            if (data.status) {
                                table.html(template('SA-template', data));
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
                $('#SA-page').bootstrapPaginator(options);
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
    this.pass = function () {
        var httpUtil = new HttpUtil();
        httpUtil.postCRF('/store/pass', {
            storeID: id
        }, function (data) {
            var modal = $.scojs_modal({
                keyboard: true,
                title: '操作提示',
                content: data.message,
                onClose: refresh
            });
            modal.show();
        });
    };
    this.refuse = function () {
        var httpUtil = new HttpUtil();
        httpUtil.postCRF('/store/pass', {
            storeID: id
        }, function (data) {
            var modal = $.scojs_modal({
                keyboard: true,
                title: '操作提示',
                content: data.message,
                onClose: refresh
            });
            modal.show();
        });
    }
}

