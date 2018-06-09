package data.dto;

public class RecipeComponentDTO {

	private int id;
	private int recipeID;
	private int commodityID;
	private double non_netto;
	private double tolerance;

	/**
	 * Constructor for a RecipeComponentDTO
	 * @param id (int)
	 * @param recipeID (int)
	 * @param commodityID (int)
	 * @param non_netto (double)
	 * @param tolerance (double)
	 */
	public RecipeComponentDTO(int id, int recipeID, int commodityID, double non_netto, double tolerance) 
	{
		this.id = id;
		this.recipeID = recipeID;
		this.commodityID = commodityID;
		this.non_netto = non_netto;
		this.tolerance = tolerance;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
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

	@Override
	public String toString() 
	{
		return "RecipeComponentDTO [id=" + id + ", recipeID=" + recipeID + ", commodityID=" + commodityID
				+ ", non_netto=" + non_netto + ", tolerance=" + tolerance + "]";
	}


}
