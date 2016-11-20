/**
 * Created by wu on 2016/11/19.
 */
$(document).ready(function () {
    var apply = new Apply();
    apply.tableInit();
});

function Apply() {

    var province = $("#province");

    var city = $("#city");

    var area = $("#area");

    var storeNum = $("#storeNum");

    var storeRole = $("#storeRole");

    var storeNum_td = $('#storeNum-td');

    var storeRole_td = $("#storeRole-td");

    var applay_error = $('#apply-error');

    this.tableInit = function () {
        $(".select2").select2();
        var location = new Location('#province', '#city', '#area');
        location.locationInit();
        this.areaInit();
        this.storeNumInit();
        this.storeRoleInit();
        $('#auditing-submit').on("click", this.applySubmit);
    };

    this.areaInit = function () {
        area.on("select2:select", function () {
            var areaID = area.select2("val");
            storeNum.html("");
            $.getJSON("/store/getNum", {
                areaID: areaID
            }, function (data) {
                storeNum.select2({
                    data: data.data
                });
            });
        });
    };

    this.storeNumInit = function () {
        storeNum.select2({
            placeholder: "门牌"
        }).on("select2:select", function () {
            var storeID = storeNum.select2("val");
            storeRole.html("");
            $.getJSON("/store/getRoles", {
                storeID: storeID
            }, function (data) {
                storeRole.select2({
                    data: data.data
                });
            });
        });
    };

    this.storeRoleInit = function () {
        storeRole.select2({
            placeholder: "岗位"
        });
    };
    this.applySubmit = function () {
        storeNum_td.removeClass("danger");
        storeRole_td.removeClass("danger");
        applay_error.addClass("text-danger").html("申报后请通知贵公司后台管理员进行审核，即可继续进行后续操作。");
        var num = storeNum.select2('val');
        if (null == num || 0 == num) {
            storeNum_td.addClass("danger");
            applay_error.html("门牌必须选择！");
            return;
        }
        var role = storeRole.select2('val');
        if (null == role || 0 == role) {
            storeRole_td.addClass("danger");
            applay_error.html("岗位必须选择！");
            return;
        }
        $.getJSON('/auditing/submit', {
            storeID: num,
            roleID: role
        }, function (backData) {
            if (backData.status) {
                $('#apply-close').trigger("click");
                refresh();
            } else {
                alert(backData.message);
            }
        })
    };
    this.cancel = function () {

    };
}

function refresh() {
    window.location.reload();
}