/**
 * 
 */

$(document).ready(function() {

	$("#navigateToSetUser").click(function() {

		$.ajax({
			url : "/cdio_final/rest/user/getUser",
			data : $('#findUserForm').serialize(),
			contenttype : "application/json",
			method : "POST",
			success : function(data) {

				$("#setID").attr("value", data.ID);
				$("#setStatus").attr("value", data.active);

			}
		});
		return false;
	})

	$("#setUser").click(function() {
		
		$.ajax({
			url : "/cdio_final/rest/user/setUserState",
			data : $('#setUserForm').serialize(),
			dataType : "json",
			contenttype : "application/json",
			method : "POST",
			success : function(data) {
				alert("User succesfully created");
			}
		});
		return false;
	})
})