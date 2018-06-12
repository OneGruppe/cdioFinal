/**
 * createUser.js
 */

$(document).ready(function() {

	$("#creatingUser").click(function() {
		$.ajax({
			url: "/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			error: function(data) {
				console.log("rofl");
			},
			success: function(data) {
				console.log(data);
				alert("Brugeren er oprettet");
			}
		});
		return false;
	});
});