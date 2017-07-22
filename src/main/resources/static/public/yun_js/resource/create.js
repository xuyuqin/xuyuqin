// function changefile(a){
//     var name = a.value;
//     name=name.split("\\");
//     var s = name.length;
//     name = name[s-1];
//     $(".text").html(name);
// }
// $(function() {
//     //预定义的全局变量
//     var page = 1;

//     var resourceId = getQueryString('resourceId');
//
//     // getOne();
//     getMyResouceList();
//
//
//     //“确定”修改按钮
//     $("#changeConfirm").on('show.bs.modal', function(e) {
//         $(this).find(".changeBtn").attr('sid', $(e.relatedTarget).data('sid'));
//     });
//     $(".changeBtn").on('click', function(e) {
//         $("#changeConfirm").modal('hide');
//         resourceId = $(this).attr('sid');
//         // getOne();
//     });
//
//
//     //“确定”删除按钮
//     $("#deleteConfirm").on('show.bs.modal', function(e) {
//         $(this).find(".deleteBtn").attr('href', $(e.relatedTarget).data('href'));
//     });
//     $(".deleteBtn").on('click', function(e) {
//         $("#deleteConfirm").modal('hide');
//         var url = $(this).attr('href');
//         $.post(url, {}, function(data) {
//             console.log(data);
//             if (data.status == 0) {
//                 //删除成功
//                 alert(data.msg);
//                 window.location.reload();
//             } else {
//                 alert(data.msg);
//             }
//         });
//     });
//
//
//     //点击发布资源单
//     $("#createBtn").on('click', function(e) {
//         var data = new FormData($("#resourceForm")[0]);
//         data.append('district.code', '');
//         if (data.get('province') != '' && data.get('province') != undefined && data.get('province') != null) {
//             data.set('district.code', data.get('province'));
//             data.delete('province');
//         }
//         if (data.get('city') != '' && data.get('city') != undefined && data.get('city') != null) {
//             data.set('district.code', data.get('city'));
//             data.delete('city');
//         }
//         if (data.get('district') != '' && data.get('district') != undefined && data.get('district') != null) {
//             data.set('district.code', data.get('district'));
//             data.delete('district');
//         }
//         var url =  "http://localhost:8080/yun/resource/edit";
//         $.ajax({
//             url: url,
//             type: 'POST',
//             data: data,
//             cache: false,
//             processData: false,
//             contentType: false,
//         })
//             .done(function(data) {
//                 if (data.status == 0) {
//                     //发布成功
//                     alert(data.msg);
//                     window.location.reload();
//                 } else {
//                     alert(data.msg);
//                 }
//             })
//             .fail(function() {
//                 console.log("error");
//             });
//     });
//
//
//     //分页按钮
//     $(document).on('click', '#pageBar li', function(e) {
//         if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
//             return false;
//         }
//         if ($(this).hasClass('prev')) {
//             page--;
//         } else if ($(this).hasClass('next')) {
//             page++;
//         } else {
//             page = $(this).find('a').html();
//         }
//         getMyResouceList();
//     });
//
//
//     //我发布的资源单
//     function getMyResouceList() {
//         var url =  "www/resource/findMy?page=" + page;
//         $.ajax({
//             url: url,
//             type: 'POST',
//             data: {},
//             processData: false,
//             contentType: false,
//             beforeSend: function(){
//                 $('.loading').show();
//             },
//             complete: function(){
//                 $('.loading').hide();
//             },
//         })
//             .done(function(data) {
//                 console.log(data);
//                 if (data.status == 0) {
//                     var tMainHtml = template('tMainTpl', data.content);
//                     $("#tMain").empty().html(tMainHtml);
//                     $("#pageBar").empty().pageBar({
//                         'totalpags': data.content.totalPages,
//                         'number': data.content.number
//                     });
//                 }
//             })
//             .error(function() {
//                 alert('error');
//             })
//     }
//
//
//     //重写form表单
//     function getOnessss() {
//         if (resourceId == '' || resourceId == undefined) {
//             var formHtml = template('formTpl', {});
//             $("#resourceForm").html(formHtml);
//             getCitysData(function(){
//                 $('#resourceForm').citys({
//                     required:false,
//                     nodata:'disabled',
//                     data:citysData
//                 })
//             });
//             $("#category").categorySelect();
//             return false;
//         }
//         var url =  'www/resource/findOne';
//         $.post(url, {resourceId: resourceId}, function(data) {
//             console.log(data);
//             if (data.status == 0) {
//                 //获取成功
//                 var formHtml = template('formTpl', data.content);
//                 $("#resourceForm").empty().html(formHtml);
//                 var cate = data.content.category.id;
//                 var province = data.content.district.code.toString().replace(/(\d{2})\d{4}/, '$10000');
//                 var city = data.content.district.code.toString().replace(/(\d{4})\d{2}/, '$100');
//                 var district = data.content.district.code.toString();
//                 if (province == district) {
//                     city = '';
//                     district = '';
//                 }
//                 if (city == district) {
//                     district = '';
//                 }
//                 $("#category").categorySelect(cate);
//                 getCitysData(function(){
//                     $('#resourceForm').citys({
//                         province:province,
//                         city:city,
//                         district:district,
//                         required:false,
//                         nodata:'disabled',
//                         data:citysData
//                     })
//                 });
//             } else {
//                 alert(data.msg);
//             }
//         });
//     }
//
//

//是否为修改单

window.onload = function(){
    var data = $.cookie('data');
    if(data !== undefined){

        $.removeCookie('data', { path: '/' });
        clearAllCookie();

        $.ajax({
            url: "/yun/resource/info/"+data,
            type: 'POST',
            data:{},
            async: false,
            cache: false,
            contentType: false,
            processData: false
        })
            .done(function(data) {
                console.dir(data);
                if (data.code == 0) {
                    $("#categorySelsect").select2().val(data.tYunResource.categoryId).trigger("change");

                    data = data.tYunResource;
                    for(var p in data){
                        $("[name="+p+"]").val(data[p]);
                    }
                    $(".province").val(data.district.substr(0,2)+"0000").change();
                     $(".city").val(data.district.substr(0,4)+"00").change();
                     $(".area").val(data.district);


                } else {
                    errorModal("提示",data.msg);
                }
            })
            .fail(function() {
                console.log("error");
            });
    }
};
$(function(){
    function cateGory(){
        $.ajax({
            url: url+"/yun/category/list",
            type: 'POST',
            data: {},
            async: false
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


    var citysData = {};
    getCitysData(function(){
        $('#resourceForm').citys({
            required:false,
            nodata:'disabled',
            data:citysData
        })
    });

//城市三级联动
    function getCitysData(ck){
        if($.isEmptyObject(citysData)){
            var citys = sessionStorage.citys;
            if(typeof citys == 'undefined' || citys == null){
                $.getJSON( '/yun/region/list', function(datas){
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

// });



// 6.23  danielzjc

function changefile(a){
    var name = a.value;
    name=name.split("\\");
    var s = name.length;
    name = name[s-1];
    $(".text").html(name);
}
//点击发布资源单
$("#createBtn").on('click', function(e) {
    var data = new FormData($("#resourceForm")[0]);
    // data.append('district.code', '');
    // if (data.get('province') != '' && data.get('province') != undefined && data.get('province') != null) {
    //     data.set('district.code', data.get('province'));
    //     data.delete('province');
    // }
    // if (data.get('city') != '' && data.get('city') != undefined && data.get('city') != null) {
    //     data.set('district.code', data.get('city'));
    //     data.delete('city');
    // }
    // if (data.get('district') != '' && data.get('district') != undefined && data.get('district') != null) {
    //     data.set('district.code', data.get('district'));
    //     data.delete('district');
    // }
    console.dir(data);
    var url =  "/yun/resource/edit";
        $.ajax({
            url: url,
            type: 'POST',
            data:data,
            async: false,
            cache: false,
            contentType: false,
            processData: false,
        })
        .done(function(data) {
            console.dir(data);
            if (data.status == 0) {
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



