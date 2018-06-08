package data.dto;

import java.util.List;

public class RecipeComponentDTO {
	
	private int recipeComponentID;
	private int recipeID;
	private int commodityID;
	private double non_netto;
	private double tolerance;
	/**
	 * Constructor for a RecipeComponentDTO with parameters
	 * @param recipeID ID of the given Recipe.
	 * @param commodityIDList ID of the given Commodity.
	 * @param non_netto 
	 * @param tolerance
	 */
	public RecipeComponentDTO(int recipeID, int commodityID, double non_netto, double tolerance) {
		this.recipeID = recipeID;
		this.commodityID = commodityID;
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

	public int getCommodityID() {
		return commodityID;
	}

	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID; 
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
				+ ", commodityID=" + commodityID + ", non_netto=" + non_netto + ", tolerance=" + tolerance + "]";
	}

}
