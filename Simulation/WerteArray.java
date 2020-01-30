import java.util.Random;
import java.lang.Math;
/*  
Vereinfachte Variante der Klasse "WerteArray" fuer Pruefung

Name:    
Klasse:   
Pruef-Nr.:  PRUEF____ 
 */
public class WerteArray
{
    private int[] array;
    private int next;
    // ------------------------------------ Konstruktoren ----------------------------------
    public WerteArray()
    {
        array = new int[100];       
        //      testFuellung();
    }
    // ------------------------------------ Ihre Implementierung ---------------------------

    public void quotLastFirst()
    {
        float last = array[array.length-1];
        float first = array[0];
        float erg = 0;

        if(last != 0 && first != 0)
            erg = last/first;
        else
            System.out.println("Mit 0 lässt es sich nicht richtig dividieren!");

        System.out.println(array[array.length-1]+" : "+array[0]+" = "+erg);
    }

    public void anzLinksGroesserRechts()
    {
        int sum = 0;
        if(array.length > 1)
        {
            for(int i = 0; i < array.length-1; i++)
            {
                if(array[i] > array[i+1])
                    sum++;
            }
            System.out.println("Anzahl der größeren Elemente = "+sum);
        }
        else
            System.out.println("Nicht genug Elemente im Array für diese Aktion!!");
    }

    public void maxWertNachVorne()
    {
        print();
        System.out.println();
        int maxPos = 0;
        int max = array[0];
        //int help = array[0];
        if(array.length>1)
        {
            for(int i = 0; i < array.length-1; i++)
            {
                if(max < array[i])
                {
                    max = array[i];
                    maxPos = i;
                }
            }
            array[maxPos] = array[0];
            array[0] = max;
        }
        else
            System.out.println("Nicht genug Elemente im Array für diese Aktion!!");
        print();

    }

    public void minAbstand()
    {
        print();

        if(array.length > 1)
        {
            int dif = Math.abs(array[0]-array[1]);
            int pos = 0;
            for(int i = 0; i < array.length-1; i++)
            {
                if(Math.abs(array[i+1]-array[i]) < dif)
                {
                    dif = Math.abs(array[i+1]-array[i]);
                    pos = i;
                }  
            }

            System.out.println("Die kleinste Differenz besteht zwischen Element " + pos + " und "+(pos+1)+" und beträgt: "+dif);
        }
    }

    
    public void rechtsShift ()
    {
        print();
        int last = array[array.length-1];
        int help = 0;
        
        for(int i = array.length-1; i > 0; i--)
        {
            help = array[i-1];
            array[i] = array[i-1];
            
        }
        array[0] = last;
        
        
        System.out.println();
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
        array = new int[15];                 // Zum Testen ev. auch new int[10]
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