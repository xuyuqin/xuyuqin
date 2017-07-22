$(function () {
    $("#jqGrid").jqGrid({
        url: '../bgyun/merchandise/list',
        datatype: "json",
        colModel: [			
			{ label: '商品编号', name: 'id', index: 'ID', width: 50, key: true },
			{ label: '商品标题', name: 'name', index: 'NAME', width: 80 }, 			
			{ label: '商品价格', name: 'price', index: 'PRICE', width: 80 }, 			
			{ label: '推荐', name: 'isRecommend', index: 'IS_RECOMMEND', width: 80 }, 			
			{ label: '库存数量', name: 'number', index: 'NUMBER', width: 80 }, 			
			{ label: '商品状态', name: 'inSale', index: 'IN_SALE', width: 80 }, 			
			{ label: '产品名称', name: 'productId', index: 'PRODUCT_ID', width: 80 }, 			
			
			
			{ label: '产品品种', name: 'subCategoryId', index: 'SUB_CATEGORY_ID', width: 80 }, 			
			{ label: '产品分类', name: 'categoryName', index: 'CATEGORY_NAME', width: 80 }, 			
				
			{ label: '商品销量', name: 'saleNum', index: 'SALE_NUM', width: 80 }, 			
			{ label: '一级会员价', name: 'price1', index: 'PRICE1', width: 80 }, 			
			
		
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
		tYunMerchandise: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.tYunMerchandise = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.tYunMerchandise.id == null ? "../tyunmerchandise/save" : "../tyunmerchandise/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.tYunMerchandise),
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
				    url: "../tyunmerchandise/delete",
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
			$.get("../tyunmerchandise/info/"+id, function(r){
                vm.tYunMerchandise = r.tYunMerchandise;
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