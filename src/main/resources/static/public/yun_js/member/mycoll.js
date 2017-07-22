$(function() {
    var page = 1,
        url = app.approot+'www/member/selectCollMerchandise',
        tpl = 'tMainTpl';

    function useTpl() {
        $.ajax({
            type: 'GET',
            url: url,
            data: {page:page},
            beforeSend: function(){
                $('.loading').show();
            },
            complete: function(){
                $('.loading').hide();
            },
            success:function(data) {                            
                console.log(data.content);
                if(data.status == 0) {
                    var html = template(tpl, data.content);
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

    /**
        **tab切换
    */
    $('#tab_header a').click(function(e){
        e.preventDefault();
        $(this).tab('show');
        url=app.approot+'www/member/'+$(this).attr("data-id");
        page=1;
        tpl=$(this).attr("data-tpl");
        useTpl();
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

    $(document).on('click', '.del', function(e) {
        var id = $(this).attr('mycollId'),
            url = app.approot+"www/member/"+$(this).attr('data-id');
        $.ajax({
            url: url,
            type: 'GET',
            data: {'mycollId':id},
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
    
});