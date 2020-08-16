package com.product.Entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class Order  {
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(int quantity, int orderId, double amountPaid, Date createdOn, ProductDetails product) {
		super();
		this.quantity = quantity;
		this.orderId = orderId;
		this.amountPaid = amountPaid;
		this.createdOn = LocalDateTime.now();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="OrderId")
	private int orderId;
	
	@Column(name="amountPaid")
	private double amountPaid;
	

    @Column(name = "created_on")
    private LocalDateTime createdOn;
	



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}


	
	
}
