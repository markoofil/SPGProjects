package model;

import java.time.Year;

public class Freelancer extends Mitarbeiter
{
	private float stundenSatz;
	private int stunden;

	public Freelancer(String name, Year gebJahr, Year eintrJahr, char gesch, float stundenSatz, int stunden)
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

	public void setStundenSatz(float stundenSatz)
	{
		if(stundenSatz > 0 )
		{
			this.stundenSatz = stundenSatz;
		}
		else
			System.out.println("Stundensatz muss > 0 sein");
	}

	public void setStunden(int stunden)
	{
		if(stunden > 0 && stunden <= 2500)
			this.stunden = stunden;
		else
			System.out.println("Stundenanzahl muss zw. 0 & 2500 sein");
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
