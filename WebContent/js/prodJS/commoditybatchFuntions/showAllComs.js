/**
 * 
 */

$(document).ready(function() {
	
	$('#navigateToShowComBatch').click(function() {
		
		$.ajax({
			url:"/rest/comBatch/getAllCommodityBatches",
			data: $('#findComForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			error: function(xhr) {
				console.log(xhr.responseText);
				alert(xhr.status);
			},
			success:function(data) {
				
				if(document.contains(document.getElementById("showComsTable")))
				{
					document.getElementById("showComsTable").remove();
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showComsTable");
					
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
					
					document.getElementById("showComs").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showComsTable");
					
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
					
					document.getElementById("showComs").appendChild(t);
				}
			}
		});
		return false;
	});
});
	