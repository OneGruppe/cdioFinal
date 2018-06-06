package data.dto;

import java.util.List;

public class RecipeDTO
{
	private int id;
	private String name;
	private List<Integer> commodityList; 
	private double nonNetto;
	private double tolerance;

	public RecipeDTO(int id, String name, List<Integer> commodityID, double nonNetto, double tolerance) {
		this.id = id;
		this.name = name;
		this.commodityList = commodityID;
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

	public Object getTolerance() {
		return tolerance;
	}

	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}	

	public List<Integer> getCommodityList() {
		return commodityList;
	}

	public void setCommodityList(List<Integer> commodityList) {
		this.commodityList = commodityList;
	}

	public double getNonNetto() {
		return nonNetto;
	}

	public void setNomNetto(double netto) {
		this.nonNetto = netto;
	}

	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name + "]";
	}

	
}
