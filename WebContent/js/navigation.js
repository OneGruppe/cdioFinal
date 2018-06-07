/**
 * Handles navigation
 */

$(document).ready(function() {
	$('#createUserForm').hide();
	$('#findUserForm').hide();
	
	$('#navigateToCreateUser').click(function() {
		$('#findUserForm').fadeOut(200);
		$('#createUserForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindUser').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').delay(300).fadeIn(200);
	})
})