<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/1
  Time: 下午2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>${requestScope.house.name}</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/select2.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">
<link rel="stylesheet" href="../../css/icheckflat/blue.css">
<%--head start--%>
<c:import url="/WEB-INF/common/common_head.jsp"/>
<%--head end--%>
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
        <%--VR图--%>
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
                <table class="table table-responsive table-condensed">
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

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/select2.min.js"></script>
<script type="text/javascript" src="../../js/template.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/goods.js"></script>
<script type="text/javascript" src="../../js/tour.js"></script>
<script id="rentMode" type="text/html">
    {{each data as rentMode index}}
    {{if index==0}}
    <li class="active">
        <a href="#content-{{rentMode.id}}" data-toggle="tab">{{rentMode.name}}</a>
    </li>
    {{else}}
    <li>
        <a href="#content-{{rentMode.id}}" data-toggle="tab">{{rentMode.name}}</a>
    </li>
    {{/if}}
    {{/each}}
</script>
<script id="rentModeContent" type="text/html">
    {{each data as rentMode index}}

    {{if rentMode.id==1}}
    {{if index == 0}}
    <div id="content-{{rentMode.id}}" class="tab-pane active">
    </div>
    {{else}}
    <div id="content-{{rentMode.id}}" class="tab-pane">
    </div>
    {{/if}}
    {{/if}}

    {{if rentMode.id==2}}
    {{if index == 0}}
    <div id="content-{{rentMode.id}}" class="tab-pane active">
    </div>
    {{else}}
    <div id="content-{{rentMode.id}}" class="tab-pane">
    </div>
    {{/if}}
    {{/if}}

    {{if rentMode.id==3}}
    {{if index==0}}
    <div id="content-{{rentMode.id}}" class="tab-pane active">
    </div>
    {{else}}
    <div id="content-{{rentMode.id}}" class="tab-pane">
    </div>
    {{/if}}
    {{/if}}

    {{/each}}
</script>
<script id="share" type="text/html">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">房间信息
                <label type="button" class="btn btn-danger btn-xs pull-right visible-xs" style="margin-top: -2px">
                    <span class="glyphicon glyphicon-shopping-cart"></span>
                    下单
                </label>
            </h3>
        </div>
        <div class="panel-body">
            <div class="col-xs-5 col-sm-4 col-md-3 col-lg-2">
                <label for="roomNo" style="width: 100%">请选择房号：
                    <select id="roomNo" class="select2 form-control" style="width: 100%"></select>
                </label>
            </div>
            <div class="col-xs-7 col-sm-8 col-md-9 col-lg-10">
                <h2 class="text-danger text-right">
                    <span class="room-expectPrice">{{room.expectPrice}}</span>
                    <small>元/月</small>
                </h2>
            </div>
        </div>
        <table class="table table-condensed table-responsive">
            <tbody>
            <tr class="bg-primary visible-xs visible-sm">
                <td>面积：
                </td>
                <td>
                    <span class="room-areaNum">{{room.areaNumber}}</span>
                    ㎡
                </td>
                <td>状态：
                </td>
                <td class="room-statusName">
                    {{room.houseStatus.statusName}}
                </td>
            </tr>
            <tr class="visible-xs visible-sm">
                <td>是否带厕所：
                </td>
                <td class="room-haveWashroom">
                    {{if room.haveWashroom}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td>是否带厨房：
                </td>
                <td class="room-haveKitchen">
                    {{if room.haveKitcken}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
            </tr>
            <tr class="bg-primary visible-xs visible-sm">
                <td>是否带书桌：
                </td>
                <td class="room-haveDesk">
                    {{if room.haveDesk}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td>是否带衣厨：
                </td>
                <td class="room-haveWardrobe">
                    {{if room.haveWardrobe}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
            </tr>
            <tr class="visible-xs visible-sm">
                <td>是否带空调：
                </td>
                <td class="room-haveAirConditioning">
                    {{if room.haveAirConditioning}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td>是否带热水器：
                </td>
                <td class="room-haveWaterHeater">
                    {{if room.haveWaterHeater}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
            </tr>
            <tr class="bg-primary visible-xs visible-sm">
                <td>是否带宽带：
                </td>
                <td class="room-haveWLAN">
                    {{if room.haveWLAN}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td>
                </td>
                <td>
                </td>
            </tr>
            <tr class="bg-primary hidden-xs hidden-sm">
                <td>面积：</td>
                <td>状态：</td>
                <td>是否带书桌：</td>
                <td>是否带衣厨：</td>
                <td>是否带厕所：</td>
                <td>是否带厨房：</td>
                <td>是否带空调：</td>
                <td>是否带热水器：</td>
                <td>是否带宽带：</td>
            </tr>
            <tr class="hidden-xs hidden-sm">
                <td>
                    <span class="room-areaNum">{{room.areaNumber}}</span>
                    ㎡
                </td>
                <td class="room-statusName">
                    {{room.houseStatus.statusName}}
                </td>
                <td class="room-haveDesk">
                    {{if room.haveDesk}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td class="room-haveWardrobe">
                    {{if room.haveWardrobe}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td class="room-haveWashroom">
                    {{if room.haveWashroom}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td class="room-haveKitchen">
                    {{if room.haveKitcken}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td class="room-haveAirConditioning">
                    {{if room.haveAirConditioning}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td class="room-haveWaterHeater">
                    {{if room.haveWaterHeater}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
                <td class="room-haveWLAN">
                    {{if room.haveWLAN}}
                    是
                    {{else}}
                    否
                    {{/if}}
                </td>
            </tr>
            </tbody>
        </table>

    </div>

    </div>
</script>
<script>
    embedpano({
        swf: "../../vtour/tour.swf",
        xml: "../../vtour/${requestScope.house.id}/tour.xml",
        target: "vr",
        html5: "auto",
        mobilescale: 1.0,
        passQueryParameters: true
    });
</script>
</body>
</html>
