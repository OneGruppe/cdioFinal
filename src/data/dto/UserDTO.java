package data.dto;

public class UserDTO
{

	private int id;
	private String name;
	private String ini;
	private int active;

	/**
	 * Constuctor for a UserDTO
	 * @param id (int)
	 * @param name (String)
	 * @param ini (String)
	 * @param active (int)
	 */
	public UserDTO(int id, String name, String ini, int active) 
	{
		this.id = id;
		this.name = name;
		this.ini = ini;
		this.active = active;
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

	public String getIni() 
	{
		return ini;
	}

	public void setIni(String ini) 
	{
		this.ini = ini;
	}

	public int getActive() 
	{
		return active;
	}

	public void setActive(int active) 
	{
		this.active = active;
	}

	/**
	 * toString overwritten to show all variables
	 */
	@Override
	public String toString() 
	{
		return "UserDTO [id=" + id + ", name=" + name + ", ini=" + ini + ", active=" + active + "]";
	}

}
