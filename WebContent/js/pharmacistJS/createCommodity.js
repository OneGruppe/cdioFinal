/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingCommodty").click(function() {
		$.ajax({
			url: "/rest/commodity/createCommodity",
			data: $('#createCommodityForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				console.log(data);
				alert("Råvaren er oprettet");
			}
		});
		return false;
	});
});