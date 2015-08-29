import java.util.ArrayList;

public class numTweetsVisitor extends Visitor
{
	//Counts the total number of tweets from a user or user group
	public int visit(Component userComp) 
	{
		//if a group, visit all group members
		if(userComp.isGroup())
		{
			int num = 0;
			UserGroup group = (UserGroup)userComp;
			ArrayList<Component> groupList = group.getGroup();
			for(Component comp: groupList)
			{
				num += visit(comp);
			}
			return num;
		}
		//else return this user's number of tweets
		else
		{
			User user = (User) userComp;
			return user.getTweets().size();
		}
	}
}
