package data.dto;

public class CommodityBatchDTO {

	private int id;
	private int commodityID;
	private int supplierID;
	private double amount;

	/**
	 * Contructor for CommodityBatchDTO
	 * @param id (int)
	 * @param commodityID (int)
	 * @param supplierID (int)
	 * @param amount (double)
	 */
	public CommodityBatchDTO (int id, int commodityID, int supplierID, double amount)
	{
		this.id = id;
		this.commodityID = commodityID;
		this.supplierID = supplierID;
		this.amount = amount;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getCommodityID() 
	{
		return commodityID;
	}

	public void setCommodityID(int commodityID) 
	{
		this.commodityID = commodityID;
	}

	public int getSupplierID() 
	{
		return supplierID;
	}

	public void setSupplierID(int supplierID) 
	{
		this.supplierID = supplierID;
	}

	public double getAmount() 
	{
		return amount;
	}

	public void setAmount(double amount) 
	{
		this.amount = amount;
	}

	@Override
	public String toString() 
	{
		return "CommodityBatchDTO [id=" + id + ", commodityID=" + commodityID + ", supplierID=" + supplierID
				+ ", amount=" + amount + "]";
	}


}
