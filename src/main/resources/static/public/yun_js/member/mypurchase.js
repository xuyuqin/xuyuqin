$(function() {
    var page = '1',
        begin_at,
        end_at,
        purchaseName,
        undefined;
    function useTpl() {
        $.ajax({
            url: app.approot+'www/member/selectMypurchase',
            type: 'GET',
            data: {page:page,begin_at:begin_at,end_at:end_at,purchaseName:purchaseName},
            beforeSend: function(){
                $('.loading').show();
            },
            complete: function(){
                $('.loading').hide();
            },
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

    $(document).on('click', '#btnSearch', function(e) {
        begin_at = $("#begin_at").val().trim()==""?undefined:$("#begin_at").val().trim();
        end_at = $("#end_at").val().trim()==""?undefined:$("#end_at").val().trim();
        purchaseName = $("#purchaseName").val().trim()==""?undefined:encodeURI($("#purchaseName").val().trim());
        page = 1;
        useTpl();
    });

    $(document).on('click', '.del', function(e) {
        var id = $(this).attr('demandId');
        var url =app.approot+"www/demand/delete";
        $.ajax({
            url: url,
            type: 'POST',
            data: {'demandId':id},
            success:function(data) {
                console.log(data);
                if(data.status == 0) {
                    page=1;
                    useTpl();
                }
            }
        });
        return false;
    });

})