/**
 * Pharmacist navigation
 */
$(document).ready(function() {
	$('#createCommodityForm').hide();
	$('#createCommodityBatchForm').hide();
	$('#createSupplierForm').hide();
	$('#findCommodityForm').hide();
	$('#findCommodityBatchForm').hide();
	$('#findSupplierForm').hide();
	
	
	$('#navigateToCreateCommodity').click(function() {
		$('#findCommodityForm').fadeOut(200);
		$('#createCommodityBatchForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityBatchForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#createCommodityForm').delay(300).fadeIn(200);
	})
	$('#navigateToCreateCommodityBatch').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findCommodityBatchForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#createCommodityBatchForm').delay(300).fadeIn(200);
	})
	$('#navigateToCreateSupplier').click(function() {
		$('#findSupplierForm').fadeOut(200);
		$('#createCommodityBatchForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findCommodityBatchForm').fadeOut(200);
		$('#createCommodityForm').fadeOut(200);
		$('#createSupplierForm').delay(300).fadeIn(200);
	})
	
	
	$('#navigateToFindCommodity').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindCommodityBatch').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindSupplier').click(function() {
		$('#createUserForm').fadeOut(200);
		$('#findUserForm').delay(300).fadeIn(200);
	})
})