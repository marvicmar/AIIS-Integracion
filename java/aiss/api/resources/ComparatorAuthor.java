package aiss.api.resources;

import java.util.Comparator;

import aiss.model.Book;

public class ComparatorAuthor implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getAuthor().compareTo(o2.getAuthor());
	}

}
