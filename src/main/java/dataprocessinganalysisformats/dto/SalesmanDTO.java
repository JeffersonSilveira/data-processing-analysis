package dataprocessinganalysisformats.dto;

import java.io.Serializable;

public class SalesmanDTO implements Serializable {

	private static final long serialVersionUID = 5040133137899968852L;

	private String cpf;
	private String name;
	private String salary;

	public SalesmanDTO(String cpf, String name, String salary) {
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Salesman [cpf=" + cpf + ", name=" + name + ", salary=" + salary + "]";
	}

}
