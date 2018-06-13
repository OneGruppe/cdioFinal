/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToShowCommodity").click(function() {
		
		$.ajax({
			url:"/cdio_final/rest/commodity/getAllCommodities",
			data: $('#findCommodityForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			success:function(data) {
				console.log(data);
				
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
					c.innerHTML = "Råvare Navn";
					
					c = r.insertCell(2);
					c.innerHTML = "Leverandør ID";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;

						c = r.insertCell(2);
						c.innerHTML = data[0][i].supplierID;

					}
					
					document.getElementById("showCommodities").appendChild(t);
						
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
					c.innerHTML = "Råvare navn";
					
					c = r.insertCell(2);
					c.innerHTML = "Leverandør ID";
										

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;

						c = r.insertCell(2);
						c.innerHTML = data[0][i].supplierID;
			

					}
					
					document.getElementById("showCommodities").appendChild(t);

				}
			}
		});
		return false;
	});
});