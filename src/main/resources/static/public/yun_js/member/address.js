$(function() {
	//表单绑定验证
	$('#editForm').bootstrapValidator({
        submitHandler: function(validator, form, submitButton){
	        $.post(app.approot+'www/member/updateAddress',$.param({'id':submitButton.attr('sid')}) + '&' + form.serialize(),function(data){
	            if(data.status==0){
	                $("#change-addr").modal('hide');
	                page=1;
	                useTpl();
	            }
	        });
        }
    });
	$('#saveForm').bootstrapValidator({
        submitHandler: function(validator, form, submitButton){
            $.post(app.approot+'www/member/addAddress',form.serialize(),function(data){
                if(data.status==0){
                    $("#new-addr").modal('hide');
                    page=1;
                    useTpl();
                }
            });
        }
    });

    var page=1;
    function useTpl() {
        $.ajax({
            type: 'GET',
            url: app.approot+'www/member/selectAddress',
            data: {page:page},
            beforeSend: function(){
                $('.loading').show();
            },
            complete: function(){
                $('.loading').hide();
            },
            success:function(data) {                            
                if(data.status == 0) {
                    getCitysData(function(){
                        for(var x in data.content.content){
                            data.content.content[x].province=citysData[data.content.content[x].province];
                            data.content.content[x].city=citysData[data.content.content[x].city];
                            data.content.content[x].district=citysData[data.content.content[x].district];
                        }
                        var html = template('tMainTpl', data.content);
                        $('#tMain').html(html);
                    });
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
    var citysData={};
    function getCitysData(ck){

        if($.isEmptyObject(citysData)){        
            var citys = sessionStorage.citys;
            if(typeof citys == 'undefined' || citys == null){
                $.getJSON(app.approot+'www/member/findRegion',function(datas){
                    for(var x in datas.content){
                        citysData[datas.content[x].code]=datas.content[x].name;
                    }
                    sessionStorage.setItem('citys', JSON.stringify(citysData))
                    ck();
                });
            } else{
                citysData=JSON.parse(citys);
                ck();
            }
        }else{
            ck();
        }
    }

    useTpl();

    getCitysData(function(){
        $('#saveForm').citys({
            required:false,
            nodata:'disabled',
            data:citysData
        });
    });


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
        useTpl();
        return false;
    });
    
    $(document).on('click', '.edit', function(e) {
        var id = $(this).attr('addressId');
        var url = app.approot+'www/member/findAddress';
        $('#change-addr').find('.edit_submit').attr('sid',id);
        $.ajax({
            url: url,
            type: 'GET',
            data: {'addressId':id},
            success:function(data) {                            
                console.log(data.content);
                if(data.status == 0) {
                    $('#change-addr').find('.receiver').attr('value', data.content.name);
                    $('#change-addr').find('.tele').attr('value', data.content.mobile);
                    $('#change-addr').find('.address').attr('value', data.content.detailAddress);
                    getCitysData(function(){
                        $('#editForm').citys({province:data.content.province,city:data.content.city,district:data.content.district,
                        data:citysData});
                    });
                    if(data.content.isDefault){
                        $('#change-addr').find('.isDefault').prop('checked',true); 
                    }
                    $("#change-addr").modal('show');
                }
            }
        });
        return false;
    });
    
    
    $(document).on('click', '.del', function(e) {
        var id = $(this).attr('addressId');
        console.log(id);
        var url = app.approot+'www/member/deleteAddress';
        $.ajax({
            type: 'POST',
            url: url,
            data: {'addressId':id},
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
    
    

    
    $(document).on('click','.save_submit',function(e){
    	$.post(app.approot+'www/member/addAddress',$("#saveForm").serialize(),function(data){
    		if(data.status==0){
    			$("#new-addr").modal('hide');
    			page=1;
    			useTpl();
    		}
    	});
    });

    $(document).on('click','.cancel_submit',function(e){
        $('.edit_submit').parents('.modal-content').find('form input').each(function(){
            if($(this).attr('type')=='checkbox'){
                $(this).prop('checked',false);
            }else{
                $(this).attr('value','');                        
            }
        })
    });
    
    
});