package dataprocessinganalysisformats.dto;

import java.io.Serializable;

public class SaleItemDTO implements Serializable {

	private static final long serialVersionUID = 7029728218578776319L;

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
		return "SaleItemDTO [id=" + id + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
