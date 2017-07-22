$(function() {
    var status = 0,
        page = 1,
        begin_at,
        end_at,
        searchName,
        undefined;

    function useTpl() {
        $.ajax({
            type: 'GET',
            url: app.approot+'www/member/selectBill',
            data: {status:status,page:page,begin_at:begin_at,end_at:end_at,searchName:searchName},
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
        status = $('#status').find("option:selected").val();
        begin_at = $("#begin_at").val().trim()==""?undefined:$("#begin_at").val().trim();
        end_at = $("#end_at").val().trim()==""?undefined:$("#end_at").val().trim();
        searchName = $("#searchName").val().trim()==""?undefined:encodeURI($("#searchName").val().trim());
        page = 1;
        useTpl();
    });

});