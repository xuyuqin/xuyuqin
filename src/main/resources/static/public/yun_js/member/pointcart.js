$(function() {

    function useTpl() {
        var url = app.approot + "json/pointcart.json";
        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'JSON',
            data: {},
            success:function(data) {
                console.log(data.content);
                if(data.status == 0) {
                    var html = template('tMainTpl', data.content);
                    $('#tMain').html(html);
                    var page = template('pageTpl', data.content);
                    $('#pageContainer').html(page)
                }
            }
        });
    }

    useTpl();

    $(document).on('click', '#pageContainer li', function(e) {
        if ($(this).hasClass('active')) {
            return false;
        }
        page = $(this).find('a').html();
        console.log('点击了' + page);
        useTpl();
        return false;
    });

});