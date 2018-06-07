package data.dto;

import java.util.List;

public class RecipeComponentDTO {

	private int recipeID;
	private List<Integer> commodityIDList;
	private double non_netto;
	private double tolerance;
	/**
	 * Constructor for a RecipeComponentDTO with parameters
	 * @param recipeID ID of the given Recipe.
	 * @param commodityIDList ID of the given Commodity.
	 * @param non_netto 
	 * @param tolerance
	 */
	public RecipeComponentDTO(int recipeID, List<Integer> commodityIDList, double non_netto, double tolerance) {
		this.recipeID = recipeID;
		this.commodityIDList = commodityIDList;
		this.non_netto = non_netto;
		this.tolerance = tolerance;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public List<Integer> getCommodityIDList() {
		return commodityIDList;
	}

	public void setCommodityID(List<Integer> commodityIDList) {
		this.commodityIDList = commodityIDList; 
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
		return "RecipeComponentDTO [recipeID=" + recipeID + ", commodityID=" + commodityIDList + ", non_netto=" + non_netto
				+ ", tolerance=" + tolerance + "]";
	}
}
