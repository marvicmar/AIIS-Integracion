package aiss.model.resorces;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import aiss.api.resources.GameResource;
import aiss.api.resources.MovieResource;
import aiss.model.Game;
import aiss.model.Movie;
import aiss.model.MovieDetails;
import aiss.model.MovieResult;

public class MovieTest {
	@Test
	public void getAllMovieTest() throws UnsupportedEncodingException {
		MovieResource movieR = new MovieResource();
		List<MovieResult> movies= movieR.getAll(null,null);
		System.out.println("PELICULAS");
		//Print games data
		for(MovieResult movie: movies) {
			
			System.out.println("pelicula->"+ movie.getOriginalTitle());
		}
	}
	
	@Test
	public void getMovieIDTest() throws UnsupportedEncodingException {
		MovieResource movieR = new MovieResource();
		String id="629542";
		MovieDetails movie= movieR.get(id);
		//Print games data
			System.out.println("pelicula->"+ movie.getOriginalTitle());
		
	}
}
