/**
 * 
 */

$(document).ready(function() {

	$("#navigateToSetUser").click(function() {

		$.ajax({
			url : "/rest/user/getUser",
			data : $('#findUserForm').serialize(),
			contenttype : "application/json",
			method : "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success : function(data) {
				alert(data.message);
				$("#setID").attr("value", data.ID);
				$("#setStatus").attr("value", data.active);

			}
		});
		return false;
	})

	$("#setUser").click(function() {
		
		$.ajax({
			url : "/rest/user/setUserState",
			data : $('#setUserForm').serialize(),
			dataType : "json",
			contenttype : "application/json",
			method : "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success : function(data) {
				alert(data.message);
			}
		});
		return false;
	})
})