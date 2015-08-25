public interface Composite 
{
	public void add(User user);
	public void add(UserGroup group);
	public String getUser();
	public String getGroup();
	public void print();
}