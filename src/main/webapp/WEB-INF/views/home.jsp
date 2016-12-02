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
                            <div id="${sysMenu.href}" class="tab-pane">

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
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/zh.js"></script>
<script src="${pageContext.request.contextPath}/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/js/template.js"></script>
<script src="${pageContext.request.contextPath}/js/map.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
<script src="http://webapi.amap.com/maps?v=1.3&key=002273d8cd1c3363f0d26dae6629472b"></script>
<script id="create-project-template" type="text/html">
    <div class="panel panel-primary">
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
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">房源信息</h3>
        </div>
        <div class="panel-body">
            <form role="form" id="issue-house-form">
                <div class="form-group row">
                    <div class="col-lg-12">
                        <label class="control-label">社区名称</label>
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
                    <div class="col-lg-6">
                        <label class="control-label">楼层</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="房屋所在楼层" name="floor">
                            <span class="input-group-addon">层</span>
                        </div>

                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-lg-6">
                        <label class="control-label">建筑面积</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="面积保留小数点后2位" name="floorArea">
                            <div class="input-group-addon">㎡</div>
                        </div>

                    </div>
                    <div class="col-lg-6">
                        <label class="control-label">公摊面积</label>
                        <div class="input-group">
                            <input type="text" class="form-control"
                                   placeholder="面积保留小数点后2位" name="poolArea">
                            <span class="input-group-addon">㎡</span>
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
                                name="status_sell"></select>
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
</body>
</html>
