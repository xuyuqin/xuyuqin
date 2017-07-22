<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<head>
</head>
<table>产品信息
<#list tYunProduct as l>
    <tr>
        <td>${l.id}</td>
        <td>${l.categoryName}</td>
        <td>${l.subCategoryName}</td>
        <td>${l.material!'null'}</td>
        <td>${l.unit!'null'}</td>
        <td>${l.price!'null'}</td>
        <td>${l.aliasName}</td>
        <td>${l.name}</td>
        <td>${l.upName}</td>
    </tr>
</#list>
</table>
<hr/>
<table>图片
<#list tYunProductImg as k>
    <tr>
        <td>${k.url}</td>
    </tr>
</#list>
</table>
<hr/>
<table>模块信息
<#list tYunProductmodule as h>
    <tr>
        <td>${h.moduleContent}</td>
    </tr>
</#list>
</table>
<hr/>
<table>下游产品
<#list tYunProductDownName as p>
    <tr>
        <td>${p.id!'null'}</td>
        <td>${p.downName!'null'}</td>
    </tr>
</#list>
</table>
<hr/>
<table>供应商
<#list tYunProviderList as p>
    <tr>
       <td>${p.id!'null'}</td>
       <td>${p.name!'null'}</td>
       <td>${p.districtname!'null'}</td>
      <td>${p.score!'null'}</td>
    </tr>
</#list>
</table>
<hr/>
</body>
</html>