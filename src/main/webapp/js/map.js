/**
 * Created by wu on 16/10/8.
 */
(function (config) {
    var fa = navigator.userAgent.toLowerCase(), e = window, ga = document, ha = ga.documentElement;

    function A(a) {
        return -1 !== fa.indexOf(a)
    }

    var oa = "ActiveXObject" in e, pa = "devicePixelRatio" in e && 1 < e.devicePixelRatio || oa && "matchMedia" in e && e.matchMedia("(min-resolution:144dpi)") && e.matchMedia("(min-resolution:144dpi)").matches, qa = A("windows nt"), ra = -1 !== fa.search(/windows nt [1-5]\./), Ca = -1 !== fa.search(/windows nt 5\.[12]/), Da = ra && !Ca, Na = A("windows phone"), Oa = A("macintosh"), Pa = A("ipad;"), $a = Pa && pa, ab = A("ipod touch;"), bb = A("iphone;"), cb = bb || Pa || ab, sb = cb && -1 !== fa.search(/ os [456]_/);
    cb && fa.search(/ os [4-8]_/);
    var Hb = cb && -1 !== fa.search(/ os [78]_/);
    cb && A("os 8_");
    var Ib = cb && A("os 10_"), Jb = A("android"), Kb = -1 !== fa.search(/android [123]/), Lb = A("android 4");
    Jb && -1 === fa.search(/android [1-4]/) || fa.search(/android 4.4/);
    var Mb = Jb ? "android" : cb ? "ios" : qa ? "windows" : Oa ? "mac" : "other", Nb = oa && !e.XMLHttpRequest, Ob = oa && !ga.querySelector, Pb = oa && !ga.addEventListener, Qb = oa && A("ie 9"), Rb = oa && A("msie 10"), mc = oa && A("rv:11");
    A("edge");
    var nc = A("qtweb"), oc = A("ucbrowser"), pc = A("micromessenger"), qc = A("mqqbrowser"), rc = A("baidubrowser"), chrome = A("chrome") && !pc && !rc && !qc, sc = A("firefox"), tc = (Oa || cb) && A("safari") && A("version/"), uc = Jb || cb || Na || A("mobile") || "undefined" !== typeof orientation, vc = e.navigator && e.navigator.msPointerEnabled && !!e.navigator.msMaxTouchPoints, Dc = vc || A("touch") || "ontouchstart" in ga, Ec = oa && "transition" in ha.style, Fc = !!ga.createElementNS && !!ga.createElementNS("http://www.w3.org/2000/svg", "svg").createSVGRect, Gc = ga.createElement("canvas"),
        Hc = !(!Gc || !Gc.getContext), Ic = !Hc || nc || Na || uc && sc || Qb || sb || $a || ab || Kb || A("gt-n710") || Da, Jc = !Ic && (Lb || Hb || !uc), Kc = Ic || Jc ? Ic ? "d" : "dv" : "v", Lc = A("webkit"), Mc = "WebKitCSSMatrix" in e && "m11" in new window.WebKitCSSMatrix, Nc = "MozPerspective" in ha.style, Oc = "OTransition" in ha.style, Pc = Ec || Mc || Nc || Oc, Qc = void 0 !== config[8] ? config[8] : !0, Rc = void 0 !== config[9] ? config[9] : !0, Sc = !Fc && uc && Hc, Tc = window.URL || window.webkitURL, Uc = window.Worker && Tc && Tc.createObjectURL && window.Blob && !oa && !oc, Vc = !1;
    try {
        Vc = "undefined" !== typeof e.localStorage
    } catch (Wc) {
    }
    config.j = {
        size: bb ? 100 : Jb ? 200 : 800,
        nx: Oa,
        F0: qa,
        ZF: cb,
        WT: Ib,
        Me: Jb,
        TY: Kb,
        Nx: Mb,
        Kv: rc,
        K_: qc,
        oW: tc,
        KX: pc,
        Sl: oa,
        Jf: Nb,
        ho: Ob,
        f_: Qb,
        IT: Rb,
        $c: Pb,
        KT: oa && !mc,
        qr: Vc,
        ws: oc,
        chrome: chrome,
        hF: sc,
        W: uc,
        A_: uc && Lc,
        AU: uc && Mc,
        z_: uc && e.opera,
        fa: pa,
        zc: Dc,
        LG: vc,
        IX: Lc,
        e_: Ec,
        JX: Mc,
        AZ: Nc,
        D_: Oc,
        UQ: Pc,
        Oh: Fc,
        ko: Hc,
        fU: Uc,
        Df: Qc && !Ic,
        eR: Qc ? Kc : "d",
        mo: Rc && !!e.WebSocket && !rc,
        dV: Sc,
        hV: Hc || Sc ? "c" : "d"
    };
    var e = window, Xc = "http map anip layers overlay0 brender mrender".split(" ");
    config.Be = "main";
    config.j.zc && (Xc += ",touch", config.Be += "t");
    config.j.W || (Xc += ",mouse", config.Be += "m");
    config.Be += "c";
    config.j.Df && (config.Be += "v", Xc += ",vectorlayer,overlay");
    config[7] && (Xc += "," + config[7], config.Be += config[7].replace(",", "").replace(eval("/AMap./gi"), ""));
    Xc += ",sync";
    config.II = Xc.split(",");
    window.AMap = window.AMap || {};
    window.AMap.dh = "1.3.19.4";
    var Yc = window.AMap.Ly = {}, Zc = config[2].split(",")[0], $c = Zc + "/theme/v" + config[4] + "/style1.3.19.4.css", ad = document.head || document.getElementsByTagName("head")[0];
    if (ad) {
        var bd = document.createElement("link");
        bd.setAttribute("rel", "stylesheet");
        bd.setAttribute("type", "text/css");
        bd.setAttribute("href", $c);
        ad.insertBefore(bd, ad.firstChild)
    } else document.write("<link rel='stylesheet' href='" + $c + "'/>");
    function cd(a) {
        var b = document, c = b.createElement("script");
        c.charset = "utf-8";
        c.src = a;
        (a = b.body || ad) && a.appendChild(c)
    }

    function dd() {
        for (var a = Zc + "/maps/main?v=" + config[4] + "&key=" + config[0] + "&m=" + config.II.join(",") + "&vrs=1.3.19.4", b = document.getElementsByTagName("script"), c, d = 0; d < b.length; d += 1)if (0 === b[d].src.indexOf(Zc.split(":")[1] + "/maps?")) {
            c = b[d];
            break
        }
        config[5] || c && c.async ? cd(a) : (document.write('<script id="amap_main_js" src=\'' + a + "' type='text/javascript'>\x3c/script>"), setTimeout(function () {
            document.getElementById("amap_main_js") || cd(a)
        }, 1))
    }

    var ed = (new Date).getTime();
    Yc.__load__ = function (a) {
        a(config, ed);
        Yc.__load__ = null
    };
    try {
        if (window.localStorage) {
            var fd = window.localStorage["_AMap_" + config.Be], gd = !1;
            fd ? (fd = JSON.parse(fd), fd.version === window.AMap.dh ? (eval(fd.script), Yc.loaded = !0) : gd = !0) : gd = !0;
            if (gd)for (var D in window.localStorage)window.localStorage.hasOwnProperty(D) && 0 === D.indexOf("_AMap_") && window.localStorage.removeItem(D)
        }
    } catch (ld) {
    }
    Yc.loaded || (dd(), config.II = void 0);
})(["002273d8cd1c3363f0d26dae6629472b", [117.886012, 24.418307, 118.414778, 24.902793, 118.11022, 24.490474], "http://webapi.amap.com", 1, "1.3", null, "350200", "", true, true])