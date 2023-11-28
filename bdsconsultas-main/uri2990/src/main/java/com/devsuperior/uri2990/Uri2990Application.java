package com.devsuperior.uri2990;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;

@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n *** RESULT NATIVE QUERY ***");
		List<EmpregadoDeptProjection> list1 = repository.search1();
		List<EmpregadoDeptDTO> result1 = list1.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		result1.forEach(System.out::println);
		
		System.out.println("\n\n *** RESULT NATIVE QUERY NOT IN ***");
		List<EmpregadoDeptProjection> list2 = repository.search1();
		List<EmpregadoDeptDTO> result2 = list2.stream().map(x -> new EmpregadoDeptDTO(x)).collect(Collectors.toList());
		result2.forEach(System.out::println);
		
		System.out.println("\n\n *** RESULT JPQL ***");
		List<EmpregadoDeptDTO> list3 = repository.search3();
		list3.forEach(System.out::println);
	}
}
