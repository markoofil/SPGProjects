package model;

import java.util.LinkedList;

public class Personalbuero
{
	private LinkedList<Mitarbeiter> mitarbeiter;

	public Personalbuero()
	{
		mitarbeiter = new LinkedList<Mitarbeiter>();
	}

	public int frauenQuote()
	{
		int anz = 0;
		for (Mitarbeiter ma : mitarbeiter)
		{
			if(ma.getGesch() == 'w')
				anz++;

		}
		if(anz > 0)
		return anz / mitarbeiter.size() * 100;
		else return 0;

	}

	public String aufnehmen(Mitarbeiter ma)
	{

		boolean quote;
		if(frauenQuote() >= 40)
			quote = true;
		else
			quote = false;
		
		if(ma != null)
		{
			if(mitarbeiter.size() < 100)
			{
				if(ma.berechneAlter() <= 60)
				{
					if(quote == true || mitarbeiter.size() == 0)
					{
						mitarbeiter.add(ma);
						return "Mitarbeiter aufgenommen";
					}
					else
						return "quote";

				}
				else
					return "alter";
			}
			else
				return "voll";
		}
		else
			return "Null-Ref. für Mitarbeiter 'ma' übergeben";

	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer(10000);
		for(Mitarbeiter m : mitarbeiter)
		{
			sb.append(m).append("\n");
		}
		return 	sb.toString();
		
	}
	
}
