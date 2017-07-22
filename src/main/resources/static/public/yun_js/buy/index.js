$(function() {
    var tab = $("#tab").attr("tab");
	var page = 1;
    var citysData={};
    $("#category").categorySelect();
    getCitysData(function(){
        $('#demandSearch').citys({
            required:false,
            nodata:'disabled',
            data:citysData
        });
    });


    //搜索
    $("#btnSearch").click(function() {
        getDemandList();
        page = 1;
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
        getDemandList();
    });


    //获取列表数据
    getDemandList();
    page = 1;
    function getDemandList() {
        var data = new FormData($("#demandSearch")[0]);
        data.append('region', '');
        if (data.get('province') != '' && data.get('province') != undefined && data.get('province') != null) {
            data.set('region', data.get('province').substr(0, 2));
            data.delete('province');
        }
        if (data.get('city') != '' && data.get('city') != undefined && data.get('city') != null) {
            data.set('region', data.get('city').substr(0, 4));
            data.delete('city');
        }
        if (data.get('district') != '' && data.get('district') != undefined && data.get('district') != null) {
            data.set('region', data.get('district'));
            data.delete('district');
        }
        if (tab == 3) {
            var url = __appconfig.approot + "www/demand/findPrice?rows=&page=" + page;
        } else if (tab == 2) {
            var url = __appconfig.approot + "www/demand/findMy?rows=&page=" + page;
        } else {
            var url = __appconfig.approot + "www/demand/findAll?rows=&page=" + page;
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
            console.log(data.content);
            if (data.status == 0) {
                var tMainHtml = template('tMainTpl', data.content);
                $("#tMain").empty().html(tMainHtml);
                $("#pageBar").empty().pageBar({
                    'totalpags': data.content.totalPages,
                    'number': data.content.number
                });
            }
        })
        .error(function() {
            alert(data.msg);
        })
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