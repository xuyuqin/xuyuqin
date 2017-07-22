$(function () {
	
	
	  $.ajax({
			type: "GET",
		    url: "../bgyun/product/queryCategory/",
		    contentType: "application/json",
		    success: function(r){
		    	vm.c = r;

		    	
			}
		});
      $.ajax({
      	type: "GET",
      	url: "../bgyun/product/queryVariety/",
      	contentType: "application/json",
      	success: function(r){
      		vm.s = r;
      		
      		
      	}
      });
      
 
//	$("#category").select2({
//		placeholder:'请选择',
//		ajax:{
//			url: "../bgyun/product/queryCategory/",
//		    dataType: 'json',
//		    delay: 250,
//		  
//		    processResults: function (data) {
//		    	
//		      return {
//		        results: data
//		      };
//		    },
//		    cache: true
//		  },
//	
//	});
//	
//	$("#subCategoryName").select2({
//		placeholder:'请选择',
//		ajax:{
//			url: "../bgyun/product/queryVariety/",
//			dataType: 'json',
//			delay: 250,
//			
//			
//			processResults: function (data) {
//				return {
//					results: data
//				};
//			},
//			cache: true
//		},
//
//	});
//	
	
    $("#jqGrid").jqGrid({
        url: '../bgyun/product/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '产品名称', name: 'name', index: 'name', width: 80 }	,	
			{ label: '产品分类', name: 'categoryName', index: 'categoryName', width: 80 }, 			
			{ label: '产品品种', name: 'subCategoryName', index: 'subCategoryName', width: 80 }, 			
			{ label: '产品别名', name: 'aliasName', index: 'aliasName', width: 80 }, 			
			{ label: '市场价', name: 'price', index: 'price', width: 80 }, 			
			{ label: '最后修改时间', name: 'editTime', index: 'editTime', width: 80 }			
		
				
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
		showSure: true,
		title: null,
		product: {},
//		cName: '增强材料',
		c:{},
//		sCName: '苯酐',
		s:{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showSure = false;
			vm.title = "新增";
			vm.product = {};
			
		},

		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = true;
			vm.showSure = false;
            vm.title = "修改";
            
            vm.getInfo(id);
          
            
           
			
		},
		info: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
			vm.showSure = true;
			vm.title = "详情";
			vm.getInfo(id);
	
		},
		saveOrUpdate: function (event) {
			var url = vm.product.id == null ? "../bgyun/product/save" : "../bgyun/product/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.product),
			   
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
				    url: "../bgyun/product/delete",
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
			$.get("../bgyun/product/info/"+id, function(r){
	
                vm.product = r.tYunProduct;
            });
		},
		reload: function (event) {
			vm.showList = true;
			vm.showSure = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});