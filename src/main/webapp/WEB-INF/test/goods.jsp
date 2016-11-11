<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/11
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <%--标题部分--%>
    <div class="row">
        <div class="col-xs-12 page-header">
            <h3>${requestScope.house.name}
                <small>No.<span id="houseID">${requestScope.house.id}</span></small>
                <div class="btn-toolbar pull-right" role="toolbar">
                    <div class="btn-group">
                        <button type="button" class="btn btn-warning hidden-xs">
                            <span class="glyphicon glyphicon-star"></span>
                            关注
                        </button>
                    </div>
                    <div class="btn-group visible-lg">
                        <button type="button" class="btn btn-warning">
                            <span class="glyphicon glyphicon-qrcode "></span>
                        </button>
                        <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                            <li><a href="#">扫码访问手机版</a></li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <img src="../../images/house/thumbnail/gethouseqr.png"
                                         class="img-responsive img-thumbnail">
                                </a>
                            </li>
                            <li class="white-divider-sm"></li>
                        </ul>
                    </div>
                </div>
            </h3>
        </div>
    </div>
    <div class="row">
        VR图
        <div class="col-md-7 col-lg-8">
            <div class="embed-responsive embed-responsive-16by9">
                <div id="vr" class="embed-responsive-item">
                </div>
            </div>
        </div>
        <div class="visible-xs visible-sm white-divider-md"></div>
        <%--房屋说明--%>
        <div class="col-md-5 col-lg-4">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">房屋信息
                        <label class="btn btn-warning btn-xs pull-right visible-xs" style="margin-top: -2px">
                            <span class="glyphicon glyphicon-star"></span>
                            关注
                        </label>
                    </h3>
                </div>
                <table class="table table-responsive">
                    <tbody>
                    <tr>
                        <td>社区：</td>
                        <td>
                            <a href="${requestScope.house.community.id}" target="_blank">
                                ${requestScope.house.community.name}
                            </a>
                        </td>
                        <td>楼层：</td>
                        <td>${requestScope.house.floor}楼</td>
                    </tr>
                    <tr class="bg-primary">
                        <td>房屋状态：</td>
                        <td>${requestScope.house.houseStatus.statusName}</td>
                        <td>付租方式：</td>
                        <td>${requestScope.house.expectPayment.paymentName}</td>
                    </tr>
                    <tr>
                        <td>布局：</td>
                        <td>${requestScope.house.houseLayout.name}</td>
                        <td>装修：</td>
                        <td>${requestScope.house.decorationType.name}</td>
                    </tr>
                    <tr class="bg-primary">
                        <td>是否带厨房：</td>
                        <td>
                            <c:choose>
                                <c:when test="${requestScope.house.haveKitcken}">
                                    <c:out value="是"/>
                                </c:when>
                                <c:when test="${!requestScope.house.haveKitcken}">
                                    <c:out value="否"/>
                                </c:when>
                            </c:choose>
                        </td>
                        <td>是否带阳台：</td>
                        <td>
                            <c:choose>
                                <c:when test="${requestScope.house.haveBalcony}">
                                    <c:out value="是"/>
                                </c:when>
                                <c:when test="${!requestScope.house.haveBalcony}">
                                    <c:out value="否"/>
                                </c:when>
                            </c:choose>
                        </td>
                    </tr>
                    <tr>
                        <td>房屋面积：</td>
                        <td>${requestScope.house.areaNumber}㎡</td>
                        <td></td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="row hidden-xs hidden-sm">
                <div class="col-xs-6">
                    <div class="input-group input-group-sm">
<span class="input-group-btn">
<button class="btn btn-default" type="button">+</button>
</span>
                        <input id="rentDate" type="number" class="form-control text-center" placeholder="租期(月)">
                        <span class="input-group-btn">
<button class="btn btn-default" type="button">-</button>
</span>
                    </div>
                </div>
                <div class="col-xs-6">
                    <button class="btn btn-danger pull-right btn-sm btn-group-justified ">
                        <span class="glyphicon glyphicon-shopping-cart"></span>
                        下单
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="white-divider-md hidden-xs hidden-sm"></div>
    <div class="row">
        <div class="col-xs-12">
            <%--出租模式--%>
            <ul id="rentMode-tab" class="nav nav-tabs">
            </ul>
            <div class="white-divider-md"></div>
            <div id="rentMode-content" class="tab-content">
            </div>
        </div>
    </div>
    <div class="row visible-sm">
        <div class="col-xs-6">
            <div class="input-group">
<span class="input-group-btn">
<button class="btn btn-default" type="button">+</button>
</span>
                <input id="rentDate" type="number" class="form-control text-center" placeholder="租期(月)">
                <span class="input-group-btn">
<button class="btn btn-default" type="button">-</button>
</span>
            </div>
        </div>
        <div class="col-xs-6">
            <button class="btn btn-danger pull-right btn-group-justified ">
                <span class="glyphicon glyphicon-shopping-cart"></span>
                下单
            </button>
        </div>
    </div>
</div>

</body>
</html>
