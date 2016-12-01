<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/24
  Time: 上午7:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--团队信息 start--%>
<div class="panel panel-primary">
    <div class="panel-heading">
        <h3 class="panel-title">我的团队</h3>
    </div>
    <c:choose>
        <c:when test="${null==seller}">
            <div class="panel-body">
                您尚未申请加入任何中介机构！
                <button href="#updateSeller" type="button"
                        class="btn btn-primary btn-sm pull-right"
                        data-toggle="collapse">申请加入
                </button>
            </div>
        </c:when>
        <c:when test="${null!=seller}">
            <div class="panel-body">
                <c:choose>
                    <c:when test="${seller.userStatus.id==1||seller.userStatus.id==2}">
                        <%--当前为待审核或审核失败状态--%>
                        <span>当前属于<u
                                class="text-danger">${seller.userStatus.statusName}</u>状态，请耐心等待！</span>
                    </c:when>
                    <c:otherwise>
                        <%--当前为审核成功状态--%>
                        <span>你好，${sessionScope.user.name}。</span>
                    </c:otherwise>
                </c:choose>
                <div class="btn-group-sm pull-right">
                    <button href="#updateSeller" type="button" class="btn btn-primary"
                            data-toggle="collapse">更换团队
                    </button>
                    <button id="secede" type="button" class="btn btn-primary">退出团队
                    </button>
                </div>
            </div>
            <table class="table table-striped">
                <tbody>
                <tr>
                    <td>账号/手机号：</td>
                    <td>${sessionScope.user.username}</td>
                    <td>姓名：</td>
                    <td>${sessionScope.user.name}</td>
                </tr>
                <tr>
                    <td>公司名称：</td>
                    <td>${seller.sysStore.company.companyName}</td>
                    <td>申请门店：</td>
                    <td>${seller.sysStore.storeName}</td>
                </tr>
                <tr>
                    <td>门店地址：</td>
                    <td colspan="3">${seller.sysStore.province.provinceName}-${seller.sysStore.city.cityName}-${seller.sysStore.area.areaName}-${seller.sysStore.storeNumber}</td>
                </tr>
                <tr>
                    <td>审核状态：</td>
                    <td>${seller.userStatus.statusName}</td>
                    <td></td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </c:when>
    </c:choose>
</div>
<div id="updateSeller" class="panel-collapse collapse">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">请填写您的申请资料！
                <a id="apply-close" href="#updateSeller" class="label pull-right"
                   data-toggle="collapse">
                    <span class="glyphicon glyphicon-remove"></span>
                </a>
            </h3>
        </div>
        <div class="panel-body">
            <span id="apply-error">申报后请通知贵公司后台管理员进行审核，即可继续进行后续操作。</span>
            <div class="btn-group-sm pull-right">
                <button id="auditing-submit" type="button"
                        class="btn btn-primary">提交申请
                </button>
                <button id="auditing-cancel" href="#updateSeller" type="button"
                        class="btn btn-primary"
                        data-toggle="collapse">取消申请
                </button>
            </div>
        </div>
        <table class="table table-striped table-responsive">
            <tbody>
            <tr>
                <td>账号：</td>
                <td>${sessionScope.user.username}</td>
                <td>姓名：</td>
                <td>${sessionScope.user.name}</td>
            </tr>
            <tr>
                <td>地址：</td>
                <td>
                    <select id="province" title="province" class="select2"
                            style="width: 100%"></select>
                </td>
                <td>
                    <select id="city" title="city" class="select2"
                            style="width: 100%"></select>
                </td>
                <td>
                    <select id="area" title="area" class="select2"
                            style="width: 100%"></select>
                </td>
            </tr>
            <tr>
                <td>门牌</td>
                <td id="storeNum-td">
                    <select id="storeNum" title="storeNum" class="select2"
                            style="width: 100%"></select>
                </td>
                <td>
                </td>
                <td>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</div>
<%--团队信息 end--%>
