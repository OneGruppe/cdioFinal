/**
 * createUser.js
 */

$(document).ready(function() {
	
	$("#creatingUser").click(function() {
		$.ajax({
			url: "/cdio_final/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				alert("User succesfully created");
			}
		});
		return false;
	});
});