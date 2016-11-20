<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wu
  联系QQ: 124734668
  创建日期: 16/9/29
  创建时间: 上午11:04
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
${requestScope.ex}


<link href="${pageContext.request.contextPath}/js/jquery.js">
<link href="${pageContext.request.contextPath}/js/bootstrap.min.js">
</body>
</html>
