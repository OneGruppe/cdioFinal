package data.dto;

public class ProductBatchComponentDTO {

	private int id;
	private int productbatchID;
	private int commodityBatchID;
	private int userID;
	private double tara;
	private double netto;

	/**
	 * Constructor for ProductBatchComponentDTO
	 * @param id
	 * @param productbatchID
	 * @param commodityBatchID
	 * @param userID
	 * @param tara
	 * @param netto
	 */
	public ProductBatchComponentDTO(int id, int productbatchID, int commodityBatchID, int userID, double tara, double netto)
	{
		this.id = id;
		this.productbatchID = productbatchID;
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

	public int getProductbatchID()
	{
		return productbatchID;
	}

	public void setProductbatchID(int productbatchID)
	{
		this.productbatchID = productbatchID;
	}

	public int getCommodityBatchID()
	{
		return commodityBatchID;
	}

	public void setCommodityID(int commodityBatchID)
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

	public void setNonNetto(double netto)
	{
		this.netto = netto;
	}

	@Override
	public String toString() 
	{
		return "ProductBatchComponentDTO [id=" + id + ", productbatchID=" + productbatchID + ", commodityBatchID="
				+ commodityBatchID + ", userID=" + userID + ", tara=" + tara + ", netto=" + netto + "]";
	}


}
