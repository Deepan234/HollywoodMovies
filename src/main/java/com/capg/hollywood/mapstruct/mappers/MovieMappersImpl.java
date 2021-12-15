package com.capg.hollywood.mapstruct.mappers;


import org.springframework.stereotype.Component;

import com.capg.hollywood.beans.Movies;
import com.capg.hollywood.mapstruct.dto.MovieDto;
import static com.capg.hollywood.utils.MovieUtils.*;


@Component
public class MovieMappersImpl implements IMovieMappers {
	
	
	



	@Override
	public MovieDto movieToMovieDto(Movies movies) {
		// TODO Auto-generated method stub
	    LOGGER.info("Mapper from movieToMovieDto is intialized");
		MovieDto movieDto = new MovieDto();
		movieDto.setId(movies.getId());
		movieDto.setName(movies.getName());
		movieDto.setCost(movies.getCost());
		LOGGER.info("Mapper from movieToMovieDto is terminated");
		return movieDto;
	}

	@Override
	public Movies MovieDtoTomovie(MovieDto movieDto) {
		// TODO Auto-generated method stub
		LOGGER.info("Mapper from MovieDtoTomovie is intialized");
		Movies movie = new Movies();
		movie.setId(movieDto.getId());
		movie.setName(movieDto.getName());
		movie.setCost(movieDto.getCost());
		LOGGER.info("Mapper from MovieDtoTomovie is terminated");
		return null;
	}

}
