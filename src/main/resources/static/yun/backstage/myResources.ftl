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
    <link rel="stylesheet" href="/public/yun_libs/bootstrap-datetimepicker.min.css">
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
                    <li class="active">我的资源单</li>
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
                <li class="navActive"><a href="/yuncai/backstage/resources">我的资源单</a></li>
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
            <h4 class="">我的资源单</h4>
            <div class=" orderSearch">
                <button class="redBtn">发布资源单</button>
            </div>
            <div class="clearfix fontColor">
                <div class="pull-right clearfix">
                    <div class="searchP clearfix">
                        <span>发布时间</span>
                        <input type="text" class="dateInput" name="time1" id="startTime">
                        <span>-</span>
                        <input type="text" class="dateInput" name="time2" id="endTime" disabled>
                        <input type="text" class="searchInput" placeholder="请填写资源单名称" name="name">
                        <input type="button" value="搜索" class="searchBtn">
                    </div>
                </div>
            </div>
            <ul class="nearOrderUl clearfix marginTop20 productListUl">
                <li class="width350">资源单名称</li>
                <li class="width250">发布时间</li>
                <li class="width120">报价次数</li>
                <li class="width180">操作</li>
            </ul>
            <div class="pList">
            <#--<ul class="nearOrderUl clearfix  productLists">-->
                    <#--<li class="width350">XXXXXXXXXXXXXXXXXXXXXXXXXXX</li>-->
                    <#--<li class="width250">2017年6月28日 11:07:41</li>-->
                    <#--<li class="width120">2</li>-->
                    <#--<li class="width180">-->
                        <#--<a href="">修改</a>-->
                        <#--<a href="">删除</a>-->
                    <#--</li>-->
                <#--</ul>-->
                <#--<ul class="nearOrderUl clearfix  productLists">-->
                    <#--<li class="width350">XXXXXXXXXXXXXXXXXXXXXXXXXXX</li>-->
                    <#--<li class="width250">2017年6月28日 11:07:41</li>-->
                    <#--<li class="width120">2</li>-->
                    <#--<li class="width180">-->
                        <#--<a href="">修改</a>-->
                        <#--<a href="">删除</a>-->
                    <#--</li>-->
                <#--</ul>-->
                <#--<ul class="nearOrderUl clearfix  productLists">-->
                    <#--<li class="width350">XXXXXXXXXXXXXXXXXXXXXXXXXXX</li>-->
                    <#--<li class="width250">2017年6月28日 11:07:41</li>-->
                    <#--<li class="width120">2</li>-->
                    <#--<li class="width180">-->
                        <#--<a href="">修改</a>-->
                        <#--<a href="">删除</a>-->
                    <#--</li>-->
                <#--</ul>-->
                <#--<ul class="nearOrderUl clearfix  productLists">-->
                    <#--<li class="width350">XXXXXXXXXXXXXXXXXXXXXXXXXXX</li>-->
                    <#--<li class="width250">2017年6月28日 11:07:41</li>-->
                    <#--<li class="width120">2</li>-->
                    <#--<li class="width180">-->
                        <#--<a href="">修改</a>-->
                        <#--<a href="">删除</a>-->
                    <#--</li>-->
                <#--</ul>-->
                <div class="text-center">
                    <ul class="pagination" id="pageBar"></ul>
                </div>
            </div>
        </div>

    </div>
</div>
</body
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript" src="/public/yun_libs/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<script src="/public/yun_js/member/datePick.js"></script>
<script>
    var page =1;
    var time1,time2,name;
    function deleteResources(obj) {
        var id = $(obj).parents('ul').attr('id');
        $.ajax({
            url: '/yun/resource/delete',
            type: 'get',
            data: {
                id: id
            },
            success: function (msg) {
                if (msg.code == 0) {
                    console.log(msg);
                    getData();
                }else {
                   alert(msg.msg)
                }
            }
        })
    }
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
        $.ajax({
            url: '/yun/resource/listmy',
            type: 'get',
            data: {
                page: page,
                time1: time1,
                time2: time2,
                name: name
            },
            success: function (msg) {
                console.log(msg);
                if (msg.code == 0) {
                    $('.pList').empty();
                    var list = msg.page.list;

                    if(msg.page.list.length>0){
                        for (var i = 0; i < list.length; i++) {
                            var html = '<ul class="nearOrderUl clearfix  productLists" id="' + list[i].id + '">'
                                    + '<li class="width350">' + list[i].name + '</li>'
                                    + '<li class="width250">' + list[i].uploadTime + '</li>'
                                    + '<li class="width120">2</li>'
                                    + '<li class="width180">'
                                    + '<a href="">修改</a>'
                                    + '<a href="javascript:void(0);" onclick="deleteResources(this)">删除</a>'
                                    + '</li>'
                                    + '</ul>';
                            $('.pList').append(html);
                        }
                    }else {
                        $('.pList').html('<div class="text-center haveNone" >暂无</div>');
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
                    $('.pList').html('<div class="text-center haveNone" >请登录</div>');
                }
            }
        })
    }
    getData();
    $('.searchBtn').click(function () {
        time1 = $('input[name=time1]').val();
        time2 = $('input[name=time2]').val();
         name = $('input[name=name]').val();
        getData();
    })

</script>

<#include "../foot.ftl">
</html>