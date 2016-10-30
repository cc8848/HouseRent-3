/**
 * Created by wuxinzhe on 16/10/2.
 */

function getSMS() {
    var phone = $("#register-phone");
    if (phone.val().length == 0) {
        phone.addClass("alert alert-danger").attr("placeholder", "手机号不能为空!");
    } else {
        phone.removeClass("alert alert-danger").attr("placeholder", "手机号");
        alert("验证码已发送!");
    }
}

function login() {
    var username = $("#login-phone");
    var password = $("#login-password");
    var captcha = $("#login-captcha");
    if (username.val().trim().length == 0) {
        username.addClass("alert alert-danger").attr("placeholder", "手机号不能为空!");
    } else {
        username.removeClass("alert alert-danger").attr("placeholder", "手机号");
    }
    if (password.val().trim().length == 0) {
        password.addClass("alert alert-danger").attr("placeholder", "密码不能为空!");
    } else {
        password.removeClass("alert alert-danger").attr("placeholder", "密码");
    }
    if (captcha.val().trim().length == 0) {
        captcha.addClass("alert alert-danger").attr("placeholder", "验证码不能为空!");
    } else {
        captcha.removeClass("alert alert-danger").attr("placeholder", "验证码");
    }
    if (!(username.val().trim().length == 0) && !(password.val().trim().length == 0) && !(captcha.val().trim().length == 0)) {
        $("#login-form").submit();
    }
}
$("#login-button").on('click',login);

function register() {
    var phone = $("#register-phone");
    var password = $("#register-password");
    var captcha = $("#register-captcha");
    if (phone.val().trim().length == 0) {
        phone.addClass("alert alert-danger").attr("placeholder", "手机号不能为空!");
    } else {
        phone.removeClass("alert alert-danger").attr("placeholder", "手机号");
    }
    if (password.val().trim().length == 0) {
        password.addClass("alert alert-danger").attr("placeholder", "密码不能为空!");
    } else {
        password.removeClass("alert alert-danger").attr("placeholder", "密码");
    }
    if (captcha.val().trim().length == 0) {
        captcha.addClass("alert alert-danger").attr("placeholder", "验证码不能为空!");
    } else {
        captcha.removeClass("alert alert-danger").attr("placeholder", "验证码");
    }
    if (!(phone.val().trim().length == 0) && !(password.val().trim().length == 0) && !(captcha.val().trim().length == 0)) {
        $.getJSON("register", {
            username: phone.val(),
            password: password.val(),
            captcha: captcha.val()
        }, function (data) {
            //判断请求是否成功
            var errorMessage = $("#register-errorMessage");
            //清空字段
            var reset = errorMessage.children();
            errorMessage.html(reset);
            //请求失败
            if (data.status == true) {
                errorMessage.removeClass("alert-danger hidden").addClass("alert-success").append(data.message);
            } else {
                errorMessage.removeClass("alert-success hidden").addClass("alert-danger").append(data.message);
            }
        });
    }
}

