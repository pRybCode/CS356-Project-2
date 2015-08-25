public class UserNotifier
{
	String userID;
	long updateTime = 0;
	
	private void setUpdateTime(long currentTime) 
	{
		this.updateTime = currentTime;
	}
	
	private void setID(String userID) 
	{
		this.userID = userID;
	}
	
	public long getTime()
	{
		return updateTime;
	}
	
	public String getID()
	{
		return userID;
	}
	
	public void updateUser(User user) 
	{
		if (user.getLastUpdateTime() > getTime())
		{
			setUpdateTime(user.getLastUpdateTime());
			setID(user.getUser());
			System.out.println();
		}
	}
	
	public void updateGroup(UserGroup group) 
	{
		return;
	}
	
}
