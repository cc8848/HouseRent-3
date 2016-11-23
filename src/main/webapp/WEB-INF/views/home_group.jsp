
<%--
  Created by IntelliJ IDEA.
  User: wu
  Date: 2016/11/24
  Time: 上午7:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:when test="${sysMenu.href=='group-manage'}">
    <div id="${sysMenu.href}" class="tab-pane">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">申请审核
                    <div class="btn-group-xs pull-right" style="margin-top: -2px">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </button>
                        <button type="button" class="btn btn-default">
                            <span id="auditing-pageNum"></span>/<span
                                id="auditing-totalPage"></span>
                        </button>
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </button>
                    </div>
                </h3>
            </div>
            <div class="panel-body">
                                        <span>
                                            勾选右侧复选框可批量操作！
                                        </span>
                <div class="btn-group-sm pull-right">
                    <button type="button" class="btn btn-success">审核通过</button>
                    <button type="button" class="btn btn-danger">审核拒绝</button>
                </div>
            </div>
            <table id="auditing-table"
                   class="table table-responsive table-striped table-condensed">
                <thead>
                <tr>
                    <th></th>
                    <th>岗位ID</th>
                    <th>用户名</th>
                    <th>联系电话</th>
                    <th><input type="checkbox" class="checkbox"></th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>
    </div>
</c:when>
