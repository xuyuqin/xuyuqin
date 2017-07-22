<#include "../top.ftl">
<#--<link href="/public/yun_libs/bootstrap-select.min.css" rel="stylesheet">-->
<link rel="stylesheet" href="/public/yun_css/public.css">
<link rel="stylesheet" href="/public/yun_css/mall/detail.css">
<body>
<#--商品id：${merchandise.id}-->
<#--供应商id：${merchandise.providerId}-->
<#--商品标题：${merchandise.title}-->
<#--商品名称：${merchandise.name}-->
<#--供应商名称：${merchandise.provider.name}-->
<#--地区：${merchandise.provider.region}-->
<#--材质：${merchandise.material}-->
<#--重量：${merchandise.weight}-->
<#--库存：${merchandise.unit}-->
<#--商品详情：${merchandise.detail}-->
<#--商品图片：<#list merchandiseImages as images>-->
<#--${images.url}-->
<#--</#list>-->
<#--商品规格：<#list merchandiseSpec as spec>-->
<#--规格名称：${spec.specification}-->
<#--规格单价：${spec.price}-->
<#--规格重量：${spec.weight}-->
<#--该规格库存：${spec.stock}-->

<#--</#list>-->
<#--<div class="section">-->
    <#--<div class="container">-->
        <#--<div id="merchandiseInfo" class="row">-->
            <#--<div class="col-md-5">-->
                <#--<div id="mallCarousel" class="carousel slide" data-ride="carousel" data-interval="false">-->
                    <#--<div class="carousel-inner">-->
                    <#--&lt;#&ndash;<#list merchandiseImages as images>&ndash;&gt;-->
                        <#--&lt;#&ndash;<#if images_index==0>&ndash;&gt;-->
                            <#--&lt;#&ndash;<div class="item active">&ndash;&gt;-->
                                <#--&lt;#&ndash;<img src="${images.url}">&ndash;&gt;-->
                                <#--&lt;#&ndash;<span></span>&ndash;&gt;-->
                                <#--&lt;#&ndash;<div class="show"></div>&ndash;&gt;-->
                            <#--&lt;#&ndash;</div>&ndash;&gt;-->
                        <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                            <#--&lt;#&ndash;<div class="item">&ndash;&gt;-->
                                <#--&lt;#&ndash;<img src="${images.url}">&ndash;&gt;-->
                                <#--&lt;#&ndash;<span></span>&ndash;&gt;-->
                                <#--&lt;#&ndash;<div class="show"></div>&ndash;&gt;-->
                            <#--&lt;#&ndash;</div>&ndash;&gt;-->
                        <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                    <#--&lt;#&ndash;</#list>&ndash;&gt;-->
                    <#--<div class="item active">-->
                    <#--<img src="https://unsplash.imgix.net/photo-1422222948315-28aadb7a2cb8?w=1024&amp;q=50&amp;fm=jpg&amp;s=cfeadbd7a991e58b553bee29a7eeca55">-->
                    <#--<span></span>-->
                    <#--<div class="show"></div>-->
                    <#--</div>-->

                    <#--<div class="item">-->
                    <#--<img src="https://unsplash.imgix.net/reserve/QTrNn7DETWGsjyS5L2n5__MG_8345.jpg?w=1024&amp;q=50&amp;fm=jpg&amp;s=f89d9bb3940033eca06ed432a250bb6d">-->
                    <#--<span></span>-->
                    <#--<div class="show"></div>-->
                    <#--</div>-->
                    <#--<div class="item">-->
                    <#--<img src="https://unsplash.imgix.net/photo-1422513391413-ddd4f2ce3340?w=1024&amp;q=50&amp;fm=jpg&amp;s=282e5978de17d6cd2280888d16f06f04">-->
                    <#--<span></span>-->
                    <#--<div class="show"></div>-->
                    <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="imgSmall">-->
                <#--&lt;#&ndash;<#list merchandiseImages as images>&ndash;&gt;-->
                    <#--&lt;#&ndash;<img src="${images.url}"&ndash;&gt;-->
                         <#--&lt;#&ndash;onclick="imgmall(${images_index},this)">&ndash;&gt;-->
                <#--&lt;#&ndash;</#list>&ndash;&gt;-->
                <#--<img src="https://unsplash.imgix.net/photo-1422222948315-28aadb7a2cb8?w=1024&amp;q=50&amp;fm=jpg&amp;s=cfeadbd7a991e58b553bee29a7eeca55"-->
                <#--onclick="imgmall(0,this)">-->
                <#--<img src="https://unsplash.imgix.net/photo-1417128281290-30a42da46277?w=1024&amp;q=50&amp;fm=jpg&amp;s=2edb796eb5e657f2c82704a1e6573938"-->
                <#--onclick="imgmall(1,this)">-->
                <#--<img src="https://unsplash.imgix.net/reserve/QTrNn7DETWGsjyS5L2n5__MG_8345.jpg?w=1024&amp;q=50&amp;fm=jpg&amp;s=f89d9bb3940033eca06ed432a250bb6d"-->
                <#--onclick="imgmall(2,this)">-->
                <#--<img src="https://unsplash.imgix.net/photo-1422513391413-ddd4f2ce3340?w=1024&amp;q=50&amp;fm=jpg&amp;s=282e5978de17d6cd2280888d16f06f04"-->
                <#--onclick="imgmall(3,this)">-->
                <#--</div>-->
            <#--&lt;#&ndash; <div>-->
                <#--<div class="col-md-6">-->
                    <#--<a href="" class="btn btn-link">-->
                        <#--<span class="glyphicon glyphicon-empty-star"></span>收藏-->
                    <#--</a>-->
                <#--</div>-->
                <#--<div class="col-md-6">-->
                    <#--<a href="" class="btn btn-link">-->
                        <#--<span class="glyphicon glyphicon-share"></span>分享-->
                    <#--</a>-->
                <#--</div>-->
            <#--</div> &ndash;&gt;-->
            <#--</div>-->
            <#--<div class="col-md-7">-->
            <#--&lt;#&ndash; 如果需要图片放大镜可以把下面的div2取消注释-->
            <#--<div id="div2">-->
                <#--<img id="img1" src="https://unsplash.imgix.net/photo-1422222948315-28aadb7a2cb8?w=1024&amp;q=50&amp;fm=jpg&amp;s=cfeadbd7a991e58b553bee29a7eeca55">-->
            <#--</div> &ndash;&gt;-->
                <#--<p class="h3" style="margin-top: 0; margin-bottom: 30px">${merchandise.title?default("品名")}</p>-->
                <#--<ul class="nav nav-pills nav-list" role="tablist">-->
                    <#--<li>-->
                        <#--<span style="display: block; padding: 10px 0px 10px 15px;">规格：</span>-->
                    <#--</li>-->

                <#--&lt;#&ndash;<#list merchandiseSpec as s>&ndash;&gt;-->
                    <#--&lt;#&ndash;<#if s_index==0>&ndash;&gt;-->
                        <#--&lt;#&ndash;<li class="active">&ndash;&gt;-->
                            <#--&lt;#&ndash;<a class="btn btn-xs btn-default " role="tab" data-toggle="tab" id="${s.id}">${s.specification}</a>&ndash;&gt;-->
                        <#--&lt;#&ndash;</li>&ndash;&gt;-->
                    <#--&lt;#&ndash;<#else >&ndash;&gt;-->
                        <#--&lt;#&ndash;<li >&ndash;&gt;-->
                            <#--&lt;#&ndash;<a class="btn btn-xs btn-default " role="tab" data-toggle="tab" id="${s.id}">${s.specification}</a>&ndash;&gt;-->
                        <#--&lt;#&ndash;</li>&ndash;&gt;-->
                    <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                <#--&lt;#&ndash;</#list>&ndash;&gt;-->
                <#--</ul>-->
                <#--<hr style="margin: 10px 0">-->
                <#--<div class="tab-content tab-info">-->
                <#--&lt;#&ndash;<#if merchandiseSpec??>&ndash;&gt;-->
                    <#--&lt;#&ndash;<#list merchandiseSpec as s>&ndash;&gt;-->
                        <#--&lt;#&ndash;<#if s_index == 0>&ndash;&gt;-->
                        <#--&lt;#&ndash;<div role="tabpanel" class="tab-pane active " id="spec${s_index}">&ndash;&gt;-->
                        <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                        <#--&lt;#&ndash;<div role="tabpanel" class="tab-pane " id="spec${s_index}">&ndash;&gt;-->
                        <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                        <#--<div class="panel-body row">-->
                            <#--<p class="col-md-6">地区：-->
                            <#--&lt;#&ndash;<#if merchandise?? && merchandise.provider?? && merchandise.provider.region??>&ndash;&gt;-->
                            <#--&lt;#&ndash;${merchandise.provider.region.name!}&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider?? && provider.region??>&ndash;&gt;-->
                            <#--${merchandise.provider.districtname}-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                            <#--</p>-->
                            <#--<p class="col-md-6">价格：-->
                            <#--&lt;#&ndash;<#if s?? && s.price??>&ndash;&gt;-->
                            <#--&lt;#&ndash;&yen;${s.price}&ndash;&gt;-->
                            <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                            <#--&lt;#&ndash;面议&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                            <#--</p>-->
                            <#--<p class="col-md-6">市场价：-->
                                <#--<del>-->
                                    <#------->
                                <#--&lt;#&ndash;<#if merchandise?? && merchandise.product??>&ndash;&gt;-->
                                    <#--&lt;#&ndash;￥${merchandise.price!}&ndash;&gt;-->
                                <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                                <#--</del>-->
                            <#--</p>-->
                            <#--<p class="col-md-6">可供：-->
                            <#--&lt;#&ndash;<#if s?? && s.stock??>&ndash;&gt;-->
                            <#--&lt;#&ndash;${s.stock}&ndash;&gt;-->
                            <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                            <#--&lt;#&ndash;欢迎垂询&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                            <#--</p>-->
                            <#--<p class="col-md-6">材质：-->
                            <#--&lt;#&ndash;<#if merchandise?? && merchandise.material??>&ndash;&gt;-->
                            <#--&lt;#&ndash;${merchandise.material}&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif merchandise.product?? && merchandise.product.material??>&ndash;&gt;-->
                            <#--&lt;#&ndash;${merchandise.product.material}&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                            <#--</p>-->
                            <#--<p class="col-md-6">重量：-->
                            <#--&lt;#&ndash;<#if s?? && s.weight??>&ndash;&gt;-->
                            <#--&lt;#&ndash;${s.weight}&ndash;&gt;-->
                            <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                            <#--&lt;#&ndash;欢迎垂询&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                            <#--</p>-->
                            <#--<form id="" class="form-horizontal" role="form">-->
                                <#--<p class="col-md-6">数量：-->
                                    <#--<input type="number" class="form-control" name="" id=""-->
                                           <#--style="display: inline-block;width: 120px" placeholder="购买数量">-->
                                    <#--<input type="hidden" class="form-control" name="specId" id="" >-->
                                <#--</p>-->
                            <#--</form>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--&lt;#&ndash;</#list>&ndash;&gt;-->
                <#--&lt;#&ndash;<#else>&ndash;&gt;-->
                    <#--<div class="tab-pane active" id="">-->
                        <#--<div class="panel-body row" style="">-->
                            <#--<p class="col-md-6">地区：-->
                            <#--&lt;#&ndash;<#if merchandise?? && merchandise.provider?? && merchandise.provider.region??>&ndash;&gt;-->
                            <#--&lt;#&ndash;${merchandise.provider.region.name!}&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider?? && provider.region??>&ndash;&gt;-->
                            <#--${merchandise.provider.districtname}-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                            <#--</p>-->
                            <#--<p class="col-md-6">价格：-->
                                <#--<#if s?? && s.price??>-->
                                    <#--&yen;${s.price}-->
                                <#--<#else>-->
                                    <#--面议-->
                                <#--</#if>-->
                            <#--</p>-->
                            <#--<p class="col-md-6">市场价：-->
                                <#--<del>-->
                                <#--<#if merchandise?? && merchandise.product??>-->
                                    <#--￥${merchandise.price!}-->
                                <#--</#if>-->
                                <#--</del>-->
                            <#--</p>-->
                            <#--<p class="col-md-6">可供：欢迎垂询</p>-->

                            <#--<p class="col-md-6">材质：-->
                            <#--<#if merchandise?? && merchandise.material??>-->
                            <#--${merchandise.material}-->
                            <#--<#elseif merchandise.product?? && merchandise.product.material??>-->
                            <#--${merchandise.product.material}-->
                            <#--</#if>-->
                            <#--</p>-->
                            <#--<p class="col-md-6">重量：欢迎垂询</p>-->
                            <#--<form id="" class="form-horizontal" role="form">-->
                                <#--<p class="col-md-12">数量：-->
                                    <#--<input type="number" class="form-control" name="" id=""-->
                                           <#--style="display: inline-block;width: 120px" placeholder="购买数量">-->
                                    <#--<input type="hidden" class="form-control" name="specId" id="" value="${merchandise.id}">-->
                                <#--</p>-->
                            <#--</form>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</#if>-->
                <#--</div>-->
                    <#--<div style="margin: 10px 0 20px">-->
                        <#--<a type="button" class="btn btn-default" id="rightNow">立即购买</a>-->
                        <#--<a type="button" class="btn btn-default" id="addCart">加入购物车</a>-->
                        <#--<a type="button" class="btn btn-default" id="btnCollection" sid="${merchandise.id}">收藏</a>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="row basicServer">-->
                <#--<div class="col-md-4">-->
                    <#--<h5>发票支持</h5>-->
                    <#--<span class="glyphicon glyphicon-file"></span>-->
                    <#--<span>普通发票</span>&nbsp;-->
                    <#--<span class="glyphicon glyphicon-print"></span>-->
                    <#--<span>增值税发票</span>-->
                <#--</div>-->
                <#--<div class="col-md-4">-->
                    <#--<h5>配货支持方式</h5>-->
                    <#--<span class="glyphicon glyphicon-home"></span>-->
                    <#--<span>送货上门</span>&nbsp;-->
                    <#--<span class="glyphicon glyphicon-shopping-cart"></span>-->
                    <#--<span>上门提货</span>-->
                <#--</div>-->
                <#--<div class="col-md-4">-->
                    <#--<h5>付款方式支持</h5>-->
                    <#--<span class="glyphicon glyphicon-credit-card"></span>-->
                    <#--<span>银行转账</span>&nbsp;-->
                <#--</div>-->
            <#--</div>-->
            <#--<div class="row">-->
                <#--<div class="col-md-9 big-col">-->
                    <#--<ul class="nav nav-tabs nav-justified" role="tablist">-->
                        <#--<li role="presentation" class="active">-->
                            <#--<a style="border-radius: 0" href="#details" aria-controls="details" role="tab"-->
                               <#--data-toggle="tab">商品详情</a>-->
                        <#--</li>-->
                        <#--<li role="presentation">-->
                            <#--<a style="border-radius: 0" href="#comment" aria-controls="comment" role="tab"-->
                               <#--data-toggle="tab">商品评价</a>-->
                        <#--</li>-->
                        <#--<li role="presentation">-->
                            <#--<a style="border-radius: 0" href="#relation" aria-controls="relation" role="tab"-->
                               <#--data-toggle="tab">相关商品</a>-->
                        <#--</li>-->
                    <#--</ul>-->
                    <#--<div class="tab-content">-->
                        <#--<div role="tabpanel" class="tab-pane active " id="details">-->
                            <#--<div class="panel-body">-->
                            <#--${merchandise.detail?default("未描述")}-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div role="tabpanel" class="tab-pane" id="comment">-->
                            <#--<div class="panel-body">-->
                                <#--<div class="col-md-4">-->
                                    <#--<p>-->
                                        <#--<span class="text-muted">产品质量：</span>-->
                                    <#--<#if !merchandise.provider.qualityScore?exists>-->
                                    <#--<i class="fa fa-fw fa-star-o"></i>-->
                                    <#--<#elseif merchandise.provider.qualityScore?int == 1>-->
                                    <#--<i class="fa fa-fw fa-star"></i><#if merchandise.provider.qualityScore gt 1 && merchandise.provider.qualityScore lt 1.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.qualityScore gte 1.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.qualityScore?int == 2>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.qualityScore gt 2 && merchandise.provider.qualityScore lt 2.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.qualityScore gte 2.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.qualityScore?int == 3>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.qualityScore gt 3 && merchandise.provider.qualityScore lt 3.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.qualityScore gte 3.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.qualityScore?int == 4>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.qualityScore gt 4 && merchandise.provider.qualityScore lt 4.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.qualityScore gte 4.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.qualityScore?int == 5>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i>-->
                                    <#--</#if>-->
                                        <#--<span style="color: orange">${merchandise.provider.qualityScore?default("无")}</span>-->
                                    <#--</p>-->
                                <#--</div>-->
                                <#--<div class="col-md-4">-->
                                    <#--<p>-->
                                        <#--<span class="text-muted">产品价格：</span>-->
                                    <#--<#if !merchandise.provider.priceScore?exists>-->
                                    <#--<i class="fa fa-fw fa-star-o"></i>-->
                                    <#--<#elseif merchandise.provider.priceScore?int == 1>-->
                                    <#--<i class="fa fa-fw fa-star"></i><#if merchandise.provider.priceScore gt 1 && merchandise.provider.priceScore lt 1.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.priceScore gte 1.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.priceScore?int == 2>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.priceScore gt 2 && merchandise.provider.priceScore lt 2.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.priceScore gte 2.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.priceScore?int == 3>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.priceScore gt 3 && merchandise.provider.priceScore lt 3.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.priceScore gte 3.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.priceScore?int == 4>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.priceScore gt 4 && merchandise.provider.priceScore lt 4.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.priceScore gte 4.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.priceScore?int == 5>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i>-->
                                    <#--</#if>-->
                                        <#--<span style="color: orange">${merchandise.provider.priceScore?default("无")}</span>-->
                                    <#--</p>-->
                                <#--</div>-->
                                <#--<div class="col-md-4">-->
                                    <#--<p>-->
                                        <#--<span class="text-muted">服务质量：</span>-->
                                    <#--<#if !merchandise.provider.serviceScore?exists>-->
                                    <#--<i class="fa fa-fw fa-star-o"></i>-->
                                    <#--<#elseif merchandise.provider.serviceScore?int == 1>-->
                                    <#--<i class="fa fa-fw fa-star"></i><#if merchandise.provider.serviceScore gt 1 && merchandise.provider.serviceScore lt 1.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.serviceScore gte 1.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.serviceScore?int == 2>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.serviceScore gt 2 && merchandise.provider.serviceScore lt 2.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.serviceScore gte 2.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.serviceScore?int == 3>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.serviceScore gt 3 && merchandise.provider.serviceScore lt 3.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.serviceScore gte 3.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.serviceScore?int == 4>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><#if merchandise.provider.serviceScore gt 4 && merchandise.provider.serviceScore lt 4.5>-->
                                    <#--<i class="fa fa-fw fa-star-half"></i><#elseif merchandise.provider.serviceScore gte 4.5><i-->
                                    <#--class="fa fa-fw fa-star-half-empty"></i></#if>-->
                                    <#--<#elseif merchandise.provider.serviceScore?int == 5>-->
                                    <#--<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i-->
                                    <#--class="fa fa-fw fa-star"></i>-->
                                    <#--</#if>-->
                                        <#--<span style="color: orange">${merchandise.provider.serviceScore?default("无")}</span>-->
                                    <#--</p>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div role="tabpanel" class="tab-pane" id="relation">-->
                            <#--<div class="panel-body">-->
                                <#--3-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <#--<div class="col-md-3 small-col">-->
                    <#--<div id="providerInfo" class="panel panel-default">-->
                        <#--<div class="panel-heading">-->
                            <#--<p class="h4" style="margin-top: 0;margin-bottom: 0">-->
                                <#--商家信息-->
                                <#--<a id="shopCollection" class="pull-right" data-provider="${merchandise.id}">-->
                                    <#--<small>收藏本店</small>-->
                                <#--</a>-->
                            <#--</p>-->
                        <#--</div>-->
                        <#--<div class="panel-body">-->
                        <#--&lt;#&ndash;<p class="h5">&ndash;&gt;-->
                        <#--&lt;#&ndash;<a href="" data-toggle="tooltip"&ndash;&gt;-->
                        <#--&lt;#&ndash;data-placement="top" title="点击进入店铺">${provider.name?default("未审核的供应商")}</a>&ndash;&gt;-->
                        <#--&lt;#&ndash;</p>&ndash;&gt;-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">所在地：</span>-->
                            <#--<#if merchandise.provider?? && merchandise.provider.districtname??>-->
                            <#--${merchandise.provider.districtname!}-->
                            <#--</#if>-->
                            <#--</p>-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">主营产品：</span>-->
                            <#--<#if merchandise.provider?? && merchandise.provider.productNames??>-->
                            <#--${ merchandise.provider.productNames!};-->
                            <#--</#if>-->
                            <#--</p>-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">质量评分：</span>-->
                            <#--&lt;#&ndash;<#if !provider.qualityScore?exists>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-o"></i>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.qualityScore?int == 1>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><#if provider.qualityScore gt 1 && provider.qualityScore lt 1.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.qualityScore gte 1.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.qualityScore?int == 2>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.qualityScore gt 2 && provider.qualityScore lt 2.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.qualityScore gte 2.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.qualityScore?int == 3>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.qualityScore gt 3 && provider.qualityScore lt 3.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.qualityScore gte 3.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.qualityScore?int == 4>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.qualityScore gt 4 && provider.qualityScore lt 4.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.qualityScore gte 4.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.qualityScore?int == 5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i>&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                                <#--<span style="color: orange">${merchandise.qualityScore?default("无")}</span>-->
                            <#--</p>-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">价格评分：</span>-->
                            <#--&lt;#&ndash;<#if !provider.priceScore?exists>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-o"></i>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.priceScore?int == 1>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><#if provider.priceScore gt 1 && provider.priceScore lt 1.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.priceScore gte 1.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.priceScore?int == 2>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.priceScore gt 2 && provider.priceScore lt 2.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.priceScore gte 2.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.priceScore?int == 3>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.priceScore gt 3 && provider.priceScore lt 3.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.priceScore gte 3.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.priceScore?int == 4>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.priceScore gt 4 && provider.priceScore lt 4.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.priceScore gte 4.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.priceScore?int == 5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i>&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                                <#--<span style="color: orange">${merchandise.priceScore?default("无")}</span>-->
                            <#--</p>-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">服务评分：</span>-->
                            <#--&lt;#&ndash;<#if !provider.serviceScore?exists>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-o"></i>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.serviceScore?int == 1>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><#if provider.serviceScore gt 1 && provider.serviceScore lt 1.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.serviceScore gte 1.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.serviceScore?int == 2>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.serviceScore gt 2 && provider.serviceScore lt 2.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.serviceScore gte 2.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.serviceScore?int == 3>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.serviceScore gt 3 && provider.serviceScore lt 3.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.serviceScore gte 3.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.serviceScore?int == 4>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><#if provider.serviceScore gt 4 && provider.serviceScore lt 4.5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star-half"></i><#elseif provider.serviceScore gte 4.5><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star-half-empty"></i></#if>&ndash;&gt;-->
                            <#--&lt;#&ndash;<#elseif provider.serviceScore?int == 5>&ndash;&gt;-->
                            <#--&lt;#&ndash;<i class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i><i class="fa fa-fw fa-star"></i><i&ndash;&gt;-->
                            <#--&lt;#&ndash;class="fa fa-fw fa-star"></i>&ndash;&gt;-->
                            <#--&lt;#&ndash;</#if>&ndash;&gt;-->
                                <#--<span style="color: orange">${merchandise.serviceScore?default("无")}</span>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div id="serviceInfo" class="panel panel-default">-->
                        <#--<div class="panel-heading">-->
                            <#--<p class="h4" style="margin-top: 0;margin-bottom: 0">-->
                                <#--客服-->
                            <#--</p>-->
                        <#--</div>-->
                        <#--<div class="panel-body">-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">售前：</span>-->
                                <#--<a href="" class="btn btn-default">客服1</a>-->
                                <#--<a href="" class="btn btn-default">客服2</a>-->
                                <#--<a href="" class="btn btn-default">客服3</a>-->
                                <#--<a href="" class="btn btn-default">客服4</a>-->
                            <#--</p>-->
                            <#--<p class="small">-->
                                <#--<span class="text-muted">售后：</span>-->
                                <#--<a href="" class="btn btn-default">客服1</a>-->
                                <#--<a href="" class="btn btn-default">客服2</a>-->
                                <#--<a href="" class="btn btn-default">客服3</a>-->
                            <#--</p>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="panel panel-default">-->
                        <#--<div class="panel-heading">-->
                            <#--<p class="h4" style="margin-top: 0;margin-bottom: 0">-->
                                <#--本店搜索-->
                            <#--</p>-->
                        <#--</div>-->
                        <#--<div class="panel-body">-->
                            <#--<form id="formInside">-->
                                <#--<div class="input-group">-->
                                    <#--<input name="name" type="text" class="form-control">-->
                                    <#--<input name="providerId" type="hidden" value="">-->
                                    <#--<span class="input-group-btn">-->
								        <#--<button class="btn btn-default" type="button" id="btnInside">Go!</button>-->
								    <#--</span>-->
                                <#--</div>-->
                            <#--</form>-->
                        <#--</div>-->
                    <#--</div>-->
                    <#--<div class="panel panel-default">-->
                        <#--<div class="panel-heading">-->
                            <#--<p class="h4" style="margin-top: 0;margin-bottom: 0">-->
                                <#--热销产品-->
                            <#--</p>-->
                        <#--</div>-->
                        <#--<div class="panel-body">-->
                            <#--<div class="thumbnail" style="border: none">-->
                                <#--<a href="">-->
                                    <#--<img src="https://unsplash.imgix.net/reserve/QTrNn7DETWGsjyS5L2n5__MG_8345.jpg?w=1024&q=50&fm=jpg&s=f89d9bb3940033eca06ed432a250bb6d"-->
                                         <#--alt="">-->
                                    <#--<span>title</span>-->
                                <#--</a>-->
                            <#--</div>-->
                            <#--<div class="thumbnail" style="border: none">-->
                                <#--<a href="">-->
                                    <#--<img src="https://unsplash.imgix.net/reserve/QTrNn7DETWGsjyS5L2n5__MG_8345.jpg?w=1024&q=50&fm=jpg&s=f89d9bb3940033eca06ed432a250bb6d"-->
                                         <#--alt="">-->
                                    <#--<span>title</span>-->
                                <#--</a>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->
<div class="container clearfix">
    <div class="pull-left">
        <div class="detailMain clearfix">
            <div class="pull-left">
                <div class="largeImg"><img src="" alt=""></div>
                <div class="imgList"></div>
                <div class="collectShare"></div>
            </div>
            <div class="pull-right">
                <h4>商品标题</h4>
                <ul>
                    <li>名称</li>
                    <li>厂家</li>
                    <li>地区</li>
                    <li>材质</li>
                    <li>质量</li>
                    <li>可供</li>
                    <li>规格</li>
                </ul>
                <div>云材价：<span>&yen;999.00/吨</span><span>（市场价&yen;1000.00）</span></div>
                <div>数量：<input type="text"></div>
                <div>合计重量：2000.00kg</div>
                <div>商品总价：&yen;2000.00元</div>
                <div>
                    <button>立即购买</button>
                    <button>加入购物车</button>
                </div>
                <ul>
                    <li>发票支持：</li>
                    <li>配送方式支持：</li>
                    <li>付款方式支持：</li>
                </ul>
            </div>
        </div>
        <div class="clearfix">
            <div class="pull-left">
                <div class="innerSearch"></div>
                <div class="serviceList"></div>
                <div class="allProduct"></div>
            </div>
            <div class="pull-right">
                <ul>
                    <li>商品详情</li>
                    <li>累计评价</li>
                    <li>相关产品及服务</li>
                </ul>
                <div class=""></div>
            </div>
        </div>
    </div>
    <div class="pull-right">
        <div></div>
        <div></div>
    </div>
</div>
</body>
<script type="text/javascript" src="/public/yun_js/mall/detail.js"></script>
<#include "../foot.ftl">