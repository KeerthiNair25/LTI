package com.movie.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Movie")
public class Movie {
	@Id
	private String movieId;
	private String movieName;
	private String language;
	private String director;
	private String producer;
	private String cast;
	private double rating;
	private String genre;
	//private Binary image;
	
	public Movie(String movieId, String movieName, String language, String director, String producer, String cast, double rating,
			String genre) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.language = language;
		this.director = director;
		this.producer = producer;
		this.cast = cast;
		this.rating = rating;
		this.genre = genre;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
//	public Binary getImage() {
//		return image;
//	}
//	public void setImage(Binary image) {
//		this.image = image;
//	}
	
	

}
