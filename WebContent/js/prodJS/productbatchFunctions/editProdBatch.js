/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToEditProd").click(function() {
		
		$.ajax({
			url:"/rest/prodBatch/getProductBatch",
			data: $('#findProdForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				
				$("#setProdID").attr("value", data.id);
				$("#setReceptID").attr("value", data.recipeID);
				$("#setStatus").attr("value", data.status);
				
			}	
		});
		return false;
	})
	
	$("#editProd").click(function() {
		
		$.ajax({
			url: "/rest/prodBatch/updateProductBatch",
			data: $('#editProdForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				
				alert("Batchet blev ændret");
			}
		});
		return false;
	})
})