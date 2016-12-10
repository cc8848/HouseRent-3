/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/10
 * 类说明:
 * 更新记录：
 */
$(document).ready(function () {
    new PageInit().init();
});


function PageInit() {

    var event = new Event();

    this.init = function () {
        $("#server").on('click',event.server);
    }
}

function Event() {
    var httpUtil = new HttpUtil();

    this.server = function () {
        //提交的表单
        var form = $("#CC-form");
        var confirm = $.scojs_confirm({
            target: '#CC-modal',
            content: template('CC-template'),
            action: submit
        });
        confirm.show();
        function submit() {
            httpUtil.postCRF('/company/create', {
                companyName: form.find("[name='companyName']").val(),
                provinceID: location.getProvinceVal(),
                cityID: location.getCityVal(),
                areaID: location.getAreaVal(),
                address: form.find("[name='address']").val(),
                phone: form.find("[name='phone']").val()
            }, function (data) {
                if (data.status) {
                    refresh();
                } else {
                    confirm.destroy();
                    var modal = $.scojs_modal({
                        keyboard: true,
                        title: '错误提示',
                        content: data.message,
                        onClose: refresh
                    });
                    modal.show();
                }
            })
        }
    }
}
