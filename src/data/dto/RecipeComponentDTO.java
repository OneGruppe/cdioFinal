package data.dto;

import java.util.List;

public class RecipeComponentDTO {

	private int recipeID;
	List<RecipeComponentCommodityDTO> componentCommodityList;

	/**
	 * Constructor for a RecipeComponentDTO
	 * @param recipeID
	 * @param componentCommodityList
	 */
	public RecipeComponentDTO(int recipeID, List<RecipeComponentCommodityDTO> componentCommodityList) {
		this.recipeID = recipeID;
		this.componentCommodityList = componentCommodityList;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public List<RecipeComponentCommodityDTO> getComponentCommodityList() {
		return componentCommodityList;
	}

	public void setComponentCommodityList(List<RecipeComponentCommodityDTO> componentCommodityList) {
		this.componentCommodityList = componentCommodityList;
	}

	@Override
	public String toString() {
		return "RecipeComponentDTO [recipeID=" + recipeID + ", componentCommodityList=" + componentCommodityList + "]";
	}


}
