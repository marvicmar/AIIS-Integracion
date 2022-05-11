package aiss.api.resources;

import java.util.Comparator;

import aiss.model.Booklist;


class ComparatorReverse implements Comparator<Booklist> {

	@Override
	public int compare(Booklist o1, Booklist o2) {
		// TODO Auto-generated method stub
		return o2.getName().compareTo(o1.getName());
	}
	
}