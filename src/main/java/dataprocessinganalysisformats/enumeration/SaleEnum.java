package dataprocessinganalysisformats.enumeration;


public enum SaleEnum {

    LAYOUT_ID("layoutIdSale"),
    ID("idSale"),
    ITEM("itemSale"),
    SALESMAN_NAME("salesmanNameSale");

    
    private String value;
    public String getValue() {
		return value;
	}

    SaleEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
