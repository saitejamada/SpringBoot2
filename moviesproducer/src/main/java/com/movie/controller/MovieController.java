package com.movie.controller;


import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movie.model.Movie;
import com.movie.model.MovieResponse;

@RestController
public class MovieController {

	Movie m[];
	
	@GetMapping("/movies")
	public MovieResponse getResponse() {
		m=new Movie[5];
		m[0]=new Movie("a z c","1978","pc12");
		m[1]=new Movie("a c","1976","pc13");
		m[2]=new Movie("game of thrones","2012","got1");
		m[3]=new Movie("lord of rings","2000","lod1");
		m[4]=new Movie("a b","2002","pc14");
		MovieResponse m1=new MovieResponse("10","1","123","12",m);
		return m1;
	}
	
	@GetMapping("/movie/{Title}")
	public ArrayList getTitledMovies(@PathVariable("Title") String title) {
		m=new Movie[5];
		ArrayList al=new ArrayList<>();
		m[0]=new Movie("priates of carabiean 3","1978","pc12");
		m[1]=new Movie("priates of carabiean 2","1976","pc13");
		m[2]=new Movie("game of thrones","2012","got1");
		m[3]=new Movie("lord of rings","2000","lod1");
		m[4]=new Movie("priates of carabiean 1","2002","pc14");
		for(int i=0;i<m.length;i++)
		{
			if(m[i].getTitle().contains(title))
			{
				al.add(m[i]);	
			}	
			
		}
		return al;
	}
	
}
