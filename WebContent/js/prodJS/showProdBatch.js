/**
 * 
 */

$(document).ready(function() {
	$("#findProductBatch").click(function() {
			
		$.ajax({
			url:"/cdio_final/rest/prodBatch/getProductBatch",
			data: $('#findProdForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				if(data.pbID != undefined)
				{
					if(document.contains(document.getElementById("showProdTable")))
					{
						
						document.getElementById("showProdTable").remove();
						var t, r, c;
						
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Status";
						

						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.pbID;
						
						c = r.insertCell(1);
						c.innerHTML = data.recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data.status;

						
						document.getElementById("showProd").appendChild(t);
							
					} 
					else
					{
						var t, r, c;
						
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Status";
						

						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.pbID;
						
						c = r.insertCell(1);
						c.innerHTML = data.recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data.status;

						
						document.getElementById("showProd").appendChild(t);
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