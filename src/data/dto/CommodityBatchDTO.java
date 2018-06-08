package data.dto;

public class CommodityBatchDTO
{

	private int commodityBatchID;
	private int commodityID;
	private int supplierID;
	private double amount;

	/**
	 * Contructor for CommodityBatchDTO
	 * @param commodityBatchID (int)
	 * @param commodityID (int)
	 * @param supplierID (int)
	 * @param amount (double)
	 */
	public CommodityBatchDTO (int commodityBatchID, int commodityID, int supplierID, double amount)
	{
		this.commodityBatchID = commodityBatchID;
		this.commodityID = commodityID;
		this.supplierID = supplierID;
		this.amount = amount;
	}

	public int getCommodityBatchID() 
	{
		return commodityBatchID;
	}

	public void setCommodityBatchID(int commodityBatchID) 
	{
		this.commodityBatchID = commodityBatchID;
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

	/**
	 * toString overwritten to show all variables
	 */
	@Override
	public String toString() 
	{
		return "CommodityBatchDTO [commodityBatchID=" + commodityBatchID + ", commodityID=" + commodityID
				+ ", supplierID=" + supplierID + ", amount=" + amount + "]";
	}


}
