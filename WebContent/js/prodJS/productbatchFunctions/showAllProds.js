/**
 * 
 */

$(document).ready(function() {
	
	$('#navigateToShowProdBatch').click(function() {
		
		$.ajax({
			url:"/rest/prodBatch/getAllProductBatches",
			data: $('#findProdForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			error: function(xhr) {
				console.log(xhr.responseText);
				alert(xhr.status);
			},
			success:function(data) {
				
				if(document.contains(document.getElementById("showProdsTable")))
				{
					document.getElementById("showProdsTable").remove();
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showProdsTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Produktbatch ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Recept ID";
					
					c = r.insertCell(2);
					c.innerHTML = "Status";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data[0][i].status;

					}
					
					document.getElementById("showProds").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showProdsTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Produktbatch ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Recept ID";
					
					c = r.insertCell(2);
					c.innerHTML = "Status";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data[0][i].status;

					}
					
					document.getElementById("showProds").appendChild(t);
				}
			}
		});
		return false;
	});
});
	