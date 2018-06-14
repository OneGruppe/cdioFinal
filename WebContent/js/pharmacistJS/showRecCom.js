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
			error: function(xhr) {
				alert(xhr.responseText);
				console.log(xhr.status);
			},
			success:function(data) {
				
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
							c.innerHTML = (data[0][i].nonNetto).toFixed(2);
							
							c = r.insertCell(4);
							c.innerHTML = data[0][i].tolerance;
							
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
							c.innerHTML = (data[0][i].nonNetto).toFixed(2);
							
							c = r.insertCell(4);
							c.innerHTML = data[0][i].tolerance;
							
						}

						
						document.getElementById("showRecCom").appendChild(t);
					}
		
			}
				
		});
		return false;
	})
})