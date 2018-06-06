/**
 * createUser.js
 */

$(document).ready(function() {
	
	$('#creatingUser').click(function() {
		$.ajax({
			url: "rest/user/createUser",
			data: $('.createUserForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "PUT",
			succes: function(data) {
				if(data == "User succesfully created") 
				{
					alert(data);
				}
				else {alert(data);}
			}
		});
		return false;
	});
});