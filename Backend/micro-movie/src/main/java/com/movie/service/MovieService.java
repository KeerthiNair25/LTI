package com.movie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.model.Movie;
import com.movie.repository.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	public Movie searchMovieById(String movieId) {
		Movie movieObj = movieRepo.findByMovieId(movieId);

		if (movieObj != null) {
			return movieObj;
		} else {
			return null;
		}
	}

//	public Movie saveMovie(Movie movie, MultipartFile file) throws IOException {
//		//Photo photo = new Photo();
//		movie.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
//        movie = movieRepo.insert(movie);
//        return movie;
//    }

	public Movie fetchUserByEmailId(String movieId) {
		return movieRepo.findByMovieId(movieId);
	}

	public List<Movie> findAll() {
		return movieRepo.findAll();
	}

	public Movie updateMovieDetails(String movieId, Movie movie) {
		Optional<Movie> movieData = Optional.ofNullable(movieRepo.findByMovieId(movieId));

		if (movieData.isPresent()) {
			Movie _movie = movieData.get();
			// _movie.setMovieId(movie.getMovieId());
			_movie.setMovieName(movie.getMovieName());
			_movie.setLanguage(movie.getLanguage());
			_movie.setDirector(movie.getDirector());
			_movie.setProducer(movie.getProducer());
			_movie.setCast(movie.getCast());
			_movie.setRating(movie.getRating());
			_movie.setGenre(movie.getGenre());
			return movieRepo.save(_movie);
		} else {
			return null;
		}
	}

	public String deleteMovieById(String movieId) {

		try {
			movieRepo.deleteById(movieId);
			return movieId;
		} catch (Exception e) {
			return "error";
		}

	}
}
