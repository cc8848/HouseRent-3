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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/icheckflat/red.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fileinput.min.css">
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
                        <c:when test="${sysMenu.href=='issue-info'}">
                            <div id="${sysMenu.href}" class="tab-pane">
                                <div class="panel panel-primary">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">房源信息</h3>
                                    </div>
                                    <div class="panel-body">
                                        <form role="form">
                                            <div class="form-group row">
                                                <div class="col-lg-12">
                                                    <label for="tittle">房屋标题</label>
                                                    <input id="tittle" type="text" class="form-control"
                                                           placeholder="标题长度不超过15个中文">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-12">
                                                    <label for="desc">描述信息</label>
                                                    <input id="desc" type="text" class="form-control"
                                                           placeholder="描述信息不超过30个中文">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-6">
                                                    <label for="price">售价</label>
                                                    <div class="input-group">
                                                        <span class="input-group-addon">￥</span>
                                                        <input id="price" type="text" class="form-control"
                                                               placeholder="请输入整套销售价，单价会根据面积自动计算">
                                                    </div>

                                                </div>
                                                <div class="col-lg-6">
                                                    <label for="floor">楼层</label>
                                                    <div class="input-group">
                                                        <input id="floor" type="text" class="form-control"
                                                               placeholder="房屋所在楼层">
                                                        <span class="input-group-addon">层</span>
                                                    </div>

                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-6">
                                                    <label for="floorArea">建筑面积</label>
                                                    <div class="input-group">
                                                        <input id="floorArea" type="text" class="form-control"
                                                               placeholder="面积保留小数点后2位">
                                                        <div class="input-group-addon">㎡</div>
                                                    </div>

                                                </div>
                                                <div class="col-lg-6">
                                                    <label for="poolArea">公摊面积</label>
                                                    <div class="input-group">
                                                        <input id="poolArea" type="text" class="form-control"
                                                               placeholder="面积保留小数点后2位">
                                                        <span class="input-group-addon">㎡</span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-3">
                                                    <label for="face">朝向</label>
                                                    <select id="face"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>
                                                <div class="col-lg-3">
                                                    <label for="decoration">装修程度</label>
                                                    <select id="decoration"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>
                                                <div class="col-lg-3">
                                                    <label for="layout">室内格局</label>
                                                    <select id="layout"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>
                                                <div class="col-lg-3">
                                                    <label for="status">期房/现房</label>
                                                    <select id="status"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-4">
                                                    <label for="province">省份</label>
                                                    <select id="province"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>
                                                <div class="col-lg-4">
                                                    <label for="city">城市</label>
                                                    <select id="city"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>
                                                <div class="col-lg-4">
                                                    <label for="area">区域</label>
                                                    <select id="area"
                                                            class="select2 form-control" style="width: 100%"></select>
                                                </div>

                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-12">
                                                    <label for="address">具体地址</label>
                                                    <input id="address" type="text" class="form-control"
                                                           placeholder="请输入详细地址">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <div class="col-lg-12">
                                                    <label for="picture">图片上传</label>
                                                    <input id="vrMode" class="radio radio-inline" type="radio"
                                                           name="viewMode" value="VR模式">
                                                    <label for="vrMode">VR模式</label>
                                                    <input id="morePic" class="radio radio-inline" type="radio"
                                                           name="viewMode" value="多图模式">
                                                    <label for="morePic">多图模式</label>
                                                    <div class="input-group">
                                                        <input id="picture" type="text" class="form-control">
                                                        <span class="input-group-btn">
                                                            <input class="btn btn-primary" type="file" value="添加图片"/>
                                                        </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
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
<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/canvas-to-blob.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/sortable.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/purify.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/fileinput.min.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/theme.js"></script>
<script src="${pageContext.request.contextPath}/js/fileup/zh.js"></script>
<script src="${pageContext.request.contextPath}/js/template.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/location.js"></script>
<script src="${pageContext.request.contextPath}/js/home.js"></script>
<script id="auditing-table-content" type="text/html">
    {{each list as userSeller}}
    <tr>
        <td></td>
        <td>{{userSeller.id}}</td>
        <td>{{userSeller.sysUsers.name}}</td>
        <td>{{userSeller.sysUsers.username}}</td>
        <td><input type="checkbox" class="checkbox"></td>
    </tr>
    {{/each}}
</script>
</body>
</html>
