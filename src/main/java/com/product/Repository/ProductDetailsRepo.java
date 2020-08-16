package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.ProductDetails;
@Repository
public interface ProductDetailsRepo extends JpaRepository<ProductDetails, Integer> {
	
	 ProductDetails findByUniqueCode(int i);

}
