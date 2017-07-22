<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;" xmlns="http://www.w3.org/1999/html">
<#include "../top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script type="text/javascript">
        var __appconfig = {
            approot: "/yun/",
            theme: "default",
            version: "3",
            menuid: "",
            uploadmaxsize: "",
            sessionId: "",
            browser_chrome: "false"
        };
    </script>
    <link href="/public/yun_css/demand/price.css" rel="stylesheet" type="text/css">
    <link href="/public/yun_libs/bootstrapValidator.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="section">
    <div class="container">
                <form id="replyForm" class="form-horizontal">
                    <div class="col-md-7">
                        <h3>找货信息</h3>
                        <table class="table table-bordered lookfor">
                            <#--<tr>-->
                                <#--<td style="min-width:160px;max-width:199px">产品：</td>-->
                                <#--<td style="min-width:160px;max-width:199px">厂家：</td>-->
                                <#--<td style="min-width:160px;max-width:199px">地区：</td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td>数量：</td>-->
                                <#--<td>规格：</td>-->
                                <#--<td>材质：</td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td>类别：</td>-->
                                <#--<td>品种：</td>-->
                                <#--<td></td>-->
                            <#--</tr>-->
                        </table>
                    </div>
                    <div class="col-md-5">
                        <h3>求购商信息</h3>
                        <table class="table table-bordered info">
                            <#--<tr>-->
                                <#--<td>公司名：</td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td>联系人：</td>-->
                            <#--</tr>-->
                            <#--<tr>-->
                                <#--<td>手机号：</td>-->
                            <#--</tr>-->
                        </table>
                    </div>
                    <div class="col-md-12">
                        <h3>请填写报价</h3>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">报价</label>
                        </div>
                        <div class="col-sm-10">
                            <div class="radio">
                                <label class="radio-inline">
                                    <input type="radio" name="priceType" value="2">总价</label>
                                <label class="radio-inline">
                                    <input type="radio" name="priceType" value="1" checked>单价</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">价格</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="price" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">联系人</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="姓名" name="contract" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">电话</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" placeholder="号码" name="phone" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">备注</label>
                        </div>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="remarks"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-2">
                            <button id="createBtn" type="button" class="btn btn-primary">发布</button>
                        </div>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/public/yun_js/demand/price.js"></script>
<script src="/public/yun_libs/jquery.citys.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script src="/public/yun_libs/bootstrapValidator.js"></script>
<#include "../foot.ftl">
</html>