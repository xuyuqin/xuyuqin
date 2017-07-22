$(function(){
	var $mobile,
	$code;
	
	$('#verificationMobileForm').bootstrapValidator({
		submitHandler: function(validator, form, submitButton){
			  $mobile = $('input[name="mobile"]').val();
			  $code = $(form).find('input[name="code"]').val();
			  $.ajax({
				  type: "POST",
				  url: app.approot+'www/auth/checkCode',
			      beforeSend: function(){
			    	  $(submitButton).find('i').show();
				  },
				  complete: function(){
			    	  $(submitButton).find('i').hide();
			      },
				  data: form.serialize(),
				  success: function(data) {
					  if(data.status == 0){
						  $('#verificationMobileForm').hide();
						  $('#newPasswordForm').show();
					  }else {
						  alert('验证码错误');
					  }
				  }
			  });
		      return false;
		}
	});
	$('#newPasswordForm').bootstrapValidator({
	    message: 'this value is not valid',
	    feedbackIcons: {  
	        valid: 'glyphicon glyphicon-ok',  
	        invalid: 'glyphicon glyphicon-remove',  
	        validating: 'glyphicon glyphicon-refresh'  
	    },
	    fields: {
	        newPassword: {
	            validators: {
	                notEmpty: {
	                    message: '请输入新密码'
	                },
	                regexp: {
	                    regexp: /^[a-zA-Z0-9]{6,18}$/,
	                    message: '密码6-18位数字、字母'
	                }
	            }
	        },
	        confirmPassword: {
	            validators: {
	                notEmpty: {
	                    message: '请输入确认密码'
	                },
	                identical: {
	                    field: 'newPassword',
	                    message: '两次输入的密码不一致'
	                }
	            }   
	        }
	    },
		submitHandler: function(validator, form, submitButton){
			$.ajax({
				url: app.approot+'www/auth/revicePassword',
				type: 'post',
			    beforeSend: function(){
			    	$(submitButton).find('i').show();
				},
				complete: function(){
			    	$(submitButton).find('i').hide();
			    },
			    data: 'mobile='+$mobile+'&code='+$code+'&'+form.serialize(),
			    success: function(data){
					if(data.status == 0){
					  $('#newPasswordForm').hide();
					  $('#complete').show();
					}else{
						alert(data.content);
					}
			    }
			});
		    return false;
		}

	});
	
	$('#verifyCode').click(function(){
		$mobile = $('input[name="mobile"]').val();
		if($mobile != '' && typeof($mobile) != "undefined"){
			$.ajax({
				type: 'post',
				url: app.approot+'www/auth/verifyCode',
				data: {phone: $mobile},
				success: function(data){
					console.log(data);
				}
			});
		} else{
			alert('输入手机号码有误');
		}

	});
})
