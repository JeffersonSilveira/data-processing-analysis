package dataprocessinganalysisformats.reader;


public enum SalesmanEnum {

    LAYOUT_ID("layoutIdSalesman"),
    CPF("cpfSalesman"),
    NAME("nameSalesman"),
    SALARY("SalarySalesman");

    private String value;

    public String getValue() {
		return value;
	}
    
    SalesmanEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
