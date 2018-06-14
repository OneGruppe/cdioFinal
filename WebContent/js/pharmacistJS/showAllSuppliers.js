/**
 * 
 */

$(document).ready(function() {
	
	$("#navigateToShowSupplier").click(function() {
		
		$.ajax({
			url:"/rest/supplier/getAllSuppliers",
			data: $('#findSupplierForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			error: function(xhr) {
				console.log(xhr.responseText);
				console.log(xhr.status);
			},
			success:function(data) {
				console.log(data);
				
				if(document.contains(document.getElementById("showSupTable")))
				{
					document.getElementById("showSupTable").remove();
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showSupTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Leverandør ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Leverandør Navn";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;

					}
					
					document.getElementById("showSuppliers").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showSupTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "Leverandør ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Leverandør Navn";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;

					}
					
					document.getElementById("showSuppliers").appendChild(t);

				}
			}
		});
		return false;
	});
});