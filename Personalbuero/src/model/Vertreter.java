package model;

import java.time.Year;

public class Vertreter extends Mitarbeiter
{
	private float basisGehalt, umsatz;

	public Vertreter(String name, Year gebJahr, Year eintrJahr, char gesch, float basisGehalt, float umsatz)
	{
		super(name, gebJahr, eintrJahr, gesch);
		setBasisGehalt(basisGehalt);
		setUmsatz(umsatz);
	}

	public float getBasisGehalt()
	{
		return basisGehalt;
	}

	public float getUmsatz()
	{
		return umsatz;
	}

	public void setBasisGehalt(float basisGehalt)
	{
		if(basisGehalt > 0)
			this.basisGehalt = basisGehalt;
		else
			System.out.println("Wert für setBasisGehalt muss >0 sein");
	}

	public void setUmsatz(float umsatz)
	{
		if(umsatz >= 0)
			this.umsatz = umsatz;
		else
			System.out.println("Wert für setUmsatz muss positiv sein");
	}

	@Override
	public float berechneGehalt()
	{
		return this.basisGehalt + (float) (this.umsatz * 0.01);
	}

	public String toString()
	{
		if(getGesch() == 'm')
			return "Vertreter: " + super.toString();
		else
			return "Vertreterin: " + super.toString();
	}
}
