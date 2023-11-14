package com.devsuperior.uri2609.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.entities.Category;
import com.devsuperior.uri2609.projections.CategorySumProjection;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query(nativeQuery = true, value = "SELECT categorie.name, SUM(product.amount) FROM categories categorie "
			+ "INNER JOIN products product "
			+ "ON product.id_categories = categorie.id "
			+ "GROUP BY categorie.name")
	List<CategorySumProjection> seach1();
	
	@Query("SELECT new com.devsuperior.uri2609.dto.CategorySumDTO(product.category.name, SUM(product.amount)) "
			+ "FROM Product product "
			+ "GROUP BY product.category.name")
	List<CategorySumDTO> seach2();
}
