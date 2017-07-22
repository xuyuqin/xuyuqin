
<#include "../top.ftl">
    <link href="/public/yun_css/resource/create.css" rel="stylesheet">

    <div class="section">
        <div class="container">
            <div class="row">
                <div class="col-md-7 createBorder">

                        <h3>资源单信息</h3>
                        <hr>
                        <form id="resourceForm" class="form-horizontal" enctype="multipart/form-data">

                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">名称</label>
                                </div>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="name" placeholder="填写资源单名称" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">公司</label>
                                </div>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" name="companyHead" placeholder="填写公司抬头" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">地区</label>
                                </div>
                                <div class="col-sm-3">
                                    <select class="form-control province" name="province">
                                    </select>
                                </div>
                                <div class="col-sm-3">
                                    <select class="form-control city" name="city">
                                    </select>
                                </div>
                                <div class="col-sm-3">
                                    <select class="form-control area" name="district">
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">价格</label>
                                </div>
                                <div class="col-sm-9">
                                    <div class="input-group">
                                        <div class="input-group-addon">￥</div>
                                        <input name="scale" class="form-control" type="text" placeholder="今日价格" value="">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label for="type" class="control-label">类型</label>
                                </div>
                                <div class="col-sm-9">
                                    <select id="categorySelsect" name="categoryId" class=" form-control" title="-请选择-" data-size="10"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-2">
                                    <label class="control-label">描述</label>
                                </div>
                                <div class="col-md-9">
                                    <textarea name="description" rows="3" class="form-control"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-2">
                                    <label class="control-label">上传资源表</label>
                                </div>
                                <div class="col-sm-9">
                                    <a class="btn btn-primary" style="position: absolute;cursor: pointer;">上传文件</a>
                                    <input class="up" onchange="changefile(this)" type="file" name="file" style="width: 80px;background: #000;opacity: 0;cursor: pointer;height:35px;position: absolute;left: 15px;">
                                    <div class="text" style="margin-left:100px;margin-top: 6px;"></div>
                                </div>

                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-9">
                                    <input type="hidden" class="form-control" name="id" value="<%=id%>">
                                    <p>网站根据某些规则解析资源单里面的内容，参考下面的资源样式，有助于其他用户搜索到您完整的资源。</p>
                                    <button type="button" id="createBtn" class="btn btn-primary">发布资源单</button>
                                </div>
                            </div>


                        </form>

                </div>
                <div class="col-md-5 createBorderT">
                        <h3>我的资源单</h3>
                        <hr>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="loading text-center" style="display:none">
                                    <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                                    <span class="sr-only">Loading...</span>
                                </div>
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th style="min-width:44px">名称</th>
                                            <th style="min-width:44px">价格</th>
                                            <th style="min-width:55px">发布时间</th>
                                            <th style="min-width:124px">操作</th>
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
        </div>
    </div>

    <div class="modal fade" id="changeConfirm" role="dialog" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">确认</h4>
                </div>
                <div class="modal-body">
                    <p>马上修改此资源单？</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary changeBtn">确定</button>
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
    <script type="text/javascript" src="/public/yun_js/resource/create.js"></script>

<script>
</script>

<#include "../foot.ftl">
