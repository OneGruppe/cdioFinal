/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToEditCom").click(function() {
		
		$.ajax({
			url:"/cdio_final/rest/comBatch/getSingleCommodity",
			data: $('#findComForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				console.log(data);
				
				$("#setID").attr("value", data.id);
				$("#setCommodityID").attr("value", data.commodityID);
				$("#setAmount").attr("value", data.amount);
				
			}	
		});
		return false;
	})
	
	$("#editCom").click(function() {
		
		$.ajax({
			url: "/cdio_final/rest/comBatch/updateCommodityBatch",
			data: $('#editComForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success: function(data) {
				console.log(data);
				
				alert("Batchet blev ændret");
			}
		});
		return false;
	})
})