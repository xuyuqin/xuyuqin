$(function(){

    $.ajax({
      url: app.approot+'www/member/selectUserinfo',
      type: 'POST',
      success: function(data){
          refreshForm(data);
      }
    });

    $('form').submit(function(){
      $.ajax({
        type: "POST",
        url:app.approot+'www/member/updateUserinfo',
        data:$(this).serialize(),
        success: function(data) {
        	if(data.status == 0){
        		refreshForm(data);
        		alert('保存成功');
        	}
        }
      });
      return false;
    });
  
    //头像上传
    var cropboxOptions = {
	        thumbBox: '.thumbBox',
	        spinner: '.spinner',
	        imgSrc: ''
	    };
    var cropper = $('.imageBox').cropbox(cropboxOptions);
    $('#file').on('change', function(){
        var reader = new FileReader();
        reader.onload = function(e) {
        	cropboxOptions.imgSrc = e.target.result;
            cropper = $('.imageBox').cropbox(cropboxOptions);
        }
        reader.readAsDataURL(this.files[0]);
//        this.files = [];
    })
    $('#btnCrop').on('click', function(){
        var img = cropper.getDataURL();
        var imgBlob = cropper.getBlob();
//        $('.cropped').append('<img src="'+img+'">');
        var formData = new FormData();
        formData.append("imgBlob", imgBlob);
        $.ajax({
        	url: app.approot+'www/member/saveAvatar',
        	data: formData,
        	type: 'post',     
            contentType: false,  
            processData: false,  
        	success: function(data){
        		console.log(data);
        		if(data.status == 0){
        			$('form input[name="avatar"]').val(data.content);
        		}
        	}
        });
    })
    $('#btnZoomIn').on('click', function(){
        cropper.zoomIn();
    })
    $('#btnZoomOut').on('click', function(){
        cropper.zoomOut();
    })
	$('#verifyCode').click(function(){
		$.ajax({
			type: 'post',
			url: app.approot+'www/member/verifyCode',
			success: function(data){
				if(data.status == 0){
					console.log('发送验证码成功');
				}else{
					console.log(data.message);
				}
			}
		});

	});
    
});
    
function refreshForm(data){
    var content = data.content,
    	mobile = content.mobile.replace(/1(\d{2})\d{4}(\d{4})/g,"1$1****$2");
    $('form input[name="avatar"]').val(content.avatar);
    $('form input[name="name"]').val(content.name);
    $('form input#inputEmail').val(content.email);
    $('#changeEmailForm .labelMobile').html(mobile);
    $('form input#inputMobile').val(mobile);
    $('form input[name="address"]').val(content.address);
    $('form input[name="qq"]').val(content.qq);
    if(content.mobileVerified){
      $('.mobileVerifiedBody').html('<h4 class="media-heading">手机认证</h4><a class="btn btn-link"><i class="fa fa-fw fa-check-circle">已认证</i><br></a><p>您的手机已通过认证</p>');
    }else{
      $('.mobileVerifiedBody').html('<h4 class="media-heading">手机认证</h4><a class="btn btn-link"><i class="fa fa-fw fa-times-circle">未认证</i><br></a><p>您的手机未通过认证</p>');
    }
    if(content.emailVerified){
      $('.emailVerifiedBody').html('<h4 class="media-heading">邮箱认证</h4><a class="btn btn-link"><i class="fa fa-fw fa-check-circle">已认证</i><br></a><p>您的邮箱已通过认证</p>');
    }else{
      $('.emailVerifiedBody').html('<h4 class="media-heading">邮箱认证</h4><a class="btn btn-link"><i class="fa fa-fw fa-times-circle">未认证</i><br></a><p>您的邮箱未通过认证</p>');
    }
}

function changeEmail(){
	var _email = $('#changeEmailForm input[name="email"]').val().trim(),
		_code = $('#changeEmailForm input[name="code"]').val().trim();
	$.ajax({
		type: 'post',
		url: app.approot+'www/member/changeEmail',
		data: {email: _email,code: _code},
		success: function(data){
			if(data.status == 0){
				alert('修改成功');
				refreshForm(data);
			}else{
				alert(data.message);
			}
		}
	});
}