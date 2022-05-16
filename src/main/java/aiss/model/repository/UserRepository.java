package aiss.model.repository;

import java.util.Collection;

import aiss.model.User;

public interface UserRepository {
	
	public void addUser(User u);
	public Collection<User> getAllUsers();
	public User getUser(String userId);
	public void updateUser(User u);
	public void deleteUser(String userId);
	public Collection<String> getAllWishes(String userId);
	public void addWish(String userId, String wishId);
	public void removeWish(String userId, String wishId);

}
