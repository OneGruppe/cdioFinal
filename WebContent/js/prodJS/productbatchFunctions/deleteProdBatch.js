/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToDeleteProd").click(function() {
		
		$.ajax({
			url:"/rest/prodBatch/deleteProductBatch",
			data: $('#findProdForm').serialize(),
			contenttype: "application/json",
			method: "DELETE",
			success:function(data) {
				
				alert("Batch slettet");
			}	
		});
		return false;
	})
})