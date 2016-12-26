<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/26
  Time: 下午3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Showings · 房库 - 二手房发布</title>
    <sec:csrfMetaTags/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/sco/scojs.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/sco/sco.message.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/fileinput/file-input.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/icheckflat/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/switch/bootstrap-switch.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/home/account">二手房管理</a></li>
            <li class="active">二手房发布</li>
        </ol>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">二手房源信息发布</h3>
            </div>
            <div class="panel-body">
                <form role="form" id="hand_house_issue">
                    <div class="page-header">
                        <h4>基础信息</h4>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="control-label" for="price">房屋编号</label>
                                <div class="input-group">
                                    <span class="input-group-addon">#</span>
                                    <input type="text" class="form-control" id="serialNum" name="serialNum"
                                           placeholder="公司内部编号（非必输）">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="province">省份</label>
                                <select class="form-control" id="province" name="province"></select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="city">城市</label>
                                <select class="form-control" id="city" name="city"></select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="area">地区</label>
                                <select class="form-control" id="area" name="area"></select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="community">社区名称</label>
                                <div class="input-group">
                                    <span class="input-group-addon">#</span>
                                    <input type="text" class="form-control" id="community" name="community"
                                           placeholder="请填写社区名称">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="page-header">
                        <h4>价格信息</h4>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="control-label">产证满二 </label>
                                    <div class="switch" data-on="primary" data-off="info" data-on-label="是"
                                         data-off-label="否">
                                        <input type="checkbox" checked/>
                                    </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label>是否唯一</label>
                                <div class="input-group">
                                    <label class="control-label">是
                                        <input class="icheck" type="radio" value="0" name="onlyHousing">
                                    </label>
                                    <label class="control-label">否
                                        <input class="icheck" type="radio" value="1" name="onlyHousing">
                                    </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <label class="control-label" for="price">出售价格</label>
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input type="text" class="form-control" id="price" name="price" placeholder="请输入价格">
                                    <span class="input-group-addon">万</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="page-header">
                        <h4>详细信息</h4>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.valid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/file-input.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/zh.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/plugin/switch/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hand_house_issue.js"></script>
</body>
</html>
