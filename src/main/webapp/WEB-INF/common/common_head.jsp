<%--
  集成开发工具: IntelliJ IDEA.
  创建者: wuxinzhe
  联系QQ: 124734668
  创建日期: 16/10/1
  创建时间: 下午8:01
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar_items">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">易租网</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar_items">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">租房</a></li>
                <li><a href="#">晒房</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id="loginOrRegister"><a href="<c:url value="/user/login"/>">注册/登录</a></li>
                <li id="account" class="dropdown hidden">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span>账户<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">账户信息</a></li>
                        <li><a href="#">我的钥匙</a></li>
                        <li><a href="#">我的房子</a></li>
                        <div class="divider"></div>
                        <li>
                            <form id="logout-form" role="form" action="/logout.do" method="post">
                                <sec:csrfInput/>
                                <button class="btn btn-link btn-block" type="button" onclick="logout()">退出</button>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

