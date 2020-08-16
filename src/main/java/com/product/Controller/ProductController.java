package com.product.Controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.Entity.Cart;
import com.product.Entity.Client;
import com.product.Entity.ProductDetails;
import com.product.Entity.ProductDetailsDTO;
import com.product.Entity.StringResponse;
import com.product.ExceptionHandler.ProductException;
import com.product.Service.CartServiceInterface;
import com.product.Service.ProductDetailsServiceInterface;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDetailsServiceInterface productService;
	
	@Autowired
	private CartServiceInterface cart;
	
	private final Logger logger = LoggerFactory.getLogger( ProductController.class.getName());
	
	@PostMapping(value="/products/add")
//	@ResponseBody
	public ResponseEntity<StringResponse> addProduct(@RequestBody ProductDetailsDTO model) 
			throws IOException {
		ProductDetails pd= uplaodImage(model);
		StringResponse Response;
		if(pd!=null) {
			logger.info("Add product Successfully");
		 Response=  new StringResponse("Successful");
	}else
	{
		logger.info("product Already Exists");
		 Response= new StringResponse("Already Exist");
	}
		
		return ResponseEntity.ok(Response);
		}

	
	public  ProductDetails uplaodImage( ProductDetailsDTO model) throws IOException, ProductException {		
		System.out.println("Original Image Byte Size - " + model.getPicByte());
			
		ProductDetails pro =productService.saveProducts(model);
		
		return pro;
	}
	
@GetMapping("/GetAllProducts")
public List<ProductDetails> getAllProducts(){
	
	return productService.getAllProducts();
	
}

@PostMapping(value="/products/add/cart/{username}/{email}")
public ResponseEntity<StringResponse> CartController(@RequestBody List<Cart> model,
		@PathVariable String username,@PathVariable String email) {
	
	logger.debug("Inside product service "+ email+" "+ username);
	Client obj = cart.addToCart(model, username, email);
	
	StringResponse Response;
	if(obj!=null) {
		logger.info("Added to Cart");
	 Response=  new StringResponse("Successful");
}else
{
	logger.info("Failed to add");
	 Response= new StringResponse("Already Exist");
}
	
	return ResponseEntity.ok(Response);
	
}
@GetMapping("/GetAllProducts/cart/{email}")
public List<ProductDetailsDTO> getCartList(@PathVariable String email){
	
	return productService.getCartList(email);
	
}


}
