//发布找货单
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


    $('#demandForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            name: {
                message: '名称验证失败',
                validators: {
                    notEmpty: {
                        message: '求购名称不能为空'
                    }
                }
            },
            category: {
                validators: {
                    notEmpty: {
                        message: '类别不能为空'
                    }
                }
            },
            amount: {
                validators: {
                    notEmpty: {
                        message: '数量不能为空'
                    }
                }
            },
            productName: {
                validators: {
                    notEmpty: {
                        message: '品种不能为空'
                    }
                }
            },
            productBuy: {
                validators: {
                    notEmpty: {
                        message: '产品名不能为空'
                    }
                }
            },
            specification: {
                validators: {
                    notEmpty: {
                        message: '规格不能为空'
                    }
                }
            },
            province: {
                validators: {
                    notEmpty: {
                        message: '地区不能为空'
                    }
                }
            },
            material: {
                validators: {
                    notEmpty: {
                        message: '材质不能为空'
                    }
                }
            },
            companyName: {
                validators: {
                    notEmpty: {
                        message: '公司名不能为空'
                    }
                }
            },
            contract: {
                validators: {
                    notEmpty: {
                        message: '联系人不能为空'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '电话不能为空'
                    }
                }
            },

        },

    });



    //确认发布求购单按钮
    $("#demandForm").submit(function(ev){ev.preventDefault();});
    $("#createBtn").on('click', function(e) {
        var bootstrapValidator = $("#demandForm").data('bootstrapValidator');
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            submitdata();
        }else{
            return;
        }

});
    
    function submitdata() {
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

        if (typeof demandId != undefined && demandId != null) {
            //修改找货单
            $.ajax({
                url: '/yun/tyundemand/updateRelease?id='+demandId,
                type: 'POST',
                data: data,
                processData: false,
                contentType: false,
            }) .done(function(data) {
                if (data.code == '0') {
                    //发布成功
                    alert(data.msg);
                    window.location.href = "/yuncai/demand/index"
                } else {
                    alert(data.msg);
                }
            })
                .fail(function() {
                    console.log("error");
                });

        }else{
            //添加找货单
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
                        window.location.href = "/yuncai/demand/index"
                    } else {
                        alert(data.msg);
                    }
                })
                .fail(function() {
                    console.log("error");
                });
        }
    }


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
    getCitysData(function() {
        $('#demandForm').citys({
            required:false,
            nodata:'disabled',
            data:citysData
        })
    });




    //获取数据列表
    getMyDemandList();
    page = 1;
    function getMyDemandList() {
        var url = "/yun/tyundemand/listmy?page="+page;
        $.ajax({
            url: url,
            type: 'POST',
            data: {},
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
                if( data.page.list.length>0){
                    sessionStorage.setItem("list",JSON.stringify(data.page.list));
                    var str="";
                    for(var i=0;i<data.page.list.length;i++){
                        var button='<a tid="examine" href="/yuncai/demand/view?demandId='+data.page.list[i].id+'" class="btn btn-default">查看</a><a tid="edit" class="btn btn-default" href="/yuncai/demand/edit?demandId='+data.page.list[i].id+'">修改</a><a tid="del" mid = "'+data.page.list[i].id+'" class="btn btn-default">删除</a>'
                        str+='<tr><td>'+isNull(data.page.list[i].name)+'</td>' +
                            '<td>'+isNull(data.page.list[i].createTime)+'</td><td>'+editAmount(data.page.list[i].replyCount)+'</td><td>'+button+'</td></tr>'
                    }
                $("#tMain").empty().html(str);
                $("#pageBar").empty().pageBar({
                    'totalpags': data.page.totalPage,
                    'number': data.page.currPage
                });
            }
        })
        .error(function() {
            alert('error');
        })
    }

    function isNull (val) {
        return val === null ? '' : val;
    }
    function editAmount(val) {
        return val == 0 || val == null ? '尚未报价':val+'次报价';
    }
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


    getOne();
    function getOne() {
        if (typeof demandId != undefined && demandId != null ) {
            var list = JSON.parse(sessionStorage.getItem("list"));
            for(var i in list){
                if(list[i].id == demandId){
                    var thislist = list[i]
                }
            }
            for(var i in thislist){
                $('[name='+i+']').val(thislist[i])
                if(i == 'category'){
                    $("#category").select2({
                        data: JSON.parse(sessionStorage.getItem('categoryList')),
                        placeholder:'请选择',
                        allowClear: true
                    }).val(thislist[i]).trigger("change");
                }
                if(i == 'district'){
                    $(".province").val(thislist[i].substr(0,2)+"0000").change();
                    $(".city").val(thislist[i].substr(0,4)+"00").change();
                    $(".area").val(thislist[i]);
                }
            }

        }


    }




    $(document).on('click','[tid=del]',function(){
        var id = $(this).attr('mid');
        tishiModal('提示框','确认删除该找货单吗?',"confirm('"+id+"')")
    })




});


function confirm(id){
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
            window.location.reload();
        }
    })
        .fail(function() {
            console.log("error");
        });
}












