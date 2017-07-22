$(function () {
    $("#jqGrid").jqGrid({
        url: '../bgyun/demand/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '审核状态', name: 'isPermit', index: 'isPermit', width: 80 }	,	
			{ label: '产品名称', name: 'productName', index: 'productName', width: 80 }, 			
			{ label: '商品类别', name: 'category', index: 'category', width: 80 }, 			
			{ label: '商品规格', name: 'specification', index: 'specification', width: 80 }, 			
			{ label: '商品材质', name: 'material', index: 'material', width: 80 }, 			
			{ label: '求购数量', name: 'amount', index: 'amount', width: 80 }, 			
			{ label: '发布时间', name: 'createTime', index: 'createTime', width: 80 }, 			
			{ label: '求购单状态', name: 'replyCount', index: 'replyCount', width: 80 },		
			{ label: '求购人', name: 'contract', index: 'contact', width: 80 }	
				
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
		demand: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		my: function () {
//			$("#jqGrid").jqGrid("clearGridData");		
			$("#jqGrid").jqGrid('setGridParam',{
	        url: '../bgyun/demand/listMy',
	    }).trigger("reloadGrid");
	
		},
		permit: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "审核";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.demand.id == null ? "../bgyun/demand/save" : "../bgyun/demand/permit";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.demand),
			   
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
				    url: "../bgyun/demand/delete",
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
			$.get("../bgyun/demand/info/"+id, function(r){
	
                vm.demand = r.tYunDemand;
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