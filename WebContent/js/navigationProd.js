/**
 * 
 */

$(document).ready(function() {
	/********************
	*** DROPDOWN MENU ***
	********************/
	
	$('#dropDownCreateProd').hide();
	$('#dropDownFindProd').hide();
	$('#dropDownVisProd').hide();
	$('#createProdForm').hide();
	$('#createComForm').hide();
	$('#findComForm').hide();
	$('#findProdForm').hide();
	$('#showComTable').hide();
	$('#showProdTable').hide();
	
	$('#navigateToCreateOptions').click(function() {
		$('#dropDownCreateProd').toggle(500);
		$('#dropDownFindProd').hide();
		$('#dropDownVisProd').hide();
	})
	
	$('#navigateToFindOptions').click(function() {
		$('#dropDownFindProd').toggle(500);
		$('#dropDownCreateProd').hide();
		$('#dropDownVisProd').hide();
	})
	
	$('#navigateToShowOptions').click(function() {
		$('#dropDownVisProd').toggle(500);
		$('#dropDownCreateProd').hide();
		$('#dropDownFindProd').hide();
	})
	
	/*********************
	***   NAVIGATION   ***
	*********************/
	$('#navigateToCreateProdBatch').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToCreateComBatch').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#findComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#createComForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindComBatch').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findComForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindProdBatch').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findProdForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowProdBatch').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findProdForm').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showProdTable').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowComBatch').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findProdForm').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showComTable').delay(300).fadeIn(200);
	})
	
})