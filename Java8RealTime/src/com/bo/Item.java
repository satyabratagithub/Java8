package com.bo;

public class Item {

	String itemId;
	double price;
	String itemType;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", price=" + price + ", itemType=" + itemType + "]";
	}
	
}
