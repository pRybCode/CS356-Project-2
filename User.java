import java.util.*;

public class User implements Component
{
	private String user;
	private ArrayList<User> followers = new ArrayList<User>();
	private ArrayList<User> following = new ArrayList<User>();
	private ArrayList<String> newsFeed = new ArrayList<String>();
	private ArrayList<String> tweets = new ArrayList<String>();
	
	public User(String createUser)
	{
		user = createUser;
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
		userID.followed(this);
	}
	
	public void writeTweet(String tweet) 
	{
		tweets.add(tweet);
		update(this, tweet);
	}

	public User update(User user, String tweet) 
	{
		if(following.contains(user))
		{
			newsFeed.add(user + ": " + tweet);
		}
		return this;
	}
	
	public void followed(User follower)
	{
		followers.add(follower);
	}
	
	public boolean isGroup()
	{
		return false;
	}
	
	public ArrayList<String> getTweets()
	{
		return tweets;
	}
	
	public List<User> getFollowingList()
	{
		return following;
	}
}
