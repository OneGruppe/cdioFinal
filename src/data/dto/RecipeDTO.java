package data.dto;

import java.util.List;

public class RecipeDTO
{
	private int id;
	private String name;

	/**
	 * Constructor for at RecipeDTO with parameters
	 * @param id ID of the Recipe.
	 * @param name Name of the Recipe.
	 */
	public RecipeDTO(int id, String name) {
		this.setId(id);
		this.setName(name);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name + "]";
	}	
}