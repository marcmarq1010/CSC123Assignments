package UI;

import java.util.List;

import user.User;
import user.UsersManager;

public class UserManagerApp 
{
	InputAssist ui = new InputAssist();
	UsersManager usersManager = new UsersManager();
	List<User> users;
	
	public void start()
	{
		int choice;
		do
		{
			displayMenu();
			choice = ui.getInt(Messages4.MENU_ENTER_CHOICE);
			
			switch(choice)
			{
			case 1:
				registerUser();
				break;
			case 2:
				ListUsers();
				break;
			case 3:
				System.out.println(Messages4.MENU_EXITING);
				break;
			default:
				System.out.println(Messages4.MENU_INVALID_CHOICE);
				break;
			}
			
		}while(choice != 3);
	}

	void displayMenu() 
	{
		System.out.println(Messages4.OPTION_1_REGISTER_USER);
		System.out.println(Messages4.OPTION_2_LIST_USERS);
		System.out.println(Messages4.OPTION_3_EXIT_PROGRAM);

	}

	private void registerUser() 
	{
		User u = usersManager.CreateUser(ui.getString(Messages4.REGISTER_FIRST_NAME), ui.getString(Messages4.REGISTER_LAST_NAME), ui.getString(Messages4.REGISTER_EMAIL));
		System.out.printf(Messages4.REGISTER_CONFIRMATION, u.registeredSuccess());
		System.out.println("");
	}
	
	private void ListUsers() 
	{
		users = usersManager.listUsers();
		
		 for (User user : users) 
	        {
	            System.out.println(user);
	        }
		System.out.println("");
	}
}
