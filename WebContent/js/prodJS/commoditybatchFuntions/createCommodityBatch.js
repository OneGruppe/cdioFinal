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
			success: function(data) {
				alert("Råvarebatch er oprettet");
			}
		});
		return false;
	});
});