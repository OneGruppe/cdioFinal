/**
 * weight.js
 */

$(document).ready(function() {

	$("#connectToWeightButton").click(function() {
		$.ajax({
			url: "/rest/weight/doConnection",
			data: $('#connectToWeight').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "POST",
			success: function(data) {
				alert(data.message);
			}
		});
		return false;
	});
});