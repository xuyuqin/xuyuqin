/**
 * Created by zhangyu on 2017/7/10.
 */
$(function () {
    //加载信息
    $.get('/yun/providermanage/myinfo').success(function (data) {
        console.log(data)
        if(data.code == 500){
            alert(data.msg)
            if(data.msg == '请先登入'){
                window.location.href = '/yuncai/login'
            }
            if(data.msg == '请先成为供应商'){
                // window.location.href = '/yuncai/login'
                //供应商页面
            }
        }
        if(data.code == 0){
            for(var i in data.tYunProvider){
                if(i == 'logo'){
                    i == null || i == undefined ? $('#supplierForm img').attr('alt','请上传logo') : 1;
                    $('#supplierForm img').attr('src','http://'+data.tYunProvider[i])
                    continue;
                }
                if(i == 'qualityScore' || i == 'serviceScore' || i == 'priceScore'){
                    $('.'+i+'').css('background-image','url("/public/yun_img/star/'+data.tYunProvider[i]+'.png")')
                    continue;
                }
                if(i == 'productIds'){
                    var arr = data.tYunProvider[i].split(',')
                    $("#category").select2({
                        data: JSON.parse(sessionStorage.getItem('categoryList')),
                        placeholder:'请选择',
                        allowClear: true
                    }).val(arr).trigger("change");
                    continue;
                }
                $('[name='+i+']').val(data.tYunProvider[i]);
            }
        }
    }).fail(function (e) {
        console.log('error occured')
    })
    


    //提交
    $('#sub').click(function () {
        var data = new FormData($('#supplierForm')[0]);
        var img = document.getElementById('upload').files[0]
        data.append('logofile',img)
        $.ajax({
            url: '/yun/providermanage/edit',
            type: 'POST',
            data: data,
            processData: false,
            contentType: false,
        })
            .done(function(data) {
                console.log(data)
                if(data.code == 0){
                    alert('修改成功');
                    window.location.reload();
                }
            })
            .fail(function() {
                console.log("error");
            });
    })

    $('#sublogo').click(function () {
        $('#upload').click();
    })
    $('#upload').change(function (e) {
        console.log(e)
        var img = new Image();
        img.onload = function(){

        }
        img.src = getFileUrl('upload');
        $('img').attr('src',img.src);
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


    function cateGory(){
        if(sessionStorage.getItem('categoryList') != '' && sessionStorage.getItem('categoryList') != undefined) {
            $("#category").select2({
                data: JSON.parse(sessionStorage.getItem('categoryList')),
                placeholder:'请选择',
                allowClear: true
            });
        }else{
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
        }

    }cateGory();

})