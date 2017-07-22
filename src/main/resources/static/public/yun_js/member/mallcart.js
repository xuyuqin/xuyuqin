$(function() {

    function useTpl() {
        $.ajax({
            type: 'GET',
            url: app.approot+"www/member/selectCart",
            data: {},
            beforeSend: function(){
                $('.loading').show();
            },
            complete: function(){
                $('.loading').hide();
            },
            success:function(data) {
                if(data.status == 0) {
                  console.log(data.length);
                  if(data.length >1){
                    var html = template('tMainTpl', data);
                    $('#tMain').html(html);
                  }

                }
            }
        });
    }

    useTpl();


    $(document).on('click', '.del', function(e) {
        var id = $(this).attr('mallcartId');
        var url = app.approot+"www/member/deleteCart";
        $.ajax({
            type: 'GET',
            url: url,
            data: {'cartId':id},
            success:function(data) {
                console.log(data.content);
                if(data.status == 0) {
                    page=1;
                    useTpl();
                }
            }
        });
        return false;
    });

    //计算以选择商品数量、价格
    function statistics(){
        var _trs=$('table').find('.checkboxThree:checked').parents('tr');
        var pCount=0;
        _trs.find('.price').each(function(){
            pCount+=parseFloat($(this).html());
        });
        $('.cartCount').html(_trs.size());
        $('.priceCount').html(pCount);
    }

    //全选单选
    $(document).on('click','.checkboxOne',function(e){
        var _table=$(this).parents('table');
        var _trs=_table.find('tbody>tr');
        if($(this).prop('checked')){
            _trs.each(function(){
                $(this).find('input[type=checkbox]').prop('checked',true);
            });
        }else{
            _trs.each(function(){
                $(this).find('input[type=checkbox]').prop('checked',false);
            });
        }
        statistics();
    });
    $(document).on('click','.checkboxTwo',function(e){
        var _tr=$(this).parents('tr');
        var group=_tr.attr('data-group');
        var _trs=_tr.siblings('tr[data-group='+group+']');
        if($(this).prop('checked')){
            _trs.each(function(){
                $(this).find('.checkboxThree').prop('checked',true);
            });
        }else{
            _trs.each(function(){
                $(this).find('.checkboxThree').prop('checked',false);
            });
        }
        statistics();
    });
    $(document).on('click','.checkboxThree',function(e){
        var _tr=$(this).parents('tr');
        var group=_tr.attr('data-group');
        if($(this).prop('checked')){

        }else{
            _tr.siblings('tr[data-group='+group+']').eq(0).find('.checkboxTwo').prop('checked',false);
            _tr.parents('table').find('.checkboxOne').prop('checked',false);
        }
        statistics();
    });

    //改变数量触发
    $(document).on('change','input[type=number]',function(){
        var _value = $(this).val().trim();
        var _carId = $(this).parents('tr').attr('mallcartId');
        var _price = $(this).parents('tr').children('td:nth-child(5)').text().trim();
        var _allPrice = $(this).parents('tr').children('td:nth-child(8)');
        _allPrice.text(parseFloat((parseFloat(_value)*parseFloat(_price)).toFixed(2)));
        $.post(app.approot+"www/member/updateCart",{cartId:_carId,amount:_value},function(result){
            console.log(result);
        });
    });

    //结算跳转
    $(document).on('click','.orderBuy',function(){
    	var checkedCartList=[];
    	$('tbody tr').each(function(index){
    		if($(this).find('input[type=checkbox]').is(':checked') && $(this).attr('mallcartid')){
    			var arr = {
    					name : index,
    					value : $(this).attr('mallcartid')
    			};
    			checkedCartList.push(arr);
    		}
		});
    	if(checkedCartList.length > 0){
    		window.location.href = app.approot+'www/member/orderBuy?'+$.param(checkedCartList);
    	}else{
    		alert('请至少选择商品');
    	}
    });

});
