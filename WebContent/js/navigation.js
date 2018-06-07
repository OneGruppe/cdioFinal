/**
 * Handles navigation
 */

$(document).ready(function() {
	$('#createUserForm').hide();
	$('#findUserForm').hide();
	
	$('#navigateToCreateUser').click(function() {
		$('#showUsersTable').fadeOut(200);
		$('#findUserForm').fadeOut(200);
		$('#showUserTable').remove();
		$('#createUserForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindUser').click(function() {
		$('#showUsersTable').fadeOut(200);
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowUsers').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').fadeOut(200);
		$('#showUserTable').remove();
		$('#showUsersTable').delay(300).fadeIn(200);
	})
})