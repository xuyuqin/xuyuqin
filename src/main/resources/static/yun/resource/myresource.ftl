<@layout.extends name="app/yun/resource/index.ftl">

	<@layout.put block="tMainTpl" type="replace">
		<script id="tMainTpl" type="text/html">
			<%if(content.length >= 1) {%>
				<%for (var i = 0; i < content.length; i++) {%>
					<tr>
					    <td><%=content[i].companyHead%></td>
		            	<td><%=content[i].provider.name%></td>
		            	<td><%=content[i].category.name%></td>
		            	<td><%=content[i].district.name%></td>
		            	<td><%=content[i].name%></td>
		            	<td>￥<%=content[i].scale%></td>
		            	<td><%=content[i].uploadTime.substr(5, 11)%></td>
					    <td sid="<%=content[i].id%>">
		            	    <a href="${app.approot}www/resource/edit?resourceId=<%=content[i].id%>" class="btn btn-success" >修改</a>
		            	    <a type="button" class="btn btn-danger deleteBtn" data-toggle="modal" data-target="#deleteConfirm" data-href="${app.approot}www/resource/delete?resourceId=<%=content[i].id%>">删除</a>
		            	</td>
					</tr>
				<%}%>
			<%} else {%>
			    <tr>
			        <td>暂无数据</td>
			    </tr>
			<%}%>
		</script>
	</@layout.put>
	
</@layout.extends>