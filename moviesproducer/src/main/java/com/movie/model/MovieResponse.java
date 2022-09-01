package com.movie.model;

import java.util.Arrays;

public class MovieResponse {

	String page;
	String per_page;
	String total;
	String  total_pages;
	Movie[] data;
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getPer_page() {
		return per_page;
	}
	public void setPer_page(String per_page) {
		this.per_page = per_page;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(String total_pages) {
		this.total_pages = total_pages;
	}
	public Movie[] getData() {
		return data;
	}
	public void setData(Movie[] data) {
		this.data = data;
	}
	public MovieResponse(String page, String per_page, String total, String total_pages, Movie[] data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_pages = total_pages;
		this.data = data;
	}
	public MovieResponse() {
		super();
	}
	@Override
	public String toString() {
		return "MovieResponse [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
				+ total_pages + ", data=" + Arrays.toString(data) + "]";
	}
	
		
}
