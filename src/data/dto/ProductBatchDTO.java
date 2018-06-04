package data.dto;

public class ProductBatchDTO
{
	private int pbID;
	private int recipeID;
	private int status;
	private int userID;
	private int comBatID;
	private double tara;
	private double netto;
	
	public ProductBatchDTO (int pbID, int status, int recipeID, int userID,
							int comBatID, double tara, double netto)
	{
		this.pbID = pbID;
		this.status = status;
		this.recipeID = recipeID;
		this.userID = userID;
		this.comBatID = comBatID;
		this.tara = tara;
		this.netto = netto;
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
