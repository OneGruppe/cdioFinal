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
				alert(xhr.status);
			},
			success: function(data) {
				alert(data.message);
			}
		});
		return false;
	});
});