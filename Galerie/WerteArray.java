import java.util.Random;
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
        double erg = 0;
        double last = 0;
        for(int i = 0; i < array.length; i++)
        {
            last = array[i];
        }
        if(last != 0 && array[0] != 0)
            erg = (last/array[0]);
        System.out.println(last+" : "+array[0]+" = "+erg);
    }

    public void anzLinksGroesserRechts()
    {
        int sum = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(i+1 != array.length && array[i] > array[i+1])
            {
                sum++;
            }
        }
        System.out.print(sum);
    }

    public void maxWertNachVorne()
    {
        int pos = 0;
        int max = 0;
        for(int i = 0; i < array.length; i++)
        {
            if(max < array[i])
            {
                max = array[i];
                pos = i;
            }

        }
        array[pos] = array[0];
        array[0] = max;
        for (int i=0; i<10; i++)
            System.out.print(array[i]+"   ");
        System.out.println("\n");
    }

    public void minAbstand()
    {
        int difMin = 0;
        int difPos = 0;
        int[] dif = new int[array.length-1];
        for(int i = 0; i < array.length; i++)
        {
            if(i+1 != array.length)
            {
                if(array[i] > array[i+1])
                    dif[i] = array[i] - array[i+1];
                else
                    dif[i] = array[i+1] - array[i]; 
            }
        }

        for(int i = 0; i < dif.length; i++)
        {
            if(i+1 != dif.length)
            {
                if(dif[i] > dif[i+1])
                {
                    difMin = dif[i+1];
                    difPos = (i+1)+1;
                }
                else
                {
                    difMin = dif[i];
                    difPos = i+1;
                }
            }

        }
        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+"   ");
        System.out.println("\n");
        System.out.println("Kleinste Differenz ist: "+difMin+" zwischen: "+"Element :"+(difPos-1)+" & "+(difPos+1));

    }

    public void rechtsShift()
    {
        int[] temp = new int[array.length];
        System.out.println("Alt: \n");
          for (int i=0; i<array.length; i++)
            System.out.print(array[i]+"   ");

        System.out.println("\nNeu: \n");

        
        for(int i=0;i<array.length;i++)
            temp[i] = array[i];

        for(int i=0;i<array.length;i++)
        {
            if(i+1 != array.length)
            array[i+1] = temp[i];
            else
            array[0] = temp[i];
        }

        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+"   ");

      

    }

    
    // ------------------------------------ Methoden fuer's Testen -------------------------
    public void print()
    {
        for (int i=0; i<next; i++)
            System.out.print(array[i]+"   ");
        System.out.println("\n");
    }

    public void testFuellung()               // Diese Methode darf zum Testen natürlich beliebig geändert werden!!
    {
        Random rand = new Random();
        array = new int[10];                 // Zum Testen ev. auch new int[10]
        for (int i=0; i<10; i++)
            array[i] = rand.nextInt(41)-20;  // befüllt die ersten 10 Elemente mit Zufalls(!!)-Werten zwischen -20 u. +20
        next = 10;

        // ...oder...       
        //        array = new int[]{ ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0 };
        //        next =  ? ; 
    }
    /**  
    public void testFuellung(int[] arrayNeu)   // wurde für den Aufruf aus einer externen Test-Klasse implementiert!!
    {
    array = arrayNeu;
    next = 10;
    }
     **/
}