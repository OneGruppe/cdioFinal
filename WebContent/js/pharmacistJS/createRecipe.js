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
				alert("Recepten er oprettet");
			}
		});
		return false;
	});
});
