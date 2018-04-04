package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import domain.Movie;
import repositories.MovieRepository;

@Service
public class MovieService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private MovieRepository movieRepository;
	
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}


}
