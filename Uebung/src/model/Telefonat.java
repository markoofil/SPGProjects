package model;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("serial")
public abstract  class Telefonat implements Comparable<Telefonat>, Serializable
{
	private String eigeneNr;
	private String fremdeNr;
	private LocalDateTime datum;
	private boolean aktiv;
	
	public Telefonat(String eigeneNr, String fremdeNr, LocalDateTime datum, boolean aktiv) throws TelefonException
	{
		setEigeneNr(eigeneNr);
		setFremdeNr(fremdeNr);
		setDatum(datum);
		setAktiv(aktiv);
	}
	//-------------------------------- getter --------------------
	public boolean isAktiv()
	{
		return aktiv;
	}
	public LocalDateTime getDatum()
	{
		return datum;
	}
	public String getEigeneNr()
	{
		return eigeneNr;
	}
	public String getFremdeNr()
	{
		return fremdeNr;
	}
	//-------------------------------- setter --------------------
	public void setAktiv(boolean aktiv)
	{
		this.aktiv = aktiv;
	}
	public void setDatum(LocalDateTime datum) throws TelefonException
	{
		if (datum != null)
			this.datum = datum;
		else
			throw new TelefonException("null-Referenz für Telefonat.setDatum !!");
	}
	public void setEigeneNr(String eigeneNr) throws TelefonException
	{
		checkTelNr(eigeneNr, "Eigen");
		this.eigeneNr = eigeneNr;
	}
	public void setFremdeNr(String fremdeNr) throws TelefonException
	{
		checkTelNr(fremdeNr, "Fremd");
		this.fremdeNr = fremdeNr;
	}
	private void checkTelNr(String telNr, String eigeneOderFremde) throws TelefonException
	{
		if (telNr != null)
			if (telNr.length() >= 10  && telNr.length() <= 15)              // �u�erst simpel Pr�fungen!!
				if (telNr.charAt(0) == '0' || telNr.charAt(0) == '+')
					try
					{
						Long.parseLong(telNr.substring(1, telNr.length()));  // Exception, wenn nicht nur Ziffern o. '+'  !!
					}
					catch(NumberFormatException e)
					{
						throw new TelefonException(eigeneOderFremde + "Tel.Nr. für set"+eigeneOderFremde+"Nr("+telNr+") enth�lt nicht nur Ziffern!!");
					}
				else
					throw new TelefonException(eigeneOderFremde + "Tel.Nr. für set"+eigeneOderFremde+"Nr("+telNr+") beginnt nicht mit 0 oder '+' !!");
			else
				throw new TelefonException(eigeneOderFremde + "Tel.Nr. für set"+eigeneOderFremde+"Nr("+telNr+") hat falsche L�nge!!");
		else
			throw new TelefonException(eigeneOderFremde + "Tel.Nr. für set"+eigeneOderFremde+"Nr(...) ist null !!");

	}
	//-------------------------------- sonstige --------------------
	public abstract float berechneBetrag();
	
	public String toString()
	{
		String datumsString = datum.format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
		return String.format("eigeneNr: %-12s fremdeNr: %-12s  Zeit: %s", eigeneNr, fremdeNr, datumsString);
	}
	//-------------------------------- Comparatoren --------------------------
	@Override
	public int compareTo(Telefonat other)
	{
		return this.getEigeneNr().compareTo(other.getEigeneNr());
	}

	
	
}
