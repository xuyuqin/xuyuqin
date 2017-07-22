$(function(){
    $('#deliveryForm').bootstrapValidator({
        message: 'this value is not valid',
        feedbackIcons: {  
            valid: 'glyphicon glyphicon-ok',  
            invalid: 'glyphicon glyphicon-remove',  
            validating: 'glyphicon glyphicon-refresh'  
        },
        fields: {
            deliveryCredential: {
                validators: {
                    notEmpty: {
                        message: '请填写提货凭证信息'
                    }
                }
            }
        }
    });
	
    var invoiceStatus = 3;
    $(document).on('change','#invoiceStatus',function(e){
    	if($("#invoiceStatus").is(':checked')){
        	invoiceStatus = 2;
        	$('#invoiceBody').show();
        }else{
        	invoiceStatus = 3;
        	$('#invoiceBody').hide();
        } 
    });
    
    //获取get参数
    function getUrlVars(){
        var vars = [], hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        for(var i = 0; i < hashes.length; i++)
        {
          hash = hashes[i].split('=');
          vars.push(hash[1]);
        }
        return vars;
    }

    //通过get参数 获取商品信息
    var data = {};
    data['orderList'] = getUrlVars();
    $.ajax({
    	type: 'post',
    	url: app.approot+'www/member/selectCartByList',
    	traditional: true,
    	data: data,
    	beforeSend: function(){
    	    $('.loading').show();
    	},
    	complete: function(){
    	    $('.loading').hide();
    	},
    	success: function(data){
            console.log(data);
            var html = template('tMainTpl', data);
            $('#tMain').html(html);
            var cartCount = 0,
            	priceCount = 0;
            for(var i=0; i<data.content.length; i++){
            	for(var j=0; j<data.content[i].length; j++){
            		cartCount++;
            		priceCount += data.content[i][j].price;
            	}
            }
            $('.cartCount').html(cartCount);
            $('.priceCount').html(priceCount);
    	}
    });
    
    //确认下单
    $(document).on('click', '#orderConfirm', function(e){
    	data['invoiceStatus'] = invoiceStatus;
    	$.ajax({
    		type: 'post',
    		url: app.approot+'www/member/newOrder',
    		data: data,
        	beforeSend: function(){
        	    $('#orderConfirm>i').show();
        	    $('#orderConfirm').attr('disabled', true);
        	},
        	complete: function(){
        	    $('#orderConfirm>i').hide();
        	    $('#orderConfirm').attr('disabled', false);
        	},
        	traditional: true,
    		success: function(data){
    			console.log(data);
    			alert('下单成功，跳转到支付页面');
    		}
    	});
    });
    
    //填写提货函-确定
    $(document).on('click', '#writeDelivery', function(){
    	$('#deliveryForm').data('bootstrapValidator').validate();
        if(!$('#deliveryForm').data('bootstrapValidator').isValid()){  
        	data['deliveryMethod'] = '';
        	data['deliveryCredential'] = '';
        	data['deliveryComment'] = '';
        	$('.deliveryInfo').hide();
            return ;  
        }
        data['deliveryMethod'] = $('#deliveryForm input[name="deliveryMethod"]:checked').next().html(),
        data['deliveryCredential'] = $('#deliveryForm input[name="deliveryCredential"]').val(),
    	data['deliveryComment'] = $('#deliveryForm input[name="deliveryComment"]').val();
        $('.deliveryMethod').html(data['deliveryMethod']);
        $('.deliveryCredential').html(data['deliveryCredential']);
        $('.deliveryComment').html(data['deliveryComment']);
        $('.deliveryInfo').show();
        $("#myModal").modal('hide'); 
    });
    
});
