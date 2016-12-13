/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/12
 * 类说明:
 * 更新记录：
 */
$(document).ready(function () {
    new Register().init();
});

function Register() {

    // form对象———————————————————
    var username = $('#username');
    var password = $('#password');
    var captcha = $('#captcha');
    // ——————————————————————————
    var name = $('#name');
    var license = $('#license');
    var sex = $('#sex');
    var job = $('#job');
    var companyAbbr = $('#company');
    // ——————————————————————————
    var agree = $('#agree');

    var validAccount = $.scojs_valid('#account', {
        rules: {
            username: ['not_empty'],
            password: ['not_empty', {regex: /^[a-zA-Z0-9]{6,10}$/}],
            check: ['not_empty', {matches: 'password'}],
            captcha: ['not_empty', {regex: /^[1-9]{6}$/}],
            name: ['not_empty'],
            license: ['not_empty', {regex: /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/}],
            sex: ['not_empty', {regex: /[1-9]/}],
            job: ['not_empty', {regex: /[1-9]/}],
            company: ['not_empty', {regex: /^[\u4e00-\u9fa5]{1,6}$/}]
        },
        messages: {
            username: {not_empty: '此处必须输入'},
            password: {not_empty: '此处必须输入', regex: '密码必须为6-10位的字母或数字'},
            check: {not_empty: '此处必须输入', matches: '必须与上一个相同'},
            captcha: {not_empty: '此处必须输入', regex: '验证码为6位数字'},
            name: {not_empty: '此处必须输入'},
            license: {not_empty: '此处必须输入', regex: '身份证号码不正确'},
            sex: {not_empty: '此处必须输入', regex: '此处必须输入'},
            job: {not_empty: '此处必须输入', regex: '此处必须输入'},
            company: {not_empty: '此处必须输入', regex: '6个汉字以内'}
        },
        onSuccess: function (response, validator, $form) {
        }
    });

    this.init = function () {
        $("[name='register']").on('click', this.submit)
    };

    this.submit = function () {
        if (validAccount.validate()) {
            //服务条款是否同意
            if ($('#agree').is(':checked')) {
                var http = new HttpUtil();
                http.postCRF('/user/register', {
                    username: username.val(),
                    password: password.val(),
                    captcha: captcha.val(),
                    name: name.val(),
                    license: license.val(),
                    sex: sex.val(),
                    job: job.val(),
                    companyAbbr: companyAbbr.val()
                }, function (data) {
                    var tools=new ModalTools();
                    var model = {};
                    if (data.status) {
                        model = $.scojs_modal({
                                title: '错误信息',
                                content: tools.p(data.message),
                                onClose: function () {
                                    forward('/user/login');
                                }
                            }
                        );
                    } else {
                        model = $.scojs_modal({
                                title: '提示信息',
                                content: tools.p(data.message)
                            }
                        );
                    }
                    model.show();
                })
            } else {
                $.scojs_message('同意《网站注册服务条款》方可进行注册！', $.scojs_message.TYPE_ERROR)
            }
        }
    };

}