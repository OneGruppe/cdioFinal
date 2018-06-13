/**
 * 
 */

$(document).ready(function() {
	$("#findProductBatchComp").click(function() {
			
		$.ajax({
			url:"/rest/prodBatchComponent/getProductBatchComponent",
			data: $('#findProdCompForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				
				console.log(data);
					if(document.contains(document.getElementById("showProdCompTable")))
					{
						document.getElementById("showProdCompTable").remove();
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdCompTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Produktbatch Komponent ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Råvarebatch ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Produktbatch ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Bruger ID";
						
						c = r.insertCell(4);
						c.innerHTML = "Tara";
						
						c = r.insertCell(5);
						c.innerHTML = "Netto";
						
						for(var i = 0; i < data[0].length; i++)
						{
							
							r = t.insertRow(1);
							
							c = r.insertCell(0);
							c.innerHTML = data[0][i].id;
							
							c = r.insertCell(1);
							c.innerHTML = data[0][i].commodityBatchID;
							
							c = r.insertCell(2);
							c.innerHTML = data[0][i].productbatchID;
							
							c = r.insertCell(3);
							c.innerHTML = data[0][i].userID;
							
							c = r.insertCell(4);
							c.setAttribute("step", "any");
							c.innerHTML = data[0][i].tara;
							
							c = r.insertCell(5);
							c.setAttribute("step", "any");
							c.innerHTML = data[0][i].netto;
						}

						
						document.getElementById("showProd").appendChild(t);
							
					} 
					else
					{
						
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showProdCompTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Produktbatch Komponent ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Råvarebatch ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Produktbatch ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Bruger ID";
						
						c = r.insertCell(4);
						c.innerHTML = "Tara";
						
						c = r.insertCell(5);
						c.innerHTML = "Netto";
						
						
						for(var i = 0; i < data[0].length; i++)
						{
							
							r = t.insertRow(1);
							
							c = r.insertCell(0);
							c.innerHTML = data[0][i].id;
							
							c = r.insertCell(1);
							c.innerHTML = data[0][i].commodityBatchID;
							
							c = r.insertCell(2);
							c.innerHTML = data[0][i].productbatchID;
							
							c = r.insertCell(3);
							c.innerHTML = data[0][i].userID;
							
							c = r.insertCell(4);
							c.setAttribute("step", "any");
							c.innerHTML = data[0][i].tara;
							
							c = r.insertCell(5);
							c.setAttribute("step", "any");
							c.innerHTML = data[0][i].netto;
						}

						
						document.getElementById("showProd").appendChild(t);
					}
		
			}
				
		});
		return false;
	})
})