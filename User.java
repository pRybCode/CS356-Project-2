import java.util.*;

public class User extends Observable implements Observer, Component
{
	private String user;
	private ArrayList<User> following = new ArrayList<User>();
	private ArrayList<String> newsFeed = new ArrayList<String>();
	private ArrayList<String> tweets = new ArrayList<String>();
	
	//create a new user and follow itself in order to see its own tweets
	public User(String createUser)
	{
		user = createUser;
		following.add(this);
	}
	//return the string of the user name
	public String getUserName() 
	{
		return toString();
	}
	//set the user's username
	public void setUserName(String user)
	{
		this.user = user;
	}
	//return the user's username
	public String toString()
	{
		return user;
	}
	//returns a string of the user's newsfeed
	public String newsFeedString()
	{
		String retVal = "";
		for(String tweet: newsFeed)
		{
			retVal += tweet + "\n";
		}
		return retVal;
	}
	//returns a string of the list of followers
	public String followingList()
	{
		String retVal = "Following: \n";
		for(User user: following)
		{
			retVal += user.getUserName() + "\n";
		}
		return retVal;
	}
	//follows another user
	public void followUser(User userID) 
	{
		following.add(userID);
		userID.addObserver(this);
	}
	//post a tweet and update this user's followers
	public void writeTweet(String tweet) 
	{
		tweets.add(user + ": " + tweet);
		newsFeed.add(tweets.get(tweets.size()-1));
		setChanged();
		notifyObservers(tweets.get(tweets.size()-1));
	}
	//follow this user
	public void followed(User follower)
	{
		addObserver(follower);
	}
	//returns that this component is not a usergroup
	public boolean isGroup()
	{
		return false;
	}
	//returns the list of tweets
	public ArrayList<String> getTweets()
	{
		return tweets;
	}
	//returns the users list of people they are following
	public List<User> getFollowingList()
	{
		return following;
	}
	//adds the updated tweet to this users newsfeed
	public void update(Observable user, Object tweet) 
	{
		newsFeed.add((String)tweet);
	}
}
