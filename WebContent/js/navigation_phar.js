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
	$('#dropDownContentCreate').hide();
	$('#dropDownContentShow').hide();
	$('#dropDownContentFind').hide();
	
	
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
		$('#createCommodityForm').fadeOut(200);
		$('#createCommodityBatchForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityBatchForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#findCommodityForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindCommodityBatch').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createCommodityBatchForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#findCommodityBatchForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindSupplier').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createCommodityBatchForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findCommodityBatchForm').fadeOut(200);
		$('#findSupplierForm').delay(300).fadeIn(200);
	})
	-
	/*****************
	 * dropdown menu *
	 *****************/
		$('#dropDownCreate').click(function() {
		$('#dropDownContentFind').hide();
		$('#dropDownContentShow').hide();
		$('#dropDownContentCreate').toggle(500);
	})
	$('#dropDownFind').click(function() {
		$('#dropDownContentCreate').hide();
		$('#dropDownContentShow').hide();
		$('#dropDownContentFind').toggle(500);
	})
	$('#dropdownShow').click(function() {
		$('#dropDownContentFind').hide();
		$('#dropDownContentCreate').hide();
		$('#dropDownContentShow').toggle(500);
	})
})