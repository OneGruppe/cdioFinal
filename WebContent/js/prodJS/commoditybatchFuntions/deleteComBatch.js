/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToDeleteCom").click(function() {
		
		$.ajax({
			url:"/cdio_final/rest/comBatch/deleteCommodityBatch",
			data: $('#findComForm').serialize(),
			contenttype: "application/json",
			method: "DELETE",
			success:function(data) {
				
				alert("Batch slettet");
			}	
		});
		return false;
	})
})