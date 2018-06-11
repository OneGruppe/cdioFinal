package data.dto;

public class RecipeDTO
{
	private int id;
	private String name;
	
	/**
	 * Constructor for RecipeDTO
	 * @param id
	 * @param name
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