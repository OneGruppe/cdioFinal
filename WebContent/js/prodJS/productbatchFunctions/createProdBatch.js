/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingProductBatch").click(function() {
		$.ajax({
			url: "/cdio_final/rest/prodBatch/createProductBatch",
			data: $('#createProdForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				alert("Produktbatch er oprettet");
			}
		});
		return false;
	});
});