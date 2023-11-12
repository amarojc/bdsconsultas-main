package com.devsuperior.uri2611;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2611.dtos.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner{
	
	@Autowired
	private MovieRepository movieRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\n *** RESULT NATIVE QUERY ***");
		List<MovieMinProjection> list = movieRepository.seach1("Action");
		List<MovieMinDTO> result1 = list.stream().map(m -> new MovieMinDTO(m)).collect(Collectors.toList());
		
		for (MovieMinDTO m : result1) {
			System.out.println(m);
		}
		
		System.out.println("\n\n *** RESULT JPQL ***");
		List<MovieMinDTO> result2 = movieRepository.seach2("Action");
		 result2.forEach(System.out::println);
	}
}
