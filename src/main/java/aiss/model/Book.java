package aiss.model;

public class Book {

	private String id;
	private String title;
	private String author;
	private String genre;
	private String year;
	private Integer rate;
	private Integer pagNumber;
	private String publisher;
	

	public Book() {
	}

	public Book(String title, String author, String genre, String year, Integer pagNumber, String publisher) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.pagNumber = pagNumber;
		this.publisher = publisher;
	}
	
	public Book(String id, String title, String author, String genre, String year, Integer pagNumber, String publisher) {
		this.id=id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.pagNumber = pagNumber;
		this.publisher = publisher;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public Integer  getRate() {
		return rate;
	}
	
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	
	public Integer  getPagNumber() {
		return pagNumber;
	}
	
	public void setPagNumber(Integer pagNumber) {
		this.pagNumber = pagNumber;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void getPublisher(String publisher) {
		this.publisher = publisher;
	}

}
