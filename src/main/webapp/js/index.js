/**
 * Created by wuxinzhe on 16/10/7.
 */
$(document).ready(showMap());

function showMap() {
    var map = new AMap.Map('container', {
        resizeEnable: true,
        zoom: 10,
        center: [116.480983, 40.0958]
    });
}
