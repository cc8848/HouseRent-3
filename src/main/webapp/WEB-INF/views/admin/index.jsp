<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/6
  Time: 下午6:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Showings · VR房库-后台管理</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar-head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/scojs.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco.message.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="white-divider-md"></div>
<div class="container-fluid">
    <div class="row">
        <div id="left" class="col-lg-2">
            <div class="panel-group" id="menu" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="one">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#menu" href="#M-custom" aria-expanded="false"
                               aria-controls="one">
                                客户管理
                            </a>
                        </h4>
                    </div>
                    <div id="M-custom" class="panel-collapse collapse in" role="tabpanel"
                         aria-labelledby="one">
                        <ul class="list-group">
                            <a href="#company" class="list-group-item" data-toggle="tab">开发商管理</a>
                            <a href="#store" class="list-group-item" data-toggle="tab">中介管理</a>
                        </ul>
                    </div>
                    <div class="panel-heading" role="tab" id="two">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#menu" href="#M-user" aria-expanded="false"
                               aria-controls="two">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="M-user" class="panel-collapse collapse" role="tabpanel"
                         aria-labelledby="two">
                        <ul class="list-group">
                            <li class="list-group-item">用户查询</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="right" class="col-lg-10">
            <div class="tab-content">
                <div id="sysInfo" class="tab-pane active"></div>
                <div id="company" class="tab-pane">
                    <div class="panel panel-default col-lg-12">
                        <div class="page-header">
                            <h2>开发商管理</h2>
                        </div>
                        <div class="row">
                            <div class="col-lg-2">
                                <select class="select2 form-control" style="width: 100%"
                                        name="province"></select>
                            </div>
                            <div class="col-lg-2">
                                <select class="select2 form-control" style="width: 100%"
                                        name="city"></select>
                            </div>
                            <div class="col-lg-2">
                                <select class="select2 form-control" style="width: 100%"
                                        name="area"></select>
                            </div>
                            <div class="col-lg-2">
                                <select class="select2 form-control" style="width: 100%"
                                        name="status"></select>
                            </div>
                            <div class="col-lg-2">

                            </div>
                            <div class="col-lg-2">
                                <button class="btn btn-primary btn-group-justified" type="button">查&nbsp;&nbsp;询</button>
                            </div>
                        </div>
                        <div class="white-divider-md"></div>
                        <div class="row">
                            <div class="table-responsive col-lg-12">
                                <table class="table" id="CA-table">

                                </table>
                            </div>
                        </div>
                        <hr>
                        <div class="white-divider-md"></div>
                        <div class="row">
                            <div class="col-lg-12">
                                <ul id="CA-page"></ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="store" class="tab-pane"></div>
            </div>

        </div>
    </div>
</div>

<%--页脚--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/index.js"></script>
<script id="CA-template" type="text/html">
    <thead>
    <tr>
        <th></th>
        <th>#</th>
        <th>公司名称</th>
        <th>公司地址</th>
        <th>联系电话</th>
        <th>申请状态</th>
        <th>申请日期</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    {{each data.list as company}}
    <tr>
        <td></td>
        <td>{{company.id}}</td>
        <td>{{company.companyName}}</td>
        <td>{{company.province.provinceName}}{{company.city.cityName}}{{company.area.areaName}}{{company.address}}</td>
        <td>{{company.phone}}</td>
        <td>{{company.statusName}}</td>
        <td>{{company.auditingTimeString}}</td>
        <td>
            <div class="btn-group-xs">
                {{if company.status==1}}
                <button class="btn btn-success" type="button" name="CA-pass">通过</button>
                <button class="btn btn-danger" type="button" name="CA-refuse">拒绝</button>
                {{else}}
                <button class="btn btn-primary" type="button" name="CA-detail">详情</button>
                {{/if}}
            </div>
        </td>
    </tr>
    {{/each}}
    </tbody>
</script>
</body>
</html>

