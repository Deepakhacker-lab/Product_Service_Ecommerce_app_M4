package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, String> {
	
	public Cart findByuniqueCode(int uniqueCode);

}
