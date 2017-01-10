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
    var api = null;
    var _this = this;
    this.init = function () {
        $("[name='modify']").on('click', this.modifyAction);
        $("[name='modifyCancel']").on('click', refresh);
        $("[name='upload']").on('click', this.portraitUpload)
        $("[name='modifySubmit']").on('click', this.modifySubmit);
    };

    this.modifyAction = function () {
        $('.form-control').each(function () {
            $(this).removeAttr('disabled');
        });
        $('.hidden').removeClass('hidden');
    };

    this.modifySubmit = function () {
        var validAccount = $.scojs_valid('#account', {
            rules: {
                name: ['not_empty'],
                license: ['not_empty', {regex: /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/}],
                sex: ['not_empty', {regex: /[1-9]/}],
                job: ['not_empty', {regex: /[1-9]/}],
                major: ['not_empty', {regex: /[1-9]/}],
                company: ['not_empty', {regex: /^[\u4e00-\u9fa5]{1,6}$/}]
            },
            messages: {
                name: {not_empty: '此处必须输入'},
                license: {not_empty: '此处必须输入', regex: '身份证号码不正确'},
                sex: {not_empty: '此处必须输入', regex: '此处必须输入'},
                job: {not_empty: '此处必须输入', regex: '此处必须输入'},
                major: {not_empty: '此处必须输入', regex: '此处必须输入'},
                company: {not_empty: '此处必须输入', regex: '6个汉字以内'}
            }
        });
        if (validAccount.validate()) {
            var http = new HttpTools();
            http.postCRF('/user/modify', {
                name: $("[name='name']").val(),
                license: $("[name='license']").val(),
                sex: $("[name='sex']").val(),
                job: $("[name='job']").val(),
                companyAbbr: $("[name='companyAbbr']").val(),
                major: $("[name='major']").val()
            }, function (data) {
                var tools = new ModalTools();
                var model = {};
                if (data.status) {
                    model = $.scojs_modal({
                            title: '修改成功',
                            content: tools.p(data.message),
                            onClose: refresh
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
            })
        }
    };

    this.portraitUpload = function () {
        var model = $.scojs_modal({
                title: '头像上传',
                content: template('portraitUpload'),
                onClose: refresh
            }
        );
        model.show();
        var fileUp = new FileUpload();
        var portrait = $('#fileUpload');
        fileUp.portrait(portrait, '/upload/portrait', _this.getExtraData, $('#alert'));
        portrait.on('change', _this.readURL);
    };

    this.readURL = function () {
        var img = $('#cut-img');
        var input = $('#fileUpload');
        if (input[0].files && input[0].files[0]) {
            var reader = new FileReader();
            reader.readAsDataURL(input[0].files[0]);
            reader.onload = function (e) {
                img.removeAttr('src');
                img.attr('src', e.target.result);
                img.Jcrop({
                    setSelect: [20, 20, 200, 200],
                    handleSize: 10,
                    aspectRatio: 1,
                    onSelect: updateCords
                }, function () {
                    api = this;
                });
            };
            if (api != undefined) {
                api.destroy();
            }
        }
        function updateCords(obj) {
            $("#x").val(obj.x);
            $("#y").val(obj.y);
            $("#w").val(obj.w);
            $("#h").val(obj.h);
        }
    };

    this.getExtraData = function () {
        return {
            sw: $('.jcrop-holder').css('width'),
            sh: $('.jcrop-holder').css('height'),
            x: $('#x').val(),
            y: $('#y').val(),
            w: $('#w').val(),
            h: $('#h').val()
        }
    }
}

