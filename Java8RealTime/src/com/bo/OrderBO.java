package com.bo;

import java.util.List;

public class OrderBO {

	String orderNo;
	List<Shipment> shipments;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public List<Shipment> getShipments() {
		return shipments;
	}
	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "OrderBO [orderNo=" + orderNo + ", shipments=" + shipments + "]";
	}
	
}
