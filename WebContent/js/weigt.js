/**
 * weight.js
 */

$(document).ready(function() {

	$("#connectToWeight").click(function() {
		$.ajax({
			url: "/rest/Weight/doConnection",
			data: $('#').serialize(),
			contenttype: "application/x-ww-form-urlencoded",
			method: "PUT",
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});