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
		following.add(this);
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
	
	public String newsFeedString()
	{
		String retVal = "";
		for(String tweet: newsFeed)
		{
			retVal += tweet + "\n";
		}
		return retVal;
	}
	
	public String followingList()
	{
		String retVal = "Following: \n";
		for(User user: following)
		{
			retVal += user.getUserName() + "\n";
		}
		return retVal;
	}
	
	public void followUser(User userID) 
	{
		following.add(userID);
	}
	
	public void writeTweet(String tweet) 
	{
		tweets.add(user + ": " + tweet);
		update(this, tweets.get(tweets.size()-1));
		
	}

	public User update(User user, String tweet) 
	{
		if(following.contains(user))
		{
			newsFeed.add(tweet);
		}
		return null;
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
