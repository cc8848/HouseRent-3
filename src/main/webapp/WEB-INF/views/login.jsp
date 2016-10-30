<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wuxinzhe
  联系QQ: 124734668
  创建日期: 16/10/4
  创建时间: 下午1:02
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">

<body>
<div class="container-fluid">
    <div class="hidden-xs col-sm-1 col-md-2 col-lg-3"></div>
    <div class="col-xs-12 col-sm-10 col-md-8 col-lg-6 row-fluid">
        <div class="page-header">
            <h1>易租网
                <small>EasyRent</small>
                <a href="/" class="btn btn-xs btn-primary pull-right active">返回首页</a>
            </h1>
        </div>
    </div>
    <div class="hidden-xs col-sm-1 col-md-2 col-lg-3"></div>
</div>
<!--登录&注册-->
<div class="container-fluid">
    <div class="row-fluid">
        <span class="hidden-xs col-sm-2 col-md-3 col-lg-4 "></span>
        <span class="col-xs-12 col-sm-8 col-md-6 col-lg-4">
            <ul class="nav nav-tabs">
                <li id="login-tab" class="active">
                    <a href="#login-content" data-toggle="tab">登录</a>
                </li>
                <li id="register-tab">
                    <a href="#register-content" data-toggle="tab">注册</a>
                </li>
                <li id="reset-tab">
                    <a href="#reset-content" data-toggle="tab">找回密码</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="login-content">
                    <div class="col-xs-1 col-sm-2"></div>
                    <div class="col-xs-10 col-sm-8">
                        <%--登录 start--%>
                        <form id="login-form" class="form" role="form" method="post" action="/login.do">
                            <div class="white-divider-xl"></div>
                            <!--用户名-->
                            <div class="form-group input-group input-group-sm">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                                <input id="login-phone" name="username" type="text" class="form-control"
                                       placeholder="手机号">
                            </div>
                            <div class="white-divider-xs"></div>
                            <!--密码-->
                            <div class="form-group input-group input-group-sm">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span>
                                </div>
                                <input id="login-password" type="password" name="password" class="form-control"
                                       placeholder="密码">
                            </div>
                            <div class="white-divider-xs"></div>
                            <!--手机验证码-->
                            <div class="form-group  input-group input-group-sm ">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-qrcode"></span>
                                </div>
                                <input id="login-captcha" type="text" name="captcha" class="form-control"
                                       placeholder="验证码">
                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                            onclick="getCaptcha()">点击获取 <span class="caret"></span></button>
                                    <ul class="dropdown-menu dropdown-menu-right " role="menu">
                                      <li><img id="captcha-img" src="" class="pic-align-center"></li>
                                    </ul>
                                </div><!-- /btn-group -->
                            </div>
                            <div class="white-divider-xs"></div>
                            <div class="form-group">
                                <sec:csrfInput/>
                                <button id="login-button" type="button" class="btn btn-sm btn-primary btn-block">登录
                                </button>
                            </div>
                            <div class="form-group">
                                <div id="login-errorMessage" class="alert alert-danger alert-dismissible"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Close</span>
                                    </button>
                                    <span class="glyphicon glyphicon-remove-circle"></span>
                                    <c:out value="${sessionScope.loginResult.message}"/>
                                </div>
                            </div>
                        </form><%--登录 end--%>
                    </div>
                    <div class="col-xs-1 col-sm-2"></div>
                </div>
                <div class="tab-pane" id="register-content">
                    <div class="col-xs-1 col-sm-2"></div>
                    <div class="col-xs-10 col-sm-8">
                        <%--注册 start--%>
                        <form id="register-form" class="form" role="form">
                            <div class="white-divider-xl"></div>
                            <!--用户名-->
                            <div class="form-group input-group input-group-sm">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                                <input id="register-phone" name="username" type="text" class="form-control"
                                       placeholder="手机号">
                            </div>
                            <div class="white-divider-xs"></div>
                            <!--密码-->
                            <div class="form-group input-group input-group-sm">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-lock"></span>
                                </div>
                                <input id="register-password" type="password" name="password" class="form-control"
                                       placeholder="密码">
                            </div>
                            <div class="white-divider-xs"></div>
                            <!--手机验证码-->
                            <div class="form-group input-group input-group-sm">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-qrcode"></span>
                                </div>
                                <input id="register-captcha" type="text" name="captcha" class="form-control"
                                       placeholder="手机验证码">
                                <span class="input-group-btn">
                                      <button class="btn btn-default" type="button" onclick="getSMS()">发送验证码</button>
                                </span>
                            </div>
                            <div class="white-divider-xs"></div>
                            <%--注册按钮--%>
                            <div class="form-group">
                                <button type="button" class="btn btn-sm btn-primary btn-block"
                                        onclick="register()">注册
                                </button>
                            </div>
                            <!--提示信息-->
                            <div class="form-group">
                                <div id="register-errorMessage" class="alert alert-danger alert-dismissible hidden"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Close</span>
                                    </button>
                                    <span class="glyphicon glyphicon-remove-circle"></span>
                                </div>
                            </div>
                        </form>
                        <%--注册 end--%>
                    </div>
                    <div class="col-xs-1 col-sm-2"></div>
                </div>
                <div class="tab-pane" id="reset-content">
                    <div class="col-xs-1 col-sm-2"></div>
                    <div class="col-xs-10 col-sm-8">
                        <form id="reset-form" class="form" role="form" method="post" action="/register">
                            <div class="white-divider-xl"></div>
                            <!--用户名-->
                            <div id="reset-phone-box" class="form-group input-group input-group-sm">
                                <div class="input-group-addon"><span class="glyphicon glyphicon-user"></span></div>
                                <input id="reset-phone" name="username" type="text" class="form-control"
                                       placeholder="手机号">
                            </div>
                            <div class="white-divider-xs"></div>
                            <!--手机验证码-->
                            <div id="reset-captcha-box" class="form-group input-group input-group-sm">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-qrcode"></span>
                                </div>
                                <input id="reset-captcha" type="text" name="captcha" class="form-control"
                                       placeholder="手机验证码">
                                 <span class="input-group-btn">
                                      <button class="btn btn-default" type="button">发送验证码</button>
                                 </span>
                            </div>
                            <!--密码-->
                            <div id="reset-password-box" class="form-group input-group input-group-sm hidden">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-lock"></span>
                                </div>
                                <input id="reset-password" type="password" name="password" class="form-control"
                                       placeholder="密码">
                            </div>
                            <div class="form-group">
                                <button id="reset-submit" type="button" class="btn btn-sm btn-primary btn-block">提交
                                </button>
                            </div>
                            <div class="form-group">
                                <div id="reset-errorMessage" class="alert alert-danger alert-dismissible hidden"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Close</span>
                                    </button>
                                    <span class="glyphicon glyphicon-remove-circle"></span>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-xs-1 col-sm-2"></div>
                </div>
            </div>
        </span>
        <span class="hidden-xs col-sm-2 col-md-3 col-lg-4"></span>
    </div>
</div>
<script src="../../js/jquery.js"></script>
<script src="../../js/login.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        var loginErrorMessage = $("#login-errorMessage");
        if (${sessionScope.loginResult.message!=null}) {
            loginErrorMessage.removeClass("hidden");
        } else {
            loginErrorMessage.addClass("hidden");
        }
    });
</script>
<script src="../../js/bootstrap.min.js"></script>
<script type="text/javascript">
    function getCaptcha() {
        $('#captcha-img').hide().attr(
                'src',
                '<c:url value="/jcaptcha.jpg"/>' + '?' + Math
                        .floor(Math.random() * 100)).fadeIn();
    }
</script>
</body>
</html>
