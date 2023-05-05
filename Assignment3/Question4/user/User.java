package user;

public class User 
{
	private int userNum;
	private static int nextUserNum = 1;
	private String firstName;
	private String lastName;
	private String email;
	
	public User(String firstName, String lastName, String email)
	{
		userNum = nextUserNum;
		nextUserNum++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public String registeredSuccess()
	{
		return firstName + " " + lastName + " (" + email + ") ";
	}

	@Override
	public String toString() 
	{
		return userNum + " - " + lastName + ", " + firstName + " (" + email + " ) ";
	}
	
	
}
