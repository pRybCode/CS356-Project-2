import java.util.*;
import java.util.Map.Entry;

public class UserInterface 
{

	Map<String, User> userUI;
	
	public UserInterface() 
	{
		userUI = new HashMap<String, User>();
	}
	
	public void add(String key, User user)
	{
		userUI.put(key, user);
	}
	
	public String getID(String key) 
	{
		return userUI.get(key).toString();
	}
	
	public void validateUser() 
	{
		for (Entry<String, User> entry : userUI.entrySet())
		{
			if (entry == userUI || ((User) userUI).getUser().contains(" "))
			{
				System.out.println("This ID is not a valid one. Please try again.");
			}
		}
	}
}
