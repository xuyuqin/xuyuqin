<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/mallCart.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach">
    <div class="container">
        <div class="navbar-header" id="logo">
            <img alt="Brand" src="/public/img/logo_03.png">
        </div>
        <div class="collapse navbar-collapse" id="moduleHeadTwo">
            <p class="myOrderSpan">我的购物车</p>
            <a class="btn" href="www/home">返回首页</a>

        </div>
    </div>
</div>
<div class="hidden-sm hidden-xs section paddingZreo">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="breadcrumb">
                    <li class="active">
                        <a href="/yuncai/backstage/index">个人中心</a>
                    </li>
                    <li class="active">我的购物车</li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="section paddingZreo">
    <div class="container">
        <div class="row">

            <div class="col-md-2 paddingZreo">
                <div class="customerCenter">个人中心</div>
                <div class="customerList">
                <#--<ol class="list-unstyled">-->
                <#--<li>-->
                <#--<i class="fa fa-minus"></i> 我的后台-->
                <#--</li>-->
                <#--<li><a href="">订单管理</a></li>-->
                <#--<li><a href="">商品管理</a></li>-->
                <#--<li><a href="">营销管理</a></li>-->
                <#--<li><a href="">店铺信息</a></li>-->
                <#--</ol>-->

                    <ol class="list-unstyled">
                        <li>
                            <i class="fa fa-minus"></i> 我的交易
                        </li>
                        <li><a href="/yuncai/backstage/order">我的订单</a></li>
                        <li><a href="/yuncai/backstage/resources">我的资源单</a></li>
                        <li><a href="/yuncai/backstage/purchase">我的求购单</a></li>
                        <li><a href="/yuncai/backstage/cart">我的购物车</a></li>
                        <li><a href="/yuncai/backstage/bill">发票查询</a></li>
                    </ol>
                    <ol class="list-unstyled">
                        <li>
                            <i class="fa fa-minus"></i> 我的白条
                        </li>
                        <li><a href="/yuncai/backstage/white">我的白条</a></li>
                    </ol>
                    <ol class="list-unstyled">
                        <li>
                            <i class="fa fa-minus"></i> 个人中心
                        </li>
                        <li><a href="/yuncai/backstage/point">我的积分</a></li>
                        <li><a href="/yuncai/backstage/coll">我的收藏</a></li>
                        <li><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                        <li><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                        <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                        <li><a href="/yuncai/backstage/address">收货地址</a></li>
                    </ol>
                </div>
            </div>

            <div class="col-md-10">
                <div style="border:1px solid #ddd;padding:20px 0">
                    <ul class="nav nav-tabs" role="tablist" style="border:none;padding: 0px 0 15px 20px;">
                        <li role="presentation" class="active" style="border-right:1px solid">
                            <a href="#mall-goods" class="colorOrange" aria-controls="mall-goods" role="tab"
                               data-toggle="tab" style="border:none;">
                                商城商品（<span class="colorOrange">${countCart!"0"}</span>）
                            </a>
                        </li>
                        <li role="presentation" style="border:none;">
                            <a href="../member/pointcart" style="border:none;">
                                积分商品（<span class="">3</span>）
                            </a>
                        </li>
                    </ul>
                    <div class="tab-content clearfix" style="border:none;">
                        <div class="tab-pane active" id="mall-goods">
                            <div class="panel panel-default" style="border:none;">
                                <!-- <div class="panel-heading text-right">
                                    <div>
                                        已选择商品
                                        <span class="text-danger cartCount">
                                                          0
                                                      </span> 件，合计（不含运费）：￥
                                        <span class="text-danger priceCount">
                                                          0.00
                                                      </span>
                                        <a class="btn btn-primary orderBuy">
                                                          结算
                                                      </a>
                                    </div>
                                </div> -->
                                <div class="col-md-12">
                                    <div class="panel-body" style="border:none">
                                        <div class="row">
                                            <div class="col-md-12 paddingZreo">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th colspan="2">
                                                            <input type="checkbox" class="checkboxOne"> 全选
                                                            </input>
                                                        </th>
                                                        <th>
                                                            商品信息
                                                        </th>
                                                        <th>
                                                            规格
                                                        </th>
                                                        <th>
                                                            单价
                                                        </th>
                                                        <th>
                                                            数量
                                                        </th>
                                                        <th>
                                                            重量
                                                        </th>
                                                        <th>
                                                            总金额
                                                        </th>
                                                        <th>
                                                            操作
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody id="tMain">
                                                    <div class="loading text-center" style="display:none">
                                                        <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                                                        <span class="sr-only">Loading...</span>
                                                    </div>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="panel-footer text-right ">
                                        已选择商品
                                        <span class="text-danger cartCount">
                                              0
                                          </span> 件，合计（不含运费）：￥
                                        <span class="text-danger priceCount">
                                              0.00
                                          </span>
                                        <a class="btn btn-primary orderBuy">
                                            结算
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/template-native.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script type="text/html" id="tMainTpl">
    <% for (var i = 0; i < content.length; i++) { %>
    <tr data-group="<%=i %>">
        <td colspan="9">
            <input type="checkbox" class="checkboxTwo">
            <%=content[i][0].provider.contactName %>
            </input>&nbsp;&nbsp;
            <a class="btn btn-default">
                联系商家
            </a>
        </td>
    </tr>
    <% for (var j = 0; j < content[i].length; j++) { %>
    <tr data-group="<%=i %>" mallcartId="<%=content[i][j].id  %>">
        <td class="<%=content[i][j].merchandise.id %>">
            <input type="checkbox" class="checkboxThree">
            </input>
        </td>
        <td>
            <a href="#">
                <!-- <img class="img-responsive" src="<%=content[i][j].merchandise.images.url  %>"/> -->
                <img class="img-responsive"
                     src="https://unsplash.imgix.net/photo-1422222948315-28aadb7a2cb8?w=1024&q=50&fm=jpg&s=cfeadbd7a991e58b553bee29a7eeca55">
            </a>
        </td>
        <td>
            <%=content[i][j].merchandise.name %>
            <br>
            <div class="btn-group">
                <a class="btn btn-link btn-xs" href="#">
                    分类：<%=content[i][j].merchandise.product.categories[0].parent.name %>
                </a>
                <a class="btn btn-link btn-xs" href="#">
                    品种：<%=content[i][j].merchandise.product.categories[0].name %>
                </a>
            </div>
            </br>
        </td>
        <td>

            <%=content[i][j].specification.specification %>
        </td>
        <td>
            <%=content[i][j].specification.price %>
        </td>
        <td>
            <input class="form-control" type="number" min="1" value="<%=content[i][j].amount  %>">
            </input>
        </td>
        <td>
            <%=content[i][j].specification.weight %>
        </td>
        <td class="price">
            <% var price = content[i][j].specification.price*content[i][j].amount %>
            <%=price %>
        </td>
        <td>
            <a class="btn btn-default del" mallcartId="<%=content[i][j].id  %>">
                删除
            </a>
        </td>
    </tr>
    <% } %>
    <% } %>
</script>
<script src="/public/yun_js/member/mallcart.js"></script>
<#include "../foot.ftl">
</html>