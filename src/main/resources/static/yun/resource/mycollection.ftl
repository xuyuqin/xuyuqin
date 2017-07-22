<@layout.extends name="app/yun/resource/index.ftl">

	<@layout.put block="tMainTpl" type="replace">
		<script id="tMainTpl" type="text/html">
			<%if(content.length >= 1) {%>
				<%for (var i = 0; i < content.length; i++) {%>
					<tr>
					    <td><%=content[i].resource.companyHead%></td>
		            	<td><%=content[i].resource.provider.name%></td>
		            	<td><%=content[i].resource.category.name%></td>
		            	<td><%=content[i].resource.district.name%></td>
		            	<td><%=content[i].resource.name%></td>
		            	<td>￥<%=content[i].resource.scale%></td>
		            	<td><%=content[i].resource.uploadTime.substr(5, 11)%></td>
					    <td sid="<%=content[i].resource.id%>">
		            	    <a class="btn btn-success" id="">预览</a>
		            	    <a class="btn btn-warning" href="">下载</a>
		            	    <a href="javascript:void(0)" class="btn btn-danger collectionBtn">取消</a>
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