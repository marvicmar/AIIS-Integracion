package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.model.Booklist;
import aiss.model.User;
import aiss.model.repository.BooklistRepository;
import aiss.model.repository.MapRepository;
import aiss.model.repository.UserRepository;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/users")
public class UserResource {
	
	public static UserResource _instance=null;
	UserRepository repository;
	BooklistRepository repository2;
	
	private UserResource(){
		repository = MapRepository.getInstance();
		repository2 = MapRepository.getInstance();
	}
	
	public static UserResource getInstance()
	{
		if(_instance==null)
			_instance=new UserResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<User> getAll(@QueryParam("name") String name, @QueryParam("order") String order, 
			@QueryParam("limit") Integer limit, @QueryParam("offSet") Integer offSet, @QueryParam("IsEmpty") Boolean isEmpty) {
		
		List<String> orders = List.of("name", "userName", "mail");
		List<User> result = new ArrayList<>();
		
		for(User user: repository.getAllUsers()) {
			if(name == null || name.isBlank()
				|| user.getName().toLowerCase().contains(name.toLowerCase())
				|| user.getUserName().contains(name)
				|| user.getEmail().contains(name)) {
				if(isEmpty == null || (isEmpty && (user.getWishList() == null 
						|| user.getWishList().size() == 0) ) 
						|| (!isEmpty && (user.getWishList() != null && user.getWishList().size() > 0))) {
					
					result.add(user);
				}
			}
		}
		
		if(order != null) {
			order = order.toLowerCase();
			if (!orders.contains(order)) {
				throw new BadRequestException("El parametro order debe contener alguno de los siguientes: "+ orders.toString() );
			} else if(order.equals(orders.get(0))) {
				Collections.sort(result, Comparator.comparing(u -> u.getName()));
			} else if(order.equals(orders.get(1))) {
				Collections.sort(result, Comparator.comparing(u -> u.getUserName()));
			} else if(order.equals(orders.get(2))) {
				Collections.sort(result, Comparator.comparing(u -> u.getEmail()));
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
	public User get(@PathParam("id") String userId) {
		return repository.getUser(userId);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addUser(@Context UriInfo uriInfo, User user) {
		if(user.getName() == null || user.getName().isEmpty()) {
			throw new BadRequestException("Debes pasar un nombre");
		}
		if(user.getUserName() == null || user.getUserName().isEmpty()) {
			throw new BadRequestException("Debes pasar un nombre de usuario");
		}
		if(user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new BadRequestException("Debes pasar un mail");
		}
		
		repository.addUser(user);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(user.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(user);
		
		return resp.build();
	}
	
	@PUT
	@Consumes("application/json")
	public Response updateUser(User user) {
		User oldUser = repository.getUser(user.getId());
		
		if(oldUser == null) {
			throw new NotFoundException("No se ha encontrado el usuario con Id: " + user.getId());
		}
		
		if(user.getName() != null || !user.getName().isEmpty()) {
			oldUser.setName(user.getName());
		}
		if(user.getUserName() != null || !user.getUserName().isEmpty()) {
			oldUser.setUserName(user.getUserName());
		}
		if(user.getEmail() != null || !user.getEmail().isEmpty()) {
			oldUser.setEmail(user.getEmail());
		}
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeUser(@PathParam("id") String userId) {
		User userToRemove = repository.getUser(userId);
		if(userToRemove == null) {
			throw new NotFoundException("No se ha encontrado el usuario a eliminar");
		} else {
			repository.deleteUser(userId);
		}
		return Response.noContent().build();
	}
	
	@POST
	@Path("/{userId}/{wishId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addWish(@Context UriInfo uriInfo, @PathParam("userId") String userId,
			@PathParam("wishId") String wishId) {
		User user = repository.getUser(userId);
		Booklist wish = repository2.getBooklist(wishId);
		//Hacer un if con movies para saber que si el wish es de libros o de películas
		
		if(user == null) {
			throw new NotFoundException("The user with id=" + userId + " was not found");
		}
		
		if (wish == null) { 
			throw new NotFoundException("The wish with id=" + wishId + " was not found");
		}
		
		if(user.getWish(wishId) != null) {
			throw new BadRequestException("The wish is already included in the user.");
		}
		
		repository.addWish(userId, wishId);
		
		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(userId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(user);			
		return resp.build();
	}
	
	@DELETE
	@Path("/{userId}/{wishId}")
	public Response removeWish(@PathParam("userId") String userId, @PathParam("wishId") String wishId) {
		User user = repository.getUser(userId);
		Booklist wish = repository2.getBooklist(wishId);
		//Hacer un if con movies para saber que si el wish es de libros o de películas
		
		if(user == null) {
			throw new NotFoundException("The user with id=" + userId + " was not found");

		}
		if (wish == null) {
			throw new NotFoundException("The wish with id=" + wishId + " was not found");
		}
		
		repository.removeWish(userId, wishId);
		
		return Response.noContent().build();
	}

}
