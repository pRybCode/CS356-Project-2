import java.util.List;

public class FeedObserver 
{
	private User watched;
	
	public FeedObserver(User user)
	{
		watched = user;
	}
	public void update(User user, String tweet) 
	{
		
	}
	
	public void notifyFollowersPost(String tweet, List<User> followers)
	{
		for(User users: followers)
		{
			users.update(watched.getUserName(), tweet);
		}
	}
	
	public void notifyFollowedUser(User follower, User followed)
	{
		followed.
	}
	
	public void updateTweet(String tweet) 
	{
		
	}
}
