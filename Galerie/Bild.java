/**
 * Write a description of class Bild here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bild
{
    private String kuenstler;
    private String titel;
    private int laenge, breite;
    private double preis;
    private boolean verkauft;

    public Bild()
    {
        setKuenstler("Paul");
        setTitel("Die Blume");
        setLaenge(50);
        setBreite(50);
        setPreis(15000);
        setVerkauft(true);
    }

    public Bild(String kuenstler,String titel, int laenge, int breite)
    {
        setKuenstler(kuenstler);
        setTitel(titel);
        setLaenge(laenge);
        setBreite(breite);
    }

    public Bild(String kuenstler, int laenge, int breite, double preis)
    {
        setKuenstler(kuenstler);
        setLaenge(laenge);
        setBreite(breite); 
        setPreis(preis);
    }

    public Bild(String kuenstler,String titel, int laenge, int breite, double preis)
    {
        setKuenstler(kuenstler);
        setTitel(titel);
        setLaenge(laenge);
        setBreite(breite);
        setPreis(preis);
    }

    public Bild(String kuenstler,String titel, int laenge, int breite, double preis, boolean verkauft)
    {
        setKuenstler(kuenstler);
        setTitel(titel);
        setLaenge(laenge);
        setBreite(breite);
        setPreis(preis); 
        setVerkauft(verkauft);
    }

    public void setKuenstler(String kuenstler)
    {
        if(kuenstler != null)
        {
            if(kuenstler != this.kuenstler)
            {
                if(this.kuenstler == null)
                {
                    this.kuenstler = kuenstler;  
                }
                else
                    System.out.println("Name nicht veränderbar");
            }
            else
                System.out.println("Name bereits vergeben");
        }
        else
            System.out.println("Null-Ref. übergeben für \"Künstler\"");
    }

    public void setTitel(String titel)
    {
        if(titel != null)
        {
            this.titel = titel;    
        }
        else
            System.out.println("Null-Ref. übergeben für \"Titel\"");
    }

    public void setLaenge(int laenge)
    {
        if(laenge > 0 && laenge < 500)
        {
            this.laenge = laenge;
        }
        else
            System.out.println("Falscher Wert für Länge vergeben (0-500)");
    }

    public void setBreite(int breite)
    {
        if(breite > 0 && breite < 500)
        {
            this.breite = breite;
        }
        else
            System.out.println("Falscher Wert für Breite vergeben (0-500)");
    }

    public void setPreis(double preis)
    {
        if(preis > 0 && preis < 5000000)
        {
            this.preis = preis;
        }
        else
            System.out.println("Falscher Wert für Preis");
    }

    public void setVerkauft(boolean verkauft)
    {
        this.verkauft = verkauft;
    }

    public String getKuenstler()
    {
        return kuenstler;
    }

    public String getTitel()
    {
        return titel;
    }

    public int getLaenge()
    {
        return laenge;
    }

    public int getBreite()
    {
        return breite;
    }

    public double getPreis()
    {
        return preis;
    }

    public boolean isVerkauft()
    {
        return verkauft;
    }
    //----------------------- Methoden ----------------------

    public String toString()
    {
        String str = kuenstler+" - "+titel+" - "+laenge+"x"+breite+" - "+"Preis: € "+
            preis+" - ";
        if(verkauft == false)
        {
            
            str += "verfügbar";
        }
        else
            str += "verkauft";
        return str;

    }

    public void print()
    {
        System.out.println(toString());
    }
    
}
