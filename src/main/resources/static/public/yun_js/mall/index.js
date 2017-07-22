// $(function() {
//     var citysData={};
//     getCitysData(function(){
//         $('#mallForm').citys({
//             required:false,
//             nodata:'disabled',
//             data:citysData
//         });
//     });
//
//
//     //搜索按钮
//     $("#btnSearch").click(function(e) {
//         var url = __appconfig.approot + 'www/merchandise/list?' + $("#mallForm").serialize();
//         console.log(url);
//         document.location = url;
//     });
//
//     //获取某一大类的8个商品
//     function getList(cate) {
//     	if (cate == '' || cate == undefined) {
//     		return false;
//     	}
//         var url = __appconfig.approot + 'www/merchandise/search?rows=8&cate=' + cate;
//         $.post(url, function(data) {
//         	console.log(data);
//         	if (data.status == 0) {
//         		//获取成功
//         		var blockHtml = template('blockTpl', data.content);
//         		$("#" + cate).append(blockHtml);
//         	} else {
//         		alert(data.msg);
//         	}
//         });
//     }
//     $("#cate optgroup").each(function(index, el) {
//     	var code = $(this).attr('code');
//     	if(code != '') {
//     		getList(code);
//     	}
//     });
//
//
//     //城市三级联动
//     function getCitysData(ck){
//         if($.isEmptyObject(citysData)){
//             var citys = sessionStorage.citys;
//             if(typeof citys == 'undefined' || citys == null){
//                 $.getJSON(__appconfig.approot + 'www/region/all', function(datas){
//                     for(var x in datas.content){
//                         citysData[datas.content[x].code]=datas.content[x].name;
//                     }
//                     sessionStorage.setItem('citys', JSON.stringify(citysData))
//                     ck();
//                 });
//             } else{
//                 citysData=JSON.parse(citys);
//                 ck();
//             }
//         }else{
//             ck();
//         }
//     }
//
// });
$.ajax({
    url: '/yun/category/list?type=0',
    type: 'get',
    success: function (msg) {
        console.log(msg);
        if (msg.code == 0) {
            var list = msg.list;
            $('.mallTitle').each(function (index) {
                $(this).text(list[index].name).parents('.mallListTopBar').attr('id', list[index].id);
            });
            $('.mallListUl').each(function (index) {
                var type = $(this).parents('.mallListTopBar').attr('id');
                var that = $(this);
                $.ajax({
                    url: '/yun/category/list',
                    type: 'get',
                    data: {
                        type: type
                    },
                    async: false,
                    success: function (msg) {
                        that.empty();
                        if (msg.code == 0) {
                            var listT = msg.list;
                            var ht = '<li class="categoryActive" id="' + listT[0].id + '">' + listT[0].name + '</li>';
                            ht += '<li id="' + listT[1].id + '">' + listT[1].name + '</li>';
                            ht += '<li id="' + listT[2].id + '">' + listT[2].name + '</li>';
                            that.append(ht);
                        }
                    }
                })
            });
            getList();
            for (var i = 0; i < list.length; i++) {
                $('.categoryU').append('<li id= "li_' + list[i].id + '">' + list[i].name + '</li>')
            }
        }
    }
});
$.ajax({
    url: '/yun/region/list',
    type: 'get',
    data:{
        level:1
    },
    success: function (msg) {
        if(msg.code==0){
            var list = msg.list;
            console.log(msg);
            for (var i = 0; i < list.length; i++) {
                $('.areaUl').append('<li id= "li_' + list[i].code + '">' + list[i].name + '</li>')
            }
        }
    }
});
$(document).on('click', '.mallListUl li', function () {
    $(this).attr('class', 'categoryActive').siblings().removeClass('categoryActive');
    getList();
});
// 搜索功能
function search() {
    var CategoryId,areaId;
    $(document).on('click', '.categoryChoose li', function () {
        $(this).attr('class', 'active').siblings().removeClass('active');
        CategoryId = $(this).attr('id');
    });
    $(document).on('click', '.areaChoose li', function () {
        $(this).attr('class', 'active').siblings().removeClass('active');
        areaId = $(this).attr('id');
    });

    $('.orangeBtnMall').click(function () {
        console.log(CategoryId,areaId);
        $.cookie('CategoryId',CategoryId);
        $.cookie('areaId',areaId);
        $.cookie('productname',$('input[name=productname]').val());
        $.cookie('detail',$('input[name=detail]').val());
        $.cookie('material',$('input[name=material]').val());
        $.cookie('providername',$('input[name=providername]').val());
        window.location.href='/yuncai/mall/list';
    })
}
search();
//获取列表数据
function getList() {
    var text, parentId, limit;
    $('.categoryActive').each(function (index) {
        if (index == 0) {
            limit = 12;
        } else if (index == 1) {
            limit = 10;
        } else {
            limit = 6;
        }
        parentId = $(this).parents('.mallListTopBar').attr('id');
        text = $(this).text();
        console.log(text, parentId);
        $.ajax({
            url: '/yun/merchandise/list',
            type: 'get',
            data: {
                Category: text,
                parent: parentId,
                limit: limit
            },
            success: function (msg) {

                if (msg.code == 0) {
                    var pList = msg.page.list;
                    if (pList.length > 0) {
                        if (index == 0) {
                            var htmlList;
                            $('#categoryList1').empty();
                            for (var i = 0; i < pList.length; i++) {
                                htmlList = '<div class="col-md-2 mallListOne mallListOne1 nextPage" id="' + pList[i].id + '">'
                                    + '<img src="/public/img/mall1.png" alt="">'
                                    + '<p>' + pList[i].name + '</p>'
                                    + '<p>材质：' + pList[i].material + '</p>'
                                    + '<p class="mallPrice">价格：&yen;' + pList[i].price + '</p>'
                                    + '</div>';
                                $('#categoryList1').append(htmlList);
                            }

                        }
                        else if (index == 1) {
                            var htmlList1;
                            $('#categoryList2').empty();
                            for (var j = 0; j < pList.length; j++) {
                                htmlList1 = '<div class="col-md-2 mallListOne mallListOne1 nextPage" id="' + pList[j].id + '">'
                                    + '<img src="/public/img/mall1.png" alt="">'
                                    + '<p>' + pList[j].name + '</p>'
                                    + '<p>材质：' + pList[j].material + '</p>'
                                    + '<p class="mallPrice">价格：&yen;' + pList[j].price + '</p>'
                                    + '</div>';
                                $('#categoryList2').append(htmlList1);
                            }
                        } else {
                            var htmlList2;
                            $('#categoryList3').empty();
                            for (var y = 0; y < pList.length; y++) {
                                htmlList2 = '<div class="mallListOneD nextPage">'
                                    + '<h4>' + pList[y].name + '</h4>'
                                    + '<div class="clearfix mallListOneDD">'
                                    + '<div class="pull-left"><img src="/public/img/mall2.png" alt=""></div>'
                                    + '<div class="pull-right">'
                                    + '<p>材质：' + pList[y].material + '</p>'
                                    + '<p>规格：' + pList[y].detail + '</p>'
                                    + '<p>重量：' + pList[y].weight + '</p>'
                                    + '<p>件数：' + pList[y].unit + '</p>'
                                    + '<p class="mallPrice">价格：&yen;' + pList[y].price + '</p>'
                                    + '</div>'
                                    + '</div>'
                                    + '</div>';
                                $('#categoryList3').append(htmlList2);
                            }

                        }
                        if (pList.length < (limit / 2)) {
                            $('.mallList').css({
                                'borderBottom': '1px solid #eaeaea'
                            });
                            $('.mallListOne:last-child ').css({
                                'borderRight': '1px solid #eaeaea'
                            });
                        } else if (pList.length > (limit / 2) && pList.length < limit) {
                            $('.mallList').css({
                                'borderBottom': '1px solid #eaeaea'
                            });
                            $('.mallListOne:last-child ').css({
                                'borderRight': '1px solid #eaeaea'
                            });
                        }
                        $('.hoverD>div').each(function () {
                            $(this).hoverDelay(function () {
                                var id = $(this).attr('id');
                                var isIt = $(this);
                                console.log(id);
                                $.ajax({
                                    url: '/yun/merchandise/detail',
                                    type: 'get',
                                    data: {
                                        merchandiseId: id
                                    },
                                    success: function (msg) {
                                        isIt.children('.hoverDiv').remove();
                                        if (id) {
                                            var html = '<div class="hoverDiv">'
                                                + '<p>规格：' + msg.merchandise.detail + '</p>'
                                                + '<p>重量：' + msg.merchandise.weight + '</p>'
                                                + '<p>件数：' + msg.merchandise.unit + '</p>'
                                                + '<p>厂家：' + msg.merchandise.providerName + '</p>'
                                                + '<p class="cangku">仓库：dddddd</p>'
                                                + '<p class="mallPrice">价格：&yen;' + msg.merchandise.price + '</p>'
                                                + '</div>';
                                            isIt.append(html);
                                        }
                                    }
                                });
                            },function () {
                                $(this).children('.hoverDiv').remove();
                            })
                        });
                        // $('.hoverD>div').hover(function () {
                        //     var id = $(this).attr('id');
                        //     var isIt = $(this);
                        //     console.log(id);
                        //     $.ajax({
                        //         url: '/yun/merchandise/detail',
                        //         type: 'get',
                        //         data: {
                        //             merchandiseId: id
                        //         },
                        //         success: function (msg) {
                        //             isIt.children('.hoverDiv').remove();
                        //             if (id) {
                        //                 var html = '<div class="hoverDiv">'
                        //                     + '<p>规格：' + msg.merchandise.detail + '</p>'
                        //                     + '<p>重量：' + msg.merchandise.weight + '</p>'
                        //                     + '<p>件数：' + msg.merchandise.unit + '</p>'
                        //                     + '<p>厂家：' + msg.merchandise.providerName + '</p>'
                        //                     + '<p class="cangku">仓库：dddddd</p>'
                        //                     + '<p class="mallPrice">价格：&yen;' + msg.merchandise.price + '</p>'
                        //                     + '</div>';
                        //                 isIt.append(html);
                        //             }
                        //         }
                        //     });
                        //
                        // }, function () {
                        //     $(this).children('.hoverDiv').remove();
                        // });
                    } else {

                    }
                }
            }
        })
    })
}
$(document).on('click','.nextPage',function () {
    var id = $(this).attr('id');
    window.location.href='/yuncai/mall/detail?merchandiseId='+id;
});
