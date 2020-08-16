package com.product.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.Entity.Cart;
import com.product.Entity.Client;
import com.product.Entity.ProductDetails;
import com.product.Entity.ProductDetailsDTO;
import com.product.ExceptionHandler.ProductException;
import com.product.Repository.ClientRepo;
import com.product.Repository.ProductDetailsRepo;

@Service
public class ProductDetailsService implements  ProductDetailsServiceInterface{
	
	@Autowired
	private ProductDetailsRepo productRepo;
	
	@Autowired
	private ClientRepo clientRepo;
	
//	@Autowired
//	private CartRepo cartRepo;
	
	// to get all products
	public List<ProductDetails> getAllProducts(){
		
		return productRepo.findAll();
	}
	


	
	public ProductDetails saveProducts( ProductDetailsDTO product) throws  IOException {
		ProductDetails pd = productRepo.findByUniqueCode(product.getUnique());
		
		if(pd==null) {
		ProductDetails pro= new ProductDetails(product.getName(),
				product.getUnique(),
				product.getPrice(),
				product.getAvailableQuantity(),
				compressBytes(product.getPicByte()));
		
		
		return productRepo.save(pro);
		}
		else {
			 throw new ProductException("Product Already Exist");
		}
	}

	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);		return outputStream.toByteArray();
	}

	// to get cart list
	@Override
	public List<ProductDetailsDTO> getCartList(String email) {

		Client obj = clientRepo.findByEmail(email);
		List<ProductDetailsDTO> prod = new ArrayList<>();
		List<Cart> cartObj = obj.getCart();
		
		for(Cart c : cartObj) {
			ProductDetails prod1 = productRepo.findByUniqueCode(c.getUnique());
			ProductDetailsDTO dto =new ProductDetailsDTO(prod1.getName(), prod1.getUnique(), prod1.getPrice()
					, prod1.getAvailableQuantity(), prod1.getPicByte(),c.getQuantity());
			prod.add(dto);
		}
		
		return prod;
	}
	

	



}
