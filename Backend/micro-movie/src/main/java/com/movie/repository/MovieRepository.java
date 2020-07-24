package com.movie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.movie.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	Movie findByMovieId(String movieId);

}
