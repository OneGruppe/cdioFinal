package data.dto;

public class RecipeDTO {

	private int id;
	private String name;

	/**
	 * Constructor for a RecipeDTO
	 * @param id (int)
	 * @param name (String)
	 */
	public RecipeDTO(int id, String name) 
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
		return "RecipeDTO [id=" + id + ", name=" + name + "]";
	}


}
