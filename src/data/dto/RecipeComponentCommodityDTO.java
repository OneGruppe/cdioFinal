package data.dto;

public class RecipeComponentCommodityDTO {

	private int commodityID;
	private double non_netto;
	private double tolerance;

	/**
	 * RecipeComponentCommodityDTO
	 * @param commodityID
	 * @param non_netto
	 * @param tolerance
	 */
	public RecipeComponentCommodityDTO(int commodityID, double non_netto, double tolerance) {
		this.commodityID = commodityID;
		this.non_netto = non_netto;
		this.tolerance = tolerance;
	}
	public int getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	public double getNon_netto() {
		return non_netto;
	}
	public void setNon_netto(double non_netto) {
		this.non_netto = non_netto;
	}
	public double getTolerance() {
		return tolerance;
	}
	public void setTolerance(double tolerance) {
		this.tolerance = tolerance;
	}

	@Override
	public String toString() {
		return "RecipeComponentCommodityDTO [commodityID=" + commodityID + ", non_netto=" + non_netto + ", tolerance="
				+ tolerance + "]";
	}


}
