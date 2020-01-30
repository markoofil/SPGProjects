public class Lokomotive
{
    private String lokId;
    private char antrieb;
    private int leistung;

    public Lokomotive(int leistung, char antrieb)
    {
        setLeistung(leistung);
        setAntrieb(antrieb);
    }

    public Lokomotive()
    {
        this.antrieb = 'H';
        this.leistung = 500;
    }
    // ------------------------------ getter --------------------------
    public char getAntrieb()
    {
        return antrieb;
    }

    public int getLeistung()
    {
        return leistung;
    }

    public String getLokId()
    {
        return lokId;
    }
    // ------------------------------ setter --------------------------
    public void setAntrieb(char antrieb)
    {//Plausibilitaetspruefungen duerfen fuer PLUEP entfallen!!
        this.antrieb = antrieb;
    }

    public void setLeistung(int leistung)
    {//Plausibilitaetspruefungen duerfen fuer PLUEP entfallen!!
        this.leistung = leistung;
    }

    public void setLokId(String lokId)
    {//Plausibilitaetspruefungen duerfen fuer PLUEP entfallen!!
        this.lokId = lokId;
    }
    // ------------------------------ others --------------------------
    public String toString() 
    {
        return  new StringBuilder(200).append("Lokomotive: Lok-Id=").append(lokId).append(", Antrieb=").append(antrieb).
        append(", Leistung=").append(leistung).toString();
    }

}
