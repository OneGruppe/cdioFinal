/**
 * createUser.js
 */

$(document).ready(function() {
	
	$("#creatingUser").click(function() {
		console.log("ALERT");
		$.ajax({
			url: "/cdio_final/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				console.log(data);
				
				/*if(data == "User succesfully created") 
				{
					alert(data);
				}
				else {alert(data);}*/
			}
		});
		return false;
	});
});