package data.dto;

public class ProductBatchComponentDTO {

	private int id;
	private int productBatchID;
	private int commodityBatchID;
	private int userID;
	private double tara;
	private double netto;

	/**
	 * Contructor for ProductBatchComponentDTO
	 * @param id (int)
	 * @param productBatchID (int)
	 * @param commodityBatchID (int)
	 * @param userID (int)
	 * @param tara (double)
	 * @param netto (double)
	 */
	public ProductBatchComponentDTO(int id, int productBatchID, int commodityBatchID, int userID, double tara, double netto) 
	{
		this.id = id;
		this.productBatchID = productBatchID;
		this.commodityBatchID = commodityBatchID;
		this.userID = userID;
		this.tara = tara;
		this.netto = netto;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public int getProductBatchID() 
	{
		return productBatchID;
	}

	public void setProductBatchID(int productBatchID) 
	{
		this.productBatchID = productBatchID;
	}

	public int getCommodityBatchID() 
	{
		return commodityBatchID;
	}

	public void setCommodityBatchID(int commodityBatchID) 
	{
		this.commodityBatchID = commodityBatchID;
	}

	public int getUserID() 
	{
		return userID;
	}

	public void setUserID(int userID) 
	{
		this.userID = userID;
	}

	public double getTara() 
	{
		return tara;
	}

	public void setTara(double tara) 
	{
		this.tara = tara;
	}

	public double getNetto() 
	{
		return netto;
	}

	public void setNetto(double netto) 
	{
		this.netto = netto;
	}

	@Override
	public String toString() 
	{
		return "ProductBatchComponentDTO [id=" + id + ", productBatchID=" + productBatchID + ", commodityBatchID="
				+ commodityBatchID + ", userID=" + userID + ", tara=" + tara + ", netto=" + netto + "]";
	}


}
