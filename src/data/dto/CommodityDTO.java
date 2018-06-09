package data.dto;

import java.util.List;

public class CommodityDTO {

	private int id;
	private String name;
	private List<SupplierDTO> supplierList;

	/**
	 * Constructor for CommodityDTO
	 * @param id (int)
	 * @param name (String)
	 * @param supplierList (List<SupplierDTO>)
	 */
	public CommodityDTO (int id, String name, List<SupplierDTO> supplierList)
	{
		this.id = id;
		this.name = name;
		this.supplierList = supplierList;
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

	public List<SupplierDTO> getSupplierList() 
	{
		return supplierList;
	}

	public void setSupplierList(List<SupplierDTO> supplierList) 
	{
		this.supplierList = supplierList;
	}

	@Override
	public String toString() 
	{
		return "CommodityDTO [id=" + id + ", name=" + name + ", supplierList=" + supplierList + "]";
	}


}
