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
		fundamentalsOfWavelets.setYear(0);
		fundamentalsOfWavelets.setRate(0.);
		fundamentalsOfWavelets.setPagNumber(228);
		fundamentalsOfWavelets.setPublisher("Wiley");
		addBook(fundamentalsOfWavelets);
		
		Book dataSmart=new Book();
		dataSmart.setTitle("Data Smart");
		dataSmart.setAuthor("Foreman, John");
		dataSmart.setGenre("data_science");
		dataSmart.setYear(0);
		dataSmart.setRate(0.);
		dataSmart.setPagNumber(235);
		dataSmart.setPublisher("Wiley");
		addBook(dataSmart);
		
		Book godCreatedTheIntegers=new Book();
		godCreatedTheIntegers.setTitle("God Created the Integers");
		godCreatedTheIntegers.setAuthor("Hawking, Stephen");
		godCreatedTheIntegers.setGenre("mathematics");
		godCreatedTheIntegers.setYear(0);
		godCreatedTheIntegers.setRate(0.);
		godCreatedTheIntegers.setPagNumber(197);
		godCreatedTheIntegers.setPublisher("Penguin");
		addBook(godCreatedTheIntegers);
		
		Book Superfreakonomics=new Book();
		Superfreakonomics.setTitle("Superfreakonomics");
		Superfreakonomics.setAuthor("Dubner, Stephen");
		Superfreakonomics.setGenre("economics");
		Superfreakonomics.setYear(0);
		Superfreakonomics.setRate(0.);
		Superfreakonomics.setPagNumber(179);
		Superfreakonomics.setPublisher("HarperCollins");
		addBook(Superfreakonomics);
		
		Book Orientalism=new Book();
		Orientalism.setTitle("Orientalism");
		Orientalism.setAuthor("Said, Edward");
		Orientalism.setGenre("history");
		Orientalism.setYear(0);
		Orientalism.setRate(0.);
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
	public void addBooklist(Booklist bl) {
		String id = "bl" + index++;	
		bl.setId(id);
		booklistMap.put(id,bl);
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
	public void addBook(String booklistId, String bookId) {
		Booklist booklist = getBooklist(booklistId);
		booklist.addBook(bookMap.get(bookId));
	}

	@Override
	public Collection<Book> getAll(String booklistId) {
		return getBooklist(booklistId).getBooks();
	}

	@Override
	public void removeBook(String booklistId, String bookId) {
		getBooklist(booklistId).deleteBook(bookId);
	}
	
	// Book related operations
	
	@Override
	public void addBook(Book b) {
		String id = "b" + index++;
		b.setId(id);
		bookMap.put(id, b);
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
	public void updateBook(Book b) {
		Book book = bookMap.get(b.getId());
		book.setTitle(b.getTitle());
		book.setAuthor(b.getAuthor());
		book.setGenre(b.getGenre());
		book.setYear(b.getYear());
		book.setRate(b.getRate());
		book.setPagNumber(b.getPagNumber());
		book.setPublisher(b.getPublisher());
	}

	@Override
	public void deleteBook(String bookId) {
		bookMap.remove(bookId);
	}

	
	
}
