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
			success : function(data) {
				console.log(data);
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
			success : function(data) {
				console.log(data);
				alert("Brugerens status er blevet ændret!");
			}
		});
		return false;
	})
})