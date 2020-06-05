package model;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class Gespraech extends Telefonat
{
	private int dauer;
	private int kostenProMinute;
	
	public Gespraech(String eigeneNr, String fremdeNr, LocalDateTime datum,
					 boolean aktiv, int dauer, int kostenProMinute) throws TelefonException
	{
		super(eigeneNr, fremdeNr, datum, aktiv);
		setDauer(dauer);
		setKostenProMinute(kostenProMinute);
	}
	//----------------------------------------- getter ------------------------
	public int getDauer()
	{
		return dauer;
	}
	public int getKostenProMinute()
	{
		return kostenProMinute;
	}
	//----------------------------------------- setter ------------------------
	public void setDauer(int dauer) throws TelefonException
	{
		if (dauer >= 1 && dauer <= 6000)
			this.dauer = dauer;
		else 
			throw new TelefonException("Falscher Parameterwert für Gespraech.setDauer("+dauer+") !!");
	}
	public void setKostenProMinute(int kostenProMinute) throws TelefonException
	{
		if (kostenProMinute >= 1 && kostenProMinute <= 50)
			this.kostenProMinute = kostenProMinute;
		else 
			throw new TelefonException("Falscher Parameterwert für Gespraech.setKostenProMinute("+kostenProMinute+") !!");
	}
	//----------------------------------------- sonstige ------------------------
	public float berechneBetrag()
	{
		if (isAktiv())
		{
			int min = dauer/60;
			if ( dauer%60 > 0 )
				min++;
			return min*kostenProMinute;
		}
		else
			return 0f;
	}
	public String toString()
	{
		return String.format("%s, %d Sek. -> %.1f Cent", super.toString(),dauer,berechneBetrag());
	}
	
	
	
	
}
