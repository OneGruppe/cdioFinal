/**
 * createUser.js
 */

$(document).ready(function() {

	$("#creatingUser").click(function() {
		$.ajax({
			url: "/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			dataType: "json",
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				alert(xhr.status);
			},
			success: function(data) {
				alert(data.message);
			}
		});
		return false;
	});
});