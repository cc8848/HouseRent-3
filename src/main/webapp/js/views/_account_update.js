/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/10
 * 类说明:
 * 更新记录：
 */
var form = $('form');
var province = form.find("[name='province']");
var city = form.find("[name='city']");
var area = form.find("[name='area']");

$(document).ready(function () {
    new PageInit().init();
});

function PageInit() {
    this.init = function () {
        $.getJSON("/address/getAllProvince", function (data) {
            province.select2({
                placeholder: "请选择省份",
                data: data.data
            });
        });
    }
}


function Event() {
}