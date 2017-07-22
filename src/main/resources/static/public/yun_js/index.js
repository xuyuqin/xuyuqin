$(function() {
    // 城市三级联动
    var citysData = {};
    getCitysData(function() {
        $('#formOne').citys({
            required: false,
            nodata: 'disabled',
            data: citysData
        })
    });
    //加载类别
    $('select[name="category"]').categorySelect();

    $('[data-toggle="popover"]').popover();
    $('#fullcarousel').carousel({});

    //自定义popover显示的内容
    $(".cityStart").popover({
        trigger: 'click',
        placement: 'bottom', //top, bottom, left or right
        title: '',
        html: 'true',
        content: ContentMethods(),
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

    //发布找货单
    $('#demand-submit').click(function() {
        var zhaohuoData =  $("#formOne").serialize();
        if($('#formOne .cityStart').val() == ''){
            $.cookie('code','');
        }else{
            zhaohuoData += '&district='+$.cookie('code');
        }

        $.ajax({
            url: '/yun/tyundemand/find?'+zhaohuoData,
            type: 'POST',
            data: {},
            processData: false,
            contentType: false,
        }).done(function(data) {
            if(data.code == 500 && data.msg == '请先登录！'){
                alert('请先登录,登陆后会自动提交您的找货单!');
                $.cookie('zhaohuo',zhaohuoData);
                window.location.href = '/yuncai/login';
            }
            if(data.code == 0){
                alert('发布成功');
                window.location.href = "/yuncai/demand/index";
            }
        }).fail(function() {
            console.log('post demand failed');
        });
    });

    //云材商城我要找货
    // $('.getShop').click(function() {
    //     console.dir($("#newShopLeftForm").serialize());
    //     var url = 'www/merchandise/list?' + encodeURI($("#newShopLeftForm").serialize());
    //     console.log(url);
    //     window.location.href = url;
    // });

    //价格动态
    var loadDynamic = function(category) {
        if(category != null || category != undefined){
            dynamicajax(category);
        }
        if(sessionStorage.getItem('Dynamicstr') != '' && sessionStorage.getItem('Dynamicstr') != undefined){
            $('#dynamic').html(sessionStorage.getItem('Dynamicstr'));
            $("[data-toggle='tooltip']").tooltip();
            adjust();
        }else{
            dynamicajax();
        }

        function DataConstruction (response,i) {
            var common = '<td><div class="left"><label class="name" data-toggle="tooltip" data-placement="bottom" title="'+isNull(response.page.list[i].mname)+'">'+isNull(response.page.list[i].mname)+
            '</label> <label class="format">'+isNull(response.page.list[i].unit) +'*'+isNull(response.page.list[i].material)+
            '</label> </div> <div class="right"> <label class="time"  data-toggle="tooltip" data-placement="bottom" title="'+
            isNull(response.page.list[i].scaleTime)+ '" >'+isNull(response.page.list[i].scaleTime)+
            '</label> <div style="clear: both"></div>'+checkupdowm(response.page.list[i].trend,response.page.list[i].postPrice)+'</div> </td>'
            var str;
            if(i%5 ==0 ){
                str = '<tr>'+common;
            }else if(i%5 == 4){
                str = common+'</tr>';
            }else{
                str = common
            }
            return str;
        }


        function dynamicajax(category){
            var url;
            category == null || category == undefined ?
                url = '/yun/tyunpricedynamics/list?limit=30' :
                url = '/yun/tyunpricedynamics/list?limit=30&subCategoryId='+category;
            $.ajax({
                url: url,
                method: 'GET',
                beforeSend: function(){
                    $('#dynamic').html('<div class="spinner"> <div class="cube1"></div> <div class="cube2"></div> </div>');
                },
                // complete: function(){
                // },
            }).done(function(response) {
                console.log('价格动态信息:')
                console.log(response);
                var str = '',str2 = '';
                if(response.code == 0){
                    for(var i =0,length = response.page.list.length;i<length;i++){
                        if(i > 14){
                            str += DataConstruction(response,i)
                        }else{
                            str2 += DataConstruction(response,i);
                        }
                    }
                    var dynamicstr = '<div class="dynamicTitle"> <label>类别</label> </div><div id="dynamicContent"><ul><li><table>'+str+'</table></li><li><table>'+str2+'</table></li></ul></div>';
                    if(category == null || category == undefined){
                        sessionStorage.setItem('Dynamicstr',dynamicstr);
                    }
                    $('#dynamic').html(dynamicstr);
                    $("[data-toggle='tooltip']").tooltip();
                    adjust();
                }
            }).fail(function(err) {
                console.error(err);
            });
        }


    };

    function checkupdowm(trend,postprice) {
        return trend<0?'<label class="updowndown"><div class="down"></div>'+trend.toString().substr(1)+'</label> <label class="numdown">'+postprice+'</label>'
        :'<label class="updownup"><div class="up"></div>'+trend+'</label> <label class="numup">'+postprice+'</label>';
    }
    function adjust() {
            $('#dynamicContent').scrollbox({
                linear: true,
                step: 1,
                delay:2 ,
                speed: 10
            });
    }

    
    loadDynamic();
    loadNews();

    //地区下拉选项数据
    function getCitysData(ck){
        if($.isEmptyObject(citysData)){
            var citys = sessionStorage.citys;
            if(typeof citys == 'undefined' || citys == null){
                $.getJSON( '/yun/region/list', function(datas){
                    console.log(datas)
                    for(var x in datas.content){
                        citysData[datas.content[x].code]=datas.content[x].name;
                    }
                    sessionStorage.setItem('citys', JSON.stringify(citysData))
                    ck();
                });
            } else{
                citysData=JSON.parse(citys);
                ck();
            }
        }else{
            ck();
        }
    }

    //为你推荐
    var loadrecommend = function () {
        if(sessionStorage.getItem('indexrecommend') != '' && sessionStorage.getItem('indexrecommend') != undefined) {
            $('#recommend ').html(sessionStorage.getItem('indexrecommend'));
            $("[data-toggle='tooltip']").tooltip();
        }else{
            $.ajax({
                url: '/yun/home/recommend?limit=9',
                method: 'GET',
                data: {}
            }).done(function(response) {
                console.log('为你推荐')
                console.log(response)
                var str = '';
                for(var i =0,length = response.page.list.length;i<length;i++) {
                    str += '<a href="#"><div class="dataOverview"> <div class="name" data-toggle="tooltip" data-placement="bottom" title="'+response.page.list[i].providerName+'">'+response.page.list[i].providerName+
                        '</div> <div class="good"  data-toggle="tooltip" data-placement="bottom" title="'+response.page.list[i].name+'">'+response.page.list[i].name+
                        '</div> <div class="format">'+isNull(response.page.list[i].specification)+'</div> <div class="time"  data-toggle="tooltip" data-placement="bottom" title="'+isNull(response.page.list[i].createTime)+'">'+isNull(response.page.list[i].createTime)+'</div> </div></a>'
                }
                $('#recommend ').html(str);
                sessionStorage.setItem('indexrecommend',str);
                $("[data-toggle='tooltip']").tooltip();

            }).fail(function(e) {

            });
        }

    }
    loadrecommend()


    $('#dynamicSelect').change(function () {
        loadDynamic($(this).val())
    })





    //加载新闻数据
    function loadNews() {
        if(sessionStorage.getItem('newlist') != '' && sessionStorage.getItem('newlist') != undefined) {
            var list = JSON.parse(sessionStorage.getItem('newlist'));
            $('.news').find('.inner .content .morea').before(list.inner).end()
                .find('.outer .content .morea').before(list.outer).end()
                .find('.firm .content .morea').before(list.firm);

        }else{
            $.get('/yun/home/news?limit=18', function(data) {
                console.log('新闻:')
                console.log(data);
                var categoryInternal = 0,
                    categoryExternal = 0,
                    categoryTrend = 0;
                var inner='',outer='',firm='';
                // categoty 1=>国内 2=>国外 3=>企业
                for(var i=0,length=data.page.list.length;i<length;i++){
                    if(data.page.list[i].category == 1){
                        if(categoryInternal < 5){
                            categoryInternal++;
                            inner += '<a href="#"><div class="dataNews"><label class="condition">国内资讯</label><p>|</p><label class="title">'+data.page.list[i].title+'</label><label class="time">'+
                                data.page.list[i].posttime.match(/\d{4}-\d{2}-\d{2}/)+'</label></div> </a>';

                        }
                        continue;
                    }
                    if(data.page.list[i].category == 2){
                        if(categoryExternal < 5){
                            categoryExternal++;
                            outer += '<a href="#"><div class="dataNews"><label class="condition">国外资讯</label><p>|</p><label class="title">'+data.page.list[i].title+
                                '</label><label class="time">'+data.page.list[i].posttime.match(/\d{4}-\d{2}-\d{2}/)+'</label></div> </a>';

                        }
                        continue;
                    }
                    if(data.page.list[i].category == 3){
                        if(categoryTrend < 5){
                            categoryTrend++;
                            firm += '<a href="#"><div class="dataNews"><label class="condition">云材行情</label><p>|</p><label class="title">'+
                                data.page.list[i].title+'</label><label class="time">'+data.page.list[i].posttime.match(/\d{4}-\d{2}-\d{2}/)+'</label></div> </a>'

                        }
                        continue;
                    }
                    if(categoryInternal == 5 && categoryExternal == 5 && categoryTrend == 5 ){
                        break;
                    }

                }
                $('.news').find('.inner .content .morea').before(inner).end()
                    .find('.outer .content .morea').before(outer).end()
                    .find('.firm .content .morea').before(firm);

                var newlist = {'inner':inner,'outer':outer,'firm':firm};
                sessionStorage.setItem('newlist',JSON.stringify(newlist))
            });
        }

    }



    function isNull (val) {
        return val == null||val == undefined ? '无' : val;
    }



    //供应商信息
    if(sessionStorage.getItem('providerLogo') != '' && sessionStorage.getItem('providerLogo') != undefined) {
        $('#providerLogo').html(sessionStorage.getItem('providerLogo'));
    }else{
        $.ajax({
            url: '/yun/home/provider?limit=9',
            method: 'GET',
            data: {},

        }).done(function(response) {
            console.log('供应商信息:')
            console.log(response)
            var str = '';
            for(var i = 0,length = response.page.list.length;i<length;i++){
                if(i%3 == 0){
                    str += '<tr><td> <img src="'+response.page.list[i].logo+'" alt="供应商"></td>';
                }else if(i%3 == 2){
                    str += '<td> <img src="'+response.page.list[i].logo+'" alt="供应商"></td></tr>';
                }else{
                    str += '<td> <img src="'+response.page.list[i].logo+'" alt="供应商"></td>';
                }
            }
            sessionStorage.setItem('providerLogo',str);
            $('#providerLogo').html(str);
        }).fail(function(e) {
            console.log('provider connection error')
        });
    }



    //找货信息
    if($.cookie('indexzhaohuo') != undefined && $.cookie('indexzhaohuo') != ''){
        $('#searchGood ul').html($.cookie('indexzhaohuo'));
    }else{
        $.ajax({
            url: '/yun/home/demand?limit=4',
            method: 'GET',
            data: {}
        }).done(function(response) {
            // console.log('找货信息:')
            // console.log(response)
            var str = '';
            for(var i = 0,length = response.page.list.length;i<length;i++){
                if(i == length -1){
                    str += '<li> <div class="dataOverview last"> <div class="name">产品名称: <p>'+isNull(response.page.list[i].productBuy)+'</p></div> <div class="format">规格: <p>'+isNull(response.page.list[i].specification)+'</p></div> <div class="Category">材质: <p>'+isNull(response.page.list[i].material)+'</p></div> <div  class="num">数量: <p>'+isNull(response.page.list[i].amount)+'</p></div> <a  href="/yuncai/demand/price?demandId='+response.page.list[i].id+'" class="hasGood">我有货</a> </div></li>';
                    break;
                }
                str += '<li> <div class="dataOverview"> <div class="name">产品名称: <p>'+isNull(response.page.list[i].productBuy)+'</p></div> <div class="format">规格: <p>'+isNull(response.page.list[i].specification)+'</p></div> <div class="Category">材质: <p>'+isNull(response.page.list[i].material)+'</p></div> <div  class="num">数量: <p>'+isNull(response.page.list[i].amount)+'</p></div> <a  href="/yuncai/demand/price?demandId='+response.page.list[i].id+'" class="hasGood">我有货</a> </div></li>';

            }
            $('#searchGood ul').html(str)
            $.cookie('indexzhaohuo',str);
        })
    }










});//$(function) end

//云材商城处的toggle
$('.material .right .head').click(function(e){
    if(!$(e.target).hasClass('actives')){
        var $this;
        $(this).find('div').removeClass('actives');
        $(e.target).get(0).localName == 'i'? $this = $(e.target).parent('div') : $this = $(e.target);
        $this.addClass('actives');
        if($this.hasClass('searchGood')){
            $('#searchGood').show();$('#recommend').hide();
        }else{
            $('#searchGood').hide();$('#recommend').show();
        }
    }
})




function show(a, b) {
    $(b).addClass("activeBtn").siblings().removeClass("activeBtn");
    if (a == "1") {
        $("#formOne").show().siblings().hide();
    } else if (a == "2") {
        $("#formTwo").show().siblings().hide();
    } else if (a == "3") {
        $("#formThree").show().siblings().hide();
    }
}
//allprovince
function ContentMethods(txt) {
    $.ajax({
        type: 'GET',
        url: "/yun/region/list?level=1",
        data: {},
        async: false,
        beforeSend: function() {},
        complete: function() {},
        success: function(data) {
            var datalenth = data.list.length;
            txt = "<div class='regiondiv'>";
            var text = "";
            for (var i = 0; i < datalenth; i++) {
                if (data.list[i].name.length > 3) {
                    text = text + "<li class='prlistlong' onclick='getcity(" + data.list[i].code + ",\"" + data.list[i].name + "\")'>" + data.list[i].name + "</li>";
                } else {
                    txt = txt + "<li class='prlist' onclick='getcity(" + data.list[i].code + ",\"" + data.list[i].name + "\")'>" + data.list[i].name + "</li>";
                }
            }

            txt = txt + text + '</div>';
        },
        error: function(msg) {
            return '出错啦';
        }
    });
    return txt;
}

function getcity(a, name) {
    $.ajax({
        type: 'GET',
        url: "/yun/region/list",
        data: { 'pcode': a },
        async: false,
        beforeSend: function() {},
        complete: function() {},
        success: function(data) {
            var datalenth = data.list.length;
            var text = " ";
            for (var i = 0; i < datalenth; i++) {
                text = text + "<li class='prlist' onclick='getqu(" + data.list[i].code + ",\"" + data.list[i].name + "\",\"" + name + "\")'>" + data.list[i].name + "</li>";
            }
            $(".regiondiv").html(text + "</div>");
        },
        error: function(msg) {
            return '出错啦';
        }
    });
}

function getqu(a, name, c) {
    $.ajax({
        type: 'GET',
        url: "/yun/region/list",
        data: { 'ccode': a },
        async: false,
        beforeSend: function() {},
        complete: function() {},
        success: function(data) {
            var datalenth = data.list.length;
            var text = " ";
            for (var i = 0; i < datalenth; i++) {
                text = text + "<li class='prlist'  onclick='putname(\"" + data.list[i].code + "\",\"" + data.list[i].name + "\",\"" + name + "\")'>" + data.list[i].name + "</li>";
            }
            $(".regiondiv").html(text + "</div>");
        },
        error: function(msg) {
            return '出错啦';
        }
    });
}

function putname(code, name) {
    $(".cityStart").val(name);
    $.cookie('code',code)
    $(".cityStart").popover("hide");
}

//价格动态轮播
// var isNegInt = function(n) {
//     return (typeof n === 'number' && n < 0 && Number.isInteger(n));
// };
// Number.isInteger = Number.isInteger || function(value) {
//     return typeof value === "number" &&
//         isFinite(value) &&
//         Math.floor(value) === value;
// };
// var degrees = 0;
// var a = "";
// var timer = setInterval(function() {
//     list();
// }, 10);
//
// function list() {
//     degrees = degrees - 1;
//     a = degrees % 325;
//     if (isNegInt(a)) {
//         $(".listCaOne .col-md-3").css({
//             'margin-top': degrees
//         });
//     } else {
//         // clearInterval(timer);
//         degrees = 0;
//     }
// }
//
// function closeTimer() {
//     clearInterval(timer);
// }
//
// function startTimer() {
//     timer = setInterval(function() {
//         list();
//     }, 10);
// }
// $(".lunBo").hover(function(){
//   alert(1);
// });
//为您推荐轮播
// var newShopDegrees = 0,
//     newShopHeight = $('.newShopBodyItems').css('height').replace(/[^0-9]/ig, "");
// var newShopTimer = setInterval(function() {
//     newShopList();
// }, 80);
// var newShopList = function() {
//     if (Math.abs(newShopDegrees) >= newShopHeight) {
//         newShopDegrees = 0;
//     } else {
//         newShopDegrees--;
//     }
//     $('.newShopBodyItems').css({
//         'margin-top': newShopDegrees
//     });
// };

// function newShopCloseTimer() {
//     clearInterval(newShopTimer);
// }
//
// function newShopStartTimer() {
//     newShopTimer = setInterval(function() {
//         newShopList();
//     }, 80);
// }

