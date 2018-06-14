/**
 * 
 */

$(document).ready(function() {
	$("#findProductBatch").click(function() {
			
		$.ajax({
			url:"/rest/prodBatch/getProductBatch",
			data: $('#findProdForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success:function(data) {
				
				console.log(data);
				
				if(data.id != undefined)
				{
					if(document.contains(document.getElementById("showProdTable")))
					{
						document.getElementById("showProdTable").remove();
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Produktbatch ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Status";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
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
						c.innerHTML = "Produktbatch ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Status";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
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