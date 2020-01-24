
/**
 * Write a description of class Galerie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Galerie
{

    private String name;
    private ArrayList<Bild> bilder;

    public Galerie(String name)
    {
        setName(name);
        bilder = new ArrayList<Bild>();
    }

    public void setName(String name)
    {
        if(name != null)
        {
            this.name = name;
        }
        else
            System.out.println("Kein Name vergeben");
    }

    public void addBild(Bild bild)
    {
        if(bilder.size() < 100)
        {
            if(bild.getPreis() >= 100)
            {
                if(bild != null)
                {
                    if(!bilder.contains(bild))
                    {
                        bilder.add(bild);
                    }
                    else
                        System.out.println("Das Bild ist bereits enthalten");
                }
                else
                    System.out.println("Kein Bild zum Hinzufügen");
            }
            else
                System.out.println("Bildwert zu gering!");
        }
        else
            System.out.println("Limit erreicht (100)");
    }

    public String toString()
    {
        String str = "Galerie \""+ name+"\"\n----------------------------";
        for(Bild anz : bilder)
        {
            str += "\nBild "+(bilder.indexOf(anz)+1)+": ";

            str += anz.toString();
        }
        str += "\n----------------------------------------\n";
        str += "Gesamtanzahl: "+berechneAnzBilder("alle") + " Bilder; Gesamtwert: "
        +berechneGesamtwert("alle") + ",-";

        return str;
    }

    public int berechneAnzVerkauft()
    {
        int sum = 0;
        for(Bild pic : bilder)
        {
            if(pic.isVerkauft() == true )
            {
                sum++;
            }
        }
        return sum;
    }

    public double berechneGesamtwert(String kuenstler)
    {
        double sum = 0;

        for(Bild b : bilder)
        {
            if(b.getKuenstler() != null)
            {
                if(b.getKuenstler() == kuenstler || kuenstler == "alle")
                {
                    sum += b.getPreis();
                }
            }
            else
                System.out.println("Null-Ref übergeben");
        }
        return sum;
    }

    public int berechneAnzBilder(String kuenstler)
    {
        int sum = 0;
        for(Bild banz : bilder)
        {
            if(kuenstler != null)
            {
                if(banz.getKuenstler() == kuenstler || kuenstler == "alle")
                {
                    sum ++;
                }
            }
            else
                System.out.println("Null-Ref. übergeben");
        }
        return sum;
    }

    public void printBilder(String kuenstler)
    { 
        String ausgabe = "";
        for(Bild bild : bilder)
        {
            if(bild.getKuenstler() == kuenstler)
            {
                ausgabe += "\n" + bild.getTitel()+" Position: "+(bilder.indexOf(bild)+1);  
            }
        }
        System.out.print(kuenstler+ausgabe+"\n" + "Bilder: "+berechneAnzBilder(kuenstler)+"; Gesamtwert: "+ berechneGesamtwert(kuenstler));
        
        
    }

    public void print()
    {
        System.out.print(toString());
    }
    /**
    public void removeBild(int pos)
    {

    }
    public void removeBilder(String kuenstler)
    {

    }
    public void insertBild(Bild bild, int pos)
    {

    }
     **/
}
