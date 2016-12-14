/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu   创建时间: 2016/12/13
 * 类说明:
 * 更新记录：
 */

$(document).ready(function () {
    new Portrait().init();
});

function Portrait() {
    var fileUp = new FileUpload();
    var portrait = $('#portrait');
    this.init = function () {
        fileUp.sampleInit(portrait, '/file/portrait');

    };
}

//定义一个全局api，这样操作起来比较灵活
var api = null;
var img = $('#cut-img');
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.readAsDataURL(input.files[0]);
        reader.onload = function (e) {
            img.removeAttr('src');
            img.attr('src', e.target.result);
            img.Jcrop({
                handleSize: 15,
                aspectRatio: 1,
                onSelect: updateCoords
            }, function () {
                api = this;
            });
        };
        if (api != undefined) {
            api.destroy();
        }
    }
    function updateCoords(obj) {
        $("#x").val(obj.x);
        $("#y").val(obj.y);
        $("#w").val(obj.w);
        $("#h").val(obj.h);
    };
}