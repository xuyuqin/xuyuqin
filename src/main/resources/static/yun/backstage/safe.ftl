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
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach">
    <div class="container">
        <div class="navbar-header" id="logo">
            <img alt="Brand" src="/public/img/logo_03.png">
        </div>
        <div class="collapse navbar-collapse" id="moduleHeadTwo">
            <p class="myOrderSpan">账号安全</p>
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
                    <li class="active">账号安全</li>
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
                        <div class="col-md-12">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-success">
                                        <div class="panel-heading">
                                            <form class="form-horizontal" role="form">
                                                <div class="form-group">
                                                    <div class="col-sm-3">
                                                        <label class="control-label text-muted">
                                                            您账户的安全等级为
                                                        </label>
                                                    </div>
                                                    <div class="col-sm-9">
                                                        <div class="radio text-muted">
                                                            <label class="radio-inline">
                                                                <input name="lv-radio" type="radio" disabled>
                                                                低
                                                                </input>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="lv-radio" type="radio" disabled>
                                                                中
                                                                </input>
                                                            </label>
                                                            <label class="radio-inline">
                                                                <input name="lv-radio" type="radio" disabled>
                                                                高
                                                                </input>
                                                            </label>
                                                        </div>
                                                    </div>
                                                    <div class="col-sm-12">
                                                        <p class="text-muted">
                                                            建议根据账户安全进行操作。
                                                        </p>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                账户安全
                                            </h3>
                                        </div>
                                        <table class="table panel-body">
                                            <tbody>
                                            <tr>
                                                <td>
                                                    <a class="btn btn-link">
                                                        <i class="fa fa-check-circle fa-fw text-success">
                                                        </i>
                                                        建议修改
                                                    </a>
                                                </td>
                                                <td>
                                                    修改密码
                                                </td>
                                                <td>
                                                    为确保账号安全，建议经常修改密码
                                                </td>
                                                <td>
                                                    <a class="btn btn-default" data-target="#change-passwd" data-toggle="modal">
                                                        修改
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr id="trMobile">
                                                <td>

                                                </td>
                                                <td>
                                                    验证手机
                                                </td>
                                                <td>

                                                </td>
                                                <td>
                                                    <a class="btn btn-default verifyMobile">
                                                        修改
                                                    </a>
                                                </td>
                                            </tr>
                                            <tr id="trEmail">
                                                <td>

                                                </td>
                                                <td>
                                                    邮箱验证
                                                </td>
                                                <td>
                                                    未验证邮箱
                                                </td>
                                                <td>
                                                    <a class="btn btn-default" data-target="#change-email" data-toggle="modal">
                                                        修改
                                                    </a>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
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
<div class="modal fade" id="change-passwd">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" class="close" data-dismiss="modal" type="button">
                    ×
                </button>
                <h4 class="modal-title text-center">
                    修改密码
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="revicePasswordForm">
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label class="control-label">原始密码：</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="oldPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label class="control-label">新密码：</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="newPassword">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-4">
                            <label class="control-label">确认密码：</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="confirmPassword">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-primary" onclick="revicePassword()">确定</button>
                <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="change-email">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" class="close" data-dismiss="modal" type="button">
                    ×
                </button>
                <h4 class="modal-title text-center">
                    验证邮箱
                </h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12">
                        <form class="form-horizontal" role="form">
                            <div class="form-group has-feedback">
                                <div class="col-sm-4 text-right">
                                    <p>
                                        邮箱地址：
                                    </p>
                                </div>
                                <div class="col-sm-6">
                                    <input class="form-control" placeholder="请填写验证邮箱" type="password">
                                    </input>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a class="btn btn-default" data-dismiss="modal">
                    取消
                </a>
                <a class="btn btn-primary">
                    确定
                </a>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/template-native.js"></script>
<script src="/public/yun_libs/bootstrapValidator.js"></script>
<script src="/public/yun_js/member/safe.js"></script>
<#include "../foot.ftl">
</html>