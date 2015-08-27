import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

public class UserGroup implements Component
{
	private ArrayList<Component> groupMembers = new ArrayList<Component>();
	private String userGroup;
	
	public UserGroup(String groupName) 
	{
		userGroup = groupName;
	}
	
	public void add(Component comp)
	{
		groupMembers.add(comp);
	}
	
	public String getGroupName() 
	{
		return userGroup;
	}

	public void setGroupName(String groupName)
	{
		userGroup = groupName;
	}
	
	public String toString()
	{
		String retVal = " ~" + userGroup;
		for(Component comps: groupMembers)
		{
			retVal +=  "\n" + "   -" + comps.toString();
		}
		return retVal;
	}
	
	public Component update(User poster, String tweet) 
	{
		ArrayList<Component> updateGroupMem = new ArrayList<Component>();
		for(Component comps: groupMembers)
		{
			updateGroupMem.add(comps.update(poster, tweet));
		}
		groupMembers = updateGroupMem;
		return this;
	}
	
	public boolean isGroup()
	{
		return true;
	}
	
	public ArrayList<Component> getGroup()
	{
		return groupMembers;
	} 
	
	public User findUser(String userName, UserGroup group)
	{
		ArrayList<Component> groupList = group.getGroup();
		for(Component comp: groupList)
		{
			if(!comp.isGroup())
			{
				User user = (User)comp;
				if(user.getUserName().equals(userName))
				{
					return user;
				}
			}
			else
			{
				UserGroup uGroup = (UserGroup)comp;
				return findUser(userName, uGroup);
			}
		}
		return null;
	}
}
