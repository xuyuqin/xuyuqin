<!DOCTYPE HTML>
<html lang="zh-cn" style="height:100%;">
<head>
</head>
<table>热搜
<#list hotProductList as l>

    <tr>
        <td>${l.id}</td>
        <td>${l.name}</td>
    </tr>

    <#--<#list nameList as k>-->
        <#--<#if "${l.id}"=="${k.id}">-->
        <#--<tr>-->
            <#--<td>${k.id}</td>-->
            <#--<td>${k.aliasName}</td>-->
        <#--</tr>-->
        <#--</#if>-->
    <#--</#list>-->
</#list>

    </table>
<hr/>
<table>
    别名
<#list nameList as k>
    <tr>
        <td>${k.id}</td>
        <td>${k.aliasName}</td>
    </tr>
</#list>
    </table>


<hr/>
<table>
    类别
<#list tYunCategoryList as q >
<#if "${q.parent!'0'}"=='0'>
<else>
<tr>
   <td> ${q.id}</td>
    <td> ${q.name}</td>
</tr>
         </#if>
            <#list tYunCategoryList as p >
             <#if "${p.parent!'0'}"=="${q.id}">
             <tr>
                 <td>........ ${p.id}</td>
                 <td> ${p.name}</td>
</tr>
                   <#list baikelist as h >
                     <#if "${p.parent!'0'}"!='0'&&"${p.name}"=="${h.subCategoryName}">
                         <tr>
                         <td>..................${h.id}</td>
                         <td> ${h.name}</td>
                         </tr>
                       </#if>
                        </#list>
                      </#if>
        </#list>
</#list>
</table>



</body>
</html>