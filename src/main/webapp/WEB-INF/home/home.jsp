<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/10
  Time: 上午7:54
  To change this template use File | Settings | File Templates.
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar-head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="white-divider-md"></div>
<div class="container">
    <div class="row">
        <div id="left-side" class="col-lg-2">
            <div class="panel-group" id="menu" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="one">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#menu" href="#account" aria-expanded="false"
                               aria-controls="one">
                                账户管理
                            </a>
                        </h4>
                    </div>
                    <div id="account" class="panel-collapse collapse in" role="tabpanel"
                         aria-labelledby="one">
                        <ul class="list-group">
                            <li class="list-group-item">
                                <a href="${pageContext.request.contextPath}/home/account" target="frame-box">账户信息</a>
                            </li>
                            <li class="list-group-item">
                                <a href="${pageContext.request.contextPath}/home/account_update"
                                   target="frame-box">账户安全</a>
                            </li>
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
        <div id="right-side" class="col-lg-10">
            <iframe id="frame-box" name="frame-box"
                    src="${pageContext.request.contextPath}/home/account" scrolling="no" frameborder="no"
                    width="100%" onload="setIFrameHeight()"></iframe>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/home.js"></script>
</body>
</html>
