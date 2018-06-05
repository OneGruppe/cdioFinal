package data.dto;

public class CommodityBatchDTO
{
	private int id;
	private int commodityID;
	private double amount;
	
	
	/**
	 * Contructor for CommodityBatchDTO with parameters
	 * @param id ID of CommodityBatch
	 * @param commodityID ID of the commodity
	 * @param amount Amount that is stored..?
	 */
	public CommodityBatchDTO (int id, int commodityID, double amount)
	{
		this.id = id;
		this.commodityID = commodityID;
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
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double Amount)
	{
		this.amount = Amount;
	}

	@Override
	public String toString() {
		return "CommodityBatchDTO [cbid=" + id + ", commodityID=" + commodityID + ", amount=" + amount + "]";
	}
	
	
}
