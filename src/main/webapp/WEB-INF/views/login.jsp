<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wu
  联系QQ: 124734668
  创建日期: 16/9/22
  创建时间: 上午11:24
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
    <sec:csrfMetaTags/>
    <link href="/css/bootstrap.css" rel="stylesheet">

</head>
<body>

<div class="error">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }</div>
<form name='f' id='f' action="<c:url value="/login.do" />" method='POST'>
    <table style="width: 70%">
        <tr>
            <td style="text-align: right; width: 25%">用户名称 :</td>
            <td style="text-align: left">
                <input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td style="text-align: right">密码 :</td>
            <td style="text-align: left">
                <input type='password' name='password'/>
            </td>
        </tr>
        <tr>
            <td style="text-align: right">
                <label for="captcha"> 验证码: </label></td>
            <td>
                <input type="text" id="captcha" name="captcha"/>
                <img src="<c:url value="/jcaptcha.jpg"/>"
                     href="javascript:refreshCaptcha()" border="1"/>
            </td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <sec:csrfInput/>
                <input type="submit" name="submit" value="登录"/>
            </td>
        </tr>
    </table>
</form>

<script type="text/javascript">
    document.f.username.focus();
    if ('${message}' == 1) {
        alert("用户名或密码错误");
    }
    function refreshCaptcha() {
        $('#captchaImg').hide().attr(
                'src',
                '<c:url value="/jcaptcha.jpg"/>' + '?' + Math
                        .floor(Math.random() * 100)).fadeIn();
    }
</script>
<link href="/js/jquery-3.1.0.min.js">
<link href="/js/bootstrap.js">
</body>

</html>
