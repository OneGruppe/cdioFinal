/**
 * 
 */

$(document).ready(function() {
	
	$("navigateToFindRecipe").click(function() {
		
		$.ajax({
			url:"/cdio_final/rest/recipe/showAllRecipe",
			data: $('#findRecipeForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			success:function(data) {
				console.log(data);
				
				if(document.contains(document.getElementById("showRecipeTable")))
				{
					document.getElementById("showRecipeTable").remove();
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showRecipeTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Recept ID";
					
					c = r.insertCell(2);
					c.innerHTML = "Recept Name";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].recipeID;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].recipeName;

					}
					
					document.getElementById("showMulti").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showRecipeTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Rececpt ID";
					
					c = r.insertCell(2);
					c.innerHTML = "Recept Name";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].recipeID;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].recipeName;

					}
					
					document.getElementById("showMulti").appendChild(t);

				}
			}
		});
		return false;
	});
});