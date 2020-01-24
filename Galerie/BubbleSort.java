
/**
 * Write a description of class BubbleSort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BubbleSort
{
    public int[] array = {5,2,3,4,1};

    public void sortMaxMin()
    {
        int temp = 0;
        for(int d = 0; d < array.length; d++)
        {
            for(int i = 0; i < array.length; i++)
            {
                if( i+1 != array.length && array[i] < array[i+1])
                {
                    temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public void print()
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
