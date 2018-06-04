package data.dto;

import java.util.List;

public class RecipeDTO
{
	private int recipeID;
	private String recipeName;
	private List<CommodityDTO> commodityID; 
	private double nomNetto;
	private double recipeTolerance;
	
	
	public RecipeDTO(int recipeID, String recipeName, List<CommodityDTO> commodityID, double nomNetto, double recipeTolerance) {
		this.recipeID = recipeID;
		this.recipeName = recipeName;
		this.commodityID = commodityID;
		this.nomNetto = nomNetto;
		this.recipeTolerance = recipeTolerance;
	}


	public int getRecipeID() {
		return recipeID;
	}


	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}


	public String getRecipeName() {
		return recipeName;
	}


	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	
	public Object getRecipeTolerance() {
		return recipeTolerance;
	}


	public void setRecipeTolerance(double recipeTolerance) {
		this.recipeTolerance = recipeTolerance;
	}	
	
	public List<CommodityDTO> getCommodityID() {
		return commodityID;
	}


	public void setCommodityID(List<CommodityDTO> commodityID) {
		this.commodityID = commodityID;
	}


	public double getNomNetto() {
		return nomNetto;
	}


	public void setNomNetto(double nomNetto) {
		this.nomNetto = nomNetto;
	}


	@Override
	public String toString() {
		return "RecipeDTO [recipeID=" + recipeID + ", recipeName=" + recipeName + "]";
	}



	
	
	
	
}
