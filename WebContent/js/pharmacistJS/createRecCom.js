/**
 * 
 */

$(document).ready(function() {
	
	$("#creatingRecipeComponent").click(function() {
		$.ajax({
			url: "/rest/recipeComponent/createRecipeComponent",
			data: $('#createRecipeComponentForm').serialize(),
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