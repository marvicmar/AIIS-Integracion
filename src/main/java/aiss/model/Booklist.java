package aiss.model;

import java.util.ArrayList;
import java.util.List;

public class Booklist {

	private String id;
	private String name;
	private String description;
	private List<Book> books;
	
	public Booklist() {}
	
	public Booklist(String name) {
		this.name = name;
	}
	
	protected void setBooks(List<Book> s) {
		books = s;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public Book getBook(String id) {
		if (books==null)
			return null;
		
		Book song =null;
		for(Book s: books)
			if (s.getId().equals(id))
			{
				song=s;
				break;
			}
		
		return song;
	}
	
	public void addBook(Book s) {
		if (books==null)
			books = new ArrayList<Book>();
		books.add(s);
	}
	
	public void deleteBook(Book s) {
		books.remove(s);
	}
	
	public void deleteBook(String id) {
		Book s = getBook(id);
		if (s!=null)
			books.remove(s);
	}

}
