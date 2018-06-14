/**
 * createUser.js
 */

$(document).ready(function() {

	$("#creatingUser").click(function() {
		$.ajax({
			url: "/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			datatype: "application/json",
			contenttype: "text/plain",
			method: "PUT",
			error: function(data) {
				console.log(data);
			},
			success: function(data) {
				console.log(data);
			}
		});
		return false;
	});
});