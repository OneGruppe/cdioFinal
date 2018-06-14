/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingCommodityBatch").click(function() {
		$.ajax({
			url: "/rest/comBatch/createCommodityBatch",
			data: $('#createComForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success: function(data) {
				alert(data.message);
			}
		});
		return false;
	});
});