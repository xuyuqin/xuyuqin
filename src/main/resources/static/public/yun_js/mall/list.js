$(function() {
	var tab = $("#tab").attr("tab");
    var page = 1;
    var needInit = true;
    var merchandiseCollections = [];
    var citysData = {};
    $("#cate").categorySelect(getQueryString('cate')); 
    getCitysData(function() {
        $('#mallForm').citys({
            required: false,
            nodata: 'disabled',
            province: getQueryString('province'),
            city: getQueryString('city'),
            district: getQueryString('district'),
            data: citysData
        })
    });

    //找货
    $("#btnSearch").click(function(e) {
        page = 1;
        getMerchandiseList();
    });

    //收藏
    $(document).on('click', '.collection', function(e) {
        var sid = $(this).attr('sid');
        var url = __appconfig.approot + 'www/merchandise/collection?merchandiseId=' + sid;
        var $btn = $(this);
        $.post(url, {}, function(data) {
            console.log(data);
            if (data.status == 0) {
                alert(data.msg);
                if ($.isEmptyObject(data.content)) {
                    for (var i = 0; i < merchandiseCollections.length; i++) {
                        if(merchandiseCollections[i] == sid) {
                            merchandiseCollections.splice(i, 1);
                        }
                    }
                    if (tab == 1) {
                        $btn.text('收藏');
                    } else {
                        $btn.parents("tr").remove();
                    }                         
                } else {
                    if (tab == 1) {
                        merchandiseCollections.push(data.content.merchandise.id);
                        $btn.text('取消');
                    } else {
                        location.reload();
                    }                    
                }
            } else {
                alert(data.msg);
            }
        });
    });

    //加入购物车
    $(document).on('click', '.addCart', function(e) {
        var url = app.approot + 'www/cart/addOne?amount=&specId=' + $(this).attr('spec');
        $.post(url, {}, function(data) {
            console.log(data);
            if (data.status == 0) {
                //to do刷新购物车标志
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        });
    });

    //分页
    $(document).on('click', '#pageBar li', function(e) {
        if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
            return false;
        }
        if ($(this).hasClass('prev')) {
            page--;
        } else if ($(this).hasClass('next')) {
            page++;
        } else {
            page = $(this).find('a').html();
        }
        getMerchandiseList();
    });


    //获取列表数据
    getMerchandiseList();
    page = 1;
    function getMerchandiseList() {
    	if (needInit) {
    		var data = new FormData($("#mallForm")[0]);
    		var name = getQueryString('name');
    		var spec = getQueryString('spec');
    		var material = getQueryString('material');
    		var factory = getQueryString('factory');
    		var cate = getQueryString('cate');
    		var district = getQueryString('district');
    		var city = getQueryString('city');
    		var province = getQueryString('province');
    		if (name != '' && name != undefined && name != null) {
    		    $("#name").attr('value', name);
    		    data.append('name', name);
    		}
    		if (spec != '' && spec != undefined && spec != null) {
    		    $("#spec").attr('value', spec);
    		    data.append('spec', spec);
    		}
    		if (material != '' && material != undefined && material != null) {
    		    $("#material").attr('value', material);
    		    data.append('material', material);
    		}
    		if (factory != '' && factory != undefined && factory != null) {
    		    $("#factory").attr('value', factory);
    		    data.append('factory', factory);
    		}    				
    		if (cate != '' && cate != undefined && cate != null) {
    		    data.append('cate', cate);
    		}
    		if (district != '' && district != undefined && district != null) {
    		    data.append('district', district);
    		} else if (city != '' && city != undefined && city != null) {
    		    data.append('city', city);
    		} else if (province != '' && province != undefined && province != null) {
    		    data.append('province', province);
    		}
            needInit = false;
    	} else {
    		var data = new FormData($("#mallForm")[0]);
    	}
        if (tab == 2) {
        	var url = __appconfig.approot + 'www/merchandise/searchCollection?page=' + page;
        } else {
        	var url = __appconfig.approot + 'www/merchandise/search?page=' + page;
        	getMyCollection();
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            processData: false,
            contentType: false,
            beforeSend: function() {
                $('.loading').show();
            },
            complete: function() {
                $('.loading').hide();
            },
        })
        .done(function(data) {
            console.log(data);
            if (data.status == 0) {
            	if (tab == 1) {
            		for (var i = 0; i < data.content.content.length; i++) {
            		    for (var j = 0; j < merchandiseCollections.length; j++) {
            		        if (merchandiseCollections[j] == data.content.content[i].id) {
            		            data.content.content[i].isCollection = 1;
            		            j = merchandiseCollections.length - 1;
            		        } else {
            		            data.content.content[i].isCollection = 0;
            		        }
            		    }
            		}
            	}
                var listHtml = template('tMianTpl', data.content);
                $("#tMain").empty().html(listHtml);
                $("#pageBar").empty().pageBar({
                    'totalpags': data.content.totalPages,
                    'number': data.content.number,
                });
            } else {
                alert(data.msg);
            }
        })
        .fail(function(data) {
            console.log("error");
        });
    }


    //获取我收藏的
    function getMyCollection() {
    	$.ajax({
    		url: __appconfig.approot + 'www/merchandise/listMyCollection',
			type: 'POST',
			data: {},
			async: false,
			processData: false,
			contentType: false,
    	})
    	.done(function(data) {
    		merchandiseCollections = $.map(data.content, function(item, index) {
                return item.merchandise.id;
            });
    	})
    	.fail(function() {
    		console.log("error");
    	});    	
    }
    

    //城市三级联动
    function getCitysData(ck){
        if($.isEmptyObject(citysData)){        
            var citys = sessionStorage.citys;
            if(typeof citys == 'undefined' || citys == null){
                $.getJSON(__appconfig.approot + 'www/region/all', function(datas){
                    for(var x in datas.content){
                        citysData[datas.content[x].code]=datas.content[x].name;
                    }
                    sessionStorage.setItem('citys', JSON.stringify(citysData))
                    ck();
                });
            } else{
                citysData=JSON.parse(citys);
                ck();
            }
        }else{
            ck();
        }
    }
});