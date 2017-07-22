$(function() {
    var page = 1;
    var cate = getQueryString('cate');
    var tag = getQueryString('tag');
    var name = getQueryString('q');

    //分页按钮
    $(document).on('click', '#pageBar li', function(e) {
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
        getProductList();
    });

    // getHotList();
    // function getHotList() {
    //     $.getJSON(__appconfig.approot + 'www/baike/hotList', function(json) {
    //         console.log(json);
    //         var hotHtml = template('hotTpl', json);
    //         $("#hotList").empty().html(hotHtml);
    //     });
    // }

    
    getTagList();
    function getTagList() {
        var url = __appconfig.approot + 'www/baike/tagList';
        $.getJSON(url, function(json) {
            console.log(json);
            var tagHtml = template('tagTpl', json);
            $("#tagList").empty().html(tagHtml);
        });
    }

    getProductList();
    page = 1;
    function getProductList() {
        if (cate != '' && cate != undefined && cate != null) {
            var url = __appconfig.approot + 'www/baike/search?page=' + page + '&cate=' + cate;
        } else if (tag != '' && tag != undefined && tag != null) {
            var url = __appconfig.approot + 'www/baike/search?page=' + page + '&tag=' + tag;
        } else if (name != '' && name != undefined && name != null) {
            var url = __appconfig.approot + 'www/baike/search?page=' + page + '&name=' + name;
        } else {
            var url = __appconfig.approot + 'www/baike/search?page=' + page;
        }
        $.ajax({
            url: url,
            type: 'POST',
            data: {},
            processData: false,
            contentType: false,
            beforeSend: function() {
                $('.loading').show();
            },
            complete: function() {
                $('.loading').hide();
            },
        }).done(function(data) {
            console.log(data);
            if (data.status == 0) {
                //获取成功
                var listHtml = template('mainTpl', data.content);
                $("#mainList").empty().html(listHtml);
                $("#pageBar").empty().pageBar({
                    'totalpags': data.content.totalPages,
                    'number': data.content.number
                });
            } else {
                console.log(data.msg);
            }
        }).fail(function() {
            console.log('error');
        });
    }   
});