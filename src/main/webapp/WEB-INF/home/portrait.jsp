<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/13
  Time: 下午2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showings · 房库 - 信息修改</title>
    <sec:csrfMetaTags/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/file-input.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/scojs.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jcrop/jquery.Jcrop.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/file-input.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="row">
    <div class="col-xs-12">
        <form role="form" enctype="multipart/form-data" action="${pageContext.request.contextPath}/file/portrait"
              method="post">
            <img alt="" src="" id="cut-img" class="img-responsive"/>
            <div class="white-divider-md"></div>
            <input type="file" name="imgFile" id="portrait" onchange="readURL(this);"/>
            <input type="hidden" id="x" name="x"/>
            <input type="hidden" id="y" name="y"/>
            <input type="hidden" id="w" name="w"/>
            <input type="hidden" id="h" name="h"/>
        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jcrop/jquery.Jcrop.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/file-input.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/portrait.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</body>
</html>

