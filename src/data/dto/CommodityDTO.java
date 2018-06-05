package data.dto;

import java.util.List;

public class CommodityDTO
{
	private int commodityID;
	private String commodityName;
	private List<SupplierDTO> suppliers;
	
	
	/**
	 * Constructor for CommodityDTO with parameters
	 * @param commodityID ID of the commodity
	 * @param CommodityName The name of the commodity
	 * @param supplier The supplier of the commodity
	 */
	public CommodityDTO (int commodityID, String CommodityName, List<SupplierDTO> supplierList)
	{
		this.commodityID = commodityID;
		this.commodityName = CommodityName;
		this.suppliers = supplierList;
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
	
	public List<SupplierDTO> getSupplier()
	{
		return suppliers;
	}
	
	public void setSupplier(List<SupplierDTO> suppliers)
	{
		this.suppliers = suppliers;
	}

	@Override
	public String toString() {
		return "CommodityDTO [commodityID=" + commodityID + ", commodityName=" + commodityName + ", supplier="
				+ suppliers + "]";
	}
}
