package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sale implements Serializable {

	private static final long serialVersionUID = -3817343393131112677L;

	private Long id;
	private List<SaleItem> items = new ArrayList<>();
	private String salesmanName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<SaleItem> getItems() {
		return items;
	}

	public void setItems(List<SaleItem> items) {
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
