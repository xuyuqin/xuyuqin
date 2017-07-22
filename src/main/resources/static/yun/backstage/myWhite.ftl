<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <#--<link rel="stylesheet" href="/public/yun_css/member/mywhite.css">-->
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
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-8">
                                <form class="form-horizontal" role="form" id="creditInfo">

                                </form>
                            </div>
                            <div class="col-md-4">
                                <h2>
                                    客服专线
                                </h2>
                                <p>
                                    021-35906666
                                </p>
                                <p>
                                    工作日（9:00-17:00 )
                                </p>
                            </div>
                        </div>
                        <hr />
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
                                            待还款
                                        </option>
                                        <option value="2">
                                            已还款
                                        </option>
                                    </select>
                                </div>
                                <div class="col-sm-1 text-right">
                                    <label class="control-label">
                                        时间
                                    </label>
                                </div>
                                <div class="col-sm-4">
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
                                <div class="col-sm-4 text-right">
                                    <a id="btnSearch" class="btn btn-default" type="submit">
                                        搜索
                                    </a>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>
                                            状态
                                        </th>
                                        <th>
                                            订单编号
                                        </th>
                                        <th>
                                            下单时间
                                        </th>
                                        <th>
                                            白条期限
                                        </th>
                                        <th>
                                            白条使用
                                        </th>
                                        <th>
                                            已还款
                                        </th>
                                        <th>
                                            待还款
                                        </th>
                                        <th>
                                            滞纳金
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
                        <div class="row">
                            <div class="col-md-12 text-center">
                                <ul class="pagination" id="pageContainer">

                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="repayment">
    <div class="modal-dialog">
        <div class="modal-content">

        </div>
    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/template-native.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script src="/public/yun_js/member/mywhite.js"></script>
<script type="text/html" id="tMainTpl">
    <% for (var i = 0; i < content.length; i++) { %>
    <tr sid="<%=content[i].id %>">
        <td>
            <% if(content[i].status == 1){ %>
            待还款
            <% }else if(content[i].status == 2){ %>
            已还款
            <% } %>
        </td>
        <td>
            <%=content[i].orderNo  %>
        </td>
        <td>
            <%=content[i].loanTime  %>
        </td>
        <td>
            <%=content[i].deadline  %>
        </td>
        <td>
            <%=content[i].amount  %>
        </td>
        <td>
            <%=content[i].paidAmount  %>
        </td>
        <td>
            <%=(content[i].amount -content[i].paidAmount)  %>
        </td>
        <td>
            <%=content[i].penalty  %>
        </td>
        <td>
            <a class="btn btn-default btnRepayment" sid=<%=content[i].id %> data-target="#repayment" data-toggle="modal">
                还款
            </a>
        </td>
    </tr>
    <% } %>
</script>

<script type="text/html" id="creditTpl">
    <div class="form-group">
        <div class="col-sm-3 text-right">
            <label class="control-label">
                公司抬头
            </label>
        </div>
        <div class="col-sm-9">
            <label class="control-label">
                <%=companyName %>
            </label>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-3 text-right">
            <label class="control-label">
                白条总额度：
            </label>
        </div>
        <div class="col-sm-9">
            <label class="control-label">
                <%=credit %>
            </label>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-3 text-right">
            <label class="control-label">
                已使用：
            </label>
        </div>
        <div class="col-sm-9">
            <label class="control-label">
                <%=usedCredit %>
            </label>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-3 text-right">
            <label class="control-label">
                剩余可用：
            </label>
        </div>
        <div class="col-sm-9">
            <label class="control-label">
                <%=credit-usedCredit %>
            </label>
        </div>
    </div>
</script>

<script type="text/html" id="modalTpl">
    <div class="modal-header">
        <button aria-hidden="true" class="close" data-dismiss="modal" type="button">
            ×
        </button>
        <h4 class="modal-title">
            白条还款
        </h4>
    </div>
    <div class="modal-body">
        <div class="row">
            <div class="col-md-12">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <p>
                                订单编号：
                            </p>
                        </div>
                        <div class="col-sm-9">
                            <p>
                                <%=orderNo %>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-6 text-right">
                            <p>
                                下单时间：
                            </p>
                        </div>
                        <div class="col-sm-6">
                            <p>
                                <%=loanTime %>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 text-right">
                            <p>
                                白条使用：
                            </p>
                        </div>
                        <div class="col-sm-6">
                            <p>
                                <%=amount %>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 text-right">
                            <p>
                                待还款：
                            </p>
                        </div>
                        <div class="col-sm-6">
                            <p>
                                <%=amount-paidAmount %>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-6">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-6 text-right">
                            <p>
                                白条期限：
                            </p>
                        </div>
                        <div class="col-sm-6">
                            <p>
                                <%=deadline %>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 text-right">
                            <p>
                                已还款：
                            </p>
                        </div>
                        <div class="col-sm-6">
                            <p>
                                <%=paidAmount %>
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-6 text-right">
                            <p>
                                滞纳金：
                            </p>
                        </div>
                        <div class="col-sm-6">
                            <p>
                                <%=penalty %>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <hr>
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <div class="col-sm-3 text-right">
                    <label class="control-label" for="inputEmail3">
                        需还款：
                    </label>
                </div>
                <div class="col-sm-8">
                    <input class="form-control" disabled="" id="inputEmail3" placeholder=<%=amount-paidAmount %> type="text">
                    </input>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-3 text-right">
                    <label class="control-label">
                        选择方式：
                    </label>
                </div>
                <div class="col-sm-8">
                    <div class="radioPayType">
                        <label class="radio-inline">
                            <input type="radio" name="payType" value="0">
                            支付宝
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="payType" value="1" checked>
                            银行卡
                            </input>
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-8">
                    <div class="radioBank">
                        <label class="radio-inline">
                            <input type="radio" name="bank" checked>
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="bank">
                            A银行
                            </input>
                        </label>
                    </div>
                </div>
            </div>
        </form>
        <hr>
        </hr>
        </hr>
    </div>
    <div class="modal-footer">
        <a class="btn btn-default modalCancel" data-dismiss="modal">
            取消
        </a>
        <a class="btn btn-primary modalConfirm" sid=<%=id %>>
            确定
        </a>
    </div>
</script>
<#include "../foot.ftl">
</html>