/**
 * weight.js
 */

$(document).ready(function() {

	$("#connectToWeightButton").click(function() {
		alert("Knap WANG")
		$.ajax({
			url: "/rest/weight/doConnection",
			data: $('#connectToWeight').serialize(),
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