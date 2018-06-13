/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToFindSingleComp").click(function() {
		
			$.ajax({
				url:"/rest/prodBatchComponent/getSingleProductBatchComponent",
				data: $('#findSingleProdCompForm').serialize(),
				dataType: "json",
				contenttype: "application/json",
				method: "POST",
				error: function(data) {
					console.log(data)
				},
				success:function(data) {
				
					console.log(data);
					
						if(document.contains(document.getElementById("showProdCompSingleTable")))
						{
							document.getElementById("showProdCompSingleTable").remove();
							var t, r, c;
						
							t = document.createElement("table");
							t.setAttribute("id", "showProdCompSingleTable");
						
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
						
							r = t.insertRow(1);
							
							c = r.insertCell(0);
							c.innerHTML = data.id;
							
							c = r.insertCell(1);
							c.innerHTML = data.commodityBatchID;
							
							c = r.insertCell(2);
							c.innerHTML = data.productbatchID;
							
							c = r.insertCell(3);
							c.innerHTML = data.userID;
							
							c = r.insertCell(4);
							c.innerHTML = data.tara;
							
							c = r.insertCell(5);
							c.innerHTML = data.netto;

						
							document.getElementById("showProd").appendChild(t);
							
						} 
						else
						{
						
							var t, r, c;
						
							t = document.createElement("table");
							t.setAttribute("id", "showProdCompSingleTable");
						
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
							
							r = t.insertRow(1);
								
							c = r.insertCell(0);
							c.innerHTML = data.id;
								
							c = r.insertCell(1);
							c.innerHTML = data.commodityBatchID;
								
							c = r.insertCell(2);
							c.innerHTML = data.productbatchID;
								
							c = r.insertCell(3);
							c.innerHTML = data.userID;
								
							c = r.insertCell(4);
							c.innerHTML = data.tara;
								
							c = r.insertCell(5);
							c.innerHTML = data.netto;
	
							
							document.getElementById("showProd").appendChild(t);
						}
			
				}
				
			});
			return false;
		})
})