package com.devsuperior.uri2602.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2602.dtos.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerMinProjection;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(nativeQuery = true, value = "SELECT c.name "
			+ "FROM customers c "
			+ "WHERE UPPER(state) = UPPER(:state)")
	List<CustomerMinProjection> search1(String state);
	
	//JPQL - Obrigatório que o nome da tabela seja igual ao nome da classe e atribuir um apelido para o objeto.
	@Query("SELECT new com.devsuperior.uri2602.dtos.CustomerMinDTO(customer.name) "
			+ "FROM Customer customer "
			+ "WHERE UPPER(customer.state) = UPPER(:state)")
	List<CustomerMinDTO> search2(String state);
}
