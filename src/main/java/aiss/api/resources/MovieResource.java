package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Movie;
import aiss.model.MovieResult;
import aiss.model.repository.BooklistRepository;
import aiss.model.repository.MapBooklistRepository;

@Path("/movies")
public class MovieResource {
	
	private static MovieResource _instance=null;
	
	
	public static MovieResource getInstance()
	{
		if(_instance==null)
				_instance=new MovieResource();
		return _instance;
	}
	
	private String uri = "https://api.themoviedb.org/3/movie/popular?api_key=c00b192fdcd2c592093704c75356d684";
	
	@GET
	@Produces("application/json")
	public MovieResult getAll(@QueryParam("language") String language, @QueryParam("page") Integer page) {
		ClientResource cr = null;
		MovieResult movies = null;
		String urlFinal = String.format("%s&language=%s&page=%s", uri, language, page);
		System.out.println("###################################################################");
		System.out.println(urlFinal);
		
		try {
			System.out.println("###################################################################movie");
			cr = new ClientResource(urlFinal);
			//System.out.println(cr.get().getText());
			movies = cr.get(MovieResult.class);
			System.out.println(movies);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of movies: " + cr.getResponse().getStatus());
			System.out.println("Error: " + re);
		}
		
		return movies;
	}
	
	@GET
	@Path("/p")
	@Produces("application/json")
	public Movie get(@QueryParam("language") String language, @QueryParam("page") Integer page) {
		ClientResource cr = null;
		Movie movie = null;
		String urlFinal = "https://api.themoviedb.org/3/movie/latest?api_key=c00b192fdcd2c592093704c75356d684&language=es-ES";
		System.out.println("###################################################################sola");
		System.out.println(urlFinal);
		
		try {
			System.out.println("###################################################################movie sola");
			cr = new ClientResource(urlFinal);
			System.out.println("###################################################################movie sola 2");
			System.out.println(cr);
			movie = cr.get(Movie.class);
			System.out.println("Resultado de movie: " + movie);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of movies: " + cr.getResponse().getStatus());
			System.out.println("Error: " + re);
		}
		
		return movie;
	}
}



