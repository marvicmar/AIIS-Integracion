package aiss.model;

import com.google.appengine.repackaged.com.google.type.Date;

public class Movie {
	String title;
	Date release_date;
	Double vote_average;
	Integer id;
	String original_language;
	String overview;
	
	public Movie() {
		super();
	}
	
	public Movie(String title, Date release_date, Double vote_average, Integer id, String original_language,
			String overview) {
		super();
		this.title = title;
		this.release_date = release_date;
		this.vote_average = vote_average;
		this.id = id;
		this.original_language = original_language;
		this.overview = overview;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRelease_date() {
		return release_date;
	}
	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}
	public Double getVote_average() {
		return vote_average;
	}
	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	
	
	
}