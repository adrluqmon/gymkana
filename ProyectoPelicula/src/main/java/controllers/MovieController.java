
package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import domain.Movie;
import services.MovieService;

@RestController
public class MovieController extends AbstractController {

	public MovieController() {
		super();
	}


	@Autowired
	MovieService movieService;


	@RequestMapping(value = "/moviesBBDD", method = {
		RequestMethod.POST
	})
	public ResponseEntity<Movie> registerMovies(@RequestBody final Movie movie) throws JsonParseException, JsonMappingException, IOException {


		final Movie movie2 = new Movie();
		movie2.setTitle(movie.getTitle());
		movie2.setIsAdult(movie.getIsAdult());
		movie2.setDate(movie.getDate());
		movie2.setGenres(movie.getGenres());

		//this.movieService.saveMovie(movie2);

		try {

			final String url = "jdbc:mysql://localhost:3306/ProyectoPelicula?user=root&password=US34AE1G&useSSL=false";

			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url);
			final PreparedStatement pstmt = con.prepareStatement("INSERT INTO movies(id,title,isAdult,date,genres) VALUES(?,?,?,?,?)");
			pstmt.setInt(1, movie2.getId());
			pstmt.setString(2, movie2.getTitle());
			pstmt.setBoolean(3, movie2.getIsAdult());
			pstmt.setString(4, movie2.getDate().toString());
			pstmt.setString(5, movie2.getGenres().toString());
			pstmt.execute();

		} catch (final Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}

}
