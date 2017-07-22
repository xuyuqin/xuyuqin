<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;" xmlns="http://www.w3.org/1999/html">
<#include "../top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <script type="application/javascript">
        $.cookie('historyUrl','/yuncai/demand/edit');
    </script>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <link href="/public/yun_css/demand/index.css" rel="stylesheet" type="text/css">
    <link href="/public/yun_libs/bootstrapValidator.min.css" rel="stylesheet" type="text/css">
</head>
<body>
<#--查看登陆状态-->
<div class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-7">
                <h3>找货信息</h3>
                <hr>
                <form id="demandForm" class="form-horizontal" role="form">
                    <div class="form-group">
                      <div class="col-sm-2">
                        <label class="control-label">名称</label>
                    </div>
                    <div class="col-sm-9">
                        <input type="text" class="form-control" name="name" placeholder="填写求购名称" value="">
                    </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">类别</label>
                        </div>
                        <div class="col-sm-9">
                            <select id="category" class="form-control" name="category">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">数量</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="number" class="form-control" name="amount" placeholder="填写数量" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">品种</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="productName" placeholder="填写品种" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">采购产品</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="productBuy" placeholder="产品名称" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">规格</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="specification" placeholder="产品规格" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">地区</label>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control province" name="province"><option value=""> - 请选择 - </option></select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control city" name="city" disabled=""><option value=""> - 请选择 - </option></select>
                        </div>
                        <div class="col-sm-3">
                            <select class="form-control area" name="district" disabled=""><option value=""> - 请选择 - </option></select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">材质</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="material" placeholder="产品材质" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">有效期</label>
                        </div>
                        <div class="col-sm-9">
                            <select name="validity" class="form-control" title="-请选择-" data-size="">
                                <option value="1">1天</option>
                                <option value="2">1周</option>
                                <option value="3">1个月</option>
                                <option value="4">永久</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">备注</label>
                        </div>
                        <div class="col-sm-9">
                            <textarea name="remarks" style="resize: none"  class="form-control" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">公司</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="companyName" placeholder="填写公司名称" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">联系人</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" name="contract" placeholder="填写公司联系人" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-2">
                            <label class="control-label">电话</label>
                        </div>
                        <div class="col-sm-9">
                            <input type="tel" class="form-control" name="phone" placeholder="填写电话" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-9">
                            <button id="createBtn" type="button" class="btn btn-primary">发布求购单</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-md-5">
                <h3>我的求购单</h3>
                <hr>
                <div class="row">
                    <div class="col-md-12">
                        <div class="loading text-center" style="display: none;">
                            <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                            <span class="sr-only">Loading...</span>
                        </div><table class="table" id="editlist">
                        <thead>
                        <tr>
                            <th style="min-width:44px">名称</th>
                            <th style="min-width:44px">时间</th>
                            <th style="min-width:58px">报价数</th>
                            <th style="min-width:188px">操作</th>
                        </tr>
                        </thead>

                        <tbody id="tMain">
                        <tr>
                            <td>暂无数据</td>
                        </tr>
                        </tbody>
                    </table>
                    </div>
                    <div class="col-md-12 text-center">
                        <ul class="pagination" id="pageBar"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<#--<script src="/public/yun_js/demand/template-native.js"></script>-->
<#--<script src="/public/yun_libs/bootstrap-select.min.js"></script>-->
<script src="/public/yun_js/demand/create.js"></script>
<script src="/public/yun_libs/jquery.citys.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script src="/public/yun_libs/bootstrapValidator.js"></script>

<#include "../foot.ftl">
</html>