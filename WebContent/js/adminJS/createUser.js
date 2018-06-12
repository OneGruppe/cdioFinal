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
			success: function(data) {
				alert("Brugeren er oprettet");
			}
		});
		return false;
	});
});