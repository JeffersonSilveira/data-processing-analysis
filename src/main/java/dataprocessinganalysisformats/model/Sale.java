package dataprocessinganalysisformats.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import dataprocessinganalysisformats.enumeration.LayoutMatcherRegexEnum;
import dataprocessinganalysisformats.enumeration.SaleItemEnum;

public class Sale implements Serializable {

	private static final long serialVersionUID = -3764411526190454501L;

	private String id;
	private List<SaleItem> saleItems;
	private String salesmanName;

	public Sale() {
		super();
	}

	public Sale(String id, List<SaleItem> saleItems, String salesmanName) {
		super();
		this.id = id;
		this.saleItems = saleItems;
		this.salesmanName = salesmanName;
	}

	public Sale(String id, String saleItems, String salesmanName) {
		super();
		this.id = id;
		System.out.println(saleItems);
		this.salesmanName = salesmanName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<SaleItem> getSaleItems() {
		return saleItems;
	}

	public void setSaleItems(String saleItems) {

		LayoutMatcherRegexEnum layoutMatcherRegexEnum = LayoutMatcherRegexEnum.SALE_ITEM;
		Matcher matcher = Pattern.compile(layoutMatcherRegexEnum.getRegex()).matcher(saleItems);

		List<SaleItem> saleItemList = new ArrayList<>();

		while (matcher.find()) {
			SaleItem saleItem = new SaleItem();
			saleItem.setId(matcher.group(SaleItemEnum.ID.getValue()));
			saleItem.setQuantity(matcher.group(SaleItemEnum.QUANTITY.getValue()));
			saleItem.setPrice(matcher.group(SaleItemEnum.PRICE.getValue()));
			saleItemList.add(saleItem);

		}
		this.saleItems = saleItemList;

	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
	}
}
