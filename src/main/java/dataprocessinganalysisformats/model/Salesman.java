package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Salesman implements Serializable {

	private static final long serialVersionUID = -9123377513586917140L;

	private String cpf;
	private String name;
	private BigDecimal salary;

	public Salesman() {
		super();
	}

	public Salesman(String cpf, String name, BigDecimal salary) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(String salary) {

		this.salary = salary != null ? new BigDecimal(salary) : null;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}