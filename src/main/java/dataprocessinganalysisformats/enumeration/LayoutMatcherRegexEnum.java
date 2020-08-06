package dataprocessinganalysisformats.enumeration;

public enum LayoutMatcherRegexEnum {

    SALESMAN(
            new StringBuilder()
                   // .append("^(?<").append(SalesmanEnum.LAYOUT_ID).append(">001)")
                    //.append("ç")
                    .append("(?<").append(SalesmanEnum.CPF).append(">[0-9]{13})")
                    .append("ç")
                    .append("(?<").append(SalesmanEnum.NAME).append(">[\\s\\S]+)")
                    .append("ç")
                    .append("(?<").append(SalesmanEnum.SALARY).append(">[0-9]*\\.?[0-9]+)")
                    .toString()
    ),
    CUSTOMER(
            new StringBuilder()
                    //.append("^(?<").append(CustomerEnum.LAYOUT_ID).append(">002)")
                   // .append("ç")
                    .append("(?<").append(CustomerEnum.CNPJ).append(">[0-9]{16})")
                    .append("ç")
                    .append("(?<").append(CustomerEnum.NAME).append(">[\\s\\S]+)")
                    .append("ç")
                    .append("(?<").append(CustomerEnum.BUSINESS_AREA).append(">[\\s\\S]+)")
                    .toString()
    ),
    SALE(
            new StringBuilder()
                    //.append("^(?<").append(SaleEnum.LAYOUT_ID).append(">003)")
                    //.append("ç")
                    .append("(?<").append(SaleEnum.ID).append(">[0-9]{0,})")
                    .append("ç")
                    .append("(?<").append(SaleEnum.ITEM).append(">\\[[0-9\\-\\,\\.]+\\])")
                    .append("ç")
                    .append("(?<").append(SaleEnum.SALESMAN_NAME).append(">[\\s\\S]+)")
                    .toString()
    ),
    SALE_ITEM(
            new StringBuilder()
                    .append("((?<").append(SaleItemEnum.ID).append(">[0-9]+)")
                    .append("-")
                    .append("(?<").append(SaleItemEnum.QUANTITY).append(">[0-9]+)")
                    .append("-")
                    .append("(?<").append(SaleItemEnum.PRICE).append(">[0-9]*\\.?[0-9]+))+")
                    .toString()
    );

    
    private String regex;
    

    public String getRegex() {
		return regex;
	}

	LayoutMatcherRegexEnum(String regex) {
        this.regex = regex;
    }
}
