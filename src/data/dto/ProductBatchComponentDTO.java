package data.dto;

public class ProductBatchComponentDTO {
	private int productbatchID;
	private int commodityBatchID;
	private int userID;
	private double tara;
	private double netto;
	

	public ProductBatchComponentDTO(int productbatchID, int commodityBatchID, int userID, double tara, double netto) {
		this.productbatchID = productbatchID;
		this.commodityBatchID = commodityBatchID;
		this.userID = userID;
		this.tara = tara;
		this.netto = netto;
	}

	public int getProductbatchID() {
		return productbatchID;
	}


	public void setProductbatchID(int productbatchID) {
		this.productbatchID = productbatchID;
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


	public double getNetto() {
		return netto;
	}


	public void setNetto(double netto) {
		this.netto = netto;
	}


	@Override
	public String toString() {
		return "ProductBatchComponentDTO [userID=" + userID + ", productbatchID=" + productbatchID
				+ ", commodityBatchID=" + commodityBatchID + ", tara=" + tara + ", netto=" + netto + "]";
	}
}
