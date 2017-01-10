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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/sco/scojs.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/sco/sco.message.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/jcrop/jquery.Jcrop.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/plugin/fileinput/file-input.min.css">
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
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">账户信息
                    <div class=" btn-group-xs pull-right" style="margin-top: -2px;">
                        <button class="btn btn-primary" type="button" name="upload">上传头像</button>
                        <button class="btn btn-primary" type="button" name="modify">修改信息</button>
                    </div>
                </h3>
            </div>
            <div class="panel-body">
                <form role="form" id="account">
                    <div class="row">
                        <div class="col-sm-4">
                            <img src="${pageContext.request.contextPath}${portrait_src}"
                                 class="img-thumbnail pic-align-center">
                        </div>
                        <div class="white-divider-md visible-xs"></div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="name">真实姓名</label>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <span class="glyphicon glyphicon-user"></span>
                                    </div>
                                    <input type="text" class="form-control" placeholder="真实姓名" id="name" name="name"
                                           value="${user.name}" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="license">身份证号</label>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="iconFont-xs">&#xe6d2;</i>
                                    </div>
                                    <input type="text" class="form-control" placeholder="18位证件号码" id="license"
                                           name="license" value="${user.license}" disabled>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="sex">性别</label>
                                <select class="form-control" id="sex" name="sex" disabled>
                                    <option value="0">-- 请选择 --</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                                <span class="help-block"></span>
                            </div>

                        </div>
                        <div class="col-sm-4">
                            <div class="form-group">
                                <label class="control-label" for="job">职业类型</label>
                                <select class="form-control" id="job" name="job" disabled>
                                    <option value="0">-- 请选择 --</option>
                                    <option value="1">公司任职</option>
                                    <option value="2">独立经纪人</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="major">擅长的领域</label>
                                <select class="form-control" id="major" name="major" disabled>
                                    <option value="0">-- 请选择 --</option>
                                    <option value="1">改善购房</option>
                                    <option value="2">投资购房</option>
                                    <option value="3">刚需购房</option>
                                </select>
                                <span class="help-block"></span>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="companyAbbr">公司简称（6个汉字以内）</label>
                                <div class="input-group">
                                    <div class="input-group-addon">
                                        <i class="iconFont-xs">&#xe66d;</i>
                                    </div>
                                    <input type="text" class="form-control" placeholder="未就职可填写'独立经纪人'" id="companyAbbr"
                                           name="companyAbbr" value="${user.companyAbbr}" disabled>
                                </div>
                            </div>
                            <div class="white-divider-md"></div>
                            <div class="form-group hidden">
                                <div class="btn-group btn-group-justified pull-right">
                                    <div class="btn-group">
                                        <button type="button" name="modifySubmit" class="btn btn-primary">提交修改</button>
                                    </div>
                                    <div class="btn-group">
                                        <button type="button" name="modifyCancel" class="btn btn-primary">取消修改</button>
                                    </div>
                                </div>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jcrop/jquery.Jcrop.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.valid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/template.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/file-input.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/fileup/zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/account.js"></script>
<script type="text/javascript">
    $(document).ready(setSelect);
    function setSelect() {
        if (${user.sex}) {
            $('#sex').val("1");
        } else {
            $('#sex').val("2");
        }
        $('#job').val(${user.job});
        $('#major').val(${user.major});
    }
</script>
<script id="portraitUpload" type="text/html">
    <div style="padding: 10px 20px">
        <form role="form" enctype="multipart/form-data" method="post">
            <div class="embed-responsive embed-responsive-16by9">
                <div class="embed-responsive-item pre-scrollable">
                    <img alt="" src="${pageContext.request.contextPath}/img/showings.jpg" id="cut-img"
                         class="img-responsive img-thumbnail"/>
                </div>
            </div>
            <div class="white-divider-md"></div>
            <input type="file" name="imgFile" id="fileUpload"/>
            <div class="white-divider-md"></div>
            <div id="alert" class="alert alert-danger" role="alert"></div>
            <input type="hidden" id="x" name="x"/>
            <input type="hidden" id="y" name="y"/>
            <input type="hidden" id="w" name="w"/>
            <input type="hidden" id="h" name="h"/>
        </form>
    </div>
</script>
</body>
</html>
