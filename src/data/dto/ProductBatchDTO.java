package data.dto;

public class ProductBatchDTO
{
	private int id;
	private int recipeID;
	private int status;
	private int userID;
	private int commodityBatchID;
	private double tara;
	private double netto;
	
	public ProductBatchDTO (int id, int status, int recipeID, int userID,
							int commodityBatchID, double tara, double netto)
	{
		this.id = id;
		this.status = status;
		this.recipeID = recipeID;
		this.userID = userID;
		this.commodityBatchID = commodityBatchID;
		this.tara = tara;
		this.netto = netto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getCommodityBatchID() {
		return commodityBatchID;
	}

	public void setCommodityBatchID(int commodityBatchID) {
		this.commodityBatchID = commodityBatchID;
	}

	public double getTara() {
		return tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public double getNetto() {
		return netto;
	}

	public void setNetto(double netto) {
		this.netto = netto;
	}


	@Override
	public String toString() {
		return "ProductBatchDTO [id=" + id + ", recipeID=" + recipeID + ", status=" + status + "]";
	}
	
	
}
