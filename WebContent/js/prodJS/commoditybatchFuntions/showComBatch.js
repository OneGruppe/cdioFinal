/**
 * 
 */

$(document).ready(function() {
	$("#findCommodityBatch").click(function() {
			
		$.ajax({
			url:"/rest/comBatch/getCommodityBatch",
			data: $('#findComForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				
				console.log(data);
				if(document.contains(document.getElementById("showComTable")) && document.contains(document.getElementById("commodityName")))
				{
					document.getElementById("commodityName").remove();	
					document.getElementById("showComTable").remove();
					var t, r, c, h;
					
					h = document.createElement("h3");
					h.setAttribute("id", "commodityName");
					
					h.innerHTML = data.id;
					
					document.getElementById("showCom").appendChild(h);
						
					t = document.createElement("table");
					t.setAttribute("id", "showComTable");
						
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Råvarebatch ID";
						
					c = r.insertCell(1);
					c.innerHTML = "Råvare ID";
			
					c = r.insertCell(2);
					c.innerHTML = "Mængde";
						
					for(var i = 0; i < data[0].length; i++)
					{							
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
							
						c = r.insertCell(1);
						c.innerHTML = data[0][i].commodityID;
							
						c = r.insertCell(2);
						c.innerHTML = data[0][i].amount;
					}

						
					document.getElementById("showCom").appendChild(t);
							
				} 
				else
				{
					var t, r, c, h;
					
					h = document.createElement("h3");
					h.setAttribute("id", "commodityName");
						
					t = document.createElement("table");
					t.setAttribute("id", "showComTable");
						
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Råvarebatch ID";
						
					c = r.insertCell(1);
					c.innerHTML = "Råvare ID";
			
					c = r.insertCell(2);
					c.innerHTML = "Mængde";
						
					for(var i = 0; i < data[0].length; i++)
					{
						h.innerHTML = "Råvarebatches som indeholder råvare ID:<br> " + data[0][0].id;
						
						document.getElementById("showCom").appendChild(h);
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
							
						c = r.insertCell(1);
						c.innerHTML = data[0][i].commodityID;
							
						c = r.insertCell(2);
						c.innerHTML = data[0][i].amount;
					}

						
					document.getElementById("showCom").appendChild(t);
				}
		
			}
				
		});
		return false;
	})
})