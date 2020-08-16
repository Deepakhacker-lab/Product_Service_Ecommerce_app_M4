package com.product.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDetailsDTO {


		@JsonProperty
		private String name;

		@JsonProperty
		private int unique;

		@JsonProperty
		private double price;

		@JsonProperty
		private int availableQuantity;

		@JsonProperty
		private byte[] picByte;
		
		@JsonProperty
		private int bookingQuantity;



		public int getBookingQuantity() {
			return bookingQuantity;
		}

		public void setBookingQuantity(int bookingQuantity) {
			this.bookingQuantity = bookingQuantity;
		}

	
		public ProductDetailsDTO(String name, int unique, double price, int availableQuantity, byte[] picByte,
				int bookingQuantity) {
			super();
			this.name = name;
			this.unique = unique;
			this.price = price;
			this.availableQuantity = availableQuantity;
			this.picByte = picByte;
			this.bookingQuantity = bookingQuantity;
		}

		public byte[] getPicByte() {
			return picByte;
		}

		public void setPicByte(byte[] picByte) {
			this.picByte = picByte;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getUnique() {
			return unique;
		}

		public void setUnique(int unique) {
			this.unique = unique;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public int getAvailableQuantity() {
			return availableQuantity;
		}

		public void setAvailableQuantity(int availableQuantity) {
			this.availableQuantity = availableQuantity;
		}


	}


