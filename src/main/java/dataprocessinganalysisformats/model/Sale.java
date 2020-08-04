package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Sale implements Serializable {

	private static final long serialVersionUID = -3817343393131112677L;

	@NotNull	
	private Integer id;
	
	private List<SaleItem> items;
    
    @NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "[a-zA-Z\\s]+", message = "Nome deve ser alfabético")
	private String salesmanName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
