
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
                    <li><a href="#">个人中心</a></li>
                    <li class="active">供应商认证</li>
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
                <li ><a href="/yuncai/backstage/resources">我的资源单</a></li>
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
                <li class="navActive"><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                <li><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                <li><a href="/yuncai/backstage/address">收货地址</a></li>
                <li><a href="/yuncai/backstage/intermediary">我的交易员</a></li>
            </ol>
        </div>
        <div class="col-md-10 rightContent">
            <h4 class="">供应商认证</h4>
            <div class=" orderSearch">
                <button class="redBtn">供应商申请</button>
            </div>
            <div class="fontColor vipauth">
                <div class="userInfoInput">
                    <label for="">名称：</label>
                    <div class="changeLine">
                        xxxxxxxxxxxx公司
                    </div>
                </div>
                <div class="userInfoInput">
                    <label for="">地址：</label>
                    <div class="changeLine">
                        xxxxxxxxxxxxxxxxxxxxxxxx
                    </div>
                </div>
                <div class="userInfoInput">
                    <label for="">联系电话：</label>
                    <div class="changeLine">
                        13312341234
                    </div>
                </div>
                <div class="userInfoInput">
                    <label for="">状态：</label>
                    <div class="changeLine">
                        正常
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script>
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
                }
                else {
                    $('.pList').html('<div class="text-center" style="margin-top: 20px">请登录</div>');
                }
            }
        })
</script>

<#include "../foot.ftl">
</html>