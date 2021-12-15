package com.capg.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.capg.hollywood.beans.Movies;
import com.capg.hollywood.mapstruct.dto.MovieDto;
import com.capg.hollywood.mapstruct.mappers.MovieMappersImpl;
import com.capg.hollywood.repo.IMovieRepo;
import com.capg.hollywood.services.MovieService;


@ExtendWith(MockitoExtension.class)
class HollywoodMoviesServiceTest {
	
	@Mock
    private IMovieRepo repo;
	
	@InjectMocks
	public MovieService service;
	
	@Mock
	public MovieMappersImpl mappers;
	
	@Mock
	private Movies movie;
	
	@Mock
	private MovieDto movieDto;
	
	@Mock
	private NullPointerException nullpointer;

	@Test
	void testAddMovie() {
		
		when(repo.save(movie)).thenReturn(movie);
		when(mappers.movieToMovieDto(movie)).thenReturn(movieDto);
		
		MovieDto result = service.addMovie(movie);
		
		assertEquals(movieDto,result);
		verify(repo).save(any(Movies.class));
		verify(mappers).movieToMovieDto(any(Movies.class));
		
	}

	@Test
	void testGetMovie() {
	 Optional<Movies> newMovie = Optional.of(movie);
	 final int userId =movie.getId();
	 when(repo.findById(userId)).thenReturn(newMovie);
	 when(mappers.movieToMovieDto(newMovie.get())).thenReturn(movieDto);

	 MovieDto result = service.getMovie(userId);

	 assertEquals(movieDto,result);
	 verify(repo,times(1)).findById(userId);
	}
	
	@Test
	void testGetMovieException() {
		when(repo.findById(movie.getId())).thenThrow(nullpointer);
    
		assertThrows(NullPointerException.class,()-> service.getMovie(movie.getId()));
     
		
		
	}
	

}
