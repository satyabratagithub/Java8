package com.bo;

import java.util.List;

public class Shipment {

	String shipmentId;
	String shipmentType;
	Address address;
	List<Item> items;
	public String getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(String shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getShipmentType() {
		return shipmentType;
	}
	public void setShipmentType(String shipmentType) {
		this.shipmentType = shipmentType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", shipmentType=" + shipmentType + ", address=" + address
				+ ", items=" + items + "]";
	}
	
}
