package dataprocessinganalysisformats.model;

import java.io.Serializable;

public class Customer implements Serializable {

	private static final long serialVersionUID = 8373784007206112669L;

	private String cnpj;
	private String name;
	private String businessArea;

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
