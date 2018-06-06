/**
 * createUser.js
 */

$(document).ready(function() {
	
	$("#creatingUser").click(function() {
		alert("HEJ DU");
		$.ajax({
			url: "rest/user/createUser",
			data: $('.createUserForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "PUT",
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