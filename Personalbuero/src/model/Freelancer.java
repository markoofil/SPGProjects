package model;

import java.time.Year;

public class Freelancer extends Mitarbeiter
{
	private float stundenSatz;
	private int stunden;

	public Freelancer(String name, Year gebJahr, Year eintrJahr, char gesch, float stundenSatz, int stunden) throws MitarbeiterException
	{
		super(name, gebJahr, eintrJahr, gesch);
		setStundenSatz(stundenSatz);
		setStunden(stunden);
	}

	public float getStundenSatz()
	{
		return stundenSatz;
	}

	public int getStunden()
	{
		return stunden;
	}

	public void setStundenSatz(float stundenSatz) throws MitarbeiterException
	{
		if(stundenSatz > 0 )
		{
			this.stundenSatz = stundenSatz;
		}
		else
			throw new MitarbeiterException("Stundensatz muss > 0 sein");
	}

	public void setStunden(int stunden) throws MitarbeiterException
	{
		if(stunden > 0 && stunden <= 2500)
			this.stunden = stunden;
		else
			throw new MitarbeiterException("Stundenanzahl muss zw. 0 & 2500 sein");
	}

	@Override
	public float berechneGehalt()
	{
		int bonus = stunden/100*100;
		return stundenSatz*stunden+bonus;
	}
	public String toString()
	{

		return super.toString();
	}

	

	
}
