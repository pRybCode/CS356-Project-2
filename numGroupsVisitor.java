
public class numGroupsVisitor extends Visitor
{
	//counts the total number of groups in a component
	public int visit(Component userComp)
	{
		//if group, increment by one and visit members
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
		//if a user, dont increment
		else
		{
			return 0;
		}
	}

}
