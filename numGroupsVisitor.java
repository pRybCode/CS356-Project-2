
public class numGroupsVisitor extends Visitor
{
	public int visit(Component userComp)
	{
		if(userComp.isGroup())
		{
			int num = 1;
			UserGroup group = (UserGroup)userComp;
			for(Component comp: group.getGroup())
			{
				num += visit(comp);
			}
			return num;
		}
		else
		{
			return 0;
		}
	}

}
