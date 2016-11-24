/**
 * Created by wu on 2016/11/19.
 */
$(document).ready(function () {
    $('.select2').select2();
    $("[href='#issue-info']").on('click', new IssueMenu().menuInit);
    $('.radio').iCheck({
        radioClass: 'iradio_flat-red'
    });
});

function Account() {

    var _this = this;

    var area = $("#area");

    var storeNum = $("#storeNum");

    var storeRole = $("#storeRole");

    var storeNum_td = $('#storeNum-td');

    var modal = new Modal();

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
                    modal.errorModal(data.message);
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
            modal.errorModal('门牌必须选择！');
            return;
        }
        $.getJSON('/auditing/submit', {
            storeID: num
        }, function (backData) {
            if (backData.status) {
                $('#apply-close').trigger("click");
                refresh();
            } else {
                modal.errorModal(backData.message);
            }
        })
    };

    this.secede = function () {
        modal.confirmModal('确定要退出团队吗？', _this.confirm)
    };

    this.confirm = function () {
        $.getJSON('/auditing/secede', function (backData) {
            if (backData.status) {
                refresh();
            } else {
                modal.errorModal(backData.message);
            }
        });
    };
}


function Group() {

    var modal = new Modal();
    var pageNum_span = $('#auditing-pageNum');
    var totalPage_span = $('#auditing-totalPage');
    var _this = this;

    this.tableInit = function () {
        pageNum_span.html('1');
        _this.showTable(0, 10);
    };

    this.showTable = function (pageNum, pageSize) {
        $.getJSON('/auditing/getList', {
            pageNum: pageNum,
            pageSize: pageSize
        }, function (backData) {
            if (backData.status) {
                totalPage_span.html(backData.data.pages);
                $('#auditing-table tbody').html(template('auditing-table-content', backData.data));
                $('.checkbox').iCheck({
                    checkboxClass: 'icheckbox_flat-red'
                });
            } else {
                modal.errorModal(backData.message);
            }
        });
    }
}


function IssueMenu() {

    var _this = this;

    var tittle = $('#tittle');

    var desc = $('#desc');

    var price = $('#price');

    var floor = $('#floor');

    var floorArea = $('#floorArea');

    var poolArea = $('#poolArea');

    var face = $('#face');

    var decoration = $('#decoration');

    var layout = $('#layout');

    var status = $('#status');

    var address = $('#address');

    var location = new Location('#province', '#city', '#area');

    this.menuInit = function () {
        location.locationInit();
        var array = [];
        array.push();
        var selectUtil = new SelectUtil()
        selectUtil.selectInit(face, "/json/house_face.json");
        selectUtil.selectInit(decoration, "/json/house_decoration.json");
        selectUtil.selectInit(layout, "/json/house_layout.json");
        selectUtil.selectInit(status, "/json/status_sell.json");
    };


}
