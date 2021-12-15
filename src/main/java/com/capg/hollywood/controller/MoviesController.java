package com.capg.hollywood.controller;

import static com.capg.hollywood.utils.MovieUtils.*;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.capg.hollywood.services.IMovieService;
import com.capg.hollywood.utils.MovieUtils;
import com.capg.hollywood.beans.Movies;
import com.capg.hollywood.mapstruct.dto.MovieDto;
@RestController
@CrossOrigin
@RequestMapping(MAPPINGLINK)
public class MoviesController {
	

	@Autowired
	private IMovieService service;
	
	@PostMapping(ADDMETHOD)
	public ResponseEntity<MovieDto> addMovie(@RequestBody Movies movie) {
		LOGGER.info("AddMovie Controller is intiated");
		MovieDto movieDto =service.addMovie(movie);
		LOGGER.info("AddMovie Controller is terminated");
		return new ResponseEntity<MovieDto>(movieDto,HttpStatus.OK);
		
	}
	
	@GetMapping(GETMETHOD)
	public ResponseEntity<MovieDto> getMovie(@PathVariable int id){
		LOGGER.info("GetMovie Controller is intiated");
		MovieDto movieDto = service.getMovie(id);
		LOGGER.info("GetMovie Controller is terminated");
	    return new  ResponseEntity<MovieDto>(movieDto,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value = ConstraintViolationException.class)
	public ResponseEntity<Object> exceptionConstraintViolationException(ConstraintViolationException exception) {
	StringBuilder msg = new StringBuilder();
	exception.getConstraintViolations().forEach(i -> msg.append(i.getConstraintDescriptor().getMessageTemplate()));
	return new ResponseEntity<>(msg.toString(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = NullPointerException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(NullPointerException exception) {
	return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> exceptionInvalidInputException(MethodArgumentTypeMismatchException exception) {
	return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
