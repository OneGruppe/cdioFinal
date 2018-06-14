/**
 * createUser.js
 */

$(document).ready(function() {
	var status = document.getElementById("#userStatus");
	$("#creatingUser").click(function() {
		if($(status).val() < 0) 
		{
            $(status).val('0');
        } 
		else if($(status).val > 1) 
		{
        	$(status).val('1');
        }
		
		$.ajax({
			url: "/rest/user/createUser",
			data: $('#createUserForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});