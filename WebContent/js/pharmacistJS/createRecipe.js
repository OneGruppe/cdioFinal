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
			success: function(data) {
				console.log(data);
				alert(data);
			}
		});
		return false;
	});
});