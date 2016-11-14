<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wuxinzhe
  联系QQ: 124734668
  创建日期: 16/10/1
  创建时间: 下午7:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/select2.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="jumbotron index-bg-1" style="margin: 0">
    <div class="container well-lg">
        <h1 class="text-right"><strong>重新定义看房方式</strong></h1>
        <div class="white-divider-md"></div>
        <p class="text-right"><strong>Redefine the Way of Showings</strong></p>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <p class="text-right">
            <a class="btn btn-success btn-lg" href="#" role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;免费注册</a>
            <a class="btn btn-primary btn-lg" href="/house/detail?houseID=1" role="button"><span class="glyphicon glyphicon-camera"></span>&nbsp;在线体验</a>
        </p>
    </div>
</div>
<div class="jumbotron" style="margin: 0">
    <div class="container text-center">
        <div class="col-lg-2"></div>
        <div class="col-lg-2 ">
            <i class="index-iconfont-1">&#xe645;</i>
            <p>VR看房</p>
        </div>
        <div class="col-lg-2">
            <i class="index-iconfont-1">&#xe63f;</i>
            <p>轻松分享</p>
        </div>
        <div class="col-lg-2">
            <i class="index-iconfont-1">&#xe694;</i>
            <p>智能比房</p>
        </div>
        <div class="col-lg-2">
            <i class="index-iconfont-1">&#xe643;</i>
            <p>海量房源</p>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div class="jumbotron index-bg-2" style="margin: 0">
    <div class="container">

    </div>
</div>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
