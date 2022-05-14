package aiss.api.resources;

import java.util.Arrays;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Movie;

@Path("/movies")
public class MovieResource {
	
	
	
	private String uri = "https://api.themoviedb.org/3/movie/popular?api_key=c00b192fdcd2c592093704c75356d684";
	
	@GET
	@Produces("application/json")
	public Collection<Movie> getAll(@QueryParam("language") String language, @QueryParam("page") Integer page) {
		ClientResource cr = null;
		Movie [] movies = null;
		try {
			String urlFinal = String.format("%s&language=%s&page=%s", uri, language, page);
			cr = new ClientResource(urlFinal);
			movies = cr.get(Movie[].class);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of movies: " + cr.getResponse().getStatus());
		}
		
		return Arrays.asList(movies);
	}
}



