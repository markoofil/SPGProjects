import java.util.Random;
import java.lang.Math;
/*  
Vereinfachte Variante der Klasse "WerteArray" fuer Pruefung

Name:    Marko Filipovic
Klasse:   5BBIF
Pruef-Zeit:  36min 
 */
public class WerteArrayTestlauf
{
    private int[] array;
    private int next;
    // ------------------------------------ Konstruktoren ----------------------------------
    public WerteArrayTestlauf()
    {
        array = new int[100];       
        //      testFuellung();
    }
    // ------------------------------------ Ihre Implementierung ---------------------------

    public void quotLastFirst()
    {
        double last = array[array.length-1];
        double first = array[0];
        double erg = 0;

        if(last != 0 && first != 0)
        {
            erg = last/first;
            System.out.println(last+" : "+first+" = "+erg);
        }
        else
            System.out.println("Es kann nicht durch 0 geteilt werden");

    }

    public void anzLinksGroesserRechts()
    {
        testFuellung();
        int sum = 0;
        for(int i = 0; i<array.length; i++)
        {
            if(i+1 != array.length)
            {
                if(array[i]>array[i+1])
                    sum++;
            }
        }
        print();
        System.out.println(sum);
    }

    public void maxWertNachVorne()
    {

        int max = array[0];
        int pos = 0;
        int temp = 0;
        for(int i =0; i<array.length;i++)
        {
            if(i+1 != array.length && array[i] > max)
            {
                max = array[i];
                pos = i;
            }
        }
        temp = array[0];
        array[0] = array[pos];
        array[pos] = temp;
        print();

    }

    public void minAbstand()
    {
        testFuellung();
        print();
        int dif = Math.abs(array[1]-array[0]);
        int pos = 0;
        for(int i=0;i<array.length;i++)
        {
            if(i+1 != array.length)
            {
                if(Math.abs(array[i+1]-array[i]) < dif)
                {
                    dif = Math.abs(array[i+1]-array[i]);
                    pos = i;
                }
            }
        }
        System.out.println("Die kleinste Differenz besteht zw. Element "+pos+" und "+(pos+1)+" und beträgt "+dif);
    }
    
    public void rechtsShift ()
    {
        
        print();
        int temp = array[array.length-1];
        for(int i = array.length-1; i > 0; i--)
        {
            array[i] = array[i-1];
        }
        array[0] = temp;
        print();
        
    }
    // ------------------------------------ Methoden fuer's Testen -------------------------
    public void print()
    {
        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+"   ");
        System.out.println("\n");
    }

    public void testFuellung()               // Diese Methode darf zum Testen natürlich beliebig geändert werden!!
    {
        Random rand = new Random();
        array = new int[10];                 // Zum Testen ev. auch new int[10]
        for (int i=0; i<array.length; i++)
            array[i] = rand.nextInt(41)-20;  // befüllt die ersten 10 Elemente mit Zufalls(!!)-Werten zwischen -20 u. +20
        next = 10;

        // ...oder...       
        //        array = new int[]{ ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0 };
        //        next =  ? ; 
    }

    public void testFuellung(int[] arrayNeu)   // wurde für den Aufruf aus einer externen Test-Klasse implementiert!!
    {
        array = arrayNeu;
        next = 10;
    }
}