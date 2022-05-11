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

import aiss.model.Book;
import aiss.model.repository.BooklistRepository;
import aiss.model.repository.MapPlaylistRepository;


import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



@Path("/books")
public class BookResource {

	public static BookResource _instance=null;
	BooklistRepository repository;
	
	private BookResource(){
		repository=MapPlaylistRepository.getInstance();
	}
	
	public static BookResource getInstance()
	{
		if(_instance==null)
			_instance=new BookResource();
		return _instance; 
	}
	
	@GET
	@Produces("application/json")
	public Collection<Book> getAll(@QueryParam("q") String q, @QueryParam("order") String order, @QueryParam("limit") Integer limit, @QueryParam("offSet") Integer offSet)
	{	
		
		List<String> orders = List.of("genre", "year", "artist");
		List<Book> result = new ArrayList<>();
		
		for(Book book: repository.getAllBooks()) {
			if(q == null || q.isBlank() 
					|| book.getTitle().toLowerCase().contains(q.toLowerCase()) 
					|| book.getGenre().toLowerCase().contains(q.toLowerCase()) 
					|| book.getAuthor().toLowerCase().contains(q.toLowerCase())) {
				result.add(book);
			}
		}
		if(order != null) {
			order = order.toLowerCase();
			if (!orders.contains(order)) {
				throw new BadRequestException("El parametro order debe contener alguno de los siguientes: "+ orders.toString() );
			} else if(order.equals(orders.get(0))) {
				Collections.sort(result, Comparator.comparing(s -> s.getGenre()));
			} else if(order.equals(orders.get(1))) {
				Collections.sort(result, Comparator.comparing(s -> s.getYear()));
			} else if(order.equals(orders.get(2))) {
				Collections.sort(result, Comparator.comparing(s -> s.getAuthor()));
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
	public Book get(@PathParam("id") String bookId)
	{
		
		return repository.getBook(bookId);
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addBook(@Context UriInfo uriInfo, Book book) {
		if(book.getTitle() == null || book.getTitle().isEmpty()) {
			throw new BadRequestException("Debes pasar un titulo");
		}
		if(book.getGenre() == null || book.getGenre().isEmpty()) {
			throw new BadRequestException("Debes pasar un Genre");
		}
		if(book.getAuthor() == null || book.getAuthor().isEmpty()) {
			throw new BadRequestException("Debes pasar un autor");
		}
		if(book.getYear() == null || book.getYear().isEmpty()) {
			throw new BadRequestException("Debes pasar un año");
		}
		
		repository.addBook(book);
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(book.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(book);
		
		return resp.build();
	}
	
	
	@PUT
	@Consumes("application/json")
	public Response updateBook(Book book) {
		Book oldBook = repository.getBook(book.getId());
		
		if(oldBook == null) {
			throw new NotFoundException("No se ha encontrado la canción con Id: " + book.getId());
		}
		
		if(book.getGenre() != null) {
			oldBook.setGenre(book.getGenre());
		}
		if(book.getAuthor() != null) {
			oldBook.setAuthor(book.getAuthor());
		}
		if(book.getTitle() != null ) {
			oldBook.setTitle(book.getTitle());
		}
		if(book.getYear() != null) {
			oldBook.setYear(book.getYear());
		}
		
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeBook(@PathParam("id") String bookId) {
		Book bookToRemove = repository.getBook(bookId);
		if(bookToRemove == null) {
			throw  new NotFoundException("No se ha encontrado la cancion a eliminar");
		} else {
			repository.deleteBook(bookId);
		}
		return Response.noContent().build();
	}
	
}
