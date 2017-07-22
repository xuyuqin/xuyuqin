<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<head>
</head>
<table>热搜
<#list tYunProduct as l>
    <tr>
        <td>${l.id}</td>
        <td>${l.categoryName}</td>
        <td>${l.subCategoryName}</td>
        <td>${l.name}</td>
    </tr>
</#list>
</table>
<hr/>
<table>热搜
<#list tYunProvider as k>
    <tr>
        <td>${k.prividerName}</td>
        <td>${k.prividerPrice}</td>
    </tr>
</#list>
</table>
<hr/>
<table>热搜
<#list tYunBuyPrice as h>
    <tr>
        <td>${h.memberId}</td>
        <td>${h.createTime}</td>  <td>${h.buyPrice}</td>
    </tr>
</#list>
</table>
<hr/>

</body>
</html>