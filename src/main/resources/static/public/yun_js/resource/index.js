
//
// getResourceList();
// var tab = $("#tab").attr("tab");
// var page = 1;
//  var citysData={};
// // var resourceCollections = [];
// // // $('#category').categorySelect();
// getCitysData(function() {
//     $('#resourceSearch').citys({
//         required:false,
//         nodata:'disabled',
//         data:citysData
//     });
// });
//
//
// //搜索
// $("#btnSearch").click(function() {
//     page = 1;
//     getResourceList();
// });
//
//
// //收藏按钮
// $(document).on('click', '.collectionBtn', function(e) {
//     var id = $(this).parents("td").attr("sid");
//     var url = "www/resource/collection?resourceId=" + id;
//     var $btn = $(this);
//     $.post(url, {}, function(data) {
//         console.log(data);
//         if (data.status == 0) {
//             alert(data.msg);
//             if ($.isEmptyObject(data.content)) {
//                 for (var i = 0; i < resourceCollections.length; i++) {
//                     if(resourceCollections[i] == id) {
//                         resourceCollections.splice(i, 1);
//                     }
//                 }
//                 if (tab == 1) {
//                     $btn.text('收藏');
//                 } else {
//                     $btn.parents("tr").remove();
//                 }
//             } else {
//                 if (tab == 1) {
//                     resourceCollections.push(data.content.resource.id);
//                     $btn.text('取消');
//                 } else {
//                     location.reload();
//                 }
//             }
//         } else {
//             alert(data.msg);
//         }
//     });
// });
//
//
// //删除按钮
// $("#deleteConfirm").on('show.bs.modal', function(e) {
//     $(this).find(".deleteBtn").attr('href', $(e.relatedTarget).data('href'));
// });
// $(".deleteBtn").on('click', function(e) {
//     $("#deleteConfirm").modal('hide');
//     var url = $(this).attr('href');
//     console.log(url);
//     $.post(url, {}, function(data) {
//         console.log(data);
//         if (data.status == 0) {
//             //删除成功
//             alert(data.msg);
//             window.location.reload();
//         } else {
//             alert(data.msg);
//         }
//     });
// });
//
//

//
//
// //获取列表数据
// page = 1;
//
// function getResourceList(result) {
//     // var data = new FormData($("#resourceSearch")[0]);
//     // data.append('region', '');
//     // if (data.get('province') != '' && data.get('province') != undefined && data.get('province') != null) {
//     //     data.set('region', data.get('province').substr(0, 2));
//     //     data.delete('province');
//     // }
//     // if (data.get('city') != '' && data.get('city') != undefined && data.get('city') != null) {
//     //     data.set('region', data.get('city').substr(0, 4));
//     //     data.delete('city');
//     // }
//     // if (data.get('district') != '' && data.get('district') != undefined && data.get('district') != null) {
//     //     data.set('region', data.get('district'));
//     //     data.delete('district');
//     // }
//     // if (tab == 3) {
//     //     var url = "www/resource/findCollection?rows=&page=" + page;
//     // } else if (tab == 2) {
//     //     var url = "www/resource/findMy?rows=&page=" + page;
//     // } else {
//     //     getMyCollection();
//     //     var url = "www/resource/findAll?rows=&page=" + page;
//     // }
//     $.ajax({
//         url: url+"/yun/resource/list",
//         type: 'POST',
//         data: {
//
//         },
//         beforeSend: function(){
//             $('.loading').show();
//         },
//         complete: function(){
//             $('.loading').hide();
//         },
//     })
//         .done(function(data) {
//
//             $(result).addClass("active").siblings().removeClass("active");
//             // console.dir(data);
//             // var reso;
//             // if (data.status == 0) {
//             //     if (tab == 1) {
//             //         for (var i = 0; i < data.content.content.length; i++) {
//             //            for (var j = 0; j < resourceCollections.length; j++) {
//             //                 if (resourceCollections[j] == data.content.content[i].id) {
//             //                     data.content.content[i].isCollection = 1;
//             //                     j = resourceCollections.length - 1;
//             //                 } else {
//             //                     data.content.content[i].isCollection = 0;
//             //                 }
//             //             }
//             //         }
//             //     }
//             //
//             //      var tMainHtml = template('tMainTpl', data.page);
//             //      console.dir(tMainHtml);
//             //       $("#tMain").empty().html(tMainHtml);
//             //     $("#pageBar").empty().pageBar({
//             //         'totalpags': data.content.totalPages,
//             //         'number': data.content.number
//             //     });
//             // }
//             if( data.page.list.length>0){
//                 var str="";
//                 var button=""
//                 for(var i=0;i<data.page.list.length;i++){
//                     if(data.page.list[i].isCollection == "0"){
//                         button = "<button id='createSave' data-id='"+data.page.list[i].id+"'>收藏</button>";
//                     }else if(data.page.list[i].isCollection == "1"){
//
//                         button = "<button data-id='"+data.page.list[i].id+"'>取消</button>";
//                     }
//                     str+='<tr><td>'+data.page.list[i].companyHead+'</td><td>'+data.page.list[i].providername+'</td>' +
//                         '<td>'+data.page.list[i].category+'</td><td>'+data.page.list[i].districtname+'</td>' +
//                         '<td>'+data.page.list[i].name+'</td><td>'+data.page.list[i].description +'</td>' +
//                         '<td>'+data.page.list[i].downloadtimes+'</td><td>'+data.page.list[i].uploadTime+'</td><td>'+data.page.list[i].scale+'</td><td>'+button+'<a href="'+data.page.list[i].url+'">下载</a></td></tr>'
//                 }
//
//                 $("#tMain").empty().html(str);
//             }
//
//
//
//         })
//         .error(function(data) {
//             alert(data.msg);
//         })
// }getResourceList();
//
//地区数据
// function getCitysData(ck){
//     if($.isEmptyObject(citysData)){
//
//         var citys = sessionStorage.citys;
//         if(typeof citys == 'undefined' || citys == null || citys == "{}"){
//             $.getJSON('/yun/region/list', function(datas){
//                 for(var x in datas.list){
//                     citysData[datas.list[x].code]=datas.list[x].name;
//                 }
//                 sessionStorage.setItem('citys', JSON.stringify(citysData))
//                 ck();
//             });
//         } else{
//             citysData=JSON.parse(citys);
//             ck();
//         }
//     }else{
//         ck();
//     }
// }
//
//
// //获取我收藏的
// function getMyCollection() {
//
//     return false;
//     var url = 'www/resource/listMyCollection';
//     $.ajax({
//         url: url,
//         type: 'POST',
//         data: {},
//         async: false,
//         processData: false,
//         contentType: false,
//     })
//         .done(function(data) {
//             resourceCollections = $.map(data.content, function(item, index) {
//                 return item.resource.id;
//             });
//         })
//         .fail(function() {
//             console.log("error");
//         });
// }
//
//
//
//



//6.22 danielzjc

//地区数据
var citysData={};
var page =1;
getCitysData(function() {
    $('#resourceSearch').citys({
        required:false,
        nodata:'disabled',
        data:citysData
    });
});
function getCitysData(ck){
    if($.isEmptyObject(citysData)){

        var citys = sessionStorage.citys;
        if(typeof citys == 'undefined' || citys == null || citys == "{}"){
            $.getJSON('/yun/region/list', function(datas){
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
    getResourceList();
});
//全部列表
function getResourceList(result) {
    console.dir($("#resourceSearch").serialize());
    $.ajax({
        url: url+"/yun/resource/list?page="+page,
        type: 'POST',
        data:$("#resourceSearch").serialize(),
        beforeSend: function(){
            $('.loading').show();
        },
        complete: function(){
            $('.loading').hide();
        },
    })
        .done(function(data) {
            console.dir(data);
            $(result).addClass("active").siblings().removeClass("active");
            if(data.code == "500"){
                alert("data.msg");
                return false;
            }
            if( data.page.list.length>0){
                var str="";
                var button=""
                for(var i=0;i<data.page.list.length;i++){
                    if(data.page.list[i].isCollection == "0"){
                        button = "<button id='createSave' data-id='"+data.page.list[i].id+"'>收藏</button>";
                    }else if(data.page.list[i].isCollection == "1"){

                        button = "<button id='deCollection' data-id='"+data.page.list[i].id+"'>取消</button>";
                    }
                    str+='<tr><td>'+data.page.list[i].companyHead+'</td><td>'+data.page.list[i].providername+'</td>' +
                        '<td>'+data.page.list[i].category+'</td><td>'+data.page.list[i].productnames+'</td>' +
                        '<td>'+data.page.list[i].name+'</td><td>'+data.page.list[i].description +'</td>' +
                        '<td>'+data.page.list[i].downloadtimes+'</td><td>'+data.page.list[i].uploadTime+'</td><td>'+data.page.list[i].scale+'</td><td>'+button+'<a href="'+data.page.list[i].url+'">下载</a></td></tr>'
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
        .error(function(data) {
            alert(data.msg);
        })
}getResourceList();



//获取我发布的
function get_myre(result){
    $("#tMain").empty();
    $.ajax({
        url: url+"/yun/resource/listmy",
        type: 'POST',
        data:$("#resourceSearch").serialize(),
        // // async: false,
        // processData: false,
        // contentType: false,
    }).done(function(data) {

        $(result).addClass("active").siblings().removeClass("active");
        // console.dir(data);
        if(data.code == "500"){
            alert("data.msg");
            return false;
        }
        if( data.page.list.length>0){
            var str="";
            var button=""
            for(var i=0;i<data.page.list.length;i++){
                str+='<tr><td>'+data.page.list[i].companyHead+'</td><td>'+data.page.list[i].providername+'</td>' +
                    '<td>'+data.page.list[i].category+'</td><td>'+data.page.list[i].productnames+'</td>' +
                    '<td>'+data.page.list[i].name+'</td>    <td>'+data.page.list[i].description +'</td>' +
                    '<td>'+data.page.list[i].downloadtimes+'</td><td>'+data.page.list[i].uploadTime+'</td><td>'+data.page.list[i].scale+'</td><td><butcton id="change_action" data-id="'+data.page.list[i].id+'" >修改</butcton><button id="delete_action" data-id="'+data.page.list[i].id+'" >删除</button></td></tr>'
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

//获取 我关注的
function list(result){
    $("#tMain").empty();
    $.ajax({
        url: url+"/yun/resourcecollection/list",
        type: 'POST',
        data:$("#resourceSearch").serialize(),
        // async: false,
        // processData: false,
        // contentType: false,
    }).done(function(data) {
        $(result).addClass("active").siblings().removeClass("active");
        // console.dir(data);
        if(data.code == "500"){
            alert("data.msg");
            return false;
        }
        if( data.page.list.length>0){
            var str="";
            var button=""
            for(var i=0;i<data.page.list.length;i++){
                str+='<tr><td>'+data.page.list[i].companyHead+'</td><td>'+data.page.list[i].providername+'</td>' +
                    '<td>'+data.page.list[i].category+'</td><td>'+data.page.list[i].productnames+'</td>' +
                    '<td>'+data.page.list[i].name+'</td><td>'+data.page.list[i].description +'</td>' +
                    '<td>'+data.page.list[i].downloadtimes+'</td><td>'+data.page.list[i].uploadTime+'</td><td>'+data.page.list[i].scale+'</td><td><button id="deCollection"  data-id="'+data.page.list[i].id+'" data-code="my">取消</button><a href="'+data.page.list[i].url+'">下载</a></td></tr>'
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


//收藏

$("#createSave").live("click",function(){

    $.ajax({
        url: url+"/yun/resourcecollection/save",
        type: 'POST',
        data: {
            resourceId : this.dataset.id
        },
        // async: false,
        // processData: false,
        // contentType: false,
    }).done(function(data) {
    console.dir(data);

        if(data.code == "0"){
            getResourceList();
        }else if(data.code == "500" && data.msg == "用户未登入"){
            // historyUrl=window.location;

            $.cookie('historyUrl', window.location,{expires : 1,path : ' / '}); //设置cookie的值

            location = "/yuncai/login";
        }

    }).fail(function() {
            console.log("error");
    });
});
//取消收藏
$("#deCollection").live("click",function () {

    var code = this.dataset.code;
    $.ajax({
        url: url+"/yun/resourcecollection/decollection",
    type: 'POST',
    data: {
    resourceId : this.dataset.id
},
// async: false,
// processData: false,
// contentType: false,
}).done(function(data) {
    if(data.code == "0"){
        if(code == "my"){
            list();
        }else{
            getResourceList();
            }
        }else{
            alert("error");
        }

    }).fail(function() {
        console.log("error");
    });
});
//我发布的 修改
$("#change_action").live("click",function () {

    window.location.href = '/yuncai/resource/create?';

    $.cookie('data', this.dataset.id,{expires : 1,path : ' / '}); //设置cookie的值
});
//我发布的 删除

function delete_for(id){
    $.ajax({
        url: url+"/yun/resource/delete",
        type: 'POST',
        data: {
            id :id
        }
    }).done(function(data) {
        if(data.code == "0"){

            get_myre();
        }else{
            alert("error");
        }

    }).fail(function() {
        console.log("error");
    });
    $(".myModal").remove();
}
$("#delete_action").live("click",function () {
    // tishiModal("提示","确定删除？","delete_for(\""+this.dataset.id)+"\")");
    $.ajax({
        url: url+"/yun/resource/delete",
        type: 'POST',
        data: {
            id :this.dataset.id
        }
    }).done(function(data) {
        if(data.code == "0"){

            get_myre();
        }else{
            alert("error");
        }

    }).fail(function() {
        console.log("error");
    });
});

//未登录 点击发布
$("#loginForC").live("click",function(){

    $.cookie('historyUrl', "/yuncai/resource/create",{expires : 1,path : ' / '}); //设置cookie的值

    location = "/yuncai/login";
});
//搜索
$("#btnSearch").click(function(){

    var tab = $("#tab .active")[0].innerHTML;

    if(tab == "全部"){
        getResourceList();
    }else if(tab =="我发布的"){
        get_myre();
    }else if(tab =="我收藏的"){
        list();
    }
});

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



            $("#categorySelsect").select2({
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

