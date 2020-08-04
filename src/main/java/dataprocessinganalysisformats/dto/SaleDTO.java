package dataprocessinganalysisformats.dto;

import java.io.Serializable;

public class SaleDTO implements Serializable {

	private static final long serialVersionUID = -2896043568041658230L;

	private String id;
	private String items;
	private String salesmanName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", items=" + items + ", salesmanName=" + salesmanName + "]";
	}
	
	

}
