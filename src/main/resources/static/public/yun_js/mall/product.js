function imgmall(a, b) {
    $("#mallCarousel").carousel(a);
    document.getElementById("img1").src = b.src;
}
$(".fa-minus").click(function(){
    var a =$("#inputNumber").val();
    if( a =="1"){

    }else{
      a = parseInt(a)-1;

      $("#inputNumber").val(a);
    }
});
$(".fa-plus").click(function(){
  var a =$("#inputNumber").val();
  if( a =="5"){

  }else{
    a =parseInt(a) +1;
    $("#inputNumber").val(a);
  }
});
window.onload = function() {

    $('#mallCarousel').carousel({});
    var oDiv = document.getElementById('mallCarousel');
    var oShow = oDiv.getElementsByTagName('div')[0];
    var oImg = document.getElementById('img1');
    var oSpan = $(".active span")[0];

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

        oSpan = $(".active span")[0];
        $(".active span").show();
        oImg.parentNode.style.display = 'block';
    };
    oShow.onmouseout = function() {

        oSpan = $(".active span")[0];
        $(".active span").hide();
        oImg.parentNode.style.display = 'none';
    };
    oShow.onmousemove = function(ev) {

        oSpan = $(".active span")[0];
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
  //页码数从一开始
  var page = 1;
  var page2 = 1;

  var specificationId;
  var specification;
  var price;

  //取url参数值
  function GetQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
  }

  function getList() {
    //获取商品评价列表接口
    var url = app.approot + 'www/merchandiseC/findCommits?page=' + page + '&merchandiseId=' + GetQueryString("merchandiseId");
    $.post(url, {}, function(data) {
      console.log(data);
      if (data.status == 0) {
        var html = template('commitsTpl', data.content);
        $("#commits").empty().html(html);
        $('#pageContainer').pageBar({
            "totalpags": data.content.totalPages,
            "number": data.content.number,
          });
      } else {
        alert(data.msg);
      }
    });
  }

  function getList2() {
    //获取相关商品列表接口
    var url = app.approot + 'www/merchandise/findRelation?rows=1&page=' + page2 + '&productId=' + $('#productId').html();
    $.post(url, {}, function(data) {
      console.log(data);
      if (data.status == 0) {
        var html = template('relationTpl', data.content);
        $("#relation").empty().html(html);
        $('#pageContainer2').pageBar({
          "totalpags": data.content.totalPages,
           "number": data.content.number,
        });
      } else {
        alert(data.msg);
      }
    });
  }

  function getList3() {
    //获取本店热销商品排行
    var url = app.approot + 'www/supplierOrder/orderSales';
    $.ajax({
      type: 'GET',
      url: url,
      data: {
        id: $('#providerId').val()
      },
      dataType: 'json',
      success: function(data) {
        console.log(data);
      }
    });
  }
  getList();
  getList2();
  getList3();
  /**
   **分页实现
   */
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
    getList();
    return false;
  });
  $(document).on('click', '#pageContainer2 li', function(e) {
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
    getList();
    return false;
  });
  /*选择规格*/
  $(document).on('click', '#specDiv a', function(e) {
    //变更重量、单价、库存数
    $('#weight').html($(this).attr("wid"));
    $('#stock').html($(this).attr("sid"));
    $('#price').html('单价：<span class="lead text-danger"><strong class="colorOrange">￥' + $(this).attr("sid") + '</strong></span>');

    //更改其他规格的按钮样式
    $('#specDiv a').removeClass("active");
    $(this).addClass("active");
    specificationId = $(this).attr("sname");
    specification = $(this).html();
    price = $(this).attr("sid");
  });

  /*立即购买*/
  $(document).on('click', '#orderConfirm', function(e) {

    if (specificationId == undefined) {
      alert("请选择规格!");
    } else {
      window.location.href = app.approot + 'www/supplierOrder/orderBuy?merchandiseId=' + $('#merchandiseId').val() + '&specificationId=' + specificationId + '&specification=' + specification + '&material=' + $('#material').html() + '&name=' + $(
        '#name').html() + '&cateName=' + $('#cateName').html() + '&price=' + price + '&amount=' + $('#inputNumber').val() + '&weight=' + $('#weight').html();
    }
  });

  /*加入购物车*/
  $(document).on('click', '#addCart', function(e) {
    var data = {
      merchandiseId: $('#merchandiseId').val(),
      providerId: $('#providerId').val(),
      specificationId: specificationId,
      price: price,
      amount: $('#inputNumber').val()
    };
    if (specificationId == 'undefined') {
      alert("请选择规格!");
    } else {
      var url = app.approot + 'www/cart/addCart';
      $.ajax({
        type: 'POST',
        url: url,
        data: data,
        dataType: 'json',
        success: function(data) {
          alert("加入购物车成功！");
        }
      });
    }
  });

  /*收藏*/
  $(document).on('click', '#collection', function(e) {
    var id = $('#merchandiseId').val();
    var spec = specificationId;
    if (spec == 'undefined') {
      alert("请选择规格!");
    } else {
      var url = app.approot + 'www/merchandise/collection?merchandiseId=' + id;
      $.ajax({
        type: 'POST',
        url: url,
        data: {},
        dataType: 'json',
        success: function(data) {
          alert(data.msg);
        }
      });
    }
  });

  //收藏店铺
  $(document).on('click', '#providerCollection', function(e) {
    var url = app.approot + "www/provider/collection?providerId=" + $(this).attr('sid');
    $.ajax({
      type: 'POST',
      url: url,
      data: {},
      dataType: 'json',
      success: function(data) {
        alert(data.msg);
      }
    });
  });

  //本店搜索
  $("#btnInside").click(function(e) {
    var url = app.approot + 'www/provider/index?' + encodeURI($("#formInside").serialize());
    console.log(url);
    document.location = url;
  });
});
