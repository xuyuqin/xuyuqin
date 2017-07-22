$(function(){
	//表单绑定验证
	$('form').bootstrapValidator({
		submitHandler: function(validator, form, submitButton){
			if($('input[name="licensePackage"]').val() != ""){
		    	  $.ajax({
		    		  type: "POST",
		    		  url: app.approot+'www/member/addApply',
		    		  data: form.serialize(),
		    		  success: function(data) {
		    			  console.log(data);
		    			  if(data.status == 0){
		    				  window.location.href = app.approot+'www/member/vipauth';
		    			  }
		    		  }
		    	  });
		      }else{
		    	  alert('请点击文件上传');
		      }
		      return false;
		}
	});

    //文件上传
    $("#licensePackageFile").fileinput({
      uploadUrl: app.approot+'www/member/uploader', // you must set a valid URL here else you will get an error
      allowedFileExtensions : ['rar','zip'], 
      overwriteInitial: false,
      maxFileSize: 10000,
      maxFilesNum: 1,
      slugCallback: function(data) {
          return data.replace('(', '_').replace(']', '_');
      }
    });
    //文件上传后事件
    $('#licensePackageFile').on('fileuploaded', function(event, data, previewId, index) {
      var form = data.form, files = data.files, extra = data.extra,
      response = data.response, reader = data.reader;
      $('input[name="licensePackage"]').val(response.content);
    });
	//type切换
    $('.radio input').each(function(index){
      $(this).click(function(){
        if($(this).attr('value') == '1'){
          $('input[name=carded]').parents('.form-group').css('display','none');
        }else{
          $('input[name=carded]').parents('.form-group').css('display','block');           
        }
      });
    });
});