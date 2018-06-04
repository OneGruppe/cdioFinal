package data.dto;

public class SupplierDTO {
	private int supID;
	private String supName;
	
	public SupplierDTO(int supID, String supName) {
		super();
		this.supID = supID;
		this.supName = supName;
	}

	public int getSupID() {
		return supID;
	}

	public void setSupID(int supID) {
		this.supID = supID;
	}

	public String getSupName() {
		return supName;
	}

	public void setSupName(String supName) {
		this.supName = supName;
	}
}
