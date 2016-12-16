<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/10
  Time: 下午3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showings · 房库 - 信息修改</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/scojs.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco.message.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/home/account">我的账户</a></li>
            <li class="active">账户安全</li>
        </ol>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">密码修改</h3>
            </div>
            <div class="panel-body">
                <div class="row">
                    <form role="form" id="security">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label">当前密码</label>
                                <input type="password" class="form-control"
                                       placeholder="6-10位字母或数字的组合" name="old">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label">新密码</label>
                                <input type="password" class="form-control"
                                       placeholder="6-10位字母或数字的组合" name="new">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label">再次确认</label>
                                <input type="password" class="form-control"
                                       placeholder="6-10位字母或数字的组合" name="check">
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label">验证码</label>
                                <div class="input-group">
                                    <input type="text" id="captcha" class="form-control" name="captcha"
                                           placeholder="6位验证码">
                                    <div class="input-group-btn">
                                        <button class="btn btn-default" type="button" name="send">发送验证码</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="panel-footer">
                <div class="row">
                    <div class="col-sm-12">
                        <button name="passwordSubmit" type="button" class="btn btn-xs btn-primary pull-right">提交修改</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.valid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/account_security.js"></script>
</body>
</html>
