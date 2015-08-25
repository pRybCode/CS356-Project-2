import java.util.*;

public class User
{
	private String user;
	private List<User> followers = new ArrayList<User>();
	private List<User> following = new ArrayList<User>();
	private List<String> newsFeed = new ArrayList<String>();
	private ArrayList<String> tweets = new ArrayList<String>();
	private FeedObserver observer;
	
	public User(String createUser)
	{
		user = createUser;
		setObserver();
	}
	public String getUserName() 
	{
		return user;
	}

	public void setUserName(String user)
	{
		this.user = user;
	}
	
	public String toString()
	{
		return user;
	}
	
	public void followUser(User userID) 
	{
		following.add(userID);
		observer.notifyFollowedUser(this, userID);
		
	}
	
	public void writeTweet(String tweet) 
	{
		tweets.add(tweet);
		observer.notifyFollowersPost(tweet, followers);
	}

	public void update(String user, String tweet) 
	{
		newsFeed.add(user + ": " + tweet);
	}
	
	public void update(Observable followers, Object arg1) 
	{
		
	}
	private void setObserver()
	{
		observer = new FeedObserver(this);
	}
}
