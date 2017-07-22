
$(function() {

    var page = 1;
    var publishPage = 1;
    var citysData={};
    var type = 1;
    var reportPage = 1;
    // $("#category").categorySelect();
    // $("#category").select2({
    //     data: selectedCategory,
    //     placeholder:'请选择',
    //     allowClear: true
    // });
    getCitysData(function(){
    $('#marketSearch').citys({
            required:false,
            nodata:'disabled',
            data:citysData
        });
    });

    //城市三级联动
    function getCitysData(ck){
        if($.isEmptyObject(citysData)){
            var citys = sessionStorage.getItem('citys');
            if(typeof citys == 'undefined' || citys == null || citys == '{}'){
                $.ajaxSettings.async = false;
                $.getJSON('/yun/region/list', function(datas){
                    for(var x in datas.list){
                        citysData[datas.list[x].code]=datas.list[x].name;
                    }
                    sessionStorage.setItem('citys', JSON.stringify(citysData));
                    ck();

                });
                $.ajaxSettings.async = true;
            } else{
                citysData=JSON.parse(citys);
                ck();
            }
        }else{
            ck();
        }
    }

    //搜索
    $("#btnSearch").click(function() {
        page = 1;
        getMarketList();
    });


    //分页按钮
    $(document).on('click', '#pageBar li', function(e) {
        if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
            return  false;
        }
        if(type == 1){
            if ($(this).hasClass('prev')) {
                page--;
                if(page <= 0){
                    page = 1;
                }
            } else if ($(this).hasClass('next')) {
                page++;
            } else {
                page = $(this).find('a').html();
            }
            getMarketList(page);
        }else if(type == 2){
            if ($(this).hasClass('prev')) {
                publishPage--;
                if(publishPage <= 0){
                    publishPage = 1;
                }
            } else if ($(this).hasClass('next')) {
                publishPage++;
            } else {
                publishPage = $(this).find('a').html();
            }
            myPublishClick(publishPage);
        }else if(type == 3){
            if ($(this).hasClass('prev')) {
                reportPage--;
                if(reportPage <= 0){
                    reportPage = 1;
                }
            } else if ($(this).hasClass('next')) {
                reportPage++;
            } else {
                reportPage = $(this).find('a').html();
            }
            myReportClick(reportPage);
        }

    });


    //获取列表数据
    getMarketList();
    page = 1;
    function getMarketList() {
        if(!$('#all').hasClass('active')){
            $('#all').addClass('active').siblings().removeClass('active')
        }
        var data = new FormData($("#marketSearch")[0]);
        if (data.get('district') != '' && data.get('district') != undefined && data.get('district') != null) {
            data.delete('city');
            data.delete('province');
        }else if (data.get('city') != '' && data.get('city') != undefined && data.get('city') != null) {
            data.append('district', '');
            data.delete('province');
            data.set('district', data.get('city'));
            data.delete('city');
        }else if (data.get('province') != '' && data.get('province') != undefined && data.get('province') != null) {
            data.append('district', '');
            data.set('district', data.get('province'));
            data.delete('province');
            data.delete('city');
        }
        // data.delete('district')
        // data.append('district','44')

        if(data.get('memberId') == ''){
            data.delete('memberId')
        }

        $.ajax({
            url: '/yun/tyundemand/list?page='+page,
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
            type = 1;
            if(data.code == 0 && data.page.list.length>0){
                sessionStorage.setItem("list",JSON.stringify(data.page.list));
                var str = '';
                for(var i=0,length=data.page.list.length;i<length;i++){
                    var button = "<a  class='btn btn-success' href='/yuncai/demand/price?demandId="+data.page.list[i].id+"&type=1'>我要报价</a>";
                    str+='<tr><td>'+editCategory(data.page.list[i].category)+'</td><td>'+isNull(data.page.list[i].productName)+'</td>' +
                        '<td>'+editValidity(data.page.list[i].validity)+'</td><td>'+isNull(data.page.list[i].name)+'</td>' +
                        '<td>'+isNull(data.page.list[i].material)+'</td><td>'+isNull(data.page.list[i].specification) +'</td>' +
                        '<td>'+editDistrict(data.page.list[i].district)+'</td><td>'+isNull(data.page.list[i].amount)+'</td><td>'+editAmount(data.page.list[i].replyCount)+'</td><td>'+button+'</td></tr>'

                }
                $("#tMain").empty().html(str);
            }else{
                $("#tMain").empty();
            }
            if(data.page.totalPage >1){
                $("#pageBar").empty().pageBar({
                    'totalpags': data.page.totalPage,
                    'number': data.page.currPage
                });
            }else{
                $("#pageBar").empty()
            }
        })
        .fail(function() {
            alert("error");
        });
    }
    $('#all').click(getMarketList);

    function editCategory(val) {
        var category =JSON.parse( sessionStorage.getItem('categoryList'));
        for (var i in category){
            for(var j in category[i]){
                for (var k in category[i][j]){
                    if(val == category[i][j][k].id){
                        return category[i][j][k].text;
                    }
                }
            }
        }
        return '';

    }


     function isNull (val) {
         return val === null ? '' : val;
     }
     function editAmount(val) {
        return val == 0 || val == null ? '尚未报价':val+'次报价';
     }
     function editValidity(val) {
         var obj ;
         switch(val)
         {
             case '1':
                obj =   '一天';
                 break;
             case '2':
                obj =  '一周';
                 break;
             case '3':
                obj =  '一月';
                 break;
             case '4':
                obj =  '永久';
                 break;

         }
         return obj
     }
     function editDistrict(val) {
        if(val == '' || val == null) {
            return '';
        }else{
                var arr = JSON.parse(sessionStorage.getItem('citys'));
                return arr[val];

        }
     }
    //我发布的
   function myPublishClick (page){
        $("#tMain").empty();
        $.ajax({
            url: "/yun/tyundemand/listmy?page="+page,
            type: 'POST',
            data: {},
            // async: false,
            processData: false,
            contentType: false,
        }).done(function(data) {
            $('#myPublish').addClass("active").siblings().removeClass("active");
            type = 2;
            sessionStorage.setItem("list",JSON.stringify(data.page.list));
            if( data.page.list.length>0){
                var str="";
                    for(var i=0;i<data.page.list.length;i++){
                        var button='<a tid="examine" href="/yuncai/demand/view?demandId='+data.page.list[i].id+'" class="btn btn-default">查看</a><a tid="edit" class="btn btn-default" href="/yuncai/demand/edit?demandId='+data.page.list[i].id+'">修改</a><a tid="del" mid = "'+data.page.list[i].id+'" class="btn btn-default">删除</a>'
                        str+='<tr><td>'+editCategory(data.page.list[i].category)+'</td><td>'+isNull(data.page.list[i].productName)+'</td>' +
                        '<td>'+editValidity(data.page.list[i].validity)+'</td><td>'+isNull(data.page.list[i].name)+'</td>' +
                        '<td>'+isNull(data.page.list[i].material)+'</td><td>'+isNull(data.page.list[i].specification) +'</td>' +
                        '<td>'+editDistrict(data.page.list[i].district)+'</td><td>'+isNull(data.page.list[i].amount)+'</td><td>'+editAmount(data.page.list[i].replyCount)+'</td><td>'+button+'</td></tr>'
                }

                $("#tMain").empty().html(str);

            }else{
                $("#tMain").empty();
            }
            if(data.page.totalPage >1){
                $("#pageBar").empty().pageBar({
                    'totalpags': data.page.totalPage,
                    'number': data.page.currPage
                });
            }else{
                $("#pageBar").empty()
            }
        })
            .fail(function() {
                console.log("error");
            });
    }

    $('#myPublish').click(function(){
        myPublishClick(publishPage);
    });

    //我报价的
    function myReportClick(page){
        $("#tMain").empty();
        $.ajax({
            url: '/yun/tyundemand/listbaojia?page='+page,
            type: 'POST',
            data: {},
            // async: false,
            processData: false,
            contentType: false,
        }).done(function(data) {
             type = 3
            $('#myReport').addClass("active").siblings().removeClass("active");
            sessionStorage.setItem("list",JSON.stringify(data.page.list));
            if( data.page.list.length>0){
                var str="";
                for(var i=0;i<data.page.list.length;i++){
                    var button='<a id="report" class="btn btn-default" href="/yuncai/demand/price?demandId='+data.page.list[i].id+'&type=2">再次报价</a>';
                    str+='<tr><td>'+editCategory(data.page.list[i].category)+'</td><td>'+isNull(data.page.list[i].productName)+'</td>' +
                        '<td>'+editValidity(data.page.list[i].validity)+'</td><td>'+isNull(data.page.list[i].name)+'</td>' +
                        '<td>'+isNull(data.page.list[i].material)+'</td><td>'+isNull(data.page.list[i].specification) +'</td>' +
                        '<td>'+editDistrict(data.page.list[i].district)+'</td><td>'+isNull(data.page.list[i].amount)+'</td><td>'+editAmount(data.page.list[i].replyCount)+'</td><td>'+button+'</td></tr>'
                }

                $("#tMain").empty().html(str);

            }else{
                $("#tMain").empty();
            }
            if(data.page.totalPage >1){
                $("#pageBar").empty().pageBar({
                    'totalpags': data.page.totalPage,
                    'number': data.page.currPage
                });
            }else{
                $("#pageBar").empty()
            }

        })
            .fail(function() {
                console.log("error");
            });
    }
    $('#myReport').click(function () {
        myReportClick(reportPage);
    })




    function cateGory(){
        $.ajax({
            url: "/yun/category/list",
            type: 'POST',
            data: {},
        }).done(function(data) {

            if(data.code == "0"){
                var obj = [{ id: "", text: '请选择' }];

                var a = 1;
                for (var i = 0; i < data.list.length;i++) {
                    if(data.list[i].parent == null){
                        var person = {};
                        person.id = data.list[i].id;
                        person.text = data.list[i].name;
                        person.children = [];
                        obj.push(person);
                        if(i !== 0){

                            a++;
                        }

                    }else{
                        var children = {};
                        children.id = data.list[i].id;
                        children.text = data.list[i].name;
                        obj[a].children.push(children);
                    }

                }
                sessionStorage.setItem('categoryList',''+JSON.stringify(obj)+'');
                $("#category").select2({
                    data: obj,
                    placeholder:'请选择',
                    allowClear: true
                });

            }else{
                alert("error");
            }

        }).fail(function() {
            console.log("error");
        });
    }cateGory();

    $(document).on('click','[tid=del]',function(){
        var id = $(this).attr('mid');
        tishiModal('提示框','确认删除该找货单吗?',"confirm('"+id+"')")
    })

});

function confirm(id){
    // alert(id)
    $.ajax({
        url: '/yun/tyundemand/deleteRelease?id='+id,
        type: 'POST',
        data: {},
        processData: false,
        contentType: false,
    }).done(function(data) {
        if(data.code == 500 && data.msg == '请先登录！'){
            window.location.href = '/yuncai/login';
        }
        if(data.code == 0){
            alert('删除成功');
            window.location.href = '/yuncai/demand/index'
        }
    })
        .fail(function() {
            console.log("error");
        });
}