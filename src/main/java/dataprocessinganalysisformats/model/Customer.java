package dataprocessinganalysisformats.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Customer implements Serializable {

    private static final long serialVersionUID = -2981957340708634808L;

    private String cnpj;
    private String name;
    private String businessArea;
        

    public Customer() {
		super();
	}



	public Customer( String cnpj, String name, String businessArea) {
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
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }
}
