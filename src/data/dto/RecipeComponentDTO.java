package data.dto;

import java.util.List;

public class RecipeComponentDTO {
	
	private int recipeComponentID;
	private int recipeID;
	private List<CommodityDTO> commodityList;
	private double non_netto;
	private double tolerance;
	/**
	 * Constructor for a RecipeComponentDTO with parameters
	 * @param recipeID ID of the given Recipe.
	 * @param commodityIDList List of CommodityDTO, that is attached to the recipeComponent.
	 * @param non_netto 
	 * @param tolerance
	 */
	public RecipeComponentDTO(int recipeComponentID, int recipeID, List<CommodityDTO> commodityList, double non_netto, double tolerance) {
		this.recipeComponentID = recipeComponentID;
		this.recipeID = recipeID;
		this.commodityList = commodityList;
		this.non_netto = non_netto;
		this.tolerance = tolerance;
	}

	
	
	public int getRecipeComponentID() {
		return recipeComponentID;
	}

	public void setRecipeComponentID(int recipeComponentID) {
		this.recipeComponentID = recipeComponentID;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public List<CommodityDTO> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<CommodityDTO> commodityList) {
		this.commodityList = commodityList; 
	}

	public double getNon_netto() {
		return non_netto;
	}

	public void setNon_netto(double non_netto) {
		this.non_netto = non_netto;
	}

	public double getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	@Override
	public String toString() {
		return "RecipeComponentDTO [recipeComponentID=" + recipeComponentID + ", recipeID=" + recipeID
				+ ", commodityID=" + commodityList + ", non_netto=" + non_netto + ", tolerance=" + tolerance + "]";
	}

}
