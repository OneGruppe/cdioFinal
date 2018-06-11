/**
 * Pharmacist navigation
 */
$(document).ready(function() {
	$('#createCommodityForm').hide();
	$('#createRecipeForm').hide();
	$('#createRecipeComponentForm').hide();
	$('#createSupplierForm').hide();
	$('#findCommodityForm').hide();
	$('#findRecipeComponentForm').hide();
	$('#findRecipeForm').hide();
	$('#findSupplierForm').hide();
	$('#dropDownContentCreate').hide();
	$('#dropDownContentShow').hide();
	$('#dropDownContentFind').hide();
	$('#editCommodityForm').hide();
	
	
	$('#navigateToCreateCommodity').click(function() {
		$('#findCommodityForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200);
		$('#createCommodityForm').delay(300).fadeIn(200);
	})
	$('#navigateToCreateRecipeComponent').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#createRecipeComponentForm').delay(300).fadeIn(200);	
	})
		$('#navigateToCreateRecipe').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createSupplierForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#createRecipeForm').delay(300).fadeIn(200);	
	})
	$('#navigateToCreateSupplier').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#findSupplierForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#createSupplierForm').delay(300).fadeIn(200);
	})
	
	
	$('#navigateToFindCommodity').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200)
		$('#createSupplierForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200)
		$('#findRecipeComponentForm').fadeOut(200)
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#findCommodityForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindRecipeComponent').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200)
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200)
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#findRecipeComponentForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindSupplier').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200)
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200)
		$('#findRecipeComponentForm').fadeOut(200)
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#findSupplierForm').delay(300).fadeIn(200);
	})
	$('#navigateToFindRecipe').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200)
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200)
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#findRecipeForm').delay(300).fadeIn(200);
		
	})
	
	$('#navigateToShowRecipe').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200)
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200)
		$('#findSupplierForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#findRecipeForm').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showSuppliers').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#showRecipes').delay(300).fadeIn(200);
	})
	
	$('#navigateToShowSupplier').click(function() {
		$('#createCommodityForm').fadeOut(200);
		$('#createRecipeComponentForm').fadeOut(200);
		$('#createRecipeForm').fadeOut(200)
		$('#createSupplierForm').fadeOut(200);
		$('#findCommodityForm').fadeOut(200);
		$('#findRecipeComponentForm').fadeOut(200)
		$('#findSupplierForm').fadeOut(200);
		$('#findRecipeForm').fadeOut(200);
		$('#showRecipe').fadeOut(200);
		$('#showRecipes').fadeOut(200);
		$('#showSupplier').fadeOut(200);
		$('#showRecCom').fadeOut(200);
		$('#showRecComs').fadeOut(200);
		$('#showCommodity').fadeOut(200);
		$('#showCommodities').fadeOut(200)
		$('#showSuppliers').delay(300).fadeIn(200);
	})
	
	/*****************
	 * dropdown menu *
	 *****************/
	$('#dropDownCreate').click(function() {
		$('#dropDownContentFind').hide();
		$('#dropDownContentShow').hide();
		$('#dropDownContentCreate').slideToggle(500);
	})
	$('#dropDownFind').click(function() {
		$('#dropDownContentCreate').hide();
		$('#dropDownContentShow').hide();
		$('#dropDownContentFind').slideToggle(500);
	})
	$('#dropdownShow').click(function() {
		$('#dropDownContentFind').hide();
		$('#dropDownContentCreate').hide();
		$('#dropDownContentShow').slideToggle(500);
	})
})
