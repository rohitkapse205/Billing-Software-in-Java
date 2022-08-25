package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {
	// properties
	@Id
	private String cname;
	private int c_phone;
	private String id;
	private String pname;
	private int qty;
	private double price;
	private double totalPrice;

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getC_phone() {
		return c_phone;
	}

	public void setC_phone(int c_phone) {
		this.c_phone = c_phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Bill(String cname, int c_phone, String id2, String productName, int quantity, double price2,
			double totalPrice2) {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(String cname2, int c_phone2, String id2, int qty2, String productName, String pname2, int quantity,
			Double price1, double totalPrice2) {
		// TODO Auto-generated constructor stub
	}

	public Bill() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bill [cname=" + cname + ", c_phone=" + c_phone + ", id=" + id + ", pname=" + pname + ", qty=" + qty
				+ ", price=" + price + ", totalPrice=" + totalPrice + "]";
	}

	public static void displayFormat() {
		// TODO Auto-generated method stub

	}

	public void display() {
		// TODO Auto-generated method stub

	}

	public void print() {
		// TODO Auto-generated method stub

	}

	// public void print() {
	// TODO Auto-generated method stub

	// }

}
