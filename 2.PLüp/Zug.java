
import java.util.*;

public class Zug
{

    private char typ;
    private Lokomotive lok;
    private int maxWaggonAnz;
    private Vector<Waggon> waggons;

    // ------------------------------ constructor --------------------------
    public Zug(String zugId, char typ, Lokomotive lok)
    {
        String id = zugId;
        setTyp(typ);
        this.lok = lok;
        waggons = new Vector<Waggon>();
        setMaxWaggonAnz();
    }

    public Zug(Lokomotive lok)
    {
        String id = "Wienerwalzer";
        this.typ = 'P';
        this.lok = lok;
        waggons = new Vector<Waggon>();
        setMaxWaggonAnz();
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

    public boolean addWaggon(Waggon waggon)
    {
        if(waggon != null)
        {
            if(!waggons.contains(waggon))
            {
                waggons.add(waggon);
                System.out.println("addWaggon funktioniert");
                return true;            
            }
            else
                return false;
        }
        else
            return false;
    }

    public String waggonUebersicht()
    {
        String str = "";
        for(Waggon w : waggons)
        {
            str += waggons.indexOf(w)+1;
            str += ". Waggon: Gewicht = "+w.berechneGewicht()+","+" Klasse = "+w.getKlasse()+", ";
            str += "Max.-Plaetze = "+w.getPlaetzeMax()+", Passagiere = "+ w.getPassagiere()+"\n";
        }
        System.out.print(str);
        return str;
    }

    public float berechneGewicht()
    {
        float sum = 0;

        for(Waggon w : waggons)
        {
            if(w != null)
                sum += w.berechneGewicht();
        }
        return sum;
    }

    public float berechneDurchschnittsGewicht()
    {
        float avg = 0;
        for(Waggon w : waggons)
        {
            if(w != null)
            {
                avg = berechneGewicht()/ waggons.size(); 
            }
        }
        return avg;
    }

    public int berechnePlaetzeFrei(int klasse)
    {
        int sum = 0;
        for(Waggon w : waggons)
        {
            if(w.getKlasse() == klasse)
            {
                sum += w.berechneFrei();
            }
        }
        return sum;
    }

    /**
     * Funktioniert, obwohl eine java.util.ConcurrentModificationException
     * geworfen wird ?!
     **/
    public boolean removeWaggon(int pos)
    {
        Iterator<Waggon> iter = waggons.iterator();
        while(iter.hasNext())
        {
            if(waggons.size() > 0 && pos >= 1)
            {
                waggons.remove(pos);
                return true;
            }
        }
        return false;
    }

    public int removeWaggonsLeer()
    {
        int sum = 0;

        if(waggons.size()>0)
        {
            Iterator<Waggon> iter = waggons.iterator();
            while(iter.hasNext())
            {
                //Waggon temp = iter.next();
                if(iter.next().getPassagiere() == 0)
                {
                    iter.remove();
                    sum++;
                }
            }

            System.out.print("Anzahl der entfernten Züge: "+sum);
        }
        return sum;
    }

    public boolean insertWaggon(Waggon waggon, int pos)
    {
        if(waggon != null)
        {
            if(waggons.size() > pos)
            {
                if(pos >= 0 && !waggons.contains(waggon))
                {
                    waggons.add(pos, waggon);
                }
            }
            else
                System.out.println("List.size() "+waggons.size()+"ist kleiner als pos "+pos);
        }
        return false;
    }
}
