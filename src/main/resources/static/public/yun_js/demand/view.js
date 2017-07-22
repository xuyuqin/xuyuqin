//找货单查看
$(function () {
    var demandId = getQueryString('demandId');
    var list = JSON.parse(sessionStorage.getItem("list"));
    //TODO 如果session\消失
    for(var i in list){
        if(list[i].id == demandId){
            var thislist = list[i]
        }
    }
    var lookfor = '<tbody><tr><td style="min-width:160px;max-width:199px">采购产品：'+isNull(thislist.productBuy)+'</td><td style="min-width:160px;max-width:199px">有效期：'+editValidity(thislist.validity)+'</td><td style="min-width:160px;max-width:199px">地区：'+editDistrict(thislist.district)+'</td> </tr>    <tr>    <td>数量：'+isNull(thislist.amount)+'</td>    <td>规格：'+isNull(thislist.specification)+'</td>    <td>材质：'+isNull(thislist.material)+'</td>    </tr>    <tr><td>类别：'+editCategory(thislist.category)+'</td>    <td>品种：'+isNull(thislist.productName)+'</td>    <td>发布时间:'+isNull(thislist.createTime)+'</td>    </tr><tr><td colspan="3">备注:'+isNull(thislist.remarks)+'</td></tr></tbody>'
    $('#replyForm .lookfor').html(lookfor)
    var info = '<tbody><tr> <td>公司名：'+isNull(thislist.companyName)+'</td>    </tr>    <tr>    <td>联系人：'+isNull(thislist.contract)+'</td>    </tr>    <tr>    <td>手机号：'+isNull(thislist.phone)+'</td>    </tr>    </tbody>';
    $('#replyForm .info').html(info)

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
    function editDistrict(val) {
        if(val == '' || val == null) {
            return '';
        }else{
            var arr = JSON.parse(sessionStorage.getItem('citys'));
            return arr[val];
        }
    }
    var page = 1;

    demandlist(page);
    function demandlist(page){
        $("#tMain").empty();
        $.ajax({
            url: '/yun/tyundemandreply/list?page='+page+'&demandId='+demandId,
            type: 'POST',
            data: {},
            processData: false,
            contentType: false,
        }).done(function(data) {
            console.log(data)
            if( data.page.list.length>0){
                var str="";
                for(var i=0;i<data.page.list.length;i++){
                    str+= '<tr><td>'+data.page.list[i].price+'</td><td>'+data.page.list[i].contract+'</td><td>'+data.page.list[i].phone+'</td><td>'+data.page.list[i].remarks+'</td></tr>';
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
        demandlist(page);
    });




})