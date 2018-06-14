package data.dto;

public class RecipeComponentDTO {

	private int id;
	private int recipeID;
	private int commodityID;
	private double nonNetto;
	private double tolerance;

	/**
	 * Constructor for RecipeComponentDTO
	 * @param id
	 * @param recipeID
	 * @param commodityID
	 * @param nonNetto
	 * @param tolerance
	 */
	public RecipeComponentDTO(int id, int recipeID, int commodityID, double nonNetto, double tolerance)
	{
		this.id = id;
		this.recipeID = recipeID;
		this.commodityID = commodityID;
		this.nonNetto = nonNetto;
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

	public double getNonNetto()
	{
		return nonNetto;
	}

	public void setNonNetto(double nonNetto)
	{
		this.nonNetto = nonNetto;
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
		return "RecipeComponent [id=" + id + ", recipeID=" + recipeID + ", commodityID=" + commodityID + ", nonNetto="
				+ nonNetto + ", tolerance=" + tolerance + "]";
	}


}
