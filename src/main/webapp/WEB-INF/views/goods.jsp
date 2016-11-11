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
    <div class="row">
        <div id="left-side" class="col-lg-8">
            <div class="row page-header">
                <h3>${requestScope.house.name}
                    <small>No.<span id="houseID">${requestScope.house.id}</span></small>
                </h3>
            </div>
            <div class="row">
                <div class="embed-responsive embed-responsive-16by9">
                    <div id="vr" class="embed-responsive-item">
                    </div>
                </div>
            </div>
            <%--租赁模式 start--%>
            <div class="white-divider-md"></div>
            <div class="row">
                <ul class="nav nav-tabs">
                    <c:forEach items="${house.rentModeList}" var="rentMode" varStatus="status">
                        <c:if test="${rentMode.id==1 }">
                            <c:choose>
                                <c:when test="${status.index==0}">
                                    <li id="share-tab" class="active">
                                </c:when>
                                <c:otherwise>
                                    <li id="share-tab">
                                </c:otherwise>
                            </c:choose>
                            <a href="#content-share" data-toggle="tab">
                                <c:out value="${rentMode.name}"/>
                            </a>
                            </li>
                        </c:if>
                        <c:if test="${rentMode.id==2 }">
                            <c:choose>
                                <c:when test="${status.index==0}">
                                    <li id="whole-tab" class="active">
                                </c:when>
                                <c:otherwise>
                                    <li id="whole-tab">
                                </c:otherwise>
                            </c:choose>
                            <a href="#content-whole" data-toggle="tab">
                                <c:out value="${rentMode.name}"/>
                            </a>
                            </li>
                        </c:if>
                        <c:if test="${rentMode.id==3 }">
                            <c:choose>
                                <c:when test="${status.index==0}">
                                    <li id="sublet-tab" class="active">
                                </c:when>
                                <c:otherwise>
                                    <li id="sublet-tab">
                                </c:otherwise>
                            </c:choose>
                            <a href="#content-sublet" data-toggle="tab">
                                <c:out value="${rentMode.name}"/>
                            </a>
                            </li>
                        </c:if>
                    </c:forEach>
                </ul>
                <div class="white-divider-md"></div>
                <div class="tab-content">
                    <c:forEach items="${house.rentModeList}" var="rentMode" varStatus="status">
                        <c:if test="${rentMode.id==1}">
                            <c:choose>
                                <c:when test="${status.index==0}">
                                    <div id="content-share" class="tab-pane active">
                                </c:when>
                                <c:otherwise>
                                    <div id="content-share" class="tab-pane">
                                </c:otherwise>
                            </c:choose>
                                    </div>
                        </c:if>
                        <c:if test="${rentMode.id==2 }">
                            <c:choose>
                            <c:when test="${status.index==0}">
                            <div id="content-whole" class="tab-pane active">
                            </c:when>
                            <c:otherwise>
                            <div id="content-whole" class="tab-pane">
                                    </c:otherwise>
                                    </c:choose>
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">
                                            <span class="glyphicon glyphicon-home"></span>
                                            <span>房屋信息</span>
                                            <small class="pull-right" style="margin-top: 7px">

                                            </small>
                                        </h3>
                                    </div>
                                    <div class="panel-body">
                                        <div class="col-lg-8">
                                            <h3>
                                                社区：
                                                <a href="#">
                                                        ${house.city.cityname}&nbsp;${house.area.areaname}&nbsp;${house.community.name}
                                                </a>
                                            </h3>
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
                        <c:if test="${rentMode.id==3}">
                                <c:choose>
                                    <c:when test="${status.index==0}">
                                         <div id="content-sublet" class="tab-pane active">
                                    </c:when>
                                    <c:otherwise>
                                         <div id="content-sublet" class="tab-pane">
                                    </c:otherwise>
                                </c:choose>

                                         </div>
                            </c:if>
                    </c:forEach>
                </div>
            </div>
            <%--租赁模式 end--%>
        </div>
        <div id="right-side" class="col-lg-4">

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
<script id="share" type="text/html">
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
                    <select id="roomNo" class="select2 form-control" style="width: 100%"></select>
                </label>
            </div>
            <div class="col-lg-9">
                <h2 class="text-danger text-right">
                    <span class="room-expectPrice">{{room.expectPrice}}</span>
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
                    <span class="room-areaNum">{{room.areaNumber}}</span>
                    ㎡
                </td>
                <td>状态：
                </td>
                <td class="room-statusName">
                    {{room.houseStatus.statusName}}
                </td>
            </tr>
            <tr>
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
            <tr>
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
            <tr >
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
            <tr>
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
