/**
 * 
 */

$(document).ready(function() {
	$("#findUser").click(function() {
			
		$.ajax({
			url:"/cdio_final/rest/user/getUser",
			data: $('#findUserForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				alert(data);
				console.log(data.ini);
			}
		});
		return false;
	})
})
	