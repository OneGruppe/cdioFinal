/**
 * 
 */

$(document).ready(function() {
	$("#navigateToEditUser").click(function() {
		
		$.ajax({
			url:"/cdio_final/rest/user/getUser",
			data: $('#findUserForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				
				$("#lockedID").attr("value", data.ID);
				$("#setName").attr("value", data.name);
				$("#setIni").attr("value", data.ini);
				
			}	
		});
		return false;
	})
	
	$("#editUser").click(function() {
		$.ajax({
			url: "/cdio_final/rest/user/updateUser",
			data: $('#editUserForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				alert("User succesfully created");
			}
		});
		return false;
	})
})
