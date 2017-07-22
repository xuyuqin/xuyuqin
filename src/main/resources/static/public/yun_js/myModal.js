/**
    modal
    各类弹出框，提示框
**/


//标准modal
function createModal(title, remote, submit) {
    if ($('#myModal').length == '0') {
        $(
            '<div class="modal fade  myModal" style="min-height:300px">'+
            '<div class ="modal-dialog" >'+
            '<div class ="modal-content" id="myModal">' +
            '</div></div></div>').appendTo("body");
        $(
            '<div class="modal-header">' +
            '<div class="portlet-title">' + title +
            '</div></div>').appendTo("#myModal");
        $('<div id="myModals" class=""></div>').appendTo("#myModal");
        $('<div class="modal-footer" style="text-align:center">' +
            '<a class="btn btn-default" data-dismiss="modal" onclick="'+submit+'">确定</a>' +
            '<a class="btn btn-default btnHidden" data-dismiss="modal">取消</a>' +
            '</div>').appendTo("#myModal");
        $('#myModals').modal({
            remote: remote,
        });
        // .on('hidden', function() {
        //     $(this).remove();
        // });
        $(".btnHidden").click(function() {
            hideModal();
            $('body').css({
                "overflow-x":"auto",
                "overflow-y":"auto"
            });
        });
        $(".myModal").fadeToggle(1).addClass('in');
    } else {
        // $('#myModals').modal({
        //     remote: remote,
        // }).on('hidden', function() {
        //     $(this).remove();
        //
        // });
    }
}

//提示 modal
function tishiModal(title, content, submit) {
    if ($('#myModal').length == '0') {
        $(
            '<div class="modal fade  myModal" style="min-height:300px;margin-top:10%" tabindex="-1" role="dialog"   aria-hidden="true">'+
            '<div class ="modal-dialog" >'+
            '<div class ="modal-content" id="myModal">' +
            '</div></div></div>').appendTo("body");
        $(
            '<div class="modal-header">' +
            '<div class="portlet-title"><button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times;</button>' + title +
            '</div></div>').appendTo("#myModal");
        $('<div class="modal-body">'+content+'</div>').appendTo("#myModal");
        $('<div class="modal-footer" style="text-align:center">' +
            '<a class="btn btn-default" onclick="'+submit+'">确定</a>' +
            '<a class="btn btn-default btnHidden" data-dismiss="modal">取消</a>' +
            '</div>').appendTo("#myModal");
        $('.myModal').modal({});
        $('.myModal').on('hide.bs.modal', function () {
            $('body').css({
                "overflow-x":"auto",
                "overflow-y":"auto"
            });
            $(".myModal").remove();
        })
        // $(".myModal").fadeToggle().addClass('in');
    } else {
    }
}

//返回错误modal
function errorModal(title, content) {
    if ($('#myModal').length == '0') {
        $(
            '<div class="modal fade  myModal" style="min-height:300px;margin-top:10%">'+
            '<div class ="modal-dialog" >'+
            '<div class ="modal-content" id="myModal">' +
            '</div></div></div>').appendTo("body");
        $(
            '<div class="modal-header">' +
            '<div class="portlet-title">' + title +
            '</div></div>').appendTo("#myModal");
        $('<div id="myModals" class="modal-body">'+content+'</div>').appendTo("#myModal");
        $('<div class="modal-footer" style="text-align:center">' +
            '<a class="btn btn-default btnHidden" data-dismiss="modal">确定</a>' +
            '</div>').appendTo("#myModal");
            $('.myModal').modal({
            });
        $('.myModal').on('hide.bs.modal', function () {
            $('body').css({
                "overflow-x":"auto",
                "overflow-y":"auto"
            });
            $(".myModal").remove();
        })
        $(".myModal").fadeToggle().addClass('in');
    } else {
    }
}


