package test;

import java.time.Year;

import model.MitarbeiterException;
import model.Vertreter;

public class TestVertreter
{

	public static void main(String[] args)
	{
		Vertreter v1;
		try
		{
			v1 = new Vertreter("Marko", Year.of(1955), Year.of(1970), 'M', 1400, 160000);
			System.out.println(v1.toString());
		}
		catch (MitarbeiterException e)
		{
			System.out.println(e.getMessage());
		}
//		Vertreter v1 = new Vertreter("Marko", Year.of(1955), Year.of(1970), 'M', -5, 0);
//		Vertreter v1 = new Vertreter("Marko", Year.of(1955), Year.of(1970), 'M', 0, -5);
		
		
	}

}
