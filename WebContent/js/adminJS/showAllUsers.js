/**
 * 
 */

$(document).ready(function() {
	
	$('#navigateToShowUsers').click(function() {
		
		$.ajax({
			url:"/rest/user/getAllUsers",
			data: $('#findUserForm').serialize(),
			dataType: "json",
			contenttype: "application/json",
			method: "GET",
			error: function(xhr) {
				alert(xhr.responseText);
				console.log(xhr.status);
			},
			success:function(data) {

				if(document.contains(document.getElementById("showUsersTable")))
				{
					document.getElementById("showUsersTable").remove();
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showUsersTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Navn";
					
					c = r.insertCell(2);
					c.innerHTML = "Initialer";
					
					c = r.insertCell(3);
					c.innerHTML = "Status";

					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;
						
						c = r.insertCell(2);
						c.innerHTML = data[0][i].ini;
						
						c = r.insertCell(3);
						c.innerHTML = data[0][i].active;
					}
					
					document.getElementById("showUsers").appendChild(t);
						
				} 
				else
				{
					var t, r, c;
					
					t = document.createElement("table");
					t.setAttribute("id", "showUsersTable");
					
					r = t.insertRow(0);
					
					c = r.insertCell(0);
					c.innerHTML = "ID";
					
					c = r.insertCell(1);
					c.innerHTML = "Navn";
					
					c = r.insertCell(2);
					c.innerHTML = "Initialer";
					
					c = r.insertCell(3);
					c.innerHTML = "Status";
					
					
					
					for(var i = 0; i < data[0].length; i++)
					{
						r = t.insertRow(1);
						
						c = r.insertCell(0);
						c.innerHTML = data[0][i].id;
						
						c = r.insertCell(1);
						c.innerHTML = data[0][i].name;
						
						c = r.insertCell(2);
						c.innerHTML = data[0][i].ini;
						
						c = r.insertCell(3);
						c.innerHTML = data[0][i].active;
					}
					
					document.getElementById("showUsers").appendChild(t);
				}
			}
		});
		return false;
	});
});
	