<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/14
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="errorModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 id="error-modal-tittle" class="modal-title">错误提示</h4>
            </div>
            <div class="modal-body">
                <p id="error-modal-message"></p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<div id="confirmModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span
                        class="sr-only">Close</span></button>
                <h4 id="confirm-modal-tittle" class="modal-title">确认提示</h4>
            </div>
            <div class="modal-body">
                <p id="confirm-modal-message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">取消</button>
                <button id="confirm-button" type="button" class="btn btn-danger" data-dismiss="modal">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<nav class="navbar navbar-fixed-top navbar-default" role="navigation" style="margin-bottom: 0">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#navbar_items">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Showings · VR房库</a>
            </div>
            <div id="navbar_items" class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-th-list"></span>&nbsp;更新日志</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-leaf"></span>&nbsp;首英百科</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-phone"></span>&nbsp;微信公众号</a></li>
                    <c:choose>
                        <c:when test="${sessionScope.user==null}">
                            <li>
                                <a href="${pageContext.request.contextPath}/user/login" class="visible-xs">
                                    <span class="glyphicon glyphicon-log-in"></span> &nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;
                                </a>
                                <form class="navbar-form hidden-xs" role="form">
                                    <a href="${pageContext.request.contextPath}/user/login"
                                       class="btn btn-default btn-sm">
                                        &nbsp;&nbsp;登&nbsp;&nbsp;录&nbsp;&nbsp;</a>
                                </form>
                            </li>
                        </c:when>
                        <c:when test="${sessionScope.user!=null}">
                            <li>
                                <a href="#" class="dropdown-toggle"
                                   data-toggle="dropdown">你好,&nbsp;${sessionScope.user.name}
                                    <span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="${pageContext.request.contextPath}/user/home">我的账户</a></li>
                                    <li class="divider"></li>
                                    <form id="logout-form" role="form"
                                          action="${pageContext.request.contextPath}/logout.do" method="post">
                                        <sec:csrfInput/>
                                        <button id="logout" class="btn btn-link btn-block" type="submit"
                                                onclick="logout()">退出
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
</nav>
