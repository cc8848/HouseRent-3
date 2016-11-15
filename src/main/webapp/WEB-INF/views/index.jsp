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
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/select2.min.css">
<link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../../css/common.css">
<body>
<%--head start--%>
<c:import url="/WEB-INF/common/showings_common_head.jsp"/>
<%--head end--%>
<div class="jumbotron index-bg-top">
    <div class="container well-lg">
        <h1 class="text-right font-shadow-black"><strong>重新定义看房方式</strong></h1>
        <div class="white-divider-md"></div>
        <p class="text-right"><strong>Redefine the Way of Showings</strong></p>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <div class="white-divider-md"></div>
        <p class="text-right">
            <a class="btn btn-success btn-lg" href="#" role="button"><span class="glyphicon glyphicon-edit"></span>&nbsp;免费注册</a>
            <a class="btn btn-primary btn-lg" href="/house/detail?houseID=1" role="button"><span
                    class="glyphicon glyphicon-camera"></span>&nbsp;在线体验</a>
        </p>
    </div>
</div>
<div class="jumbotron index-bg-gray">
    <div class="container text-center">
        <div class="col-lg-2"></div>
        <div class="col-lg-2 ">
            <i class="index-iconfont-lg">&#xe645;</i>
            <p>VR看房</p>
        </div>
        <div class="col-lg-2">
            <i class="index-iconfont-lg">&#xe63f;</i>
            <p>轻松分发</p>
        </div>
        <div class="col-lg-2">
            <i class="index-iconfont-lg">&#xe694;</i>
            <p>附近周边</p>
        </div>
        <div class="col-lg-2">
            <i class="index-iconfont-lg">&#xe643;</i>
            <p>海量房源</p>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div class="jumbotron index-bg-bottom">
    <div class="container">
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div class="page-header">
                <h2 class="font-shadow-white text-center"><strong>每个房产业务的场合，我们都精益求精</strong></h2>
            </div>
            <div id="carousel-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active ">
                        <img src="${pageContext.request.contextPath}/images/index/background.jpg" alt="..."
                             class="pic-align-center img-rounded">
                        <div class="carousel-caption">
                            ...
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/images/index/background.jpg" alt="..."
                             class="pic-align-center img-rounded">
                        <div class="carousel-caption">
                            ...
                        </div>
                    </div>
                </div>

                <!-- Controls -->
                <a class="left carousel-control" href="#carousel-generic" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#carousel-generic" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
    <div class="col-lg-1"></div>
</div>
<div class="jumbotron index-bg-white">
    <div class="container">
        <div class="col-lg-5">
            <h2><i class="index-iconfont-md">&#xe645;</i>&nbsp;VR全景在线看房</h2>
            <p>
                <small>身临其境的VR看房体验，多场景组合，摆脱单调的2D照片，更加生动的展示房屋特点，提高成交率！</small>
            </p>
        </div>
        <div class="col-lg-7">
            <img src="../../images/index/VRshowings.png" class="img-responsive img-rounded img-thumbnail">
        </div>
    </div>
</div>
<div class="jumbotron index-bg-gray">
    <div class="container">
        <div class="col-lg-7">
            <img src="../../images/index/VRshowings.png" class="img-responsive img-rounded img-thumbnail">
        </div>
        <div class="col-lg-5">
            <h2><i class="index-iconfont-md">&#xe63f;</i>&nbsp;多种方式轻松分发</h2>
            <p>
                <small>多种灵活的分发方式，无缝嵌入式房源展示页面，以及最适合微信等移动终端上传播的二维码！</small>
            </p>
        </div>
    </div>
</div>
<div class="jumbotron index-bg-white">
    <div class="container">
        <div class="col-lg-5">
            <h2><i class="index-iconfont-md">&#xe643;</i>&nbsp;海量房库任你挑选</h2>
            <p>
                <small>全网互联，房库共享，只需要向房源提供者发送申请，即可分享房源，互利共赢，再也不会因房源不足而流失到手的客户！</small>
            </p>
        </div>
        <div class="col-lg-7">
            <img src="../../images/index/VRshowings.png" class="img-responsive img-rounded img-thumbnail">
        </div>
    </div>
</div>
<div class="jumbotron index-bg-gray">
    <div class="container">
        <div class="col-lg-7">
            <img src="../../images/index/VRshowings.png" class="img-responsive img-rounded img-thumbnail">
        </div>
        <div class="col-lg-5">
            <h2><i class="index-iconfont-md">&#xe694;</i>&nbsp;周边信息一网打尽</h2>
            <p>
                <small>在线地图直接展示房源周边环境，配套设施，智能地图规划，不论工作上班、学习上学，最适合你的才是最好的。</small>
            </p>
        </div>
    </div>
</div>
<div class="jumbotron index-bg-gray">
    <div class="container">
        <div class="col-lg-12">
            <h3 class="text-center">
                『 每一次创新都倾注了无懈的努力，一次次推倒重来只为拿出最好的产品 』
            </h3>
            <p class="text-center">
                —
            </p>
            <p class="text-center">
               Showings
            </p>
        </div>
    </div>
</div>
<div class="jumbotron index-bg-black">
    <div class="container">
        <div class="col-lg-12" style="color: #FFFFFF;">
            <h4 class="text-center">
                <small>©2012-2016 Showings 版权所有</small>
            </h4>
            <h4 class="text-center">
                <small>京ICP备15000327号</small>
            </h4>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/common.js"></script>
</body>
</html>
