<#include "../top.ftl">
<#--<link href="/public/yun_libs/bootstrap-select.min.css" rel="stylesheet">-->
<link rel="stylesheet" href="/public/yun_css/public.css">
<link rel="stylesheet" href="/public/yun_css/mall/mallIndex.css">
<link rel="stylesheet" href="//at.alicdn.com/t/font_dammzwgd7u2qpvi.css">
<style>
    .select2-selection__clear {
        margin-top: -2px !important;
    }

    td div {
        height: 50px;
        overflow: hidden;
    }
</style>

<div class="section">
    <div class="container">

        <div class="container mallNav">
            <div class=" clearfix mallD">
                <div class="pull-left navT">类别</div>
                <div class="pull-left navBtn">
                    <ul class="categoryUl categoryU clearfix categoryChoose">
                        <li class="active">全部</li>
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    <#--<li>类别1</li>-->
                    <#--<li>类别2</li>-->
                    </ul>
                </div>
            </div>
            <div class="clearfix mallD">
                <div class="pull-left navT">地区</div>
                <div class="pull-left navBtn">
                    <ul class="categoryUl areaUl clearfix areaChoose">
                        <li class="active">全部</li>
                    <#--<li>黑龙江</li>-->
                    <#--<li>上海</li>-->
                    <#--<li>江苏</li>-->
                    <#--<li>山东</li>-->
                    </ul>
                </div>
            </div>
            <div class="row mallI">
                <div class="col-md-10 mallInput">
                    <ul class="row mallUlInput clearfix">
                        <li class="col-md-3">
                            <label for="">品名</label>
                            <input type="text" name="productname">
                        </li>
                        <li class="col-md-3">
                            <label for="">规格</label>
                            <input type="text" name="detail">
                        </li>
                        <li class="col-md-3">
                            <label for="">材料</label>
                            <input type="text" name="material">
                        </li>
                        <li class="col-md-3">
                            <label for="">仓库</label>
                            <input type="text" name="">
                        </li>
                        <li class="col-md-3">
                            <label for="">厂家</label>
                            <input type="text" name="providername">
                        </li>
                    </ul>
                </div>
                <div class="col-md-2 clearfix">
                    <button class="orangeBtnMall pull-right">找货</button>
                </div>
            </div>
        </div>
        <div class="row allC">
            <div class="col-md-12" id="tab" tab="">
                <button  type="button" class="active" id="all">全部</button>
                <button  type="button" class="" id="collection">我收藏的</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                    <ul class="listTitle">
                        <li style="width:110px" >类别</li>
                        <li style="width:180px" >厂家</li>
                        <li style="width:190px" >产品名称</li>
                        <li style="width:100px" >材质</li>
                        <li style="width:80px"  >规格</li>
                        <li style="width:80px"  >地区</li>
                        <li style="width:80px"  >件数</li>
                        <li style="width:80px"  >重量</li>
                        <li style="width:80px"  >可供</li>
                        <li style="width:80px"  >单价</li>
                        <li style="width:100px" >操作</li>
                    </ul>
                    <div class="loading text-center" style="display:none">
                        <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
                        <span class="sr-only">Loading...</span>
                    </div>
                    <div id="tMain"></div>

            </div>
            <div class="col-md-12 text-center">
                <ul class="pagination" id="pageBar">
                </ul>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="/public/yun_libs/jquery.citys.js"></script>
<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>
<script src="/public/yun_js/mall/addCart.js"></script>
<#--<script type="text/javascript" src="/public/yun_js/mall/index.js"></script>-->
<#--<script type="text/javascript" src="/public/yun_js/mall/hoverDelay.js"></script>-->
<#--<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>-->
<#--<script type="text/javascript" src="scripts/common/template-native.js?_=${app.parameters.Version!}"></script>-->
<#--<script type="text/javascript" src="scripts/controls/jquery.citys.js"></script>-->
<#--<script type="text/javascript" src="scripts/controls/jquery.pageBar.js"></script>-->
<#--<script type="text/javascript" src="scripts/bootstrap/bootstrap-select.min.js"></script>-->
<script>

    var CategoryId = $.cookie('CategoryId');
    var areaId = $.cookie('areaId');
    var productname = $.cookie('productname');
    var detail = $.cookie('detail');
    var material = $.cookie('material');
    var providername = $.cookie('providername');
    $('input[name=productname]').val(productname);
    $('input[name=detail]').val(detail);
    $('input[name=material]').val(material);
    $('input[name=providername]').val(providername);
    $.cookie('CategoryId', '');
    $.cookie('areaId', '');
    $.cookie('productname', '');
    $.cookie('detail', '');
    $.cookie('material', '');
    $.cookie('providername', '');
    $.ajax({
        url: '/yun/category/list?type=0',
        type: 'get',
        success: function (msg) {
            if (msg.code == 0) {
                var list = msg.list;
                for (var i = 0; i < list.length; i++) {
                    $('.categoryU').append('<li id= "li_' + list[i].id + '">' + list[i].name + '</li>')
                }
                CategoryId = '#' + CategoryId;
                $(CategoryId).attr('class', 'active').siblings().removeClass('active');
                getList();
            }
        }
    });
    $.ajax({
        url: '/yun/region/list',
        type: 'get',
        data: {
            level: 1
        },
        success: function (msg) {
            if (msg.code == 0) {
                var list = msg.list;
                for (var i = 0; i < list.length; i++) {
                    $('.areaUl').append('<li id= "li_' + list[i].code + '">' + list[i].name + '</li>')
                }
                areaId = '#' + areaId;

                $(areaId).attr('class', 'active').siblings().removeClass('active');
            }
        }
    });

    $(document).on('click', '.categoryChoose li', function () {
        $(this).attr('class', 'active').siblings().removeClass('active');
    });

    $(document).on('click', '.areaChoose li', function () {
        $(this).attr('class', 'active').siblings().removeClass('active');
    });

    $('.orangeBtnMall').click(function () {
        $('#all').click();
        getList();
    });
    function getList() {
        var category = $('.categoryChoose .active').text();
        if (category == '全部') {
            category = '';
        }
        var area = $('.areaChoose .active').text();
        if (area == '全部') {
            area = '';
        }
        $.ajax({
            url: '/yun/merchandise/list',
            type: 'get',
            data: {
                Category: category,
                region: area,
                productname: $('input[name=productname]').val(),
                detail: $('input[name=detail]').val(),
                material: $('input[name=material]').val(),
                providername: $('input[name=providername]').val()
            },
            success: function (msg) {
                console.log(msg);
                if (msg.code == 0) {
                    var list = msg.page.list;
                    if (list.length > 0) {
                        console.log(list.length);
                        $()
                        $('#tMain').empty();
                        for (var i = 0; i < list.length; i++) {
                            var html = '<ul id="' + list[i].id + '" class="mallListAll">'
                                    + '<li style="width:110px">' + list[i].subCategoryName + '</li>'
                                    + '<li style="width:180px">' + list[i].providerName + '</li>'
                                    + '<li style="width:190px">' + list[i].name + '</li>'
                                    + '<li style="width:100px">' + list[i].material + '</li>'
                                    + '<li style="width:80px" ><div>' + list[i].detail + '</div></li>'
                                    + '<li style="width:80px" >' + list[i].region + '</li>'
                                    + '<li style="width:80px" >' + list[i].unit + '</li>'
                                    + '<li style="width:80px" >' + list[i].weight + '</li>'
                                    + '<li style="width:80px" >库存</li>'
                                    + '<li style="width:80px" >' + list[i].price + '</li>'
                                    + '<li style="width:100px">' +
                                    '<div  class="operation">' +
                                    '<button type="button" class="addCart">' +
                                    '<span class="iconfont icon-cart"></span></button>' +
                                    '<button type="button">' +
                                    '<span class="iconfont icon-comments"></span></button>' +
                                    '<button type="button" class="collect">' +
                                    '<span class="iconfont icon-xin"></span></button>' +
                                    '</div>' +
                                    '</li>'
                                    + '</ul>';
                            $('#tMain').append(html);
                        }
                    } else {
                        $('#tMain').html('无货');
                    }
                     $('.addCart').each(function () {
                         var that = $(this);
                         $(this).click(function () {
                             var id = that.parents('ul').attr('id');

                         })
                     }
                     );
                    $('.collect').each(function () {
                        var that = $(this);
                        $(this).click(function () {
                            var id = that.parents('ul').attr('id');
                            console.log(id);
                            var obj = that;
                            addCollect(id,obj);
                        })
                    })
                }

            }
        });
    }
    $('#collection').click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        $.ajax({
            url:'/yun/merchandise/listmy',
            type:'get',
            success:function (msg) {
                if (msg.code == 0) {

                    var list = msg.page.list;
                    console.log(list);
                    if (list.length > 0) {
                        console.log(list.length);
                        $('#tMain').empty();
                        for (var i = 0; i < list.length; i++) {
                            var html =
                                    '<ul id="' + list[i].id + '" class="mallListAll">'
                                    + '<li style="width:110px">' + list[i].subCategoryName + '</li>'
                                    + '<li style="width:180px">' + list[i].providerName + '</li>'
                                    + '<li style="width:190px">' + list[i].name + '</li>'
                                    + '<li style="width:100px">' + list[i].material + '</li>'
                                    + '<li style="width:80px" ><div>' + list[i].detail + '</div></li>'
                                    + '<li style="width:80px" >' + list[i].region + '</li>'
                                    + '<li style="width:80px" >' + list[i].unit + '</li>'
                                    + '<li style="width:80px" >' + list[i].weight + '</li>'
                                    + '<li style="width:80px" >库存</li>'
                                    + '<li style="width:80px" >' + list[i].price + '</li>'
                                    + '<li style="width:100px">' +
                                    '<div class="operation">' +
                                    '<button type="button" class="addCart">' +
                                    '<span class="iconfont icon-cart"></span></button>' +
                                    '<button type="button">' +
                                    '<span class="iconfont icon-comments"></span></button>' +
                                    '<button type="button" class="collect">' +
                                    '<span class="iconfont icon-xin"></span></button>' +
                                    '</div>' +
                                    '</li>'
                                    + '</ul>';
                            $('#tMain').append(html);
                        }
                    } else {
                        $('#tMain').html('没有收藏');
                    }
                    $('.addCart').each(function () {
                                var that = $(this);
                                $(this).click(function () {
                                    var id = that.parents('ul').attr('id');
                                    console.log(id);
                                })
                            }
                    );
                    $('.collect').each(function () {
                        var that = $(this);
                        $(this).click(function () {
                            var id = that.parents('ul').attr('id');
                            console.log(id);
                            var obj = that;
                            addCollect(id,obj);
                        })
                    })
                }
            }
        })
    });
    $('#all').click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        getList();
    })
</script>

<#include "../foot.ftl">