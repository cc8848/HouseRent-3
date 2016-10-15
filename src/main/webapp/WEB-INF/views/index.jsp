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
<c:import url="/WEB-INF/common/common_head.jsp"/>
<%--head end--%>

<div class="container-fluid">
    <div id="search-term" class="col-xs-12 col-sm-3 col-md-2">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">搜索条件</h3>
            </div>
            <div class="panel-body">
                <!--地区 start-->
                <div id="address">
                    <div class="input-group input-group-sm">
                        <div class="input-group-btn">
                            <button type="button" class="btn btn-default" data-toggle="collapse"
                                    href="#collapseOne">
                                <span class="caret"></span>
                            </button>
                        </div>
                        <input id="area-input" type="text" class="form-control" placeholder="请选择地址" readonly>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse">
                        <form class="navbar-form form-group">
                            <select id="province" class="select2 form-control" style="width: 100%"></select>
                            <div class="white-divider-xs"></div>
                            <select id="city" class="select2 form-control" style="width: 100%"></select>
                            <div class="white-divider-xs"></div>
                            <select id="area" class="select2 form-control" style="width: 100%"></select>
                            <div class="white-divider-xs"></div>
                            <button id="address-button" type="button" class="btn btn-primary btn-block"
                                    data-toggle="collapse" href="#collapseOne">确定
                            </button>
                        </form>
                    </div>
                </div><!--地区 end-->
                <div class="white-divider-sm"></div>
                <!--租金 start-->
                <div id="price" class="input-group input-group-sm">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span
                                class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a id="price-1" href="#">0-500</a></li>
                            <li><a id="price-2" href="#">500-1000</a></li>
                            <li><a id="price-3" href="#">1000-2000</a></li>
                            <li><a id="price-4" href="#">2000-4000</a></li>
                            <li><a id="price-5" href="#">4000 以上</a></li>
                            <li class="divider"></li>
                            <li><a id="price-6" href="#">不限</a></li>
                        </ul>
                    </div>
                    <input id="price-input" type="text" class="form-control" placeholder="请选择租金" readonly>
                    <span class="input-group-addon">¥</span>
                </div><!--租金 end-->
                <div class="white-divider-sm"></div>
                <!--厅室 start-->
                <div id="room" class="input-group input-group-sm">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span
                                class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a id="room-1" href="#">一室</a></li>
                            <li><a id="room-2" href="#">二室</a></li>
                            <li><a id="room-3" href="#">三室</a></li>
                            <li><a id="room-4" href="#">四室</a></li>
                            <li><a id="room-5" href="#">四室以上</a></li>
                            <li class="divider"></li>
                            <li><a id="room-6" href="#">不限</a></li>
                        </ul>
                    </div>
                    <input id="room-input" type="text" class="form-control" placeholder="请选择厅室" readonly>
                </div><!--厅室 end-->
                <div class="white-divider-sm"></div>
                <!--厅室 start-->
                <div id="rentMode" class="input-group input-group-sm">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span
                                class="caret"></span></button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a id="rentMode-1" href="#">整套出租</a></li>
                            <li><a id="rentMode-2" href="#">单间出租</a></li>
                            <li><a id="rentMode-3" href="#">床位出租</a></li>
                            <li class="divider"></li>
                            <li><a id="rentMode-4" href="#">不限</a></li>
                        </ul>
                    </div>
                    <input id="rentMode-input" type="text" class="form-control" placeholder="请选择方式" readonly>
                </div><!--厅室 end-->
                <div class="white-divider-sm"></div>
                <button id="searchButton" type="button" class="btn btn-primary btn-block"><span
                        class="glyphicon glyphicon-search"></span></button>
            </div>
        </div>
    </div>
    <div id="house-list" class="col-xs-12 col-sm-9 col-md-10">
        <%--房屋分布地图or列表  start--%>
        <div id="house-tab">
            <ul class="nav nav-tabs">
                <li id="recommend-tab" class="active"><a href="#recommend" data-toggle="tab">好房推荐</a></li>
                <li id="list-tab"><a href="#list" data-toggle="tab">房屋清单</a></li>
                <li id="map-tab"><a href="#map" data-toggle="tab">房屋分布图</a></li>
            </ul>
            <div class="white-divider-xs"></div>
            <div class="tab-content">
                <div id="recommend" class="tab-pane active">
                    <div class="list-group">
                        <a href="#" class="list-group-item">
                            <div class="container-fluid">
                                <div id="thumbnail" class="col-sm-2 hidden-xs">
                                    <img src="../../images/test.jpg" alt="" class="img-responsive img-thumbnail"/>
                                </div>
                                <div id="house" class="col-sm-10">
                                    <h4 class="list-group-item-heading">绿苑海景小区</h4>
                                    <div class="white-divider-md"></div>
                                    <div class="list-group-item-text">
                                        <span class="glyphicon glyphicon-home"></span><span>绿苑海景</span>
                                        <button type="button" class="btn btn-primary btn-xs">
                                            <span class="glyphicon glyphicon-map-marker"></span>查看地图
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子2</p>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子3</p>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子4</p>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子4</p>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子4</p>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子4</p>
                        </a>
                        <a href="#" class="list-group-item ">
                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                            <p class="list-group-item-text">好房子4</p>
                        </a>
                    </div>
                </div>
                <div id="list" class="tab-pane">
                    <%--列表--%>
                </div>
                <div id="map" class="tab-pane">
                    <div class="embed-responsive embed-responsive-16by9">
                        <div id="container" class="embed-responsive-item"></div>
                    </div>
                </div>
            </div>
        </div>
        <%--房屋分布地图or列表  end--%>
    </div>
</div>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript"
        src="http://webapi.amap.com/maps?v=1.3&key=002273d8cd1c3363f0d26dae6629472b"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/select2.min.js"></script>
<script type="text/javascript" src="../../js/index.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
