package data.dto;

public class ProductBatchDTO {

	private int id;
	private int recipeID;
	private int status;
	private int commodityBatchID;
	private int userID;
	private double tara;
	private double nonNetto;
	
	public ProductBatchDTO(int id, int recipeID, int status, int commodityBatchID, int userID, double tara, double nonNetto) {
		this.id = id;
		this.recipeID = recipeID;
		this.status = status;
		this.commodityBatchID = commodityBatchID;
		this.userID = userID;
		this.tara = tara;
		this.nonNetto = nonNetto;
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

	public int getCommodityBatchID() {
		return commodityBatchID;
	}

	public void setCommodityBatchID(int commodityBatchID) {
		this.commodityBatchID = commodityBatchID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getTara() {
		return tara;
	}

	public void setTara(double tara) {
		this.tara = tara;
	}

	public double getNonNetto() {
		return nonNetto;
	}

	public void setNonNetto(double nonNetto) {
		this.nonNetto = nonNetto;
	}

	@Override
	public String toString() {
		return "ProductBatchDTO [id=" + id + ", recipeID=" + recipeID + ", status=" + status + ", commodityBatchID="
				+ commodityBatchID + ", userID=" + userID + ", tara=" + tara + ", nonNetto=" + nonNetto + "]";
	}
}