/**
 * Created by Administrator on 2017/7/10 0010.
 */
function addCart(id) {
    $.ajax({
        url: '/yun/cart/addCart',
        data:{
            merchandiseId:id
        },
        type:'get',
        success:function (msg) {
            console.log(msg);
        }
    })
}
function addCollect(id,obj) {
    $.ajax({
        url: '/yun/merchandise/collection',
        data:{
            merchandiseId:id
        },
        type:'get',
        success:function (msg) {
            console.log(msg);
            if(msg.code==0){

                if(msg.msg=='取消收藏成功'){
                    obj.find('.iconfont').css({
                        color:'#555'
                    });
                }else {
                    obj.find('.iconfont').css({
                        color:'#ff771c'
                    });
                }
            }
        }
    })
}