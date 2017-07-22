<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                    <li><a href="/yuncai/index">首页</a></li>
                    <li><a href="/yuncai/backstage/index">个人中心</a></li>
                    <li class="active">首页</li>
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
                <li class="navActive"><a href="/yuncai/backstage/index">首页</a></li>
            </ol>
        <#if isProvider == 1>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">我的后台</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li ><a href="/yuncai/backstage/supplierInfo">店铺信息</a></li>
                <li ><a href="/yuncai/backstage/supplierGoods">商品管理</a></li>
                <li ><a href="/yuncai/backstage/supplierInquiry">询盘管理</a></li>
                <li ><a href="/yuncai/backstage/supplierMarketing">营销管理</a></li>
                <li ><a href="/yuncai/backstage/supplierOrder">订单状态</a></li>
            </ol>
        </#if>
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
                <li><a href="/yuncai/backstage/coll">我的收藏</a></li>
                <li><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                <li><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                <li><a href="/yuncai/backstage/address">收货地址</a></li>
                <li><a href="/yuncai/backstage/intermediary">我的交易员</a></li>
            </ol>
        </div>
        <div class="col-md-10 rightContent">
            <h4 class="">账户概况</h4>
            <div class="personInfo">
                <div class="pull-left halfCircle"></div>
                <div class="pull-right rightInfo">
                    <div class=" rightInfoContent">
                        <div class=" row">
                            <div class="col-md-3 backC">
                                <div class="backName">admin</div>
                                <div class="clearfix backId">
                                    <span class="iconfont icon-shoujirenzheng "></span>
                                    <span class="iconfont icon-brand "></span>
                                </div>
                                <div class="backGo"><a href="/yuncai/backstage/userinfo">立即完善个人信息</a></div>
                            </div>
                            <div class="col-md-6 padding">
                                <div class="backMyPoint">
                                    <div class="myPoint">我的资产</div>
                                    <div class="myPointNum">
                                        <span class="iconfont icon-jifen"></span>&nbsp;&nbsp;
                                        <span>积分：999</span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                           <button class="authenticationBtn">企业账号认证</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="headImg">
                    <img src="/public/img/intermediary.png" alt="" id="headerImg">
                </div>
            </div>
            <div class="orderManage nearOrder">
                <h4>订单管理</h4>
                <ul class="orderManageUl">
                    <li>
                        <div class="orderManageD">
                            <div class="pull-left">
                                <span class="iconfont icon-daifukuan"></span>
                            </div>
                            <div class="pull-left rightC">
                                <div>待付款订单</div>
                                <p class="orderNum0">1</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="orderManageD">
                            <div class="pull-left">
                                <span class="iconfont icon-huoche"></span>
                            </div>
                            <div class="pull-left rightC">
                                <div>待收货订单</div>
                                <p class="orderNum1">1</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="orderManageD">
                            <div class="pull-left">
                                <span class="iconfont icon-kaipiaoyaoqiu"></span>
                            </div>
                            <div class="pull-left rightC">
                                <div>待开票订单</div>
                                <p class="orderNum2">1</p>
                            </div>
                        </div>
                    </li>
                    <li>
                        <div class="orderManageD">
                            <div class="pull-left">
                                <span class="iconfont icon-pingjia"></span>
                            </div>
                            <div class="pull-left rightC">
                                <div>待评价订单</div>
                                <p class="orderNum3">1</p>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="nearOrder">
                <h4>最近订单</h4>
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
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
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
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
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
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
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
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
                            <#--<ul class=" clearfix orderDetailLi">-->
                                <#--<li class="width150">鞍钢 冷轧卷 ST12</li>-->
                                <#--<li class="width301">原材料丨脱模剂丨9.75*1500*C    x2</li>-->
                                <#--<li class="width130">9.62</li>-->
                                <#--<li class="width120">3520</li>-->
                                <#--<li class="width135">待付款</li>-->
                            <#--</ul>-->
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
<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>

<script>
    //分页
    var page =1;
    var status ='undefined';
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
    function getData( ) {
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
                    $('.orderNum0').text(orderCount[1].TotalNUM);
                    $('.orderNum1').text(orderCount[2].TotalNUM);
                    $('.orderNum2').text(orderCount[4].TotalNUM);
                    $('.orderNum3').text(orderCount[5].TotalNUM);
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
                        $('.fontColor').html('<div class="text-center" style="margin-top: 20px">暂无订单</div>');
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
                    $('.fontColor').html('<div class="text-center" style="margin-top: 20px">请登录</div>');
                }
            }
        });
    }
    $.ajax({
        url:'/yun/member/myinfo',
        type:'get',
        success:function (msg) {
            console.log(msg);
            if (msg.code==0){
                $('.backName').text(msg.info.name);
//                $('#headerImg').attr('src',msg.info.avatar);
            }
        }
    });
$('.authenticationBtn').click(function () {
    window.location.href = '/yuncai/backstage/vipauth';
})
</script>

<#include "../foot.ftl">
</html>