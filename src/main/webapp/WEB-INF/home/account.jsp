<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/9
  Time: 下午6:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showings · 房库 - 账户信息</title>
    <sec:csrfMetaTags/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/home/account">我的账户</a></li>
            <li class="active">账户信息</li>
        </ol>
    </div>
    <div class="row">
        <div class="panel-group" id="message" role="tablist" aria-multiselectable="true">
            <div class="panel panel-primary">
                <div class="panel-heading" role="tab" id="one">
                    <h3 class="panel-title">
                        <i class="iconFont-xs">&#xe626;</i>
                        <a data-toggle="collapse" data-parent="#message" href="#content" aria-expanded="false"
                           aria-controls="one">
                            系统广播
                        </a>
                        <span class="badge pull-right">1</span>
                    </h3>
                </div>
                <div id="content" class="panel-collapse collapse " role="tabpanel"
                     aria-labelledby="one">
                    <ul class="list-group">
                        <li class="list-group-item">2017年12月12日以前入住首英的开发商将获得为期1年的免费服务！</li>
                    </ul>

                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">基本信息<span class="btn btn-primary btn-xs pull-right">修改信息</span></h3>
            </div>
            <div class="panel-body">
                <dl class="dl-horizontal">
                    <dt>姓名：</dt>
                    <dd>${sessionScope.user.name}</dd>
                    <dt>性别：</dt>
                    <dd>男</dd>
                    <dt>年龄：</dt>
                    <dd>17岁</dd>
                    <dt>隶属公司：</dt>
                    <dd>厦门中鼎信实业有限公司</dd>
                    <dt>上次登录：</dt>
                    <dd>${sessionScope.user.lastLoginString}</dd>
                </dl>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/_account.js"></script>

</body>
</html>
