<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge" />
    <!--easyui在ie9的问题解决-->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="uadf">
    <link href="/public/yun_libs/bootstrap.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/public/yun_libs/select2.css">
    <link href="//at.alicdn.com/t/font_0qkk79o1l594quxr.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="/public/yun_css/top.css">
    <link href="/public/yun_libs/bootstrap-select.min.css" rel="stylesheet" type="text/css">

</head>

<body style="min-width:1160px;height:100%;margin: auto">
        <div class="navbar navbar-default navbar-static-top" id="navHead">
            <div class="container">
                <div class="collapse navbar-collapse" id="navbar-ex-collapse">
                    <#--<ul class="nav navbar-nav navbar-right"></ul>-->
                    <a class=" btn-link navbar-btn navbar-left navHead" >【嘉兴】</a>
                    <div id="status"></div>
                    <a class=" btn-link navbar-btn navbar-right navHeadt">客服热线：0572-12345678（9：00-17：00）</a>
                    <a class=" btn-link navbar-btn navbar-right navHeadt" >积分商城</a>
                    <a href="/yuncai/backstage/order" class=" btn-link navbar-btn navbar-right navHeadt"  >我的订单</a>
                    <a href="/yuncai/backstage/index" class=" btn-link navbar-btn navbar-right navHeadt"  >我的云材网</a>
                </div>
            </div>
        </div>
        <div class="moduleSeach">
            <div class="container">
                <div class="navbar-header" id="logo">
                    <a href="/yuncai/index"> <img alt="Brand" src="/public/yun_img/logo_03.png"></a>
                </div>
                <div class="seach">
                    <div class="row">
                        <ul class="seachList">
                            <li class="active" data-type="merchandise">产品</li>
                            <li data-type="provider">供应商</li>
                            <li data-type="baike">复材百科</li>
                        </ul>
                    </div>
                    <div>
                        <form id="seachFrom" class="form-horizontal" style="display: inline;">
                            <input type="text" name="q" class="form-control seachInput" placeholder="请输入产品百科关键字搜索" />
                        </form>
                        <a class="btn btn-primary" id="btnSearchm">搜索</a>
                    </div>
                    <div class="more">
                        <ul>
                            <li>碳纤维复合材料商品</li>
                            <li>树脂商品</li>
                            <li>碳纤维/碳纤制品商品</li>
                            <li>芯材/夹芯材料商品</li>
                            <li><a href="#">更多</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="container paddingZreo">
            <div class="container logoHang" id="moduleHead">
                <ul class="lead nav navbar-nav moduleHead">
                    <li class="home">
                        <a href="/yuncai/index">首页</a>
                    </li>
                    <li class="mall">
                        <a href="/yuncai/mall/index">商城</a>
                    </li>
                    <li class="resource">
                        <a href="/yuncai/resource/index">资源单</a>
                    </li>
                    <li class="demand">
                        <a href="/yuncai/demand/index">免费找货</a>
                    </li>
                    <li class="baike">
                        <a href="www/baike">百科</a>
                    </li>
                    <li class="news">
                        <a href="www/news">资讯</a>
                    </li>
                    <li class="greydog">
                        <a href="www/greydog/index">灰狗物流</a>
                    </li>
                    <li class="loan">
                        <a href="www/loan/index">白条</a>
                    </li>
                    <li class="market">
                        <a href="www/market">行情</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="line"></div>
        <div class="fixedList">
            <div class="list" id="shoppingCart">
                <i class="iconfont">&#xe698;</i>
                <div>购物车</div>
                <div class="shoppingSign">
                    <!-- <span>22</span> -->
                </div>
            </div>
            <div class="list" id="feedBack">
                <i class="iconfont">&#xe69e;</i>
                <div>意见反馈</div>
            </div>
            <div class="list" id="hotline">
                <i class="iconfont">&#xe6c7;</i>
                <div>客服热线</div>
            </div>
            <div class="list" id="onlineConsultant">
                <i class="iconfont">&#xe69b;</i>
                <div>在线咨询</div>
            </div>
            <div class="list" id="qrCode">
                <i class="iconfont">&#xe6a9;</i>
                <div>二维码</div>
            </div>
            <div class="list" id="topa">
                <a href="#top" target="_self"><i class="iconfont">&#xe662;</i>
                    <div>返回顶部</div></a>
            </div>
        </div>

</body>
<script src="/public/yun_libs/jquery-1.8.0.min.js"></script>
<script src="/public/yun_libs/jquery.cookie.js"></script>
<script src="/public/yun_libs/bootstrap.js"></script>
<script src="/public/yun_js/myModal.js"></script>
<script src="/public/yun_libs/select2.js"></script>
<script src="/public/yun_js/top.js"></script>
<script type="text/javascript">
    window.onscroll=function(){
        var sl=-Math.max(document.body.scrollLeft,document.documentElement.scrollLeft);
        document.getElementById('navHead').style.left=sl+'px';
    };

</script>
</html>
