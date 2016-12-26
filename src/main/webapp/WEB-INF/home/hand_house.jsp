<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/26
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showings · 房库 - 二手房信息</title>
    <sec:csrfMetaTags/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco/scojs.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco/sco.message.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fileinput/file-input.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/home/account">二手房管理</a></li>
            <li class="active">二手房发布</li>
        </ol>
    </div>
</div>




<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.valid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/file-input.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/zh.js"></script>
</body>
</html>
