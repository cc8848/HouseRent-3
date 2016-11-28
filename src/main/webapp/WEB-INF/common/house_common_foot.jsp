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

<nav class="navbar navbar-fixed-bottom navbar-inverse" role="navigation" style="margin-bottom: 0">
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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Showings · ${house.community.name}</a>
                </div>
                <div id="navbar_items" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="#view">VR全景</a></li>
                        <li><a href="#activity">优惠活动</a></li>
                        <li><a href="#info">楼盘信息</a></li>
                        <li><a href="#map">地图周边</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-list"></span>&nbsp;查看房单</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-list"></span>&nbsp;小区信息</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>

