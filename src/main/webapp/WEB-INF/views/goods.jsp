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
<div class="white-divider-md"></div>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h3>简约干净的小房间，坐北朝南面阳！
                <small>你值得拥有！</small>
            </h3>
        </div>
    </div>
    <div class="row">
        <%--VR图--%>
        <div class="col-xs-6">
            <div class="embed-responsive embed-responsive-4by3">
                <div id="vr" class="embed-responsive-item">

                </div>
            </div>
        </div>
        <%--房屋说明--%>
        <div class="col-xs-6">
            <%--<c:if test="">--%>
            <div class="btn-group btn-group-sm">
                <%--<c:forEach items="" var="">--%>
                <button type="button" class="btn btn-default ">Left</button>
                <%--</c:forEach>--%>
            </div>
            <%--</c:if>--%>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <ul>
            <li>ID:${requestScope.house.id}</li>
            <li>Name:${requestScope.house.name}</li>
            <li>expectRent:${requestScope.house.expectRent}</li>
        </ul>
    </div>
</div>


<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/tour.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/goods.js"></script>
<script>
    embedpano({
        swf: "../../vtour/tour.swf",
        xml: "../../vtour/${requestScope.house.id}/tour.xml",
        target: "vr",
        html5: "auto",
        mobilescale: 1.0,
        passQueryParameters: true
    });
</script>
</body>
</html>
