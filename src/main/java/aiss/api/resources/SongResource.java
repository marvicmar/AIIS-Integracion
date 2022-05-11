package aiss.api.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import aiss.model.Song;
import aiss.model.repository.MapPlaylistRepository;
import aiss.model.repository.PlaylistRepository;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



@Path("/songs")
public class SongResource {

	public static SongResource _instance=null;
	PlaylistRepository repository;
	
	private SongResource(){
		repository=MapPlaylistRepository.getInstance();
	}
	
	public static SongResource getInstance()
	{
		if(_instance==null)
			_instance=new SongResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Song> getAll(@QueryParam("q") String q, @QueryParam("order") String order, @QueryParam("limit") Integer limit, @QueryParam("offSet") Integer offSet)
	{	
		
		List<String> orders = List.of("album", "year", "artist");
		List<Song> result = new ArrayList<>();
		
		for(Song song: repository.getAllSongs()) {
			if(q == null || q.isBlank() 
					|| song.getTitle().toLowerCase().contains(q.toLowerCase()) 
					|| song.getAlbum().toLowerCase().contains(q.toLowerCase()) 
					|| song.getArtist().toLowerCase().contains(q.toLowerCase())) {
				result.add(song);
			}
		}
		if(order != null) {
			order = order.toLowerCase();
			if (!orders.contains(order)) {
				throw new BadRequestException("El parametro order debe contener alguno de los siguientes: "+ orders.toString() );
			} else if(order.equals(orders.get(0))) {
				Collections.sort(result, Comparator.comparing(s -> s.getAlbum()));
			} else if(order.equals(orders.get(1))) {
				Collections.sort(result, Comparator.comparing(s -> s.getYear()));
			} else if(order.equals(orders.get(2))) {
				Collections.sort(result, Comparator.comparing(s -> s.getArtist()));
			}
		}
		if(offSet != null) {
			result = result.subList(offSet, result.size());
		}
		
		if(limit != null) {
			result = result.subList(0, limit);
		}
		
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Song get(@PathParam("id") String songId)
	{
		
		return repository.getSong(songId);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addSong(@Context UriInfo uriInfo, Song song) {
		if(song.getTitle() == null || song.getTitle().isEmpty()) {
			throw new BadRequestException("Debes pasar un titulo");
		}
		if(song.getAlbum() == null || song.getAlbum().isEmpty()) {
			throw new BadRequestException("Debes pasar un Album");
		}
		if(song.getArtist() == null || song.getArtist().isEmpty()) {
			throw new BadRequestException("Debes pasar un artista");
		}
		if(song.getYear() == null || song.getYear().isEmpty()) {
			throw new BadRequestException("Debes pasar un año");
		}
		
		repository.addSong(song);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(song.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(song);
		
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateSong(Song song) {
		Song oldSong = repository.getSong(song.getId());
		
		if(oldSong == null) {
			throw new NotFoundException("No se ha encontrado la canción con Id: " + song.getId());
		}
		
		if(song.getAlbum() != null) {
			oldSong.setAlbum(song.getAlbum());
		}
		if(song.getArtist() != null) {
			oldSong.setArtist(song.getArtist());
		}
		if(song.getTitle() != null ) {
			oldSong.setTitle(song.getTitle());
		}
		if(song.getYear() != null) {
			oldSong.setYear(song.getYear());
		}
		
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeSong(@PathParam("id") String songId) {
		Song songToRemove = repository.getSong(songId);
		if(songToRemove == null) {
			throw  new NotFoundException("No se ha encontrado la cancion a eliminar");
		} else {
			repository.deleteSong(songId);
		}
		return Response.noContent().build();
	}
	
}
