$(function(){
	$('#revicePasswordForm').bootstrapValidator({
		message: 'this value is not valid',
		feedbackIcons: {  
            valid: 'glyphicon glyphicon-ok',  
            invalid: 'glyphicon glyphicon-remove',  
            validating: 'glyphicon glyphicon-refresh'  
		},
		fields: {
			oldPassword: {
				validators: {
					notEmpty: {
						message: '请输入原始密码'
					}
				}
			},
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
			
		}
	});

	
	function getUserinfo(){
		$.ajax({
			type: 'POST',
			url: app.approot+'www/member/selectUserinfo',
			success: function(data){
				console.log(data);
				var _content=data.content,
					$tdMobile=$('#trMobile>td'),
					$tdEmail=$('#trEmail>td');
				$tdMobile.eq(2).html(_content.mobile);
				$tdEmail.eq(2).html(_content.email);
				if(_content.mobileVerified){
					$tdMobile.eq(0).html('<a class="btn btn-link"><i class="fa fa-check-circle fa-fw text-success"></i>已开启</a>');
				}else{
					$tdMobile.eq(0).html('<a class="btn btn-link"><i class="fa fa-exclamation-circle fa-fw text-primary"></i>未开启</a>');
				}
				if(_content.emailVerified){
					$tdEmail.eq(0).html('<a class="btn btn-link"><i class="fa fa-check-circle fa-fw text-success"></i>已开启</a>');
				}else{
					$tdEmail.eq(0).html('<a class="btn btn-link"><i class="fa fa-exclamation-circle fa-fw text-primary"></i>未开启</a>');
				}
				
				if(_content.mobileVerified && _content.emailVerified){
					$('input[name="lv-radio"]').eq(2).attr('checked', true)
				} else if(_content.mobileVerified || _content.emailVerified){
					$('input[name="lv-radio"]').eq(1).attr('checked', true)
				} else{
					$('input[name="lv-radio"]').eq(0).attr('checked', true)
				}
			}
		});
	}
	getUserinfo();

})

function revicePassword(){
	$('#revicePasswordForm').data('bootstrapValidator').validate();
    if(!$('#revicePasswordForm').data('bootstrapValidator').isValid()){  
        return ;  
    }
	$.post('revicePassword',$('#revicePasswordForm').serialize(),function(data){
		if(data.status == 0){
			$("#change-passwd").modal('hide'); 
		}else{
			console.log(data);
		}
	});
}