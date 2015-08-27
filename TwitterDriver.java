public class TwitterDriver
{
	public static void main(String[] args)
	{
		//Admin is a singleton
		Admin panel = new Admin();
		panel.getInstance().run();
	}
}