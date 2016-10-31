<div class="panel panel-default">
    <!-- Default panel contents -->
    <div class="panel-heading">
        好房推荐
    </div>
    <c:forEach items="${houseRecommend.houseList}" var="house">
        <ul class="list-group">
            <a href="/user/login" class="list-group-item container-fluid">
                <div class="col-md-2 hidden-xs hidden-sm">
                    <img src="${house.thumbnailPath}" alt=""
                         class="img-responsive img-thumbnail"/>
                </div>
                <div class="col-md-10 col-xs-12 ">
                    <h4 class="list-group-item-heading">${house.name}
                        <label class="label label-danger pull-right">${house.expectRent}元/月</label>
                    </h4>
                    <div class="white-divider-md"></div>
                    <div class="list-group-item-text">
                        <span class="glyphicon glyphicon-home"></span>
                        <span>&nbsp;${house.community.name}</span>
                        <label class="label label-success pull-right">${house.houseStatus.statusName}</label>
                    </div>
                    <div class="white-divider-md"></div>
                    <div class="list-group-item-text">
                        <label class="label label-danger">${house.decorationType.name}</label>
                        <c:if test="${house.haveKitcken}">
                            <label class="label label-primary">独立厨房</label>
                        </c:if>
                        <c:if test="${house.haveBalcony}">
                            <label class="label label-warning">独立阳台</label>
                        </c:if>
                        <label class="label label-info"></label>
                    </div>
                    <div class="white-divider-lg"></div>
                    <div class="list-group-item-text">
                        <span>${house.areaNumber}㎡</span>/
                        <span>${house.houseLayout.name}</span>/
                        <span>${house.decorationType.name}</span>/
                        <span>${house.floor}层</span>
                        <div class="pull-right">
                            <c:forEach items="${house.rentModeList}" var="rentMode">
                                                        <span class="label label-default" style="margin-left: 10px">
                                                                ${rentMode.name}
                                                        </span>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </a>
        </ul>
    </c:forEach>
</div>