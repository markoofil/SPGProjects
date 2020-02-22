package model;

import java.time.Year;

public class Manager extends Mitarbeiter
{
	private float fixum;

	public Manager(String name, Year gebJahr, Year eintrJahr, char gesch, float fixum)
	{
		super(name, gebJahr, eintrJahr, gesch);
		setFixum(fixum);
	}

	public float getFixum()
	{
		return fixum;
	}

	public void setFixum(float fixum)
	{
		if(fixum > 0)
			this.fixum = fixum;
		else
			System.out.println("Wert für setFixum muss >0 sein!");
	}

	@Override
	public float berechneGehalt()
	{
		return fixum;
	}

	public String toString()
	{

		return super.toString();
	}
}
