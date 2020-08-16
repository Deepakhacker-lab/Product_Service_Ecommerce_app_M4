package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
