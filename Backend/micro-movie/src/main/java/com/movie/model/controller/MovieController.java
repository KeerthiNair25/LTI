package com.movie.model.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.movie.model.Movie;
import com.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService service;

	@PostMapping("/addMovie")
	@CrossOrigin(origins = "http://localhost:4200")
	public Movie addMovie(@RequestBody Movie movie) {
		Movie movieObj = service.saveMovie(movie);
		// String id = service.addPhoto(movieObj.getMovieId(), image);
		return movieObj;
	}

	@GetMapping("/searchMovie/{movieId}")
	public ResponseEntity<Movie> searchMovie(@PathVariable("movieId") String movieId) {
		Movie movieObj = service.searchMovieById(movieId);
		if (movieObj != null) {
			return new ResponseEntity<>(movieObj, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/allMovies")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Movie> findAllMovie() {
		// System.out.println("testing");
		return service.findAll();
	}

//	@PostMapping("/photos/add")
//    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image, Model model) throws IOException {
//        String id = photoService.addPhoto(title, image);
//        return "redirect:/photos/" + id;
//    }

	@PostMapping("/updateMovie/{movieId}")
	public ResponseEntity<Movie> updateMovie(@PathVariable("movieId") String movieId, @RequestBody Movie movie) {

		Movie movieObj = service.updateMovieDetails(movieId, movie);
		ResponseEntity<Movie> response;
		if (movieObj == null)
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else
			response = new ResponseEntity<Movie>(movieObj, HttpStatus.OK);
		return response;

	}

	@DeleteMapping("/deleteMovie/{movieId}")
	public ResponseEntity<Movie> deleteTutorial(@PathVariable("movieId") String movieId) {
		String msg;
		ResponseEntity<Movie> response = null;
		try {
			msg = service.deleteMovieById(movieId);
			if (msg != null && !msg.equals("error"))
				response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		return response;
	}

//	@GetMapping("/tutorials/{id}")
//	  public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") String id) {
//	    
//	  }
//
//	  @PostMapping("/tutorials")
//	  public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//	    
//	  }
//
//	  @PutMapping("/tutorials/{id}")
//	  public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") String id, @RequestBody Tutorial tutorial) {
//	    
//	  }
//
//	  @DeleteMapping("/tutorials/{id}")
//	  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") String id) {
//	    
//	  }
//
//	  @DeleteMapping("/tutorials")
//	  public ResponseEntity<HttpStatus> deleteAllTutorials() {
//	    
//	  }
//
//	  @GetMapping("/tutorials/published")
//	  public ResponseEntity<List<Tutorial>> findByPublished() {
//	    
//	  }

}
