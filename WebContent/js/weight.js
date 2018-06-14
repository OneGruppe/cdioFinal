/**
 * weight.js
 */

$(document).ready(function() {

	$("#weight1con").click(function() {
		alert("Knap WANG")
		$.ajax({
			url: "/rest/weight/doConnection",
			data: $('#weight1con').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
	
	$("#weight2con").click(function() {
		alert("Knap TZU")
		$.ajax({
			url: "/rest/weight/doConnection",
			data: $('#weight2con').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});