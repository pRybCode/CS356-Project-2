
public class numUserVisitor extends Visitor
{
	public int visit(Component userComp) 
	{
		if(userComp.isGroup())
		{
			int num = 0;
			UserGroup group = (UserGroup)userComp;
			for(Component comps: group.getGroup())
			{
				num += visit(comps);
			}
			return num;
		}
		else
		{
			return 1;
		}
	}

}
