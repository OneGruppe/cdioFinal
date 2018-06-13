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
			success:function(data) {
				console.log(data);
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
			success: function(data) {
				alert("Brugerens information er blevet ændret!");
			}
		});
		return false;
	})
})
