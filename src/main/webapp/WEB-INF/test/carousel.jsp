<%--
  Created by IntelliJ IDEA.
  User: wuxin
  Date: 2016/10/30
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%--轮播图--%>
<div class="row">
    <div id="carousel-generic" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="../../images/index/1.jpg" style="width: 100%" alt="...">
                <div class="carousel-caption">
                    First
                </div>
            </div>
            <div class="item">
                <img src="../../images/index/2.jpg" style="width: 100%" alt="...">
                <div class="carousel-caption">
                    Second
                </div>
            </div>
            <div class="item">
                <img src="../../images/index/3.jpg" style="width: 100%" alt="...">
                <div class="carousel-caption">
                    Second
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
</div><%--轮播图 end--%>
