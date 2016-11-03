/**
 * Created by wuxinzhe on 16/10/7.
 */
/**
 * Created by wuxinzhe on 16/10/7.
 */
$(document).ready(userInfoShow());

function userInfoShow() {
    var account = $("#account");
    var loginOrRegister = $("#loginOrRegister");
    var userInfo = null;
    $.getJSON("/user/getUserInfo", function (data) {
        userInfo = data.data;
        if (null == userInfo) {
            //userInfo若为空(未登录),则账户信息隐藏
            account.addClass("hidden");
            //相对的,登录信息显示
            loginOrRegister.removeClass("hidden");
        } else {
            //userInfo若不为空(已经登录),则账户信息显示
            account.removeClass("hidden");
            //相对的,登录信息隐藏
            loginOrRegister.addClass("hidden");
        }
    });
}


function logout() {
    $("#logout-form").submit();
}


