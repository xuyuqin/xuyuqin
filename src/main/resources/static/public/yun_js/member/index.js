$(function() {

    getSupplier();
    getCounts();

    //在线支付modal
    $(document).on('click', '.payOnline', function(e) {

        createModal('在线支付', 'member/myOrderPayOnline', 'myOrderPaysave()');
        return false;
    });
    //白条支付modal
    $(document).on('click', '.payCredit', function(e) {

        createModal('白条支付', 'member/myOrderPayCredit', 'myOrderPayOnlinesave()');
        return false;
    });
    //填提货函modal
    $(document).on('click', '.pickLetter', function(e) {
    	var orderNo = $(this).attr('data-orderNo');
        createModal('填提货函', 'member/myOrderPickLetter?orderNo='+orderNo, 'myOrderPickLettersave()');
        return false;
    });
    //确认收货
    $(document).on('click', '.confirm', function(e) {
    	var orderNo = $(this).attr('data-orderNo');
    	$.post(app.approot + "www/member/myOrderConfirm", {orderNo: orderNo}, function(data) {
            if (data.status == '0' && data.content) {
            	getSupplier();
            	getCounts();
            }
    	});
    	return false;
    });
    //发票modal
    $(document).on('click', '.invoice', function(e) {
    	var orderNo = $(this).attr('data-orderNo');
    	createModal('开票', 'member/myOrderInvoice?orderNo='+orderNo, 'myOrderInvoicesave()');
    	return false;
    });
    //确认收票
    $(document).on('click', '.received', function(e) {
    	var orderNo = $(this).attr('data-orderNo');
    	$.post(app.approot + "www/member/myOrderReceived", {orderNo: orderNo}, function(data) {
            if (data.status == '0' && data.content) {
            	getSupplier();
            	getCounts();
            }
    	});
    	return false;
    });
    //评价modal
    $(document).on('click', '.evaluate', function(e) {
    	var orderNo = $(this).attr('data-orderNo');
        createModal('评价', 'member/myOrderPayEvaluate?orderNo='+orderNo, 'myOrderEvaluatesave()');
        return false;
    });





});

var page = 1,
    status = 0;

function getSupplier() {
  $.ajax({
    type: 'get',
    url: "/yuncai/www/member/selectOrder",
    data: {status:status, page:page},
	beforeSend: function(){
		$('.loading').show();
	},
	complete: function(){
		$('.loading').hide();
	},
    success: function(data) {
      console.log(data);
      if (data.status === 0) {
          var html = template('tMianTpl', data.content);
          $("#tMain").html(html);
          //增加付款倒计时
          countTime(data.content.content);

          if(data.content.totalElements == 0){
        	  $('#pageContainer').empty();
          }
          $('#pageContainer').pageBar({
              "totalpags":data.content.totalPages,
              "number":data.content.number
          });
      }
    }
  });
}

function getCounts(){
	$.ajax({
		type: 'GET',
		url: '/yuncai/www/member/countsOrder',
		success: function(data){
			$('.listbtn').each(function(index){
				$(this).find('p').html(data.content[index]);
			});
		}
	});
}

/**
**分页实现
*/
$(document).on('click', '#pageContainer li', function(e) {
  if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
    return false;
  }
  if($(this).attr('class') == 'prev'){
    page--;
  }else if($(this).attr('class') == 'next'){
    page++;
  }else{
    page = $(this).find('a').html();
  }
  getSupplier();
  return false;
});

/**
**代发货、待开票、待付款、已取消列表切换
*/
$(document).on('click',".listbtn",function(e){
	status=$(this).attr('data-list-status');
	$('#list-title').html($(this).find('h4').html());
	getSupplier();
});

//取消订单
$(document).on('click', '.deleteOrder', function(e){
	var orderNo = $(this).attr('data-orderNo');
	$.ajax({
	    type: 'post',
	    url: "/yuncai/www/member/deleteOrder",
	    data: {orderNo: orderNo},
	    success: function(data) {
	        if (data.status == '0') {
	        }
	        page=1;
	        getSupplier();
	        getCounts();
	    },
	    error: function(data) {
	        hideModal();
	        errorModal('提示', '返回错误');
	    }
	});
	return false;
});

//在线支付 确定
function myOrderPaysave() {
	var price=$('#payOnlinePrice').val();
  	var white=$('#payOnlineWhite').val();
	var other=$('#payOnlineOther').val();
	var type=$('#payOnlineType input[type="radio"]:checked')[0].value;
	var submitData={
		price:price,
		white:white,
		other:other,
		type:type
	};
$.ajax({
	type:'post',
	url:'',
	data:submitData,
	dataType:'json',
	success:function(data){
	  if(data.status=='0'){
	    //成功
	  }
	}
});

    hideModal();
  };

  //白条支付 确定
  function myOrderPayOnlinesave() {
    var price=$('#whitePayPrice').val();
  var whiteLine=$('#whitePayLine').val();
  var whiteUse=$('#whitePayUse').val();
  var other=$('#whitePayUse').val();
  var submitData={
    price:price,
    whiteLine:whiteLine,
    whiteUse:whiteUse,
    other:other
  };
  $.ajax({
    type:'post',
    url:'',
    data:submitData,
    dataType:'json',
    success:function(data){
      if(data.status=='0'){
        //成功
          }
        }
      });

    hideModal();
  }

  //填提货函 确定
  function myOrderPickLettersave() {
    $.post(app.approot + "www/member/callForDelivery", $("#deliveryForm").serialize(), function(data) {
    if (data.status == '0') {
    	$(".pickLetter").css('display','none');
        $("#pick-letter").modal('hide');
        alert('成功');
    }else {
        errorModal('提示',data.msg);
        }
    });
    hideModal();
  }

  //评价 确定
  function myOrderEvaluatesave() {
	var pj = [];
	$('#pjForm>div').each(function(){
	var arr = {},
		_sid = $(this).attr('sid'),
		_radio = $(this).find('.radio input:checked'),
		_comment = $(this).find('textarea[name="msg"]');
	arr.sid = _sid;
	// arr.qualityScore = _radio[0].value;
	// arr.priceScore = _radio[1].value;
	// arr.serviceScore = _radio[2].value;

  arr.qualityScore = $("#qualityStar").val();
  arr.priceScore = $("#priceStar").val();
  arr.serviceScore = $("#serviceStar").val();
	arr.comment = _comment.val();
	pj.push(arr);
});
$.ajax({
	url: app.approot + "www/member/callForComment",
	type: "POST",
	contentType: "application/json; charset=utf-8",
	data: JSON.stringify(pj),
	success: function(data) {
        if (data.status == '0') {
            $("#evaluate").modal('hide');
            getSupplier();
            getCounts();
        }else{
              errorModal('提示',data.msg);
	        }
		}
	});

    hideModal();
  }

//发票 确定
function myOrderInvoicesave() {
	$.post(app.approot + "www/member/callForBill", $("#billForm").serialize(), function(data) {

    if (data.status == '0' && data.content) {
        $("#callbillwindow").modal('hide');
	    }
	});

	hideModal();
};
//给需要倒计时的订单加上倒计时
function countTime(data){
	for(var i=0; i<data.length; i++){
		if(data[i].status == 2){
			var ele = $('.panel[data-id="'+data[i].id+'"]').find('.paymentExpire');
			(function(ele){
				startTime = new Date().getTime(),
				endTime = new Date(data[i].paymentExpire).getTime(),
				alarm = new Alarm(startTime, endTime, function(second, minute, hour, day){
					ele.html('付款剩余时间：'+hour + ':' + minute + ':' + second);
				}, function(){
					ele.html('付款剩余时间：'+'00:00:00');
					getSupplier();
				});
				alarm.start();
			})(ele)

		}
	}
}

//倒计时方法(单位是毫秒)
var Alarm = function(startime, endtime, countFunc, endFunc){
	this.time = Math.floor((endtime - startime) / 1000);
	this.countFunc = countFunc;
	this.endFunc = endFunc;
	this.flag = 't' + Date.parse(new Date());
};
Alarm.prototype.start = function () {
    var _this = this;

    _this.flag = setInterval(function () {
        if (_this.time < 0) {
            clearInterval(_this.flag);
            _this.endFunc();
        } else {
            var minute, hour, day, second;
            day = Math.floor(_this.time / 60 / 60 / 24) < 10 ? '0' + Math.floor(_this.time / 60 / 60 / 24) : Math.floor(_this.time / 60 / 60 / 24);
            hour = Math.floor(_this.time / 60 / 60 % 24) < 10 ? '0' + Math.floor(_this.time / 60 / 60 % 24) : Math.floor(_this.time / 60 / 60 % 24);
            minute = Math.floor(_this.time / 60 % 60) < 10 ? '0' + Math.floor(_this.time / 60 % 60) : Math.floor(_this.time / 60 % 60);
            second = Math.floor(_this.time % 60) < 10 ? '0' + Math.floor(_this.time % 60) : Math.floor(_this.time % 60);
            //倒计时执行函数
            _this.countFunc(second, minute, hour, day);
            _this.time--;

        }
    }, 1000);
}
