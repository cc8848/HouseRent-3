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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
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
                    <a href="#account-info" class="list-group-item" data-toggle="tab">账户信息</a>
                    <%--门店经理角色拥有团队管理权限--%>
                    <c:if test="${sessionScope.user.haveRoles(3)}">
                        <a href="#group-manage" class="list-group-item" data-toggle="tab">团队管理</a>
                    </c:if>
                    <a href="#" class="list-group-item" data-toggle="tab">发布房源</a>
                    <a href="#" class="list-group-item" data-toggle="tab">我的房单</a>
                    <a href="#" class="list-group-item" data-toggle="tab">我的钱包</a>
                    <a href="#" class="list-group-item" data-toggle="tab">业绩统计</a>
                    <a href="#" class="list-group-item" data-toggle="tab">安全设置</a>
                    <a href="#" class="list-group-item" >账户退出</a>
                </ul>
            </div>
        </div>
        <div id="right-side" class="col-lg-9">
            <div class="tab-content">
                <div id="account-info" class="tab-pane active">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">我的团队</h3>
                        </div>
                        <c:choose>
                            <c:when test="${null==seller}">
                                <div class="panel-body">
                                    您尚未申请加入任何中介机构！
                                    <button href="#updateSeller" type="button"
                                            class="btn btn-primary btn-sm pull-right" data-toggle="collapse">申请加入
                                    </button>
                                </div>
                            </c:when>
                            <c:when test="${null!=seller}">
                                <div class="panel-body">
                                    <c:choose>
                                        <c:when test="${seller.userStatus.id==1||seller.userStatus.id==2}">
                                            <%--当前为待审核或审核失败状态--%>
                                            <span>当前属于<u class="text-danger">${seller.userStatus.statusName}</u>状态，请耐心等待！</span>
                                        </c:when>
                                        <c:otherwise>
                                            <%--当前为审核成功状态--%>
                                            <span>你好，${sessionScope.user.name}。</span>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="btn-group-sm pull-right">
                                        <button href="#updateSeller" type="button" class="btn btn-primary"
                                                data-toggle="collapse">更换团队
                                        </button>
                                        <button id="secede" type="button" class="btn btn-primary">退出团队</button>
                                    </div>
                                </div>
                                <table class="table table-striped">
                                    <tbody>
                                    <tr>
                                        <td>账号/手机号：</td>
                                        <td>${sessionScope.user.username}</td>
                                        <td>姓名：</td>
                                        <td>${sessionScope.user.name}</td>
                                    </tr>
                                    <tr>
                                        <td>公司名称：</td>
                                        <td>${seller.sysStore.sysCompany.companyName}</td>
                                        <td>申请门店：</td>
                                        <td>${seller.sysStore.storeName}</td>
                                    </tr>
                                    <tr>
                                        <td>门店地址：</td>
                                        <td colspan="3">${seller.sysStore.province.provinceName}-${seller.sysStore.city.cityName}-${seller.sysStore.area.areaName}-${seller.sysStore.storeNumber}</td>
                                    </tr>
                                    <tr>
                                        <td>审核状态：</td>
                                        <td>${seller.userStatus.statusName}</td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    </tbody>
                                </table>
                            </c:when>
                        </c:choose>
                    </div>
                    <div id="updateSeller" class="panel-collapse collapse">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">请填写您的申请资料！
                                    <a id="apply-close" href="#updateSeller" class="label pull-right"
                                       data-toggle="collapse">
                                        <span class="glyphicon glyphicon-remove"></span>
                                    </a>
                                </h3>
                            </div>
                            <div class="panel-body">
                                <span id="apply-error">申报后请通知贵公司后台管理员进行审核，即可继续进行后续操作。</span>
                                <div class="btn-group-sm pull-right">
                                    <button id="auditing-submit" type="button"
                                            class="btn btn-primary">提交申请
                                    </button>
                                    <button id="auditing-cancel" href="#updateSeller" type="button"
                                            class="btn btn-primary"
                                            data-toggle="collapse">取消申请
                                    </button>
                                </div>
                            </div>
                            <table class="table table-striped table-responsive">
                                <tbody>
                                <tr>
                                    <td>账号：</td>
                                    <td>${sessionScope.user.username}</td>
                                    <td>姓名：</td>
                                    <td>${sessionScope.user.name}</td>
                                </tr>
                                <tr>
                                    <td>地址：</td>
                                    <td>
                                        <select id="province" title="province" class="select2"
                                                style="width: 100%"></select>
                                    </td>
                                    <td>
                                        <select id="city" title="city" class="select2" style="width: 100%"></select>
                                    </td>
                                    <td>
                                        <select id="area" title="area" class="select2" style="width: 100%"></select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>门牌</td>
                                    <td id="storeNum-td">
                                        <select id="storeNum" title="storeNum" class="select2"
                                                style="width: 100%"></select>
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
                </div>
            </div>
        </div>
    </div>
</div>
<%--foot start--%>
<c:import url="/WEB-INF/common/showings_common_foot.jsp"/>
<%--foot end--%>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/location.js"></script>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
</body>
</html>
