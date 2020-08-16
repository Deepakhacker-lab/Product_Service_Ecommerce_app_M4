package com.product.Service;

import java.io.IOException;
import java.util.List;

import com.product.Entity.ProductDetails;
import com.product.Entity.ProductDetailsDTO;

public interface ProductDetailsServiceInterface {
	public List<ProductDetails> getAllProducts();
	
	public ProductDetails saveProducts( ProductDetailsDTO model) throws  IOException;
	
	public List<ProductDetailsDTO> getCartList(String email);
}
