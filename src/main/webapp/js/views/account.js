/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/10
 * 类说明:
 * 更新记录：
 */
$(document).ready(function () {
    new PageInit().init();
});


function PageInit() {
    var api = null;
    var _this = this;
    this.init = function () {
        $('#modify').on('click', this.modifyInfo);
        $("[name='modifyCancel']").on('click', refresh);
        $("[name='upload']").on('click', this.portraitUpload)
    };

    this.modifyInfo = function () {
        $('.form-control').each(function () {
            $(this).removeAttr('disabled');
        });
        $('.hidden').removeClass('hidden');
    };

    this.portraitUpload = function () {
        var model = $.scojs_modal({
                title: '头像上传',
                content: template('portraitUpload'),
                onClose: refresh
            }
        );
        model.show();
        var fileUp = new FileUpload();
        var portrait = $('#fileUpload');
        var alert = $('#alert');
        fileUp.portrait(portrait, '/file/portrait', _this.getExtraData);
        portrait.on('change', _this.readURL);
        portrait.on('fileerror', function (event, data, msg) {
            console.log(data.id);
            console.log(data.index);
            console.log(data.file);
            console.log(data.reader);
            console.log(data.files);
            // get message
            alert(msg);
        });
        portrait.on('fileuploaderror', function (event, data, msg) {
            alert.removeClass('hidden').html(msg);
        });
        portrait.on('fileclear', function (event) {
            alert.addClass('hidden').html();
        });
    };

    this.readURL = function () {
        var img = $('#cut-img');
        var input = $('#fileUpload');
        if (input[0].files && input[0].files[0]) {
            var reader = new FileReader();
            reader.readAsDataURL(input[0].files[0]);
            reader.onload = function (e) {
                img.removeAttr('src');
                img.attr('src', e.target.result);
                img.Jcrop({
                    setSelect: [20, 20, 200, 200],
                    handleSize: 10,
                    aspectRatio: 1,
                    onSelect: updateCords
                }, function () {
                    api = this;
                });
            };
            if (api != undefined) {
                api.destroy();
            }
        }
        function updateCords(obj) {
            $("#x").val(obj.x);
            $("#y").val(obj.y);
            $("#w").val(obj.w);
            $("#h").val(obj.h);
        }
    };

    this.getExtraData = function () {
        return {
            sw: $('.jcrop-holder').css('width'),
            sh: $('.jcrop-holder').css('height'),
            x: $('#x').val(),
            y: $('#y').val(),
            w: $('#w').val(),
            h: $('#h').val()
        }
    }
}

