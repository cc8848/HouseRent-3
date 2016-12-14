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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/home/account">我的账户</a></li>
            <li class="active">信息修改</li>
        </ol>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">账户信息修改
                    <button type="button" class="btn btn-xs btn-primary pull-right">提交修改</button>
                </h3>
            </div>
            <div class="panel-body">
                <form role="form">
                    <div class="form-group">
                        <div class="col-sm-6">
                            <label class="control-label">真实姓名</label>
                            <input type="text" class="form-control"
                                   placeholder="此姓名将用于前台展示，请勿填写简称如：小王" name="name">
                        </div>
                        <div class="col-sm-6">
                            <label class="control-label">证件号码</label>
                            <input type="text" class="form-control"
                                   placeholder="请输入18位证件号码" name="license">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/_account_update.js"></script>
</body>
</html>
