package data.dto;

import java.util.List;

public class ProductBatchComponentDTO {
	private int productbatchID;
	private List<CommodityBatchDTO> commodityBatchList;
	private int userID;
	private double tara;
	private double netto;
	
	
	public ProductBatchComponentDTO(int productbatchID, List<CommodityBatchDTO> commodityBatchList, int userID, double tara, double netto) {
		this.productbatchID = productbatchID;
		this.commodityBatchList = commodityBatchList;
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


	public List<CommodityBatchDTO> getCommodityBatchList() {
		return commodityBatchList;
	}


	public void setCommodityBatchID(List<CommodityBatchDTO> commodityBatchList) {
		this.commodityBatchList = commodityBatchList;
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
	
	
}
