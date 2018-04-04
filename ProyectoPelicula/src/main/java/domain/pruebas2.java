
package domain;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import services.MovieService;

public class pruebas2 {

	@Autowired
	private MovieService movieService;


	public static void main(final String[] args) throws JsonParseException, JsonMappingException, IOException {

		final ObjectMapper JSON_MAPPER = new ObjectMapper();

		final Movie movie = JSON_MAPPER.readValue(new File("movie2.json"), Movie.class);

		final Movie movie2 = new Movie();
		movie2.setTitle(movie.getTitle());
		movie2.setIsAdult(movie.getIsAdult());
		movie2.setDate(movie.getDate());
		movie2.setGenres(movie.getGenres());

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

	}

}
