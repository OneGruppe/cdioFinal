package dto;

public class ProductBatchDTO
{
	private int pbID;
	private int recipeID;
	private int status;
	
	public ProductBatchDTO (int pbID, int recipeID, int status)
	{
		this.pbID = pbID;
		this.recipeID = recipeID;
		this.status = status;
	}

	public int getPbID() {
		return pbID;
	}

	public void setPbID(int pbID) {
		this.pbID = pbID;
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
		return "ProductBatchDTO [pbID=" + pbID + ", recipeID=" + recipeID + ", status=" + status + "]";
	}
	
	
}
