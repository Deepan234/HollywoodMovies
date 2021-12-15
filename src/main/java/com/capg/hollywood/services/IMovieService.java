package com.capg.hollywood.services;

import com.capg.hollywood.beans.Movies;
import com.capg.hollywood.mapstruct.dto.MovieDto;

public interface IMovieService {

	MovieDto getMovie(int id);

	MovieDto addMovie(Movies movie);

}
