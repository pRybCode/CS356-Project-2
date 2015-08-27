public interface Component 
{
	public String toString(); //Necessary for higher level search functions/organization
	public Component update(User poster, String tweet); //need to be updated about a tweet
	public boolean isGroup(); //when iterating through components, need to know when to enter a usergroup
}
