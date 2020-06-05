package model;

import java.util.Comparator;

public class ComparatorZeit implements Comparator<Telefonat>
{

	@Override
	public int compare(Telefonat o1, Telefonat o2)
	{
//		if(o1.getDatum().isAfter(o2.getDatum()))
//		{
//			return 1;
//		}
//		else
//			if((o1.getDatum().isBefore(o2.getDatum())))
//			{
//				return -1;
//			}
//			else
//				return 0;
		return o1.getDatum().compareTo(o2.getDatum());
	}

		
	

	

}
