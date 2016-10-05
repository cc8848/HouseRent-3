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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">
<script src="../../js/jquery.js"></script>
<body>
<div class="container-fluid">
    <div class="col-xs-0 col-sm-3"></div>
    <div class="row-fluid col-xs-12 col-sm-6">
        <div class="page-header">
            <h1>易租网
                <button type="button" class="btn btn-xs btn-primary pull-right">返回首页</button>
                <small>EasyRent</small>

            </h1>

        </div>

    </div>
    <div class="col-xs-0 col-sm-3"></div>
</div>
<!--登录&注册-->
<div class="container-fluid">
    <div class="row-fluid">
        <span class="col-xs-0 col-sm-4"></span>
        <span class="col-xs-12 col-sm-4">
            <ul class="nav nav-tabs">
                <li id="register-tab" class="active">
                    <a href="#register-content" data-toggle="tab">注册</a>
                </li>
                <li id="login-tab">
                    <a href="#login-content" data-toggle="tab">登录</a>
                </li>
                <li id="reset-tab">
                    <a href="#reset-content" data-toggle="tab">找回密码</a>
                </li>
            </ul>
            <div class="tab-content">
                <div class="tab-pane active" id="register-content">
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
                                        onclick="registerCheck()">注册
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
                <div class="tab-pane " id="login-content">
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
                            <div class="form-group input-group input-group-sm">
                                <div class="input-group-addon">
                                    <span class="glyphicon glyphicon-qrcode"></span>
                                </div>
                                <input id="login-captcha" type="text" name="captcha" class="form-control"
                                       placeholder="验证码">
                                <div class="input-group-btn">
                                    <img src="<c:url value="/jcaptcha.jpg"/>" class="img-thumbnail"
                                         onclick="refreshCaptcha()">
                                </div>
                            </div>
                            <div class="white-divider-xs"></div>
                            <div class="form-group">
                                <button type="button" class="btn btn-sm btn-primary btn-block"
                                        onclick="login()">登录
                                </button>
                            </div>
                            <div class="form-group">
                                <div id="login-errorMessage" class="alert alert-danger alert-dismissible hidden"
                                     role="alert">
                                    <button type="button" class="close" data-dismiss="alert">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">Close</span>
                                    </button>
                                    <span class="glyphicon glyphicon-remove-circle"></span>
                                </div>
                            </div>
                        </form>
                        <%--登录 end--%>
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
                                <button id="reset-submit" type="button" class="btn btn-sm btn-primary btn-block"
                                        onclick="registerCheck()">提交
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
        <span class="col-xs-0 col-sm-4"></span>
    </div>
</div>
<script src="../../js/common.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>
