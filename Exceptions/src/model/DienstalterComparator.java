package model;

import java.util.Comparator;

public class DienstalterComparator implements Comparator<Mitarbeiter>
{

	@Override
	public int compare(Mitarbeiter o1, Mitarbeiter o2)
	{
		if(o1.berechneDienstalter() > o2.berechneDienstalter())
			return 1;
		else
			if(o1.berechneDienstalter() < o2.berechneDienstalter())
				return -1;
			else
				return 0;
	}

}
