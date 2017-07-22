$(function () {
    $("#jqGrid").jqGrid({
        url: '../bgyun/resource/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '审核状态', name: 'isPermit', index: 'isPermit', width: 80 }	,	
			{ label: '资源单名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '公司抬头', name: 'companyHead', index: 'companyHead', width: 80 }, 			
			{ label: '发布时间', name: 'uploadTime', index: 'uploadTime', width: 80 }, 			
			{ label: '地区', name: 'district', index: 'district', width: 80 }, 			
			{ label: '商品类别', name: 'category', index: 'category', width: 80 }, 			
			{ label: '发布人', name: 'providername', index: 'providername', width: 80 }, 			
			{ label: '下载次数', name: 'downloadtimes', index: 'downloadtimes', width: 80 }		
				
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		resource: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		my: function () {
//			$("#jqGrid").jqGrid("clearGridData");		
			$("#jqGrid").jqGrid('setGridParam',{
	        url: '../bgyun/resource/listMy',
	    }).trigger("reloadGrid");
	
		},
		permit: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "审批";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.resource.id == null ? "../bgyun/resource/save" : "../bgyun/resource/permit";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.resource),
			   
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: "../bgyun/resource/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../bgyun/resource/info/"+id, function(r){
	
                vm.resource = r.tYunResource;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});