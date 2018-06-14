/**
 * 
 */

$(document).ready(function() {

	$("#creatingCommodity").click(function() {
		$.ajax({
			url: "/rest/commodity/createCommodity",
			data: $('#createCommodityForm').serialize(),
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
	});
});