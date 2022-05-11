package aiss.model.repository;

import java.util.Collection;

import aiss.model.Booklist;
import aiss.model.Book;

public interface BooklistRepository {
	
	
	// Books
	public void addBook(Book s);
	public Collection<Book> getAllBooks();
	public Book getBook(String bookId);
	public void updateBook(Book s);
	public void deleteBook(String bookId);
	
	// Playlists
	public void addBooklist(Booklist p);
	public Collection<Booklist> getAllBooklists();
	public Booklist getBooklist(String BooklistId);
	public void updateBooklist(Booklist p);
	public void deleteBooklist(String BooklistId);
	public Collection<Book> getAll(String BooklistId);
	public void addBook(String BooklistId, String bookId);
	public void removeBook(String BooklistId, String bookId); 
}
