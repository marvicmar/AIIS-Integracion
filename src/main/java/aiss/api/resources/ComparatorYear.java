package aiss.api.resources;

import java.util.Comparator;

import aiss.model.Song;

public class ComparatorYear implements Comparator<Song>{

	@Override
	public int compare(Song o1, Song o2) {
		// TODO Auto-generated method stub
		return o1.getYear().compareTo(o2.getYear());
	}

}
