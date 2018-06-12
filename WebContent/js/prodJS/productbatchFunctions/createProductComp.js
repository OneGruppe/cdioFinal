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
			success: function(data) {
				alert("Produktbatch Komponenten er oprettet");
			}
		});
		return false;
	});
});