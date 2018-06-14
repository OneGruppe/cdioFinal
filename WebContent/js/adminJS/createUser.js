/**
 * createUser.js
 */

$(document).ready(function() {

	$("#creatingUser").click(function() {
		$.ajax({
			url: "/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			contenttype: "application/json",
			method: "PUT",
			success: function(data) {
				console.log(data);
			}
		});
		return false;
	});
});