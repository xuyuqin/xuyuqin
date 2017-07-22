<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/bill.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach">
    <div class="container">
        <div class="navbar-header" id="logo">
            <img alt="Brand" src="/public/img/logo_03.png">
        </div>
        <div class="collapse navbar-collapse" id="moduleHeadTwo">
            <p class="myOrderSpan">发票查询</p>
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
                    <li class="active">发票查询</li>
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
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="form-group">
                                <div class="col-sm-1 text-right">
                                    <label class="control-label">
                                        状态
                                    </label>
                                </div>
                                <div class="col-sm-2">
                                    <select id="status" class="form-control">
                                        <option value="0">
                                            全部
                                        </option>
                                        <option value="1">
                                            已开票
                                        </option>
                                        <option value="2">
                                            未开票
                                        </option>
                                        <option value="3">
                                            未申请
                                        </option>
                                    </select>
                                </div>
                                <div class="col-sm-1 text-right">
                                    <label class="control-label">
                                        时间
                                    </label>
                                </div>
                                <div class="col-sm-5">
                                    <div class="input-group">
                                        <input id="begin_at" class="form-control" placeholder="开始时间" type="date">
                                        <span class="input-group-addon">
                                                        <i class="fa fa-minus">
                                                        </i>
                                                    </span>
                                        <input id="end_at" class="form-control" placeholder="结束时间" type="date">
                                        </input>
                                        </input>
                                    </div>
                                </div>
                                <div class="col-sm-2">
                                    <input id="searchName" class="form-control" placeholder="公司抬头" type="text">
                                    </input>
                                </div>
                                <div class="col-sm-1">
                                    <a id="btnSearch" class="btn btn-default orangeBtn" type="submit">
                                        搜索
                                    </a>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-md-12 paddingZreo">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>
                                            发票状态
                                        </th>
                                        <th>
                                            订单编号
                                        </th>
                                        <th>
                                            下单时间
                                        </th>
                                        <th>
                                            发票抬头
                                        </th>
                                        <th>
                                            发票总额
                                        </th>
                                    </tr>
                                    </thead>
                                    <tbody id="tMain">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <ul class="pagination" id="pageContainer">
                                    <div class="loading text-center" style="display:none">
                                        <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                                        <span class="sr-only">Loading...</span>
                                    </div>
                                </ul>
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
<script src="/public/yun_js/member/bill.js"></script>
<script type="text/html" id="pageTpl">
    <% if(!first) { %>
    <li class="prev"><a href="#">Prev</a></li>
    <% } %>
    <% for (var i = 0; i < totalPages; i++) { %>
    <% if(i == number) { %>
    <li class="active" >
        <% } else { %>
    <li>
        <% } %>
        <a href="#"><%= i+1 %></a></li>
    <% } %>
    <% if(!last) { %>
    <li class="next"><a href="#">Next</a></li>
    <% } %>
</script>
<script type="text/html" id="tMainTpl">
    <% for (var i = 0; i < content.length; i++) { %>
    <tr sid="<%=content[i].id ">
        <% if(content[i].invoiceStatus == 1){ %>
        <td class="color">  已开票
            <% }else if(content[i].invoiceStatus == 2){ %>
        <td class="color">  未开票
            <% }else if(content[i].invoiceStatus == 3){ %>
        <td class="color">  未申请
            <% } %>
        </td>
        <td><%=content[i].orderNo  %></td>
        <td><%=content[i].orderTime  %></td>
        <td><%=content[i].invoiceHead  %></td>
        <td>￥<%=content[i].orderPrice  %></td>
    </tr>
    <% } %>
</script>
<#include "../foot.ftl">
</html>