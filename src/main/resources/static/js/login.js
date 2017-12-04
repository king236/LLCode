$(document).ready(function() {
	$("input").keydown(function(event) {
		if (event.which == 13) {
			checkLogin();
		}
	});
});

function checkLogin() {
	var username = $("input[name=username]").val();
	var password = $("input[name=password]").val();
	$("#loginResult").addClass("text-danger");
	if (isNull(username)) {
		$("#loginResult").text("请输入用户名！");
	} else if (hasBlank(username)) {
		$("#loginResult").text("用户名中不能含有空格！");
	} else if (isNull(password)) {
		$("#loginResult").text("请输入密码！");
	} else if (hasBlank(password)) {
		$("#loginResult").text("密码中不能含有空格！");
		// } else if (password.length < 6) {
		// $("#loginResult").text("请输入至少6位密码");
	} else {
		doLogin();
	}
}

function doLogin() {
	$("#loginResult").addClass("text-primary");
	$("#loginResult").text("登录中...");
	$.ajax({
		type : 'post',
		url : loginUrl,
		data : {
			'username' : $("input[name=username]").val(),
			'password' : $("input[name=password]").val()
		},// 传给后台的数据
		dataType : 'json',// 服务器返回的数据类型 可选XML ,Json jsonp script html text等
		success : function(data) {
			if (data.result == 'success') {
				$("#loginResult").addClass("text-success");
				$("#loginResult").text("登录成功。页面跳转中……");
				window.location.href = redirectUrl;
			} else {
				$("#loginResult").addClass("text-danger");
				$("#loginResult").text(data.errmsg);
			}
		},
		error : function() {
			$("#loginResult").addClass("text-danger");
			$("#loginResult").text("登录失败，请刷新页面重试。");
		}
	});
}