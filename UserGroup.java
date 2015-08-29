import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

public class UserGroup implements Component
{
	private ArrayList<Component> groupMembers = new ArrayList<Component>();
	private String userGroup;
	//creates a usergroup with a given name
	public UserGroup(String groupName) 
	{
		userGroup = groupName;
	}
	//adds a component to this usergroup
	public void add(Component comp)
	{
		groupMembers.add(comp);
	}
	//returns the groups name
	public String getGroupName() 
	{
		return userGroup;
	}
	//sets the group name
	public void setGroupName(String groupName)
	{
		userGroup = groupName;
	}
	//returns a string all the members of this user group
	public String toString()
	{
		String retVal = " ~" + userGroup;
		for(Component comps: groupMembers)
		{
			retVal +=  "\n" + "   -" + comps.toString();
		}
		return retVal;
	}
	//updates all the members of this user group
	public void update(Observable poster, Object tweet) 
	{
		for(Component comps: groupMembers)
		{
			comps.update(poster, tweet);
		}
	}
	//returns true, saying that this component is a group
	public boolean isGroup()
	{
		return true;
	}
	//returns the list of group members
	public ArrayList<Component> getGroup()
	{
		return groupMembers;
	} 
	//returns a specific member of a given name
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
			//if a group, search that group
			else
			{
				UserGroup uGroup = (UserGroup)comp;
				return findUser(userName, uGroup);
			}
		}
		//if not found, return null
		return null;
	}
}
