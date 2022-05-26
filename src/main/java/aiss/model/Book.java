package aiss.model;

import java.util.Objects;

public class Book {

	private String id;
	private String title;
	private String author;
	private String genre;
	private Integer year;
	private Double rate;
	private Integer pagNumber;
	private String publisher;
	

	public Book() {
	}

	public Book(String title, String author, String genre, Integer year, Double rate ,Integer pagNumber, String publisher) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.rate = rate;
		this.pagNumber = pagNumber;
		this.publisher = publisher;
	}
	
	public Book(String id, String title, String author, String genre, Integer year, Double rate, Integer pagNumber, String publisher) {
		this.id=id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.rate = rate;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Double  getRate() {
		return rate;
	}
	
	public void setRate(Double rate) {
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
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, genre, id, pagNumber, publisher, rate, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(genre, other.genre)
				&& Objects.equals(id, other.id) && Objects.equals(pagNumber, other.pagNumber)
				&& Objects.equals(publisher, other.publisher) && Objects.equals(rate, other.rate)
				&& Objects.equals(title, other.title) && Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", genre=" + genre + ", year=" + year
				+ ", rate=" + rate + ", pagNumber=" + pagNumber + ", publisher=" + publisher + "]";
	}

}
