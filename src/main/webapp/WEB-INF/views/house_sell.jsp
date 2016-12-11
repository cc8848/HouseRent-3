<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/24
  Time: 上午8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Showings · VR房库-${house.tittle}</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar-foot.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icheckflat/blue.css">
<script src="http://webapi.amap.com/maps?v=1.3&key=002273d8cd1c3363f0d26dae6629472b"></script>
<body>
<div class="container">
    <div class="row" id="view">
        <div class="col-lg-12">
            <div class="page-header">
                <h3>${house.tittle}
                    <small class="pull-right">No.<span id="houseID">${house.id}</span></small>
                </h3>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-9">
            <div class="embed-responsive embed-responsive-16by9">
                <div id="vr" class="embed-responsive-item">
                </div>
            </div>
        </div>
        <div class="white-divider-md visible-xs"></div>
        <div class="col-lg-3">
            <div class="btn-group btn-group-justified">
                <div class="btn-group">
                    <button type="button" class="btn btn-danger">
                        <span class="glyphicon glyphicon-star-empty"></span>
                        收藏
                    </button>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-qrcode"></span>
                        <span class="sr-only">Toggle Dropdown</span>
                        二维码
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li class="divider"></li>
                        <li><a href="#" class="text-center">微信扫描二维码</a></li>
                    </ul>
                </div>
            </div>
            <div class="white-divider-md"></div>
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">预约看房</h3>
                </div>
                <div class="panel-body">
                    <p>
                        留下您的联系方式,我们会即刻安排专业的置业顾问与您取得联系。
                    </p>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <form role="form">
                            <div class="form-group has-feedback">
                                <input title="name" type="text" class="form-control" placeholder="您的姓名">
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                            <div class="white-divider-md"></div>
                            <div class="form-group has-feedback">
                                <input title="name" type="text" class="form-control" placeholder="您的联系方式">
                                <span class="glyphicon glyphicon-phone form-control-feedback"></span>
                            </div>
                            <div class="white-divider-md"></div>
                            <div class="btn-group-justified">
                                <div class="btn-group">
                                    <button type="submit" class="btn btn-danger form-control">提交</button>
                                </div>
                            </div>
                        </form>
                    </li>
                    <li class="list-group-item">
                        <address>
                            <h4>${company.companyName}</h4><br>
                            <small><span class="glyphicon glyphicon-phone"></span> : ${company.phone}</small>
                            <br>
                            <small><span class="glyphicon glyphicon-globe"></span> : ${company.address}</small>
                        </address>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="activity" class="row">
        <div class="col-lg-12">
            <div class="jumbotron">
                <h1>迎元旦 抽豪车</h1>
                <p>
                    凡在活动时间内购买置业的客户，可享受1次抽宝马豪车的机会！宝马车型为X5系，每人仅有1次抽取的机会，
                    在付款当天即可立刻抽奖！奖品不可折现，不可退换！
                </p><br>
                <p class="text-right">
                    <small>2017年1月1日-2017年1月3日</small>
                    <br>
                    <small>中鼎信实业有限公司</small>
                </p>
            </div>
        </div>
    </div>
    <div id="info" class="row">
        <div class="col-lg-12">
            <div class="panel panel-danger">
                <div class="col-lg-12">
                    <div class="page-header">
                        <h1>楼盘信息</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="col-lg-8">
                        <p id="description">${house.description}</p>
                    </div>
                    <div class="col-lg-4">
                        <h2 class="text-danger text-right">
                            ${house.expectPrice}
                            <small>元/㎡</small>
                        </h2>
                    </div>

                </div>
                <div class="table-responsive">
                    <table class="table  table-striped ">
                        <tbody>
                        <tr>
                            <td></td>
                            <td>楼盘名称：</td>
                            <td id="community">${house.community.name}</td>
                            <td>产权年限：</td>
                            <td id="age"><span>${house.age}</span>年</td>
                            <td>房屋格局：</td>
                            <td id="layout">${house.houseLayout.name}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>建筑面积：</td>
                            <td id="floorArea"><span>${house.floorArea}</span>㎡</td>
                            <td>公摊面积：</td>
                            <td id="poolArea"><span>${house.poolArea}</span>㎡</td>
                            <td>装修类型：</td>
                            <td id="decoration">${house.houseDecoration.name}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>房屋朝向：</td>
                            <td id="face">${house.faceName}</td>
                            <td>物业费：</td>
                            <td id="propertyFee"><span></span>元/月</td>
                            <td>梯户类型：</td>
                            <td>${house.houseElevator.name}</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>楼盘地址：</td>
                            <td colspan="5" id="address">${house.address}</td>
                            <td></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div id="map" class="row">
        <div class="col-lg-12">
            <div class="panel panel-danger col-lg-12">
                <%--<div class="panel-heading">--%>
                <%--<h3 class="panel-title">地图及周边</h3>--%>
                <%--</div>--%>
                <div class="page-header">
                    <h1>地图及周边</h1>
                </div>
                <div class="embed-responsive panel panel-default"
                     style="height: 350px;margin-bottom: 0">
                    <div id="container" class="embed-responsive-item"
                         style="height: 350px">
                    </div>
                </div>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="btn-group ">
                            <button type="button" class="btn btn-primary">本盘</button>
                            <button type="button" class="btn btn-primary">公交</button>
                            <button type="button" class="btn btn-primary">学校</button>
                            <button type="button" class="btn btn-primary">医院</button>
                            <button type="button" class="btn btn-primary">商超</button>
                            <button type="button" class="btn btn-primary">公园</button>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%--foot start--%>
<c:import url="/WEB-INF/common/house_common_foot.jsp"/>
<%--foot end--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/table/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/house_sell.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/table/tour.js"></script>

<script>
    embedpano({
        swf: "${pageContext.request.contextPath}/images/house/vtour/tour.swf",
        xml: "${pageContext.request.contextPath}/images/house/vtour/1/tour.xml",
        target: "vr",
        html5: "auto",
        mobilescale: 1.0,
        passQueryParameters: true
    });
</script>
<script type="text/javascript">
    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom: 11,
        center: [${house.community.lng}, ${house.community.lat}]
    });
</script>
</body>
</html>
