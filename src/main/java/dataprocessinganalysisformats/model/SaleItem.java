package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaleItem implements Serializable {

	private static final long serialVersionUID = 3497591442981093168L;

	private Long id;
	private Long quantity;
	private BigDecimal unitPrice;

	public SaleItem(Long id, Long quantity, BigDecimal unitPrice) {
		this.id = id;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal getPrice() {
		return unitPrice.multiply(new BigDecimal(quantity));
	}

}
