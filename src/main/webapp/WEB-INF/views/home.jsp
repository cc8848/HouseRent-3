<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wuxinzhe
  联系QQ: 124734668
  创建日期: 16/10/6
  创建时间: 上午9:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Showings · 房库 - 我的账户</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icheckflat/red.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fileinput.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/scojs.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco.message.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar-head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<script src="http://webapi.amap.com/maps?v=1.3&key=002273d8cd1c3363f0d26dae6629472b"></script>
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="white-divider-md"></div>
<div class="container">
    <div class="row">
        <div id="left-side" class="col-lg-3">
            <div class="panel panel-default">
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-lg-12">
                                <img src="${pageContext.request.contextPath}/images/index/wifiOpen.png"
                                     class="img-circle img-thumbnail img-responsive">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-12 text-center">
                                <h4>${sessionScope.user.name}</h4>
                            </div>
                        </div>
                    </li>
                    <c:forEach items="${sysMenuList}" var="sysMenu">
                        <a href="#${sysMenu.href}" class="list-group-item" data-toggle="tab">${sysMenu.menuDesc}</a>
                    </c:forEach>
                    <a href="#" class="list-group-item">账户退出</a>
                </ul>
            </div>
        </div>
        <div id="right-side" class="col-lg-9">
            <div class="tab-content">
                <c:forEach items="${sysMenuList}" var="sysMenu">
                    <c:choose>
                        <%--账户信息--%>
                        <c:when test="${sysMenu.href=='account-info'}">
                            <div id="${sysMenu.href}" class="tab-pane active">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="page-header">
                                            <h1 class="hidden-xs">账户信息
                                                <small class="pull-right">No.${sessionScope.user.userId}</small>
                                            </h1>
                                            <h3 class="visible-xs">账户信息
                                                <small class="pull-right">No.${sessionScope.user.userId}</small>
                                            </h3>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <div class="btn-group pull-right">
                                                    <button type="button" class="btn btn-danger">修改密码</button>
                                                    <button type="button" class="btn btn-warning">修改手机</button>
                                                    <c:if test="${!isSeller}">
                                                        <button type="button" class="btn btn-primary" name="join">加入门店
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${isSeller && storeForSeller.sysStatus==1}">
                                                        <button type="button" class="btn btn-primary" name="cancel">
                                                            取消申请
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${isSeller && storeForSeller.sysStatus==2}">
                                                        <button type="button" class="btn btn-primary" name="quit">退出门店
                                                        </button>
                                                    </c:if>
                                                    <c:if test="${isSeller && storeForSeller.sysStatus==3}">
                                                        <button type="button" class="btn btn-primary" name="repeat">
                                                            重新申请门店
                                                        </button>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="white-divider-md"></div>
                                        <div class="row">
                                            <div class="col-lg-12">
                                                <dl class="dl-horizontal">
                                                    <dt>真实姓名：</dt>
                                                    <dd>${sessionScope.user.name}</dd>
                                                    <dt>手机号码：</dt>
                                                    <dd>${sessionScope.user.username}</dd>
                                                    <dt>上次登录：</dt>
                                                    <dd>${sessionScope.user.lastLoginString}</dd>
                                                </dl>
                                                <c:if test="${isSeller}">
                                                    <dl class="dl-horizontal">
                                                        <dt>所属中介:</dt>
                                                        <dd>${storeForSeller.name}</dd>
                                                        <dt>门店地址:</dt>
                                                        <dd>${storeForSeller.province.provinceName}${storeForSeller.city.cityName}${storeForSeller.area.areaName}${storeForSeller.address}</dd>
                                                    </dl>
                                                </c:if>
                                                <c:if test="${!isSeller}">
                                                    <dl class="dl-horizontal">
                                                        <dt>所属中介：</dt>
                                                        <dd>尚未加入任何中介机构</dd>
                                                    </dl>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <ul class="list-group">
                                            <%--如果不是公司则显示开通信息--%>
                                        <c:if test="${!haveCompany}">
                                            <li class="list-group-item">
                                                <h3>开发商企业服务
                                                    <button id="CC-button" class="btn btn-primary pull-right"
                                                            type="button">我要开通
                                                    </button>
                                                </h3>
                                            </li>
                                        </c:if>
                                            <%--企业服务--%>
                                        <c:if test="${haveCompany}">
                                            <li class="list-group-item">
                                                <div class="page-header">
                                                    <h1>${company.companyName}
                                                        <small class="pull-right">No.${company.id}</small>
                                                    </h1>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <dl class="dl-horizontal">
                                                            <dt>服务类型：</dt>
                                                            <dd>开发商企业服务</dd>
                                                            <dt>服务状态：</dt>
                                                            <dd class="text-danger">${company.statusName}</dd>
                                                            <c:choose>
                                                                <c:when test="${company.status==1}">
                                                                    <dt>申请日期：</dt>
                                                                    <dd class="text-danger">${company.auditingTimeString}</dd>
                                                                </c:when>
                                                                <c:when test="${company.status==3}">
                                                                    <dt>申请日期：</dt>
                                                                    <dd class="text-danger">${company.auditingTimeString}</dd>
                                                                    <button id="CCR-button" class="btn btn-primary"
                                                                            type="button">重新申请
                                                                    </button>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <dt>开通日期：</dt>
                                                                    <dd class="text-danger">${company.operateTimeString}</dd>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </dl>
                                                        <dl class="dl-horizontal">
                                                            <dt>公司地址：</dt>
                                                            <dd>${company.province.provinceName} ${company.city.cityName} ${company.area.areaName} ${company.address}</dd>
                                                            <dt>联系电话：</dt>
                                                            <dd>${company.phone}</dd>
                                                        </dl>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                        <c:if test="${!haveStore}">
                                            <li class="list-group-item">
                                                <h3>中介门店服务
                                                    <button id="CS-button" class="btn btn-primary pull-right"
                                                            type="button">
                                                        我要开通
                                                    </button>
                                                </h3>
                                            </li>
                                        </c:if>
                                        <c:if test="${haveStore}">
                                            <li class="list-group-item">
                                                <div class="page-header">
                                                    <h1 class="hidden-xs">${store.name}
                                                        <small class="pull-right">No.${store.id}</small>
                                                    </h1>
                                                    <h3 class="visible-xs">${store.name}
                                                        <small class="pull-right">No.${store.id}</small>
                                                    </h3>
                                                </div>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <dl class="dl-horizontal">
                                                            <dt>服务类型：</dt>
                                                            <dd>中介门店服务</dd>
                                                            <dt>服务状态：</dt>
                                                            <dd class="text-danger">${store.sysStatusName}</dd>
                                                            <c:choose>
                                                                <c:when test="${store.sysStatus==1}">
                                                                    <dt>申请日期：</dt>
                                                                    <dd class="text-danger">${store.auditingTimeString}</dd>
                                                                </c:when>
                                                                <c:when test="${store.sysStatus==3}">
                                                                    <dt>申请日期：</dt>
                                                                    <dd class="text-danger">${store.auditingTimeString}</dd>
                                                                    <button id="CSR-button" class="btn btn-primary"
                                                                            type="button">重新申请
                                                                    </button>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <dt>开通日期：</dt>
                                                                    <dd class="text-danger">${store.operateTimeString}</dd>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </dl>
                                                        <dl class="dl-horizontal">
                                                            <dt>门店地址：</dt>
                                                            <dd>${store.province.provinceName} ${store.city.cityName} ${store.area.areaName}</dd>
                                                            <dt></dt>
                                                            <dd>${store.address}</dd>
                                                        </dl>
                                                    </div>
                                                </div>
                                            </li>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${sysMenu.href=='issue-house'}">
                            <div id="${sysMenu.href}" class="tab-pane">

                            </div>
                        </c:when>
                        <c:when test="${sysMenu.href=='create-project'}">
                            <div id="${sysMenu.href}" class="tab-pane">

                            </div>
                        </c:when>
                        <c:when test="${sysMenu.href=='project-manage'}">
                            <div id="${sysMenu.href}" class="tab-pane">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">项目管理</h3>
                                    </div>
                                    <div class="panel-body">
                                        <p>
                                            ...
                                        </p>
                                    </div>
                                    <div class="table-responsive">
                                        <table id="PM-table" class="table table-striped">

                                        </table>
                                    </div>
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <ul id="PM-page">

                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${sysMenu.href=='house-manage'}">
                            <div id="${sysMenu.href}" class="tab-pane">
                                <div class="panel panel-default col-lg-12">
                                    <div class="page-header">
                                        <h1>房源管理
                                            <small class="pull-right">No.<span id="HM-companyID">${company.id}</span>
                                            </small>
                                        </h1>
                                    </div>
                                    <div class="panel-body">
                                        <div class="col-lg-3">
                                            <label class="control-label">项目</label>
                                            <select class="select2 form-control" style="width: 100%"
                                                    name="HM-project"></select>
                                        </div>
                                    </div>

                                    <div class="table-responsive">
                                        <table id="HM-table" class="table table-striped">

                                        </table>
                                    </div>
                                    <ul class="list-group">
                                        <li class="list-group-item">
                                            <ul id="HM-page">

                                            </ul>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </c:when>
                        <c:when test="${sysMenu.href=='group-manage'}">
                            <div id="${sysMenu.href}" class="tab-pane">
                                <div class="panel panel-default col-lg-12">
                                    <div class="page-header">
                                        <h2>团队管理
                                            <small class="pull-right">No.<span id="GM-storeID">${store.id}</span>
                                            </small>
                                        </h2>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-2">
                                            <select class="select2 form-control" style="width: 100%"
                                                    name="status"></select>
                                        </div>
                                        <div class="col-lg-2">
                                        </div>
                                        <div class="col-lg-2">

                                        </div>
                                        <div class="col-lg-2">

                                        </div>
                                        <div class="col-lg-2">

                                        </div>
                                        <div class="col-lg-2">
                                            <button id="GM-query" class="btn btn-primary btn-group-justified"
                                                    type="button">查&nbsp;&nbsp;询
                                            </button>
                                        </div>
                                    </div>
                                    <div class="white-divider-md"></div>
                                    <div class="row">
                                        <div class="table-responsive col-lg-12">
                                            <table class="table">

                                            </table>
                                        </div>
                                    </div>
                                    <hr>
                                    <div class="white-divider-md"></div>
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <ul id="GM-page"></ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<%--foot start--%>
<c:import url="/WEB-INF/common/showings_common_foot.jsp"/>
<%--foot end--%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/soc/sco.message.js"></script>
<script src="${pageContext.request.contextPath}/js/soc/sco.modal.js"></script>
<script src="${pageContext.request.contextPath}/js/soc/sco.confirm.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
<script src="${pageContext.request.contextPath}/js/template.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/views/home.js"></script>
<script id="create-project-template" type="text/html">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">创建项目</h3>
        </div>
        <div class="panel-body">
            <form role="form" id="create-project-form">
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">项目/社区名称</label>
                        <input type="text" class="form-control"
                               placeholder="标题长度不超过15个中文" name="tittle">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-4">
                        <label class="control-label">省份</label>
                        <select class="select2 form-control"
                                style="width: 100%"
                                name="province"></select>
                    </div>
                    <div class="col-lg-4">
                        <label class="control-label">城市</label>
                        <select class="select2 form-control"
                                style="width: 100%"
                                name="city"></select>
                    </div>
                    <div class="col-lg-4">
                        <label class="control-label">区域</label>
                        <select class="select2 form-control"
                                style="width: 100%"
                                name="area"></select>
                    </div>

                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">具体地址</label>
                        <input type="text" class="form-control"
                               placeholder="请输入详细地址" name="address">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">物业公司</label>
                        <input type="text" class="form-control"
                               placeholder="请输入完整公司名称" name="estateManageCompany">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-6">
                        <label class="control-label">开盘时间</label>
                        <div class="input-group date form_date" data-date=""
                             data-date-format="yyyy-MM-dd" data-link-field="openTime"
                             data-link-format="yyyy-mm-dd">

                            <input class="form-control" size="16" type="text"
                                   name="openTime" readonly>
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="openTime" value=""/>
                    </div>
                    <div class="col-lg-6">
                        <label class="control-label">交房时间</label>
                        <div class="input-group date form_date" data-date=""
                             data-date-format="yyyy-MM-dd" data-link-field="realEstateTime"
                             data-link-format="yyyy-mm-dd">
                            <input class="form-control" size="16" type="text"
                                   name="realEstateTime" readonly>
                            <span class="input-group-addon"><span
                                    class="glyphicon glyphicon-calendar"></span></span>
                        </div>
                        <input type="hidden" id="realEstateTime" value=""/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">地图位置</label>
                        <div class="embed-responsive panel panel-default"
                             style="height: 200px;margin-bottom: 0">
                            <div id="community-map" class="embed-responsive-item"
                                 style="height: 200px">
                            </div>
                        </div>
                        <input type="hidden" value="" name="lng"/>
                        <input type="hidden" value="" name="lat"/>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-primary" name="submit">
                                提交申请
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="panel-footer">
            <p>依照国家相关法律法规，发布新项目，我公司须对项目进行相关审核及实地拍摄取景.</p>
            <p>申请提交后，我公司将会在3个工作日内完成资料的初审，并与您取得联系，首英感谢您的支持。</p>
        </div>
    </div>
</script>
<script id="issue-house-template" type="text/html">
    <div class="panel panel-default col-lg-12">
        <div class="page-header">
            <h1>房源信息</h1>
        </div>
        <div class="panel-body">
            <form role="form" id="issue-house-form">
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">房源标题</label>
                        <input type="text" class="form-control"
                               placeholder="标题长度不超过15个中文" name="tittle">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">描述信息</label>
                        <input type="text" class="form-control"
                               placeholder="描述信息不超过30个中文" name="desc">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-6">
                        <label class="control-label">售价</label>
                        <div class="input-group">
                            <span class="input-group-addon">￥</span>
                            <input type="text" class="form-control"
                                   placeholder="请输入整套销售价，单价会根据面积自动计算" name="price">
                        </div>

                    </div>
                    <div class="col-lg-3">
                        <label class="control-label">佣金</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="最高不超过20%" name="brokerage">
                            <span class="input-group-addon">%</span>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <label class="control-label">楼层</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="房屋所在楼层" name="floor">
                            <span class="input-group-addon">层</span>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-4">
                        <label class="control-label">建筑面积</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="面积保留小数点后2位" name="floorArea">
                            <div class="input-group-addon">㎡</div>
                        </div>

                    </div>
                    <div class="col-lg-4">
                        <label class="control-label">公摊面积</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="面积保留小数点后2位" name="poolArea">
                            <span class="input-group-addon">㎡</span>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <label class="control-label">产权年限</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="最长不超过70年" name="age">
                            <span class="input-group-addon">年</span>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-3">
                        <label class="control-label">朝向</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="face"></select>
                    </div>
                    <div class="col-lg-3">
                        <label class="control-label">装修程度</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="decoration"></select>
                    </div>
                    <div class="col-lg-3">
                        <label class="control-label">室内格局</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="layout"></select>
                    </div>
                    <div class="col-lg-3">
                        <label class="control-label">期房/现房</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="houseStatus"></select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-6">
                        <label class="control-label">梯户类型</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="elevatorType"></select>
                    </div>
                    <div class="col-lg-6">
                        <label class="control-label">项目/社区</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="community"></select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-4">
                        <label class="control-label">省份</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="province"></select>
                    </div>
                    <div class="col-lg-4">
                        <label class="control-label">城市</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="city"></select>
                    </div>
                    <div class="col-lg-4">
                        <label class="control-label">区域</label>
                        <select class="select2 form-control" style="width: 100%"
                                name="area"></select>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">具体地址</label>
                        <input type="text" class="form-control"
                               placeholder="请输入详细地址" name="address">
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-12">
                        <div class="btn-group pull-right">
                            <button type="button" class="btn btn-primary" name="issueSubmit">
                                提交信息
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</script>
<script id="PM-template" type="text/html">
    <thead>
    <tr>
        <th></th>
        <th>#</th>
        <th>项目名称</th>
        <th>申请日期</th>
        <th>申请状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    {{each data.list as community index}}
    <tr>
        <td></td>
        <td>{{community.id}}</td>
        <td>{{community.name}}</td>
        <td>{{community.auditingTimeString}}</td>
        <td>{{community.statusName}}</td>
        <td>
            <div class="btn-group-xs">
                {{if community.status==2}}
                <a href="#" class="btn btn-primary">详情</a>
                {{/if}}
                {{if community.status==1}}
                <button id="PM-{{community.id}}" class="btn btn-danger" type="button" name="PM-cancel">取消</button>
                {{/if}}
            </div>
        </td>
    </tr>
    {{/each}}
    </tbody>
</script>
<script id="HM-template" type="text/html">
    <thead>
    <tr>
        <th></th>
        <th>#</th>
        <th>标题</th>
        <th>项目</th>
        <th>售价</th>
        <th>佣金</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    {{each data.list as house index}}
    <tr>
        <td></td>
        <td>{{house.id}}</td>
        <td>{{house.tittle}}</td>
        <td>项目</td>
        <td>{{house.expectPrice}}</td>
        <td>{{house.brokerage}}%</td>
        <td>{{house.sysStatusName}}</td>
        <td>
            <div class="btn-group-xs">
                {{if house.sysStatus==2}}
                <a href="#" class="btn btn-primary">详情</a>
                {{/if}}
                {{if house.sysStatus==1}}
                <button id="HM-{{house.id}}" class="btn btn-danger" type="button" name="HM-cancel">取消</button>
                {{/if}}
            </div>
        </td>
    </tr>
    {{/each}}
    </tbody>
</script>
<%--创建公司模板--%>
<script id="CC-template" type="text/html">
    <div class="page-header">
        <h3>开通企业服务申请</h3>
    </div>
    <form role="form" id="CC-form">
        <div class="form-group row">
            <div class="col-lg-12">
                <label class="control-label">公司名称</label>
                <input type="text" class="form-control"
                       placeholder="请输入公司全称" name="companyName">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-lg-4">
                <label class="control-label">省份</label>
                <select class="select2 form-control" style="width: 100%"
                        name="province"></select>
            </div>
            <div class="col-lg-4">
                <label class="control-label">城市</label>
                <select class="select2 form-control" style="width: 100%"
                        name="city"></select>
            </div>
            <div class="col-lg-4">
                <label class="control-label">区域</label>
                <select class="select2 form-control" style="width: 100%"
                        name="area"></select>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-lg-6">
                <label class="control-label">具体地址</label>
                <input type="text" class="form-control"
                       placeholder="请输入详细地址" name="address">
            </div>
            <div class="col-lg-6">
                <label class="control-label">联系电话</label>
                <input type="text" class="form-control"
                       placeholder="请输入座机电话(确保畅通)" name="phone">
            </div>
        </div>
    </form>
</script>
<%--创建门店模板--%>
<script id="CS-template" type="text/html">
    <div class="page-header">
        <h3>开通门店申请</h3>
    </div>
    <form role="form" id="CS-form">
        <div class="form-group row">
            <div class="col-lg-12">
                <label class="control-label">门店名称</label>
                <input type="text" class="form-control"
                       placeholder="请输入门店名称" name="name">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-lg-4">
                <label class="control-label">省份</label>
                <select class="select2 form-control" style="width: 100%"
                        name="province"></select>
            </div>
            <div class="col-lg-4">
                <label class="control-label">城市</label>
                <select class="select2 form-control" style="width: 100%"
                        name="city"></select>
            </div>
            <div class="col-lg-4">
                <label class="control-label">区域</label>
                <select class="select2 form-control" style="width: 100%"
                        name="area"></select>
            </div>
        </div>
        <div class="form-group row">
            <div class="col-lg-12">
                <label class="control-label">具体地址</label>
                <input type="text" class="form-control"
                       placeholder="请输入详细地址" name="address">
            </div>
        </div>
    </form>
</script>
<%--团队管理模板--%>
<script id="GM-template" type="text/html">
    <thead>
    <tr>
        <th></th>
        <th>#</th>
        <th>姓名</th>
        <th>电话</th>
        <th>申请日期</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    {{each data.list as seller}}
    <tr>
        <td></td>
        <td>{{seller.user.id}}</td>
        <td>{{seller.user.name}}</td>
        <td>{{seller.user.username}}</td>
        <td>{{seller.status}}</td>
        <td>{{seller.auditingTimeString}}</td>
        <td>
            {{if seller.status==1}}
            <div class="btn-group-xs">
                <button class="btn btn-success" type="button" name="GM-pass">通过</button>
                <button class="btn btn-danger" type="button" name="GM-refuse">拒绝</button>
            </div>
            {{/if}}
        </td>
    </tr>
    {{/each}}
    </tbody>
</script>
</body>
</html>
