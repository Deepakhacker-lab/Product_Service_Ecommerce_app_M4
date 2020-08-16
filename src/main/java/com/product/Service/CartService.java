package com.product.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.product.Entity.Cart;
import com.product.Entity.Client;
import com.product.ExceptionHandler.ProductAlreadyExistInCartException;
import com.product.Repository.CartRepo;
import com.product.Repository.ClientRepo;

@Service
public class CartService implements CartServiceInterface{

	
	@Autowired
	private ClientRepo clientRepo;
	
	@Autowired
	private CartRepo cartRepo;
	

	@Transactional
	public Client addToCart(List<Cart> cart, String username, String email) {
		
		Client obj =clientRepo.findByEmail(email);
		try {
		if(obj== null) {
			Client newObj = new Client();

			newObj.setUsername(username);
			newObj.setEmail(email);
			for(Cart c: cart) {
				if(cartRepo.findByuniqueCode(c.getUnique()) == null) {
				newObj.add(c);
				}
				else {
					throw new ProductAlreadyExistInCartException("Product Already Exist in Cart");
				}
			}

			return clientRepo.save(newObj);
			
		}
		else {
			//Cart newCart = new Cart();
			for(Cart c: cart) {
				if(cartRepo.findByuniqueCode(c.getUnique()) == null) {
					obj.add(c);
					}
					else {
						throw new ProductAlreadyExistInCartException("Product Already Exist in Cart");
					}
			}
		
		return clientRepo.save(obj);
		}
		}catch(Exception exec) {
			throw new ProductAlreadyExistInCartException(exec.getMessage());
		}
		
	
	
	}
	
}
