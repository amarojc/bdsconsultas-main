package com.devsuperior.uri2609;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n *** RESULT NATIVE QUERY ***");
		List<CategorySumProjection> list = categoryRepository.seach1();
		List<CategorySumDTO> result1 = list.stream().map(c -> new CategorySumDTO(c)).collect(Collectors.toList());
		result1.forEach(System.out::println);
		
		System.out.println("\n\n *** RESULT JPQL ***");
		List<CategorySumDTO> result2 = categoryRepository.seach2();
		result2.forEach(System.out::println);
	}
}
