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

<nav class="navbar navbar-fixed-top navbar-inverse" role="navigation" style="margin-bottom: 0">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                            data-target="#navbar_items">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Showings · 房库</a>
                </div>
                <div id="navbar_items" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-list"></span>&nbsp;查看房单</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-send"></span>&nbsp;发布房源</a></li>
                        <c:choose>
                            <c:when test="${sessionScope.user==null}">
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/login" class="visible-xs">
                                        <span class="glyphicon glyphicon-log-in"></span> &nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;
                                    </a>
                                    <form class="navbar-form hidden-xs" role="form">
                                        <a href="${pageContext.request.contextPath}/user/login"
                                           class="btn btn-default btn-sm">
                                            <span class="glyphicon glyphicon-log-in"></span> &nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;
                                        </a>
                                    </form>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/user/login" class="visible-xs">
                                        <span class="glyphicon glyphicon-edit"></span> &nbsp;注&nbsp;&nbsp;册&nbsp;&nbsp;
                                    </a>
                                    <form class="navbar-form hidden-xs" role="form">
                                        <a href="${pageContext.request.contextPath}/user/login"
                                           class="btn btn-default btn-sm">
                                            <span class="glyphicon glyphicon-edit"></span> &nbsp;&nbsp;注&nbsp;&nbsp;册&nbsp;&nbsp;
                                        </a>
                                    </form>
                                </li>
                            </c:when>
                            <c:when test="${sessionScope.user!=null}">
                                <li>
                                    <a href="#" class="dropdown-toggle"
                                       data-toggle="dropdown">你好,&nbsp;${sessionScope.user.name}
                                        <span class="caret"></span></a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li class="divider"></li>
                                        <form id="logout-form" role="form"
                                              action="${pageContext.request.contextPath}/logout.do" method="post">
                                            <sec:csrfInput/>
                                            <button class="btn btn-link btn-block" type="button" onclick="logout()">退出
                                            </button>
                                        </form>
                                    </ul>
                                </li>
                            </c:when>
                        </c:choose>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>

