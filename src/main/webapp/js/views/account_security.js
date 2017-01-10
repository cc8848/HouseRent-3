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
    this.init = function () {
        $("[name='passwordSubmit']").on('click', this.passwordChange);
    };

    this.passwordChange = function () {
        var validSecurity = $.scojs_valid('#security', {
            rules: {
                old: ['not_empty', {regex: /^[a-zA-Z0-9]{6,10}$/}],
                new: ['not_empty', {regex: /^[a-zA-Z0-9]{6,10}$/}],
                check: ['not_empty', {matches: 'new'}],
                captcha: ['not_empty', {regex: /^[1-9]{6}$/}]
            },
            messages: {
                old: {not_empty: '此处必须输入', regex: '密码必须为6-10位的字母或数字'},
                new: {not_empty: '此处必须输入', regex: '密码必须为6-10位的字母或数字'},
                check: {not_empty: '此处必须输入', matches: '必须与新密码相同'},
                captcha: {not_empty: '此处必须输入', regex: '验证码为6位数字'}
            }
        });

        if (validSecurity.validate()) {
            var http = new HttpTools();
            http.postCRF('/user/security/password', {
                old: $("[name='old']").val(),
                new: $("[name='new']").val(),
                captcha: $("[name='captcha']").val()
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
                            title: '修改失败',
                            content: tools.p(data.message)
                        }
                    );
                }
                model.show();
            })
        }


    };
}

