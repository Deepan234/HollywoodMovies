package com.capg.hollywood.mapstruct.mappers;

import org.mapstruct.Mapper;

import com.capg.hollywood.beans.Movies;
import com.capg.hollywood.mapstruct.dto.MovieDto;

@Mapper(
	    componentModel = "spring"
	)
public interface IMovieMappers {
    
	MovieDto movieToMovieDto(Movies movies);
	Movies MovieDtoTomovie(MovieDto movieDto);
}
