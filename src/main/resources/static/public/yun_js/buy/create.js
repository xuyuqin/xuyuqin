$(function() {
    //预定义的全局变量
    var page = 1;
    var categoryData = {};
    var citysData = {};
    var demandId = getQueryString('demandId');


    //“确定”修改按钮
    $("#changeConfirm").on('show.bs.modal', function(e) {
        $(this).find(".changeBtn").attr('sid', $(e.relatedTarget).data('sid'));
    });
    $(".changeBtn").on('click', function(e) {
        $("#changeConfirm").modal('hide');
        demandId = $(this).attr('sid');
        getOne();
    });


    //“确定”删除按钮
    $("#deleteConfirm").on('show.bs.modal', function(e) {
        $(this).find(".deleteBtn").attr('href', $(e.relatedTarget).data('href'));
    });
    $(".deleteBtn").on('click', function(e) {
        $("#deleteConfirm").modal('hide');
        var url = $(this).attr('href');
        $.post(url, {}, function(data) {
            console.log(data);
            if (data.status == 0) {
                //删除成功
                alert(data.msg);
                window.location.reload();
            } else {
                //弹出错误
                alert(data.msg);
            }
        });
    });


    //确认发布求购单按钮
    $("#createBtn").on('click', function(e) {
        var data =  new FormData($("#demandForm")[0]);
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
        var obj = $('#select2-category-container');

        if( data.get('category') != undefined ){
                data.delete('category')
                data.append('category',obj.attr('title'))
         }
            if(obj.text() == '请选择'){
                data.delete('category')
            }

        var url = "/yun/tyundemand/find";
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            processData: false,
            contentType: false,
        })
        .done(function(data) {
            if (data.code == '0') {
                //发布成功
                alert(data.msg);
                window.location.reload();
            } else {
                alert(data.msg);
            }
        })
        .fail(function() {
            console.log("error");
        });                    
    });


    //分页按钮
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
        getMyDemandList();
    });


    //获取一个求购单数据，用以编辑
    getOne();
    function getOne() {
        if (demandId == '' || demandId == undefined) {
            // var formHtml = template('formTpl', {});
            // $("#demandForm").html(formHtml);
            getCitysData(function() {
                $('#demandForm').citys({
                    required:false,
                    nodata:'disabled',
                    data:citysData
                })
            });
            // $("#category").categorySelect();
            return false;
        }
        //当前用户的求购单
        // var url = __appconfig.approot + 'www/demand/findOne';
        // $.post(url, {demandId: demandId}, function(data) {
        //     console.log(data);
        //     if (data.status == 0) {
        //         // var formHtml = template('formTpl', data.content);
        //         $("#demandForm").empty().html(formHtml);
        //         var cate = data.content.category.id;
        //         var province = data.content.district.code.toString().replace(/(\d{2})\d{4}/, '$10000');
        //         var city = data.content.district.code.toString().replace(/(\d{4})\d{2}/, '$100');
        //         var district = data.content.district.code.toString();
        //         if (province == district) {
        //             city = '';
        //             district = '';
        //         }
        //         if (city == district) {
        //             district = '';
        //         }
        //         $("#category").categorySelect(cate);
        //         getCitysData(function(){
        //             $('#demandForm').citys({
        //                 province:province,
        //                 city:city,
        //                 district:district,
        //                 required:false,
        //                 nodata:'disabled',
        //                 data:citysData
        //             })
        //         });
        //     } else {
        //         alert(data.msg);
        //     }
        // });
    }


    //获取数据列表
    // getMyDemandList();
    // page = 1;
    // function getMyDemandList() {
    //     var url = __appconfig.approot + "www/demand/findMy?page=" + page;
    //     $.ajax({
    //         url: url,
    //         type: 'POST',
    //         data: {},
    //         processData: false,
    //         contentType: false,
    //         beforeSend: function(){
    //             $('.loading').show();
    //         },
    //         complete: function(){
    //             $('.loading').hide();
    //         },
    //     })
    //     .done(function(data) {
    //         console.log(data);
    //         if (data.status == 0) {
    //             var tMainHtml = template('tMainTpl', data.content);
    //             $("#tMain").empty().html(tMainHtml);
    //             $("#pageBar").empty().pageBar({
    //                 'totalpags': data.content.totalPages,
    //                 'number': data.content.number
    //             });
    //         }
    //     })
    //     .error(function() {
    //         alert('error');
    //     })
    // }


    //城市三级联动
    function getCitysData(ck){
        if($.isEmptyObject(citysData)){        
            var citys = sessionStorage.citys;
            if(typeof citys == 'undefined' || citys == null){
                $.getJSON( '/yun/region/list', function(datas){
                    for(var x in datas.list){
                        citysData[datas.list[x].code]=datas.list[x].name;
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
    //类别
    function cateGory(){
        $.ajax({
            url: url+"/yun/category/list",
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
});