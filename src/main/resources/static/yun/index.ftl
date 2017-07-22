<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;" xmlns="http://www.w3.org/1999/html">
<#include "top.ftl">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/public/yun_css/modal.css" rel="stylesheet" type="text/css">
    <link href="/public/yun_libs/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="/public/yun_css/top.css" rel="stylesheet" type="text/css">
    <link href="/public/yun_css/customizedFont/iconfont.css" rel="stylesheet" type="text/css">
    <link href="/public/yun_css/index.css" rel="stylesheet" type="text/css">

</head>
<body style="width:100%;height:100%;">
    <div class="section"  style="top: 217px;">
        <div class="container paddingZreo figure">
            <div class="row">
                <div class="col-md-7 left">
                    <div id="fullcarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
                        <ol class="carousel-indicators">
                            <li class="icon active" data-target="#fullcarousel" data-slide-to="0">1</li>
                            <li class="icon" data-target="#fullcarousel" data-slide-to="1">2</li>
                            <li class="icon" data-target="#fullcarousel" data-slide-to="2">3</li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="/public/yun_img/banner/banner-01.jpg">
                                <div class="carousel-caption">
                                    <h2> </h2>
                                    <p> </p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="/public/yun_img/banner/banner-02.jpg">
                                <div class="carousel-caption">
                                    <h2> </h2>
                                    <p> </p>
                                </div>
                            </div>
                            <div class="item">
                                <img src="/public/yun_img/banner/banner-03.jpg">
                                <div class="carousel-caption">
                                    <h2> </h2>
                                    <p> </p>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
                <div class="col-md-5 right" style="border: 1px solid #dddddd;
    border-radius: 1px;">
                    <div class="row">
                        <ul class="nav nav-justified nav-tabs liList">
                            <li class="activeBtn" onMouseMove="show('1',this)">
                                <a>找货物</a>
                            </li>
                            <li class="" onMouseMove="show('2',this)">
                                <a>找物流</a>
                            </li>
                            <li class="" onMouseMove="show('3',this)">
                                <a>找资金</a>
                            </li>
                        </ul>
                    </div>
                    <div class="row">
                        <div class="col-md-12 headContent">
                            <form style="height:250px" class="form-horizontal " id="formOne" role="form">
                                <table class="table  tableOne">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">类别</label>
                                                </div>
                                                <div class="paddingLeft col-sm-8">
                                                    <select name="category" class="selectpicker show-tick form-control" title="-请选择-" data-size="10"><option class="bs-title-option" value="">-请选择-</option></select>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">采购产品</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="productBuy">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">品种</label>
                                                </div>
                                                <div class="paddingLeft col-sm-8">
                                                    <input type="text" class="form-control" name="productName">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">数量</label>
                                                </div>
                                                <div class="paddingLeft col-sm-8">
                                                    <input type="text" class="form-control" name="amount">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">规格</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="specification">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">材质</label>
                                                </div>
                                                <div class="paddingLeft col-sm-8">
                                                    <input type="text" class="form-control" name="material">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">地区</label>
                                                </div>
                                                <div class="paddingLeft col-sm-8">
                                                    <input type="text" class="form-control cityStart" placeholder="" name="">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">有效期</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <select name="validity" class="form-control" title="-请选择-" data-size="">
                                                        <option value="1">1天</option>
                                                        <option value="2">1周</option>
                                                        <option value="3">1个月</option>
                                                        <option value="4">永久</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><div class="dashed"></div></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label class="control-label">公司名称</label>
                                                </div>
                                                <div class="col-sm-9">
                                                    <input type="text" class="form-control" name="companyName">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">联系人</label>
                                                </div>
                                                <div class="paddingLeft col-sm-8">
                                                    <input type="text" class="form-control" name="contract">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class="control-label">电话</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="phone">
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <button type="button" id="demand-submit" class="btn btn-default btnOne">发布</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>

                            </form>

                            <form style="height:250px" class="form-horizontal " id="formTwo" role="form">
                                <table class="table tableOne">
                                    <tbody>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label class="control-label">起点</label>
                                                </div>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control cityStart" placeholder="请选择起点" name="companyName">
                                                </div>
                                            </div>
                                        </td>
                                        <td></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label class="control-label">货物</label>
                                                </div>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" placeholder="选择货物" name="companyName">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td><i class="iconfont">&#xe604;</i></td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label class="control-label">卸点</label>
                                                </div>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" placeholder="请选择终点" name="companyName">
                                                </div>
                                            </div>
                                        </td>
                                        <td></td>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-2">
                                                    <label class="control-label">吨位</label>
                                                </div>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" placeholder="填写重量/吨" name="companyName">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>

                                        <td colspan="3">
                                            <label>我们的参考价来自真实订单的成交数据</label>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td class="btnTd">
                                            <button type="button" id="" class="btn btn-default btnOne chayunjia">查运价</button>
                                            <button type="button" id="" class="btn btn-default btnOne searchcar">帮我找车</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </form>
                            <form style="height:250px" class="form-horizontal " id="formThree" role="form">
                                <div class="formThreeContent">
                                    <#--<button type="button" id="more" class="btn btn-default btnOne">发布</button>-->
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="section" style="top: 600px;">
        <div class="container price">
            <div class="row headjg">
                <p class="lead navbar-left navbar-text">价格动态</p>
                <div class="contentjg">
                    <div class="col-sm-1 text-right">
                        <span>类别</span>
                    </div>
                    <div class="col-sm-2">
                        <select name="category" id="dynamicSelect" class="selectpicker show-tick form-control" title="-请选择-" data-size="10"><option  value="">-请选择-</option></select>
                    </div>
                </div>
            </div>
            <div id="dynamic" class="lunBo">
                <#--<div class="dynamicTitle">-->
                    <#--<label>类别</label>-->
                <#--</div>-->
                    <div class="spinner">
                        <div class="cube1"></div>
                        <div class="cube2"></div>
                    </div>
                <div id="dynamicContent">

                 </div>
                    <#--<tr>-->
                        <#--<td>-->
                            <#--<div class="left">-->
                                <#--<label class="name">普卷 鞍钢</label>-->
                                <#--<label class="format">5.75*1500*C</label>-->
                            <#--</div>-->
                            <#--<div class="right">-->
                                <#--<label class="time">今天 9:30</label>-->
                                <#--<div style="clear: both"></div>-->
                                <#--<label class="updownup"><div class="up"></div>20</label>-->
                                <#--<label class="numup">3390</label>-->
                            <#--</div>-->

            </div>
        </div>
    </div>
    <div class="section" style="top: 1015px;">
        <div class="container material">
            <div class="row headjg">
                <p class="lead navbar-left navbar-text">云材商城</p>
                <#--<div class="contentjg">-->
                    <#--<span><a href="/yuncai//www/member/apply">供应商入驻</a></span>-->
                <#--</div>-->
            </div>
            <div class="row">
                <div class="col-md-3 left">
                    <div class="row">
                        <div class="col-md-12 newShopLeft">
                            <form class="form-horizontal" id="newShopLeftForm" role="form">
                                <table class="table newShop">
                                    <tbody>
                                    <tr>
                                        <td colspan="2">
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class=" ">类别</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <select name="category" class="selectpicker show-tick form-control" title="-请选择-" data-size="10" ><option class="bs-title-option" value="">-请选择-</option></select>
                                                </div>
                                            </div>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class=" " contenteditable="true">品种</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" placeholder="填写品种" name="">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class=" " contenteditable="true" >采购产品</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" placeholder="填写产品名称" name="name">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class=" ">规格</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="spec" placeholder="填写规格">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class=" ">材质</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="material" placeholder="填写材质">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <div class="form-group">
                                                <div class="col-sm-4">
                                                    <label class=" " contenteditable="true">厂家</label>
                                                </div>
                                                <div class="col-sm-8">
                                                    <input type="text" class="form-control" name="name" placeholder="选择厂家">
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div>
                                    <button type="button" class="btn btn-default getShop">我要找货</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 center">
                    <div class="row">
                        <div class="col-md-12 newShopRight">
                            <div class="newShopHead">
                                <p class="lead navbar-left navbar-text">供应商</p>
                                <div class="contentjg">
                                    <a href="#"><span> 更多>
                                    </span></a>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <table id="providerLogo">


                                </table>
                            </div>
                        </div>

                </div>
            </div>
                <div class="right">
                    <div class="head">
                        <a href="javascript:;"><div class="searchGood actives"> <i class="iconfont">&#xe638;</i>找货信息</div></a>
                        <a href="javascript:;"><div class="recommend"><i class="iconfont">&#xe600;</i>为你推荐</div></a>
                    </div>
                    <div class="content">
                        <div id="searchGood">
                            <ul>
                                <li>
                                    <div class="spinner">
                                        <div class="cube1"></div>
                                        <div class="cube2"></div>
                                    </div>
                                    <#--<div class="dataOverview">-->
                                            <#--<div class="name">产品名称: <p>碳纤维复合材料</p></div>-->
                                        <#--<div class="format">规格: <p>SGCC</p></div>-->
                                        <#--<div class="Category">材质: <p>碳纤维</p></div>-->
                                        <#--<div  class="num">数量: <p>1000吨</p></div>-->
                                        <#--<a href="#" class="hasGood">我有货</a>-->
                                    <#--</div>-->
                                </li>

                            </ul>
                        </div>
                        <div id="recommend" style="display: none;">
                            <#--<div class="dataOverview">-->
                                <#--<div class="name">江苏攀华</div>-->
                                <#--<div class="good">有花镀锌卷</div>-->
                                <#--<div class="format">SGCC</div>-->
                                <#--<div class="time">1小时前</div>-->
                            <#--</div>-->
                        </div>
                    </div>
                </div>
                <div>
                    <div class="supply first">
                        <div class="top">
                            <label class="item">今日服务人数</label>
                            <p>1000</p><label class="unit">人</label>
                        </div>

                        <div class="bottom">
                            <label class="item">今日成交单数</label>
                            <p>1000</p><label class="unit">单</label>
                        </div>
                    </div>
                    <div class="supply">
                        <label class="title">今日最火商品</label>
                        <label class="commodity">碳纤维复合材料</label>
                        <div class="detail">
                        <label class="unit">成交 </label><p>1000</p>
                        <label class="unit">吨</label>
                        </div>
                    </div>
                    <div class="supply">
                        <label class="title">今日最火商家</label>
                        <label class="commodity">山东中航泰达</label>
                    </div>
                    <div class="supply">

                        <label class="title">昨日服务人数</label>
                        <div class="detail less">
                        <p>1000</p>
                        <label class="unit">人</label>
                        </div>
                    </div>
                    <div class="supply">
                        <label class="title">昨日成交单数</label>
                        <div class="detail less">
                            <p>1000</p>
                            <label class="unit">单</label>
                        </div>
                    </div>
                    <div class="supply">
                        <label class="title">昨日最火商品</label>
                        <label class="commodity">碳纤维复合材料</label>
                        <div class="detail">
                            <label class="unit">成交 </label><p>1000</p>
                            <label class="unit">吨</label>
                         </div>
                    </div>
                    <div class="supply">
                        <label class="title">昨日最火商家</label>
                        <label class="commodity">山东中航泰达</label>
                    </div>
                </div>
            </div>
    </div>
    </div>
    <div class="section" style="top: 1633px;">
        <div class="container news">
            <div class="row headjg">
                <p class="lead navbar-left navbar-text">新闻资讯</p>
                <div class="contentjg">
                    <span><a href="/yuncai/www/news">更多></a></span>
                </div>
            </div>
            <div class="row">
                <div class="inner">
                    <div class="top">国内资讯</div>
                    <div class="content">
                        <#--<div class="dataNews">-->
                            <#--<label class="condition">云材行情</label>-->
                            <#--<p>|</p>-->
                            <#--<label class="title">华东地区上海高桥石化苯酚略略略略略略略略</label>-->
                            <#--<label class="time">2017-06-21</label>-->
                        <#--</div>-->


                            <a href="#" class="morea"><div class="more">
                                查看更多>>
                            </div> </a>
                    </div>
                </div>
                <div class="outer">
                    <div class="top">国外资讯</div>
                    <div class="content">
                        <#--<div class="dataNews">-->
                            <#--<label class="condition">云材行情</label>-->
                            <#--<p>|</p>-->
                            <#--<label class="title">华东地区上海高桥石化苯酚略略略略略略略略</label>-->
                            <#--<label class="time">2017-06-21</label>-->
                        <#--</div>-->
                        <a href="#" class="morea"><div class="more">
                            查看更多>>
                        </div> </a>
                    </div>
                </div>
                <div class="firm">
                    <div class="top">企业动态</div>
                    <div class="content">
                        <#--<div class="dataNews">-->
                            <#--<label class="condition">云材行情</label>-->
                            <#--<p>|</p>-->
                            <#--<label class="title">华东地区上海高桥石化苯酚略略略略略略略略</label>-->
                            <#--<label class="time">2017-06-21</label>-->
                        <#--</div>-->


                            <a href="#" class="morea"><div class="more">
                                查看更多>>
                            </div> </a>
                    </div>
                </div>
                <#--<div class="col-md-3">-->
                    <#--<a href="#"><img src="/public/yun_img/news/news1.jpg"  class="img-responsive"></a>-->
                    <#--<ol class="list-unstyled" id="category-internal">-->
                    <#--</ol>-->
                <#--</div>-->
                <#--<div class="col-md-3">-->
                    <#--<a href="#"><img src="/public/yun_img/news/news2.jpg"  class="img-responsive"></a>-->
                    <#--<ol class="list-unstyled" id="category-external">-->
                    <#--</ol>-->
                <#--</div>-->
                <#--<div class="col-md-3">-->
                    <#--<a href="#"><img src="/public/yun_img/news/news2.jpg" class="img-responsive"></a>-->
                    <#--<ol class="list-unstyled" id="category-trend">-->
                    <#--</ol>-->
                <#--</div>-->
                <#--<div class="col-md-3">-->
                    <#--<a href="#"><img src="/public/yun_img/news/news2.jpg" class="img-responsive"></a>-->
                    <#--<ol class="list-unstyled" id="category-interview">-->
                    <#--</ol>-->
                <#--</div>-->
            </div>
        </div>
    </div >
    <div class="section" style="top: 2050px;">
        <div class="container logistics">
            <div class="row headjg">
                <p class="lead navbar-left navbar-text">灰狗物流</p>
                <div class="contentjg">
                    <span><a href="/yuncai/www/greydog/carrier">承运商入驻></a></span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-9 paddingZreo wuliu">
                    <a href="#"><img src="/public/yun_img/logistics.jpg" class="wuliuimg"></a>
                </div>
                <#--<div class="col-md-3 paddingZreo">-->
                    <#--<a href="#"><img src="/public/yun_img/wuliuimg/wuliu3.jpg" class="wuliuimg"></a>-->
                <#--</div>-->
                <div class="QRcode">
                    <#--<img src="/public/yun_img/capital.jpg" alt="">-->
                    <i class="iconfont"></i>
                    <label class="top">扫描二维码立刻关注灰狗物流微信服务号</label>
                    <label class="bottom">实时掌握最新消息</label>
                </div>
                <div class="QRcode">
                    <i class="iconfont"></i>
                    <label class="top">扫描二维码立刻下载灰狗物流手机APP</label>
                    <label class="bottom">相约灰狗物流APP</label>
                </div>
            </div>
        </div>
    </div>
    <div class="section"  style="top: 2450px;">
        <div class="container finance">
            <div class="row headjg">
                <p class="lead navbar-left navbar-text">供应链金融服务</p>
                <div class="contentjg">
                    <span></span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 finance">

                        <div class="col-md-3   paddingZreo left" >
                            <#--<img src="/public/yun_img/finance/finance2.jpg" class="wuliuimg"/>-->
                            <div class=" blankNote">
                                <label class="title"><i class="iconfont">&#xe658;</i>云材白条</label>
                                <div class="content">
                                    <a href="#"><label class="item" >白条介绍</label></a>
                                    <a href="#"><label class="item">申请白条</label></a>
                                </div>
                            </div>
                            <div class="bill">
                                <label class="title"><i class="iconfont">&#xe6f0;</i>票据结算</label>
                                <div class="content">
                                    <a href="#"> <label class="item">业务优势</label></a>
                                    <a href="#"><label class="item">票据结算</label></a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9  paddingZreo right" >
                            <img src="/public/yun_img/finance/finance1.jpg" class="wuliuimg"/>
                            <a class="btn btn-primary" id="apply" href="/yuncai/www/loan/index">立即申请</a>
                        </div>
                    <#--<div class="col-md-3  paddingZreo">-->
                    <#--<img src="http://7z.res.molbase.net/img_mall_v1/home/finance_stepImg.jpg" />-->
                    <#--</div>-->

                </div>
            </div>
        </div>
    </div>
    <div class="section" style="top: 2860px;">
            <div class="container link">
                <div class="row headjg">
                    <p class="lead navbar-left navbar-text">友情链接</p>
                    <div class="contentjg">
                        <span></span>
                    </div>
                </div>
                <div class="row content">
                    <ul>
                        <li>
                            <a href="http://www.baidu.com" target="_blank"><img src="/public/yun_img/link/bd_logo1.png" alt=""></a>
                        </li>
                        <li>
                            <a href="https://www.hao123.com" target="_blank"><img src="/public/yun_img/link/hao123.png" alt=""></a>
                        </li>
                        <li>
                            <a href="http://www.sina.com.cn/" target="_blank"><img src="/public/yun_img/link/sina.png" alt=""></a>
                        </li>
                        <li>
                            <a href="http://www.qq.com/" target="_blank"><img src="/public/yun_img/link/qq.png" alt=""></a>
                        </li>
                        <li>
                            <a href="http://www.sohu.com/" target="_blank"><img src="/public/yun_img/link/souhu.png" alt=""></a>
                        </li>
                        <li>
                            <a href="http://www.ifeng.com/" target="_blank"><img src="/public/yun_img/link/fenghuang.png" alt=""></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>







</body>
<script src="/public/yun_libs/bootstrap-select.min.js"></script>
<script src="/public/yun_js/index.js"></script>
<script src="/public/yun_js/myModal.js"></script>
<script src="/public/yun_libs/jquery.citys.js"></script>
<script src="/public/yun_libs/jquery.pageBar.js"></script>
<script src="/public/yun_libs/jquery.scrollbox.min.js"></script>

<#include "foot.ftl">
</html>
