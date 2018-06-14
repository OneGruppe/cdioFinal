/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingSupplier").click(function() {
		$.ajax({
			url: "/rest/supplier/createSupplier",
			data: $('#createSupplierForm').serialize(),
			contenttype: "application/json",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success: function(data) {
				alert("Leverandøren er oprettet");
			}
		});
		return false;
	});
});