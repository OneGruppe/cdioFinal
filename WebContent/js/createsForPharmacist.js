/**
 *  Create functions for pharmacists
 */

$(document).ready(function() {
	
	$("#creatingCommodity").click(function() {
		$.ajax({
			url: "/cdio_final/rest/user/createUser",
			data: $('#createCommodityForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				alert("Commodity succesfully created");
			}
		});
		return false;
	});
});