package dataprocessinganalysisformats.reader;


public enum CustomerEnum {

    LAYOUT_ID("layoutIdCustomer"),
    CNPJ("cnpjCustomer"),
    NAME("nameCustomer"),
    BUSINESS_AREA("businessAreaCustomer");

    private String value;
    

    public String getValue() {
		return value;
	}

	CustomerEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
