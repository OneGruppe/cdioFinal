/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingProductBatch").click(function() {
		$.ajax({
			url: "/cdio_final/rest/prodBatch/createProductBatch",
			data: $('#createProdForm').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				alert(data);
			}
		});
		return false;
	});
});