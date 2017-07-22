<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/myorder.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach">
    <div class="container">
        <div class="navbar-header" id="logo">
            <img alt="Brand" src="/public/img/logo_03.png">
        </div>
        <div class="collapse navbar-collapse" id="moduleHeadTwo">
            <p class="myOrderSpan">我的积分</p>
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
                    <li class="active">我的积分</li>
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
                <ul class="nav nav-tabs" id="tab-header">
                    <li class="active">
                        <a href="../member/mypoint" class="point-info">
                            积分信息
                        </a>
                    </li>
                    <li>
                        <a href="../member/pointorder" class="point-order">
                            积分订单
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div role="tabpanel" class="tab-pane active" id="point-info">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <form class="form-horizontal" role="form" id="point-view"></form>
                            <#-- <form class="form-horizontal" role="form">
                                <div class="form-group">
                                    <div class="col-sm-2 text-left">
                                        <label class="control-label">
                                            积分：1000
                                        </label>
                                    </div>
                                    <div class="col-sm-4">
                                        <a class="btn btn-default">
                                            去积分商城兑换
                                        </a>
                                    </div>
                                </div>
                            </form> -->
                                <div class="row">
                                    <div class="col-md-12">
                                        <table class="table table-bordered">
                                            <thead>
                                            <tr>
                                                <th>
                                                    积分来源
                                                </th>
                                                <th>
                                                    积分变化
                                                </th>
                                                <th>
                                                    时间
                                                </th>
                                                <th>
                                                    备注
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody id="tMain">
                                            <#-- <tr>
                                                            <td>
                                                                商城购物
                                                            </td>
                                                            <td class="danger">
                                                                +100
                                                            </td>
                                                            <td>
                                                                2016-10-14 11:11:11
                                                            </td>
                                                            <td>
                                                                购入10000元商品
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                积分商城购物
                                                            </td>
                                                            <td class="success">
                                                                -100
                                                            </td>
                                                            <td>
                                                                2016-10-14 11:11:11
                                                            </td>
                                                            <td>
                                                                购入10000元商品
                                                            </td>
                                                        </tr> -->
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
    </div>
</div>

</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/template-native.js"></script>
<#--<script src="/public/yun_libs/jquery.pageBar.js"></script>-->
<#--<script src="/public/yun_js/member/myorder.js"></script>-->
<script type="text/javascript">
    $(function() {
        var page = 1;
        function useTpl() {
            //console.log(url);
            $.ajax({
                type: 'GET',
                url: "/yuncai/www/member/selectCollMerchandise",
                data: {page:page},
                success:function(data) {
                    if(data.status == 0) {
                        console.log(data.content);
//                                var panelTitle = template('panelTitleTpl', data.content);
//                                $("#point-view").html(panelTitle);

//                                var html = template('tMainTpl', data.content);
//                                $('#tMain').html(html);
//                                var page = template('pageTpl', data.content);
//                                $('#pageContainer').html(page)
                    }
                }
            });
        }

        useTpl();

        $(document).on('click', '#pageContainer li', function(e) {
            if ($(this).hasClass('active')) {
                return false;
            }
            page = $(this).find('a').html();
            console.log('点击了' + page);
            useTpl();
            return false;
        });
    });
</script>

<script type="text/html" id="panelTitleTpl">
    <div class="form-group">
        <div class="col-sm-2 text-left">
            <label class="control-label">
                积分：<%=point  %>
            </label>
        </div>
        <div class="col-sm-4">
            <a class="btn btn-default">
                去积分商城兑换
            </a>
        </div>
    </div>
</script>

<script type="text/html" id="pageTpl">
    <% for (var i = 0; i < pageBar.length; i++) { %>
    <% if(pageBar[i] == pageNum) { %>
    <li class="active" >
        <% } else { %>
    <li>
        <% } %>
        <a href="#"><%= pageBar[i] %></a></li>
    <% } %>
</script>

<script type="text/html" id="tMainTpl">
    <% for (var i = 0; i < ls.length; i++) { %>
    <tr>
        <td>
            <%=ls[i].c_scoreSource  %>
        </td>
        <td>
            <%=ls[i].c_scoreNum  %>
        </td>
        <td>
            <%=ls[i].c_scoreTime  %>
        </td>
        <td>
            <%=ls[i].c_note  %>
        </td>
    </tr>
    <% } %>
</script>
<#include "../foot.ftl">
</html>