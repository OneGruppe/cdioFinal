package data.dto;

public class SupplierDTO 
{

	private int supplierID;
	private String supplierName;

	/**
	 * Constructor for a SupplierDTO
	 * @param supplierID
	 * @param supplierName
	 */
	public SupplierDTO(int supplierID, String supplierName) 
	{
		this.supplierID = supplierID;
		this.supplierName = supplierName;
	}

	public int getSupplierID() 
	{
		return supplierID;
	}

	public void setSupplierID(int supplierID) 
	{
		this.supplierID = supplierID;
	}

	public String getSupplierName() 
	{
		return supplierName;
	}

	public void setSupplierName(String supplierName) 
	{
		this.supplierName = supplierName;
	}

	/**
	 * toString overwritten to show all variables
	 */
	@Override
	public String toString() 
	{
		return "SupplierDTO [supplierID=" + supplierID + ", supplierName=" + supplierName + "]";
	}


}
