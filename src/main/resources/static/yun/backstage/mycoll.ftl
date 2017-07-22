<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_kfrjvw7udrysyvi.css">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/myorder.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach topStyle">
    <div class="container">
        <div class="row">
            <div class="pull-left">
                <img alt="Brand" id="topLogo" src="/public/img/logo1.png">
            </div>
            <div class="pull-right" id="moduleHeadTwo">
                <div class="topInput">
                    <input type="search" placeholder="请输入产品名称" id="topSearch"/>
                    <input type="button" value="搜索" id="topButton"/>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container topBreadcrumb">
    <div class="row">
        <div class="col-md-12">
            <div class="pull-left">
                <span class="iconfont icon-dingwei"></span>
                <span class="topPosition">当前位置：</span>
            </div>
            <div class="pull-left">
                <ol class="breadcrumb">
                    <li><a href="#">首页</a></li>
                    <li><a href="#">个人中心</a></li>
                    <li class="active">我的收藏</li>
                </ol>
            </div>
        </div>
    </div>
</div>
<div class="container backContainer">
    <div class="row">
        <div class="col-md-2 leftNav">
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">用户中心</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li><a href="/yuncai/backstage/index">首页</a></li>
            </ol>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">我的交易</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li><a href="/yuncai/backstage/order">我的订单</a></li>
                <li><a href="/yuncai/backstage/resources">我的资源单</a></li>
                <li><a href="/yuncai/backstage/purchase">我的找货</a></li>
                <li><a href="/yuncai/backstage/cart">我的购物车</a></li>
                <li><a href="/yuncai/backstage/bill">发票查询</a></li>
            </ol>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">我的白条</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li><a href="/yuncai/backstage/white">我的白条</a></li>
            </ol>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">个人中心</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <#--<li><a href="/yuncai/backstage/point">我的积分</a></li>-->
                <li class="navActive"><a href="/yuncai/backstage/coll">我的收藏</a></li>
                <li><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                <li><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                <li><a href="/yuncai/backstage/address">收货地址</a></li>
                <li><a href="/yuncai/backstage/intermediary">我的交易员</a></li>
            </ol>
        </div>
        <div class="col-md-10 rightContent">
            <ul class="collUl clearfix">
                <li class="collActive">收藏的商品</li>
                <li>收藏的供应商</li>
            </ul>
            <div class="collectionList">
                <#--<ul class="collOtherUl">-->
                    <#--<li onclick="return false">分类</li>-->
                    <#--<li class="collOtherActive">全部</li>-->
                    <#--<li>类别1（1）</li>-->
                    <#--<li>类别2（2）</li>-->
                    <#--<li>类别3（3）</li>-->
                <#--</ul>-->
                <ul class="collProductUl clearfix">
                    <li>
                        <div class="clearfix collName">
                            <div class="pull-left">产品名称</div>
                            <div class="pull-right">
                                <span class="iconfont icon-aixin"></span>
                            </div>
                        </div>
                        <div class="factoryName">厂家1</div>
                        <div class="clearfix">
                            <div class="pull-left">
                                <ul class="collInfoUl">
                                    <li>分类：类别1</li>
                                    <li>材质：材质1</li>
                                    <li>规格：规格XXX</li>
                                    <li>重量：XXX</li>
                                    <li class="collMoney">￥123.00元</li>
                                </ul>
                            </div>
                            <div class="pull-right">
                                <img class="collImg" src="/public/img/coll.png" alt="">
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="clearfix collName">
                            <div class="pull-left">产品名称</div>
                            <div class="pull-right">
                                <span class="iconfont icon-aixin"></span>
                            </div>
                        </div>
                        <div class="factoryName">厂家1</div>
                        <div class="clearfix">
                            <div class="pull-left">
                                <ul class="collInfoUl">
                                    <li>分类：类别1</li>
                                    <li>材质：材质1</li>
                                    <li>规格：规格XXX</li>
                                    <li>重量：XXX</li>
                                    <li class="collMoney">￥123.00元</li>
                                </ul>
                            </div>
                            <div class="pull-right">
                                <img class="collImg" src="/public/img/coll.png" alt="">
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="clearfix collName">
                            <div class="pull-left">产品名称</div>
                            <div class="pull-right">
                                <span class="iconfont icon-aixin"></span>
                            </div>
                        </div>
                        <div class="factoryName">厂家1</div>
                        <div class="clearfix">
                            <div class="pull-left">
                                <ul class="collInfoUl">
                                    <li>分类：类别1</li>
                                    <li>材质：材质1</li>
                                    <li>规格：规格XXX</li>
                                    <li>重量：XXX</li>
                                    <li class="collMoney">￥123.00元</li>
                                </ul>
                            </div>
                            <div class="pull-right">
                                <img class="collImg" src="/public/img/coll.png" alt="">
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="clearfix collName">
                            <div class="pull-left">产品名称</div>
                            <div class="pull-right">
                                <span class="iconfont icon-aixin"></span>
                            </div>
                        </div>
                        <div class="factoryName">厂家1</div>
                        <div class="clearfix">
                            <div class="pull-left">
                                <ul class="collInfoUl">
                                    <li>分类：类别1</li>
                                    <li>材质：材质1</li>
                                    <li>规格：规格XXX</li>
                                    <li>重量：XXX</li>
                                    <li class="collMoney">￥123.00元</li>
                                </ul>
                            </div>
                            <div class="pull-right">
                                <img class="collImg" src="/public/img/coll.png" alt="">
                            </div>
                        </div>
                    </li>
                </ul>
                    <div class="text-center">
                        <ul class="pagination" id="pageBar"></ul>
                    </div>
            </div>
            <#--<div class="hidden">-->
                <#--<ul class="collProductUl clearfix">-->
                    <#--<li>-->
                        <#--<div class="clearfix collName">-->
                            <#--<div class="pull-left">供应商名称</div>-->
                            <#--<div class="pull-right">-->
                                <#--<span class="iconfont icon-aixin"></span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="factoryName">所在地区</div>-->
                        <#--<div class="clearfix">-->
                            <#--<div class="pull-left">-->
                                <#--<ul class="collInfoUl">-->
                                    <#--<li>主营产品：</li>-->
                                    <#--<li>分类1、分类2</li>-->
                                    <#--<li>分类三、分类四</li>-->
                                <#--</ul>-->
                            <#--</div>-->
                            <#--<div class="pull-right">-->
                                <#--<img class="collImg" src="/public/img/coll.png" alt="">-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</li>-->
                    <#--<li>-->
                        <#--<div class="clearfix collName">-->
                            <#--<div class="pull-left">供应商名称</div>-->
                            <#--<div class="pull-right">-->
                                <#--<span class="iconfont icon-aixin"></span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="factoryName">所在地区</div>-->
                        <#--<div class="clearfix">-->
                            <#--<div class="pull-left">-->
                                <#--<ul class="collInfoUl">-->
                                    <#--<li>主营产品：</li>-->
                                    <#--<li>分类1、分类2</li>-->
                                    <#--<li>分类三、分类四</li>-->
                                <#--</ul>-->
                            <#--</div>-->
                            <#--<div class="pull-right">-->
                                <#--<img class="collImg" src="/public/img/coll.png" alt="">-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</li>-->
                    <#--<li>-->
                        <#--<div class="clearfix collName">-->
                            <#--<div class="pull-left">供应商名称</div>-->
                            <#--<div class="pull-right">-->
                                <#--<span class="iconfont icon-aixin"></span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="factoryName">所在地区</div>-->
                        <#--<div class="clearfix">-->
                            <#--<div class="pull-left">-->
                                <#--<ul class="collInfoUl">-->
                                    <#--<li>主营产品：</li>-->
                                    <#--<li>分类1、分类2</li>-->
                                    <#--<li>分类三、分类四</li>-->
                                <#--</ul>-->
                            <#--</div>-->
                            <#--<div class="pull-right">-->
                                <#--<img class="collImg" src="/public/img/coll.png" alt="">-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</li>-->
                    <#--<li>-->
                        <#--<div class="clearfix collName">-->
                            <#--<div class="pull-left">供应商名称</div>-->
                            <#--<div class="pull-right">-->
                                <#--<span class="iconfont icon-aixin"></span>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="factoryName">所在地区</div>-->
                        <#--<div class="clearfix">-->
                            <#--<div class="pull-left">-->
                                <#--<ul class="collInfoUl">-->
                                    <#--<li>主营产品：</li>-->
                                    <#--<li>分类1、分类2</li>-->
                                    <#--<li>分类三、分类四</li>-->
                                <#--</ul>-->
                            <#--</div>-->
                            <#--<div class="pull-right">-->
                                <#--<img class="collImg" src="/public/img/coll.png" alt="">-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</li>-->
                <#--</ul>-->
            <#--</div>-->
        </div>

    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<#--<script src="/public/yun_libs/template-native.js"></script>-->
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<#--<script src="/public/yun_js/member/mycoll.js"></script>-->
<script>
    var page =1;
    getData('/yun/member/mymerchandisecollection',true);
    $(document).on('click', '#pageBar li', function(e) {
        if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
            return false;
        }
        if ($(this).hasClass('prev')) {
            page--;
        } else if ($(this).hasClass('next')) {
            page++;
        } else {
            page = $(this).find('a').html();
        }
        if($('.collActive').text()=='收藏的商品'){
            getData('/yun/member/mymerchandisecollection',true);
        }else {
            getData('/yun/member/myprovidercollection',false);
        }
    });
    function cancelFavoriteProduct(obj) {
       var id = $(obj).parents('li').attr('id');
       $.ajax({
           url:'/yun/member/demymerchandisecollection',
           type:'get',
           data:{
               merchandiseId:id
           },
           success:function (msg) {
               if (msg.code == 0){
                   getData('/yun/member/mymerchandisecollection',true);
               }
               else {
                   alert(msg.msg);
               }
           }
       })
    }
    function cancelFavoriteShop(obj) {
        var id = $(obj).parents('li').attr('id');
        $.ajax({
            url:'/yun/member/demyprovidercollection',
            type:'get',
            data:{
                providerId:id
            },
            success:function (msg) {
                if (msg.code == 0){
                    getData('/yun/member/myprovidercollection',false);
                }
                else {
                    alert(msg.msg);
                }
            }
        })
    }
    function getData(url,isTrue) {

            $('.collProductUl').empty();
            $.ajax({
                        url: url,
                        data: {
                            page: page
                        },
                        success: function (msg) {
                            if (msg.code == 0) {
                                var list = msg.page.list;
                                if(list.length>0){

                                    for (var i = 0;i<list.length;i++){
                                        var oneList = list[i];
                                        var html;
                                        if(isTrue){
                                            html= '<li id="'+oneList.id+'">'
                                                    +'<div class="clearfix collName">'
                                                    +'<div class="pull-left titleS">'+oneList.name+'</div>'
                                                    +'<div class="pull-right collectA" onclick="cancelFavoriteProduct(this)">'
                                                    +'<span class="iconfont icon-aixin"></span>'
                                                    +'</div>'
                                                    +'</div>'
                                                    +'<div class="factoryName">'+oneList.providerId+'</div>'
                                                    +'<div class="clearfix">'
                                                    +'<div class="pull-left widthB50">'
                                                    +'<ul class="collInfoUl">'
                                                    +'<li>分类：'+oneList.subCategoryId+'</li>'
                                                    +'<li>材质：'+oneList.material+'</li>'
                                                    +'<li>规格：'+oneList.detail+'</li>'
                                                    +'<li>重量：'+oneList.weight+'</li>'
                                                    +'<li class="collMoney">&yen;'+oneList.price+'</li>'
                                                    +'</ul>'
                                                    +'</div>'
                                                    +'<div class="pull-right widthB50">'
                                                    +'<img class="collImg" src="/public/img/coll.png" alt="">'
                                                    +'</div>'
                                                    +'</div>'
                                                    +'</li>';
                                        }else {
                                            html= '<li id="'+oneList.id+'">'
                                                    +'<div class="clearfix collName">'
                                                    +'<div class="pull-left">'+oneList.name+'</div>'
                                                    +'<div class="pull-right collectB">'
                                                    +'<span class="iconfont icon-aixin" onclick="cancelFavoriteShop(this)"></span>'
                                                    +'</div>'
                                                    +'</div>'
                                                    +'<div class="factoryName">'+oneList.contactAddress+'</div>'
                                                    +'<div class="clearfix">'
                                                    +'<div class="pull-left">'
                                                    +'<ul class="collInfoUl">'
                                                    +' <li>主营产品：</li>'
                                                    +'<li>分类1、分类2</li>'
                                                    +'<li>分类三、分类四</li>'
                                                    +'</ul>'
                                                    +'</div>'
                                                    +'<div class="pull-right">'
                                                    +'<img class="collImg" src="/public/img/coll.png" alt="">'
                                                    +'</div>'
                                                    +'</div>'
                                                    +'</li>';
                                        }
//                                    $(document).on('click',$('.icon-aixin'),function () {
//                                        console.log($(this).parents('li').attr('id'));
//                                    });
//                                    $('.icon-aixin').click(function () {
//                                        console.log($(this).parents('li').attr('id'));
//                                    });

                                        $('.collProductUl').append(html);

                                    }
                                }else {
                                    $('.collectionList').html('<div class="text-center haveNone" >暂无订单</div>');
                                }
                                if(msg.page.totalPage >1){
                                    $("#pageBar").empty().pageBar({
                                        'totalpags': msg.page.totalPage,
                                        'number': msg.page.currPage
                                    });
                                }else{
                                    $("#pageBar").empty()
                                }
                            }
                            else {
                                $('.collectionList').html('<div class="text-center haveNone" >请登录</div>');
                            }
                        }
                    }
            )
        }
    $('.collUl li').each(function () {
            var that = $(this);
            that.click(function () {
                that.attr('class', 'collActive');
                that.siblings().removeAttr('class');
                if(that.text()=='收藏的商品'){
                    getData('/yun/member/mymerchandisecollection',true);
                }else {
                    getData('/yun/member/myprovidercollection',false);
                }
            });
        });

</script>
<#include "../foot.ftl">
</html>