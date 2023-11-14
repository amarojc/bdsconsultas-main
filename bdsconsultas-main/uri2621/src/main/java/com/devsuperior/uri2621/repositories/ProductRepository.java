package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dtos.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(nativeQuery = true, value = "SELECT products.name FROM products "
			+ "INNER JOIN providers "
			+ "ON providers.id = products.id_providers "
			+ "WHERE products.amount BETWEEN :amountMin AND :amountMax "
			+ "AND providers.name LIKE CONCAT(:beginName,'%')")
	public List<ProductMinProjection> seach1(Integer amountMin, Integer amountMax, String beginName);
	
	@Query("SELECT new com.devsuperior.uri2621.dtos.ProductMinDTO(product.name) "
			+ "FROM Product product "
			+ "WHERE product.amount BETWEEN :amountMin AND :amountMax "
			+ "AND product.provider.name LIKE CONCAT(:beginName,'%')")
	public List<ProductMinDTO> seach2(Integer amountMin, Integer amountMax, String beginName);
} 
