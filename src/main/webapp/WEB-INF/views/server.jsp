<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/10
  Time: 下午12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Showings · 房库 - 开通服务</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
</head>
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="white-divider-md"></div>
<div class="jumbotron index-bg-white">
    <div class="container">
        <div class="col-lg-6">
            <div class="page-header">
                <h2>开发商项目管理</h2>
            </div>
            <dl class="dl-horizontal">
                <dt>项目配置</dt>
                <dd>开发商基础信息、社区项目基础信息、楼栋管理、户型管理、房屋管理</dd>
                <dt>销售管理</dt>
                <dd>分销商看房报备、销控表</dd>
                <dt>项目展示</dt>
                <dd>VR全景、地图信息、基础信息展示</dd>
            </dl>
        </div>
        <div class="col-lg-6">

        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</body>
</html>
