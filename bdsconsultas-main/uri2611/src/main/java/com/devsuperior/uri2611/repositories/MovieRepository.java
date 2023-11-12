package com.devsuperior.uri2611.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2611.dtos.MovieMinDTO;
import com.devsuperior.uri2611.entities.Movie;
import com.devsuperior.uri2611.projections.MovieMinProjection;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	@Query(nativeQuery = true, value = "SELECT movies.id, movies.name "
			+ "FROM movies "
			+ "INNER JOIN genres "
			+ "ON movies.id_genres = genres.id "
			+ "WHERE genres.description = :genreName")
	public List<MovieMinProjection> seach1(String genreName);
	
	@Query("SELECT new com.devsuperior.uri2611.dtos.MovieMinDTO(movie.id, movie.name) "
			+ "FROM Movie movie "
			+ "WHERE movie.genre.description = :genreName")
	public List<MovieMinDTO> seach2(String genreName);
	
}
