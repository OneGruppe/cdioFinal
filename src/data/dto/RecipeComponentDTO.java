package data.dto;

public class RecipeComponentDTO
{

	private int recipeComponentID;
	private int recipeID;
	private int commodityID;
	private double non_netto;
	private double tolerance;

	/**
	 * Constructor for a RecipeComponentDTO
	 * @param recipeComponentID (int)
	 * @param recipeID (int)
	 * @param commodityID (int)
	 * @param non_netto (double)
	 * @param tolerance (double)
	 */
	public RecipeComponentDTO(int recipeComponentID, int recipeID, int commodityID, double non_netto, double tolerance) 
	{
		this.recipeComponentID = recipeComponentID;
		this.recipeID = recipeID;
		this.commodityID = commodityID;
		this.non_netto = non_netto;
		this.tolerance = tolerance;
	}

	public int getRecipeComponentID() 
	{
		return recipeComponentID;
	}

	public void setRecipeComponentID(int recipeComponentID) 
	{
		this.recipeComponentID = recipeComponentID;
	}

	public int getRecipeID() 
	{
		return recipeID;
	}

	public void setRecipeID(int recipeID) 
	{
		this.recipeID = recipeID;
	}

	public int getCommodityID() 
	{
		return commodityID;
	}

	public void setCommodityID(int commodityID) 
	{
		this.commodityID = commodityID;
	}

	public double getNon_netto() 
	{
		return non_netto;
	}

	public void setNon_netto(double non_netto) 
	{
		this.non_netto = non_netto;
	}

	public double getTolerance() 
	{
		return tolerance;
	}

	public void setTolerance(double tolerance) 
	{
		this.tolerance = tolerance;
	}

	/**
	 * toString overwritten to show all variables
	 */
	@Override
	public String toString() 
	{
		return "RecipeComponentDTO [recipeComponentID=" + recipeComponentID + ", recipeID=" + recipeID
				+ ", commodityID=" + commodityID + ", non_netto=" + non_netto + ", tolerance=" + tolerance + "]";
	}


}
