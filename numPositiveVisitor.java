import java.util.ArrayList;


public class numPositiveVisitor extends Visitor
{
	//count the number of "positive" tweets
	public int visit(Component userComp) 
	{
		//if a group, visit the group's members
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
		//else, count the number of positive tweets this user has
		else
		{
			int num = 0;
			User user = (User) userComp;
			ArrayList<String> tweets = user.getTweets();
			for(String tweet: tweets)
			{
				//in this case positive words are good and excellent
				if(tweet.toLowerCase().contains("good") || tweet.toLowerCase().contains("excellent"))
				{
					num++;
				}
			}
			return num;
		}
	}
}
