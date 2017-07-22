<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/supplierGoods.css">
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
                    <li class="active">商品管理</li>
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
                <li ><a href="/yuncai/backstage/supplierInfo">店铺信息</a></li>
                <li class="navActive"><a href="/yuncai/backstage/supplierGoods">商品管理</a></li>
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
            <form id="GoodsForm" class="form-horizontal" role="form">
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">产品分类</label>
                    </div>
                    <div class="col-sm-9">
                        <select  class="form-control" name="productIds" >
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">产品品种</label>
                    </div>
                    <div class="col-sm-9">
                        <select  class="form-control" name="productIds" >
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">产品名称</label>
                    </div>
                    <div class="col-sm-9">
                        <select  class="form-control" name="productIds" >
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">商品标题</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="name" placeholder="填写商品标题" value="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <img src="" alt="">
                        <input type="file" accept="image/gif,image/png, image/jpeg" id="upload1">
                        <div class="mark h">
                            <div class="add"></div>
                            <div class="remove"><i class="close"></i></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <img src="" alt="">
                        <input type="file" accept="image/png, imaimage/gif,image/png, image/jpegge/jpeg" id="upload2">
                        <div class="mark h">
                            <div class="add"></div>
                            <div class="remove"><i class="close"></i></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <img src="" alt="">
                        <input type="file" accept="image/gif,image/png, image/jpeg" id="upload3">
                        <div class="mark h">
                            <div class="add"></div>
                            <div class="remove"><i class="close"></i></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <img src="" alt="">
                        <input type="file" accept="image/gif,image/png, image/jpeg" id="upload4">
                        <div class="mark h">
                            <div class="add"></div>
                            <div class="remove"><i class="close"></i></div>
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <img src="" alt="">
                        <input type="file" accept="image/gif,image/png, image/jpeg" id="upload5">
                        <div class="mark h">
                            <div class="add"></div>
                            <div class="remove"><i class="close"></i></div>
                        </div>
                    </div>

                    <#--<img src="" alt="" class="logo">-->
                    <#--<input type="file" name="" accept="image/gif, image/jpeg" id="upload" style="display: none!important;">-->
                    <#--<button id="sublogo"  type="button" class="btn btn-default" >上传logo</button>-->
                    <#--TODO-->
                </div>
                <label >点击添加商品展示图片，第一张为商品主图。支持jpeg,png,gif格式,大小不超过1MB。</label>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">商品规格</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="profile" placeholder="填写商品规格" value="">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">商品单位</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="profile" placeholder="填写商品单位" value="">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">商品原价</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="profile" placeholder="填写商品原价" value=""><p class="y">元</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">1级经销商价格</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contactName" placeholder="填写1级经销商价格" value=""><p class="y">元</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">2级经销商价格</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contactPhone" placeholder="填写2级经销商价格" value=""><p class="y">元</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">3级经销商价格</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contactAddress" placeholder="填写3级经销商价格" value=""><p class="y">元</p>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">4级经销商价格</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contactAddress" placeholder="填写4级经销商价格" value=""><p class="y">元</p>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">5级经销商价格</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contactAddress" placeholder="填写5级经销商价格" value=""><p class="y">元</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">商品库存</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="contactAddress" placeholder="填写商品库存" value=""><p class="j">件</p>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">其他属性</label>
                    </div>
                    <div class="col-sm-9">
                        <select id="category" class="form-control" name="productIds" >
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-2">
                        <label class="control-label">商品详情</label>
                    </div>
                    <div class="col-sm-9">
                        <div id="editor" style="width: 700px">

                        </div>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-9">
                        <button id="sub" type="button" class="btn btn-primary">发布</button>
                        <a  href="/yuncai/backstage/supplierGoods" class="btn btn-default">取消</a>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/wangEditor.min.js"></script>
<script src="/public/yun_js/member/supplierGoodsEdit.js"></script>
<#include "../foot.ftl">
</html>