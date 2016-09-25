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
    <link href="/css/bootstrap.css" rel="stylesheet">

</head>
<body>

<center>
    <div class="error">
        ${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message }</div>
    <form name='f' id='f'
          action='<%=request.getContextPath()%>/j_spring_security_check'
          method='POST'>
        <table style="width: 50%">
            <tr>
                <td style="text-align: right; width: 35%">用户名称 :</td>
                <td style="text-align: left">
                    <input type='text' name='j_username' value=''></td>
            </tr>
            <tr>
                <td style="text-align: right">密码 :</td>
                <td style="text-align: left">
                    <input type='password' name='j_password'/></td>
            </tr>
            <tr>
                <td style="text-align: right">
                    <label for="j_captcha"> 验证码: </label></td>
                <td>
                    <input type='text' name='j_captcha' class="required"
                           size='5'/>
                    <img id="imageF" src="<c:url value="/resource/image.jsp"/>"/>
                    <a href="#" id="flashImage">看不清楚换一张</a>

                </td>
            </tr>
            <tr>
                <td align="right"><input id="_spring_security_remember_me"
                                         name="_spring_security_remember_me" type="checkbox" value="true"/>

                </td>
                <td><label for="_spring_security_remember_me">Remember Me?</label>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input
                        type="submit" name="submit" value="登录"/></td>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript">

    document.f.j_username.focus();
    if ('${message}' == 1) {
        alert("用户名或密码错误");
    }

    jQuery(function ($) {


        $("#flashImage").click(function () {

            $('#imageF').hide().attr('src', '<c:url value="/resource/image.jsp"/>' + '?' + Math.floor(Math.random() * 100)).fadeIn();
        });
    });


</script>
<link href="/js/jquery-3.1.0.min.js">
<link href="/js/bootstrap.js">
</body>

</html>
