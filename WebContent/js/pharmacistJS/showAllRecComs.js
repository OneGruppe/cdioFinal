/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToShowRecipe").click(function() {
		
		$.ajax({
			url:"/rest/RecipeComponent/getAllRecipeComponents",
			data: $('#findRecipeComponentForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			success:function(data) {
				console.log(data);
				
				if(document.contains(document.getElementById("showRecComTable")))
				{
					document.getElementById("showRecComTable").remove();
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showRecComTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Recept komponent ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Recept ID";
					
					c = r.insertCell(2);
					c.innerHTML = "Råvare ID";

					c = r.insertCell(3);
					c.innerHTML = "Netto vægt";
					
					c = r.insertCell(4);
					c.innerHTML = "Tolerance";



					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data[0][i].commodityID;
						
						c = r.insertCell(3);
						c.innerHTML = data[0][i].nonNetto;
						
						c = r.insertCell(4);
						c.innerHTML = data[0][i].tolerance;

					}
					
					document.getElementById("showRecComs").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showRecipeTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Recept komponent ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Recept ID";
					
					c = r.insertCell(2);
					c.innerHTML = "Råvare ID";

					c = r.insertCell(3);
					c.innerHTML = "Netto vægt";
					
					c = r.insertCell(4);
					c.innerHTML = "Tolerance";
					
					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data[0][i].commodityID;
						
						c = r.insertCell(3);
						c.innerHTML = data[0][i].nonNetto;
						
						c = r.insertCell(4);
						c.innerHTML = data[0][i].tolerance;

					}
					
					document.getElementById("showRecComs").appendChild(t);

				}
			}
		});
		return false;
	});
});