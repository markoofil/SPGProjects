public class Sortieren
{
    private int[] werte = { 5, 9, 4, 6, 7, 8, 1, 4};

    public Sortieren()
    {

    }

    public boolean test() {
        boolean sorted = true;
        for (int i=0; i<werte.length-1; i++) {
            if (werte[i] > werte[i+1]) {
                System.out.println("Fehler, Werte an Stelle " + i + " und "+ (i+1) + " nicht aufsteigend sortiert");
                sorted = false;      
            }   
        }
        return sorted;
    }

    public void print() {
        for (int a : werte) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void sort()
    {
        boolean swapped = true;
        int i = 0;
        while (swapped) {
            swapped = false;
            for (int j=0; j<werte.length - i -1; j++) {
                if (werte[j] > werte[j+1]) {
                    swap(j, j+1);
                    swapped = true;
                }
                print();
            }
            i++;
        }
    }

    public void swap(int i, int j) {
        if (i < werte.length && j < werte.length) {
            int tmp = werte[i];
            werte[i] = werte[j];
            werte[j] = tmp;
        } else {
            System.err.println("Fehler...");
        }
    }

    public void rechtsShift()
    {
        print();
        int temp = werte[werte.length-1];
        for(int i = werte.length-1; i > 0; i--)
        {
            werte[i] = werte[i-1];
        }
        werte[0] = temp;
        System.out.println();
        print();
    }
}