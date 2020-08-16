package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, String>{

	public Client findByEmail(String email);



}
