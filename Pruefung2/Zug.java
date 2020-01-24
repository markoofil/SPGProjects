import java.util.Vector;

public class Zug
{

    private char typ;
    private Lokomotive lok;
    private int maxWaggonAnz;
    private Vector<Waggon> waggons;
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
        if(waggons != null)
        {
            if(!waggons.contains(waggon))
            {
                waggons.add(waggon);
                System.out.println("Waggon hinzugefügt");
            }
            else
                System.out.println("Waggon bereits enthalten");
        }
        System.out.println("Null-Ref. übergeben");
    }

    public void waggonUebersicht()
    {
        String str = "";
        for(Waggon w : waggons)
        {
            if(waggons != null)
            {
                str += waggons.indexOf(w);
            }
            str += ". Waggon Gewicht = ";
            str += ", Klasse = ";
            str += ", Max.-Plaetze = ";
            str += ", Passagiere = ";
        }
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
