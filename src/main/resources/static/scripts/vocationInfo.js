$('.forLeave').click(function() {
		var vocation = $(this).parent().parent().children("td").get(0);
		var vocationId = vocation.innerText;
		var user = $(this).parent().parent().children("td").get(1);
		var userId = user.innerText;
		var url = "../index/toLeave";
		$(this).attr("href", url);
	});
