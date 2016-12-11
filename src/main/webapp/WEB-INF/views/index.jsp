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
    <title>Showings · VR房库-首页</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar-head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="jumbotron index-bg-banner">
    <div class="container well-lg">
        <h1 class="text-right font-shadow-black"><strong>重新定义看房方式</strong></h1>
        <div class="white-divider-md"></div>
        <p class="text-right"><strong>Redefine the Way of Showings</strong></p>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <p class="text-right">
            <a class="btn btn-success btn-lg" href="#" role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;免费注册</a>
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/house/detail?houseID=1"
               role="button"><span
                    class="glyphicon glyphicon-camera"></span>&nbsp;在线体验</a>
        </p>
    </div>
</div>
<div class="jumbotron index-bg-gray" style="padding: 20px 0">
    <div class="container text-center">
        <div class="col-lg-2"></div>
        <div class="col-lg-2 ">
            <i class="iconFont-lg">&#xe645;</i>
            <p>VR看房</p>
        </div>
        <div class="col-lg-2">
            <i class="iconFont-lg">&#xe63f;</i>
            <p>轻松分发</p>
        </div>
        <div class="col-lg-2">
            <i class="iconFont-lg">&#xe694;</i>
            <p>附近周边</p>
        </div>
        <div class="col-lg-2">
            <i class="iconFont-lg">&#xe643;</i>
            <p>海量房源</p>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div class="jumbotron index-bg-white">
    <div class="container">
        <div class="col-lg-6">
            <div class="page-header">
                <h2>VR全景</h2>
            </div>
            <dl class="dl-horizontal">
                <dt>项目展示：</dt>
                <dd>VR全景展示、社区信息展示、房屋信息展示</dd>
                <dt>周边展示：</dt>
                <dd>地图展示</dd>
            </dl>
        </div>
        <div class="col-lg-6">

        </div>
    </div>
</div>
<div class="jumbotron index-bg-gray">
    <div class="col-lg-6">

    </div>
    <div class="container">
        <div class="col-lg-6">
            <div class="page-header-black">
                <h2>项目管理</h2>
            </div>
            <dl class="dl-horizontal">
                <dt>项目配置：</dt>
                <dd>公司基础信息、项目基础信息</dd>
                <dt>房屋管理：</dt>
                <dd>楼栋管理、户型管理、房屋管理</dd>
            </dl>
        </div>

    </div>
</div>
<div class="jumbotron index-bg-white">
    <div class="container">

        <div class="col-lg-6">
            <div class="page-header">
                <h2>销售管理</h2>
            </div>
            <dl class="dl-horizontal">
                <dt>销售管理：</dt>
                <dd>分销商看房报备、销控表、促销活动</dd>
                <dt>客户管理：</dt>
                <dd>电销客户管理、上门客户管理、公共客户池管理</dd>
            </dl>
        </div>
        <div class="col-lg-6">

        </div>
    </div>
</div>

<div class="jumbotron index-bg-gray">
    <div class="container">
        <div class="col-lg-12">
            <h3 class="text-center">
                『 每一次创新都倾注了无懈的努力，一次次推倒重来只为拿出最好的产品 』
            </h3>
            <p class="text-center">
                —
            </p>
            <p class="text-center">
                Showings
            </p>
        </div>
    </div>
</div>
<%--页脚--%>
<c:import url="/WEB-INF/common/showings_common_foot.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</body>
</html>
