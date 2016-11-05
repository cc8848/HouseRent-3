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
<body>
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
                        <button type="button" class="btn btn-warning">
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
        <div class="col-sm-6">
            <div class="embed-responsive embed-responsive-4by3">
                <div id="vr" class="embed-responsive-item">
                </div>
            </div>
        </div>
        <div class="visible-xs white-divider-md"></div>
        <%--房屋说明--%>
        <div class="col-sm-6">
            <div id="info-table" class="table-responsive">
                <table class="table">
                    <tbody>
                    <tr class="warning">
                        <td>社区：</td>
                        <td><a href="${requestScope.house.community.id}"
                               target="_blank">${requestScope.house.community.name}</a></td>
                        <td>楼层：</td>
                        <td>${requestScope.house.floor}楼</td>
                    </tr>
                    <tr>
                        <td>布局：</td>
                        <td>${requestScope.house.houseLayout.name}</td>
                        <td>装修：</td>
                        <td>${requestScope.house.decorationType.name}</td>
                    </tr>
                    <tr class="warning">
                        <td>付租方式：</td>
                        <td>${requestScope.house.expectPayment.paymentName}</td>
                        <td>房屋状态：</td>
                        <td>${requestScope.house.houseStatus.statusName}</td>
                    </tr>
                    <tr>
                        <td>房屋面积：</td>
                        <td>${requestScope.house.areaNumber}㎡</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr class="warning">
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
                    </tbody>
                </table>
            </div>
            <div class="white-divider-md"></div>
            <div id="rentMode-tab" class="tab-content">
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/icheck.min.js"></script>
<script type="text/javascript" src="../../js/template.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/goods.js"></script>
<script type="text/javascript" src="../../js/tour.js"></script>
<script id="rentMode" type="text/html">
    <ul class="nav nav-tabs">
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
    </ul>
</script>
<script id="rentModeContent" type="text/html">
    {{each data as rentMode index}}
    {{if rentMode.id==1}}
    {{if index==0}}
    <div id="content-{{rentMode.id}}" class="tab-pane active">
    </div>
    {{else}}
    <div id="content-{{rentMode.id}}" class="tab-pane">
    </div>
    {{/if}}
    {{/if}}
    {{if rentMode.id==2}}
    {{if index==0}}
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
    {{each data as room index}}
    <div id="input-check-{{room.id}}" class="input-check">
        <input id="check-{{room.id}}" type="checkbox">&nbsp;
        <label for="check-{{room.id}}" class="label label-success">
            [{{room.roomNo}}号]：{{room.expectRent}}元/月
        </label>
    </div>
    {{/each}}
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
