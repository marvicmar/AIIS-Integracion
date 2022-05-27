package aiss.api.resources;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import aiss.model.Game;

@Path("/games")
public class GameResource {
	
	public static GameResource _instance=null;
	
	public static GameResource getInstance()
	{
		if(_instance==null)
			_instance=new GameResource();
		return _instance; 
	}
	
	
	private String uri = "https://indigo-computer-349516.ew.r.appspot.com/api/games";
	
	
	@GET
	@Produces("application/json")
	public List<Game> getAll(@QueryParam("desc") Boolean desc, @QueryParam("name") String name) {
        ClientResource cr = new ClientResource(uri);
        Game[] games = cr.get(Game[].class);
        List<Game>result=new ArrayList<>();
        for (Game game : games) {
        	if(name == null || game.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(game);
			}
		}
        
        if(desc != null && desc) {
			Collections.sort(result, Comparator.comparing(p -> p.getScore()));
			Collections.reverse(result);
        } 
        return result;
    }
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Game get(@PathParam("id") String gameId) {
		ClientResource cr = new ClientResource(uri + "/" + gameId);
        Game result = cr.get(Game.class);
        return result;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Representation addGame(Game game) {
		ClientResource cr = new ClientResource(uri);
        Representation result = cr.post(game);
        return result;
	}
	
	@DELETE
	@Path("/{id}")
	public Representation removeGame(@PathParam("id") String gameId) {
		ClientResource cr = new ClientResource(uri + "/" + gameId);
        Representation result = cr.delete();
        return result;
	}

}
