/**
 * 
 */

$(document).ready(function() {
	$('#navigateToShowUsers').click(function() {
		$.ajax({
			url:"/cdio_final/rest/user/getAllUsers",
			data: $('#navigateToShowUsers').serialize(),
			dataType: "json",
			contenttype: "application/x-ww-form-urlencoded",
			method: "GET",
			success:function(data) {
				
				var tr;
				for(var i=0; i < data.length; i++)
				{
					tr = $('<tr/>');
					tr.append("<td>"  + data[i].name)
				}
			}
		});
		return false;
	});
});
	