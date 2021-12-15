package com.capg.hollywood.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capg.hollywood.beans.Movies;

public interface IMovieRepo extends JpaRepository<Movies,Integer>{
	
	

}
