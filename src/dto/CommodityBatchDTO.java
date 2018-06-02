package dto;

public class CommodityBatchDTO
{
	private int cbid;
	private int commodityID;
	private double amount;
	
	
	/**
	 * Contructor for CommodityBatchDTO with parameters
	 * @param cbid ID of CommodityBatch
	 * @param commodityID ID of the commodity
	 * @param amount Amount that is stored..?
	 */
	public CommodityBatchDTO (int cbid, int commodityID, double amount)
	{
		this.cbid = cbid;
		this.commodityID = commodityID;
		this.amount = amount;
	}
	
	public String toString()
	{
		return "" + cbid + commodityID + amount;
	}
	
	public int getCbid()
	{
		return cbid;
	}
	
	public void setCbid(int id)
	{
		cbid = id;
	}
	
	public int getCommodityID()
	{
		return commodityID;
	}
	
	public void setCommodityID(int id)
	{
		commodityID = id;
	}
	
	public double getAmount()
	{
		return amount;
	}
	
	public void setAmount(double wishedAmount)
	{
		amount = wishedAmount;
	}
}
