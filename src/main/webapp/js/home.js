/**
 * Created by wu on 2016/11/19.
 */
$(document).ready(function () {
    var apply = new Apply();
    apply.tableInit();
    $('.checkbox').iCheck({
        checkboxClass: 'icheckbox_flat-red'
    })
});

function Apply() {

    var area = $("#area");

    var storeNum = $("#storeNum");

    var storeRole = $("#storeRole");

    var storeNum_td = $('#storeNum-td');

    this.tableInit = function () {
        $(".select2").select2();
        var location = new Location('#province', '#city', '#area');
        location.locationInit();
        this.areaInit();
        this.storeNumInit();
        $('#auditing-submit').on("click", this.applySubmit);
        $('#secede').on('click', this.secede);
    };

    this.areaInit = function () {
        area.on("select2:select", function () {
            var areaID = area.select2("val");
            storeNum.html("");
            $.getJSON("/store/getNum", {
                areaID: areaID
            }, function (data) {
                if (data.status) {
                    storeNum.select2({
                        data: data.data
                    });
                } else {
                    errorModal(data.message);
                }
            });
        });
    };

    this.storeNumInit = function () {
        storeNum.select2({
            placeholder: "门牌"
        });
    };

    this.applySubmit = function () {
        storeNum_td.removeClass("danger");
        var num = storeNum.select2('val');
        if (null == num || 0 == num) {
            storeNum_td.addClass("danger");
            errorModal('门牌必须选择！');
            return;
        }
        $.getJSON('/auditing/submit', {
            storeID: num
        }, function (backData) {
            if (backData.status) {
                $('#apply-close').trigger("click");
                refresh();
            } else {
                errorModal(backData.message);
            }
        })
    };
    this.secede = function () {
        confirmModal('确定要退出团队吗？', confirm)
    };

}

function refresh() {
    window.location.reload();
}

confirm = function () {
    $.getJSON('/auditing/secede', function (backData) {
        if (backData.status) {
            refresh();
        } else {
            errorModal(backData.message);
        }
    });
};