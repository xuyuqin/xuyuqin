$(function() {
    var page = 1;
    var demandId = getQueryString('demandId');

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
        getReplys();
    });


    getDemand();
    getReplys();

    function getDemand() {
        var url = __appconfig.approot + 'www/demand/findOne?demandId=' + demandId;
        $.post(url, function(data) {
            console.log(data);
            if (data.status == 0) {
                //获取成功
                var demandHtml = template('tDemandTpl', data.content);
                $("#tDemand").empty().html(demandHtml);
            } else {
                var demandHtml = template('tDemandTpl', {});
                $("#tDemand").empty().html(demandHtml);
                alert(data.msg);
            }
        });
    }

    function getReplys() {
        var url = __appconfig.approot + 'www/demand/findReplys?rows=5&page=' + page + '&demandId=' + demandId;
        $.post(url, function(data) {
            console.log(data);
            if (data.status == 0) {
                //获取成功
                var replysHtml = template('tReplyTpl', data.content);
                $("#tReply").html(replysHtml);
                $("#pageBar").empty().pageBar({
                    'totalpags': data.content.totalPages,
                    'number': data.content.number,
                });
            } else {
                var replysHtml = template('tReplyTpl', data.content);
                $("#tReply").html(replysHtml);
                alert(data.msg);
            }
        });
    }
});