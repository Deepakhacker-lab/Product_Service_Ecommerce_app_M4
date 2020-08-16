package com.product.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product", schema="product")
public class ProductDetails {

  public ProductDetails() {
  
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;

@Column(name = "name")

private String name;

@Column(name="unique_Code")
private int uniqueCode;

public int getUnique() {
	return uniqueCode;
}

public void setUnique(int unique) {
	this.uniqueCode = unique;
}



@Column(name="price")
private double price;

@Column(name="quantity")
private int AvailableQuantity;




//image bytes can have large lengths so we specify a value



//which is more than the default length for picByte column



@Column(name = "picByte", length = 1000)

private byte[] picByte;


public String getName() {

    return name;

}

public void setName(String name) {

    this.name = name;

}



public double getPrice() {
	return price;
}



public ProductDetails(String name, int unique, double price, int availableQuantity, byte[] picByte) {
	super();
	this.name = name;
	this.uniqueCode = unique;
	this.price = price;
	this.AvailableQuantity = availableQuantity;
	this.picByte = picByte;
}

public void setPrice(double price) {
	this.price = price;
}

public int getAvailableQuantity() {
	return AvailableQuantity;
}

public void setAvailableQuantity(int availableQuantity) {
	AvailableQuantity = availableQuantity;
}

public byte[] getPicByte() {
return picByte;

}

public void setPicByte(byte[] picByte) {
 this.picByte = picByte;

}


}

