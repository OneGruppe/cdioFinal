package data.dto;

public class RecipeDTO
{
	private int recipeID;
	private String recipeName;
	
	
	public RecipeDTO(int recipeID, String recipeName) {
		this.recipeID = recipeID;
		this.recipeName = recipeName;
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


	@Override
	public String toString() {
		return "RecipeDTO [recipeID=" + recipeID + ", recipeName=" + recipeName + "]";
	}
	
	
	
	
}
