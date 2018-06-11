package data.dto;

public class CommodityBatchDTO {

	private int id;
	private int commodityID;
	private int supplierID;
	private String supplierName;
	private double amount;
	
	/**
	 * Contructor for CommodityBatchDTO
	 * @param id
	 * @param commodityID
	 * @param supplierID
	 * @param supplierName
	 * @param amount
	 */
	public CommodityBatchDTO(int id, int commodityID, double amount, int supplierID, String supplierName) {
		this.id = id;
		this.commodityID = commodityID;
		this.amount = amount;
		this.supplierID = supplierID;
		this.supplierName = supplierName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	public int getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "CommodityBatchDTO [id=" + id + ", commodityID=" + commodityID + ", amount=" + amount + ", supplierID=" + supplierID
				+ ", supplierName=" + supplierName + "]";
	}
}
