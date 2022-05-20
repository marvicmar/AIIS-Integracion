package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.resteasy.spi.BadRequestException;

import javax.ws.rs.core.Response.ResponseBuilder;

import aiss.model.Book;
import aiss.model.Booklist;
import aiss.model.repository.BooklistRepository;
import aiss.model.repository.MapRepository;
import javassist.NotFoundException;

@Path("/booklist")
public class BooklistResource {
	
	/* Singleton */
	private static BooklistResource _instance=null;
	BooklistRepository repository;
	
	private BooklistResource() {
		repository=MapRepository.getInstance();

	}
	
	public static BooklistResource getInstance()
	{
		if(_instance==null)
				_instance=new BooklistResource();
		return _instance;
	}
	
	public Set<Book> getSetOfBookFromBooklistSet(Set<String> ids){
		Set<Book> result = new HashSet<>();
		Collection<Booklist> bookLists = repository.getAllBooklists().stream().filter(l -> ids.contains(l.getId())).collect(Collectors.toSet());
		for(Booklist list: bookLists) {
			result.addAll(list.getBooks());
		} 
		return result;
	}
	
	public List<Book> getListOfBookFromBooklistSet(Set<String> ids){
		List<Book> result = new ArrayList<>();
		Collection<Booklist> bookLists = repository.getAllBooklists().stream().filter(l -> ids.contains(l.getId())).collect(Collectors.toSet());
		for(Booklist list: bookLists) {
			result.addAll(list.getBooks());
		} 
		return result;
	}
	
	public Map<String, Long> getMapAllBookFromBooklist(List<String> ids){
		System.out.println(ids);
		System.out.println(repository.getAllBooklists().stream().map(l -> l.getId()).collect(Collectors.toList()));
		List<Book> ls = repository.getAllBooklists()
				.stream().filter(lista -> ids.contains(lista.getId()))
				.map(Booklist::getBooks).flatMap(b -> b.stream()).collect(Collectors.toList());
		
		System.out.println(ls);
		
		Map<String, Long> result = repository.getAllBooklists()
				.stream().filter(lista -> ids.contains(lista.getId()))
				.map(Booklist::getBooks)
				.flatMap(book -> book.stream())
				.collect(Collectors.groupingBy(Book::getId, Collectors.counting()));	
		return result;
	}
	

	@GET
	@Produces("application/json")
	public Collection<Booklist> getAll(@QueryParam("IsEmpty") Boolean isEmpty, @QueryParam("desc") Boolean desc, @QueryParam("name") String name)
	{
		List<Booklist> result = new ArrayList<Booklist>();
		System.out.println(desc);
		for(Booklist booklist: repository.getAllBooklists()) {
			if(isEmpty == null 
					|| (isEmpty && (booklist.getBooks() == null || booklist.getBooks().size() == 0) ) 
					|| (!isEmpty && (booklist.getBooks() != null && booklist.getBooks().size() > 0))) {
				if(name == null || booklist.getName().toLowerCase().contains(name.toLowerCase())) {
					result.add(booklist);
				}
			}
		
			
			
		}
		if(desc != null && desc) {
			Collections.sort(result, Comparator.comparing(p -> p.getName()));
		} else {
			Collections.sort(result, new ComparatorReverse());
			
		}
		
		return result;
	}
	
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Booklist get(@PathParam("id") String id) throws NotFoundException
	{
		Booklist list = repository.getBooklist(id);
		
		if (list == null) {
			throw new NotFoundException("The booklist with id="+ id +" was not found");			
		}
		
		return list;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response addBooklist(@Context UriInfo uriInfo, Booklist booklist) {
		if (booklist.getName() == null || booklist.getName().isEmpty())
			throw new BadRequestException("The name of the booklist must not be null");
		

		repository.addBooklist(booklist);

		// Builds the response. Returns the booklist the has just been added.
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(booklist.getId());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(booklist);			
		return resp.build();
	}

	
	@PUT
	@Consumes("application/json")
	public Response updateBooklist(Booklist booklist) throws NotFoundException {
		Booklist oldbooklist = repository.getBooklist(booklist.getId());
		if (oldbooklist == null) {
			throw new NotFoundException("The booklist with id="+ booklist.getId() +" was not found");			
		}
		
		// Update name
		if (booklist.getName()!=null)
			oldbooklist.setName(booklist.getName());
		
		// Update description
		if (booklist.getDescription()!=null)
			oldbooklist.setDescription(booklist.getDescription());
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response removeBooklist(@PathParam("id") String id) throws NotFoundException {
		Booklist toberemoved=repository.getBooklist(id);
		if (toberemoved == null)
			throw new NotFoundException("The booklist with id="+ id +" was not found");
		else
			repository.deleteBooklist(id);
		
		return Response.noContent().build();
	}
	
	
	@POST	
	@Path("/{booklistId}/{bookId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response addBook(@Context UriInfo uriInfo,@PathParam("booklistId") String booklistId, @PathParam("bookId") String bookId) throws NotFoundException
	{				
		
		Booklist booklist = repository.getBooklist(booklistId);
		Book book = repository.getBook(bookId);
		
		if (booklist==null)
			throw new NotFoundException("The booklist with id=" + booklistId + " was not found");
		
		if (book == null)
			throw new NotFoundException("The book with id=" + bookId + " was not found");
		
		if (booklist.getBook(bookId)!=null)
			throw new BadRequestException("The book is already included in the booklist.");
			
		repository.addBook(booklistId, bookId);		

		// Builds the response
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "get");
		URI uri = ub.build(booklistId);
		ResponseBuilder resp = Response.created(uri);
		resp.entity(booklist);			
		return resp.build();
	}
	
	
	@DELETE
	@Path("/{booklistId}/{bookId}")
	public Response removebook(@PathParam("booklistId") String booklistId, @PathParam("bookId") String bookId) throws NotFoundException {
		Booklist booklist = repository.getBooklist(booklistId);
		Book book = repository.getBook(bookId);
		
		if (booklist==null)
			throw new NotFoundException("The booklist with id=" + booklistId + " was not found");
		
		if (book == null)
			throw new NotFoundException("The book with id=" + bookId + " was not found");
		
		
		repository.removeBook(booklistId, bookId);		
		
		return Response.noContent().build();
	}
}