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
	
	protected void setBooks(List<Book> b) {
		books = b;
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
		
		Book book =null;
		for(Book b: books)
			if (b.getId().equals(id))
			{
				book=b;
				break;
			}
		
		return book;
	}
	
	public void addBook(Book b) {
		if (books==null)
			books = new ArrayList<Book>();
		books.add(b);
	}
	
	public void deleteBook(Book b) {
		books.remove(b);
	}
	
	public void deleteBook(String id) {
		Book b = getBook(id);
		if (b!=null)
			books.remove(b);
	}

}
