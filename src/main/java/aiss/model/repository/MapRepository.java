package aiss.model.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import aiss.model.Booklist;
import aiss.model.User;
import aiss.model.Book;


public class MapRepository implements BooklistRepository, UserRepository{

	Map<String, Booklist> booklistMap;
	Map<String, Book> bookMap;
	Map<String, User> userMap;
	private static MapRepository instance=null;
	private int index=0;
	
	
	public static MapRepository getInstance() {
		
		if (instance==null) {
			instance = new MapRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		
		booklistMap = new HashMap<String,Booklist>();
		bookMap = new HashMap<String,Book>();
		userMap = new HashMap<String, User>();
		
		// Create books
		Book fundamentalsOfWavelets=new Book();
		fundamentalsOfWavelets.setTitle("Fundamentals of Wavelets");
		fundamentalsOfWavelets.setAuthor("Goswami, Jaideva");
		fundamentalsOfWavelets.setGenre("signal_processing");
		fundamentalsOfWavelets.setYear(2010);
		fundamentalsOfWavelets.setRate(9.);
		fundamentalsOfWavelets.setPagNumber(228);
		fundamentalsOfWavelets.setPublisher("Wiley");
		addBook(fundamentalsOfWavelets);
		
		Book dataSmart=new Book();
		dataSmart.setTitle("Data Smart");
		dataSmart.setAuthor("Foreman, John");
		dataSmart.setGenre("data_science");
		dataSmart.setYear(2013);
		dataSmart.setRate(9.);
		dataSmart.setPagNumber(235);
		dataSmart.setPublisher("Wiley");
		addBook(dataSmart);
		
		Book godCreatedTheIntegers=new Book();
		godCreatedTheIntegers.setTitle("God Created the Integers");
		godCreatedTheIntegers.setAuthor("Hawking, Stephen");
		godCreatedTheIntegers.setGenre("mathematics");
		godCreatedTheIntegers.setYear(2005);
		godCreatedTheIntegers.setRate(8.2);
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
		Orientalism.setRate(9.2);
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
		
		Booklist booklist3 = new Booklist();
		booklist3.setName("Read");
		booklist3.setDescription("Books I have read");
		addBooklist(booklist3);
		
		// Create users
		User belen = new User();
		belen.setName("Belen Fraga");
		belen.setUserName("bel_fra");
		belen.setEmail("belenFra@mail.com");
		addUser(belen);
		
		User carlos = new User();
		carlos.setName("Carlos Fuentes");
		carlos.setUserName("carl_fuen");
		carlos.setEmail("carlFuent@mail.com");
		addUser(carlos);
		
		User justa = new User();
		justa.setName("Justa Soto");
		justa.setUserName("just_soto");
		justa.setEmail("justSoto@mail.com");
		addUser(justa);
		
		User biel = new User();
		biel.setName("Biel Pulido");
		biel.setUserName("biel_pul");
		biel.setEmail("bielPul@mail.com");
		addUser(biel);
		
		User mateo = new User();
		mateo.setName("Mateo del Campo");
		mateo.setUserName("mate_camp");
		mateo.setEmail("mateoDelCamp@mail.com");
		addUser(mateo);
		
		// Add books to booklists
		addBook(booklist1.getId(), fundamentalsOfWavelets.getId());
		addBook(booklist1.getId(), dataSmart.getId());
		addBook(booklist1.getId(), godCreatedTheIntegers.getId());
		addBook(booklist1.getId(), Superfreakonomics.getId());
		
		addBook(booklist2.getId(), Superfreakonomics.getId());
		addBook(booklist2.getId(), Orientalism.getId());
		
		addBook(booklist3.getId(), dataSmart.getId());
		addBook(booklist3.getId(), godCreatedTheIntegers.getId());
		addBook(booklist3.getId(), Superfreakonomics.getId());
		
		
		// Add wishes to user
		addWish(belen.getId(), booklist1.getId());
		addWish(belen.getId(), booklist2.getId());
		
		addWish(carlos.getId(), booklist2.getId());
		
		addWish(justa.getId(), booklist1.getId());
		addWish(justa.getId(), booklist3.getId());
		addWish(justa.getId(), booklist2.getId());
		
		addWish(biel.getId(), booklist1.getId());
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
	
	// User related operation
	
	@Override
	public void addUser(User u) {
		String id = "u" + index++;
		u.setId(id);
		userMap.put(id, u);
	}
	
	@Override
	public Collection<User> getAllUsers() {
			return userMap.values();
	}
	
	@Override
	public User getUser(String userId) {
		return userMap.get(userId);
	}
	
	@Override
	public void updateUser(User u) {
		userMap.put(u.getId(),u);
	}
	
	@Override
	public void deleteUser(String userId) {
		userMap.remove(userId);
	}
	
	@Override
	public Collection<String> getAllWishes(String userId) {
		return getUser(userId).getWishList();
	}
	
	@Override
	public void addWish(String userId, String wishId) {
		User user = getUser(userId);
		user.addWish(wishId);
	}
	
	@Override
	public void removeWish(String userId, String wishId) {
		getUser(userId).deleteWish(wishId);
	}
	

	
	
}
