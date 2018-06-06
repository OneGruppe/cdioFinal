package data.dto;

public class UserDTO
{
	private int id;
	private String name;
	private String ini;
	private int active;
	
	/**
	 * Constuctor for a UserDTO with parameters
	 * @param id ID of the user
	 * @param name The name of the user
	 * @param ini The initials of the user
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
	public void setId(int userID) 
	{
		this.id = userID;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String userName) 
	{
		this.name = userName;
	}
	public String getIni() 
	{
		return ini;
	}
	public void setIni(String userIni) 
	{
		this.ini = userIni;
	}
	
	public int getActive() 
	{
		return active;
	}

	public void setActive(int active) 
	{
		this.active = active;
	}

	@Override
	public String toString() 
	{
		return "UserDTO [id=" + id + ", name=" + name + ", ini=" + ini + ", active=" + active + "]";
	}
	
}
