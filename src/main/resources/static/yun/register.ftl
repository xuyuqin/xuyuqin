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
            欢迎注册
        </div>
        <div class="pull-right service">
            客服热线：<span class="serviceCall">021-35906666</span><span class="serviceTime">(9:00-17:00)</span>
        </div>
    </div>
</div>
<div class="loginMid registerMid">
    <div class="container " style="position: relative">
        <div class="registerForm pull-right">
            <form action="" id="registerForm">
            <div class="clearfix loginTitle marginBt10">
                <div class="pull-left  loginW">欢迎注册</div>
                <div class="pull-right" style="font-size: 1.4rem">已有账号去<a href="/yuncai/login">登录</a></div>
            </div>
            <div class="largeInput form-group"><input type="text" class="form-control" name="mobile" placeholder="请输入手机号码"
                                           data-bv-notempty="true"
                                           data-bv-phone="true"
                                           /></div>

            <div class="largeInput form-group"><input type="password" class="form-control" placeholder="请输入登录密码"
                                           data-bv-notempty="true"
                                           data-bv-regexp="true"
                                           data-bv-regexp-regexp="^[a-zA-Z0-9]{6,18}$"
                                           name="password"></div>
                <div class="smallInput clearfix form-group"><input type="text" class="form-control" placeholder="请输入验证码"
                                                                   data-bv-notempty="true"
                                                                   name="verifyCode" id=""/><button id="verifyCode" type="button">获取验证码</button></div>
            <div class="largeInput form-group"><input type="text" class="form-control" placeholder="请输入邀请码(非必填)"></div>
            <div class="clearfix registerCheck">
                <div class="pull-left form-group clearfix">
                    <input type="checkbox" checked data-bv-notempty="true"
                           data-bv-message="阅读并同意" style="float: left"><label for="" class="autoLogin" style="float: left">阅读并同意 <a href="">《云材网用户服务协议》</a></label>
                </div>
            </div>
            <div class="loginBtn">
                <button id="loginBottom" type="submit">注册</button>
            </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/jquery.cookie.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_libs/bootstrapValidator.js"></script>
<script src="/public/yun_libs/icheck.js"></script>
<script src='../public/yun_js/auth/register.js'></script>

<#include "foot.ftl">
</html>