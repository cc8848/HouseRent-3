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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrapTable/bootstrap-table.min.css">
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
                            <li class="list-group-item"><a href="${pageContext.request.contextPath}/" target="box">开发商管理</a>
                            </li>
                            <li class="list-group-item"><a href="#" target="box">中介管理</a></li>
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
            <div class="embed-responsive embed-responsive-16by9">
                <iframe name="box" src="#" class="embed-responsive-item"></iframe>
            </div>
        </div>
    </div>
</div>

<%--页脚--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/table/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap-paginator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/index.js"></script>
</body>
</html>

