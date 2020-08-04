package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SaleItem implements Serializable {

	private static final long serialVersionUID = 7752695424777724086L;

	@NotNull
	private Integer id;

	@NotNull
	private Integer quantity;

	@NotNull
	private BigDecimal price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SaleItem [id=" + id + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
