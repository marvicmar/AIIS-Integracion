package aiss.api.resources;

import java.util.Comparator;

import aiss.model.Book;

public class ComparatorYear implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getYear().compareTo(o2.getYear());
	}

}
