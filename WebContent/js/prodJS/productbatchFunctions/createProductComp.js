/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingProductComp").click(function() {
		$.ajax({
			url: "/rest/prodBatchComponent/createProductBatchComponent",
			data: $('#createProdCompForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			error: function(xhr) {
				alert(xhr.responseText);
				console.log(xhr.status);
			},
			success: function(data) {
				alert(data.message);
			}
		});
		return false;
	});
});