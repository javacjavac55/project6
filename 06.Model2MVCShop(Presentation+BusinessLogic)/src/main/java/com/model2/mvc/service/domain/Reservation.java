package com.model2.mvc.service.domain;

public class Reservation {
	
	private int resNo;
	private String bookerId;
	private int itemNo;
	private int resOrder;
	
	public Reservation() {
	}

	public int getResNo() {
		return resNo;
	}

	public void setResNo(int resNo) {
		this.resNo = resNo;
	}

	public String getBookerId() {
		return bookerId;
	}

	public void setBookerId(String bookerId) {
		this.bookerId = bookerId;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getResOrder() {
		return resOrder;
	}

	public void setResOrder(int resOrder) {
		this.resOrder = resOrder;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reservation [resNo=");
		builder.append(resNo);
		builder.append(", bookerId=");
		builder.append(bookerId);
		builder.append(", itemNo=");
		builder.append(itemNo);
		builder.append(", resOrder=");
		builder.append(resOrder);
		builder.append("]");
		return builder.toString();
	}
	
}
