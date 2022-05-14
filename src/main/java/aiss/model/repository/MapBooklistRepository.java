package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Booklist;
import aiss.model.Book;


public class MapBooklistRepository implements BooklistRepository{

	Map<String, Booklist> booklistMap;
	Map<String, Book> bookMap;
	private static MapBooklistRepository instance=null;
	private int index=0;
	
	
	public static MapBooklistRepository getInstance() {
		
		if (instance==null) {
			instance = new MapBooklistRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		booklistMap = new HashMap<String,Booklist>();
		bookMap = new HashMap<String,Book>();
		
		// Create books
		Book fundamentalsOfWavelets=new Book();
		fundamentalsOfWavelets.setTitle("Fundamentals of Wavelets");
		fundamentalsOfWavelets.setAuthor("Goswami, Jaideva");
		fundamentalsOfWavelets.setGenre("signal_processing");
		fundamentalsOfWavelets.setYear(2010);
		fundamentalsOfWavelets.setRate(8.5);
		fundamentalsOfWavelets.setPagNumber(228);
		fundamentalsOfWavelets.setPublisher("Wiley");
		addBook(fundamentalsOfWavelets);
		
		Book dataSmart=new Book();
		dataSmart.setTitle("Data Smart");
		dataSmart.setAuthor("Foreman, John");
		dataSmart.setGenre("data_science");
		dataSmart.setYear(2013);
		dataSmart.setRate(8.2);
		dataSmart.setPagNumber(235);
		dataSmart.setPublisher("Wiley");
		addBook(dataSmart);
		
		Book godCreatedTheIntegers=new Book();
		godCreatedTheIntegers.setTitle("God Created the Integers");
		godCreatedTheIntegers.setAuthor("Hawking, Stephen");
		godCreatedTheIntegers.setGenre("mathematics");
		godCreatedTheIntegers.setYear(2005);
		godCreatedTheIntegers.setRate(9.);
		godCreatedTheIntegers.setPagNumber(197);
		godCreatedTheIntegers.setPublisher("Penguin");
		addBook(godCreatedTheIntegers);
		
		Book Superfreakonomics=new Book();
		Superfreakonomics.setTitle("Superfreakonomics");
		Superfreakonomics.setAuthor("Dubner, Stephen");
		Superfreakonomics.setGenre("economics");
		Superfreakonomics.setYear(2009);
		Superfreakonomics.setRate(9.2);
		Superfreakonomics.setPagNumber(179);
		Superfreakonomics.setPublisher("HarperCollins");
		addBook(Superfreakonomics);
		
		Book Orientalism=new Book();
		Orientalism.setTitle("Orientalism");
		Orientalism.setAuthor("Said, Edward");
		Orientalism.setGenre("history");
		Orientalism.setYear(1978);
		Orientalism.setRate(8.6);
		Orientalism.setPagNumber(197);
		Orientalism.setPublisher("Penguin");
		addBook(Orientalism);
		
		// Create booklists
		Booklist booklist1=new Booklist();
		booklist1.setName("AISSBookList");
		booklist1.setDescription("AISS Book List");
		addBooklist(booklist1);
		
		Booklist booklist2 = new Booklist();
		booklist2.setName("Favourites");
		booklist2.setDescription("A sample booklist");
		addBooklist(booklist2);
		
		// Add books to booklists
		addBook(booklist1.getId(), fundamentalsOfWavelets.getId());
		addBook(booklist1.getId(), dataSmart.getId());
		addBook(booklist1.getId(), godCreatedTheIntegers.getId());
		addBook(booklist1.getId(), Superfreakonomics.getId());
		
		addBook(booklist2.getId(), Superfreakonomics.getId());
		addBook(booklist2.getId(), Orientalism.getId());
	}
	
	// Booklist related operations
	@Override
	public void addBooklist(Booklist p) {
		String id = "b" + index++;	
		p.setId(id);
		booklistMap.put(id,p);
	}
	
	@Override
	public Collection<Booklist> getAllBooklists() {
			return booklistMap.values();
	}

	@Override
	public Booklist getBooklist(String id) {
		return booklistMap.get(id);
	}
	
	@Override
	public void updateBooklist(Booklist p) {
		booklistMap.put(p.getId(),p);
	}

	@Override
	public void deleteBooklist(String id) {	
		booklistMap.remove(id);
	}

	@Override
	public void addBook(String playlistId, String songId) {
		Booklist playlist = getBooklist(playlistId);
		playlist.addBook(bookMap.get(songId));
	}

	@Override
	public Collection<Book> getAll(String playlistId) {
		return getBooklist(playlistId).getBooks();
	}

	@Override
	public void removeBook(String playlistId, String songId) {
		getBooklist(playlistId).deleteBook(songId);
	}
	
	// Book related operations
	
	@Override
	public void addBook(Book s) {
		String id = "s" + index++;
		s.setId(id);
		bookMap.put(id, s);
	}
	
	@Override
	public Collection<Book> getAllBooks() {
			return bookMap.values();
	}

	@Override
	public Book getBook(String bookId) {
		return bookMap.get(bookId);
	}

	@Override
	public void updateBook(Book s) {
		Book book = bookMap.get(s.getId());
		book.setTitle(s.getTitle());
		book.setAuthor(s.getAuthor());
		book.setGenre(s.getGenre());
		book.setYear(s.getYear());
		book.setRate(s.getRate());
		book.setPagNumber(s.getPagNumber());
		book.setPublisher(s.getPublisher());
	}

	@Override
	public void deleteBook(String bookId) {
		bookMap.remove(bookId);
	}
	
}
