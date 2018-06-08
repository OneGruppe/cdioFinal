/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToDeleteProd").click(function() {
		
		$.ajax({
			url:"/cdio_final/rest/prodBatch/deleteProductBatch",
			data: $('#findProdForm').serialize(),
			contenttype: "application/json",
			method: "DELETE",
			success:function(data) {
				alert("Batch slette");
			}	
		});
		return false;
	})
})