package com.product.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="Cart_details"
,uniqueConstraints = {@UniqueConstraint(columnNames = {"uniqueCode", "client_id"})})
public class Cart {
	


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name="uniqueCode")
private int uniqueCode;

public int getUnique() {
	return uniqueCode;
}

public void setUnique(int unique) {
	this.uniqueCode = unique;
}

@Column(name="quantity")
private int quantity;

public int getQuantity() {
	return quantity;
	
}
public Cart(int uniqueCode, int quantity) {
	this.uniqueCode = uniqueCode;
	this.quantity = quantity;
}

public void setQuantity(int quantity) {
	this.quantity=quantity;
}

@ManyToOne(cascade= {CascadeType.DETACH,CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
@JoinColumn(name="client_id")
public Client client;

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}
public Cart() {
	
}

}
