<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;" xmlns="http://www.w3.org/1999/html">
<#include "../top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <#--<link href="/public/yun_css/demand/price.css" rel="stylesheet" type="text/css">-->

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
                <h3>找货人信息</h3>
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
                <h3>报价商信息</h3>

                <div class="loading text-center" style="display: none;">
                    <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                    <span class="sr-only">Loading...</span>
                </div><table class="table">
                <thead>
                <tr>
                    <th style="min-width:58px">报价</th>
                    <th style="min-width:44px">联系人</th>
                    <th style="min-width:44px">电话</th>
                    <th style="min-width:55px">备注</th>
                </tr>
                </thead>
                <tbody id="tMain"></tbody>
            </table>
                <div class="col-md-12 text-center">
                    <ul class="pagination" id="pageBar"><li class="disabled"><a href="#">上页</a></li><li class="active"><a href="#">1</a></li><li class="disabled"><a href="#">下页</a></li></ul>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="/public/yun_js/demand/view.js"></script>
<script src="/public/yun_libs/jquery.citys.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>

<#include "../foot.ftl">
</html>