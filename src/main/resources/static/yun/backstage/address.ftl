<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "../top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <#--<link rel="stylesheet" href="/public/yun_css/member/mallCart.css">-->
</head>
<body style="width:100%;height:100%;">
<div class="hidden-sm hidden-xs section paddingZreo">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <ul class="breadcrumb">
                    <li class="active">
                        <a href="/yuncai/backstage/index">个人中心</a>
                    </li>
                    <li class="active">
                        收货地址
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="section">
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
                            <div class="col-sm-12 text-right">
                                <a class="btn btn-default" data-target="#new-addr" data-toggle="modal">
                                    新增收货地址
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>
                                            收货人
                                        </th>
                                        <th>
                                            联系电话
                                        </th>
                                        <th>
                                            收货地址
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
<div class="modal fade" id="change-addr">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" class="close" data-dismiss="modal" type="button">
                    ×
                </button>
                <h4 class="modal-title">
                    修改收货地址
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="editForm">
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label" for="receiver">
                                收货人：
                            </label>
                        </div>
                        <div class="col-sm-9">
                            <input class="form-control receiver" id="" name="name" data-bv-notempty="true" data-bv-notempty-message="不能为空" placeholder="姓名" type="text">
                            </input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label" for="tele">
                                联系电话：
                            </label>
                        </div>
                        <div class="col-sm-9">
                            <input class="form-control tele" id="" name="mobile" data-bv-phone="true" data-bv-phone-message="不能为空" placeholder="手机" type="text">
                            </input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label">
                                所在地区：
                            </label>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control province" name="province" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control city" name="city" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control area" name="district" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label" for="address" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                                详细地址：
                            </label>
                        </div>
                        <div class="col-sm-9">
                            <input class="form-control address" id="" name="detailAddress" placeholder="详细地址" type="text">
                            </input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-8">
                            <div class="checkbox">
                                <label>
                                    <input class="isDefault" type="checkbox" name="isDefault" value="1" >设为常用地址</input>
                                </label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default cancel_submit" data-dismiss="modal" type="button">
                    取消
                </button>
                <button class="btn btn-primary edit_submit" type="submit">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="new-addr">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button aria-hidden="true" class="close" data-dismiss="modal" type="button">
                    ×
                </button>
                <h4 class="modal-title">
                    新增收货地址
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" role="form" id="saveForm">
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label" for="receiver">
                                收货人：
                            </label>
                        </div>
                        <div class="col-sm-8">
                            <input class="form-control" id="name" name="name" data-bv-notempty="true" data-bv-notempty-message="不能为空" placeholder="姓名" type="text">
                            </input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label" for="tel">
                                联系电话：
                            </label>
                        </div>
                        <div class="col-sm-8">
                            <input class="form-control" id="tel" name="mobile" data-bv-notempty="true" data-bv-notempty-message="不能为空" placeholder="手机" type="text">
                            </input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label">
                                所在地区
                            </label>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control province" name="province" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control city" name="city" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                            </select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control area" name="district" data-bv-notempty="true" data-bv-notempty-message="不能为空">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-3 text-right">
                            <label class="control-label" for="address">
                                详细地址：
                            </label>
                        </div>
                        <div class="col-sm-8">
                            <input class="form-control" id="address" name="detailAddress" data-bv-notempty="true" data-bv-notempty-message="不能为空" placeholder="详细地址" type="text">
                            </input>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-8">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="isDefault" value="1">
                                    设为常用地址
                                    </input>
                                </label>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default cancel_submit" data-dismiss="modal" type="button">
                    取消
                </button>
                <button class="btn btn-primary save_submit" type="submit">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>

</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/template-native.js"></script>
<script src="/public/yun_libs/bootstrapValidator.js"></script>
<script src="/public/yun_libs/jquery.citys.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script src="/public/yun_js/member/address.js"></script>
<script type="text/html" id="tMainTpl">
    <% for (var i = 0; i < content.length; i++) { %>
    <tr>
        <td><%=content[i].name  %></td>
        <td><%=content[i].mobile  %></td>
        <td><%=content[i].province + content[i].city + content[i].district + content[i].detailAddress %></td>
        <td>
            <a class="btn btn-default edit" data-toggle="modal" data-target="#change-addr" addressId=<%=content[i].id%>>
                修改
            </a>
            <a class="btn btn-default del" addressId=<%=content[i].id%>>
                删除
            </a>
        </td>
    </tr>
    <% } %>
</script>
<#include "../foot.ftl">
</html>