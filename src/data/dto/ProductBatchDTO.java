package data.dto;

public class ProductBatchDTO
{
	private int id;
	private int recipeID;
	private int status;

	/**
	 * Constructor for a ProductBatchDTO with parameters
	 * @param id ID of the Product batch.
	 * @param recipeID ID of the Recipe.
	 * @param status Status of the product.
	 */
	public ProductBatchDTO (int id, int recipeID, int status)
	{
		this.id = id;
		this.recipeID = recipeID;
		this.status = status;
	}

	public int getID() {
		return id;
	}

	public void setID(int ID) {
		this.id = ID;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductBatchDTO [productBatchid=" + id + ", recipeID=" + recipeID + ", status=" + status
				+ "]";
	}
}