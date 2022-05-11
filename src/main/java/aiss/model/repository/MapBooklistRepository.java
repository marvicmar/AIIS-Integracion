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
	private int index=0;			// Index to create Booklists and Books' identifiers.
	
	
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
		fundamentalsOfWavelets.setYear("1956");
		fundamentalsOfWavelets.setRate(0);
		fundamentalsOfWavelets.setPagNumber(228);
		fundamentalsOfWavelets.setPublisher("Wiley");
		addBook(fundamentalsOfWavelets);
		
		Book dataSmart=new Book();
		dataSmart.setTitle("Data Smart");
		dataSmart.setAuthor("Foreman, John");
		dataSmart.setGenre("data_science");
		dataSmart.setYear("1986");
		dataSmart.setRate(0);
		dataSmart.setPagNumber(235);
		dataSmart.setPublisher("Wiley");
		addBook(dataSmart);
		
		Book godCreatedTheIntegers=new Book();
		godCreatedTheIntegers.setTitle("God Created the Integers");
		godCreatedTheIntegers.setAuthor("Hawking, Stephen");
		godCreatedTheIntegers.setGenre("mathematics");
		godCreatedTheIntegers.setYear("1909");
		godCreatedTheIntegers.setRate(0);
		godCreatedTheIntegers.setPagNumber(197);
		godCreatedTheIntegers.setPublisher("Penguin");
		addBook(godCreatedTheIntegers);
		
		Book Superfreakonomics=new Book();
		Superfreakonomics.setTitle("Superfreakonomics");
		Superfreakonomics.setAuthor("Dubner, Stephen");
		Superfreakonomics.setGenre("economics");
		Superfreakonomics.setYear("1980");
		Superfreakonomics.setRate(0);
		Superfreakonomics.setPagNumber(179);
		Superfreakonomics.setPublisher("HarperCollins");
		addBook(Superfreakonomics);
		
		Book orientalism=new Book();
		orientalism.setTitle("Orientalism");
		orientalism.setAuthor("Said, Edward");
		orientalism.setGenre("history");
		orientalism.setYear("1989");
		orientalism.setRate(0);
		orientalism.setPagNumber(197);
		orientalism.setPublisher("Penguin");
		addBook(orientalism);
		
		// Create Booklists
		Booklist jaBooklist=new Booklist();
		jaBooklist.setName("AISSBooklist");
		jaBooklist.setDescription("AISS Booklist");
		addBooklist(jaBooklist);
		
		Booklist booklist = new Booklist();
		booklist.setName("Favourites");
		booklist.setDescription("A sample Booklist");
		addBooklist(booklist);
		
		// Add Books to Booklists
		addBook(jaBooklist.getId(), rollingInTheDeep.getId());
		addBook(jaBooklist.getId(), one.getId());
		addBook(jaBooklist.getId(), smellLikeTeenSpirit.getId());
		addBook(jaBooklist.getId(), losingMyReligion.getId());
		
		addBook(booklist.getId(), losingMyReligion.getId());
		addBook(booklist.getId(), gotye.getId());
	}
	
	// Booklist related operations
	@Override
	public void addBooklist(Booklist p) {
		String id = "p" + index++;	
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
	public void addBook(String BooklistId, String bookId) {
		Booklist booklist = getBooklist(BooklistId);
		booklist.addBook(bookMap.get(bookId));
	}

	@Override
	public Collection<Book> getAll(String BooklistId) {
		return getBooklist(BooklistId).getBooks();
	}

	@Override
	public void removeBook(String BooklistId, String bookId) {
		getBooklist(BooklistId).deleteBook(bookId);
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
		book.setPagNumber(s.getPagNumber());
		book.setRate(s.getRate());
		book.setPublisher(s.getPublisher());
		
	}

	@Override
	public void deleteBook(String bookId) {
		bookMap.remove(bookId);
	}
	
}
