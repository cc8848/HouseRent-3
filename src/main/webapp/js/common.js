/**
 * Created by wuxinzhe on 16/10/2.
 */
function getCaptcha() {
    $("#captcha-box").removeClass("hidden");
}

function refreshCaptcha() {
    $("#captcha-img").hide().attr(
        'src',
        '<c:url value="/jcaptcha.jpg"/>' + '?' + Math
            .floor(Math.random() * 100)).fadeIn();
}

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

function registerCheck() {
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
        register(phone.val(), password.val(), captcha.val());
    }
}

function register(phoneVal, passwordVal, captchaVal) {
    $.getJSON("register", {
        username: phoneVal,
        password: passwordVal,
        captcha: captchaVal
    }, function (data, status) {
        //判断请求是否成功
        var errorMessage = $("#register-errorMessage");
        //请求失败
        if (status = "fail") {
            errorMessage.removeClass("hidden").html(data.message);
        } else if (status == "success" && data.status == "false") {//请求成功,注册失败
            errorMessage.removeClass("hidden").html(data.message);
        } else if (status == "success" && data.status == "true") {//请求成功,注册成功
            errorMessage.removeClass("alert-danger hidden").addClass("alert-success").html("注册成功,请登录!");
        }
    });
}
