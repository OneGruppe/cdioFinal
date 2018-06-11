package data.dto;

public class ProductBatchComponentDTO 
{
	private int id;
	private int productbatchID;
	private int commodityID;
	private int userID;
	private double tara;
	private double nonNetto;
	
	/**
	 * Constructor for ProductBatchComponentDTO
	 * @param id
	 * @param productbatchID
	 * @param commodityID
	 * @param userID
	 * @param tara
	 * @param nonNetto
	 */
	public ProductBatchComponentDTO(int id, int productbatchID, int commodityID, int userID, double tara, double nonNetto)
	{
		this.id = id;
		this.productbatchID = productbatchID;
		this.commodityID = commodityID;
		this.userID = userID;
		this.tara = tara;
		this.nonNetto = nonNetto;
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
	
	public int getCommodityID()
	{
		return commodityID;
	}
	
	public void setCommodityID(int commodityID)
	{
		this.commodityID = commodityID;
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
	
	public double getNonNetto()
	{
		return nonNetto;
	}
	
	public void setNonNetto(double nonNetto)
	{
		this.nonNetto = nonNetto;
	}
	
	@Override
	public String toString() {
		return "ProductBatchComponentDTO [id=" + id + ", productbatchID=" + productbatchID + ", commodityID="
				+ commodityID + ", userID=" + userID + ", tara=" + tara + ", nonNetto=" + nonNetto + "]";
	}

}
