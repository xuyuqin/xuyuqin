$(function() {
    var demandId = getQueryString('demandId');

    $(document).on('click','#createBtn',function() {
        var data = new FormData($("#replyForm")[0]);
        if (demandId == '' || demandId == undefined || demandId == null) {
            alert("未找到本求购单，不能报价");
            return false;
        } else {
            data.append('demand.id', demandId);
        }
        var url = __appconfig.approot + "www/demand/price";
        $.ajax({
            url: url,
            type: 'POST',
            data: data,
            processData: false,
            contentType: false,
            beforeSend: function(){
                $('.loading').show();
            },
            complete: function(){
                $('.loading').hide();
            },
        })
        .done(function(data) {
            console.log(data);
        })
        .fail(function(data) {
            console.log("error");
        });
    });

    getDemand();
    getDemandReply();

    function getDemand() {
        var url = __appconfig.approot + 'www/demand/findOne?demandId=' + demandId;
        $.post(url, function(data) {
            console.log(data);
            if (data.status == 0) {
                //获取成功
                var demandHtml = template('tDemandTpl', data.content);
                $("#tDemand").html(demandHtml);
            } else {
                var demandHtml = template('tDemandTpl', {});
                $("#tDemand").html(demandHtml);
                alert(data.msg);
            }
        });
    }

    function getDemandReply() {
        var url = __appconfig.approot + 'www/demand/findReply?demandId=' + demandId;
        $.post(url, function(data) {
            console.log(data);
            if (data.status == 0) {
                //获取成功
                var formHtml = template('formTpl', data.content);
                $("#replyForm").html(formHtml);
            } else {
                alert(data.msg);
            }
        });
    }
});