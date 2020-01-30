import java.util.Vector;

public class Zug
{

    private char typ;
    private Lokomotive lok;
    private int maxWaggonAnz;
    private Vector<Waggon> waggons = new Vector<Waggon>();
    private String zugId;
    // ------------------------------ constructor --------------------------

    public Zug(String zugId, char typ)
    {
        this.zugId = zugId;
        setTyp(typ);
        setMaxWaggonAnz();
    }

    public void addWaggon(Waggon waggon)
    {
        if(waggon != null)
        {
            if(!waggons.contains(waggon))
            {
                if(waggons.size() < maxWaggonAnz)
                {
                    waggons.add(waggon);
                    System.out.println("Waggon hinzugefügt");
                }
                else
                    System.out.println("Max Anzahl an Waggons überschritten");
            }
            else
                System.out.println("Waggon bereits enthalten");
        }
        else
            System.out.println("Null-Ref. übergeben");
    }

    public void waggonUebersicht()
    {
        String str = "";
        for(Waggon w : waggons)
        {

            str += waggons.indexOf(w)+1;
            str += ". Waggon Gewicht = "+w.berecneGewicht();
            str += ", Klasse = "+w.getKlasse();
            str += ", Max.-Plaetze = "+w.getPlaetzeMax();
            str += ", Passagiere = "+w.getPassagiere();
            str += "\n";
        }
        System.out.println(str);
    }
    // ------------------------------ setter -------------------------- 
    public void setTyp(char typ)
    {//Fuer PLUEP ohne Plausibilitaetspruefung
        this.typ = typ;
    }

    public void setMaxWaggonAnz()
    {
        if (typ == 'P')
            maxWaggonAnz = 55;
        else 
        if (typ == 'A')
            maxWaggonAnz = 40;
        else 
        if (typ == 'R')
            maxWaggonAnz = 1;
        else
        {
            System.out.println("Falscher Typ fuer Zug -> Max.-Anz. auf 1 gesetzt");
            maxWaggonAnz = 1;
        }
    }
    // ------------------------------ others --------------------------

}
