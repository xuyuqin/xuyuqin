$(function(){
  $('#demand-submit').click(function(){
    var data = new FormData($(this).closest('form')[0]);
    $.ajax({
      url:__appconfig.approot + 'www/demand/add',
      data:data,
      method:'POST',
      processData:false,
      contentType:false
    }).done(function(){
      console.log('demand posted');
    }).fail(function(){
      console.log('post demand failed');
    });
  });
});
