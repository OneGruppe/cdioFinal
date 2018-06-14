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
				console.log(xhr.status);
			},
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});