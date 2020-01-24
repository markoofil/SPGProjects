public class Waggon 
{
	private int gewicht;   // in Tonnen
	private int klasse;
	private int plaetzeMax;
	private int passagiere;
	 
    public Waggon(int gewicht, int klasse, int plaetzeMax)
    {
        setGewicht(gewicht);
        setKlasse(klasse);
        setPlaetzeMax(plaetzeMax);
    }
	// ------------------------------ getter --------------------------
	public int getGewicht()
	{
		return gewicht;
	}
	public int getKlasse()
	{
		return klasse;
	}
	public int getPassagiere()
	{
		return passagiere;
	}
	public int getPlaetzeMax()
	{
		return plaetzeMax;
	}
	// ------------------------------ setter --------------------------
	public void setGewicht(int gewicht)
	{//Plausibilitaetspruefungen duerfen fuer PLUEP entfallen!!
		this.gewicht = gewicht;
	}
	public void setKlasse(int klasse)
	{//Plausibilitaetspruefungen duerfen fuer PLUEP entfallen!!
		this.klasse = klasse;
	}
	public void setPlaetzeMax(int plaetzeMax)
	{//Plausibilitaetspruefungen duerfen fuer PLUEP entfallen!!
		this.plaetzeMax = plaetzeMax;
	}
	// ------------------------------ others --------------------------
	public int berecneFrei()
	{
		return plaetzeMax-passagiere;
	}
	public float berecneGewicht()
	{
		return gewicht + (passagiere*75f)/1000f;
	}
	public void einsteigen(int passagiere)
	{
		if (passagiere > 0  &&  this.passagiere+passagiere <= plaetzeMax)
			this.passagiere+=passagiere;
		else
			System.out.println("Falsche Anzahl ("+passagiere+") fuer Waggon.einsteigen(...)");
	}
	public void aussteigen(int passagiere)
	{
		if (passagiere > 0  &&  passagiere <= this.passagiere)
			this.passagiere-=passagiere;
		else
			System.out.println("Falsche Anzahl ("+passagiere+") fuer Waggon.aussteigen(...)");
	}
	public String toString() 
	{
		return new StringBuilder(200).append("Waggon: Gewicht=").append(gewicht).append(", Klasse=").append(klasse).
									 append(",Max.-Plaetze=").append(plaetzeMax).
									 append(", Passagiere=").append(passagiere).toString();
	}
}
