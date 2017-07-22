<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;" xmlns="http://www.w3.org/1999/html">
<#include "../top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/public/yun_css/demand/index.css" rel="stylesheet" type="text/css">
</head>
<body>

<div class="section">
    <div class="container">
        <form id="marketSearch" class="form-horizontal">
            <div class="row">
                <div class="col-md-3">
                    <div class="form-group">
                        <label class="col-md-4 control-label">厂家：</label>
                        <div class="col-md-8">
                            <input name="providerName" type="text" class="form-control" id="factor" placeholder="厂家">
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label class="col-md-4 control-label">类别：</label>
                        <div class="col-md-8">
                            <select id="category" class="form-control" name="category">
                            </select>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label class="col-md-2 control-label">地区：</label>
                        <div class="col-md-10">
                            <div class="row" style="margin-bottom:0">
                                <div class="col-md-4">
                                    <select class="form-control province" name="province"><option value=""> - 请选择 - </option></select>
                                </div>
                                <div class="col-md-4">
                                    <select class="form-control city" name="city" disabled=""><option value=""> - 请选择 - </option></select>
                                </div>
                                <div class="col-md-4">
                                    <select class="form-control area" name="district" disabled=""><option value=""> - 请选择 - </option></select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="form-group">
                        <label class="col-md-4 control-label">品种：</label>
                        <div class="col-md-8">
                            <input name="productName" type="text" class="form-control" id="spec" placeholder="品种">
                        </div>
                    </div>
                </div>

                <div class="col-md-3">
                    <div class="form-group">
                        <div class="col-md-8 col-md-offset-4">
                            <button id="btnSearch" type="button" class="btn btn-primary">搜索</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <div class="row">
            <div class="col-md-12" id="tab" tab="1">
                <a id="all" href="javascript:void(0)" class="btn btn-default active">全部</a>
            <#if log?? && log == "1">
                <a id="myPublish"  class="btn btn-default">我发布的</a>
                <a id="myReport" class="btn btn-default">我报价的</a>
            </#if>
                <a href="/yuncai/demand/edit" class="btn btn-default pull-right">发布求购单</a>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="loading text-center" style="display: none;">
                    <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                    <span class="sr-only">Loading...</span>
                </div>
                <table class="table" id="commodity">
                <thead>
                <tr>
                    <th >类别</th>
                    <th >品种</th>
                    <th >有效期</th>
                    <th >名称</th>
                    <th >材质</th>
                    <th >规格</th>
                    <th >地区</th>
                    <th >数量</th>
                    <th >报价数</th>
                    <th >操作</th>
                </tr>
                </thead>

                <tbody id="tMain"></tbody>
            </table>
            </div>
            <div class="col-md-12 text-center">
                <ul class="pagination" id="pageBar"><li class="disabled"><a href="#">上页</a></li><li class="active"><a href="#">1</a></li><li class="disabled"><a href="#">下页</a></li></ul>
            </div>
        </div>

    </div>
</div>
</body>
<script src="/public/yun_js/demand/demand.js"></script>
<script src="/public/yun_libs/jquery.citys.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script type="application/javascript">
    $.cookie('historyUrl','/yuncai/demand/index',{ path: '/' });
</script>

<#include "../foot.ftl">
<#--TODO 我要报价和我的报价需要先查询自己是否是供应商-->
</html>