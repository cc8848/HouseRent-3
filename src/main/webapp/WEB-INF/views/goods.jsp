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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icheckflat/blue.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/house_common_head.jsp"/>
<%--head end--%>
<div class="container">
    <div class="row">
        <div class="col-lg-12 ">
            <div class="page-header">
                <h3>${requestScope.house.name}
                    <small>No.<span id="houseID">${requestScope.house.id}</span></small>
                    <small class="pull-right"> ${house.city.cityName}&nbsp;${house.area.areaName}&nbsp;<a
                            href="#">${house.community.name}</a></small>
                </h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div id="left-side" class="col-lg-9">
            <div class="embed-responsive embed-responsive-16by9">
                <div id="vr" class="embed-responsive-item">
                </div>
            </div>
            <div class="white-divider-md"></div>
            <%--租赁模式 start--%>
            <ul id="tab" class="nav nav-tabs">
                <c:forEach items="${house.rentModeList}" var="rentMode" varStatus="status">
                    <c:if test="${rentMode.id==1 }">
                        <li id="whole-tab">
                            <a href="#content-whole" data-toggle="tab">
                                <c:out value="${rentMode.name}"/>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${rentMode.id==2 }">
                        <li id="share-tab">
                            <a href="#content-share" data-toggle="tab">
                                <c:out value="${rentMode.name}"/>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${rentMode.id==3 }">
                        <li id="sublet-tab">
                            <a href="#content-sublet" data-toggle="tab">
                                <c:out value="${rentMode.name}"/>
                            </a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
            <div class="white-divider-md"></div>
            <div id="tab-content" class="tab-content">
                <c:forEach items="${house.rentModeList}" var="rentMode" varStatus="status">
                    <c:if test="${rentMode.id==1 }">
                        <div id="content-whole" class="tab-pane">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        <span class="glyphicon glyphicon-home"></span>
                                        <span>房屋信息</span>
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <div class="col-lg-8">

                                    </div>
                                    <div class="col-lg-4">
                                        <h2 class="text-danger text-right">
                                                ${house.expectPrice}
                                            <small>元/月</small>
                                        </h2>
                                    </div>
                                </div>
                                <table class="table table-responsive">
                                    <tbody>
                                    <tr>
                                        <td>房屋面积：</td>
                                        <td>${requestScope.house.areaNumber}㎡</td>
                                        <td>楼层：</td>
                                        <td>${house.floor}层</td>
                                    </tr>
                                    <tr>
                                        <td>房屋状态：</td>
                                        <td>${requestScope.house.houseStatus.statusName}</td>
                                        <td>付租方式：</td>
                                        <td>${requestScope.house.expectPayment.paymentName}</td>
                                    </tr>
                                    <tr>
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
                                        <td>布局：</td>
                                        <td>${house.houseLayout.name}</td>
                                        <td>装修：</td>
                                        <td>${requestScope.house.decorationType.name}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${rentMode.id==2}">
                        <div id="content-share" class="tab-pane">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h3 class="panel-title">
                                        <span class="glyphicon glyphicon-home"></span>
                                        房间信息
                                    </h3>
                                </div>
                                <div class="panel-body">
                                    <div class="col-lg-3">
                                        <label for="roomNo" style="width: 100%">请选择房号：
                                            <select id="roomNo" class="select2 form-control" style="width: 100%">
                                                <c:forEach items="${house.roomsList}" var="room">
                                                    <option>${room.roomNo}</option>
                                                </c:forEach>
                                            </select>
                                        </label>
                                    </div>
                                    <div class="col-lg-9">
                                        <h2 class="text-danger text-right">
                                            <span class="room-expectPrice">${house.roomsList.get(0).expectPrice}</span>
                                            <small>元/月</small>
                                        </h2>
                                    </div>
                                </div>
                                <table class="table table-responsive">
                                    <tbody>
                                    <tr>
                                        <td>面积：
                                        </td>
                                        <td>
                                            <span class="room-areaNum">${house.roomsList.get(0).areaNumber}</span>
                                            ㎡
                                        </td>
                                        <td>状态：
                                        </td>
                                        <td class="room-statusName">
                                                ${house.roomsList.get(0).houseStatus.statusName}
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>是否带厕所：
                                        </td>
                                        <td class="room-haveWashroom">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveWashroom}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>是否带厨房：
                                        </td>
                                        <td class="room-haveKitchen">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveKitcken}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>是否带书桌：
                                        </td>
                                        <td class="room-haveDesk">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveDesk}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>是否带衣厨：
                                        </td>
                                        <td class="room-haveWardrobe">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveWardrobe}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>是否带空调：
                                        </td>
                                        <td class="room-haveAirConditioning">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveAirConditioning}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>是否带热水器：
                                        </td>
                                        <td class="room-haveWaterHeater">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveWaterHeater}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>是否带宽带：
                                        </td>
                                        <td class="room-haveWLAN">
                                            <c:choose>
                                                <c:when test="${house.roomsList.get(0).haveWLAN}">
                                                    是
                                                </c:when>
                                                <c:otherwise>
                                                    否
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </c:if>
                    <c:if test="${rentMode.id==3}">
                        <div id="content-sublet" class="tab-pane">
                        </div>
                    </c:if>
                </c:forEach>
            </div>
            <%--租赁模式 end--%>
        </div>
        <div id="right-side" class="col-lg-3">
            <div class="btn-group btn-group-justified">
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">
                        <span class="glyphicon glyphicon-star-empty"></span>
                        收藏
                    </button>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-primary">
                        <span class="glyphicon glyphicon-envelope"></span>
                        投诉
                    </button>
                </div>
            </div>

            <div class="white-divider-md"></div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">下单租房</h3>
                </div>
                <div class="panel-body">
                    <p>
                        提交租单后我站工作人员将与房源提供者联系，若房源已经准备好出租再将您的联系方式提供给对方，以保证您的隐私。
                    </p>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <select id="rentWay" class="select2" title="rentWay" style="width: 100%">
                            <option></option>
                            <c:forEach items="${house.rentModeList}" var="rentMode">
                                <c:choose>
                                    <c:when test="${rentMode.id==1}">
                                        <optgroup label="${rentMode.name}">
                                            <option>${rentMode.name}</option>
                                        </optgroup>
                                    </c:when>
                                    <c:when test="${rentMode.id==2}">
                                        <optgroup label="${rentMode.name}">
                                            <c:forEach items="${house.roomsList}" var="room">
                                                <option>房号：${room.roomNo}</option>
                                            </c:forEach>
                                        </optgroup>
                                    </c:when>
                                    <c:when test="${rentMode.id==3}">
                                        <optgroup label="${rentMode.name}">
                                            <option>${rentMode.name}</option>
                                        </optgroup>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </select>
                        <div class="white-divider-md"></div>
                        <div class="input-group input-group-sm">
                            <span class="input-group-btn">
                                <button id="tenancy-plus" class="btn btn-default" type="button">+</button>
                            </span>
                            <input id="tenancy-input" type="number" class="form-control text-center"
                                   placeholder="租期（月）">
                            <span class="input-group-btn">
                                <button id="tenancy-subtract" class="btn btn-default" type="button">-</button>
                            </span>
                        </div>
                        <div class="white-divider-md"></div>
                        <button type="button" class="btn btn-primary btn-group-justified btn-sm">
                            提交租单
                        </button>
                    </li>
                </ul>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        房源入驻
                    </h3>
                </div>
                <div class="panel-body">
                    <p>
                        由于全景照片需通过本站专业相机拍摄，因此本站将派出工作人员到现场用专业的VR相机拍摄取景，并免费上架房源。
                    </p>

                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <p class="text-danger">
                            <strong>
                                <small>*&nbsp;本站遵从<abbr title="一套物业仅可上架一条信息!">『100%真房源』</abbr>的准则！</small>
                            </strong>
                        </p>
                        <button type="button" class="btn btn-primary btn-group-justified btn-sm">
                            发布房源
                        </button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        附近房源
                    </h3>
                </div>
                <div class="panel-body">
                    <c:if test="${null!=nearPageHouse.list&&nearPageHouse.list.size()>0}">
                        <c:forEach items="${nearPageHouse.list}" var="nearHouse">
                            <div class="col-lg-3">
                                <img class="img-thumbnail img-responsive pic-align-center"
                                     src="${pageContext.request.contextPath}/images/house/thumbnail/${nearHouse.get("houseID")}/thumbnail.jpg"
                                     alt="...">
                                <hr>
                                <c:choose>
                                    <c:when test="${nearHouse.get('maxPrice')== nearHouse.get('minPrice')}">
                                        <p class="text-right" style="padding-right: 25px">
                                            <span class="text-danger">￥${nearHouse.get("minPrice")}</span> ~
                                            <span class="text-danger">￥${nearHouse.get("maxPrice")}</span>
                                        </p>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="text-right" style="padding-right: 25px">
                                            <span class="text-danger">￥${nearHouse.get("minPrice")}</span>
                                        </p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>
<c:import url="/WEB-INF/common/showings_common_foot.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/goods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/tour.js"></script>
<script>
    embedpano({
        swf: "${pageContext.request.contextPath}/images/house/vtour/tour.swf",
        xml: "${pageContext.request.contextPath}/images/house/vtour/${requestScope.house.id}/tour.xml",
        target: "vr",
        html5: "auto",
        mobilescale: 1.0,
        passQueryParameters: true
    });
</script>
</body>
</html>
