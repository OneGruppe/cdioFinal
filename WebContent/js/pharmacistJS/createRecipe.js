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
				console.log(xhr.status);
			},
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});