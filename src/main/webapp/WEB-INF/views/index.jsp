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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/select2.min.css">
<body>
<div class="page-header">
    <h1>Hello World!</h1>
</div>
<div class="row">
    <div class="col-lg-12">
        框架技术：<br><br>
        SpringMVC：前端控制器
        <br>
        <br>
        Spring：核心框架
        <br>
        <br>
        Mybatis：数据库框架
        <br>
        <br>
        Ehcache：缓存框架
        <br>
        <br>
        JCaptcha：验证码生成器
        <br>
        <br>
        SpringSecurity：安全（权限）框架
        <br>
        <br>
        BootStrap：前端响应式框架
        <br>
        //各类基于Bootstrap插件 f
    </div>

</div>



<%--页脚--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/plugin/bootstrap.min.js"></script>
</body>
</html>
