package model;

import java.time.Year;

public class Angestellte extends Mitarbeiter
{

	public Angestellte(String name, Year gebJahr, Year eintrJahr, char gesch) throws MitarbeiterException
	{
		super(name, gebJahr, eintrJahr, gesch);
	}

	@Override
	public float berechneGehalt()
	{
		return 1500+(50*berechneDienstalter());
	}
	
	public String toString()
	{

		return super.toString();
	}

}
