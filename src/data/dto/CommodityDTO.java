package data.dto;

public class CommodityDTO
{
	private int id;
	private String name;
	private int supplierID;
	
	/**
	 * Constructor for CommodityDTO
	 * @param id
	 * @param name
	 * @param supplierID
	 */
	public CommodityDTO(int id, String name, int supplierID)
	{
		this.id = id;
		this.name = name;
		this.supplierID = supplierID;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSupplierID()
	{
		return supplierID;
	}

	public void setSupplierID(int supplierID)
	{
		this.supplierID = supplierID;
	}

	@Override
	public String toString() {
		return "CommodityDTO [id=" + id + ", name=" + name + ", supplierID=" + supplierID + "]";
	}
	
	
	
}