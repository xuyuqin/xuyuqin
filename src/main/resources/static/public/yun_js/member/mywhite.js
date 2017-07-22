$(function() {
    var status = 0,
        page = 1,
        begin_at,
        end_at,
        undefined;
    $.ajax({
        url: app.approot+'www/member/selectLoanAccount',
        type: 'GET',
        data: {},
        beforeSend: function(){
            $('.loading').show();
        },
        complete: function(){
            $('.loading').hide();
        },
        success:function(data) {
            if(data.status == 0) {
                console.log(data.content);

                var cred = template('creditTpl', data.content);
                $('#creditInfo').html(cred);
            }
        }
    });
    function useTpl() {
        $.ajax({
            url: app.approot+'www/member/selectLoan',
            type: 'GET',
            data: {status:status,page:page,begin_at:begin_at,end_at:end_at},
            success:function(data) {
                if(data.status == 0) {
                    console.log(data.content);

                    var html = template('tMainTpl', data.content);
                    $('#tMain').html(html);
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

    useTpl();

    $(document).on('click', '#btnSearch', function(e) {
        status = $('#status').find("option:selected").val();
        begin_at = $("#begin_at").val().trim()==""?undefined:$("#begin_at").val().trim();
        end_at = $("#end_at").val().trim()==""?undefined:$("#end_at").val().trim();
        page = 1;
        useTpl();
    });

    $(document).on('click', '.btnRepayment', function(e){
        var _sid = $(this).attr('sid');
        $.ajax({
            url: app.approot+'www/member/selectOneLoan',
            type: 'GET',
            data: {id:_sid},
            success: function(data){
                var modal = template('modalTpl', data.content);
                $('.modal-content').html(modal);
            }
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

    $(document).on('click', '.radioPayType input', function(){
        if($(this).attr('value') == '0'){
            $('.radioBank').css('display','none');
        }else{
            $('.radioBank').css('display','block');
        }
    });

    $(document).on('click', '.modalConfirm', function(){
        console.log();
    });

});