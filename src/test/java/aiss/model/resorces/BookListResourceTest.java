package aiss.model.resorces;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.BeforeClass;
import org.junit.Test;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.api.resources.BooklistResource;
import aiss.model.Book;
import aiss.model.Booklist;

import aiss.model.repository.MapRepository;



public class BookListResourceTest {

	static List<Booklist> lists;
	
	
	public void valores() {
		
		ClientResource cr = null;
		Booklist[]v=null;
		try {
			cr = new ClientResource("https://wishes-350515.oa.r.appspot.com/api/booklist");
			v = cr.get(Booklist[].class);
			lists=Arrays.asList(v);
			
		} catch (ResourceException re) {
			System.err.println("Error when retrieving the collections of playlists: " + cr.getResponse().getStatus());
		}
	}
	
	
	
	@Test
	public void testGetAll()throws UnsupportedEncodingException {
		valores();
		
		
		System.out.println(lists);
	}
}
