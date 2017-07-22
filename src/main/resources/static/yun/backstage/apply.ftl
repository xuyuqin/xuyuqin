<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/css/fileinput.min.css">
    <link rel="stylesheet" href="/public/css/default.css">
    <link rel="stylesheet" href="/public/css/bootstrapValidator.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach">
    <div class="container">
        <div class="navbar-header" id="logo">
            <img alt="Brand" src="/public/img/logo_03.png">
        </div>
        <div class="collapse navbar-collapse" id="moduleHeadTwo">
            <p class="myOrderSpan">供应商申请</p>
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
                        <a href="vipauth">供应商账号认证</a>
                    </li>
                    <li class="active">供应商账号认证申请</li>
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
                            <div class="col-md-2 hidden-sm hidden-xs"></div>
                            <div class="col-md-8">
                                <form class="form-horizontal" role="form" enctype="multipart/form-data" data-bv-message="This value is not valid" data-bv-feedbackicons-valid="glyphicon glyphicon-ok" data-bv-feedbackicons-invalid="glyphicon glyphicon-remove" data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label for="inputName" class="control-label">类型：</label>
                                        </div>
                                        <div class="col-sm-8">
                                            <div class="radio" name="type">
                                                <label class="radio-inline">
                                                    <input type="radio" name="licenseType" value="0" checked>个人</label>
                                                <label class="radio-inline">
                                                    <input type="radio" name="licenseType" value="1">企业</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label for="inputName" class="control-label">名称：</label>
                                        </div>
                                        <div class="col-sm-8 text-right">
                                            <input type="text" class="form-control" name="name" id="inputName" data-bv-notempty="true" data-bv-notempty-message="不能为空" placeholder="请填写个人/企业名称">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label for="inputAddress" class="control-label">地址：</label>
                                        </div>
                                        <div class="col-sm-8 text-right">
                                            <input type="text" class="form-control" name="address" id="inputAddress" data-bv-notempty="true" data-bv-notempty-message="不能为空" placeholder="请填写个人/企业地址">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label for="inputMobile" class="control-label">联系电话：</label>
                                        </div>
                                        <div class="col-sm-8 text-right">
                                            <input type="text" class="form-control" name="phone" id="inputMobile" data-bv-notempty="true" data-bv-notempty-message="不能为空" data-bv-phone="true" data-bv-phone-message="请填写正确的手机号码"  placeholder="请填写个人/企业联系电话">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label for="inputCarded" class="control-label">身份证号码：</label>
                                        </div>
                                        <div class="col-sm-8 text-right">
                                            <input type="text" class="form-control" name="carded" id="inputCarded" data-bv-notempty="true" data-bv-notempty-message="不能为空"
                                                   data-bv-regexp="true" data-bv-regexp-regexp="(^\d{15}$)|(^\d{17}([0-9]|X|x)$)" data-bv-regexp-message="请填写正确的身份证号码" placeholder="请填写个人身份证号码">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label class="control-label">相关证件：</label>
                                        </div>
                                        <div class="col-sm-8 text-right">
                                            <input name="licensePackage" style="display:none;" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                                            <input id="licensePackageFile" name="licensePackageFile" type="file" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                                        </div>
                                        <div class="col-sm-offset-3 col-sm-8">
                                            <p class="help-block">
                                                请上传zip、rar的压缩包文档，包括：<br>
                                                个人用户请上传手持身份证正反面清晰图片<br>
                                                企业用户请上传营业执照、组织机构代码证、税务登记证、开户许可证、企业认证授权书 或 企业三证合一之后的营业执照、开户许可证、企业认证授权书
                                            </p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-8">
                                            <button type="submit" class="btn btn-default">提交申请</button>
                                        </div>
                                    </div>
                                </form>
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
<script src="/public/yun_libs/fileinput.min.js"></script>
<script src="/public/yun_libs/fileinput_locale_zh.js"></script>
<script src="/public/yun_js/member/apply.js"></script>
<#include "../foot.ftl">
</html>