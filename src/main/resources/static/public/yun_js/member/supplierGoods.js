/**
 * Created by zhangyu on 2017/7/11.
 */
$(function () {
    $.get('/yun/providermanage/myMerchandise').success(function (data) {
        console.log(data)
        if(data.code == 500 && data.msg == "请先登入"){
            alert(data.msg);
            window.location.href="/yuncai/login"
        }
        if(data.code == 0){
            var insalelist = data.insalelist.list.length,
                notinsalelist = data.notinsalelist.list.length;
            //出售中的商品
            if(insalelist>0){
                $('#tabs').find('li:eq(0) a').textadd(' ( '+insalelist+' )');
                var str = '';
                var button = '<a href="#" class="btn btn-default">修改</a><a href="#" class="btn btn-default">下架</a>' +
                    '<a href="#" class="btn btn-default">删除</a>';
                var str = dataStructure(data.insalelist,button,insalelist);
                $('#panel-1').find('tbody').html(str)
            }else{
                $('#tabs').find('li:eq(0) a').textadd(' ( 0 )')
            }
            //仓库中的商品
            if(notinsalelist>0){
                $('#tabs').find('li:eq(1) a').textadd(' ( '+notinsalelist+' )');
                var str = '';
                var button = '<a href="#" class="btn btn-default">修改</a><a href="#" class="btn btn-default">上架</a>' +
                    '<a href="#" class="btn btn-default">删除</a>';
                var str = dataStructure(data.notinsalelist,button,notinsalelist);
                $('#panel-2').find('tbody').html(str)
            }else{
                $('#tabs').find('li:eq(1) a').textadd(' ( 0 )')
            }

            $("[data-toggle='tooltip']").tooltip();
        }
    }).fail(function () {
        console.log('error occured')
    })
    
    function  dataStructure(data,button,length) {
        var str = '';
        for(var i=0;i<length;i++){
            str += '<tr><td data-toggle="tooltip" data-placement="bottom" title="'+data.list[i].name+'">'
                +data.list[i].name+'</td>' +
                '<td><p class="yuan">￥'+data.list[i].price+'</p></td>' +
                '<td>'+data.list[i].unit+'</td>' +
                '<td>'+data.list[i].salenum+'</td>' +
                '<td>'+data.list[i].createTime+'</td>' +
                '<td>'+button+'</td></tr>'
        }
        return str;
    }
    
    $.fn.extend({
        textadd:function (val) {
            var bar = $(this).text();
            $(this).text(bar+val);
        }
    })
})