/**
 * 
 */

$(document).ready(function() {
	$("#findRecipeComponent").click(function() {
			
		$.ajax({
			url:"/rest/recipeComponent/getRecipeComponent",
			data: $('#findRecipeComponentForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
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
						c.innerHTML = "Recept Komponent ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Råvare ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Non Netto";
						
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
							c.innerHTML = (data[0][i].non_netto).toFixed(4);
							
							c = r.insertCell(4);
							c.innerHTML = (data[0][i].tolerance).toFixed(4);
							
						}

						
						document.getElementById("showRecCom").appendChild(t);
							
					} 
					else
					{
						
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showRecComTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Recept Komponent ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Råvare ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Non Netto";
						
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
							c.innerHTML = (data[0][i].non_netto).toFixed(4);
							
							c = r.insertCell(4);
							c.innerHTML = (data[0][i].tolerance).toFixed(4);
							
						}

						
						document.getElementById("showRecCom").appendChild(t);
					}
		
			}
				
		});
		return false;
	})
})