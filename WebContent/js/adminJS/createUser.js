/**
 * createUser.js
 */

$(document).ready(function() {

	$("#creatingUser").click(function() {
		$.ajax({
			url: "/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				console.log(data);
				alert("Brugeren er oprettet");
			}
		});
		return false;
	});
});