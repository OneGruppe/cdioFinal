/**
 * 
 */

$(document).ready(function() {
	$("#findSupplier").click(function() {
			
		$.ajax({
			url:"/rest/supplier/getSupplier",
			data: $('#findSupplierForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			error: function(xhr) {
				console.log(xhr.responseText);
				alert(xhr.status);
			},
			success:function(data) {
				
				if(data.id != undefined)
				{
					if(document.contains(document.getElementById("showSupTable")))
					{
						document.getElementById("showSupTable").remove();
						var t, r, c;
						
						t = document.createElement("table");
						t.setAttribute("id", "showSupTable");
						
						r = t.insertRow(0);
						
						c = r.insertCell(0);
						c.innerHTML = "Levrendør ID";
						
						c = r.insertCell(1);
						c.innerHTML = "Leverandør navn";
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
						c = r.insertCell(1);
						c.innerHTML = data.name;

						
						document.getElementById("showSupplier").appendChild(t);
							
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
						
						
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data.id;
						
						c = r.insertCell(1);
						c.innerHTML = data.name;

						
						document.getElementById("showSupplier").appendChild(t);
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