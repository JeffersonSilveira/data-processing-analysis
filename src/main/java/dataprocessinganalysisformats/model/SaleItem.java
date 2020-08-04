package dataprocessinganalysisformats.model;

import java.io.Serializable;

public class SaleItem implements Serializable {

	private static final long serialVersionUID = 7752695424777724086L;

	private String id;
	private String quantity;
	private String unitPrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "SaleItem [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
}
