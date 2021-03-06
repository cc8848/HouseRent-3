<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/12/11
  Time: 下午5:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Showings · VR房库-注册</title>
    <sec:csrfMetaTags/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco/scojs.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/sco/sco.message.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h2>Showings · 注册账号
                    <a href="${pageContext.request.contextPath}/" class="btn btn-xs btn-primary pull-right">返回首页</a>
                </h2>
            </div>
        </div>
    </div>
    <div class="row">
        <form role="form" id="account">
            <div class="col-lg-3">
                <div class="form-group">
                    <label class="label label-primary control-label">账号信息</label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="username">手机号码</label>
                    <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-phone"></span></span>
                        <input type="text" class="form-control" id="username" name="username" placeholder="手机号码">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="password">密码</label>
                    <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        <input type="password" class="form-control" id="password" name="password"
                               placeholder="6-10位字母或数字的组合">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="check">再次确认密码</label>
                    <div class="input-group">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                        <input type="password" class="form-control" id="check" name="check" placeholder="请输入相同的密码">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="captcha">验证码</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-qrcode"></span>
                        </div>
                        <input type="text" id="captcha" class="form-control" name="captcha" placeholder="6位验证码">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="button" name="send">发送验证码</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3">
                <div class="form-group">
                    <label class="label label-primary control-label">个人信息</label>
                </div>
                <div class="form-group">
                    <label class="control-label" for="name">真实姓名</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <span class="glyphicon glyphicon-user"></span>
                        </div>
                        <input type="text" class="form-control" placeholder="真实姓名" id="name" name="name">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="license">身份证号</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="iconFont-xs">&#xe6d2;</i>
                        </div>
                        <input type="text" class="form-control" placeholder="18位证件号码" id="license" name="license">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label" for="sex">性别</label>
                    <select class="form-control" id="sex" name="sex">
                        <option value="0">-- 请选择 --</option>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="job">职业类型</label>
                    <select class="form-control" id="job" name="job">
                        <option value="0">-- 请选择 --</option>
                        <option value="1">公司任职</option>
                        <option value="2">独立经纪人</option>
                    </select>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="major">擅长的领域</label>
                    <select class="form-control" id="major" name="major">
                        <option value="0">-- 请选择 --</option>
                        <option value="1">改善购房</option>
                        <option value="2">投资购房</option>
                        <option value="3">刚需购房</option>
                    </select>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <label class="control-label" for="company">公司简称（6个汉字以内）</label>
                    <div class="input-group">
                        <div class="input-group-addon">
                            <i class="iconFont-xs">&#xe66d;</i>
                        </div>
                        <input type="text" class="form-control" placeholder="未就职可填写'独立经纪人'" id="company" name="company">
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="form-group">
                    <label class="label label-primary control-label">服务条款</label>
                </div>
                <div class="panel panel-default">
                    <div class="panel-body ">
                        <h4>网站注册服务条款</h4>
                    </div>
                    <ul class="list-group">
                        <li class="list-group-item pre-scrollable">
                            <c:import url="/WEB-INF/views/register_service.jsp"/>
                        </li>
                    </ul>
                    <div class="panel-footer">
                        <div class="checkbox" style="margin: 0">
                            <label class="control-label">
                                <input type="checkbox" id="agree" value="1"> 我同意
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <button type="button" class="btn btn-primary form-control" name="register">注册账号</button>
                </div>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.valid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.modal.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/soc/sco.message.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/register.js"></script>
</body>
</html>
