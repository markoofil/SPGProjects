package model;

import java.time.*;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter>
{
	private String name;
	private Year gebJahr, eintrJahr;
	private char gesch;

	public Mitarbeiter(String name, Year gebJahr, Year eintrJahr, char gesch)
	{
		setName(name);
		setGebJahr(gebJahr);
		setEintrJahr(eintrJahr);
		setGesch(gesch);
	}

	// ------------------------------------ getter ------------------------
	public String getName()
	{
		return name;
	}

	public Year getGebJahr()
	{
		return gebJahr;
	}

	public Year getEintrJahr()
	{
		return eintrJahr;
	}

	// ------------------------------------ setter ------------------------
	public void setName(String name)
	{
		if(name != null)
			this.name = name;
		else
			System.out.println("null-Referenz fuer setName !!!");
	}

	public void setGebJahr(Year gebJahr)
	{
		if(gebJahr != null)
		{
			if(!gebJahr.isBefore(Year.now().minusYears(100)) && !gebJahr.isAfter(Year.now()))
			{
				this.gebJahr = gebJahr;
			}
			else
				System.out.println("Mitarbeiter ist >100 Jahre alt!!");
		}
		else
			System.out.println("Null-Ref. für gebJahr übergeben");
	}

	public void setEintrJahr(Year eintrJahr)
	{
		if(eintrJahr != null)
		{
			if(!eintrJahr.isAfter(Year.now()) && !eintrJahr.isBefore(getGebJahr().plusYears(15)))
			{
				this.eintrJahr = eintrJahr;
			}
			else
				System.out.println(
						"Ungültiger Wert übergeben! Info: Mitarbeiter kann nicht vor dem 15. Lebensjahr anfangen! Aktuelles Jahr soll nicht überschritten werden!");
		}
		else
			System.out.println("Null-Ref. für eintrJahr übergeben");

	}

	public char getGesch()
	{
		return gesch;
	}

	public void setGesch(char gesch)
	{
		gesch = Character.toLowerCase(gesch);
		if(gesch == 'w' || gesch == 'm' || gesch == 'x')
			this.gesch = gesch;
		else
			System.out.println("Falsches Format für setGesch gewählt!! (w,m oder x)");
	}

	// -------------------------------------- others -----------------------
	public int berechneAlter()
	{
		return LocalDate.now().getYear() - gebJahr.getValue();
	}

	public int berechneDienstalter()
	{
		return Year.now().getValue() - eintrJahr.getValue();
	}



	public int berechneDienstalter(Year jahr) // z.B. um zu berechnen, wer im nächsten Jahr ein Jubiläum feiert
	{

		if(jahr != null)
		{
			if(jahr.getValue() >= 0)
			{
				return jahr.getValue() - getEintrJahr().getValue();
			}
			else
			{
				System.out.println("Negatives Jahr nicht möglich");
				return 0;
			}
		}
		else
		{
			return Year.now().getValue() - getEintrJahr().getValue();
		}

//		if(jahr != null)
//		{
//			if(!jahr.isBefore(getEintrJahr()))
//			{
//				return jahr.getValue() - eintrJahr.getValue();
//			}
//			else
//			{
//				System.out.println("Ein negatives Dienstalter ist nicht möglich! ");
//				return 0;
//			}
//		}
//		else
//			System.out.println("Null-Ref. übergeben. Aktuelles Jahr wird verwendet (" + Year.now().getValue() + ")");
//		return jahr.getValue() - Year.now().getValue();
	}

	public abstract float berechneGehalt();

	public float berechnePraemie(Year jahr)
	{
		if(jahr != null)
		{
			switch (berechneDienstalter(jahr))
			{
			case 15:
				return berechneGehalt();
			case 25:
				return berechneGehalt() * 2;
			case 35:
				return berechneGehalt() * 3;
			case 40:
				return berechneGehalt() * 4;
			case 50:
				return berechneGehalt() * 6;
			}
		}
		else
		{
			switch (berechneDienstalter())
			{
			case 15:
				return berechneGehalt();
			case 25:
				return berechneGehalt() * 2;
			case 35:
				return berechneGehalt() * 3;
			case 40:
				return berechneGehalt() * 4;
			case 50:
				return berechneGehalt() * 6;
			}
		}
		return 0;

	}

	public String toString()
	{
		StringBuffer sb = new StringBuffer(10000);

		sb.append(getClass().getSimpleName()).append(" Name: ").append(name).append(" , Geb.Jahr: ").append(gebJahr)
				.append(", Alter: ");
		sb.append(berechneAlter()).append(", Geschlecht: ").append(getGesch()).append(", Eintr.Jahr: ")
				.append(eintrJahr).append(", Dienstalter: ");
		sb.append(berechneDienstalter()).append(", Gehalt: ").append(berechneGehalt());

		return sb.toString();
	}

	public void print()
	{
		System.out.println(toString());
	}

	@Override
	public int compareTo(Mitarbeiter other)
	{
		if(other != null)
		{
			if(berechneGehalt() > other.berechneGehalt())
				return 1;
			else
				if(berechneGehalt() < other.berechneGehalt())
					return -1;
				else
					return 0;
		}
		return 1;
	}
}
