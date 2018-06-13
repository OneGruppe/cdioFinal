/**
 * 
 */

$(document).ready(function() {
	$("#findRecipe").click(function() {
			
		$.ajax({
			url:"/rest/recipe/getRecipe",
			data: $('#findRecipeForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				
				console.log(data);
				
				if(data.id != undefined)
				{
					if(document.contains(document.getElementById("showRecTable")))
					{
						document.getElementById("showRecTable").remove();
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showRecTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept navn";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
						c = r.insertCell(1);
						c.innerHTML = data.name;

						
						document.getElementById("showRecipe").appendChild(t);
							
					} 
					else
					{
						
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showRecTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept Navn";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
						c = r.insertCell(1);
						c.innerHTML = data.name;

						
						document.getElementById("showRecipe").appendChild(t);
					}
				}
				else
				{
					alert("Ugyldigt ID blev indtastet")
				}
		
			}
				
		});
		return false;
	})
})