<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wu
  联系QQ: 124734668
  创建日期: 16/9/29
  创建时间: 上午10:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Parameter_error</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
</head>
<body>
${requestScope.ex}


<link href="${pageContext.request.contextPath}/js/jquery-3.1.0.min.js">
<link href="${pageContext.request.contextPath}/js/bootstrap.js">
</body>
</html>
