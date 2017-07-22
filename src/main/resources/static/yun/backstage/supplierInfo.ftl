<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/supplierInfo.css">
    <link rel="stylesheet" href="/public/yun_libs/select2.css">
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
                    <li class="active">店铺信息</li>
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
                    <div class="pull-left">我的后台</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li class="navActive"><a href="/yuncai/backstage/supplierInfo">店铺信息</a></li>
                <li ><a href="/yuncai/backstage/supplierGoods">商品管理</a></li>
                <li ><a href="/yuncai/backstage/supplierInquiry">询盘管理</a></li>
                <li ><a href="/yuncai/backstage/supplierMarketing">营销管理</a></li>
                <li ><a href="/yuncai/backstage/supplierOrder">订单状态</a></li>
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
                <li><a href="/yuncai/backstage/coll">我的收藏</a></li>
                <li><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                <li><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                <li><a href="/yuncai/backstage/address">收货地址</a></li>
                <li><a href="/yuncai/backstage/intermediary">我的交易员</a></li>
            </ol>
        </div>
        <div class="col-md-10 rightContent">
            <div class="supplierInfo">
                <h4 class="">供应商基本信息</h4>
                <form id="supplierForm" class="form-horizontal" role="form">
                    <div class="imgArea">
                        <img src="" alt="" class="logo">
                        <input type="file" name="" accept="image/png, image/jpeg" id="upload" style="display: none!important;">
                        <button id="sublogo"  type="button" class="btn btn-default" >上传logo</button>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">供应商名称</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="name" placeholder="填写供应商名称" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">主营产品</label>
                        </div>
                        <div class="col-sm-9">
                            <select id="category" class="form-control" name="productIds" multiple="multiple">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">供应商简介</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="profile" placeholder="填写供应商简介" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">联系人</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="contactName" placeholder="填写联系人" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">联系电话</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="contactPhone" placeholder="填写联系电话" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">联系地址</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="contactAddress" placeholder="填写联系地址" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-9">
                            <button id="sub" type="button" class="btn btn-primary">保存</button>
                        </div>
                    </div>
                </form>

            </div>
            <div class="supplierScore">
                <h4 class="">供应商评分</h4>
                <div class="score">

                    <label class="quality">产品质量:</label>
                    <div class="qualityScore">

                    </div>
                    <label class="price"> 产品价格:</label>
                    <div class="priceScore">

                    </div>
                    <label class="service">客户服务:</label>
                    <div class="serviceScore">

                    </div>

                </div>
                <div class="recently">
                    <h4>近一个月</h4>
                    <label class="title">商铺营业额:</label> <label  class="yuan">9999999</label><label  class="unit">元</label>
                    <label class="title">成交订单数:</label> <label  class="num">200</label><label  class="unit">单</label>
                </div>

            </div>
        </div>
    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/select2.js"></script>

<#--<script src="/public/yun_js/myModal.js"></script>-->
<script src="/public/yun_js/member/supplierInfo.js"></script>
<#include "../foot.ftl">
</html>