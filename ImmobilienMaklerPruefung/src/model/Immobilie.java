package model;

public abstract class Immobilie implements Comparable<Immobilie>
{
	private String adresse;
	private float flaeche;

	public Immobilie(String adresse, float flaeche)
	{
		setAdresse(adresse);
		setFlaeche(flaeche);
	}

	// ------------------------------------------- getter
	// ---------------------------------
	public String getAdresse()
	{
		return adresse;
	}

	public float getFlaeche()
	{
		return flaeche;
	}

	// ------------------------------------------- setter
	// ---------------------------------
	public void setAdresse(String adresse)
	{
		if(adresse != null)
			if(!adresse.isEmpty())
				this.adresse = adresse;
			else
				System.out.println("Leer-String fuer Immobilie.setAdresse()!!");
		else
			System.out.println("null-Referenz fuer Immobilie.setAdresse()!!");
	}

	public void setFlaeche(float flaeche)
	{
		if(flaeche >= 100f && flaeche <= 100000f)
			this.flaeche = flaeche;
		else
			System.out.println("Falscher Parameterwert (" + flaeche + ") fuer Immobilie.setFlaeche()!!");
	}

	// ------------------------------------------- other
	// ---------------------------------
	public String toString()
	{
		return adresse + ", Flaeche: " + flaeche + " qm";
	}

	public abstract float berechneVerkehrswert();

	@Override
	public int compareTo(Immobilie other)
	{
		if(other != null)
		{
			if(berechneVerkehrswert() > other.berechneVerkehrswert())
				return 1;
			else
				if(berechneVerkehrswert() < other.berechneVerkehrswert())
					return -1;
				else
					return 0;
		}
		return 0;
	}

}
