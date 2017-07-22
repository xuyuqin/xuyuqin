$(function() {

    useTpl();

    $(document).on('click', '#pageContainer li', function(e) {
        if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
            return false;
        }
        if ($(this).hasClass('prev')) {
            page--;
        } else if ($(this).hasClass('next')) {
            page++;
        } else {
            page = $(this).find('a').html();
        }
        useTpl();
        return false;
    });

    $(document).on('click', '#btnSearch', function(e) {
        begin_at = $("#begin_at").val().trim() == "" ? undefined : $("#begin_at").val().trim();
        end_at = $("#end_at").val().trim() == "" ? undefined : $("#end_at").val().trim();
        resourceName = $("#reourceName").val().trim() == "" ? undefined : encodeURI($("#reourceName").val().trim());
        page = 1;
        useTpl();
    });

    $(document).on('click', '.del', function(e) {
        var id = $(this).attr('resourceId');
        var url = app.approot+"www/resource/delete";
        $.ajax({
            url: url,
            type: 'POST',
            data: {'resourceId': id},
    		beforeSend: function(){
    			$('.loading').show();
    		},
    		complete: function(){
    			$('.loading').hide();
    		},
            success: function(data) {
                console.log(data.content);
                if (data.status == 0) {
                    page = 1;
                    useTpl();
                }
            }
        });
        return false;
    });
});

var page = '1',
    begin_at,
    end_at,
    resourceName,
    undefined;
function useTpl() {
    $.ajax({
        type: 'get',
        url: app.approot+'www/member/selectMyresource',
        data: {
            page: page,
            begin_at: begin_at,
            end_at: end_at,
            resourceName: resourceName
        },
        success: function(data) {
            if (data.status == 0) {
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