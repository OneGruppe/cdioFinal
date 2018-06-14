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
			error: function(xhr) {
				console.log(xhr.responseText);
				alert(xhr.status);
			},
			success:function(data) {
				
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
					var t, r, c;
						
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
		
			}
				
		});
		return false;
	})
})