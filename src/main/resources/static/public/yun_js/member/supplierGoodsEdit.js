/**
 * Created by zhangyu on 2017/7/11.
 */
$(function () {
    $(document).on('click','#GoodsForm img',function () {
        if($(this).siblings('div.mark').hasClass('s')){
            return false;
        }
        $(this).siblings('input').click();
    })
    $(document).on('change','input[type=file]',function () {
        var id = $(this).attr('id');
        if(!checkSize(''+id+'')){
            alert('图片尺寸过大');
            clear(''+id+'');
            return false;
        }
        $(this).siblings('img').attr('src',getFileUrl(''+id+''))
            .siblings('div.mark').removeClass('h').addClass('s');
    });
    $(document).on('click','#GoodsForm .remove',function () {
        console.log('remove');
        $(this).closest('div.col-sm-2').find('img').attr('src','')
            .siblings('div.mark').removeClass('s').addClass('h')
        var id = $(this).closest('div.col-sm-2').find('input[type=file]').attr('id')
        clear(''+id+'');
    })

    //文本框创建
    var E = window.wangEditor
    var editor = new E('#editor');
    editor.create();

    $('#sub').click(function () {
        // TODO ajax提交
    })



    function getFileUrl(sourceId) {
        var url;
        if (navigator.userAgent.indexOf("MSIE")>=1) { // IE
            url = document.getElementById(sourceId).value;
        } else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        } else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome
            url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0));
        }
        return url;
    }

    function clear(File) {
        var file=document.getElementById(File);
        //IE，Safari，chrome
        if(file.outerHTML){
            file.outerHTML=file.outerHTML;
        }
        else{      //FF
            file.value="";
        }
    }
    
    function checkSize(id) {
        var file=document.getElementById(id);
        return file.files[0].size < 1024*1024 ? true : false;
    }

})