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
<link rel="stylesheet" href="../../css/icheckflat/blue.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/common_head.jsp"/>
<%--head end--%>
<div class="white-divider-md"></div>
<div class="container">
    <%--标题部分--%>
    <div class="row">
        <div class="col-xs-12 page-header">
            <h3>${requestScope.house.name}
                <small>你值得拥有！</small>
                <div class="btn-toolbar pull-right" role="toolbar">
                    <div class="btn-group">
                        <button type="button" class="btn btn-warning">
                            <span class="glyphicon glyphicon-star"></span>
                            关注
                        </button>
                    </div>
                    <div class="btn-group visible-lg">
                        <button type="button" class="btn btn-warning">
                            <span class="glyphicon glyphicon-qrcode "></span>
                        </button>
                        <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                            <span class="sr-only">Toggle Dropdown</span>
                        </button>
                        <ul class="dropdown-menu dropdown-menu-right" role="menu">
                            <li><a href="#">扫码访问手机版</a></li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <img src="../../images/house/thumbnail/gethouseqr.png"
                                         class="img-responsive img-thumbnail">
                                </a>
                            </li>
                            <li class="white-divider-sm"></li>
                        </ul>
                    </div>
                </div>
            </h3>

        </div>
    </div>
    <div class="row">
        <%--VR图--%>
        <div class="col-sm-6">
            <div class="embed-responsive embed-responsive-4by3">
                <div id="vr" class="embed-responsive-item">
                </div>
            </div>
        </div>
        <div class="visible-xs white-divider-md"></div>
        <%--房屋说明--%>
        <div class="col-sm-6">
            <ul class="nav nav-tabs">
                <li id="share-tab" class="active">
                    <a href="#share-content" data-toggle="tab">分租</a>
                </li>
                <li id="whole-tab">
                    <a href="#whole-content" data-toggle="tab">整租</a>
                </li>
                <li id="sublet-tab">
                    <a href="#sublet-content" data-toggle="tab">转租</a>
                </li>
            </ul>
            <div class="white-divider-md"></div>
            <div class="tab-content">
                <div id="share-content" class="tab-pane active">
                    <div class="input-check">
                        <input id="check" type="checkbox">&nbsp;
                        <label for="check" class="label label-danger">01号：￥2000/月</label>
                    </div>
                    <div class="input-check">
                        <input id="check2" type="checkbox">&nbsp;
                        <label for="check2" class="label label-danger">02号：￥2000/月</label>
                    </div>
                    <div class="input-check">
                        <input id="check3" type="checkbox">&nbsp;
                        <label for="check3" class="label label-danger">03号：￥2000/月</label>
                    </div>
                    <div class="input-check">
                        <input id="check4" type="checkbox">&nbsp;
                        <label for="check4" class="label label-danger">04号：￥2000/月</label>
                    </div>
                    <div class="input-check">
                        <input id="check5" type="checkbox">&nbsp;
                        <label for="check5" class="label label-danger">05号：￥2000/月</label>
                    </div>
                </div>
                <div id="whole-content" class="tab-pane">
                    整租
                </div>
                <div id="sublet-content" class="tab-pane">
                    转租
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <ul>
            <li>ID:${requestScope.house.id}</li>
            <li>expectRent:${requestScope.house.expectRent}</li>
        </ul>
    </div>
</div>


<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/icheck.min.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<script type="text/javascript" src="../../js/goods.js"></script>
<script type="text/javascript" src="../../js/tour.js"></script>
<script>

</script>

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
