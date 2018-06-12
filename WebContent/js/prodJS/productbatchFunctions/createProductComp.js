/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingProductComp").click(function() {
		$.ajax({
			url: "/cdio_final/rest/prodBatchComponent/createProductBatchComponent",
			data: $('#createProdCompForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				alert("Produktbatch Komponenten er oprettet");
			}
		});
		return false;
	});
});