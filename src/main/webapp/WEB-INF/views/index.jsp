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
    <div class="row">
        <div id="carousel-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img src="../../images/index/1.jpg" style="width: 100%" alt="...">
                    <div class="carousel-caption">
                        First
                    </div>
                </div>
                <div class="item">
                    <img src="../../images/index/2.jpg" style="width: 100%" alt="...">
                    <div class="carousel-caption">
                        Second
                    </div>
                </div>
                <div class="item">
                    <img src="../../images/index/3.jpg" style="width: 100%" alt="...">
                    <div class="carousel-caption">
                        Second
                    </div>
                </div>
            </div>
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="white-divider-md"></div>
    <div class="row">
        <div class="col-sm-1"></div>
        <!--搜索区-->
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
                            <button id="searchButton" type="button" class="btn btn-primary" data-toggle="tab"
                                    href="#list">
                                按需搜索
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--好房列表-->
        <div id="house-list" class="col-xs-12 col-sm-7 col-md-8">
            <div id="house-tab">
                <div class="tab-content">
                    <%--<!--好房推荐-->--%>
                    <div id="recommend" class="tab-pane active">
                        <div class="panel panel-default">
                            <!-- Default panel contents -->
                            <div class="panel-heading">
                                好房推荐
                            </div>
                            <c:forEach items="${houseRecommend.houseList}" var="house">
                                <ul class="list-group">
                                    <a href="/user/login" class="list-group-item container-fluid">
                                        <div class="col-md-2 hidden-xs hidden-sm">
                                            <img src="${house.thumbnailPath}" alt=""
                                                 class="img-responsive img-thumbnail"/>
                                        </div>
                                        <div class="col-md-10 col-xs-12 ">
                                            <h4 class="list-group-item-heading">${house.name}
                                                <label class="label label-danger pull-right">${house.expectRent}元/月</label>
                                            </h4>
                                            <div class="white-divider-md"></div>
                                            <div class="list-group-item-text">
                                                <span class="glyphicon glyphicon-home"></span>
                                                <span>&nbsp;${house.community.name}</span>
                                                <label class="label label-success pull-right">${house.houseStatus.statusName}</label>
                                            </div>
                                            <div class="white-divider-md"></div>
                                            <div class="list-group-item-text">
                                                <label class="label label-danger">${house.decorationType.name}</label>
                                                <c:if test="${house.haveKitcken}">
                                                    <label class="label label-primary">独立厨房</label>
                                                </c:if>
                                                <c:if test="${house.haveBalcony}">
                                                    <label class="label label-warning">独立阳台</label>
                                                </c:if>
                                                <label class="label label-info"></label>
                                            </div>
                                            <div class="white-divider-lg"></div>
                                            <div class="list-group-item-text">
                                                <span>${house.areaNumber}㎡</span>/
                                                <span>${house.houseLayout.name}</span>/
                                                <span>${house.decorationType.name}</span>/
                                                <span>${house.floor}层</span>
                                                <div class="pull-right">
                                                    <c:forEach items="${house.rentModeList}" var="rentMode">
                                                        <span class="label label-default" style="margin-left: 10px">
                                                                ${rentMode.name}
                                                        </span>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                        </div>
                                    </a>
                                </ul>
                            </c:forEach>
                        </div>
                    </div>
                    <!--房屋搜索-->
                    <div id="list" class="tab-pane">
                        <%--列表--%>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-1"></div>
    </div>
</div>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/select2.min.js"></script>
<script type="text/javascript" src="../../js/index.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
