package com.devsuperior.uri2621;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dtos.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n *** RESULT NATIVE QUERY ***");
		List<ProductMinProjection> list = productRepository.seach1(10, 20, "P");
		List<ProductMinDTO> result1 = list.stream().map(p -> new ProductMinDTO(p)).collect(Collectors.toList());
		
		for (ProductMinDTO p : result1) {
			System.out.println("\n" + p);
		}
		
		System.out.println("\n\n *** RESULT JPQL ***");
		List<ProductMinDTO> result2 = productRepository.seach2(10, 20, "P");
		result2.forEach(System.out::println);
		
	}
}
