$(document).ready(function() {
	$.ajax({
		url:'http://localhost:8080/user/account?u=user',
		type:'get',
		crossDomain: true,
		xhrFields: {
			withCredentials: true
		},
		headers: {  'Access-Control-Allow-Origin': '*' },
		async:false,
		complete:function(data, textStatus){
			var d = data.status;
			$(".sort").hide();
			if (d == 200){
				var d = JSON.parse(data.responseText);
				$(".logged").show();
				$(".notlogged").hide();	
				if(d.userType == "USER") {
					$(".user").show();
					$(".admin").hide();
				}
			}else if(d == 404) {
				$(".notlogged").show(100);
				$(".logged").hide(100);
				$(".user").hide(100);
				$(".admin").hide(100);
			}
		},
		error:function(){}
	});
});
		
function logout() {
	var r = confirm("Are you sure?");
	if (r == true) {
		$.ajax({
			url:'http://localhost:8080/user/logout?u=user',
			type:'get',
			crossDomain: true,
			xhrFields: {
			    withCredentials: true
			},
			headers: {  'Access-Control-Allow-Origin': '*' },
			complete:function(data, textStatus){
				if (data.status == 200) {
					window.location.href = "/";
				}
			}
		});
	}
}