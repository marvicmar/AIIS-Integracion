package aiss.model;

import java.util.ArrayList;
import java.util.List;

import aiss.model.repository.MapBooklistRepository;

public class User {

	private String id;
	private String name;
	private String userName;
	private String email;
	private static List<String> wishList;
	
	public User() {
	}
	
	public User(String name, String userName, String email, List<String> wishList) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.wishList = wishList;
	}
	
	public User(String id, String name, String userName, String email, List<String> wishList) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.wishList = wishList;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<String> getWishList() {
		return wishList;
	}
	
	public static String getWish(String id) {
		if (wishList ==  null) {
			return null;
		}
		
		String wish = null;
		for(String w: wishList) {
			for(Booklist bl: MapBooklistRepository.getInstance().getAllBooklists()) {
				if(bl.getId() == w) {
					wish = MapBooklistRepository.getInstance().getBooklist(w).toString();
					break;
				}
			}
		}
		return wish;
	}
	
	public void addWish(String w) {
		if (wishList == null) {
			wishList = new ArrayList<String>();
		}
		wishList.add(w);
	}
	
	public void deleteWish(String w) {
		wishList.remove(w);
	}
	
}
