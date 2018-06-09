/**
 * 
 */

$(document).ready(function() {
	$("#findCommodityBatch").click(function() {
			
		$.ajax({
			url:"/cdio_final/rest/comBatch/getCommodityBatch",
			data: $('#findComForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				console.log(data);
				if(data.cbID != undefined)
				{
					if(document.contains(document.getElementById("showComTable")))
					{
						
						document.getElementById("showComTable").remove();
						var t, r, c;
						
						
						t = document.createElement("table");
						t.setAttribute("id", "showComTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Råvarebatch ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Råvare ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Leverandør ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Mængde";
						

						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.cbID;
						
						c = r.insertCell(1);
						c.innerHTML = data.commodityID;
						
						c = r.insertCell(2);
						c.innerHTML = data.supplierID;
						
						c = r.insertCell(3);
						c.innerHTML = data.amount;

						
						document.getElementById("showCom").appendChild(t);
							
					} 
					else
					{
						var t, r, c;
						
						
						t = document.createElement("table");
						t.setAttribute("id", "showComTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Råvarebatch ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Råvare ID";
						
						c = r.insertCell(2);
						c.innerHTML = "Leverandør ID";
						
						c = r.insertCell(3);
						c.innerHTML = "Mængde";
						

						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.cbID;
						
						c = r.insertCell(1);
						c.innerHTML = data.commodityID;
						
						c = r.insertCell(2);
						c.innerHTML = data.supplierID;
						
						c = r.insertCell(3);
						c.innerHTML = data.amount;

						
						document.getElementById("showCom").appendChild(t);
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