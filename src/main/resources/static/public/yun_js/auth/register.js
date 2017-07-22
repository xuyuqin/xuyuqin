$(function(){

	$('#registerForm').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
		message:null,
		submitHandler: function(validator, form, submitButton){
		  $.ajax({
			  type: "get",
			  url: '/yun/regist',
			  data: form.serialize(),
			  success: function(data) {
				  if(data.code == 0){
					  window.location.href = '/yuncai/login';
				  }else {
					  alert(data.msg);
				  }
			  }
		  });
	      return false;
		}
	});

	$('#verifyCode').click(function(){
        sms_button($('#verifyCode'));
		var $mobile = $('input[name="mobile"]').val();
		if($mobile != '' && typeof($mobile) != "undefined"){
			$.ajax({
				type: 'post',
				url: '/yun/verifyCode',
				data: {mobile: $mobile},
				success: function(data){
					if(data.code==0){

					}
				}
			});
		} else{
			alert('输入手机号码有误');
		}

	});

    function sms_button(obj) {
        var count = 1;
        var sum = 30;
        obj.text(sum);
        var a = setInterval(function () {
            if (count > 30) {
                obj.removeAttr('disabled');
                obj.text("重新获取");
                clearInterval(a);
            } else {
                obj.attr('disabled', 'disabled');
                obj.text(sum - count);
            }
            count++;
        }, 1000);
    }
});