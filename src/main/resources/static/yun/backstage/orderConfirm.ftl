<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/css/bootstrapValidator.css">
    <link rel="stylesheet" href="/public/yun_css/member/orderconfirm.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach">
    <div class="container">
        <div class="navbar-header" id="logo">
            <img alt="Brand" src="/public/img/logo_03.png">
        </div>
        <div class="collapse navbar-collapse" id="moduleHeadTwo">
            <p class="myOrderSpan">订单确认</p>
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
                    <li class="active">
                        <a href="vipauth">我的订单</a>
                    </li>
                    <li class="active">订单确认</li>
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
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">商品明细</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>商品信息</th>
                                <th></th>
                                <th>规格</th>
                                <th>单价（元）</th>
                                <th>数量</th>
                                <th>重量（吨）</th>
                                <th>总金额（元）</th>
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
                <form class="form-horizontal" id="orderForm">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">收货信息</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group has-feedback">
                                <div class="checkbox">
                                    <label><input id="invoiceStatus" type="checkbox" checked>开发票</label>
                                </div>
                            </div>
                            <div id="invoiceBody">
                                <div class="form-group">
                                    <div class="col-sm-2">
                                        <label class="control-label">发票抬头：</label>
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" id="invoiceHead" placeholder="发票抬头" value="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-2">
                                        <label class="control-label">邮寄地址：</label>
                                    </div>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" id="invoiceAddress" placeholder="邮寄地址" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">提货函信息：</label>
                                </div>
                                <div class="col-sm-5">
                                    <div class="deliveryInfo" style="display:none">
                                        <div class="row">
                                            <div class="col-sm-4">
                                                <span>选择方式：</span>
                                                <span class="deliveryMethod"></span>
                                            </div>
                                            <div class="col-sm-8">
                                                <span>提货凭证：</span>
                                                <span class="deliveryCredential"></span>
                                            </div>
                                        </div>
                                        <div>
                                            <span>备注信息：</span>
                                            <span class="deliveryComment"></span>
                                        </div>
                                    </div>
                                    <a class="btn btn-default" data-toggle="modal" data-target="#myModal">填写提货函</a>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="row">
                                <div class="col-sm-4"></div>
                                <div class="col-sm-2">已选择商品 <span class="cartCount">0</span> 件</div>
                                <div class="col-sm-4">合计（不含运费）： ￥
                                    <span class="lead text-danger priceCount">00.00</span></div>
                                <div class="col-sm-2">
                                    <a id="orderConfirm" class="btn btn-danger" href="#">确认下单<i class="fa fa-spinner" aria-hidden="true" style="display:none"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="modal fade" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button class="close" data-dismiss="modal" type="button">×</button>
                                <h4 class="modal-title text-center">填写提货函</h4>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal" role="form" id="deliveryForm">
                                    <div class="form-group">
                                        <div class="col-sm-3 text-right">
                                            <label class="control-label">选择方式</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <div class="radio">
                                                <label class="radio-inline">
                                                    <input name="deliveryMethod" value="1" type="radio" checked><span>整单提货</span></label>
                                                <label class="radio-inline">
                                                    <input name="deliveryMethod" value="2" type="radio"><span>分批提货</span></label>
                                                <label class="radio-inline">
                                                    <input name="deliveryMethod" value="3" type="radio"><span>过户</span></label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3 text-right">
                                            <label class="control-label">提货凭证</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <input type="text" name="deliveryCredential" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3 text-right">
                                            <label class="control-label">备注信息</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <textarea class="form-control" name="deliveryComment"></textarea>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button class="btn btn-primary" id="writeDelivery">确定</button>
                                <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
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
<script src="/public/yun_libs/bootstrapValidator.js"></script>
<script src="/public/yun_js/member/orderconfirm.js"></script>
<script type="text/html" id="tMainTpl">
    <% for (var i = 0; i < content.length; i++) { %>
    <tr data-group="<%=i %>">
        <td colspan="9">
            <a>
                <%=content[i][0].provider.contactName  %>
            </a>&nbsp;&nbsp;
            <a class="btn btn-default">
                联系商家
            </a>
        </td>
    </tr>
    <% for (var j = 0; j < content[i].length; j++) { %>
    <tr data-group="<%=i %>" mallcartId="<%=content[i][j].id  %>">
        <td>
            <a href="#">
                <img class="img-responsive" src="https://unsplash.imgix.net/photo-1422222948315-28aadb7a2cb8?w=1024&q=50&fm=jpg&s=cfeadbd7a991e58b553bee29a7eeca55">
            </a>
        </td>
        <td>
            <%=content[i][j].merchandise.name  %>
            <br>
            <div class="btn-group">
                <a class="btn btn-link btn-xs" href="#">
                    分类：<%=content[i][j].merchandise.product.categories[0].name  %>
                </a>
                <a class="btn btn-link btn-xs" href="#">
                    品种：<%=content[i][j].merchandise.product.subCategory.category.name  %>
                </a>
            </div>
            </br>
        </td>
        <td>
            <%=content[i][j].specification.specification  %>
        </td>
        <td>
            <%=content[i][j].specification.price  %>
        </td>
        <td>
            <%=content[i][j].amount  %>
        </td>
        <td>
            <%=content[i][j].specification.weight  %>
        </td>
        <td class="price text-danger blob">
            <%=content[i][j].price  %>
        </td>
    </tr>
    <% } %>
    <% } %>
</script>
<#include "../foot.ftl">
</html>