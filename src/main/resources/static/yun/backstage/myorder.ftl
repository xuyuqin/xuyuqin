<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_vzeajmrx43lq5mi.css">
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
                    <li><a href="#">我的交易</a></li>
                    <li class="active">我的订单</li>
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
                <li class="navActive"><a href="/yuncai/backstage/order">我的订单</a></li>
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
                <li><a href="/yuncai/backstage/coll">我的收藏</a></li>
                <li><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                <li><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                <li><a href="/yuncai/backstage/address">收货地址</a></li>
                <li><a href="/yuncai/backstage/intermediary">我的交易员</a></li>
            </ol>
        </div>
        <div class="col-md-10 rightContent">
            <h4 class="">我的订单</h4>
            <div class="topInput orderSearch">
                <input type="search" placeholder="按订单编号/商品编号/名称查询" id="topSearch"/>
                <input type="button" value="搜索" id="topButton"/>
            </div>
            <div class="nearOrder">
                <ul class="orderBar clearfix">
                    <li class="orderActive">全部订单（<span class="orderNum0"></span>）</li>
                    <li data-status="2">待付款（<span class="orderNum1"></span>）</li>
                    <li data-status="3">待收货（<span class="orderNum2"></span>）</li>
                    <li data-status="5">待开票（<span class="orderNum3"></span>）</li>
                    <li data-status="6">待评价（<span class="orderNum4"></span>）</li>
                    <li data-status="7">已完成（<span class="orderNum5"></span>）</li>
                    <li data-status="4">已取消（<span class="orderNum6"></span>）</li>
                </ul>
                <ul class="nearOrderUl clearfix">
                    <li class="width150">商品信息</li>
                    <li class="width301">商品详情</li>
                    <li class="width130">单件重量（吨）</li>
                    <li class="width120">价格（元）</li>
                    <li class="width135">订单状态</li>
                </ul>
                <div class="fontColor">
                    <#--<div class="orderDetail">-->
                        <#--<div class="orderTitle clearfix">-->
                            <#--<div class="pull-left">订单编号：32323223232332</div>-->
                            <#--<div class="pull-right">下单时间：2017-06-21&nbsp;13:49:14</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailPadding">-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<div class="actionPosition">待付款</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailBtn">-->
                            <#--<div class="pull-right">-->
                                <#--<button class="redBtn">在线支付</button>-->
                                <#--<button class="redBtn">白条支付</button>-->
                                <#--<button class="noneBtn">取消订单</button>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="orderDetail">-->
                        <#--<div class="orderTitle clearfix">-->
                            <#--<div class="pull-left">订单编号：32323223232332</div>-->
                            <#--<div class="pull-right">下单时间：2017-06-21&nbsp;13:49:14</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailPadding">-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<div class="actionPosition">待评价</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailBtn">-->
                            <#--<div class="pull-right">-->
                                <#--<button class="redBtn">评价订单</button>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="orderDetail">-->
                        <#--<div class="orderTitle clearfix">-->
                            <#--<div class="pull-left">订单编号：32323223232332</div>-->
                            <#--<div class="pull-right">下单时间：2017-06-21&nbsp;13:49:14</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailPadding">-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<div class="actionPosition">待收货</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailBtn">-->
                            <#--<div class="pull-right">-->
                                <#--<button class="redBtn">填提货函</button>-->
                                <#--<button class="redBtn">确认收货</button>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="orderDetail">-->
                        <#--<div class="orderTitle clearfix">-->
                            <#--<div class="pull-left">订单编号：32323223232332</div>-->
                            <#--<div class="pull-right">下单时间：2017-06-21&nbsp;13:49:14</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailPadding">-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135"></li>-->
                            <#--</ul>-->
                            <#--<div class="actionPosition">待开票</div>-->
                        <#--</div>-->
                        <#--<div class="orderDetailBtn">-->
                            <#--<div class="pull-right">-->
                                <#--<button class="redBtn">联系开票</button>-->
                                <#--<button class="redBtn">确认收票</button>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                </div>
                <div class="text-center">
                    <ul class="pagination" id="pageBar"></ul>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<#--<script src="/public/yun_libs/template-native.js"></script>-->
<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>
<script>
    var status='undefined';
    var page =1;
    getData();
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
        getData();
    });
    function getData() {
        var data;
        $('.fontColor').empty();
        if (status == 'undefined') {
            data = {
                page: page
            }
        } else {
            data = {
                status: status,
                page: page
            }
        }
        $.ajax({
            type: "get",
            url: "/yun/member/myorder",
            data: data,
            success: function (msg) {
                if (msg.code == 0) {
                    var orderCount = msg.orderCount;
                    $('.orderNum0').text(msg.page.totalCount);
                    $('.orderNum1').text(orderCount[1].TotalNUM);
                    $('.orderNum2').text(orderCount[2].TotalNUM);
                    $('.orderNum3').text(orderCount[4].TotalNUM);
                    $('.orderNum4').text(orderCount[5].TotalNUM);
                    $('.orderNum5').text(orderCount[6].TotalNUM);
                    $('.orderNum6').text(orderCount[3].TotalNUM);
                   var list =msg.page.list;
                   if(list.length>0){
                       for (var i = 0;i<list.length;i++){
                           var btn,state ;
                           var oneList = list[i];
                           switch (oneList.status){
                               case 1:
                                   state ='<div class="actionPosition">待发货</div>';
                                   btn = '';
                                   break;
                               case 2:
                                   state ='<div class="actionPosition">待付款</div>';
                                   btn = '<button class="redBtn">在线支付</button>'
                                           +'<button class="redBtn">白条支付</button>'
                                           +'<button class="noneBtn">取消订单</button>';
                                   break;
                               case 3:
                                   state ='<div class="actionPosition">待收货</div>';
                                   btn =   '<button class="redBtn">填提货函</button>'
                                           +'<button class="redBtn">确认收货</button>';
                                   break;
                               case 4:
                                   state ='<div class="actionPosition">已取消</div>';
                                   btn =  '';
                                   break;
                               case 5:
                                   state ='<div class="actionPosition">待开票</div>';
                                   btn =   '<button class="redBtn">联系开票</button>'
                                           +'<button class="redBtn">确认收票</button>';
                                   break;
                               case 6:
                                   state ='<div class="actionPosition">待评价</div>';
                                   btn =   '<button class="redBtn">评价订单</button>';
                                   break;
                               case 7:
                                   state ='<div class="actionPosition">已完成</div>';
                                   btn =   '';
                                   break;
                               default:
                                   btn='';
                                   state='';
                           }
                           var html =  '<div class="orderDetail">'
                                   +'<div class="orderTitle clearfix">'
                                   +'<div class="pull-left">订单编号：'+oneList.orderNo+'</div>'
                                   +'<div class="pull-right">下单时间：'+oneList.orderTime+'</div>'
                                   +'</div>'
                                   +'<div class="orderDetailPadding">'
                                   +'<ul class=" clearfix orderDetailLi">'
                                   +'<li class="width150 overflowD" >'+oneList.merchandiseName+'</li>'
                                   +'<li class="width301" ><div class="pull-left width230 overflowD">'+oneList.detail+'</div><div class="pull-right width50">X'+Math.ceil(oneList.amount)+'</div></li>'
                                   +'<li class="width130">'+Math.ceil(oneList.weight)+'</li>'
                                   +'<li class="width120">'+oneList.orderPrice+'</li>'
                                   +'<li class="width135"></li>'
                                   +'</ul>'
//                               +'<ul class=" clearfix orderDetailLi">'
//                               +'<li class="width150">鞍钢 冷轧卷 ST12</li>'
//                               +'<li class="width301">原材料丨脱模剂丨9.75*1500*C x2</li>'
//                               +'<li class="width130">9.62</li>'
//                               +'<li class="width120">3520</li>'
//                               +'<li class="width135"></li>'
//                               +'</ul>'
                                   +state
                                   +'</div>'
                                   +'<div class="orderDetailBtn">'
                                   +'<div class="pull-right">'
                                   +btn
                                   +'</div>'
                                   +'</div>'
                                   +'</div>';
                           $('.fontColor').append(html);
                       }

                   }else {
                       $('.fontColor').html('<div class="text-center haveNone" >暂无订单</div>');
                   }
                    if(msg.page.totalPage >1){
                        $("#pageBar").empty().pageBar({
                            'totalpags': msg.page.totalPage,
                            'number': msg.page.currPage
                        });
                    }else{
                        $("#pageBar").empty()
                    }
                } else {
                    $('.fontColor').html('<div class="text-center haveNone" >请登录</div>');
                }
            }
        });
    }
    $('.orderBar li').each(function (index) {
        var that = $(this);
        that.click(function () {
            that.attr('class', 'orderActive');
            that.siblings().removeAttr('class');
            status = that.attr('data-status');
            console.log(status);
            getData(1, status)

        });
    })
</script>
<#--<script src="/public/yun_js/member/myorder.js"></script>-->
<#--<script id="tMainTpl" type="text/html">-->
<#--<div class="tMainHead panel-body">-->

<#--<div class="col-md-12">-->
<#--<div class="col-md-2">商品信息</div>-->
<#--<div class="col-md-2">分类</div>-->
<#--<div class="col-md-2">品种</div>-->
<#--<div class="col-md-2">规格</div>-->
<#--<div class="col-md-2">单件重量(吨)</div>-->
<#--<div class="col-md-2">单价(元)</div>-->
<#--</div>-->
<#--</div>-->
<#--<% for (var i = 0; i < content.length; i++) { %>-->
<#--<div class="panel panel-default"  data-id="<%= content[i].id %>">-->
<#--<div class="col-md-12 orderlistHead">-->
<#--<div class="col-md-8">-->
<#--<a class="btn btn-link dfFont" href="orderlist?orderNo=<%= content[i].orderNo %>">订单编号：<%= content[i].orderNo %></a>-->
<#--<a class="btn btn-link dfFont" href="orderlist?orderNo=<%= content[i].orderNo %>">订单详情</a>-->
<#--</div>-->
<#--<div class="col-md-4 text-right">-->
<#--<span class="btn btn-link dfFont">下单时间：<%= content[i].orderTime %></span>-->
<#--</div>-->
<#--</div>-->
<#--<div class="panel-body">-->

<#--<% for (var j = 0; j < content[i].orderMerchandises.length; j++) { %>-->
<#--<div class="col-md-12 tMainList" id="<%= content[i].orderMerchandises[j].id %>">-->
<#--<div class="col-md-2 orangeFont textEllipsis" title="<%= content[i].orderMerchandises[j].merchandise.name %>">-->
<#--<%= content[i].orderMerchandises[j].merchandise.name %>-->
<#--</div>-->
<#--<div class="col-md-2 dfFont">-->
<#--<%= content[i].orderMerchandises[j].merchandise.product.categories[0].name %>-->
<#--</div>-->
<#--<div class="col-md-2 blueFont">-->
<#--<%= content[i].orderMerchandises[j].merchandise.product.categories[0].parent.name %>-->
<#--</div>-->
<#--<div class="col-md-2 blueFont">-->
<#--<%= content[i].orderMerchandises[j].specification.specification %>-->
<#--</div>-->
<#--<div class="col-md-2 blueFont">-->
<#--<%= content[i].orderMerchandises[j].specification.weight %>-->
<#--</div>-->
<#--<div class="col-md-2 orangeFont">-->
<#--<%= content[i].orderMerchandises[j].specification.price %>-->
<#--</div>-->
<#--</div>-->


<#--<% } %>-->

<#--<div class="col-md-12 orderlistFoot">-->
<#--<div class="col-md-8">-->
<#--<p>-->
<#--<span class="dfFont">订单状态：-->
<#--<% if(content[i].status == 1){ %>-->
<#--待发货-->
<#--<% }else if(content[i].status == 2){ %>-->
<#--待付款-->
<#--<% }else if(content[i].status == 3){ %>-->
<#--待收货-->
<#--<% }else if(content[i].status == 4){ %>-->
<#--已取消-->
<#--<% }else if(content[i].status == 5){ %>-->
<#--待开票-->
<#--<% }else if(content[i].status == 6){ %>-->
<#--待评价-->
<#--<% }else if(content[i].status == 7){ %>-->
<#--已完成-->
<#--<% } %>-->
<#--</span>-->
<#--</p>-->

<#--<p>-->
<#--<span class="dfFont paymentExpire"></span>-->
<#--</p>-->
<#--</div>-->
<#--<div class="col-md-4">-->
<#--<p>-->
<#--<span class="dfFont">订单总额：<span class="orangeFont"><%= content[i].orderPrice %></span></span>-->
<#--</p>-->
<#--</div>-->
<#--</div>-->
<#--<div class="col-md-12 text-right">-->
<#--<% if(content[i].status == "2"){ %>-->
<#--<a class="btn btn-danger orangeBtn payOnline" data-orderNo=<%=content[i].orderNo %> >在线支付</a>-->
<#--<a class="btn btn-danger orangeBtn payCredit" data-orderNo=<%=content[i].orderNo %> >白条支付</a>-->
<#--<a class="btn btn-link deleteOrder" data-orderNo=<%=content[i].orderNo %> >取消订单</a>-->
<#--<% }else if(content[i].status == "3"){ %>-->
<#--<% if(content[i].deliveryMethod == undefined){ %>-->
<#--<a class="btn btn-danger orangeBtn pickLetter" data-orderNo=<%=content[i].orderNo %> >填提货函</a>-->
<#--<% } %>-->
<#--<a class="btn btn-danger orangeBtn confirm" data-toggle="modal" data-target="#" data-orderNo=<%=content[i].orderNo %> >确认收货</a>-->
<#--<% }else if(content[i].status == "6"){ %>-->
<#--<a class="btn btn-danger orangeBtn evaluate" data-orderNo=<%=content[i].orderNo %> >评价订单</a>-->
<#--<% }else if(content[i].status == "5"){ %>-->
<#--<% if(content[i].invoiceStatus == 3){ %>-->
<#--<a class="btn btn-danger orangeBtn invoice" data-orderNo=<%=content[i].orderNo %> >联系开票</a>-->
<#--<% } %>-->
<#--<a class="btn btn-danger orangeBtn received" data-orderNo=<%=content[i].orderNo %> >确认收票</a>-->
<#--<% } %>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<% } %>-->
<#--</script>-->
<#include "../foot.ftl">
</html>