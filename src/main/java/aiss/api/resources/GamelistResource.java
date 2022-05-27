package aiss.api.resources;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import aiss.model.Gamelist;

@Path("/gamelist")
public class GamelistResource {
	
	public static GamelistResource _instance=null;
	
	public static GamelistResource getInstance()
	{
		if(_instance==null)
			_instance=new GamelistResource();
		return _instance; 
	}
	
	private String uri = "https://indigo-computer-349516.ew.r.appspot.com/api/libraries";
	
	@GET
	@Produces("application/json")
	public List<Gamelist>  getAll(@QueryParam("name") String name) throws UnsupportedEncodingException {
        ClientResource cr = new ClientResource(uri);
        Gamelist[] games = cr.get(Gamelist[].class);
        List<Gamelist>result=new ArrayList<>();
        for (Gamelist gamelist : games) {
        	if(name == null ||  gamelist.getName().toLowerCase().contains(name.toLowerCase())) {
				result.add(gamelist);
			}
        	
		}
        return result;
    }
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Gamelist get(@PathParam("id") String gamelistId) {
		ClientResource cr = new ClientResource(uri + "/" + gamelistId);
		Gamelist result = cr.get(Gamelist.class);
        return result;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Representation addGamelist(Gamelist gamelist) {
		ClientResource cr = new ClientResource(uri);
        Representation result = cr.post(gamelist);
        return result;
	}
	
	@POST
	@Path("/{gamelistId}/{gameId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Representation addGame(@PathParam("gamelistId") String gamelistId, @PathParam("gameId") String gameId) {
		ClientResource cr = new ClientResource(uri + "/" + gamelistId + "/" + gameId);
        Representation result = cr.post("");
        return result;
	}
	
	@DELETE
	@Path("/{id}")
	public Representation removeGamelist(@PathParam("id") String gamelistId) {
		ClientResource cr = new ClientResource(uri + "/" + gamelistId);
        Representation result = cr.delete();
        return result;
	}
	
	@DELETE
	@Path("/{gamelistId}/{gameId}")
	public Representation removeGame(@PathParam("gamelistId") String gamelistId, @PathParam("gameId") String gameId) {
		ClientResource cr = new ClientResource(uri + "/" + gamelistId + "/" + gameId);
        Representation result = cr.delete();
        return result;
	}

}
