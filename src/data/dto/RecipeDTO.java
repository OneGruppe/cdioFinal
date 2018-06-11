package data.dto;

public class RecipeDTO {

	private int id;
	private String name;
	private int commodityID;
	private double nonNetto;
	private double tolerance;
	
	/**
	 * Constructor for a RecipeDTO
	 * @param id
	 * @param name
	 * @param commodityID
	 * @param nonNetto
	 * @param tolerance
	 */
	public RecipeDTO(int id, String name, int commodityID, double nonNetto, double tolerance) {
		this.id = id;
		this.name = name;
		this.commodityID = commodityID;
		this.nonNetto = nonNetto;
		this.tolerance = tolerance;
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
	public int getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	public double getNonNetto() {
		return nonNetto;
	}
	public void setNonNetto(double nonNetto) {
		this.nonNetto = nonNetto;
	}
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}
	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name + ", commodityID=" + commodityID + ", nonNetto=" + nonNetto
				+ ", tolerance=" + tolerance + "]";
	}	
	
}