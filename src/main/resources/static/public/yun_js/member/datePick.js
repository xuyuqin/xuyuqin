/**
 * Created by Administrator on 2017/7/3 0003.
 */

var now = new Date();
var month = (now.getMonth()+1)>9?now.getMonth()+1:'0'+(now.getMonth()+1);
var date = now.getDate()>9?now.getDate():'0'+now.getDate();
var endDate = now.getFullYear()+'-'+month+'-'+date;
var time1;

$('#startTime').datetimepicker({
    format: 'yyyy-mm-dd',
    startView:4,
    minView:2,
    language:'zh-CN',
    endDate:endDate
}).on('changeDate',function () {
    $(this).datetimepicker('hide');
    time1 = $('input[name=time1]').val();

    $('#endTime').attr('disabled',false).datetimepicker({
        format: 'yyyy-mm-dd',
        startView:4,
        minView:2,
        language:'zh-CN',
        startDate:time1,
        endDate:endDate
    }).on('changeDate',function () {
        $(this).datetimepicker('hide');
    });
});

