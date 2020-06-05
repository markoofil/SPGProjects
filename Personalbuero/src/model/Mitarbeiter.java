package model;

import java.time.*;

public abstract class Mitarbeiter implements Comparable<Mitarbeiter>
{
	private String name;
	private Year gebJahr, eintrJahr;
	private char gesch;

	public Mitarbeiter(String name, Year gebJahr, Year eintrJahr, char gesch) throws MitarbeiterException
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

	public char getGesch()
	{
		return gesch;
	}

	// ------------------------------------ setter ------------------------
	public void setName(String name) throws MitarbeiterException
	{
		if(name != null)
			this.name = name;
		else
			throw new MitarbeiterException("null-Referenz fuer setName !!!");
	}

	public void setGebJahr(Year gebJahr) throws MitarbeiterException
	{
		if(gebJahr != null)
		{
			if(!gebJahr.isBefore(Year.now().minusYears(100)) && !gebJahr.isAfter(Year.now()))
			{
				this.gebJahr = gebJahr;
			}
			else
				throw new MitarbeiterException("Mitarbeiter ist >100 Jahre alt!!");
		}
		else
			throw new MitarbeiterException("Null-Ref. für gebJahr übergeben");
	}

	public void setEintrJahr(Year eintrJahr) throws MitarbeiterException
	{
		if(eintrJahr != null)
		{
			if(!eintrJahr.isAfter(Year.now()) && !eintrJahr.isBefore(getGebJahr().plusYears(15)))
			{
				this.eintrJahr = eintrJahr;
			}
			else
				throw new MitarbeiterException(
						"Ungültiger Wert übergeben! Info: Mitarbeiter kann nicht vor dem 15. Lebensjahr anfangen! Aktuelles Jahr soll nicht überschritten werden!");
		}
		else
			throw new MitarbeiterException("Null-Ref. für eintrJahr übergeben");

	}

	public void setGesch(char gesch) throws MitarbeiterException
	{
		gesch = Character.toLowerCase(gesch);
		if(gesch == 'w' || gesch == 'm' || gesch == 'x')
			this.gesch = gesch;
		else
			throw new MitarbeiterException("Falsches Format für setGesch gewählt!! (w,m oder x)");
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

	@SuppressWarnings("null")
	public int berechneDienstalter(Year jahr) throws MitarbeiterException // z.B. um zu berechnen, wer im nächsten Jahr
																			// ein Jubiläum feiert
	{
		if(jahr != null)
		{
			if(jahr.isAfter(Year.now()))
			{
				return jahr.getValue() - eintrJahr.getValue();
			}
			else
			{
				throw new MitarbeiterException("Ein negatives Dienstalter ist nicht möglich! ");
//				return 0; // don't need it due to Exceptionhandling
			}
		}
		else
		{
			return jahr.getValue() - Year.now().getValue();
		}
	}

	public abstract float berechneGehalt();

	public float berechnePraemie(Year jahr) throws MitarbeiterException // ohne Exception wird try catch vorgeschlagen
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
