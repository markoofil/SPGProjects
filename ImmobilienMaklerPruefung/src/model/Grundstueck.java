package model;

public class Grundstueck extends Immobilie
{

	private char widmung;
	private float qmPreis;

	public Grundstueck(String adresse, float flaeche, char widmung, float qmPreis)
	{
		super(adresse, flaeche);
		setWidmung(widmung);
		setQmPreis(qmPreis);
	}

	public char getWidmung()
	{
		return widmung;
	}

	public float getQmPreis()
	{
		return qmPreis;
	}

	public void setWidmung(char widmung)
	{
		this.widmung = widmung;
	}

	public void setQmPreis(float qmPreis)
	{
		this.qmPreis = qmPreis;
	}

	@Override
	public float berechneVerkehrswert()
	{
		if(widmung == 'n')
			return getQmPreis() * getFlaeche() * 0.5f;
		else
			if(widmung == 'b')
				return getQmPreis() * getFlaeche() * 2f;
			else
				return getQmPreis() * getFlaeche();

	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer(1000);
			sb.append(getClass().getSimpleName()).append(" @ ").append(super.toString()).append(" -> ");
			if(getWidmung() == 'b')
				sb.append(" Bauland ");
			else
				if (getWidmung() == 'n')
					sb.append(" Naturschutz ");
				else
					if(getWidmung() == 'g')
					sb.append(" Grünland ");
					else
						sb.append(" Unbekannt ");
			
			sb.append(", € ").append(berechneVerkehrswert());
		return sb.toString();
	}

	



	

}
