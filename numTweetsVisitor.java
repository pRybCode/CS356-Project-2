
public class numTweetsVisitor extends Visitor
{
	//Counts the total number of tweets from a user or user group
	public int visit(Component userComp) 
	{
		if(userComp.isGroup())
		{
			int num = 0;
			UserGroup group = (UserGroup)userComp;
			for(Component comp: group.getGroup())
			{
				num += visit(comp);
			}
			return num;
		}
		else
		{
			User user = (User) userComp;
			return user.getTweets().size();
		}
	}
}
