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
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getComBatID() {
		return comBatID;
	}

	public void setComBatID(int comBatID) {
		this.comBatID = comBatID;
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
		return "ProductBatchDTO [pbID=" + pbID + ", recipeID=" + recipeID + ", status=" + status + "]";
	}
	
	
}
