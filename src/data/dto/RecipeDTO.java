package data.dto;

public class RecipeDTO
{

	private int recipeID;
	private String recipeName;

	/**
	 * Constructor for a RecipeDTO
	 * @param recipeID (int)
	 * @param recipeName (String)
	 */
	public RecipeDTO(int recipeID, String recipeName) 
	{
		this.recipeID = recipeID;
		this.recipeName = recipeName;
	}


	public int getRecipeID() 
	{
		return recipeID;
	}


	public void setRecipeID(int recipeID) 
	{
		this.recipeID = recipeID;
	}


	public String getRecipeName() 
	{
		return recipeName;
	}


	public void setRecipeName(String recipeName) 
	{
		this.recipeName = recipeName;
	}

	/**
	 * toString overwritten to show all variables
	 */
	@Override
	public String toString() 
	{
		return "RecipeDTO [recipeID=" + recipeID + ", recipeName=" + recipeName + "]";
	}


}
