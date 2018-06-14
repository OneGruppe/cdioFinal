/**
 * 
 */

$(document).ready(function() {

	$("#creatingRecipe").click(function() {
		$.ajax({
			url: "/rest/recipe/createRecipe",
			data: $('#createRecipeForm').serialize(),
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