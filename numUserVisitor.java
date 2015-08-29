
public class numUserVisitor extends Visitor
{
	//visits a component, if it is a user, increment
	//else, visit all the members of the group
	public int visit(Component userComp) 
	{
		//if group, visit group members
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
		//else increment by 1
		else
		{
			return 1;
		}
	}

}
