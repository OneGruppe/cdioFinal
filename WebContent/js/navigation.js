/**
 * Handles navigation
 */

$(document).ready(function() {
	$('#createUserForm').hide();
	$('#findUserForm').hide();
	$('#editUserForm').hide();
	$('#setUserForm').hide();
	
	$('#navigateToCreateUser').click(function() {
		$('#showUsersTable').fadeOut(200);
		$('#findUserForm').fadeOut(200);
		$('#showUserTable').remove();
		$('#showUsersTable').remove();
		$('#editUserForm').fadeOut(200);
		$('#setUserForm').fadeOut(200);
		$('#createUserForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindUser').click(function() {
		$('#showUsersTable').fadeOut(200);
		$('#createUserForm').fadeOut(200);
		$('#showUsersTable').remove();
		$('#editUserForm').fadeOut(200);
		$('#setUserForm').fadeOut(200);
		$('#findUserForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowUsers').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').fadeOut(200);
		$('#showUserTable').remove();
		$('#editUserForm').fadeOut(200);
		$('#setUserForm').fadeOut(200);
		$('#showUsersTable').delay(300).fadeIn(200);
	})
	
	$('#navigateToEditUser').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#setUserForm').fadeOut(200);
		$('#showUsersTable').fadeOut(200);
		$('#editUserForm').delay(300).fadeIn(200);
	})
})