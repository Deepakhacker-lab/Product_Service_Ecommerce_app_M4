package com.product.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client_details")
public class Client {

	public Client(){}
	
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone() {
		return Phone;
	}

	public void setPhone(Long phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(int postalCode) {
		PostalCode = postalCode;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

	private String Username;
	
	private String email;
	
	private long Phone;
	
	private String Address;
	
	private int PostalCode;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private List<Cart> cart;

	public List<Cart> getCart() {
		return cart;
	}


	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}


	public Client(String username, String email, long phone, String address, int postalCode) {
		super();
		Username = username;
		this.email = email;
		Phone = phone;
		Address = address;
		PostalCode = postalCode;
	}
	
	// add convenience method for bi directional relationship
	
	public void setPhone(long phone) {
		Phone = phone;
	}


	public void add(Cart tempcart) {
		
		if(cart ==null) {
			cart = new ArrayList<>();
		}
		cart.add(tempcart);
		tempcart.setClient(this);
	}
}
