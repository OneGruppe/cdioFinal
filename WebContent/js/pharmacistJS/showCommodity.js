/**
 * 
 */

$(document).ready(function() {
	$("#findCommodity").click(function() {
			
		$.ajax({
			url:"/rest/commodity/getCommodity",
			data: $('#findCommodityForm').serialize(),
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
					if(document.contains(document.getElementById("showComTable")))
					{
						document.getElementById("showComTable").remove();
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showComTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Råvare ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Råvare navn";
						
						c = r.insertCell(2);
						c.innerHTML = "Leverandør ID";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
						c = r.insertCell(1);
						c.innerHTML = data.name;
						
						c = r.insertCell(2);
						c.innerHTML = data.supplierID;

						
						document.getElementById("showCommodity").appendChild(t);
							
					} 
					else
					{
						
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showComTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Råvare ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Råvare Navn";
						
						c = r.insertCell(2);
						c.innerHTML = "Leverandør ID";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
						c = r.insertCell(1);
						c.innerHTML = data.name;
						
						c = r.insertCell(2);
						c.innerHTML = data.supplierID;

						
						document.getElementById("showCommodity").appendChild(t);
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