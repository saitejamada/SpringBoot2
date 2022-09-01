package com.movie.model;

public class Movie {
	
	String Title;
	String Year;
	String imdbID;

	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		this.Year = year;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public Movie(String title, String year, String imdbID) {
		super();
		this.Title = title;
		this.Year = year;
		this.imdbID = imdbID;
	}
	public Movie() {
		super();
	}
	@Override
	public String toString() {
		return "Movie [title=" + Title + ", year=" + Year + ", imdbID=" + imdbID + "]";
	}
	
	
	
}
