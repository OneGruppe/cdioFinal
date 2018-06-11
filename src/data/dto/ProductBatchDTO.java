package data.dto;

public class ProductBatchDTO
{
	private int id;
	private int recipeID;
	private int status;

	/**
	 * Constructor for ProductBatchDTO
	 * @param id
	 * @param recipeID
	 * @param status
	 */
	public ProductBatchDTO(int id, int recipeID, int status)
	{
		this.id = id;
		this.recipeID = recipeID;
		this.status = status;
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

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	@Override
	public String toString()
	{
		return "ProductBatchDTO [id=" + id + ", recipeID=" + recipeID + ", status=" + status + "]";
	}
	
}