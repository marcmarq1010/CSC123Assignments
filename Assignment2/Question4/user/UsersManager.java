package user;

import java.util.ArrayList;
import java.util.List;

public class UsersManager 
{
	 List<User> users;	
	
	public UsersManager()
	{
		users = new ArrayList<User>();
	}
	
	public User CreateUser(String firstName, String LastName, String email)
	{
		User user = new User(firstName, LastName, email);
		
		users.add(user);
		
		return user;	
	}
	
	public List<User> listUsers()
	{
		return users;
	}
}
