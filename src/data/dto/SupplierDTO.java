package data.dto;

public class SupplierDTO {

	private int id;
	private String name;

	/**
	 * Constructor for a SupplierDTO
	 * @param id
	 * @param name
	 */
	public SupplierDTO(int id, String name) 
	{
		this.id = id;
		this.name = name;
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

	@Override
	public String toString() 
	{
		return "SupplierDTO [id=" + id + ", name=" + name + "]";
	}


}
