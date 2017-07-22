<#include "../top.ftl">
<#--<link href="/public/yun_libs/bootstrap-select.min.css" rel="stylesheet">-->
<link rel="stylesheet" href="/public/yun_css/public.css">
<link rel="stylesheet" href="/public/yun_css/mall/mallIndex.css">
<style>
    .select2-selection__clear {
        margin-top: -2px !important;
    }
</style>
<div class="container mallTop">
    <div class="row">
        <div class="col-md-5">
            <div class="mallTopD">我要成为供应商</div>
            <div class="mallTopD1">
                <a href="" class="mallTopA">成为供应商</a>
            </div>
        </div>
        <div class="col-md-7"></div>
    </div>
</div>
<div class="container mallNav">
    <div class=" clearfix mallD">
        <div class="pull-left navT">类别</div>
        <div class="pull-left navBtn">
            <ul class="categoryUl categoryU clearfix categoryChoose">
                <li class="active" id="all_">全部</li>
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
                <li class="active" id="all_">全部</li>
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
<div class="container mallL">
    <div class="mallListTopBar">
        <div class="pull-left">
            <span class="mallTitle" id="category1">分类一</span>
            <a class="mallLeftA" href="">更多》</a>
        </div>
        <div class="pull-right">
            <ul class="mallListUl clearfix">
            <#--<li class="categoryActive">品种1</li>-->
                <#--<li>品种2</li>-->
                <#--<li>品种3</li>-->
            </ul>
        </div>
    </div>
    <div class="row mallList hoverD" id="categoryList1">
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1 nextPage">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
        <div class="col-md-2 mallListOne mallListOne1">
            <img src="/public/img/mall1.png" alt="">
            <p>商品标题</p>
            <p>材质：XXXX</p>
            <p class="mallPrice">价格：&yen;9999.00</p>
        </div>
    </div>
</div>
<div class="container mallL">
    <div class="mallListTopBar">
        <div class="pull-left">
            <span class="mallTitle" id="category2">分类二</span>
            <a class="mallLeftA" href="">更多》</a>
        </div>
        <div class="pull-right">
            <ul class="mallListUl clearfix">
            <#--<li class="categoryActive">品种1</li>-->
                <#--<li>品种2</li>-->
                <#--<li>品种3</li>-->
            </ul>
        </div>
    </div>
    <div class="row mallList">
        <div class="col-md-2 mallListTwo">
            <img class="mallTwoImg" src="/public/img/mallLeft.jpg" alt="">
        </div>
        <div class="col-md-10 mallListTwo hoverD" id="categoryList2">
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
            <div class="mallListOne">
                <img src="/public/img/mall1.png" alt="">
                <p>商品标题</p>
                <p>材质：XXXX</p>
                <p class="mallPrice">价格：&yen;9999.00</p>
            </div>
        </div>
    </div>
</div>
<div class="container mallL">
    <div class="mallListTopBar">
        <div class="pull-left">
            <span class="mallTitle" id="category3" data-id="">分类三</span>
            <a class="mallLeftA" href="">更多》</a>
        </div>
        <div class="pull-right">
            <ul class="mallListUl">
            <#--<li class="categoryActive">品种1</li>-->
                <#--<li>品种2</li>-->
                <#--<li>品种3</li>-->
            </ul>
        </div>
    </div>
    <div class="row mallList">
        <div class="col-md-2 mallListTwo mallListThree">
            <img class="mallTwoImg" src="/public/img/mallLeft.jpg" alt="">
        </div>
        <div class="col-md-10 mallListTwo mallListThree" id="categoryList3">
            <div class="mallListOneD">
                <h4>商品标题</h4>
                <div class="clearfix mallListOneDD">
                    <div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>
                    <div class="pull-right">
                        <p>材质：XXXX</p>
                        <p>规格：XXXXXX</p>
                        <p>重量：XXXX</p>
                        <p>件数：XXXX</p>
                        <p class="mallPrice">价格：&yen;9999.00</p>
                    </div>
                </div>

            </div>
            <div class="mallListOneD">
                <h4>商品标题</h4>
                <div class="clearfix mallListOneDD">
                    <div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>
                    <div class="pull-right">
                        <p>材质：XXXX</p>
                        <p>规格：XXXXXX</p>
                        <p>重量：XXXX</p>
                        <p>件数：XXXX</p>
                        <p class="mallPrice">价格：&yen;9999.00</p>
                    </div>
                </div>

            </div>
            <div class="mallListOneD">
                <h4>商品标题</h4>
                <div class="clearfix mallListOneDD">
                    <div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>
                    <div class="pull-right">
                        <p>材质：XXXX</p>
                        <p>规格：XXXXXX</p>
                        <p>重量：XXXX</p>
                        <p>件数：XXXX</p>
                        <p class="mallPrice">价格：&yen;9999.00</p>
                    </div>
                </div>

            </div>
            <div class="mallListOneD">
                <h4>商品标题</h4>
                <div class="clearfix mallListOneDD">
                    <div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>
                    <div class="pull-right">
                        <p>材质：XXXX</p>
                        <p>规格：XXXXXX</p>
                        <p>重量：XXXX</p>
                        <p>件数：XXXX</p>
                        <p class="mallPrice">价格：&yen;9999.00</p>
                    </div>
                </div>

            </div>
            <div class="mallListOneD">
                <h4>商品标题</h4>
                <div class="clearfix mallListOneDD">
                    <div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>
                    <div class="pull-right">
                        <p>材质：XXXX</p>
                        <p>规格：XXXXXX</p>
                        <p>重量：XXXX</p>
                        <p>件数：XXXX</p>
                        <p class="mallPrice">价格：&yen;9999.00</p>
                    </div>
                </div>

            </div>
            <div class="mallListOneD">
                <h4>商品标题</h4>
                <div class="clearfix mallListOneDD">
                    <div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>
                    <div class="pull-right">
                        <p>材质：XXXX</p>
                        <p>规格：XXXXXX</p>
                        <p>重量：XXXX</p>
                        <p>件数：XXXX</p>
                        <p class="mallPrice">价格：&yen;9999.00</p>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<div class="container bottomLink">
    <div class="bottomLinkT">友情链接</div>
    <div>
        <ul class=" row clearfix">
            <li class="col-md-2">
                <a href="http://www.baidu.com" target="_blank"><img src="/public/yun_img/link/bd_logo1.png" alt=""></a>
            </li>
            <li class="col-md-2">
                <a href="https://www.hao123.com" target="_blank"><img src="/public/yun_img/link/hao123.png" alt=""></a>
            </li>
            <li class="col-md-2">
                <a href="http://www.sina.com.cn/" target="_blank"><img src="/public/yun_img/link/sina.png" alt=""></a>
            </li>
            <li class="col-md-2">
                <a href="http://www.qq.com/" target="_blank"><img src="/public/yun_img/link/qq.png" alt=""></a>
            </li>
            <li class="col-md-2">
                <a href="http://www.sohu.com/" target="_blank"><img src="/public/yun_img/link/souhu.png" alt=""></a>
            </li>
            <li class="col-md-2">
                <a href="http://www.ifeng.com/" target="_blank"><img src="/public/yun_img/link/fenghuang.png"
                                                                     alt=""></a>
            </li>
        </ul>
    </div>
</div>
<script type="text/javascript" src="/public/yun_libs/jquery.citys.js"></script>
<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>
<script type="text/javascript" src="/public/yun_js/mall/index.js"></script>
<script type="text/javascript" src="/public/yun_js/mall/hoverDelay.js"></script>
<#--<script type="text/javascript" src="/public/yun_libs/jquery.pageBar.js"></script>-->
<#--<script type="text/javascript" src="scripts/common/template-native.js?_=${app.parameters.Version!}"></script>-->
<#--<script type="text/javascript" src="scripts/controls/jquery.citys.js"></script>-->
<#--<script type="text/javascript" src="scripts/controls/jquery.pageBar.js"></script>-->
<#--<script type="text/javascript" src="scripts/bootstrap/bootstrap-select.min.js"></script>-->
<script>


</script>

<#include "../foot.ftl">