$(document).ready(function() {
	$('#login_submit').click(function() {
		var userName = $('#inputUser').val();
		var password = $('#inputPassword').val();
		if (userName.length == 0) {
			alert("请输入用户名！");
		} else if (password.length == 0) {
			alert("密码不能为空！");
		} else {
			$('#login_form').attr("action", "../user/dologin");
			$('#login_form').submit();
		}
	});
});