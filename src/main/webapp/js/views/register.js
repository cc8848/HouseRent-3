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
    var company = $('#company');
    // ——————————————————————————
    var agree = $('#agree');

    var com = [username, password, captcha, name, license, sex, job, company, agree];

    this.init = function () {
        $("[name='register']").on('click', this.submit)
    };

    this.submit = function () {
        if (validate()) {
            var http = new HttpUtil();
            http.postCRF('/user/register', {
                username: username.val(),
                password: password.val(),
                captcha: captcha.val(),
                name: name.val(),
                license: license.val(),
                sex: sex.val(),
                job: job.val(),
                company: company.val()
            }, function (data) {

            })
        } else {

        }

        function validate() {
            var flag = true;
            var vali = new Validate();
            $.each(com, function () {
                if (!vali.not_empty(this)) {
                    this.closest('.form-group').addClass('has-error');
                    flag = false;
                }
            });
            return flag;
        }
    };

}

function Validate() {

    this.not_empty = function (target) {
        if ('INPUT' == target[0].targetName) {
            return target.val() != null && target.val().length > 0;
        } else if ('SELECT' == target[0].targetName) {
            return target.val() != null && target.val().length > 0 && target.val() != 0;
        }
    };

    this.minLength = function (target, len) {
        return target.val().length > len;
    };

    this.maxLength = function (target, len) {
        return target.val().length < len;
    }

}