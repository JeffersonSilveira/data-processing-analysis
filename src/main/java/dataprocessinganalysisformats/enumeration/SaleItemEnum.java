package dataprocessinganalysisformats.enumeration;


public enum SaleItemEnum {

    ID("idSaleItem"),
    QUANTITY("quantitySaleItem"),
    PRICE("priceSaleItem");

    private String value;
    public String getValue() {
		return value;
	}
    
    SaleItemEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
