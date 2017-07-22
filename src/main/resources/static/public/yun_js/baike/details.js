$(function() {
    var page1 = 1;
    var page2 = 1;
    var productId = getQueryString('productId');
    getProduct();
    getSection();
    getUpStream();
    getDownStream();
    getProvider();

    //分页按钮
    $(document).on('click', '#pageBar1 li', function(e) {
        if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
            return false;
        }
        if ($(this).hasClass('prev')) {
            page1--;
        } else if ($(this).hasClass('next')) {
            page1++;
        } else {
            page1 = $(this).find('a').html();
        }
        getUpStream();
    });

    $(document).on('click', '#pageBar2 li', function(e) {
        if ($(this).hasClass('active') || $(this).hasClass('disabled')) {
            return false;
        }
        if ($(this).hasClass('prev')) {
            page2--;
        } else if ($(this).hasClass('next')) {
            page2++;
        } else {
            page2 = $(this).find('a').html();
        }
        getDownStream();
    });    

    function getProduct() {
        var url = __appconfig.approot + 'www/product/findOne?productId=' + getQueryString('productId');
        $.getJSON(url, function(json) {
            console.log(json);
            if (json.status == 0) {
                //获取成功
                var productHtml = template('productTpl', json);
                $("#productInfo").empty().html(productHtml);
            } else {
                alert(json.msg);
            }
        });
    }

    function getSection() {
        var url = __appconfig.approot + 'www/baike/findSection?productId=' + productId;
        $.getJSON(url, function(json) {
            console.log(json);
            if (json.status == 0) {
                //获取成功
                var sectionHtml = template('sectionTpl', json);
                $("#sectionDom").empty().html(sectionHtml);
            } else {
                alert(json.msg);
            }
        });
    }

    function getUpStream() {
        var url = __appconfig.approot + 'www/product/findUpstream?rows=12&page=' + page1 + '&productId=' + productId;
        $.getJSON(url, function(json) {
            console.log(json);
            if (json.status == 0) {
                var upHtml = template('upstreamTpl', json.content);
                $("#upstreamDom").empty().html(upHtml);
                if (json.content.totalPages > 1) {
                    $("#pageBar1").empty().pageBar({
                        'totalpags': json.content.totalPages,
                        'number': json.content.number,
                    });
                } else {
                    $("#pageBar1").parent().remove();
                }
            } else {
                alert(json.msg);
            }
        });
    }

    function getDownStream() {
        var url = __appconfig.approot + 'www/product/findDownstream?rows=12&page=' + page2 + '&productId=' + productId;
        $.getJSON(url, function(json) {
            console.log(json);
            if (json.status == 0) {
                var downHtml = template('downstreamTpl', json.content);
                $("#downstreamDom").empty().html(downHtml);
                if (json.content.totalPages > 1) {
                    $("#pageBar2").empty().pageBar({
                        'totalpags': json.content.totalPages,
                        'number': json.content.number,
                    });
                } else {
                    $("#pageBar2").parent().remove();
                }
            } else {
                alert(json.msg);
            }
        });
    }

    function getProvider() {
        var url = __appconfig.approot + 'www/provider/searchRelevant?rows=4';
        $.post(url, {
            productId: getQueryString('productId')
        }, function(data) {
            console.log(data);
            if (data.status == 0) {
                var recommendHtml = template('recommendTpl', data.content);
                $("#recommendDom").empty().html(recommendHtml);
            } else {
                alert(data.msg);
            }
        });
    }
});