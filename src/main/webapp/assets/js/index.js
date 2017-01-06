/**
 * @author 张镇涛
 */
$(function(){
	$.ajax({
		url:'isLogin',
		dataType:'json',
		success:function(data){
			if(data['result'] == "true"){
				$("#navul").html('<li class="dropdown user-dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>&nbsp;&nbsp; '+data['userName']+' &nbsp;&nbsp;<b class="caret"></b></a>'
				+'<ul class="dropdown-menu"><li><a href="index.html?innerPath=profile.html"><i class="fa fa-user"></i> Profile</a></li><li class="divider"></li>'
						+'<li><a href="logout"><i class="fa fa-power-off"></i> Log Out</a></li></ul></li>');
			}else{
				$("#navul").html('<li><a href="login.html"><i class="fa fa-hand-o-right"></i> Log In &nbsp;&nbsp;&nbsp;&nbsp;</a></li>');
			}
		},
		error:function(){
			
		}
	});
	var url = location.search;
	if(url.indexOf("?")!=-1){
		var str = url.substr(1);
		$("#inner").attr("data",str.split("=")[1]);
	}else{
		$("#inner").attr("data","welcome.html");
	}
})