/**
 * 
 */

$(document).ready(function() {
	/********************
	*** DROPDOWN MENU ***
	********************/
	
	$('#dropDownCreateProd').hide();
	$('#dropDownFindProd').hide();
	
	$('#navigateToCreateOptions').click(function() {
		$('#dropDownCreateProd').toggle(500);
		$('#dropDownFindProd').hide();
	})
	
	$('#navigateToFindOptions').click(function() {
		$('#dropDownFindProd').toggle(500);
		$('#dropDownCreateProd').hide();
	})
	
	/*********************
	***   NAVIGATION   ***
	*********************/
	
	
	
})