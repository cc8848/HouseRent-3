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
                <!--地区-->
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
                <!--租金-->
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
                <!--厅室-->
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
                <!--租赁模式-->
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
                <div class="btn-group btn-group-justified">
                    <div class="btn-group">
                        <button id="recommendHouse" type="button" class="btn btn-primary" data-toggle="tab"
                                href="#recommend">好房推荐
                        </button>
                    </div>
                    <div class="btn-group">
                        <button id="searchButton" type="button" class="btn btn-primary" data-toggle="tab" href="#list">
                            按需搜索
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--好房列表-->
    <div id="house-list" class="col-xs-12 col-sm-9 col-md-10">
        <div id="house-tab">
            <div class="tab-content">
                <!--好房推荐-->
                <div id="recommend" class="tab-pane active">
                    <div class="panel panel-default">
                        <!-- Default panel contents -->
                        <div class="panel-heading">
                            房屋清单
                        </div>
                        <div class="panel-body">
                            <nav>
                                <ul class="pagination" style="margin:0">
                                    <li><a href="#">&laquo;</a></li>
                                    <li><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><span>...</span></li>
                                    <li><a href="#">7</a></li>
                                    <li><a href="#">8</a></li>
                                    <li><a href="#">9</a></li>
                                    <li><a href="#">&raquo;</a></li>
                                </ul>
                            </nav>
                        </div>
                        <ul class="list-group">
                            <div class="list-group-item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div id="thumbnail" class="col-sm-3 hidden-xs">
                                            <img src="../../images/test.jpg" alt=""
                                                 class="img-responsive img-thumbnail"/>
                                        </div>
                                        <div id="house" class="col-sm-9 col-xs-12">
                                            <h4 class="list-group-item-heading">绿苑海景小区</h4>
                                            <div class="white-divider-md"></div>
                                            <div class="list-group-item-text">
                                                <span class="glyphicon glyphicon-home"></span><span>&nbsp;绿苑海景</span>
                                            </div>
                                            <div class="white-divider-md"></div>
                                            <div class="list-group-item-text">
                                                <label class="label label-danger">精装修</label>
                                                <label class="label label-primary">押一付三</label>
                                                <label class="label label-success">家电齐全</label>
                                            </div>
                                            <div class="white-divider-md"></div>
                                            <div class="list-group-item-text">
                                                <button type="button" class="btn btn-primary btn-xs">
                                                    <span class="glyphicon glyphicon-map-marker"></span>&nbsp;查看地图
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </ul>
                    </div>
                </div>
                <!--房屋搜索-->
                <div id="list" class="tab-pane">
                    <%--列表--%>
                </div>
            </div>
        </div>
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
