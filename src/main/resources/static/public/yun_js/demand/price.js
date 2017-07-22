//我要报价
$(function () {
    var demandId = getQueryString('demandId');
    var submitType = getQueryString('type');//1提交报价  2 再次报价
    var list = JSON.parse(sessionStorage.getItem("list"));
    for(var i in list){
        if(list[i].id == demandId){
            var thislist = list[i]
        }
    }
    var lookfor = '<tbody><tr><td style="min-width:160px;max-width:199px">采购产品：'+isNull(thislist.productBuy)+'</td><td style="min-width:160px;max-width:199px">有效期：'+editValidity(thislist.validity)+'</td><td style="min-width:160px;max-width:199px">地区：'+editDistrict(thislist.district)+'</td> </tr>    <tr>    <td>数量：'+thislist.amount+'</td>    <td>规格：'+thislist.specification+'</td>    <td>材质：'+isNull(thislist.material)+'</td>    </tr>    <tr><td>类别：'+editCategory(thislist.category)+'</td>    <td>品种：'+thislist.productName+'</td>    <td>发布时间:'+isNull(thislist.createTime)+'</td>    </tr><tr><td colspan="3">备注'+thislist.remarks+'</td></tr></tbody>'
    $('#replyForm .lookfor').html(lookfor)
    var info = '<tbody><tr> <td>公司名：'+isNull(thislist.companyName)+'</td>    </tr>    <tr>    <td>联系人：'+isNull(thislist.contract)+'</td>    </tr>    <tr>    <td>手机号：'+isNull(thislist.phone)+'</td>    </tr>    </tbody>';
    $('#replyForm .info').html(info)
    function editDistrict(val) {
        if(val == '' || val == null) {
            return '';
        }else{
            var arr = JSON.parse(sessionStorage.getItem('citys'));
            return arr[val];
        }

    }
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

    function isNull (val) {
        return val === null ? '' : val;
    }


    $('#replyForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            price: {
                message: '名称验证失败',
                validators: {
                    notEmpty: {
                        message: '价格不能为空'
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
    $("#replyForm").submit(function(ev){ev.preventDefault();});
    $("#createBtn").on('click', function(e) {
        var bootstrapValidator = $("#replyForm").data('bootstrapValidator');
        bootstrapValidator.validate();
        if(bootstrapValidator.isValid()){
            submitdata();
        }else{
            return;
        }

    });
    
    function submitdata() {
        var data = $('#replyForm').serialize();
        $.ajax({
            url: '/yun/tyundemandreply/offer?demandId='+demandId+'&'+data,
            type: 'POST',
            data: {},
            processData: false,
            contentType: false,
        }).done(function(data) {
            console.log(data)
            if(data.code == 500 && data.msg == '请先登录！'){
                window.location.href = '/yuncai/login';
            }
            if(data.code == 0){
                alert(data.msg);
                window.location.href = '/yuncai/demand/index'
            }
        })
            .fail(function() {
                console.log("error");
            });
    }









    // $('#createBtn').click(function () {
        // var data = new FormData($('#replyForm')[0]);
        // data.append('demandId',demandId)
        // var data = $('#replyForm').serialize()
        //默认已经是供应商
        // if(submitType == 1){
            //提交报价
             //没有修改报价
            // $.ajax({
            //     url: '/yun/tyundemandreply/offer?demandId='+demandId+'&'+data,
            //     type: 'POST',
            //     data: {},
            //     processData: false,
            //     contentType: false,
            // }).done(function(data) {
            //     console.log(data)
            //     if(data.code == 500 && data.msg == '请先登录！'){
            //         window.location.href = '/yuncai/login';
            //     }
            //     if(data.code == 0){
            //         alert(data.msg);
            //         window.location.href = '/yuncai/demand/index'
            //     }
            // })
            //     .fail(function() {
            //         console.log("error");
            //     });
        // }else if(submitType == 2){
        //     //更新报价
        //     $.ajax({
        //         url: '/yun/tyundemandreply/updateOffer?demandId='+demandId+'&'+data,
        //         type: 'POST',
        //         data: data,
        //         processData: false,
        //         contentType: false,
        //     }).done(function(data) {
        //         if(data.code == 500 && data.msg == '请先登录！'){
        //             window.location.href = '/yuncai/login';
        //         }
        //         if(data.code == 0){
        //             alert(data.msg);
        //             window.location.href = '/yuncai/demand/index'
        //         }
        //     })
        //         .fail(function() {
        //             console.log("error");
        //         });
        // }
    // })

    // check();
    // function check() {
    //     if(submitType == 2){
    //         console.log('再次填写');
    //     }
    // }



});