package aiss.api.resources;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.Game;
import aiss.model.Movie;
import aiss.model.MovieDetails;
import aiss.model.MovieResult;
import aiss.model.repository.BooklistRepository;
import aiss.model.repository.MapRepository;

@Path("/movies")
public class MovieResource {
	
	public static MovieResource _instance=null;
	
	public static MovieResource getInstance()
	{
		if(_instance==null)
			_instance=new MovieResource();
		return _instance; 
	}
	
	private String uri = "https://api.themoviedb.org/3";
	private String key = "c00b192fdcd2c592093704c75356d684";
	
	@GET
	@Produces("application/json")
	public List<MovieResult> getAll() {
        ClientResource cr = new ClientResource(String.format("%s/movie/popular?api_key=%s", uri, key));
        List<MovieResult> result = cr.get(Movie.class).getResults();
        return result;
    }
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public MovieDetails get(@PathParam("id") String movieId) {
		ClientResource cr = new ClientResource(String.format("%s/movie/%s?api_key=%s", uri, movieId, key));
		System.out.println("##############################################1");
		MovieDetails result = cr.get(MovieDetails.class);
		System.out.println("##############################################2");
        return result;
	}
}



