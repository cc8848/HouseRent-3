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
<link rel="stylesheet" href="../../css/bootstrap-select.min.css">
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
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">查询条件</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <form class="navbar-form" role="search">
                        <div class="form-group">
                            <div class="btn-group bootstrap-select">
                                <button type="button" class="btn dropdown-toggle btn-default" data-toggle="dropdown"
                                        data-id="first-disabled" title="Apple" aria-expanded="false"><span
                                        class="filter-option pull-left">不限</span>&nbsp;<span class="caret"></span>
                                </button>
                                <div class="dropdown-menu open"
                                     style="max-height: 107px; overflow: hidden; min-height: 134px;">
                                    <div class="bs-searchbox">
                                        <input type="text" class="form-control" autocomplete="off">
                                    </div>
                                    <ul class="dropdown-menu inner" role="menu"
                                        style="max-height: 53px; overflow-y: auto; min-height: 80px;">
                                        <li class="dropdown-header " data-optgroup="1">
                                            <span class="text">Fruit</span>
                                        </li>
                                        <li data-original-index="1" data-optgroup="1" class="selected active">
                                            <a tabindex="0" class="opt" data-tokens="null">
                                                <span class="text">Apple</span>
                                                <span class="glyphicon glyphicon-ok check-mark"></span>
                                            </a>
                                        </li>
                                        <li data-original-index="2" data-optgroup="1">
                                            <a tabindex="0" class="opt undefined" data-tokens="null">
                                                <span class="text">Orange</span>
                                                <span class="glyphicon glyphicon-ok check-mark"></span>
                                            </a>
                                        </li>
                                        <li class="divider" data-optgroup="2div"></li>
                                        <li class="dropdown-header " data-optgroup="2">
                                            <span class="text">Vegetable</span>
                                        </li>
                                        <li data-original-index="3" data-optgroup="2">
                                            <a tabindex="0" class="opt" data-tokens="null">
                                                <span class="text">Corn</span>
                                                <span class="glyphicon glyphicon-ok check-mark"></span>
                                            </a>
                                        </li>
                                        <li data-original-index="4" data-optgroup="2">
                                            <a tabindex="0" class="opt undefined" data-tokens="null">
                                                <span class="text">Carrot</span>
                                                <span class="glyphicon glyphicon-ok check-mark"></span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <input type="text" class="form-control" placeholder="Search">
                        </div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </form>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
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
