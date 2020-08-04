package dataprocessinganalysisformats.dto;

import java.io.Serializable;

public class CustomerDTO  implements Serializable{


	private static final long serialVersionUID = 4220563300869587770L;
	
	private String cnpj;
	private String name;
	private String businessArea;

	public CustomerDTO(String cnpj, String name, String businessArea) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

	@Override
	public String toString() {
		return "Customer [cnpj=" + cnpj + ", name=" + name + ", businessArea=" + businessArea + "]";
	}

}
