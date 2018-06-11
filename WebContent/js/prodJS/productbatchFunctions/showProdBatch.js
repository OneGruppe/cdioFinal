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
				
				console.log(data);
				
				if(data.pbID != undefined)
				{
					if(document.contains(document.getElementById("showProdTable")) && document.contains(document.getElementById("commodityNameTitle")))
					{
						document.getElementById("commodityNameTitle").remove();
						document.getElementById("showProdTable").remove();
						var t, r, c, h;
						
						h = document.createElement("h3");
						h.setAttribute("id", "commodityNameTitle");
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdTable");
						
						h.innerHTML = "Råvarenavn: " + data.comName;
						
						document.getElementById("showProd").appendChild(h);
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Produktbatch ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Produktbatch komponent ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Råvarebatch ID";
						
						c = r.insertCell(4);
						c.innerHTML = "Bruger ID";
						
						c = r.insertCell(5);
						c.innerHTML = "Navn";
						
						c = r.insertCell(6);
						c.innerHTML = "Tara";
						
						c = r.insertCell(7);
						c.innerHTML = "Netto";
						
						c = r.insertCell(8);
						c.innerHTML = "Status";
						
					
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.pbID;
						
						c = r.insertCell(1);
						c.innerHTML = data.recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data.pbcID;
						
						c = r.insertCell(3);
						c.innerHTML = data.comBatchID;
						
						c = r.insertCell(4);
						c.innerHTML = data.userID;
						
						c = r.insertCell(5);
						c.innerHTML = data.name;
						
						c = r.insertCell(6);
						c.innerHTML = data.tara;
						
						c = r.insertCell(7);
						c.innerHTML = data.netto;
						
						c = r.insertCell(8);
						c.innerHTML = data.status;

						
						document.getElementById("showProd").appendChild(t);
							
					} 
					else
					{
						
						var t, r, c, h;
						
						h = document.createElement("h3");
						h.setAttribute("id", "commodityNameTitle");
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdTable");
						
						h.innerHTML = "Råvarenavn: " + data.comName;
						
						document.getElementById("showProd").appendChild(h);
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Produktbatch ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Recept ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Produktbatch komponent ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Råvarebatch ID";
						
						c = r.insertCell(4);
						c.innerHTML = "Bruger ID";
						
						c = r.insertCell(5);
						c.innerHTML = "Navn";
						
						c = r.insertCell(6);
						c.innerHTML = "Tara";
						
						c = r.insertCell(7);
						c.innerHTML = "Netto";
						
						c = r.insertCell(8);
						c.innerHTML = "Status";
						
					
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.pbID;
						
						c = r.insertCell(1);
						c.innerHTML = data.recipeID;
						
						c = r.insertCell(2);
						c.innerHTML = data.pbcID;
						
						c = r.insertCell(3);
						c.innerHTML = data.comBatchID;
						
						c = r.insertCell(4);
						c.innerHTML = data.userID;
						
						c = r.insertCell(5);
						c.innerHTML = data.name;
						
						c = r.insertCell(6);
						c.innerHTML = data.tara;
						
						c = r.insertCell(7);
						c.innerHTML = data.netto;
						
						c = r.insertCell(8);
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