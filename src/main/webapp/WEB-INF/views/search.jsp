<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/1
  Time: 上午8:53
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
        <div id="left-side" class="col-xs-12 col-sm-4 col-md-3">
            <div id="search-term">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">搜索条件</h3>
                    </div>
                    <div class="panel-body">
                        <!--地区-->
                        <div id="address">
                            <div class="input-group input-group-sm">
                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-default" data-toggle="collapse"
                                            href="#collapseOne">
                                        <span class="caret"></span>
                                    </button>
                                </div>
                                <input id="area-input" type="text" class="form-control" placeholder="请选择地区" readonly>
                            </div>
                            <div id="collapseOne" class="panel-collapse collapse">
                                <form class="navbar-form form-group">
                                    <select id="province" class="select2 form-control" style="width: 100%"></select>
                                    <div class="white-divider-xs"></div>
                                    <select id="city" class="select2 form-control" style="width: 100%"></select>
                                    <div class="white-divider-xs"></div>
                                    <select id="area" class="select2 form-control" style="width: 100%"></select>
                                    <div class="white-divider-xs"></div>
                                    <button id="address-button" type="button" class="btn btn-primary btn-block"
                                            data-toggle="collapse" href="#collapseOne">确定
                                    </button>
                                </form>
                            </div>
                        </div><!--地区 end-->
                        <div class="white-divider-sm"></div>
                        <!--社区-->
                        <div id="community">
                            <div class="input-group input-group-sm">
                                <div class="input-group-btn">
                                    <button type="button" class="btn btn-default" data-toggle="collapse"
                                            href="#collapseCommunity">
                                        <span class="caret"></span>
                                    </button>
                                </div>
                                <input id="community-input" type="text" class="form-control" placeholder="请选择社区"
                                       readonly>
                            </div>
                            <div id="collapseCommunity" class="panel-collapse collapse">
                                <form class="navbar-form form-group">
                                    <select id="communitySelect" class="select2 form-control"
                                            style="width: 100%"></select>
                                    <div class="white-divider-xs"></div>
                                    <button id="community-button" type="button" class="btn btn-primary btn-block"
                                            data-toggle="collapse" href="#collapseOne">确定
                                    </button>
                                </form>
                            </div>
                        </div><!--社区 end-->
                        <div class="white-divider-sm"></div>
                        <!--租金-->
                        <div id="price" class="input-group input-group-sm">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle"
                                        data-toggle="dropdown"><span
                                        class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a id="price-1" href="#">0-500</a></li>
                                    <li><a id="price-2" href="#">500-1000</a></li>
                                    <li><a id="price-3" href="#">1000-2000</a></li>
                                    <li><a id="price-4" href="#">2000-4000</a></li>
                                    <li><a id="price-5" href="#">4000 以上</a></li>
                                    <li class="divider"></li>
                                    <li><a id="price-6" href="#">不限</a></li>
                                </ul>
                            </div>
                            <input id="price-input" type="text" class="form-control" placeholder="请选择租金" readonly>
                            <span class="input-group-addon">¥</span>
                        </div><!--租金 end-->
                        <div class="white-divider-sm"></div>
                        <!--厅室-->
                        <div id="room" class="input-group input-group-sm">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle"
                                        data-toggle="dropdown"><span
                                        class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a id="room-1" href="#">一室</a></li>
                                    <li><a id="room-2" href="#">二室</a></li>
                                    <li><a id="room-3" href="#">三室</a></li>
                                    <li><a id="room-4" href="#">四室</a></li>
                                    <li><a id="room-5" href="#">四室以上</a></li>
                                    <li class="divider"></li>
                                    <li><a id="room-6" href="#">不限</a></li>
                                </ul>
                            </div>
                            <input id="room-input" type="text" class="form-control" placeholder="请选择厅室" readonly>
                        </div><!--厅室 end-->
                        <div class="white-divider-sm"></div>
                        <!--租赁模式-->
                        <div id="rentMode" class="input-group input-group-sm">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle"
                                        data-toggle="dropdown"><span
                                        class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a id="rentMode-1" href="#">整套出租</a></li>
                                    <li><a id="rentMode-2" href="#">单间出租</a></li>
                                    <li><a id="rentMode-3" href="#">床位出租</a></li>
                                    <li class="divider"></li>
                                    <li><a id="rentMode-4" href="#">不限</a></li>
                                </ul>
                            </div>
                            <input id="rentMode-input" type="text" class="form-control" placeholder="请选择方式" readonly>
                        </div><!--厅室 end-->
                        <div class="white-divider-sm"></div>
                        <div class="btn-group btn-group-justified">
                            <div class="btn-group">
                                <button id="recommendHouse" type="button" class="btn btn-primary" data-toggle="tab"
                                        href="#recommend">好房推荐
                                </button>
                            </div>
                            <div class="btn-group">
                                <button id="searchButton" type="button" class="btn btn-primary" data-toggle="tab"
                                        href="#list">
                                    按需搜索
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="hidden-xs">
                <div class="thumbnail">
                    <img class="img-responsive img-rounded" data-src="holder.js/300x300"
                         src="../../images/index/realHouse.png" alt="...">
                    <div class="caption">
                        <h3>真实房源</h3>
                        <p>所有房源信息均来自线下真实的信息渠道，确保房屋信息真实准确，更新及时！</p>
                        <p>
                            <a href="#" class="btn btn-primary btn-block" role="button">提交房源</a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="hidden-xs">
                <div class="thumbnail">
                    <img class="img-responsive img-rounded" data-src="holder.js/300x300"
                         src="../../images/index/wifiOpen.png" alt="...">
                    <div class="caption">
                        <h3>WiFi开门</h3>
                        <p>手机APP即可开门，无需换锁，无需携带笨重的机械钥匙，APP轻轻一点即可打开房门。</p>
                        <p><a href="#" class="btn btn-primary btn-block" role="button">免费安装</a></p>
                    </div>
                </div>
            </div>
            <div class="hidden-xs">
                <div class="thumbnail">
                    <img class="img-responsive img-rounded" data-src="holder.js/300x300" src="../../images/index/VR.png"
                         alt="...">
                    <div class="caption">
                        <h3>VR看房</h3>
                        <p>采用最新的VR技术，每一次摄影均通过工作人员专业的VR拍摄，无需走街串巷即可在手机上享受身临其境的看房体验！</p>
                        <p><a href="#" class="btn btn-primary btn-block" role="button">上门拍摄</a></p>
                    </div>
                </div>
            </div>
        </div>
        <div id="right-side" class="col-xs-12 col-sm-8 col-md-9">
            <!--好房列表-->
            <div id="house-list">
                <div id="house-tab">
                    <div class="tab-content">
                        <!--好房推荐-->
                        <div id="recommend" class="tab-pane active">
                            <div class="panel panel-default">
                                <div id="recommendTittle" class="panel-heading">
                                    <h3 class="panel-title">好房推荐
                                        <nav class="pull-right">
                                            <ul class="pagination pagination-sm" style="margin: -5px 0px 0px 0px">
                                                <li><a href="#">&laquo;</a></li>
                                                <li><a href="#">1</a></li>
                                                <li><a href="#">2</a></li>
                                                <li><a href="#">3</a></li>
                                                <li><a href="#">4</a></li>
                                                <li><a href="#">5</a></li>
                                                <li><a href="#">&raquo;</a></li>
                                            </ul>
                                        </nav>
                                    </h3>
                                </div>
                            </div>
                        </div>
                        <!--房屋搜索-->
                        <div id="list" class="tab-pane">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/select2.min.js"></script>
<script type="text/javascript" src="../../js/template.js"></script>
<script type="text/javascript" src="../../js/index.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
<%--模板--%>
<script id="recommendList" type="text/html">
    <ul class="list-group">
        {{each houseList as house index}}
        <a href="{{house.id}}" class="list-group-item container-fluid">
            <div class="col-md-2 hidden-xs hidden-sm">
                <img src="{{house.thumbnailPath}}" alt=""
                     class="img-responsive img-thumbnail"/>
            </div>
            <div class="col-md-10 col-xs-12 ">
                <h4 class="list-group-item-heading">{{house.name}}
                    <label class="label label-danger pull-right hidden-xs">{{house.expectRent}}元/月</label>
                </h4>
                <div class="white-divider-md"></div>
                <div class="list-group-item-text">
                    <span class="glyphicon glyphicon-home"></span>
                    <span>&nbsp;{{house.community.name}}</span>
                    <label class="label label-success pull-right">{{house.houseStatus.statusName}}</label>
                </div>
                <div class="white-divider-md"></div>
                <div class="list-group-item-text">
                    <label class="label label-danger">{{house.decorationType.name}}</label>
                    {{if house.haveKitchen}}
                    <label class="label label-primary">独立厨房</label>
                    {{/if}}
                    {{if house.haveBalcony}}
                    <label class="label label-warning">独立阳台</label>
                    {{/if}}
                </div>
                <div class="white-divider-lg"></div>
                <div class="list-group-item-text">
                    <span>{{house.areaNumber}}㎡</span>/
                    <span>{{house.houseLayout.name}}</span>/
                    <span>{{house.decorationType.name}}</span>/
                    <span>{{house.floor}}层</span>
                    <label class="label label-danger pull-right visible-xs">{{house.expectRent}}元/月</label>
                    <div class="pull-right hidden-xs">
                        {{each house.rentModeList as rentMode index}}
                        <span class="label label-default" style="margin-left: 10px">
                        {{rentMode.name}}
                        </span>
                        {{/each}}
                    </div>
                </div>
            </div>
        </a>
        {{/each}}
    </ul>
</script>
</body>
</html>

