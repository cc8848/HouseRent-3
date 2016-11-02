<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wuxinzhe
  联系QQ: 124734668
  创建日期: 16/10/1
  创建时间: 下午7:53
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/select2.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/common_head.jsp"/>
<%--head end--%>

<div class="container">
    <div class="white-divider-md"></div>
    <div class="hidden-xs" style="height: 100px"></div>
    <%--搜索框--%>
    <div class="row">
        <div class="hidden-xs col-sm-2"></div>
        <div class="col-xs-12 col-sm-8">
            <div class="input-group input-group-lg">
                <input type="text" class="form-control" placeholder="请输入搜索关键字...">
                <span class="input-group-btn ">
                 <button class="btn btn-primary" type="button">Go!</button>
            </span>
            </div>
        </div>
        <div class="hidden-xs col-sm-2"></div>
    </div>
    <div class="hidden-xs" style="height: 120px"></div>
    <div class="white-divider-md"></div>
    <%--产品介绍--%>
    <div class="row">
        <div class="col-sm-4">
            <div class="thumbnail">
                <img src="../../images/index/realHouse.png" alt="realHouse" class="img-responsive img-rounded" style="width: 100%">
                <div class="caption">
                    <h3>真实房源</h3>
                    <p>所有房源均采用线下真实可靠的渠道获取</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="thumbnail">
                <img src="../../images/index/wifiOpen.png" alt="realHouse" class="img-responsive img-rounded" style="width: 100%">
                <div class="caption">
                    <h3>真实房源</h3>
                    <p>所有房源均采用线下真实可靠的渠道获取</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="thumbnail">
                <img src="../../images/index/VR.png" alt="realHouse" class="img-responsive img-rounded" style="width: 100%">
                <div class="caption">
                    <h3>真实房源</h3>
                    <p>所有房源均采用线下真实可靠的渠道获取</p>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
