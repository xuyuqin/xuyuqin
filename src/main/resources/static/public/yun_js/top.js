String.prototype.replaceAll  = function(s1,s2){
    return this.replace(new RegExp(s1,"gm"),s2);
}

var url = "http://" + window.location.host;

//modulebootstrap1相关
// $("#moduleHead ul li").click(function() {
//     $(this).addClass("actives").siblings().removeClass("actives");
// });

$(function() {
    $('[data-toggle="popover"]').popover();
});

$(window).scroll(function() {
    var scrollTop = $(this).scrollTop(); //下拉多少
    var scrollHeight = $(document).height();
    var windowHeight = $(this).height(); //页面显示区域

    if (scrollTop > 450) {
        $("#topa").fadeIn(500);
    } else {
        $("#topa").fadeOut(500);
    }
});

$(document).ready(function() {

    $("#btnSearchm").click(function(e) {
        var type = $('.seachList .active').data('type');
        var url = 'www/' + type + '/search?' + $("#seachFrom").serialize();
        document.location = url;
    });

    //自定义popover显示的内容
    $("#shoppingCart").popover({
        trigger: 'click', //click| hover | focus | manual
        placement: 'left', //top, bottom, left or right
        title: '',
        html: 'true',
        content: ContentMethod("")
    }).on("mouseenter", function() {
        var _this = this;
        $(this).popover("show");
        $(this).siblings(".popover").on("mouseleave", function() {
            $(_this).popover('hide');
        });
    }).on("mouseleave", function() {
        var _this = this;
        setTimeout(function() {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide");
            }
        }, 100);
    });

    $("#hotline").popover({
        trigger: 'click', //click| hover | focus | manual
        placement: 'left', //top, bottom, left or right
        title: '',
        html: 'true',
        content: '<div class="hotlinePopver"><div class="row"><div class="col-md-12 hotlinePopverTitle">客服热线:</div></div><div class="row"><div class="col-md-12 text-center">021-888888</div></div><div class="row"><div class="col-md-12 hotlinePopverTitle">工作时间:</div></div><div lass="row"><div class="col-md-12 text-center">9:00-17:00</div></div></div>'
    }).on("mouseenter", function() {
        var _this = this;
        $(this).popover("show");
        $(this).siblings(".popover").on("mouseleave", function() {
            $(_this).popover('hide');
        });
    }).on("mouseleave", function() {
        var _this = this;
        setTimeout(function() {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide");
            }
        }, 100);
    });

    var activeDh = window.location.pathname;
    var pairs = activeDh.split("/");
    var path = pairs[2];
    if (path == "index") {
        $(".home").addClass("actives");
    } else if (path == "mall") {
        $(".mall").addClass("actives");
    } else if (path == "resource") {
        $(".resource").addClass("actives");
    } else if (path == "demand") {
        $(".demand").addClass("actives");
    } else if (path == "baike") {
        $(".baike").addClass("actives");
    } else if (path == "news") {
        $(".news").addClass("actives");
    } else if (path == "greydog") {
        $(".greydog").addClass("actives");
    } else if (path == "loan") {
        $(".loan").addClass("actives");
    } else if (path == "market") {
        $(".market").addClass("actives");
    }


    $(".seachList li").click(function() {
        var text = this.innerText;
        $(this).addClass("active").siblings().removeClass("active");
        var seachInput = $(".seachInput");
        if (text == "产品") {
            seachInput.attr("placeholder", "请输入产品百科关键字搜索");
        } else if (text == "供应商") {
            seachInput.attr("placeholder", "请输入供应商关键字搜索");
        } else if (text == "复材百科") {
            seachInput.attr("placeholder", "请输入复材关键字搜索");
        }
    });


    var ie6 = /msie 6/i.test(navigator.userAgent),
        dv = $('.logoHang'),
        st;

    if (dv.length > 0) {
        dv.attr('otop', dv.offset().top); //存储原来的距离顶部的距离
    } else {
        dv.attr('otop', '50'); //存储原来的距离顶部的距离
    }
    $(window).scroll(function() {
        st = Math.max(document.body.scrollTop || document.documentElement.scrollTop);
        if (st >= parseInt(dv.attr('otop'))) {
            if (ie6) { //IE6不支持fixed属性，所以只能靠设置position为absolute和top实现此效果
                dv.css({ position: 'absolute', top: st , 'border-bottom' : '3px solid #317ee7'});
            } else if (dv.css('position') != 'fixed')
                dv.css({ 'position': 'fixed', top: 50, left: 0, right: 0, 'width': '100%' , 'border-bottom' : '3px solid #317ee7'});
        } else if (dv.css('position') != 'static')
            dv.css({ 'position': 'static','border-bottom':0 });
    });
});

function ContentMethod(txt) {
    return false;
    var url =  "www/cart/listMyCart";
    $.getJSON(url, function(json, textStatus) {
        console.log(json);
        if (json.status == 0) {
            var x = -1, top = new Array();
            for (var i = 0; i < json.content.length; i++) {
                var current = json.content[i];
                if (i == 0 || current.provider.id != top[x].id) {
                    x++;
                    top[x] = {
                        id: current.provider.id,
                        name: current.provider.name,
                        addTime: new Date(current.addTime)
                    };
                    top[x].content = [];
                }
                top[x].content.push(current);
            }
            top.sort(function(a, b) {
                return b.addTime - a.addTime;
            })
            console.log(top);
            var data = top;
            if (data[0].content) {
                var lenlsit = data[0].content.length;
                if (length > 4) {
                    lenlsit = 4;
                }
                $(".shoppingSign").html('<span>' + lenlsit + '</span>');
                txt = '<div class="shoppingPopver row"><div class="col-md-12 shoppingPopverTitle">购物车</div>';
                for (var i = 0; i < lenlsit; i++) {
                    txt = txt +
                    '<div class="col-md-12 shoppingPopverList">' +
                    '<div class="col-md-8">' + data[0].content[i].merchandise.detail + '</div>' +
                    '<div class="col-md-4">￥' + data[0].content[i].price + '</div>' +
                    '<div class="col-md-8 paddingZreo"><div class="col-md-12 paddingZ">Hrb399e 28*9</div>' +
                    '<div class="col-md-12">上海市xxx</div></div><div class="col-md-4 paddingZreo">' +
                    '<div class="col-md-12"><div class="modulettonCompute"><a class="btn"><i class="fa fa-minus"></i></a>' +
                    '<input type="text" id="inputNumber" value="1" onfocus="this.blur();" />' +
                    '<a class="btn"><i class="fa fa-plus"></i></a></div>' +
                    '</div><div class="col-md-12">删除</div></div></div>';
                }
                txt = txt + "</div></div>";
            } else {
                txt = '<div  class="row" style="width:150px;text-align:center">没有商品<div>';
            }
        } else {
            txt = '<div><a class="btn-link navbar-btn navbar-left" href="' + __appconfig.approot + 'www/auth/login">请登录</a><div>';
        }
        return txt;
    });   
}


//modulebootstrap2相关
$('.list-unstyled li').click(function(e) {
    $(".list-unstyled li").removeClass('treeActive');
    $(this).addClass('treeActive');
});


//常用的函数
//取地址栏参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function loginout() {
     $.cookie('name','');
}

if($.cookie('name') != '' && $.cookie('name') != undefined){
    //已登陆
    $('#status').html('<a href="/yuncai/backstage/index" class=" btn-link navbar-btn navbar-left navHeadt"  >您好!'+$.cookie('name')+'...</a><a onclick="loginout()" href="/yun/logout"  class="btn-link navbar-btn navbar-left navHeadt">退出</a>')
}else{
    $.get('/yun/member/myinfo').success(function (m) {
        if(m.code == 500){
            $('#status').html("<a href='/yuncai/login' class='btn-link navbar-btn navbar-left navHeadt'>请登录</a><a href='/yuncai/register' class='btn-link navbar-btn navbar-left navHeadt'>免费注册</a>");
        }
        if(m.code == 0){
            $.cookie('name',m.info.mobile.substr(0,5))
            $('#status').html('<a href="/yuncai/backstage/index" class=" btn-link navbar-btn navbar-left navHeadt"  >您好!'+$.cookie('name')+'...</a><a onclick="loginout()" href="/yun/logout"  class="btn-link navbar-btn navbar-left navHeadt">退出</a>');
        }
    }).fail(function () {
        console.log('链接错误')
    })
}


//清除所有cookie函数
function clearAllCookie() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if(keys) {
        for(var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
    }
}
//个人中心 左边list的toggle
$(document).on('click','.backContainer .leftNav li.clearfix',function (e) {
    var e = e|| event;
    var obj = e.target.nodeName == 'LI'? $(this): $(this).closest('li.clearfix');
    obj.siblings('li').toggle(100);
    if(obj.hasClass('roll')){
        obj.find('.pull-right').html('<span class="iconfont icon-shangla"></span>');
        obj.removeClass('roll')
    }else{
        obj.find('.pull-right').html('<span class="iconfont icon-xia"> </span>');
        obj.addClass('roll')
    }
});