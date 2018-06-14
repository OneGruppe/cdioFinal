/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingProductBatch").click(function() {
		$.ajax({
			url: "/rest/prodBatch/createProductBatch",
			data: $('#createProdForm').serialize(),
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