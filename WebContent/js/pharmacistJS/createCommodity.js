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
			error: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});