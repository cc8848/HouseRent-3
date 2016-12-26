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
        $('.switch').bootstrapSwitch();
    }

}