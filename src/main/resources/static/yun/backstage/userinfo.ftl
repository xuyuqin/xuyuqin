<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_vzeajmrx43lq5mi.css">
    <link rel="stylesheet" href="/public/yun_css/module.css">
    <link rel="stylesheet" href="/public/yun_css/member/myorder.css">
</head>
<body style="width:100%;height:100%;">
<div class="moduleSeach topStyle">
    <div class="container">
        <div class="row">
            <div class="pull-left">
                <img alt="Brand" id="topLogo" src="/public/img/logo1.png">
            </div>
            <div class="pull-right" id="moduleHeadTwo">
                <div class="topInput">
                    <input type="search" placeholder="请输入产品名称" id="topSearch"/>
                    <input type="button" value="搜索" id="topButton"/>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container topBreadcrumb">
    <div class="row">
        <div class="col-md-12">
            <div class="pull-left">
                <span class="iconfont icon-dingwei"></span>
                <span class="topPosition">当前位置：</span>
            </div>
            <div class="pull-left">
                <ol class="breadcrumb">
                    <li><a href="/yuncai/index">首页</a></li>
                    <li><a href="/yuncai/backstage/index">个人中心</a></li>
                    <li class="active">账户信息</li>
                </ol>
            </div>
        </div>
    </div>
</div>
<div class="container backContainer">
    <div class="row">
        <div class="col-md-2 leftNav">
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">用户中心</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li><a href="/yuncai/backstage/index">首页</a></li>
            </ol>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">我的交易</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li><a href="/yuncai/backstage/order">我的订单</a></li>
                <li><a href="/yuncai/backstage/resources">我的资源单</a></li>
                <li><a href="/yuncai/backstage/purchase">我的求购单</a></li>
                <li><a href="/yuncai/backstage/cart">我的购物车</a></li>
                <li><a href="/yuncai/backstage/bill">发票查询</a></li>
            </ol>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">我的白条</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <li><a href="/yuncai/backstage/white">我的白条</a></li>
            </ol>
            <ol class="list-unstyled">
                <li class="clearfix">
                    <div class="pull-left">个人中心</div>
                    <div class="pull-right">
                        <span class="iconfont icon-shangla"></span>
                    </div>
                </li>
                <#--<li><a href="/yuncai/backstage/point">我的积分</a></li>-->
                <li><a href="/yuncai/backstage/coll">我的收藏</a></li>
                <li><a href="/yuncai/backstage/vipauth">企业账号认证</a></li>
                <li class="navActive"><a href="/yuncai/backstage/userinfo">账号信息</a></li>
                <li><a href="/yuncai/backstage/safe">账号安全</a></li>
                <li><a href="/yuncai/backstage/address">收货地址</a></li>
            </ol>
        </div>
        <div class="col-md-10 rightContent">
            <h4 class="">个人信息</h4>
            <form action="" id="userInfoForm" class="formStyle">
                <div class="userInfoInput">
                    <label for="">姓名</label>
                    <input type="text" name="name">
                </div>
                <div class="userInfoInput">
                    <label for="">性别</label>
                    <div class="sexChoose">男</div>
                    <div class="sexChoose sexChoose1">女</div>
                    <input type="radio" class="regular-radio" name="sex" value="男" id="radio1"/> <label for="radio1" class="laberStyle labelStyle1" ></label>
                    <input type="radio" class="regular-radio" name="sex" value="女" id="radio2"/> <label for="radio2" class="laberStyle labelStyle2"></label>
                </div>
                <div class="userInfoInput">
                    <label for="">生日</label>
                    <span id="box">
                        <select name="sel1" id="sel1">
                            <option value="year">年</option>
                        </select>
                        <select name="sel2" id="sel2">
                            <option value="month">月</option>
                        </select>
                        <select name="sel3" id="sel3">
                            <option value="day">日</option>
                        </select>
                    </span>

                </div>
                <div class="userInfoInput">
                    <label for="">所在地</label>
                    <select class="location1">
                        <option value="">请选择</option>
                    </select>
                    <select class="location2">
                        <option value="">请选择</option>
                    </select>
                    <select class="location3">
                        <option value="">请选择</option>
                    </select>
                </div>
                <div class="userInfoInput">
                    <label for="">地址</label>
                    <input type="text" name="" class="location4">
                </div>
                <div class="userInfoInput">
                    <label for="">QQ</label>
                    <input type="text" name="qq">
                </div>
                <div class="userInfoInput">
                    <label for="">手机号码</label>
                    <div class="changeLine">
                        <div class="width200" id="userMobile">13333333333</div>
                        <div class="width50 activeBtns">修改</div>
                        <div class="width50">已验证</div>
                    </div>
                </div>
                <div class="userInfoInput">
                    <label for="">电子邮件</label>
                    <div class="changeLine">
                        <div class="width200" id="userEmail">13333333333@qq.com</div>
                        <div class="width50 activeBtns">修改</div>
                        <div class="width50">已验证</div>
                    </div>
                </div>
                <div class="userInfoInput">
                    <label for="">邀请码</label>
                    <div class="changeLine">
                        <div class="width200" id="userYqm">wewe111111111</div>
                        <div class="width100 activeBtns">邀请好友</div>
                    </div>
                </div>
                <div class="submitBtn">
                    <button type="button" id="submitBtn">保存</button>
                </div>
            </form>
        </div>

    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/date.js"></script>
<#--<script src="/public/yun_libs/template-native.js"></script>-->
<#--&lt;#&ndash;<script src="/public/yun_libs/jquery.pageBar.js"></script>&ndash;&gt;-->
<#--<script src="/public/yun_js/member/cropbox.js"></script>-->
<#--<script src="/public/yun_js/member/userinfo.js"></script>-->
<script>
    $.ajax({
        url: '/yun/member/myinfo',
        type: 'get',
        success: function (msg) {
            if (msg.code == 0) {
                $('input[name=name]').val(msg.info.name);
                $('input[name=qq]').val(msg.info.qq);
                $('#userMobile').text(msg.info.mobile);
                $('#userEmail').text(msg.info.email);
                $('#userYqm').text(msg.info.yqm);
            }
        }
    });
    $('#submitBtn').click(function () {
        $.ajax({
            url: '/yun/member/editmyinfo',
            type: 'post',
            data: {
                name: $('input[name=name]').val(),
                mobile: $('#userMobile').text(),
                email: $('#userEmail').text(),
                qq: $('input[name=qq]').val(),
                address: $('.location1 option:selected').text() + $('.location2 option:selected').text() + $('.location3 option:selected').text() + $('.location4').val(),

            },
            success: function (msg) {
                console.log(msg);
                if (msg.code == 0) {
                }
            }
        })
    });
        $.ajax({
            url: '/yun/region/list?level=1',
            type: 'get',
            success: function (msg) {
                if (msg.code == 0) {
                    var html='<option>请选择</option>';
                    for (var i = 0; i < msg.list.length; i++) {
                        html += '<option value="' + msg.list[i].code + '">' + msg.list[i].name + '</option>'
                    }
                    $('.location1').empty().html(html);
                }

                $('.location1').change(function () {
                    var pcode = $('.location1 option:selected').val();
                    $.ajax({
                        url: '/yun/region/list?pcode='+pcode,
                        type: 'get',
                        success: function (msg) {
                            if (msg.code == 0) {
                                var html1='<option>请选择</option>';
                                for (var i = 0; i < msg.list.length; i++) {
                                    html1+= '<option value="' + msg.list[i].code + '">' + msg.list[i].name + '</option>'
                                }
                                $('.location2').empty().html(html1);
                            }

                            $('.location2').change(function () {
                                var ccode = $('.location2 option:selected').val();
                                $.ajax({
                                    url: '/yun/region/list?ccode='+ccode,
                                    type: 'get',
                                    success: function (msg) {
                                        if (msg.code == 0) {
                                            var html2='<option>请选择</option>';
                                            for (var i = 0; i < msg.list.length; i++) {
                                                html2 += '<option value="' + msg.list[i].code + '">' + msg.list[i].name + '</option>'
                                            }
                                            $('.location3').empty().html(html2);
                                        }
                                    }

                                })
                            })
                        }

                    })
                })
            }

        })
</script>
<#include "../foot.ftl">
</html>