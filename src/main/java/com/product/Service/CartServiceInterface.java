package com.product.Service;

import java.util.List;

import com.product.Entity.Cart;
import com.product.Entity.Client;

public interface CartServiceInterface {

	public Client addToCart(List<Cart> cart, String username, String email);
	
	
}
