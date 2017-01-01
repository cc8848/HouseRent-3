/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/26
 * 类说明:
 * 更新记录：
 */
$(document).ready(function () {
    var handHouse = new HandHouseIssue();
    handHouse.Init();
});

function HandHouseIssue() {

    this.Init = function () {
        $("[name='propertyRightsForTwoYears'],[name='onlyHousing']").bootstrapSwitch({
            onText: "是",
            offText: "否",
            onColor: "success",
            offColor: "danger",
            size: "small",
            onSwitchChange: function (event, state) {
                if (state == true) {
                    $(this).val("1");
                } else {
                    $(this).val("0");
                }
            }
        });
        var location = new Location($("[name='province']"), $("[name='city']"), $("[name='area']"));
        location.locationInit();
        var fileInput=new FileUpload();
        fileInput.sampleInit($("[name='thumbnail']"),'/upload/house');
        fileInput.sampleInit($("[name='panorama']"),'/upload/house')
    }

}