/**
 * 知识产权声明:本文件自创建起,其内容的知识产权即归属于原作者,任何他人不可擅自复制或模仿.
 * 创建者: wu  创建时间: 2016/12/10
 * 类说明:
 * 更新记录：
 */
// document.domain = "showings.com.cn";
//如果在同个顶级域名下，不同子域名之间互通信息，设置document.domain="showings.com.cn"
function setIFrameHeight() {
    var iFrame=document.getElementById('frame-box');
    if (iFrame) {
        var iFrameWin = iFrame.contentWindow || iFrame.contentDocument.parentWindow;
        if (iFrameWin.document.body) {
            iFrame.height = iFrameWin.document.body.scrollHeight;
        }
    }
}
