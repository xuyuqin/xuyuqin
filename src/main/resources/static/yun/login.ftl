<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/>
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/public/yun_libs/bootstrap.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_dammzwgd7u2qpvi.css">
    <link rel="stylesheet" href="/public/yun_css/public.css">
    <link rel="stylesheet" href="/public/yun_css/login.css">
</head>
<body style="width:100%;height:100%;">
<div class="loginTop">
    <div class="container clearfix">
        <div class="pull-left">
            <a href="/yuncai/index"><img src="/public/img/logo2.png" alt=""></a>
        </div>
        <div class="pull-left welcome">
            欢迎登录
        </div>
        <div class="pull-right service">
            客服热线：<span class="serviceCall">021-35906666</span><span class="serviceTime">(9:00-17:00)</span>
        </div>
    </div>
</div>
<div class="loginMid">
    <div class="container " style="position: relative">
        <div class="loginForm pull-right">
            <div class="clearfix loginTitle">
                <div class="pull-left  loginW">欢迎登录</div>
                <div class="pull-right"><a href="/yuncai/register">免费注册</a></div>
            </div>
           <div class="loginInput clearfix"><label for=""><span class="iconfont icon-people"></span></label><input type="text" name="username" placeholder="手机号/邮箱/用户名" id="username"/></div>
           <div class="loginInput"><label for=""><span class="iconfont icon-mima"></span></label><input type="password" name="password" id="password"/></div>
            <div class="clearfix loginCheck" style="margin-top: 60px">
                <div class="pull-left">
                    <input type="checkbox"><label for="" class="autoLogin">自动登录</label>
                        <#--<input tabindex="2" type="checkbox" id="input-2" checked>-->
                        <#--<label for="input-2">自动登录</label>-->
                </div>
                <div class="pull-right"><a href="">忘记密码？</a></div>
            </div>
            <div class="loginBtn">
                <button id="loginBottom">登录</button>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/jquery.cookie.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/bootstrapValidator.js"></script>
<script src="/public/yun_libs/icheck.js"></script>
<#--<script src='../public/yun_js/auth/register.js'></script>-->
<script>
    $('#username').change(function () {
        var username = $('#username').val();
        $.ajax({
            type: "get",
            url: "/yun/isRegisted",
            data: {
                mobile: username
            },
            success: function (msg) {
                console.log(msg);
                if (msg.code == 0) {
                    alert('账号不存在');
                }
            }
        })
    });
    $('#loginBottom').click(function () {
        var username = $('#username').val();
        var password = $('#password').val();
        $.ajax({
            type: "get",
            url: "/yun/login",
            data: {
                username: username,
                password: password
            },
            success: function (msg) {
                console.log(msg);
                if (msg.code == 0) {
                    //判断首页找货是否存在
                    if($.cookie('zhaohuo') != undefined && $.cookie('zhaohuo') != ''){
                        var zhaohuoData = $.cookie('zhaohuo').replace(/(\")/g, "\\\"");
                        $.cookie('zhaohuo','')
                        $.ajax({
                            url: '/yun/tyundemand/find?'+zhaohuoData,
                            type: 'POST',
                            data: {},
                            processData: false,
                            contentType: false,
                        }).done(function(data) {
                            if(data.code == 0){
                                window.location.href = "/yuncai/demand/index";
                            }
                        })
                     }

                    if($.cookie('historyUrl') !==undefined){
                        window.location.href = $.cookie('historyUrl');
                        $.removeCookie('historyUrl');
                    }else{
                        window.location.href = '/yuncai/index';
                    }
                } else {
                    alert(msg.msg);
                }
            }
        })
    })
</script>
<#include "foot.ftl">
</html>