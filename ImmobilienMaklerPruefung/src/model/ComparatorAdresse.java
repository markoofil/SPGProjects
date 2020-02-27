package model;

import java.util.Comparator;

public class ComparatorAdresse implements Comparator<Immobilie>
{

	@Override
	public int compare(Immobilie o1, Immobilie o2)
	{
		return o1.getAdresse().compareTo(o2.getAdresse());
	}

}
