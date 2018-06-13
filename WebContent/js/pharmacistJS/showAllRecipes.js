/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToShowRecipe").click(function() {
		
		$.ajax({
			url:"/rest/recipe/getAllRecipes",
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
					
					c = r.insertCell(1);
					c.innerHTML = "Recept navn";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;

					}
					
					document.getElementById("showRecipes").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showRecipeTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Rececpt ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Recept navn";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;

					}
					
					document.getElementById("showRecipes").appendChild(t);

				}
			}
		});
		return false;
	});
});