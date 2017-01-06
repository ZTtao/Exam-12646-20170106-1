/**
 * @author 张镇涛
 */
$(function(){
    $.ajax({
        url:'isLogin',
        dataType:'json',
        success:function(data){
            if(data['result'] == "true"){
            	$("#h1").html('Welcome,&nbsp;&nbsp;'+data['userName']);
            }
        },
        error:function(){
            
        }
    });
})