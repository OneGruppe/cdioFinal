/**
 * 
 */

$(document).ready(function() {
	$("#navigateToEditUser").click(function() {
		
		$.ajax({
			url:"/rest/user/getUser",
			data: $('#findUserForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success:function(data) {
				alert(data.message);
				$("#lockedID").attr("value", data.ID);
				$("#setName").attr("value", data.name);
				$("#setIni").attr("value", data.ini);
				
			}	
		});
		return false;
	})
	
	$("#editUser").click(function() {
		$.ajax({
			url: "/rest/user/updateUser",
			data: $('#editUserForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				alert(xhr.status);
			},
			success: function(data) {
				alert(data.message);
			}
		});
		return false;
	})
})
