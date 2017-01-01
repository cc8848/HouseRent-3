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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/select/select2.min.css">
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
                <form role="form" id="hand_house_issue" enctype="multipart/form-data">
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
                    <div class="row">
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label>房屋户型</label>
                                <div class="input-group">
                                    <input type="number" min="0" value="0" class="form-control" id="roomQuantity"
                                           name="roomQuantity">
                                    <span class="input-group-addon">室</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label>&nbsp;</label>
                                <div class="input-group">
                                    <input type="number" min="0" value="0" class="form-control" id="hallQuantity"
                                           name="hallQuantity">
                                    <span class="input-group-addon">厅</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label>&nbsp;</label>
                                <div class="input-group">
                                    <input type="number" min="0" value="0" class="form-control" id="bathroomQuantity"
                                           name="bathroomQuantity">
                                    <span class="input-group-addon">卫</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="control-label" for="type">房屋类型</label>
                                <select class="form-control" id="type" name="type"></select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="control-label" for="decoration">装修类型</label>
                                <select class="form-control" id="decoration" name="decoration"></select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-2">
                            <div class="form-group">
                                <label class="control-label" for="orientation">房屋朝向</label>
                                <select class="form-control" id="orientation" name="orientation"></select>
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="currentFloor">楼层</label>
                                <div class="input-group">
                                    <input type="number" min="1" value="1" class="form-control" id="currentFloor"
                                           name="currentFloor">
                                    <span class="input-group-addon">楼</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="totalFloor">&nbsp;</label>
                                <div class="input-group">
                                    <span class="input-group-addon">共</span>
                                    <input type="number" min="1" value="1" class="form-control" id="totalFloor"
                                           name="totalFloor">
                                    <span class="input-group-addon">层</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="floorArea">建筑面积</label>
                                <div class="input-group">
                                    <input type="number" min="0" value="0" class="form-control" id="floorArea"
                                           name="floorArea">
                                    <span class="input-group-addon">㎡</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="buildAge">建造年代</label>
                                <div class="input-group">
                                    <input type="number" min="1988" value="1999" class="form-control" id="buildAge"
                                           name="buildAge">
                                    <span class="input-group-addon">年</span>
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
                                <label class="control-label" for="price">出售价格</label>
                                <div class="input-group">
                                    <span class="input-group-addon">￥</span>
                                    <input type="text" class="form-control" id="price" name="price" placeholder="请输入价格">
                                    <span class="input-group-addon">万</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="propertyRightsForTwoYears">产权证是否已经满两年？</label>
                                <div class="input-group">
                                    <input name="propertyRightsForTwoYears" id="propertyRightsForTwoYears"
                                           type="checkbox"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label class="control-label" for="onlyHousing">是否是唯一性住房？</label>
                                <div class="input-group">
                                    <input name="onlyHousing" id="onlyHousing" type="checkbox"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">

                    </div>
                    <div class="row">

                    </div>
                    <div class="page-header">
                        <h4>详细信息</h4>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="alert alert-danger" role="alert">
                                不能出现任意联系方式（包含但不限于QQ、微信、电话、网址、MSN、邮箱等）；<br>请勿添加其他小区广告，请勿输入与出售房源无关内容或非法信息。
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="control-label" for="title">房屋标题</label>
                                <div class="input-group">
                                    <span class="input-group-addon">#</span>
                                    <input type="text" class="form-control" id="title" name="title">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="houseDetails">房屋详情</label>
                                <textarea id="houseDetails" role="textbox" class="form-control" rows="6"></textarea>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="ownerMentality">房东心态</label>
                                <textarea id="ownerMentality" role="textbox" class="form-control" rows="6"></textarea>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="supportingFacility">小区配套</label>
                                <textarea id="supportingFacility" role="textbox" class="form-control"
                                          rows="6"></textarea>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-3">
                            <div class="form-group">
                                <label for="professionalService">服务介绍</label>
                                <textarea id="professionalService" role="textbox" class="form-control"
                                          rows="6"></textarea>
                                <span class="help-block"></span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#" data-toggle="tab" role="tab">多图模式</a>
                                </li>
                                <li role="presentation" ><a href="#" data-toggle="tab" role="tab">VR全景模式</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <input id="thumbnail" name="thumbnail" type="file" multiple>
                                <span class="help-block"></span>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <input id="panorama" name="panorama" type="file">
                                <span class="help-block"></span>
                            </div>
                        </div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/select2/select2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/file-input.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/zh.js"></script>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/plugin/switch/bootstrap-switch.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hand_house_issue.js"></script>
</body>
</html>
