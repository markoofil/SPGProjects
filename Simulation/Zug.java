import java.util.*;
public class Zug
{

    private char typ;
    private Lokomotive lok;
    private int maxWaggonAnz;
    private Vector<Waggon> waggons = new Vector<Waggon>();

    // ------------------------------ constructor --------------------------
    public Zug(String zugId, char typ)
    {
        zugId = zugId;
        setTyp(typ);
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
                System.out.println("Waggon erfolgreich hinzugefügt!");
                return true;
            }
            else
                System.out.println("Waggon bereits vorhanden");
        }
        return false;
    }

    public String waggonUebersicht()
    {
        String str = "";
        if(waggons.size()>0)
        {
            for(Waggon w : waggons)
            {
                str += waggons.indexOf(w)+1;
                str += ". Waggon: Gewicht="+w.getGewicht();
                str += ", Klasse="+w.getKlasse();
                str += ", Max.-Plaetze="+w.getPlaetzeMax();
                str += ", Passagiere="+w.getPassagiere();
                str += "\n";
            }
        }
        else
            str += "Keine Waggons vorhanden";
        System.out.println(str);
        return str;
    }

    public float berechneGewicht()
    {
        float sum = 0;
        for(Waggon w : waggons)
        {
            sum += w.berechneGewicht();
        }
        System.out.println("Gesamtgewicht aller Waggons: "+sum);
        return sum;
    }

    public float berechneDurchschnittsGewicht()
    {
        float avg = 0;
        if(waggons.size()>0)
        {
            avg = berechneGewicht()/(waggons.size());
            System.out.println("Durchschnittsgewicht aller Waggons: "+avg);
        }
        return avg;
    }

    public int berechneAnzPlaetzeFrei(int klasse)
    {
        int sum = 0;

        for(Waggon w : waggons)
        {
            if(klasse == w.getKlasse())
                sum += w.berechneFrei();
        }
        return sum;
    }

    public boolean removeWaggon(int pos)
    {
        if(waggons.size()>0)
        {
            if(pos >= 0 && pos < waggons.size())
            {
                waggons.remove(pos);
                System.out.println("Entfernen des Waggons hat geklappt!");
                return true;
            }
        }
        System.out.println("Entfernen des Waggons hat nicht geklappt, da kein Waggon an der Position verfügbar ist!");
        return false;
    }
    /**
    public int removeWaggonsLeer() // Bissi geschummelt, aber geübt! -- klappt dennoch nicht
    {
        int sum=0;
       
        while( Iterator<Waggon>() waggons.iterator().hasNext())
        {
            if(waggons.iterator().next().getPassagiere() == 0)
            {
                waggons.iterator().remove();
                sum++;
            }
        }
        System.out.println(sum+" leere Waggons wurden entfernt!");
        return sum;
    }
    */
    
      public int removeWaggonsLeer() // Bissi geschummelt, aber geübt! -- klappt dennoch nicht
    {
        int sum=0;
        Iterator<Waggon> iter = waggons.iterator();
        while(iter.hasNext())
        {
            if(iter.next().getPassagiere() == 0)
            {
                iter.remove();
                sum++;
            }
        }
        System.out.println(sum+" leere Waggons wurden entfernt!");
        return sum;
    }
     

    public boolean insertWaggon(Waggon waggon, int pos)
    {
        if(waggons.size()>0)
        {
            if(pos >= 0 && pos < waggons.size())
            {
                waggons.add(pos, waggon);
                System.out.println("Hinzufügen des Waggons hat geklappt!");
                return true;
            }
        }
        return false;
    }
}
