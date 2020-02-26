package model;

import java.util.Comparator;

public class NameComparator implements Comparator<Mitarbeiter>
{

	@Override
	public int compare(Mitarbeiter o1, Mitarbeiter o2)
	{
		
		return o1.getName().compareTo(o2.getName());
	}
	
//	public static Comparator<Mitarbeiter> comp = new Comparator<Mitarbeiter>()
//	{
//
//		@Override
//		public int compare(Mitarbeiter o1, Mitarbeiter o2)
//		{
//			int res = String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
//			if(res == 0)
//			{
//				res = o1.compareTo(o2);
//			}
//			return res;
//		}
//	}
};
	

