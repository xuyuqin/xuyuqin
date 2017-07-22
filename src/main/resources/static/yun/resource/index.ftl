

<#include "../top.ftl">
    <link href="css/bootstrap/bootstrap-select.min.css" rel="stylesheet">
<style>
    .select2-selection__clear{
        margin-top: -2px !important;
    }
    th{
        width:10%;
    }
    td{
        white-space: nowrap;
        overflow:hidden;
        text-overflow:ellipsis;
    }
</style>
    <div class="section">
        <div class="container">

                <form id="resourceSearch" class="form-horizontal">
                    <div class="row">

                        <div class="col-md-3">
                            <div class="form-group">
                                <label class="col-md-4 control-label">类别：</label>
                                <div class="col-md-8">
                                    
                                    <select id="categorySelsect" class="form-control" name="categoryId">
                                    </select>
                                    <#--<select name="categoryId" id="category" class="selectpicker show-tick form-control" title="-请选择-" data-size="10"></select>-->
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="col-md-2 control-label">地区：</label>
                                <div class="col-md-10">
                                    <div class="row" style="margin-bottom:0">
                                        <div class="col-md-4">
                                            <select class="form-control province" name="province">
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <select class="form-control city" name="city">
                                            </select>
                                        </div>
                                        <div class="col-md-4">
                                            <select class="form-control area" name="district">
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label class="col-md-4 control-label">品种：</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="productname" placeholder="名称">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <label class="col-md-4 control-label">公司：</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="name" placeholder="公司名">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="form-group">
                                <div class="col-md-8 col-md-offset-4">
                                    <button id="btnSearch" type="button" class="btn btn-primary">找货</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="row">
                    <div class="col-md-12" id="tab">
                            <a onclick="getResourceList(this)" class="btn btn-default active">全部</a>

                        <#if log?? && log == "1">
                            <a onclick="get_myre(this)" class="btn btn-default">我发布的</a>
                            <a onclick="list(this)" class="btn btn-default">我收藏的</a>

                            <a href="/yuncai/resource/create"  class="btn btn-default pull-right">发布资源单</a>
                        </#if>
                        <#if log?? && log == "2">
                            <a id="loginForC"  class="btn btn-default pull-right">发布资源单</a>
                        </#if>
                    </div>
                </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="loading text-center" style="display:none">
                        <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                        <span class="sr-only">Loading...</span>
                    </div>
                    <table style="table-layout:fixed" class="table table-condensed table-hover table-striped">
                        <thead>
                        <tr>
                            <th>公司名</th>
                            <th>发布者</th>
                            <th>类别</th>
                            <th>主营品种</th>
                            <th>资源单名称</th>
                            <th>资源单描述</th>
                            <th>下载次数</th>
                            <th>上传时间</th>
                            <th>今日调价</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="tMain"></tbody>
                    </table>
                </div>
                <div class="col-md-12 text-center">
                    <ul class="pagination" id="pageBar"></ul>
                </div>
            </div>

        </div>
    </div>
    <div class="modal fade" id="deleteConfirm" role="dialog" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">确认</h4>
                </div>
                <div class="modal-body">
                    <p>是否删除该资源单？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary deleteBtn">删除</button>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="/public/yun_libs/jquery.citys.js"></script>
    <script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>
    <script type="text/javascript" src="/public/yun_js/resource/index.js"></script>

    <#--<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>-->
	<#--<script type="text/javascript" src="scripts/common/template-native.js?_=${app.parameters.Version!}"></script>-->
    <#--<script type="text/javascript" src="scripts/controls/jquery.citys.js"></script>-->
    <#--<script type="text/javascript" src="scripts/controls/jquery.pageBar.js"></script>-->
    <#--<script type="text/javascript" src="scripts/bootstrap/bootstrap-select.min.js"></script>-->


<#include "../foot.ftl">