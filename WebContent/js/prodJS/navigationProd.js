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
	$('#createProdCompForm').hide();
	$('#findProdCompForm').hide();

	$('#navigateToCreateOptions').click(function() {
		$('#dropDownCreateProd').slideToggle(250);
		$('#dropDownFindProd').hide();
		$('#dropDownVisProd').hide();
	})
	
	$('#navigateToFindOptions').click(function() {
		$('#dropDownFindProd').slideToggle(250);
		$('#dropDownCreateProd').hide();
		$('#dropDownVisProd').hide();
	})
	
	$('#navigateToShowOptions').click(function() {
		$('#dropDownVisProd').slideToggle(250);
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
		$('#showProdTable').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#createProdTitel').delay(300).fadeIn(200);
		$('#createProdForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToCreateComBatch').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#findComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#createComForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindComBatch').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#findComForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindProdBatch').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#findProdForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowProdBatch').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findProdForm').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#showProdsTable').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowComBatch').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findProdForm').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#showComsTable').delay(300).fadeIn(200);
	})
	
	$('#navigateToEditProd').click(function() {
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#editProdForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToEditCom').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#editComForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToCreateProdComp').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#findProdCompForm').fadeOut(200);
		$("#showProdCompTable").fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#createProdCompForm').delay(300).fadeIn(200);
	})
	
	$('#navigateToFindProdComp').click(function() {
		$('#findProdForm').fadeOut(200);
		$('#findComForm').fadeOut(200);
		$('#createComForm').fadeOut(200);
		$('#showProdTable').fadeOut(200);
		$('#showProdsTable').fadeOut(200);
		$('#showComTable').fadeOut(200);
		$('#showComsTable').fadeOut(200);
		$('#createProdCompForm').fadeOut(200)
		$("#showProdCompTable").fadeOut(200);
		$('#createProdForm').fadeOut(200);
		$('#findProdCompForm').delay(300).fadeIn(200);
	})
	
	$('#findProductBatch').click(function() {
		$('#editProdForm').fadeOut(50);
	})
	
	$('#findCommodityBatch').click(function() {
		$('#editComForm').fadeOut(50);
	})
	
	
	
})