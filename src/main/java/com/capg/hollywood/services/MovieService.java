package com.capg.hollywood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hollywood.beans.Movies;
import com.capg.hollywood.mapstruct.dto.MovieDto;
import com.capg.hollywood.mapstruct.mappers.IMovieMappers;
import com.capg.hollywood.repo.IMovieRepo;
import static com.capg.hollywood.utils.MovieUtils.*;

@Service("service")
public class MovieService implements IMovieService {
    
	@Autowired
	IMovieRepo repo;
	
	@Autowired
	private IMovieMappers mapper;
	
	@Override
	public MovieDto getMovie(int id) {
		// TODO Auto-generated method stub
		LOGGER.info("Get movie is intialized");
		Movies movie = repo.findById(id).orElseThrow(() -> {throw new NullPointerException("Could not be null");});
		LOGGER.info("Get movie is terminated");
		return mapper.movieToMovieDto(movie);
		
	}

	@Override
	public MovieDto addMovie(Movies movie) {
		// TODO Auto-generated method stub
		
		LOGGER.info("adding movie is intialized");
		repo.save(movie);
		LOGGER.info("adding movie is terminated");
		return mapper.movieToMovieDto(movie);
	}

}
