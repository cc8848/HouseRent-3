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
    <title>Showings · VR房库-正在审核当中..</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar-head.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>

<div class="container">
    <div class="white-divider-md"></div>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div class="row">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">申报信息
                            <small style="color: white">No.<span id="auditing-id">${userSeller.id}</span></small>
                        </h3>
                    </div>
                    <div class="panel-body">
                        申报后请通知贵公司后台管理员，进行批准审核，即可继续进行后续操作。
                    </div>
                    <table class="table table-striped">
                        <tbody>
                        <tr>
                            <td>账号/手机号：</td>
                            <td>${user.username}</td>
                            <td>姓名：</td>
                            <td>${user.name}</td>
                        </tr>
                        <tr>
                            <td>公司名称</td>
                            <td>${userSeller.sysStore.sysCompany.companyName}</td>
                            <td>申请门店：</td>
                            <td>${userSeller.sysStore.storeName}</td>
                        </tr>
                        <tr>
                            <td>门店地址：</td>
                            <td colspan="3">${userSeller.sysStore.province.provinceName}-${userSeller.sysStore.city.cityName}-${userSeller.sysStore.area.areaName}-${userSeller.sysStore.storeNumber}</td>
                        </tr>
                        <tr>
                            <td>申请岗位：</td>
                            <td>${userSeller.sysRoles.roleDesc}</td>
                            <td>审核状态：</td>
                            <td>${userSeller.userStatus.statusName}</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="btn-group pull-right">
                    <button type="button" class="btn btn-primary ">修&nbsp;&nbsp;&nbsp;&nbsp;改</button>
                    <button type="button" class="btn btn-primary">取&nbsp;&nbsp;&nbsp;&nbsp;消</button>
                </div>
            </div>
            <div class="row">

            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
</body>
</html>
