/**
 * Shows a single user
 */

$(document).ready(function() {
	$("#findUser").click(function() {
			
		$.ajax({
			url:"/cdio_final/rest/user/getUser",
			data: $('#findUserForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "POST",
			success:function(data) {
				console.log(data.name);
				
				if(document.contains(document.getElementById("showUserTable")))
				{
					document.getElementById("showUserTable").remove();
					var t, r, c;
					
					
					t = document.createElement("table");
					t.setAttribute("id", "showUserTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Navn";
					
					c = r.insertCell(2);
					c.innerHTML = "Initialer";
					
					c = r.insertCell(3);
					c.innerHTML = "Status";
					

					
					r = t.insertRow(1);
					
					c = r.insertCell(0);
					c.innerHTML = data.ID;
					
					c = r.insertCell(1);
					c.innerHTML = data.name;
					
					c = r.insertCell(2);
					c.innerHTML = data.ini;
					
					c = r.insertCell(3);
					c.innerHTML = data.active;
					
					
					document.getElementById("showUser").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showUserTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Navn";
					
					c = r.insertCell(2);
					c.innerHTML = "Initialer";
					
					c = r.insertCell(3);
					c.innerHTML = "Status";
					
					
					
					r = t.insertRow(1);
					
					c = r.insertCell(0);
					c.innerHTML = data.ID;
					
					c = r.insertCell(1);
					c.innerHTML = data.name;
					
					c = r.insertCell(2);
					c.innerHTML = data.ini;
					
					c = r.insertCell(3);
					c.innerHTML = data.active;

					
					document.getElementById("showUser").appendChild(t);
				}
			}
		});
		return false;
	})
})
	