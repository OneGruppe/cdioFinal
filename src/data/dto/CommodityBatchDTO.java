package data.dto;

public class CommodityBatchDTO
{
	private int id;
	private int commodityID;
	private double amoumt;
	
	/**
	 * Constructor for CommodityBatchDTO
	 * @param id
	 * @param commodityID
	 * @param amoumt
	 */
	public CommodityBatchDTO(int id, int commodityID, double amoumt)
	{
		this.id = id;
		this.commodityID = commodityID;
		this.amoumt = amoumt;
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
	
	public double getAmoumt()
	{
		return amoumt;
	}
	
	public void setAmoumt(double amoumt)
	{
		this.amoumt = amoumt;
	}
	
	@Override
	public String toString()
	{
		return "CommodityBatchDTO [id=" + id + ", commodityID=" + commodityID + ", amoumt=" + amoumt + "]";
	}
	
}
