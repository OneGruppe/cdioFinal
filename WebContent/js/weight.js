/**
 * weight.js
 */

$(document).ready(function() {

	$("#connectToWeight").click(function() {
		$.ajax({
			url: "/rest/weight/doConnection",
			data: $('#').serialize(),
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