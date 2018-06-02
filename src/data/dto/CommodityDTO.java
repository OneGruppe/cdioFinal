package data.dto;

public class CommodityDTO
{
	private int commodityID;
	private String commodityName;
	private String supplier;
	
	
	/**
	 * Constructor for CommodityDTO with parameters
	 * @param commodityID ID of the commodity
	 * @param CommodityName The name of the commodity
	 * @param supplier The suppler of the commodity
	 */
	public CommodityDTO (int commodityID, String CommodityName, String supplier)
	{
		this.commodityID = commodityID;
		this.commodityName = CommodityName;
		this.supplier = supplier;
	}
	
	public int getCommodityID()
	{
		return commodityID;
	}
	
	public void setCommodityID(int commodityID)
	{
		this.commodityID = commodityID;
	}
	
	public String getCommodityName()
	{
		return commodityName;
	}
	
	public void setCommodityName(String commodityName)
	{
		this.commodityName = commodityName;
	}
	
	public String getSupplier()
	{
		return supplier;
	}
	
	public void setSupplier(String supplier)
	{
		this.supplier = supplier;
	}

	@Override
	public String toString() {
		return "CommodityDTO [commodityID=" + commodityID + ", commodityName=" + commodityName + ", supplier="
				+ supplier + "]";
	}
}
