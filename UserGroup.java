import java.util.Map;
import java.util.Map.Entry;

public class UserGroup implements Component
{
	Map<String, UserGroup> numUserGroup;
	private String UserGroup;
	private long creationTime;
	
	public UserGroup(String createUserGroup) 
	{
		setCreationTime(System.currentTimeMillis());
		this.UserGroup = createUserGroup;
	}
	
	public void setCreationTime(long creationTime) 
	{
		this.creationTime = creationTime;
	}
	
	public long getCreationTime() 
	{
		return creationTime;
	}
	
	public String getUserGroup() 
	{
		return UserGroup;
	}

	public void setUserName(String UserGroup)
	{
		this.UserGroup = UserGroup;
	}
	
	public String toString() 
	{
		return UserGroup;
	}
	
	public String validateUserGroup() 
	{
		for (Entry<String, UserGroup> entry : numUserGroup.entrySet())
		{
			if (entry == numUserGroup || ((UserGroup) numUserGroup).getUserGroup().contains(" ")) 
			{
				return "This UserGroup ID is not a valid one. Please try again.";
			}
		}
		return "";
	}
	
}
