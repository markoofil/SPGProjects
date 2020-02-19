package model;

import java.util.Iterator;
import java.util.LinkedList;
import model.Angestellte;

public class Personalbuero
{
	private LinkedList<Mitarbeiter> mitarbeiter;

	public Personalbuero()
	{
		mitarbeiter = new LinkedList<Mitarbeiter>();
	}

	public int frauenQuote()
	{
		float anz = 0;
		for (Mitarbeiter ma : mitarbeiter)
		{
			if(ma.getGesch() == 'w')
				anz++;

		}
		if(anz > 0)
			return (int) (anz / mitarbeiter.size() * 100);
		else
			return (int) anz;

	}

	public String aufnehmen(Mitarbeiter ma)
	{

		if(ma != null)
		{
			if(mitarbeiter.size() < 100)
			{
				if(!mitarbeiter.contains(ma))
				{
					if(ma.berechneAlter() <= 60)
					{
						if(frauenQuote() >= 40 || mitarbeiter.size() == 0)
						{
							mitarbeiter.add(ma);
							return "Mitarbeiter aufgenommen";
						}
						else
							if(frauenQuote() <= 40 && ma.getGesch() == 'w')
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
					return "doppelt";
			}
			else
				return "voll";
		}
		else
			return "Null-Ref. für Mitarbeiter 'ma' übergeben";

	}

	public float berechneGehaltsSumme()
	{
		float sum = 0;
		if(!mitarbeiter.isEmpty())
			for (Mitarbeiter m : mitarbeiter)
			{
				sum += m.berechneGehalt();
			}
		else
			System.out.println("Keine Mitarbeiter vorhanden!");

		return sum;
	}

	public int zaehleAlter(int alter)
	{
		int anz = 0;
		if(!mitarbeiter.isEmpty())
			for (Mitarbeiter m : mitarbeiter)
			{
				if(m.berechneAlter() > alter)
					anz++;
			}
		else
			System.out.println("Keine Mitarbeiter vorhanden!");

		return anz;
	}

	public int zaehleAngestellte()
	{
		int anz = 0;

		if(!mitarbeiter.isEmpty())
		{
			for (Mitarbeiter m : mitarbeiter)
			{
				anz++;
			}
		}
		else
			System.out.println("Keine Mitarbeiter vorhanden!");
		return anz;
	}

	public float berechneAvgGehaltAngestellte()
	{
//		if(!mitarbeiter.isEmpty())
//			return berechneGehaltsSumme() / (float) zaehleAngestellte();
//		else
//			System.out.println("Keine Mitarbeiter vorhanden!");

		float sum = 0;
		int anz = 0;
		if(mitarbeiter.size() > 1)
		{
			for (Mitarbeiter m : mitarbeiter)
			{
				if(m instanceof Angestellte)
					sum += m.berechneGehalt();
				anz++;
			}
		
		 return sum / anz;
		}
		else
			System.out.println("Nicht genügend Mitarbeiter vorhanden");

		return 0;
	}

	public boolean kuendigen(int pos)
	{
		if(mitarbeiter.size() >= pos)
		{
			mitarbeiter.remove(pos);
			System.out.println("Mitarbeiter auf Position: " + pos + " wurde gekündigt");
			return true;
		}
		else
			System.out.println("Niemand musste dran glauben");
		return false;

	}

	public Mitarbeiter kuendigen(String name)
	{
		Iterator<Mitarbeiter> iter = mitarbeiter.iterator();

		while (iter.hasNext())
		{
			Mitarbeiter ma = iter.next();
			if(ma.getName().equals(name))
			{
				iter.remove();
				System.out.println(ma + " wurde gekündigt");
				return ma;
			}

		}
		return null;

	}

	public boolean kuendigen(Mitarbeiter ma)
	{
		Iterator<Mitarbeiter> iter = mitarbeiter.iterator();
		while(iter.hasNext())
		{
			iter.remove(ma);
		}
		
		return false;
		
	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer(10000);
		for (Mitarbeiter m : mitarbeiter)
		{
			sb.append(m).append("\n");
		}
		return sb.toString();

	}

}
