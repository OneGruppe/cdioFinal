package data.dto;

public class CommodityBatchDTO
{
	private int cbID;
	private int commodityID;
	private double amount;
	
	
	/**
	 * Contructor for CommodityBatchDTO with parameters
	 * @param cbid ID of CommodityBatch
	 * @param commodityID ID of the commodity
	 * @param amount Amount that is stored..?
	 */
	public CommodityBatchDTO (int cbID, int commodityID, double amount)
	{
		this.cbID = cbID;
		this.commodityID = commodityID;
		this.amount = amount;
	}
	
	public int getCbid()
	{
		return cbID;
	}
	
	public void setCbid(int cbID)
	{
		this.cbID = cbID;
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
		return "CommodityBatchDTO [cbid=" + cbID + ", commodityID=" + commodityID + ", amount=" + amount + "]";
	}
	
	
}
