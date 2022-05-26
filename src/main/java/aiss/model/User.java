package aiss.model;

import java.util.HashSet;
import java.util.Set;

import aiss.model.repository.MapRepository;

public class User {

	private String id;
	private String name;
	private String userName;
	private String email;
	private Gender gender;
	private Set<String> wishList;
	
	public User() {
	}
	
	public User(String name, String userName, String email, Gender gender, Set<String> wishList) {
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.gender =  gender;
		this.wishList = wishList;
	}
	
	public User(String id, String name, String userName, String email, Gender gender, Set<String> wishList) {
		this.id = id;
		this.name = name;
		this.userName = userName;
		this.email = email;
		this.gender = gender;
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
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Set<String> getWishList() {
		return wishList;
	}
	
	public String getWish(String id) {
		if (wishList ==  null) {
			return null;
		}
		
		String wish = null;
		for(String w: wishList) {
			for(Booklist bl: MapRepository.getInstance().getAllBooklists()) {
				if(bl.getId() == w) {
					wish = MapRepository.getInstance().getBooklist(w).toString();
					break;
				}
			}
		}
		return wish;
	}
	
	public void addWish(String w) {
		if (wishList == null) {
			wishList = new HashSet<String>();
		}
		wishList.add(w);
	}
	
	public void deleteWish(String w) {
		wishList.remove(w);
	}
	
}
