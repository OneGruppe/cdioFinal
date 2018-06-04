package data.dto;

import java.util.List;

public class RecipeDTO
{
	private int recipeID;
	private String recipeName;
	private List<RecipeDTO> getCommodityID; 
	private double recipenomNetto;
	private double recipeTolerance;
	
	
	public RecipeDTO(int recipeID, String recipeName, List<RecipeDTO> commodityID, double recipeNetoo, double recipeTolerance) {
		this.recipeID = recipeID;
		this.recipeName = recipeName;
		this.getCommodityID = commodityID;
		this.recipenomNetto = recipenomNetto;
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


	public Object getRecipenomNetto() {
		return recipenomNetto;
	}


	public void setRecipenomNetto(double recipenomNetto) {
		this.recipenomNetto = recipenomNetto;
	}
	@Override
	public String toString() {
		return "RecipeDTO [recipeID=" + recipeID + ", recipeName=" + recipeName + "]";
	}



	
	
	
	
}
