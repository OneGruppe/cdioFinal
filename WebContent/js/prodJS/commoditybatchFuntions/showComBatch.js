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
				if(data.pbID != undefined)
				{
					if(document.contains(document.getElementById("showComTable")))
					{
						
						document.getElementById("showComTable").remove();
						var t, r, c;
						
						
						t = document.createElement("table");
						t.setAttribute("id", "showComTable");
						
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

						
						document.getElementById("showCom").appendChild(t);
							
					} 
					else
					{
						var t, r, c;
						
						
						t = document.createElement("table");
						t.setAttribute("id", "showComTable");
						
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