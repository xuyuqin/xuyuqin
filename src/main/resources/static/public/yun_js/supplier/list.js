$(function() {
    var tab = $("#tab").attr("tab");
    var productId = getQueryString('productId');
    var page = 1;
    var needInit = true;
    var providerCollections = [];
    var citysData = {};
    $("#category").categorySelect(getQueryString('category'));
    getCitysData(function() {
        $('#providerForm').citys({
            required: false,
            nodata: 'disabled',
            province: getQueryString('province'),
            city: getQueryString('city'),
            district: getQueryString('district'),
            data: citysData,
        })
    });


    //搜索按钮
    $("#btnSearch").click(function(e) {
        page = 1;
        getProviderList();
    });


    //收藏
    $(document).on('click', '.collection', function(e) {
        var sid = $(this).attr('sid');
        var url = __appconfig.approot + 'www/provider/collection?providerId=' + sid;
        $btn = $(this);
        $.post(url, {}, function(data) {
            console.log(data);
            if (data.status == 0) {
                if ($.isEmptyObject(data.content)) {
                    for (var i = 0; i < providerCollections.length; i++) {
                        if(providerCollections[i] == sid) {
                            providerCollections.splice(i, 1);
                        }
                    }
                    if (tab == 2) {
                        $(e.target).parents("tr").remove();
                    } else {
                        $(e.target).text('收藏');
                    }                    
                } else {
                    //新增一个收藏
                    if (tab == 2) {
                        location.reload();
                    } else {
                       providerCollections.push(data.content.provider.id);
                        $(e.target).text('取消'); 
                    }                    
                }
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
        getProviderList(); 
    });


    //获取列表数据
    getProviderList();
    page = 1;
    function getProviderList() {
        if (needInit) {
            var data = new FormData($("#providerForm")[0]);
            var name = getQueryString('name');
            var cate = getQueryString('category');
            var district = getQueryString('district');
            var city = getQueryString('city');
            var province = getQueryString('province');
            if(productId != '' && productId != undefined && productId != null) {
                $("#productId").attr('value', productId);
                data.set('productId', productId);
            }
            if(name != '' && name != undefined && name != null) {
                $("#name").attr('value', name);
                data.append('name', name);
            }
            if(cate != '' && cate != undefined && cate != null) {
                data.append('category', cate);
            }            
            if(district != '' && district != undefined && district != null) {
                data.append('district', district);
            } else if(city != '' && city != undefined && city != null) {
                data.append('city', city);
            } else if(province != '' && province != undefined && province != null) {
                data.append('province', province);
            }
            needInit = false;
        } else {
            var data = new FormData($("#providerForm")[0]);
        }
        if (productId != '' && productId != undefined && productId != null) {
            var url = __appconfig.approot + 'www/provider/searchRelevant?page=' + page;
            getMyCollection();
        } else if (tab == 2) {
            var url = __appconfig.approot + 'www/provider/searchCollection?page=' + page;
        } else {
            var url = __appconfig.approot + 'www/provider/search?page=' + page;
            getMyCollection();
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            processData: false,
            contentType: false,
            beforeSend: function(){
                $('.loading').show();
            },
            complete: function(){
                $('.loading').hide();
            },
        })
        .done(function(data) {
            console.log(data);
            if (data.status == 0) {
                if (tab == 1) {
                    for (var i = 0; i < data.content.content.length; i++) {
                        for (var j = 0; j < providerCollections.length; j++) {
                            if (providerCollections[j] == data.content.content[i].id) {
                                data.content.content[i].isCollection = 1;
                                j = providerCollections.length - 1;
                            } else {
                                data.content.content[i].isCollection = 0;
                            }
                        }
                    }
                }
                var listHtml = template('tMainTpl', data.content);
                $("#tMain").empty().html(listHtml);
                $("#pageBar").empty().pageBar({
                    'totalpags': data.content.totalPages,
                    'number': data.content.number,
                });
            } else {
                alert(data.msg);
            }
        })
        .fail(function() {
            console.log("error");
        });
    }


    //获取我收藏的
    function getMyCollection() {
        var url = __appconfig.approot + 'www/provider/listMyCollection';
        $.ajax({
            url: url,
            type: 'POST',
            data: {},
            async: false,
            processData: false,
            contentType: false,
        })
        .done(function(data) {
            providerCollections = $.map(data.content, function(item, index) {
                return item.provider.id;
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