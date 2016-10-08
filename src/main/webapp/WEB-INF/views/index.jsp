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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <sec:csrfMetaTags/>
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">

<body>

<%--head start--%>
<c:import url="/WEB-INF/common/common_head.jsp"/>
<%--head end--%>
<div class="container-fluid">
    <div id="search" class="col-xs-12">
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#search-nav">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">查询条件</a>
                </div>
                <div class="collapse navbar-collapse" id="search-nav">
                    <%--地区 start--%>
                    <ul class="nav navbar-nav">
                        <li>
                            <div class="btn-group navbar-btn">
                                <button type="button" class="btn btn-default">请选择地区</button>
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                    <span class="caret"></span>
                                    <span class="sr-only">Toggle Dropdown</span>
                                </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">思明区</a></li>
                                    <li><a href="#">海沧区</a></li>
                                    <li><a href="#">湖里区</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">不限</a></li>
                                </ul>
                            </div>
                        </li>
                    </ul>
                    <%--地区 end--%>
                    <form class="navbar-form navbar-right" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div>
            </div>
        </nav>
    </div>
    <div class="col-xs-12 col-sm-8">
        <ul class="nav nav-tabs">
            <li id="map-tab" class="active"><a href="#map" data-toggle="tab">地图</a></li>
            <li id="list-tab"><a href="#list" data-toggle="tab">列表</a></li>
        </ul>
        <div class="white-divider-xs"></div>
        <div class="tab-content">
            <div id="map" class="tab-pane active">
                <div class="embed-responsive embed-responsive-16by9">
                    <div id="container" class="embed-responsive-item"></div>
                </div>
            </div>
            <div id="list" class="tab-pane"></div>
        </div>
        <div class="white-divider-xs"></div>
    </div>
    <div id="house-details" class="col-xs-12 col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">房屋简介</div>
            <div class="panel-body">
                Panel content
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=002273d8cd1c3363f0d26dae6629472b"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/index.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
