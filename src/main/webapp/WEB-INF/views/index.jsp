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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/select2.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">
<body>

<%--head start--%>
<c:import url="/WEB-INF/common/common_head.jsp"/>
<%--head end--%>

<div class="container-fluid">
    <div class="col-sm-8">
        <%--查询 start--%>
        <div id="search-nav">
            <nav class="navbar navbar-default" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                data-target="#search-navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">搜房</a>
                    </div>
                    <div id="search-navbar" class="collapse navbar-collapse">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">请选择地区 <span
                                        class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <form class="navbar-form form-group">
                                        <select id="province" class="select2 form-control" style="width: 100%"></select>
                                        <div class="white-divider-md"></div>
                                        <select id="city" class="select2 form-control" style="width: 100%"></select>
                                        <div class="white-divider-md"></div>
                                        <select id="area" class="select2 form-control" style="width: 100%"></select>
                                        <div class="divider"></div>
                                        <button type="submit" class="btn btn-primary btn-block">确定</button>
                                    </form>
                                </ul>
                            </li>
                        </ul>
                        <p class="navbar-text"></p>
                        <form class="navbar-form navbar-right">
                            <div class="input-group">
                                <input id="search" name="" type="text" class="form-control" placeholder="请输入地址...">
                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-primary">搜索</button>
                                    <button type="button" class="btn btn-primary dropdown-toggle"
                                            data-toggle="dropdown">
                                        <span class="caret"></span>
                                        <span class="sr-only">Toggle Dropdown</span>
                                    </button>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a></li>
                                        <li class="divider"></li>
                                        <li>
                                            <form class="navbar-form form-group">
                                                <select id="price" class="select2 form-control" style="width: 100%"></select>
                                                <div class="white-divider-md"></div>
                                                <select id="roomNum" class="select2 form-control" style="width: 100%"></select>
                                                <div class="white-divider-md"></div>
                                                <select id="" class="select2 form-control" style="width: 100%"></select>
                                                <div class="divider"></div>
                                                <button type="submit" class="btn btn-primary btn-block">搜索</button>
                                            </form>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </nav>
        </div>
        <%--查询 end--%>
        <%--房屋分布地图or列表  start--%>
        <div id="house-tab">
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
            <div class="white-divider-md"></div>
        </div>
        <%--房屋分布地图or列表  end--%>
    </div>
    <div id="house-details" class="col-xs-12 col-sm-4">
        <div class="panel panel-default">
            <div class="panel-heading">房屋简介</div>
            <div class="panel-body">
                Panel content
            </div>
            <div class="panel-footer">房屋简介</div>
        </div>
    </div>
</div>


<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=002273d8cd1c3363f0d26dae6629472b"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/select2.min.js"></script>
<script type="text/javascript" src="../../js/index.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
