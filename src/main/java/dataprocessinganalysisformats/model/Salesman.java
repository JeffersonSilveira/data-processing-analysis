package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Salesman implements Serializable {

	private static final long serialVersionUID = 9059411616286903532L;

	private String cpf;
	private String name;
	private BigDecimal salary;

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

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salesman [cpf=" + cpf + ", name=" + name + ", salary=" + salary + "]";
	}
}
