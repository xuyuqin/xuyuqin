function imgmall(a, b) {
    $("#mallCarousel").carousel(a);
    document.getElementById("img1").src = b.src;
}

window.onload = function() {

    $('#mallCarousel').carousel({});
    var oDiv = document.getElementById('mallCarousel');
    var oShow = oDiv.getElementsByTagName('div')[0];
    var oImg = document.getElementById('img1');
    var oSpan = $("#mallCarousel .active span")[0];

    oShow.onmouseover = function() {
        //  degrees = $(window).scrollTop();
        //  var timerProducts = setInterval(function(){
        //
        //      if(degrees < "0") {
        //            $(window).scrollTop(0);
        //            clearInterval(timerProducts);
        //      }else{
        //           degrees = degrees-2;
        //          $(window).scrollTop(degrees);
        //      }
        //  }, 10);

        oSpan = $("#mallCarousel .active span")[0];
        $("#mallCarousel .active span").show();
        oImg.parentNode.style.display = 'block';
    };
    oShow.onmouseout = function() {

        oSpan = $("#mallCarousel .active span")[0];
        $("#mallCarousel .active span").hide();
        oImg.parentNode.style.display = 'none';
    };
    oShow.onmousemove = function(ev) {

        oSpan = $("#mallCarousel .active span")[0];
        var oEvent = ev || event;
        var x = oEvent.offsetX - oDiv.offsetLeft - oSpan.offsetWidth/2;
        var y = oEvent.offsetY - oDiv.offsetTop - oSpan.offsetHeight/2;
        if (x < 0) {
            x = 0;
        } else if (x > oShow.offsetWidth - oSpan.offsetWidth) {
            x = oShow.offsetWidth - oSpan.offsetWidth;
        }
        if (y < 0) {
            y = 0;
        } else if (y > oShow.offsetHeight - oSpan.offsetHeight) {
            y = oShow.offsetHeight - oSpan.offsetHeight;
        }
        oSpan.style.left = x + 'px';
        oSpan.style.top = y + 'px';
        var percentX = x / (oShow.offsetWidth - oSpan.offsetWidth);
        var percentY = y / (oShow.offsetHeight - oSpan.offsetHeight);
        var oImgparent = oImg.parentNode;
        oImg.style.left = -percentX * (oImg.offsetWidth - oImgparent.offsetWidth) + 'px';
        oImg.style.top = -percentY * (oImg.offsetHeight - oImgparent.offsetHeight) + 'px';
    };
};


$(function() {
    var merchandiseId = getQueryString('merchandiseId');

	//收藏按钮
	$("#btnCollection").click(function(e) {
		var url = __appconfig.approot + 'www/merchandise/collection?merchandiseId=' + $(this).attr('sid');
		$.post(url, {}, function(data) {
			console.log(data);
			if (data.status == 0) {
				alert(data.msg);
			} else {
				alert(data.msg);
			}
		});
	});

	//收藏店铺
    $("#shopCollection").click(function(e) {
    	console.log($(this).data('providerId'));
        var url = __appconfig.approot + 'www/provider/collection?providerId=' + $(this).data('provider');
        $.post(url, {}, function(data) {
            console.log(data);
            if (data.status == 0) {
                alert(data.msg);
            } else {
                alert(data.msg);
            }
        });
    });

	//本店搜索
	$("#btnInside").click(function(e) {
		var url = __appconfig.approot + 'www/provider/index?' + encodeURI($("#formInside").serialize());
		document.location = url;
	});
});