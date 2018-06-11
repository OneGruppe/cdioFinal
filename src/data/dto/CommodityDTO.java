package data.dto;

public class CommodityDTO {

	private int id;
	private String name;
	
	/**
	 * Constructor for CommodityDTO
	 * @param id
	 * @param name
	 */
	public CommodityDTO(int id, String name) {
		this.id = id;
		this.name = name;
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
		return "CommodityDTO [id=" + id + ", name=" + name + "]";
	}
	
}
